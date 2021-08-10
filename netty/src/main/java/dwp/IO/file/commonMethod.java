package dwp.IO.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @description: 常用方法
 * @author: Dunn
 * @create: 2021-08-10 11:31
 */
public class commonMethod {

    private static  Integer fileNum = 0;

    /**
     * 构建file
     */
    @Test
    public void build() throws IOException {
        File f = new File("E:\\java\\other\\text1.txt");
        System.out.println("文件绝对路径:"+f.getAbsolutePath());
        System.out.println("文件构造路径:"+f.getPath());
        System.out.println("文件名称:"+f.getName());
        System.out.println("文件长度:"+f.length()+"字节");

        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        f.createNewFile();
        System.out.println(f.isFile());

    }

    /**
     * 递归文件
     */
    @Test
    public void recursion(){
        File file = new File("F:\\IdeaProject");
        if (file.exists()){
            reFile(file);
            System.out.println("文件数量" + fileNum);
        }
    }

    public void reFile(File f){
        File[] files = f.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名：" + file.getAbsolutePath());
                fileNum++;
            }else {
                System.out.println("目录：" + file.getAbsolutePath());
                reFile(file);
            }
        }
    };


}
