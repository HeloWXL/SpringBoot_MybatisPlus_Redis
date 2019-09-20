package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangxl
 * @ClassName UserController
 * @Description TODO
 * @date 2019/9/20 15:46
 */
@Api("用户接口")
@RequestMapping("/")
@Controller
public class UserController {

  @Resource
  private UserService userService;


  /**
   * 获取所有用户信息
   * @return
   */
  @ApiOperation("获取")
  @GetMapping("/getall")
  @ResponseBody
  public Object getUserList(){
    return userService.getUserList();
  }


  /**
   * 根据id删除用户信息
   * @param id
   * @return
   */
  @ApiOperation("删除")
  @GetMapping("/del")
  @ResponseBody
  public int delUser(@RequestParam("id") int id){
    return userService.delUser(id);
  }

  /**
   * 添加用户信息
   * @param user
   * @return
   */
  @ApiOperation("添加")
  @PostMapping("/insert")
  @ResponseBody
  public int insertUser(@RequestBody User user){
    return userService.insertUser(user);
  }
}
