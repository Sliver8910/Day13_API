package com.ruda.n2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.ruda.n2.member.Member;
import com.ruda.n2.member.MemberService;
import com.ruda.n2.network.Network;

public class Server3 {

	public static void main(String[] args) {
		// id, pw를 분리
		//ArrayList<Member>
		ServerSocket ss =null;
		Socket sc = null;
		Network network = new Network();
		MemberService memberService = new MemberService();
		try {
			ss= new ServerSocket(8282);
			sc = ss.accept();
			String ym = network.receive(sc);
			String [] sm = ym.split(",");
			String yid = sm[0];
			String ypw = sm[1];
			ArrayList<Member> members = memberService.init();
			Member m = memberService.memerLogin(yid, ypw, members);
			String msg = "0";
			if(m != null) {
				msg = "1"; //로그인 성공
			}
			network.send(sc, msg);
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
