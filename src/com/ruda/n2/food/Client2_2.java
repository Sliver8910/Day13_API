package com.ruda.n2.food;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.ruda.n2.network.Network;

public class Client2_2 {
	
	public static void main(String[] args) {
		Scanner ssc = new Scanner(System.in);
		Network network = new Network();
	
		try {
			Socket sc = new Socket("127.0.0.1", 8282);
			System.out.println("1. 점심메뉴");
			System.out.println("2. 저녁메뉴");
			String select = ssc.next();
			network.send(sc, select);
			
			network.receive(sc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}

}
