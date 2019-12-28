package com.base.proxy.staticc;

/**
 * 静态代理
 * 特点：
 * 1. 目标对象必须要实现接口
 * 2. 代理对象，要实现与目标对象一样的接口
 */
public class StaticProxyFit implements UserDao {

    private UserDao target;

    //装饰者模式的对象是又外部传入的
    public StaticProxyFit(UserDao userDao){
        this.target = userDao;
    }

    @Override
    public void save() {
        System.out.println("代理操作： 开启事务...");
        target.save();   // 执行目标对象的方法
        System.out.println("代理操作：提交事务...");
    }

    @Override
    public void find() {
        target.find();
    }
}