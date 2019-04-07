package priv.zh;


import junit.framework.Assert;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;


/**
 * @author zhaoheng
 * @version 1.0
 * shiro test class
 */
public class ShiroTest{
   
    @Test
    public void testHelloWorld(){
        // get SecurityManager factory,use .ini init it
        Factory<SecurityManager> factory= new  IniSecurityManagerFactory("classpath:shiro.ini");
        //get SecurityManager instance
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //get Subject 
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("zhang","123");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("message", subject.hasAllRoles(Arrays.asList(new String[]{"123"})));
        Assert.assertTrue("message", subject.isAuthenticated());
        subject.logout();
    }
}