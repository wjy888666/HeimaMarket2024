package com.itheima.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author:wjy
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {
    @Override
    public void deductBalance(Long id, Integer money) {
        // 1. 查询用户
        User user = getById(id);
        // 2. 检验用户状态
        if(user == null || user.getStatus() == 2){
            throw new RuntimeException("用户状态异常！");
        }
        // 3. 校验余额
        if(user.getBalance() < money){
            throw new RuntimeException("用户余额不足！");
        }
        // 4. 扣减余额 update_tb_user set balance = balance - ?
        baseMapper.deductBalance(id,money);
    }
}
