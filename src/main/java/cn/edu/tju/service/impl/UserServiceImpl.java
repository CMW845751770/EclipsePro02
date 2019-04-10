package cn.edu.tju.service.impl;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.tju.mapper.UserMapper;
import cn.edu.tju.pojo.User;
import cn.edu.tju.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserMapper userMapper ; 
	@Override
	public User userLogin(String userName) 
	{
		return userMapper.selUserByUserName(userName);
	}
	
	@Override
	public User userRegCheckName(String userName) {
		return userMapper.selUserByUserName(userName);
	}

	@Override
	public int userRegister(String userName, String password) {
		password= new SimpleHash("MD5",password,ByteSource.Util.bytes(userName),100).toString() ; 
		return userMapper.insUserByUserNameAndPasswod(userName, password);
	}

}
