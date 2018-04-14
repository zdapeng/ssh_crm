package com.dapeng.service;

import com.dapeng.domain.Base_Dict;

import java.util.List;

public interface BaseDictService{
    List<Base_Dict> getListByTypeCode(String dict_type_code);
}
