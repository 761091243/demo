package dwp.IO.putStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description: 文件输入流
 * @author: Dunn
 * @create: 2021-08-10 15:11
 */
public class FileInputStreamDemo {


    /**
     * 读取文件内容
     * @throws IOException
     */
    @Test
    public void demo() throws IOException {
        FileInputStream fis = new FileInputStream("src\\main\\resources\\file\\b.txt");
        byte[] bytes = new byte[2];
        int len;
        while ((len = fis.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
    }

    /**
     * 图片复制
     */
    @Test
    public void  demo1() throws IOException {
        // 创建文件输入流
        FileInputStream fis = new FileInputStream("src\\main\\resources\\file\\1.jpg");
        // 创建文件输出流
        FileOutputStream fos = new FileOutputStream("src\\main\\resources\\file\\2.jpg");
        // 文件复制
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();

    }


}
