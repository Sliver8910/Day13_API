package com.ruda.n2.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Network {
	
	public String send(Socket sc, String msg) throws Exception {
	OutputStream os = null;
	OutputStreamWriter ow = null;
	BufferedWriter bw = null;
	
	os = sc.getOutputStream();
	ow = new OutputStreamWriter(os);
	bw = new BufferedWriter(ow);
	bw.write(msg+"\r\n");
	bw.flush();
	
	return msg;
	}
	
	public String receive(Socket sc) throws Exception {
		InputStream is = null;
		InputStreamReader ir= null;
		BufferedReader br = null;
		
		is = sc.getInputStream();
		ir = new InputStreamReader(is);
		br = new BufferedReader(ir);
		String msg = br.readLine();
		
		return msg;
	}
}
