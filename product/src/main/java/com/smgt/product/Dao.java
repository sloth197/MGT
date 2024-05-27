package com.smgt.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import com.smgt.product.MyBatis.MyFactory;

@Component
public class Dao {
    SqlSession session;

    public Dao() {
        session = MyFactory.getSession();
    }

    // List
    public List<ProductVo> list(String findStr) {
        session = MyFactory.getSession();
        List<ProductVo> list = session.selectList("product.product_list", findStr);
        session.close();
        return list;
    }

    // View
    public ProductVo view(String codeName) {
        session = MyFactory.getSession();
        ProductVo vo = session.selectOne("product.product_view", codeName);
        session.close();
        return vo;
    }

    // Register
    public String register(ProductVo vo) {
        session = MyFactory.getSession();
        int cnt = session.insert("product.product_register", vo);

        String msg = "";
        if (cnt > 0) {
            msg = "It's been entered normally.";
            session.commit();
        } else {
            msg = "Error entering";
            session.rollback();
        }
        session.close();
        return msg;
    }

    // Update
    public String update(ProductVo vo) {
        session = MyFactory.getSession();
        int cnt = session.update("product.product_update", vo);

        String msg = "";
        if (cnt > 0) {
            msg = "It has been updated normally.";
            session.commit();
        } else {
            msg = "Error updating";
            session.rollback();
        }
        session.close();
        return msg;
    }

    // Delete
    public String delete(String codeName) {
        session = MyFactory.getSession();
        int cnt = session.delete("product.product_delete", codeName);

        String msg = "";
        if (cnt > 0) {
            msg = "Deleted.";
            session.commit();
        } else {
            msg = "Error deleting";
            session.rollback();
        }
        session.close();
        return msg;
    }
    //Code

    //Register
    public boolean register(CodeVo vo){
      session = new MyFactory().getSession();
      boolean b = false;
      int cnt = session.insert("code.code_register", vo);
      if(cnt > 0){
          b=true;
          session.commit();
      }else{
          session.rollback();
      }
      session.close();
      return b;
  }
}