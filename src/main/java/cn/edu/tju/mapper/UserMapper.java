package cn.edu.tju.mapper;

import org.apache.ibatis.annotations.Param;

import cn.edu.tju.pojo.User;

/**
 * User�����ݷ��ʲ����
 * @author 845751770
 *
 */
public interface UserMapper 
{
	User selUserByUserName(String userName) ; 
	
	int insUserByUserNameAndPasswod(@Param("userName")String userName ,@Param("password")String password) ; 
}
