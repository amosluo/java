package com.amos.service.impl;

import com.amos.bean.TblTodo;
import com.amos.mapper.TblTodoMapper;
import com.amos.service.ITblTodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 待办事项 服务实现类
 * </p>
 *
 * @author amos
 * @since 2021-08-06
 */
@Service
public class TblTodoServiceImpl extends ServiceImpl<TblTodoMapper, TblTodo> implements ITblTodoService {

}
