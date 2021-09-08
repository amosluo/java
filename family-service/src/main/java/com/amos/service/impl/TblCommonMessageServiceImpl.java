package com.amos.service.impl;

import com.amos.bean.TblCommonMessage;
import com.amos.mapper.TblCommonMessageMapper;
import com.amos.service.ITblCommonMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 常用短信 服务实现类
 * </p>
 *
 * @author amos
 * @since 2021-08-06
 */
@Service
public class TblCommonMessageServiceImpl extends ServiceImpl<TblCommonMessageMapper, TblCommonMessage> implements ITblCommonMessageService {

}
