package chat;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


/*
 * 
 */
@ServerEndpoint("/chatting")
public class WebSocket {
	
	@OnOpen
	public void onOpen(String message, Session session) {
		System.out.println("받은 메세지 " + message);
		
		try {
			for(Session clientSession : session.getOpenSessions()) {
				clientSession.getBasicRemote().sendText(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnClose 
	public void onClose(Session session) {
		System.out.println("WebSocket CLOSED " + session.getId());
	}
	
}
