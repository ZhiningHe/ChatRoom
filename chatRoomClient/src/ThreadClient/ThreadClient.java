package ThreadClient;


import java.io.IOException;
import java.net.Socket;

/**
 * 建立Socket连接
 * 启动读数据和写数据线程
 * MultiThreadClient（主类）
 * ReadDataFromeServerThread
 * WriteDataToServerThread
 */



public class ThreadClient {


    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            //创建写线程
            Thread read = new ReadDataFromServerThread(socket);
            read.setName("Thread-Client-Read");
            read.start();
            //创建读线程
            Thread write = new WriteDataToServerThread(socket);
            write.setName("Thread-Client-Write");
            write.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
