package dwp.IO.putStream;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @description: 字符输出流
 * @author: Dunn
 * @create: 2021-08-10 16:12
 */
public class FileWriterDome {

    @Test
    public void demo1() throws IOException {
        // true追加数据
        FileWriter fw = new FileWriter("src\\main\\resources\\file\\c.txt",true);
        fw.write("\r\n");
        fw.write("第1行");
        fw.write("\r\n");
        fw.write("第2行");
        fw.close();
    }
}
