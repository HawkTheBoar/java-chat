package Messages;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class Message {
	Date timeSent;
	String name;
	String content;
	
	public Message(String name, String content) {
		this.timeSent = new Date();
		this.name = name;
		this.content = content;
	}
	public String toString() {
		return DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("cz", "CZ")).format(timeSent)
			   + " "
			   + name + " >> " + this.content;
	}
}
