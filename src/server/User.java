package server;

import java.net.Socket;

import Messages.Message;
import utils.MessageWriter;
import Messages.*;
public class User {
	private String name;
	private Socket userSocket;
	private MessageWriter out;
	private Channel joinedChannel;
	public User(Socket sock, String name) {
		this.userSocket = sock;
		this.out = new MessageWriter(sock);
		this.name = name;
	}
	public void join(Channel channel) {
		channel.recieveConnection(this);
		joinedChannel = channel;
	}
	public void leave(Channel channel) {
		channel.cutConnection(this);
		joinedChannel = null;
	}
	// send a message to the client
	public void notify(Message message) {
		out.send(message);
	}
	public void send(String content) {
		if(joinedChannel != null) {
			Message message = new UserMessage(this, content);
			joinedChannel.sendMessage(message);
		}
	}
	public String getName() {
		return name;
	}
	public Socket getSocket() {
		return this.userSocket;
	}
}
