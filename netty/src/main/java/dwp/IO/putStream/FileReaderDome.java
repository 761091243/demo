package dwp.IO.putStream;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * @description: 字符输入流
 * @author: Dunn
 * @create: 2021-08-10 15:53
 */
public class FileReaderDome {


    /**
     * 读取文件
     * @throws IOException
     */
    @Test
    public void demo1() throws IOException {
        FileReader fr = new FileReader("src\\main\\resources\\file\\putStream\\a.txt");
        int len;
        char[] cbuf = new char[2];
        while ((len = fr.read(cbuf)) != -1) {
            System.out.print(new String(cbuf,0,len));
        }
        fr.close();
    }


}
