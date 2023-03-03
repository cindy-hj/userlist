package com.example.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.IUserDAO;
import com.example.vo.UserEntity;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserDAO userDAO;
	
	@RequestMapping("/user")
	public @ResponseBody Map<String, Object> news() throws Exception {
		Map<String, Object> rtnObj = new HashMap<>();
		
		List<UserEntity> userList = userDAO.listUser();
		logger.info("user->" + userList.toString());
		
		rtnObj.put("user_list", userList);
		return rtnObj;
	}
	
	@RequestMapping("/insertuser")
	public @ResponseBody String insertuser(HttpServletRequest request) throws Exception {
		UserEntity user = new UserEntity(); // 추가할 사용자 생성
		user.setUserID(request.getParameter("id"));
		user.setUserPassword(request.getParameter("pwd"));
		user.setUserName(request.getParameter("name"));
		
		userDAO.insertUser(user); // 사용자 추가
		return "ok";
	}
	
	@RequestMapping("/updateuser")
	public @ResponseBody String updateuser(HttpServletRequest request) throws Exception {
		UserEntity user = new UserEntity();
		user.setUserID(request.getParameter("id"));
		user.setUserPassword(request.getParameter("pwd"));
		
		userDAO.updateUser(user);
		return "ok";
	}
	
	@RequestMapping("/deleteuser")
	public @ResponseBody String deleteuser(HttpServletRequest request) throws Exception {
		UserEntity user = new UserEntity();
		user.setUserID(request.getParameter("id"));
		
		userDAO.deleteUser(user);
		return "delete ok";  
	}
}




