package utils;
import java.net.Socket;

import Messages.Message;

import java.io.PrintWriter;
public class MessageWriter {
	PrintWriter out;
	public MessageWriter(Socket sock) {
		try {
			out = new PrintWriter(sock.getOutputStream(), true);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void send(Message message) {
		out.println(message.toString());
	}
}
