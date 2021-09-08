package com.amos.service.impl;

import com.amos.bean.TblEmployeeContact;
import com.amos.mapper.TblEmployeeContactMapper;
import com.amos.service.ITblEmployeeContactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工通讯录 服务实现类
 * </p>
 *
 * @author amos
 * @since 2021-08-06
 */
@Service
public class TblEmployeeContactServiceImpl extends ServiceImpl<TblEmployeeContactMapper, TblEmployeeContact> implements ITblEmployeeContactService {

}
