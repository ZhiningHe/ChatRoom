package ThreadClient;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 向服务器发送信息
 */

public class WriteDataToServerThread extends Thread{

    private final Socket client;

    public WriteDataToServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            PrintStream send =
                    new PrintStream(client.getOutputStream(),true,"UTF-8");
           Scanner input = new Scanner(System.in);
            System.out.println("***********************");
            System.out.println("   [注册]-R：name       ");
            System.out.println("   [群聊]-G：mess       ");
            System.out.println("   [私聊]-P：name：mess ");
            System.out.println("   [退出]-Q             ");
            System.out.println("***********************");

            while (true) {

                String message;
                    if (input.hasNext()) {
                        message = input.nextLine();
                        send.println(message);
                        if (message.contains("bye~")) {
                            client.close();
                            send.close();
                            input.close();
                            break;
                        }
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
