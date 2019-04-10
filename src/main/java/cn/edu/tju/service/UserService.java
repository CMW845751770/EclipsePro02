package cn.edu.tju.service;

import cn.edu.tju.pojo.User;

public interface UserService 
{
	/**
	 * �����û���½��ѯ�û��ķ���
	 * @param userName
	 * @return
	 */
	User userLogin(String userName) ; 
	
	/**
	 * �����û�ע���ж��û����Ƿ��ѱ�ռ��
	 * @param userName
	 * @return
	 */
	User userRegCheckName(String userName) ; 
	
	/**
	 *�����û� ע�Ṧ��
	 * @param userName
	 * @param password
	 * @return
	 */
	int userRegister(String userName , String password) ;
}
