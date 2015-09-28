package com.kwahsog.maven.SteamSrcServerQuery;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.servers.SourceServer;

public class FullPlayerTester {

	public static void FullPlayerTestercheck(SourceServer sampleserver) throws SteamCondenserException, UnknownHostException, TimeoutException, InterruptedException
	{
		
		boolean full = true;
		HashMap<String, Object> serverinfo = sampleserver.getServerInfo();

		//get current info	
		Byte servermaxplayers = (Byte) serverinfo.get("maxPlayers");
		Byte currentplayers = (Byte) serverinfo.get("numberOfPlayers");

		//optional print statements about server
		System.out.println("Server info: " + serverinfo.toString());
		System.out.println("Max Players: " + servermaxplayers);		
		
		while(full)
		{			
		if (currentplayers < servermaxplayers)
		{
			//if server has space
		full = false;
		System.out.println("Server has space, there are currently: " + currentplayers + " on the server.");
			for (int i = 1; i <10; i++)
			{
				java.awt.Toolkit.getDefaultToolkit().beep();
				Thread.sleep(100);
			}
						
		}
		else 
		{
			//server full, wait then update player list.
			System.out.println("Server is full, there are currently: " + currentplayers + " on the server.");
			Thread.sleep(1000*10);
			sampleserver.updatePlayers();
		}
		}
	}
		
}

