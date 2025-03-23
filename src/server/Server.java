package server;
import java.net.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
public class Server {
	private ArrayList<Channel> channels;
	private ArrayList<User> users;
	private Map<User, Thread> runningThreads;
	private ServerSocket serverSock;
	public Server() {
		this.channels = new ArrayList<Channel>();
		this.users = new ArrayList<User>();
		this.runningThreads = new HashMap<User, Thread>();
	}
	public void start() {
		Channel baseChannel = new Channel("general");
		int port = 6666;
		try {
			serverSock = new ServerSocket(port);
			System.out.println("Server started on port: "+port);
			while(true) {
				Socket client = serverSock.accept();
				User user = new User(client, "user");
				user.join(baseChannel);
				users.add(user);
				UserInputHandler inputHandler = new UserInputHandler(user);
				Thread t = new Thread(inputHandler);
				t.start();
				runningThreads.put(user, t);
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void stop() {
		
	}
}
