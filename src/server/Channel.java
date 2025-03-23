package server;
import java.util.List;

import Messages.Message;
import Messages.ServerMessage;
public class Channel {
	private List<User> joinedUsers;
	private List<Message> messages;
	private String name;
	public Channel(String name) {
		this.name = name;
	}
	public void recieveConnection(User user) {
		joinedUsers.add(user);
		
		sendMessage(new ServerMessage("Hello, welcome to channel: " + name + ". Enjoy!"));
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
	public List<Message> getMessages() {
		return this.messages;
	}
}
