package cn.edu.tju.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.edu.tju.pojo.User;
import cn.edu.tju.service.UserService;

public class UserRealm extends AuthorizingRealm 
{
	@Resource
	private UserService userServiceimpl  ; 
	@Override
	public String getName() {
		return "UserRealm";
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) 
	{
		Set<String> roles = new HashSet<>() ;
		roles.add("user")  ; 
		System.out.println("UserRealm.doGetAuthorizationInfo()");
		return new SimpleAuthorizationInfo(roles);
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException 
	{
		UsernamePasswordToken upToken = (UsernamePasswordToken)token  ; 
		String userName = (String) upToken.getPrincipal() ;
		User user = userServiceimpl.userLogin(userName) ;
		System.out.println("UserRealm.doGetAuthenticationInfo()");
		return new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes(userName),getName());
	}
//	public static void main(String[] args) 
//	{
//		System.out.println(new SimpleHash("MD5","admin",ByteSource.Util.bytes("admin"),100));
//	}
}
