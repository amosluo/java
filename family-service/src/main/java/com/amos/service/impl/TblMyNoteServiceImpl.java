package com.amos.service.impl;

import com.amos.bean.TblMyNote;
import com.amos.mapper.TblMyNoteMapper;
import com.amos.service.ITblMyNoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 我的记事本 服务实现类
 * </p>
 *
 * @author amos
 * @since 2021-08-06
 */
@Service
public class TblMyNoteServiceImpl extends ServiceImpl<TblMyNoteMapper, TblMyNote> implements ITblMyNoteService {

}
