package com.ruda.n2;


import java.net.Socket;

import java.util.Scanner;

import com.ruda.n2.network.Network;

public class Client3 {

	public static void main(String[] args) {
		// id입력
		// pw 입력
		// 서버로 전송
		Socket sc = null;
		Network network = new Network();
		
		try {
			sc = new Socket("211.238.142.21", 8282);
			Scanner ssc = new Scanner(System.in);
			System.out.println("id 입력");
			String yid = ssc.next();
			System.out.println("pw 입력");
			String ypw = ssc.next();
			String ym = yid+","+ypw;
			network.send(sc, ym);
			
			String str =network.receive(sc);
			if(str.equals("0")) {
				System.out.println("로그인 실패");
			}else {
				System.out.println("로그인 성공");
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
