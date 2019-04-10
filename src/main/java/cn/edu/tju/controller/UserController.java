package cn.edu.tju.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.tju.pojo.User;
import cn.edu.tju.service.UserService;

@Controller
@RequestMapping("user")
public class UserController 
{
	@Resource
	private UserService userServiceImpl;
	
	@ResponseBody
	@RequestMapping("login")
	public Map<String,Object> userLogin(String userName,String password,HttpSession session) 
	{
		System.out.println(userName+"---->"+password);
		Map<String,Object> map = new HashMap<>() ; 
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated())
		{
			UsernamePasswordToken token = new UsernamePasswordToken(userName,password) ;
			try 
			{
				subject.login(token);
			}catch (AuthenticationException e) 
			{
				map.put("msg", "failed") ; 
				return map ; 
			}
		}
		System.out.println("UserController.userLogin()");
		subject.getSession().setAttribute("userName", userName);
		session.setAttribute("userName", userName);
		map.put("msg", "success") ;
		return map ; 
		
	}
	
	@ResponseBody
	@RequestMapping("reg/checkname")
	public Map<String, Object> checkName(String userName)
	{
		System.out.println("UserController.checkName()");
		Map<String,Object> map = new HashMap<>() ; 
		User user = userServiceImpl.userRegCheckName(userName) ;
		if(user!=null)
		{
			map.put("msg", "flaied") ; 
		}
		else
		{
			map.put("msg", "success") ; 	
		}
		return map ; 
	}
	
	@ResponseBody
	@RequestMapping("reg")
	public Map<String, Object> userRegister(String userName,String password)
	{
		System.out.println("UserController.userRegister()");
		Map<String,Object> map = new HashMap<>() ; 
		int index = userServiceImpl.userRegister(userName, password) ; 
		if(index>0)
		{
			map.put("msg", "success") ; 
		}
		else
		{
			map.put("msg", "failed") ; 	
		}
		return map ; 
	}
	
	@RequestMapping("logout")
	public String userLogout()
	{
		System.out.println("UserController.userLogout()");
		return "redirect:/main.html" ; 
	}
	
}
