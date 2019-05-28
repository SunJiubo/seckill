package com.nsmall.seckill.service;

import com.nsmall.seckill.dao.UserDAO;
import com.nsmall.seckill.domain.User;
import com.nsmall.seckill.result.CodeMsg;
import com.nsmall.seckill.util.MD5Util;
import com.nsmall.seckill.vo.LoginVo;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author sky
 * @Date 19-5-28 下午5:00
 * @Version 1.0
 */

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public User getById(long id){
        return userDAO.getById(id);
    }

    public CodeMsg login(LoginVo loginVo){
        if(loginVo==null){
            return CodeMsg.SERVER_ERROR;
        }
        String mobile = loginVo.getMobile();
        String formword = loginVo.getPassword();

        User user = userDAO.getById(Long.parseLong(mobile));
        if(user==null){
            return CodeMsg.MOBILE_NOT_EXIST;
        }

        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDbPass(formword,saltDB);
        if(!calcPass.equals(dbPass)){
            return CodeMsg.PASSWORD_ERROR;
        }

        return CodeMsg.SUCCESS;
    }
}
