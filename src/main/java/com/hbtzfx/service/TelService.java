package com.hbtzfx.service;

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

    public int saveTel(TelDO tel) {
       return telDao.saveTel(tel);
    }
}
