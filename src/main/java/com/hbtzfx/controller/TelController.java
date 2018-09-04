package com.hbtzfx.controller;

import com.hbtzfx.common.model.CommonResponse;
import com.hbtzfx.common.util.ResultUtil;
import com.hbtzfx.common.util.ValidateCode;
import com.hbtzfx.entity.TelDO;
import com.hbtzfx.service.TelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
@RequestMapping("tel")
@Controller
public class TelController {
    @Autowired private TelService telService;

    @GetMapping("getTelList")
    public String findTel(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                          @RequestParam(value = "pageSize", defaultValue = "5") int pageSize, Model model) throws Exception {
        model.addAttribute("telList", telService.getTelList(currentPage, pageSize).getList());
        return "telMain";
    }

    @GetMapping("saveTel")
    public Map<String, String> saveTel(@RequestParam String userName,
                                       @RequestParam String tellnumber,
                                       @RequestParam String desction,
                                       @RequestParam String searchType
                                       ) {
        TelDO tel = new TelDO(tellnumber, userName, desction, searchType);
        int i = telService.saveTel(tel);
        Map<String,String> msg = new HashMap<>();
        if (i > 0) {
            msg.put("code", "200");
            msg.put("msg", "添加成功");
        } else {
            msg.put("code", "500");
            msg.put("msg", "添加失败");
        }
        return msg;
    }

    /**
     * 响应验证码页面
     * @return
     */
    @GetMapping(value="/validateCode")
    public String validateCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();

        ValidateCode vCode = new ValidateCode(120,40,4,10);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
        return null;
    }

    @GetMapping(value="/validateCodes")
    public Map validateCode(HttpServletRequest request) throws Exception {
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String sessionCode = (String) session.getAttribute("code");

        Map<String, String> result = new HashMap<>();
        if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {  //忽略验证码大小写
            result.put("code", "500");
            result.put("msg", "验证码对应不上code=" + code + "  sessionCode=" + sessionCode);
        } else {
            request.getSession().invalidate(); // 清空session
            result.put("code", "200");
            result.put("msg", "验证成功");
        }
        return result;
    }
}
