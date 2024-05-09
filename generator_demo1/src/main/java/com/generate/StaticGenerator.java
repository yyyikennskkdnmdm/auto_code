package com.generate;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 静态文件生成
 */
public class StaticGenerator {
    public static void main(String[] args) {
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath);
        // 输入路径：ACM实例代码模板目录
        String inputPath = new File(parentFile, "acm-template").getAbsolutePath();
        // 输出路径：直接输出到目录的根目录
        String outputPath = projectPath + File.separator + "generator_demo1" + File.separator + "src";
//        copyFilesByRecursive(inputPath, outputPath);
        copyFilesByHutool(inputPath, outputPath);
    }

    /**
     * 拷贝文件 (Hutool实现，会将<输入目录>完整拷贝到<输出目录>下)
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutool(String inputPath, String outputPath){
        FileUtil.copy(inputPath, outputPath, false);
    }

    /**
     * 递归拷贝文件（递归实现，会将输入目录完整拷贝到输出目录下）
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByRecursive(String inputPath, String outputPath){
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        copyFileByRecursive(inputFile, outputFile);
    }

    private static void copyFileByRecursive(File inputFile, File outputFile) {
        //区分是文件还是目录
        if(inputFile.isDirectory()){
            //outputFile目录下创建名为inputFile.getNmae()的文件
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 如果是目录，首先创建目标目录
            if(!destOutputFile.exists()) destOutputFile.mkdirs();

            // 获取目录下的所有文件和子目录
            // 如果没有文件，直接结束； 否则递归拷贝下一层文件
            File[] files = inputFile.listFiles();
            if(ArrayUtil.isEmpty(files)) return;
            for (File file : files) copyFileByRecursive(file, destOutputFile);
        }else{
            // 是文件，直接复制到目标目录下
            try {
                Files.copy(inputFile.toPath(), outputFile.toPath().resolve(inputFile.getName()), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Test
    public void test(){
        String filePath = "test.txt";
        File file2 = new File("");//获取本代码文件的url
        File file = new File(file2.getAbsoluteFile().toString() + File.separator + filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("文件已创建！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件已存在！");
        }


        File testDir = new File("testDir");
        File file1 = new File(testDir, "test.txt");
        System.out.println("file1 = " + file1);

        Path path = file1.toPath();
        System.out.println("path = " + path);

        Path test = path.resolve("test");
        System.out.println("test = " + test);

    }


}
