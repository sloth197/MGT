package com.smgt.product.MyBatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyFactory {
   public static SqlSession session;

    static{
       try{
        Reader reader = 
            Resources.getResourceAsReader("com/smgt/product/mybatis/config.xml"); //config의 저장 위치를 가져옴
        SqlSessionFactory factory = 
            new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession();            
       }catch(Exception ex){
        ex.printStackTrace();
       } 
    }
    public static SqlSession getSession(){
        return session;
    }
}
