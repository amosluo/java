package com.amos.dao;

import com.amos.bean.Pay;

import java.util.List;

public interface PayDao {
    //通过id查询pay
    public Pay find(Integer id);
    //通过金额和创建人查询
    public List<Pay> findByAmountAndCreatedBy(Double payAmount, String createdBy);
    //通过实体查询
    public List<Pay> findByPay(Pay pay);
    //添加pay
    public Integer add(Pay emp);
}
