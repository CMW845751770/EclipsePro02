package cn.edu.tju.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import cn.edu.tju.realm.UserRealm;

@Configuration
public class ShiroConfig{
	

	 @Bean
	 public ShiroDialect shiroDialect() {
	     return new ShiroDialect();
	 }
	@Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        autoProxyCreator.setProxyTargetClass(true);
        return autoProxyCreator;
    }
    @Bean("hashedCredentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		// ָ�����ܷ�ʽΪMD5
		credentialsMatcher.setHashAlgorithmName("MD5");
		// ���ܴ���
		credentialsMatcher.setHashIterations(100);
		credentialsMatcher.setStoredCredentialsHexEncoded(true);
		return credentialsMatcher;
	}
    
    //���Լ�����֤��ʽ��������
    @Bean
    public UserRealm userRealm() 
    {
    	UserRealm userRealm = new UserRealm() ; 
    	userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    //Ȩ�޹���������Ҫ��Realm�Ĺ�����֤
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }
    //Filter���������ö�Ӧ�Ĺ�����������ת����
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<String, String>();
        //�ǳ�
        map.put("/main.html","anon");
        map.put("/main","anon");
        map.put("/user/logout","logout");
        map.put("/user/login","anon");
        map.put("/user/reg","anon");
        map.put("/user/reg/checkname","anon");
        map.put("/login.html","anon");
        map.put("/img/**","anon");
        map.put("/res/**","anon");
        map.put("/css/**","anon");
        map.put("/js/**","anon");
        //�������û���֤
        map.put("/**","authc");
        //��¼
        shiroFilterFactoryBean.setLoginUrl("/blog/show");
        //����ҳ�棬��֤��ͨ����ת
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //����ע���ʹ�ã����������ע�ⲻ��Ч
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}