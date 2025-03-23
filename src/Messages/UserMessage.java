package Messages;

import server.User;

public class UserMessage extends Message {
	public UserMessage(User user, String content) {
		super(user.getName(), content);
	}
}
