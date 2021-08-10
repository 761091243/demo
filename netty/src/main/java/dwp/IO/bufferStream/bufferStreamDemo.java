package dwp.IO.bufferStream;

import org.junit.Test;

import java.io.*;

/**
 * @description: 字节缓冲流
 * @author: Dunn
 * @create: 2021-08-10 17:14
 */
public class bufferStreamDemo {


    /**
     * 字节流copy
     * @throws IOException
     */
    @Test
    public void demo1() throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("src\\main\\resources\\file\\bufferStream\\redis-desktop-manager-0.8.8.384.exe");
        FileOutputStream fos = new FileOutputStream("src\\main\\resources\\file\\bufferStream\\copy1-redis.exe");
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
        long endTime = System.currentTimeMillis();
        System.out.println("字节流copy用时:" + (endTime - startTime)); // 用时160

    }

    /**
     * 字节缓冲流copy
     * @throws IOException
     */
    @Test
    public void demo2() throws IOException{
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("src\\main\\resources\\file\\bufferStream\\redis-desktop-manager-0.8.8.384.exe");
        FileOutputStream fos = new FileOutputStream("src\\main\\resources\\file\\bufferStream\\copy1-redis.exe");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }
        bis.close();
        bos.close();
        long endTime = System.currentTimeMillis();
        System.out.println("字节缓冲流copy用时:" + (endTime - startTime)); // 用时41
    }

}
