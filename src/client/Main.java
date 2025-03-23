package client;
import java.io.*;
import java.net.Socket;
public class Main {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 6666);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			UserInputHandler handler = new UserInputHandler(s);
			Thread t = new Thread(handler);
			t.start();
			while(true) {
				String line = in.readLine();
				if(line != null)
					System.out.println(line);
			}
			//s.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
