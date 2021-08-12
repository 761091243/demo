package dwp.NIO.buffer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author: Dunn
 * @create: 2021-08-12 18:14
 */
public class BufferDemo1 {


    /**
     * 使用Chanel和buffer本地文件 写数据
     * @throws IOException
     */
    @Test
    public void demo1() throws IOException {
        // 没文件会自动创建
        FileOutputStream os = new FileOutputStream("src\\main\\resources\\file\\NIO\\buffer\\a.txt",true);
        FileChannel channel = os.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("时尚时尚最时尚".getBytes());
        // buffer写转换成读
        buffer.flip();
        channel.write(buffer);
        os.close();
    }

    /**
     * 使用Chanel和buffer本地文件 读数据
     * @throws IOException
     */
    @Test
    public void demo2() throws IOException {
        FileInputStream is = new FileInputStream("src\\main\\resources\\file\\NIO\\buffer\\a.txt");
        FileChannel channel = is.getChannel();
        // 这里需要2的倍数，因为中文占2个字节，不然会乱码 ---
        ByteBuffer buffer = ByteBuffer.allocate(5*2);
        int len;
        while ((len = channel.read(buffer)) != -1){
            channel.read(buffer);
            System.out.print(new String(buffer.array()));
            buffer.clear();
        }
        is.close();
    }









}
