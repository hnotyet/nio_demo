package com.hg.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {

	
	public static void main(String[] args) throws IOException {
		
		ServerSocket socket = new ServerSocket(80); 
        while (true) { 
            final Socket connection = socket.accept(); 
            System.out.println(connection.toString());
        }
		
	}
}
