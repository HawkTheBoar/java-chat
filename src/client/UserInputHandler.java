package client;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class UserInputHandler implements Runnable{
	Socket userSock;
	PrintWriter out;
	public UserInputHandler(Socket sock) {
		this.userSock = sock;
		try {
			out = new PrintWriter(sock.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(out == null)
			return;
		Scanner s = new Scanner(System.in);
		while(true) {
			String line = s.nextLine();
			if(line != null)
				out.println(line);
		}
	}
}
