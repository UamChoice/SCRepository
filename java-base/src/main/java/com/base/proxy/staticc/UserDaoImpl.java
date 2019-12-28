package com.base.proxy.staticc;

//目标对象
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("模拟：保存用户！");
    }
    @Override
    public void find() {
        System.out.println("模拟：查询用户");
    }
}
