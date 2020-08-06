/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.*;

/**
 *
 * @author Thắng Bùi
 */
public class Client {

    public static void main(String[] args) {
        try {
            //2: Client tạo socket.
            Socket socket = new Socket("localhost", 2811);
            // connect(): Client gửi yêu cầu đến Server với địa chỉ IP và Port xác định
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner scan = new Scanner(System.in);

            while (true) {
                //Xử lý
                String message = "";
                int x = scan.nextInt();
                dos.writeUTF(String.valueOf(x)); // Chuyển đổi int sang String

                String s = dis.readUTF();
                System.out.println(s);
                break;
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
