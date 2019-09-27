package com.ruda.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		//ServerSocket
		//Socket
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner ssc = new Scanner(System.in);
		String str = null;
		try {
			ss = new ServerSocket(8282);
			boolean check = true;
			while(check) {
				System.out.println("클라이언트 접속 받을 준비중");
				sc = ss.accept();
				is = sc.getInputStream();//byte
				ir = new InputStreamReader(is);//char
				br = new BufferedReader(ir); //char를 모아서 String으로 만들어줌
				str = br.readLine();
				System.out.println(str);
				if(str.toUpperCase().equals("END")) {
					break;
					}

				System.out.println("클라이언트로 전송할 메세지 입력");
				str = ssc.next();
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(str+"\r\n");
				bw.flush();
				System.out.println("클라이언트로 전송 완료");
				if(str.toUpperCase().equals("END")) {
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
				ow.close();
				os.close();
				br.close();
				ir.close();
				is.close();
				sc.close();
				ss.close();
				ssc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

}
