package com.base.design;

/**
 * 单例模式
 * Double Control lock
 */
public class SingleDCL {
    //volatile 防止指令重排，立即写入内存，多线程可见
    private volatile static SingleDCL instance;
    private SingleDCL(){};

    public static SingleDCL getInstance(){
        if(instance==null){
            synchronized (SingleDCL.class){
                if(instance==null){
                    //这里的指令重排。1：new一个对象 2：分配空间分2个指令
                    //线程先从缓存去，没有再去内存
                    instance = new SingleDCL();
                }
            }
        }
        return instance;
    }
}
