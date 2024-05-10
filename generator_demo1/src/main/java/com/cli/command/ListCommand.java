package com.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;

@Command(name = "list", description = "查看文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    public void run() {
        String projectPath = System.getProperty("user.dir");
//        System.out.println("projectPath = " + projectPath);
        // 整个项目的根路径
        // 输入路径
        String inputPath = new File(projectPath, "acm-template").getAbsolutePath();
//        System.out.println("inputPath = " + inputPath);
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

}