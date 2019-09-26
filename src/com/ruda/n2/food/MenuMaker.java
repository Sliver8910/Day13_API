package com.ruda.n2.food;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class MenuMaker {

	private ArrayList<String> lunchs;
	private ArrayList<String> dinners;
	
	public String selectMenu(String select) {
		Random random = new Random();
		String menu = null;
		if(select.equals("1")) {
			menu = lunchs.get(random.nextInt(lunchs.size()));
			
		}else {
			menu = dinners.get(random.nextInt(dinners.size()));
		}
			return menu;
	}

	public void init() {
		this.lunchs = this.makeMenu("lunch.txt", "-");
		this.dinners = this.makeMenu("dinner.txt", ",");
	}



	public ArrayList<String> makeMenu(String filename, String delim) {
		BufferedReader br = null;
		File file = null;
		FileReader fr = null;
		boolean check = true;
		StringTokenizer st = null;

		file = new File("c:\\test", filename);
		ArrayList<String> ar = new ArrayList<String>();
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			check = true;
			
			while(check) {
				String str = br.readLine();
				if(str==null) {
					break;
				}
				st = new StringTokenizer(str, delim);
				while(st.hasMoreTokens()) {
					ar.add(st.nextToken().trim());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}

}
