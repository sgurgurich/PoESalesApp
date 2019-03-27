package sockets;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.json.simple.JSONObject;

@ClientEndpoint
public class SocketManager {
	
	private static SocketManager instance;
	
	private URI endpointURI;
	
	public static SocketManager getInstance() {
		if (instance == null) {
			instance = new SocketManager();
		}
		return instance;
	}
	
    Session userSession = null;
    private SocketMessageHandler msgHandler;

    public SocketManager() {
		this.endpointURI = null;
		this.msgHandler = new SocketMessageHandler();
    	
        try {
        	this.endpointURI = new URI("ws://rustnstardust.com:8080");
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

 
    @OnOpen
    public void onOpen(Session userSession) {
        System.out.println("opening websocket");
        this.userSession = userSession;
    }


    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        System.out.println("closing websocket");
        this.userSession = null;
    }

    @OnMessage
    public void onMessage(String message) {
        if (this.msgHandler != null) {
            this.msgHandler.handleMsg(message);
        }
    }

    public void sendMessage(String message) {
        this.userSession.getAsyncRemote().sendText(message);
    }
    
    public SocketMessageHandler getMsgHandler(){
    	return this.msgHandler;
    }


	
	
	/*
	
	
	
	
	private boolean openSocket() {
		try {
			socket = new Socket(addr, port);
			outgoingMsg = new DataOutputStream(socket.getOutputStream());
			incomingMsg = new DataInputStream(socket.getInputStream());
			System.out.println("Connected to server");
			JSONObject helloHeader = new JSONObject();
			
			helloHeader.put("type", "newConnection");
			helloHeader.put("uniqueID", "sG27t8Af");
			helloHeader.put("platform", "pcUser");
			
			System.out.println(helloHeader.toJSONString());
			sendMessage(helloHeader.toJSONString());
			
			return true;
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
*/




}
