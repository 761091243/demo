package com.dunn.nio;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description: 通道
 * @author: Dunn
 * @create: 2022-04-24 18:59
 *
 * public int read(ByteBuffer dst) ，从通道读取数据并放到缓冲区中
 * public int write(ByteBuffer src) ，把缓冲区的数据写到通道中
 * public long transferFrom(ReadableByteChannel src, long position, long count)，从目标通道中复制数据到当前通道
 * public long transferTo(long position, long count, WritableByteChannel target)，把数据从当前通道复制给目标通道
 */
public class ChannelTest {

    /**
     * Channel
     * 1本地文件写数据
     */
    @Test
    public void write() throws IOException {

        FileOutputStream fos = new FileOutputStream("src\\main\\resources\\file\\channel.text");
        FileChannel channel = fos.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("Hello world".getBytes());
        // 换成转换为读
        byteBuffer.flip();

        // 把缓冲区的数据写到通道中
        channel.write(byteBuffer);
        fos.close();
    }

    /**
     * Channel
     * 2本地文件读数据
     */
    @Test
    public void read() throws IOException {
        FileInputStream fis = new FileInputStream("src\\main\\resources\\file\\channel.text");
        FileChannel channel = fis.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 从通道读取数据并放到缓冲区中
        channel.read(buffer);

        // 缓存转换为读
        buffer.flip();

        System.out.println(new String(buffer.array()));
        fis.close();
    }

    /**
     * Channel
     * 3-使用一个Buffer 完成文件读取、写入
     */
    @Test
    public void redAndWrite() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src\\main\\resources\\file\\channel.text");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("src\\main\\resources\\file\\channel2.text");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true) {
            //循环读取

            byteBuffer.clear(); //清空 buffer
            int read = fileChannel01.read(byteBuffer);
            System.out.println("read =" + read);
            if (read == -1) { //表示读完
                break;

            }

            byteBuffer.flip();
            fileChannel02.write(byteBuffer);

        }
        //关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }


    /**
     * 4-拷贝文件transferFrom 方法
     */
    @Test
    public void transFrom() throws IOException {
        FileInputStream fis = new FileInputStream("src\\main\\resources\\file\\channel\\a.jpg");
        FileOutputStream fos = new FileOutputStream("src\\main\\resources\\file\\channel\\a1.jpg");
        FileChannel iChannel = fis.getChannel();
        FileChannel oChannel = fos.getChannel();

        long size = oChannel.transferFrom(iChannel, 0, iChannel.size());
        System.out.println("传输字节数：" + size);
        fis.close();
        fos.close();
    }

}
