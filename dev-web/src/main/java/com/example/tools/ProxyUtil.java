package com.example.tools;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 动态创建一个代理类，
 * 传入：目标对象
 * 返回：代理对象
 * 1.先用文件流File写.java文件到某个路径下
 * 2.再用JavaCompiler编译刚生成的java文件为.class文件
 * 3.URLClassLoader装在clazz类
 * 4.运用java反射找到构造方法，生成一个代理类
 */
public class ProxyUtil {

    /**
     *  content --->string
     *  .base  io
     * .class
     *
     * .new   反射----》class
     * @return
     */
    public static Object newInstance(Object target){
        Object proxy=null;
        Class targetInf = target.getClass().getInterfaces()[0];
        Method methods[] =targetInf.getDeclaredMethods();
        String line="\n";
        String tab ="\t";
        String infName = targetInf.getSimpleName();
        String content ="";
        String packageContent = "package com.google;"+line;
        String importContent = "import "+targetInf.getName()+";"+line;
        String clazzFirstLineContent = "public class $Proxy implements "+infName+"{"+line;
        String filedContent  =tab+"private "+infName+" target;"+line;
        String constructorContent =tab+"public $Proxy ("+infName+" target){" +line
                                  +tab+tab+"this.target =target;"
                                  +line+tab+"}"+line;
        String methodContent = "";
        for (Method method : methods) {
            String returnTypeName = method.getReturnType().getSimpleName();
            String methodName =method.getName();
            // Sting.class String.class
            Class args[] = method.getParameterTypes();
            String argsContent = "";
            String paramsContent="";
            int flag =0;
            for (Class arg : args) {
                String temp = arg.getSimpleName();
                //String
                //String p0,Sting p1,
                argsContent+=temp+" p"+flag+",";
                paramsContent+="p"+flag+",";
                flag++;
            }
            if (argsContent.length()>0){
                argsContent=argsContent.substring(0,argsContent.lastIndexOf(",")-1);
                paramsContent=paramsContent.substring(0,paramsContent.lastIndexOf(",")-1);
            }

            methodContent+=tab+"public "+returnTypeName+" "+methodName+"("+argsContent+") {"+line
                          +tab+tab+"System.out.println(\"log\");"+line
                          +tab+tab+"target."+methodName+"("+paramsContent+");"+line
                          +tab+"}"+line;

        }

        content=packageContent+importContent+clazzFirstLineContent+filedContent+constructorContent+methodContent+"}";

        File file =new File("d:\\com\\google\\$Proxy.base");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();


            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(file);

            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();

            URL[] urls = new URL[]{new URL("file:D:\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.google.$Proxy");

            Constructor constructor = clazz.getConstructor(targetInf);
            proxy = constructor.newInstance(target);

            //clazz.newInstance();
            //Class.forName()
        }catch (Exception e){
            e.printStackTrace();
        }

        return proxy;
    }
}
