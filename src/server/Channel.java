package server;
import java.util.ArrayList;

import Messages.Message;
import Messages.ServerMessage;
public class Channel {
	private ArrayList<User> joinedUsers;
	private ArrayList<Message> messages;
	private String name;
	public Channel(String name) {
		this.name = name;
		this.joinedUsers = new ArrayList<User>();
		this.messages = new ArrayList<Message>();
	}
	public void recieveConnection(User user) {
		joinedUsers.add(user);
		
		sendMessage(new ServerMessage(user.getName()+" welcome to channel " + name + "!"));
	}
	public void cutConnection(User user) {
		joinedUsers.remove(user);
	}
	public void sendMessage(Message message) {
		messages.add(message);
		joinedUsers.forEach((user) -> {
			user.notify(message);
		});
	}
	public ArrayList<Message> getMessages() {
		return this.messages;
	}
}
