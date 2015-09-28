package com.kwahsog.maven.SteamSrcServerQuery;

import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.servers.SourceServer;

public class SampleServerTest {
	
	public static void main(String [] args) throws UnknownHostException, TimeoutException, InterruptedException 
	{
		
	
	try {
		SourceServer sampleserver = new SourceServer("95.172.92.240", 27015);
		FullPlayerTester.FullPlayerTestercheck(sampleserver);
		
		
	} catch (SteamCondenserException e) {
		System.out.println("Invalid server. Stack trace:");
		e.printStackTrace();
	}

	}
}

