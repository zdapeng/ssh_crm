package com.dapeng.service.impl;

import com.dapeng.dao.BaseDictDao;
import com.dapeng.domain.Base_Dict;
import com.dapeng.service.BaseDictService;

import java.util.List;

public class BaseDictServiceImpl implements BaseDictService {

    private BaseDictDao baseDictDao;
    @Override
    public List<Base_Dict> getListByTypeCode(String dict_type_code) {
        return baseDictDao.getListByTypeCode(dict_type_code);
    }

    public BaseDictDao getBaseDictDao() {
        return baseDictDao;
    }

    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }
}
