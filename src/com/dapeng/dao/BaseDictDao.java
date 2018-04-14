package com.dapeng.dao;

import com.dapeng.domain.Base_Dict;

import java.util.List;

public interface BaseDictDao extends BaseDao<Base_Dict> {
    List<Base_Dict> getListByTypeCode(String dict_type_code);
}
