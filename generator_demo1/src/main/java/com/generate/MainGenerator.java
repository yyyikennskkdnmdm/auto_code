package com.generate;

import com.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setAuthor("jianghao");
        mainTemplateConfig.setOutputText("求和结果");
        doGenerate(mainTemplateConfig);
    }

    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        // 如果在auto_code中执行需要将inputPath交换
//        String inputPath = new File(parentFile, "acm-template").getAbsolutePath();
        String inputPath = parentFile.getPath();
        String outputPath = parentFile.getPath();
        //生成静态文件
//        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        // 生成动态文件
        // 如果在auto_code中执行需要将inputDynamicFilePath交换
//        String inputDynamicFilePath = projectPath + File.separator + "generator_demo1" + File.separator + "src"
//                + File.separator + "main" + File.separator + "resources" + File.separator + "templates"
//                + File.separator + "MainTemplate.java.ftl";
        String inputDynamicFilePath = inputPath + File.separator + "generator_demo1" + File.separator + "src"
                + File.separator + "main" + File.separator + "resources" + File.separator + "templates"
                + File.separator + "MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template2" + File.separator +
                 "src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath,model);
    }


}
