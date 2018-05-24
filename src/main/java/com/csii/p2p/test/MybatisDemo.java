package com.csii.p2p.test;


import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.InputStream;  
  
import org.apache.ibatis.session.SqlSession;  
import org.apache.ibatis.session.SqlSessionFactory;  
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.csii.p2p.entity.User;  
  
  
/*
 mybatis代码生成器测试类
 */  
public class MybatisDemo {  
  
    //获取到sqlSession  
    public static SqlSession getSqlSession() throws Exception{  
        InputStream configFile = new FileInputStream(  
                "F:\\eclipse_workspace\\csii_loan\\src\\test\\resources\\mybatisGenerator\\mybatis-config.xml");  
          
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);  
        
        //加载配置文件得到SqlSessionFactory  
        return sqlSessionFactory.openSession();  
    }  
      
    public static void main(String[] args) throws Exception {  
          
        SqlSession sqlSession = getSqlSession();  
       /*   
        UserMapper um = sqlSession.getMapper(UserMapper.class);  
          
        User user = um.selectByPrimaryKey(1);  
          
        System.out.println(  user.getEmail() );  
         */ 
    }  
      
}  