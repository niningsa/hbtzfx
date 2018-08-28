package com.hbtzfx.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hbtzfx.common.model.PageInfo;
import com.hbtzfx.dao.TelDao;
import com.hbtzfx.entity.TelDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelService {
    @Autowired
    private TelDao telDao;

    public List<TelDO> findTel() {
        return telDao.findTel();
    }

    /**
     * 保存咨询数据
     * @param tel
     * @return
     */
    public int saveTel(TelDO tel) {
       return telDao.saveTel(tel);
    }

    /**
     * 分页展示
     * @param currentPage 当前页码
     * @param pageSize 每页条数
     * @return
     */
    public PageInfo<TelDO> getTelList(int currentPage, int pageSize) {
        //设置分页信息保存到threadlocal中
        Page<TelDO> page = PageHelper.startPage(currentPage, pageSize);//一定要放在查询之前
        //紧跟着的第一个select方法会被分页，contryMapper会被PageInterceptor截拦,截拦器会从threadlocal中取出分页信息，把分页信息加到sql语句中，实现了分页查旬
        PageInfo pageInfo = new PageInfo(telDao.findTel());
        pageInfo.setPageNum(page.getPageNum());
        pageInfo.setPageSize(page.getPageSize());
        pageInfo.setPages(page.getPages());
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }
}
