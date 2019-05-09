package ThreadClient;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


/**
 * 接收服务器数据
 */
public class ReadDataFromServerThread extends Thread{


    private final Socket client;

    public ReadDataFromServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //获取输入流
            Scanner in = new Scanner(client.getInputStream());
            while (true){
                if(client.isClosed()){
                    System.out.println("客户端已关闭");
                    break;
                }else{
                    if(in.hasNext()){
                        String message = in.nextLine();
                        System.out.println(message);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
