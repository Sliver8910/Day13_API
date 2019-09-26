package com.ruda.n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		//1단계 
		Socket sc = null;
		//Socket sc1 = null;
		//ServerSocket ss = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		String str = null;
		Scanner ssc = new Scanner(System.in); 
		try {
			sc = new Socket("211.238.142.21", 8282);
			boolean check = true;
			while(check) {
				System.out.println("서버로 전송할 메세지 입력");
				str = ssc.next();
				os = sc.getOutputStream();//byte
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(str+"\r\n");
				bw.flush();
				System.out.println("서버로 전송 완료");
				if(str.toUpperCase().equals("END")) {
					break;
				}

				System.out.println("서버 접속 받을 준비중");
				is = sc.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				str = br.readLine();
				System.out.println(str);

				if(str.toUpperCase().equals("END")) {
					break;
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();

				bw.close();
				ow.close();
				os.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

