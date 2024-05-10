package com.cli.command;

import picocli.CommandLine.*;

import java.util.concurrent.Callable;

@Command(name = "test1", description = "生成代码", mixinStandardHelpOptions = true)
public class TestCommand implements Callable<Integer> {

    // echo 表示在输入的时候，显示输入
    @Option(names = {"-a", "--atext"}, arity = "0..1", description = "test_a", interactive = true, echo = true)
    private String atext;

    @Override
    public Integer call() throws Exception {
        System.out.println("atext = " + atext);
        return 0;
    }
}
