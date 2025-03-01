package com.cc.server.service.log.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.server.entity.log.LogLogin;
import com.cc.server.mapper.log.LogLoginMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cc.server.service.log.LogLoginService;

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
public class LogLoginServiceImpl extends ServiceImpl<LogLoginMapper, LogLogin> implements LogLoginService {
  @Autowired
  private LogLoginMapper logLoginMapper;

 /**
 *  查询表log_login所有信息
 */
 @Override
 public List<LogLogin> selectAllLogLogin() { return logLoginMapper.selectAllLogLogin();}

   /**
   *  根据主键id查询表log_login信息
   *  @param id
   */
   @Override
   public LogLogin selectLogLoginById(@Param("id") Long id) { return logLoginMapper.selectLogLoginById(id);}

 /**
 *  根据条件查询表log_login信息
 *  @param logLogin
 */
 @Override
 public List<LogLogin> selectLogLoginByCondition(LogLogin logLogin) { return logLoginMapper.selectLogLoginByCondition(logLogin);}

   /**
   *  根据主键id查询表log_login信息
   *  @param id
   */
   @Override
   public Integer deleteLogLoginById(@Param("id") Long id) { return logLoginMapper.deleteLogLoginById(id);}

   /**
   *  根据主键id更新表log_login信息
   *  @param logLogin
   */
   @Override
   public Integer updateLogLoginById(LogLogin logLogin) { return logLoginMapper.updateLogLoginById(logLogin);}

   /**
   *  新增表log_login信息
   *  @param logLogin
   */
   @Override
   public Integer insertLogLogin(LogLogin logLogin) { return logLoginMapper.insertLogLogin(logLogin);}
}
