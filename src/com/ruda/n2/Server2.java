package com.ruda.n2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;


public class Server2 { 
	public static void main(String[] args) {
		//1번을 클릭하면 lunch.txt를 불러와서 하나를 무작위로 골라서 전송
		//2번을 클릭하면 dinner.txt를 불러와서 하나를 무작위로 골라서 전송

		ServerSocket ss = null;
		Socket sc = null;
		InputStream is = null;
		InputStreamReader ir= null;
		BufferedReader br = null;
		File file = null;
		FileReader fr = null;
		boolean check = true;
		StringTokenizer st = null;
		ArrayList<String> ar = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		String select1 = null;
		int select =0;
		System.out.println("클라이언트 접속 받을 준비중");
		try {
			ss= new ServerSocket(8282);
			sc= ss.accept();
			is = sc.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			//select = br.read();
			select1 = br.readLine();
			select = Integer.parseInt(select1);

			switch (select) {
			case 1:
				file = new File("c:\\test","lunch.txt");
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				check = true;
				ar = new ArrayList<String>();
				while(check) {
					String str = br.readLine();
					if(str==null) {
						break;
					}
					st = new StringTokenizer(str,"-");
					while(st.hasMoreTokens()) {
						ar.add(st.nextToken());
					}
				}
				Random random = new Random();
				int num = random.nextInt(ar.size());
				System.out.println(ar.get(num));

				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(ar.get(num)+"\r\n");
				bw.flush();
				break;

			default:
				file = new File("c:\\test","dinner.txt");
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				check = true;
				ar = new ArrayList<String>();
				while(check) {
					String str = br.readLine();
					if(str==null) {
						break;
					}
					st = new StringTokenizer(str,",");
					while(st.hasMoreTokens()) {
						ar.add(st.nextToken().trim());
					}
				}
				random = new Random();
				num = random.nextInt(ar.size());
				System.out.println(ar.get(num));
				os = sc.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(ar.get(num)+"\r\n");
				bw.flush();
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bw.close();
				ow.close();
				os.close();
				br.close();
				fr.close();
				ir.close();
				is.close();
				sc.close();
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
