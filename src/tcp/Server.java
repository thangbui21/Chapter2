/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Thắng Bùi
 */
public class Server {
    public static void main(String[] args) {
        try {
            //1: Server tạo socket, gán số hiệu cổng và lắng nghe kết nối.
            ServerSocket myServer = new ServerSocket(2811);
            // bind():Server gán số hiệu cổng (port) cho socket
            // listen(): Server lắng nghe các yêu cầu kết nối từ client trên cổng được gán.
            System.out.println("Server ready!");
            
            while(true) {
                // Thiết lập kết nối
                Socket socket = myServer.accept(); //2S: Server chấp nhận kết nối của client, 
                                                   //    một kênh ảo được hình thành. Client và Server trao đổi thông qua kênh này.
                System.out.println("Client connected");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                
                // 3:Xử lý
                String message = "";
                String num = dis.readUTF();
                int x = Integer.parseInt(num);
                
                if (x % 2 == 0) {
                    message += num + " là số chẵn";
                    dos.writeUTF(message);
                    break;
                }
            }
            // 4: Kết thúc phiên làm việc.
        } catch (IOException e) {
            System.out.println(e);
        }
                
                
              
    }
}
