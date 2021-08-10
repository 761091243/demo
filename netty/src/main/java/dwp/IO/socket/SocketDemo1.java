package dwp.IO.socket;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: ������demo1
 * @author: Dunn
 * @create: 2021-08-10 18:26
 */
public class SocketDemo1 {


    /**
     * �����1
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

        System.out.println("-----�ظ���Ϣ----");
        OutputStream os = accept.getOutputStream();
        os.write("�����յ����������".getBytes());

        is.close();
        os.close();
        serverSocket.close();
    }

    /**
     * �ͻ���1
     */
    @Test
    public void socket1() throws IOException {
        Socket socket = new Socket("localhost", 6666);
        OutputStream os = socket.getOutputStream();
        os.write("�������ð����յ���ظ�".getBytes());
        System.out.println("-----������Ϣ----");
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
