package com.example.demo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.config.RedisUtil;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangxl
 * @ClassName UserService
 * @Description TODO
 * @date 2019/9/20 15:46
 */
@Service
public class UserService {

  @Resource
  private UserMapper userMapper;


  @Autowired
  private RedisUtil redisUtil;

  /**
   * 获取所有用户信息
   * @return
   */
  public Object getUserList(){
    //从先缓存中获取--如果没的话 在去数据库中进行查询
    List<Object> userList = redisUtil.lGet("userList",0,-1);
    if(userList.size()>0){
      return userList;
    }else{
      List<User> list = userMapper.selectList(new EntityWrapper<User>());
      redisUtil.lSet("userList",list);
      return list;
    }
  }

  /**
   * 根据id删除用户信息
   * @param id
   * @return
   */
  public int delUser(int id){
    redisUtil.del("userList");
    return userMapper.deleteById(id);
  }

  /**
   * 添加用户信息
   * @param user
   * @return
   */
  public int insertUser(User user){
    redisUtil.del("userList");
    return userMapper.insert(user);
  }

}
