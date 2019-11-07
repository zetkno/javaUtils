package com.zetkno.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Demo {
    public static void main(String[] args) throws Exception{
//        if (args.length != 2) {
//            System.out.println("命令执行错误，执行结构，");
//            System.exit(1);
//        }
        long start = System.currentTimeMillis();
        FileUtils fu = new FileUtils("F:\\pic\\sasiki.jpg","F:\\Demo\\sa.jpg");
        System.out.println(fu.copy() ? "文件拷贝成功" : "文件拷贝失败");
        long end = System.currentTimeMillis();
        System.out.println("文件拷贝完成的时间：" + (end - start));
    }
}


public class FileUtils {
    private File srcFile;
    private File desFile;

    public FileUtils(File srcFile, File desFile) {
        this.srcFile = srcFile;
        this.desFile = desFile;
    }

    public FileUtils(String src, String des) {
        this(new File(src), new File(des));


    }

    public boolean copy() throws Exception{
        if (!this.srcFile.exists()) {
            System.out.println("拷贝的源文件不存在");
            return false;
        }
        if (!this.desFile.getParentFile().exists()) {
            this.desFile.getParentFile().mkdirs();
        }
        byte[] data = new byte[1024];  //开辟一个拷贝的缓冲区
        InputStream input = null;
        OutputStream output = null;
        input = new FileInputStream(this.srcFile);
        output = new FileOutputStream(this.desFile);
        int len = 0;
        while ((len = input.read(data)) != -1) {
            output.write(data, 0, len);
        }
        if (input != null){
            input.close();
        }
        if (output != null) {
            output.close();
        }
            return true;

    }
}

