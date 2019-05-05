package SigleClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SigleClient {
    public static void main(String[] args) throws IOException {
        //建立连接
        Socket socket = new Socket("127.0.0.1",666);
        //打印接收到的数据
        Scanner scanner = new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("Server："+scanner.nextLine());
        }

        //发数据
        PrintStream printStream = new PrintStream(socket.getOutputStream(),true,
                "UTF-8");
        printStream.println("hi~,i am client");

        socket.close();
        scanner.close();
        printStream.close();
    }
}









