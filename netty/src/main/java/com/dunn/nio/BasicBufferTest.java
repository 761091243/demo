package com.dunn.nio;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * @description: 缓存
 * @author: Dunn
 * @create: 2022-04-20 10:37
 */
public class BasicBufferTest {

    /**
     * capacity: 总容量长度
     * limit:可用长度,写数据时，limit = 总容量长度， 读数据时 = 已存数据长度
     * position:下一个位置
     * mark：标记
     */
    @Test
    public void demo1() {
        IntBuffer intBuffer = IntBuffer.allocate(8);
        System.out.println("----------初始-----------");
        System.out.println("总容量为：" + intBuffer.capacity());
        System.out.println("可用长度：" + intBuffer.limit());
        System.out.println("下一个位置：" + intBuffer.position());
        System.out.println("标记：" + intBuffer.mark());

        intBuffer.put(100);
        intBuffer.put(200);
        intBuffer.put(300);
        intBuffer.put(400);
        intBuffer.put(500);

        // 写
/*        int i = 1;
        while (intBuffer.hasRemaining()) {
            intBuffer.put(1000+i);
            i++;
        }*/

        // 转换为读
        intBuffer.flip();
        System.out.println("----------转换为读-----------");
        System.out.println("总容量为：" + intBuffer.capacity());
        System.out.println("可用长度：" + intBuffer.limit());
        System.out.println("下一个位置：" + intBuffer.position());
        System.out.println("标记：" + intBuffer.mark());
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }

        System.out.println("----------已全部读取-----------");
        System.out.println("总容量为：" + intBuffer.capacity());
        System.out.println("可用长度：" + intBuffer.limit());
        System.out.println("下一个位置：" + intBuffer.position());
        System.out.println("标记：" + intBuffer.mark());
    }


}
