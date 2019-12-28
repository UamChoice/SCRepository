package com.base.proxy.dyna;

import com.base.proxy.staticc.UserDao;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;

public class DynaProxyWriteClass {

    public static void main(String[] args) {
        writeClass();
    }

    public static void writeClass(){

        //目标类实现的接口对象们
        Class[] interfaces = new Class[]{UserDao.class};
        //生成的代理类的名字
        String proxyName = "ProxyUserDao";
        //File文件路径地址
        String fileFoder = "F:\\Program Files\\JetBrains\\Idea_workspace\\JavaBase\\classes\\";
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                proxyName, interfaces);

        File file = new File(fileFoder+proxyName+".class");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(proxyClassFile);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
