package com.ruda.n1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		//1단계 
		Socket sc = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		Scanner ssc = new Scanner(System.in); 
		try {
			sc = new Socket("211.238.142.21", 8282);
			System.out.println("서버로 전송할 메세지 입력");
			String str = ssc.next();
			os = sc.getOutputStream();//byte
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			bw.write(str+"\r\n");
			bw.flush();
			System.out.println("서버로 전송 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
