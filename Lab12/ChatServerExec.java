// Imports
import java.io.PrintWriter;
import java.util.HashSet;


/**
 * A multithreaded chat room server.  When a client connects the
 * server requests a screen name by sending the client the
 * text "SUBMITNAME", and keeps requesting a name until
 * a unique one is received.  After a client submits a unique
 * name, the server acknowledges with "NAMEACCEPTED".  Then
 * all messages from that client will be broadcast to all other
 * clients that have submitted a unique screen name.  The
 * broadcast messages are prefixed with "MESSAGE ".
 * 
 */
public class ChatServerExec {

    public ChatServerExec(int port) {
    	CHAT_ROOM_PORT = port;
	}

    /**
     * The port that the server listens on.
     */
    private static int CHAT_ROOM_PORT;
    /**
     * Starts an instance of a server in a thread so that GUI thread can continue to operate asynchronously
     * @param port
     */
   public void startServer() {
		// Variables
		ChatServer server = new ChatServer(CHAT_ROOM_PORT);
		Thread t = new Thread(server);
		
		// Run thread
		t.start(); 
    }
}
