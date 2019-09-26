package com.ruda.n2.food;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.ruda.n2.network.Network;

public class Server2_1 {
	
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket sc = null;
		Network network = new Network();
		MenuMaker mm = new MenuMaker();
		
		try {
			ss = new ServerSocket(8282);
			sc = ss.accept();
			String select = network.receive(sc);
			
			String menu = mm.selectMenu(select);
			
			network.send(sc, menu);
			
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		mm = new MenuMaker();
		mm.init();
		String menu = mm.selectMenu("2");
		System.out.println(menu);
		
		
	}

}
