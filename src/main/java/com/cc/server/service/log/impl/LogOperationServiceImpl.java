package com.cc.server.service.log.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.server.entity.log.LogOperation;
import com.cc.server.mapper.log.LogOperationMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cc.server.service.log.LogOperationService;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2025-03-01 20:26:58
 */
@Service
public class LogOperationServiceImpl extends ServiceImpl<LogOperationMapper, LogOperation> implements LogOperationService {
  @Autowired
  private LogOperationMapper logOperationMapper;

 /**
 *  查询表log_operation所有信息
 */
 @Override
 public List<LogOperation> selectAllLogOperation() { return logOperationMapper.selectAllLogOperation();}

   /**
   *  根据主键id查询表log_operation信息
   *  @param id
   */
   @Override
   public LogOperation selectLogOperationById(@Param("id") Long id) { return logOperationMapper.selectLogOperationById(id);}

 /**
 *  根据条件查询表log_operation信息
 *  @param logOperation
 */
 @Override
 public List<LogOperation> selectLogOperationByCondition(LogOperation logOperation) { return logOperationMapper.selectLogOperationByCondition(logOperation);}

   /**
   *  根据主键id查询表log_operation信息
   *  @param id
   */
   @Override
   public Integer deleteLogOperationById(@Param("id") Long id) { return logOperationMapper.deleteLogOperationById(id);}

   /**
   *  根据主键id更新表log_operation信息
   *  @param logOperation
   */
   @Override
   public Integer updateLogOperationById(LogOperation logOperation) { return logOperationMapper.updateLogOperationById(logOperation);}

   /**
   *  新增表log_operation信息
   *  @param logOperation
   */
   @Override
   public Integer insertLogOperation(LogOperation logOperation) { return logOperationMapper.insertLogOperation(logOperation);}
}
