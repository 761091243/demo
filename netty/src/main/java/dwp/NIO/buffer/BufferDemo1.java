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
     * ʹ��Chanel��buffer�����ļ� д����
     * @throws IOException
     */
    @Test
    public void demo1() throws IOException {
        // û�ļ����Զ�����
        FileOutputStream os = new FileOutputStream("src\\main\\resources\\file\\NIO\\buffer\\a.txt",true);
        FileChannel channel = os.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("ʱ��ʱ����ʱ��".getBytes());
        // bufferдת���ɶ�
        buffer.flip();
        channel.write(buffer);
        os.close();
    }

    /**
     * ʹ��Chanel��buffer�����ļ� ������
     * @throws IOException
     */
    @Test
    public void demo2() throws IOException {
        FileInputStream is = new FileInputStream("src\\main\\resources\\file\\NIO\\buffer\\a.txt");
        FileChannel channel = is.getChannel();
        // ������Ҫ2�ı�������Ϊ����ռ2���ֽڣ���Ȼ������ ---
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
