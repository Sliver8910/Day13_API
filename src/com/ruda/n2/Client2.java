package com.ruda.n2;

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

public class Client2 {

	public static void main(String[] args) {
		//1.점심메뉴
		//2.저녁메뉴
		Scanner ssc = new Scanner(System.in);
		Socket sc = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		String str = null;
		int select = 0;
		String select1 = null;

		try {
			sc = new Socket("211.238.142.21", 8282);
			System.out.println("1. 점심메뉴");
			System.out.println("2. 저녁메뉴");
			//select = ssc.nextInt();
			select1 = ssc.next();
			select = Integer.parseInt(select1);
			switch (select) {
			case 1:
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(select+"\r\n");
				bw.flush();
				break;
				
			case 2:
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(select+"\r\n");
				bw.flush();
				break;
				
			default:
				System.out.println("1~2사이의 숫자를 입력하시오");
				break;	
			}
			is = sc.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			str = br.readLine();
			System.out.println(str);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				ssc.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
