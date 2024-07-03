package org.thewhitemage13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) throws IOException {

        try(var socket = new Socket("localhost", 8081);

            var inputStream = new DataInputStream(socket.getInputStream());
            var outputStream = new DataOutputStream(socket.getOutputStream());
            var scanner = new Scanner(System.in)){

            while(scanner.hasNextLine()) {
                outputStream.writeUTF(scanner.nextLine());
                System.out.println("Server: " + inputStream.readUTF());

            }
        }
    }
}
