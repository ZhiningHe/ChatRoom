package SigleServer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SigleServer {
    public static void main(String[] args) throws IOException {
        //建立基站
        ServerSocket serverSocket = new ServerSocket(666);
        //accept会返回一个socket用来读写数据
        Socket socket = serverSocket.accept();
        System.out.println("等待客户端连接……");

        //建立连接后，建立数据输入输出
        //打印 发送的数据 (写)
        PrintStream printStream = new PrintStream
                (socket.getOutputStream(),true,"UTF-8");
        printStream.println("Hi~i am server!");

        //打印 收到的数据 （读）
        Scanner scanner = new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("Client:"+scanner.nextLine());
        }

        //关闭流
        scanner.close();
        printStream.close();
        socket.close();
    }
}
