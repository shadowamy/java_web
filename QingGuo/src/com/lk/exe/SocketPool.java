package com.lk.exe;
import java.net.Socket;

import java.util.LinkedList;

public class SocketPool {

	
	private static LinkedList<Socket> SocketList;
	
	static public void initList()
	{
		SocketList = new LinkedList<Socket>();
	}
	
	static public void addSocket(Socket socket)
	{
		SocketList.add(socket);
	}

	static public void removeSocket()
	{
		SocketList.remove();
	}
	
	public static LinkedList<Socket> getSocketList() {
		return SocketList;
	}

	public static void setSocketList(LinkedList<Socket> socketList) {
		SocketList = socketList;
	}
}
