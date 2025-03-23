package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputHandler implements Runnable{
	private BufferedReader in;
	private User user;
	public UserInputHandler(User user) {
		this.user = user;
		try {
			in = new BufferedReader(new InputStreamReader(user.getSocket().getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(true) {
			try{
				String line = in.readLine();
				if(line != null) {
					System.out.println("System print: " + line);
					user.send(line);
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
	
}
