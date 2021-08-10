package dwp.IO.socket;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: 网络编程demo1
 * @author: Dunn
 * @create: 2021-08-10 18:26
 */
public class SocketDemo1 {


    /**
     * 服务端1
     */
    @Test
    public void serverSocket1() throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket accept = serverSocket.accept();
        InputStream is = accept.getInputStream();
        int len;
        byte[] bytes = new byte[1024];
        len = is.read(bytes);
        System.out.println(new String(bytes,0,len));

        System.out.println("-----回复信息----");
        OutputStream os = accept.getOutputStream();
        os.write("我已收到，你吃了吗".getBytes());

        is.close();
        os.close();
        serverSocket.close();
    }

    /**
     * 客户端1
     */
    @Test
    public void socket1() throws IOException {
        Socket socket = new Socket("localhost", 6666);
        OutputStream os = socket.getOutputStream();
        os.write("服务端你好啊！收到请回复".getBytes());
        System.out.println("-----接收信息----");
        InputStream is = socket.getInputStream();
        int len;
        byte[] bytes = new byte[1024];
        len = is.read(bytes);
        System.out.println(new String(bytes,0,len));

        os.close();
        is.close();
        socket.close();
    }

}
