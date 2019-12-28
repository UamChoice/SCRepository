package com.base.proxy;

import com.base.proxy.dyna.DynaProxy;
import com.base.proxy.staticc.UserDao;
import com.base.proxy.staticc.StaticProxy;
import com.base.proxy.staticc.StaticProxyFit;
import com.base.proxy.staticc.UserDaoImpl;
import com.base.proxy.staticc.extend.HelloTimeSale;
import com.base.proxy.staticc.extend.Sale;

public class Test {
    public static void main(String[] args) {
        staticProxy();
        staticProxyFit();
        staticProxyExtend();
        dynaProxy();
    }

    /**
     * 静态代理--接口
     */
    public static void staticProxy(){
        System.out.println("静态方式-接口");
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.find();
        staticProxy.save();
        System.out.println();
    }

    /**
     * 静态代理--接口--装饰
     */
    public static void staticProxyFit(){
        System.out.println("静态方式-接口--装饰");
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        StaticProxyFit staticProxy = new StaticProxyFit(userDaoImpl);
        staticProxy.find();
        staticProxy.save();
        System.out.println();
    }

    public static void staticProxyExtend(){
        System.out.println("静态方式-继承");
        Sale sale = new HelloTimeSale();
        sale.sale();
        System.out.println();
    }

    /**
     * JDk动态代理
     */
    public static void dynaProxy(){
        System.out.println("动态代理--jdk");
        //目标对象
        UserDaoImpl target = new UserDaoImpl();
        //代理对象
        UserDao proxy = (UserDao)new DynaProxy(target).getProxyInstance();

        proxy.find();
        proxy.save();
        System.out.println();

    }
}
