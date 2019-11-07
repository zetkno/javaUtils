package com.zetkno.io;

import java.io.*;

//  FileOutputWriter  FileInputReader   字符转换流

public class IODemo {
    public static void main(String[] args) throws Exception{
//        String path = "F:\\Demo\\";
//        File file = new File(path);
//        rename(file);

        File file = new File("F:\\IOFileTest\\ceshi.txt");
//        System.out.println(file.getParentFile());
//        if (!file.getParentFile().exists()) {  //文件不存在
//            file.getParentFile().mkdirs();     // 创建父目录
//        }
//        OutputStream output = new FileOutputStream(file,true);
//        String str = "www.google.com\r\n";
//        output.write(str.getBytes());
//        output.close();

        InputStream input = new FileInputStream(file);
        byte[] data = new byte[123456];
        int len = input.read(data);
        System.out.println("【" + new String(data,0, len) + "】");
        input.close();

//        if (!(file.getParentFile().exists())) {
//            file.getParentFile().mkdirs();
//        }
        Writer writer = new FileWriter(file, true);
//        String str = "www.baidu.com\r\n";
//        writer.write(str);
//        writer.close();
    }

//    后缀改成.txt结尾
    public static void rename(File file) {
        file.getName();
        if (file.isDirectory()) {
            File[] results = file.listFiles();
            if (results != null) {
                for (int i = 0; i < results.length; i++) {
                    rename(results[i]);
                }
            }
        } else {
            if (file.isFile()) {
                String fielName = null;
                if (file.getName().contains(".")) {
                     fielName = file.getName().substring(0,file.getName().lastIndexOf(".")) + ".txt";
                } else {
                    fielName = fielName + ".txt";
                }
                File newFile = new File(file.getParent(), fielName);
                file.renameTo(newFile);
            }
        }
    }

//    列出目录下所有文件
    public static void listDir(File file) {
        if (file.isDirectory()) {    //是目录就list出来
            File[] results = file.listFiles();
            if (results != null) {
                for (int i = 0; i < results.length; i++) {
                    listDir(results[i]);
                }
            }
        } else {
            System.out.println(file);
        }
    }
}
