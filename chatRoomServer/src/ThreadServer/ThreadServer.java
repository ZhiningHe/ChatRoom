package ThreadServer;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 建立socketServer
 * accept接收客户端连接
 * 采用线程池方式
 *
 * MultiThreadServer
 * ClientHeadler
 *
 */



public class ThreadServer {

        //支持100client
        //1 thread -> 10 client

        //创建一个固定大小的线程池
        private static final ExecutorService executor = Executors.newFixedThreadPool(10, new ThreadFactory() {
            private final AtomicInteger id = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("Thread-Client-Handler-" + id.getAndIncrement());
                return t;
            }
        });

        public static void main(String[] args) {
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                System.out.println("服务器端启动  " + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());

                while (true) {
                    Socket client = serverSocket.accept();
                    System.out.println(client+"已连接……");
                    //使用线程池
                    executor.execute(new ClientHandler(client));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }








