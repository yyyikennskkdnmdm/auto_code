package com.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
// mixinStandardHelpOptions属性设置为true可以给应用程序自动添加--help和--version选项
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true) 
public class ASCIIArt implements Runnable {
    // Option注解将字段设置为命令行选项，可以给选项设置名称和描述
    @Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 19;

    // Parameters注解将字段设置为命令行选项，可以指定默认值
    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli", 
               description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" }; 

    @Override
    public void run() {
        // 自己实现业务逻辑
        System.out.println("fontSize = " + fontSize);
        System.out.println("words = " + String.join(",", words));
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute(args); 
        System.exit(exitCode); 
    }
}