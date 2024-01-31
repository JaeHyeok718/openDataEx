//package com.kh.opendata;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.text.DateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Locale;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.kh.opendata.model.vo.AirVo;
//
///**
// * Handles requests for the application home page.
// */
//
//
//@Controller
//public class HomeController {
//	public static final String SERVICEKEY = "dOXGzcdHlIJiL54EsKqB9EH1oLRrtdY7oayBW1WtsAql0Con5gPFNZAWdfcZJKXuI1PC75Hilx6WjEnglbzKtA%3D%3D";
//
//	
//	@ResponseBody
//	@RequestMapping("air.do")
//	public ArrayList<AirVo> selectAir(String location) throws IOException {
//		
//		System.out.println(location);
//		// 자바에서 요청 및 응답데이터 추출해보기
//				// OPEN API에 요청할 URL 준비하기
//				String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
//				url += "?serviceKey=" + SERVICEKEY; // 서비스키 추가
//				url += "&sidoName=" + URLEncoder.encode("서울", "UTF-8"); // 요청 시 전달값에 한글이 포함되어 있다면 encoding처리 해주기
//				url += "&returnType=json";
//				
//				// 요청하고자 하는 url을 전달하면서 URL객체를 생성한다
//				URL requestUrl = new URL(url);
//				
//				
//				// HttpUrlConnection 객체를 이용하여 api 요청 작업을 수행한다
//				HttpURLConnection urlCon = (HttpURLConnection)requestUrl.openConnection();
//				
//				// 요청에 필요한 설정 해주기 (get) header method 설정
//				urlCon.setRequestMethod("GET"); // get방식 요청 설정
//				
//				// 해당 openApi 서버로 요청 후 연결스트림을 이용하여 응답 데이터 읽어오기(추출)
//				BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
//				
//				// 연결된 스트림을 이용하여 각 데이터 읽어오기
//				String responseText = "";
//				String line;
//				// 더이상 읽을 데이터가 없으면 null을 반환 null을 읽어올 때까지 문자열 읽어오기 작업
//				while ((line = br.readLine()) != null) { // br.readLine() 이 수행되면 한줄을 읽어버리기 때문에 변수 처리해야한다
//					responseText += line;
//				}
//				
//				JsonObject jobj = new JsonParser().parse(responseText).getAsJsonObject();
//				
//		
//				JsonObject response = jobj.getAsJsonObject("response");
//
//
//				JsonObject body = response.getAsJsonObject("body");
//
//				JsonArray items = body.getAsJsonArray("items");
//				
//				ArrayList<AirVo> list = new ArrayList<>();
//				
//				for (int i = 0; i < items.size(); i++) {
//					
//					AirVo air = new AirVo();
//					
//
//					JsonObject item = items.get(i).getAsJsonObject();
//					
//					air.setCoValue(item.get("coValue").getAsString());
//					air.setDataTime(item.get("dataTime").getAsString());
//					air.setKhaiValue(item.get("khaiValue").getAsString());
//					air.setNo2Value(item.get("no2Value").getAsString());
//					air.setO3Value(item.get("o3Value").getAsString());
//					air.setPm10Value(item.get("pm10Value").getAsString());
//					air.setSidoName(item.get("sidoName").getAsString());
//					air.setSo2Value(item.get("so2Value").getAsString());
//					air.setStationName(item.get("stationName").getAsString());
//					
//					list.add(air);
//				}			
//				br.close();
//				urlCon.disconnect();
//					
//					return list;
//	}
//	
//	
//
//
//}
