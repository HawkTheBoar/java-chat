package Messages;

public class ServerMessage extends Message {

	public ServerMessage(String content) {
		super("Server", content);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return name + " >> " + content;
	}
}
