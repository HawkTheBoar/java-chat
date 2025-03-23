package server;

import java.net.Socket;

import Messages.Message;
import utils.MessageWriter;

public class User {
	private String name;
	private Socket userSocket;
	private MessageWriter out;
	public User(Socket sock, String name) {
		this.userSocket = sock;
		this.out = new MessageWriter(sock);
		this.name = name;
	}
	public void join(Channel channel) {
		channel.recieveConnection(this);
	}
	public void leave(Channel channel) {
		channel.cutConnection(this);
	}
	// send a message to the client
	public void notify(Message message) {
		out.send(message);
	}
	public String getName() {
		return name;
	}
}
