package com.itheima.mp.mapper;

<<<<<<< HEAD
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
=======
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
>>>>>>> 518e02e (MyBatisPlus)
import com.itheima.mp.domain.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testInsert() {
        User user = new User();
        user.setId(5L);
        user.setUsername("Lucy");
        user.setPassword("123");
        user.setPhone("18688990011");
        user.setBalance(200);
        user.setInfo("{\"age\": 24, \"intro\": \"英文老师\", \"gender\": \"female\"}");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.saveUser(user);
    }

    @Test
    void testSelectById() {
        User user = userMapper.queryUserById(1L);
        System.out.println("user = " + user);
    }


    @Test
    void testQueryByIds() {
        List<User> users = userMapper.queryUserByIds(List.of(1L, 2L, 3L, 4L));
        users.forEach(System.out::println);
    }

    @Test
    void testUpdateById() {
        User user = new User();
        user.setId(1L);
        user.setBalance(20000);
        userMapper.updateUser(user);
    }

    @Test
    void testDeleteUser() {
        userMapper.deleteUser(5L);
    }

    @Test
    void testQuery(){
        User user = userMapper.queryUserById(1L);
        System.out.println("user = " + user);
    }


    @Test
    void testQueryWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .select("id","username","info","balance")
                .like("username","a")
                .ge("balance",100);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
<<<<<<< HEAD
    void testQueryAllWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .select("id","username","info","balance");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
=======
>>>>>>> 518e02e (MyBatisPlus)
    void testUpdateByQueryWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username","Jack");
        User user = new User();
        user.setBalance(3000);
        userMapper.update(user,wrapper);
    }
<<<<<<< HEAD

    @Test
    void testUpdateWrapper(){
        List<Long> ids = List.of(1L,2L,4L);
        // 1. 生成 SQL
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>()
                .setSql("balance = balance - 200")
                .in("id",ids);
        // 2. 更新 注意 第一个参数可以给 null 也就是不填更新字段和数据，而是基于 UpdateWrapper中的 setSQL 来更新
        userMapper.update(null,wrapper);
    }

    @Test
    void testLambdaQueryWrapper(){
        // 1.构建条件 WHERE username LIKE "%o%" AND balance >= 1000
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .select(User::getId,User::getUsername,User::getInfo,User::getBalance)
                .like(User::getUsername,"o")
                .ge(User::getBalance,1000);
        // 2.查询
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void testCustomWrapper(){
        // 1. 准备自定义查询条件
        List<Long> ids = List.of(1L,2L,4L);
        QueryWrapper<User> wrapper = new QueryWrapper<User>().in("id",ids);

        // 2. 调用mapper的自定义方法，直接传递 wrapper
        userMapper.deductBalanceByIds(200,wrapper);
    }

    @Test
    void testCustomJoinWrapper(){
        // 1. 准备自定义查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .in("u.id",List.of(1L,2L,4L))
                .eq("a.city","北京");

        // 2. 调用 mapper 的自定义方法
        List<User> users = userMapper.queryUserByWrapper(wrapper);

        // 3. 打印
        users.forEach(System.out::println);
    }
=======
>>>>>>> 518e02e (MyBatisPlus)
}
