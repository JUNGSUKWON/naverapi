package com.jsw.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Util {
	// 오늘 날짜를 가져 오는 메소드(yyyyMMdd)
	public static String getCurrentDate(String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		return sdf.format(new Date());
	}

	// 파일 읽어서 화면에 출력(파일 내용을 여기 메소드 밖으로 보내고 싶다.)
	public static String readLineFile(String filePath) {
		BufferedReader br = null;
		String retLine="";
		StringBuffer sb = new StringBuffer();

		try {
			br = new BufferedReader(new FileReader(filePath));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				//				retLine +=line +"\n";
				sb.append(line+"\n");
				//				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//		return retLine;
		return sb.toString();
	}
	//위 정보들을 라인이 아니라 ,를 구분자로 하여 분리
	public static void seperate(String filePath) {

		BufferedReader br = null;
		try {
			br = new BufferedReader (new FileReader(filePath));
			while(true) {

				String line = br.readLine();
				if (line == null) {
					break;
				}
				String[] array=new String[3] ;
				array=line.split(",");
				for(int i=0;i<array.length;i++) {
					System.out.print(array[i]+" ");
				}

				System.out.println();
				//				System.out.println(Arrays.toString(array));
			}
		}catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void mySplit(String str, String regex1, String regex2,int splitNum){

		String []strArr=str.split(regex1);
		//		System.out.println(ArrayList.toString(strArr));
		//		System.out.println(strArr.length);
		for(String s:strArr) {
			String [] tmp = s.split(regex2);
			for(int i=0;i<tmp.length;i++) {
				if(i==tmp.length-1) {
					System.out.println(tmp[i]);
				}
				else {
					System.out.print(tmp[i]+" ");
				}
			}
			System.out.println();
		}
	}


	// 파일 쓰기(새파일로 쓰기, 덮어쓰기)
	public static void writeLineFile(ArrayList<String> strList, String filePath) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(filePath);
			for(String s : strList) {
				out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	// 	파일 쓰기(이어 쓰기)
	public static void writeLineFile(ArrayList<String> strList, String filePath, boolean isAppend) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(filePath, isAppend));
			for(String s : strList) {
				out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}


}