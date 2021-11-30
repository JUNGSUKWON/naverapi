package naverapi;

import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import dto.NaverApiDTO;

// 메인에 있는 네이버 API 소스들을 클래스를 만들어서 다 옮기고
// 메인에서는 검색어만 전달하면 결과가 나오게 만들기

// 맛집을 찾아 주는 앱이라 생각하고 json 형식의 데이터로 받는데
// 너무 복잡하네..
// 제목, 링크, 날짜만 가져와서 보기 좋게 출력 해보자
// 제목: 여기 맞집
// 링크: https://sa;dfkjsajdf
// 날짜: 20211129
// 어렵지만 어떻게 해야 될지 고민 또는 검색을 통해서 할 수 있는 사람은 해보기

public class MainClass {

	static NaverAPI nv = new NaverAPI();
	public static void main(String[] args) {
		
		//번호를 정해서 그 번호로 검색하게 한다.
		String responseBody=searchNumber();
//		String responseBody = nv.searchNews("코로나");
//    	String responseBody = nv.searchBlog("놀러갈만한곳");
//    	String responseBody = nv.searchMovie("줄리아 로버츠");
//    	String responseBody = nv.searchBook("힐링");
//		System.out.println(responseBody);
		ArrayList<NaverApiDTO>list = nv.getListJson(responseBody);
		for(NaverApiDTO dto:list) {
			
			System.out.print("제목: ");
			System.out.println(dto.getTitle());
			System.out.print("링크");
			System.out.println(dto.getLink());
			System.out.print("날짜");
			System.out.println(dto.getPubDate());
			System.out.println();
		}
	}

	private static String searchNumber() {
		
		System.out.println("1번부터 4번까지 검색하고 싶은 번호를 입력해주세요 (1뉴스 2블로그 3영화 4책");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		if(number==1) {
			System.out.println("검색하고 싶은 키워드를 입력해주세요:");
			String search = sc.next();
			return nv.searchNews(search);
		}else if(number==2) {
			System.out.println("검색하고 싶은 키워드를 입력해주세요:");
			String search = sc.next();
			return nv.searchBlog(search);
		}else if(number==3) {
			System.out.println("검색하고 싶은 키워드를 입력해주세요:");
			String search = sc.next();
			return nv.searchMovie(search);
		}else if(number==4) {
			System.out.println("검색하고 싶은 키워드를 입력해주세요:");
			String search = sc.next();
			return nv.searchBook(search);
		}
		
		return null;
	}


}
