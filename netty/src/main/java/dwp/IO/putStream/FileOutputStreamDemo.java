package dwp.IO.putStream;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description: 文件输出流
 * @author: Dunn
 * @create: 2021-08-10 14:44
 */
public class FileOutputStreamDemo {


    /**
     * 创建一个文件并每次都是重新输出
     * @throws IOException
     */
    @Test
    public void demo1() throws IOException {

        FileOutputStream fos = new FileOutputStream("src\\main\\resources\\file\\a.txt");
        // 注意urf-8 中文是占3个字节
        byte[] bytes = "倚天屠龙记".getBytes();
        fos.write(bytes);
        fos.close();

    }

    /**
     * 追加输出
     */
    @Test
    public void demo2() throws IOException {
        // true 为追加输出
        FileOutputStream fos = new FileOutputStream("src\\main\\resources\\file\\a.txt",true);
        // 注意urf-8 中文是占3个字节
        String[] str = {"第一行","第二行","第三行","第四行"};
        for (String s : str) {
            byte[] bytes = s.getBytes();
            // 换行
            fos.write("\r\n".getBytes());
            fos.write(bytes);
        }
        fos.close();
    }


}
