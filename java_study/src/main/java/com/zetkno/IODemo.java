package com.zetkno;

import java.io.File;

public class IODemo {
    public static void main(String[] args) {
        showDiretory(new File("F://IOFileTest"));
    }

    public static void showDiretory(File file) {
        _walkDiretory(file, 0);
    }

    public static void _walkDiretory(File file, int level) {
        if (file.isDirectory()) {
            for (File temp : file.listFiles()) {
                _walkDiretory(temp, level + 1);
            }
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.println("\t");
            }
            System.out.println(file.getName());
        }
    }
}
