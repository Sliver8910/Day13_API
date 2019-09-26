package com.ruda.n2.member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.ruda.n2.Server3;
import com.ruda.n2.network.Network;

public class MemberService {

	public ArrayList<Member> init() throws Exception {
		//파일의 내용을 읽어서 파싱 작업
		File file = new File("c:\\test","member.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		boolean check = true;
		ArrayList<Member> members = new ArrayList<Member>();
		while(check) {
			String str = br.readLine();
			if(str==null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(str,",");
			while(st.hasMoreTokens()) {
				Member member = new Member();
				member.setId(st.nextToken().trim());
				member.setPw(st.nextToken().trim());
				members.add(member);
			}
		}
		return members;

	}
	public void memerLogin(String yid, String ypw, ArrayList<Member> members, Socket sc) throws Exception {
		//id와, pw를 매개변수로 받아서 로그인 유무를 검증
		Network network = new Network();
		Member member = new Member();
		String str = "로그인 성공";
		String str2 = "로그인 실패";
		for(int i=0;i<members.size();i++) {
			if(members.get(i).getId().equals(yid) && members.get(i).getPw().equals(ypw)) {
				member = members.get(i);
				break;
			}else {
			}
			if(member != null) {
				network.send(sc, str);
			}else {
				network.send(sc, str2);
			}
		}

	}
}
