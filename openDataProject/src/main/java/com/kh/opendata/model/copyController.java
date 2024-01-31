/*
 * package com.kh.opendata.model;
 * 
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.io.InputStreamReader; import java.net.HttpURLConnection; import
 * java.net.URL; import java.net.URLEncoder; import java.util.ArrayList;
 * 
 * import org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * import com.google.gson.JsonArray; import com.google.gson.JsonObject; import
 * com.google.gson.JsonParser; import com.kh.opendata.model.vo.AirVo;
 * 
 * public class copyController { public static final String SERVICEKEY =
 * "dOXGzcdHlIJiL54EsKqB9EH1oLRrtdY7oayBW1WtsAql0Con5gPFNZAWdfcZJKXuI1PC75Hilx6WjEnglbzKtA%3D%3D";
 * 
 * @ResponseBody
 * 
 * @RequestMapping(value = "disaster.do") public ArrayList<AirVo>
 * airPollution(String location) throws IOException {
 * 
 * System.out.println(location);
 * 
 * String url =
 * "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
 * 
 * url += "?serviceKey=" + SERVICEKEY;// 서비스키
 * 
 * url += "&sidoName=" + URLEncoder.encode(location, "UTF-8");// 벨류값
 * 
 * url += "&returnType=json";
 * 
 * url += "&numOfRows=20";
 * 
 * URL requestUrl = new URL(url);
 * 
 * HttpURLConnection urlConnection = (HttpURLConnection)
 * requestUrl.openConnection();
 * 
 * urlConnection.setRequestMethod("GET");
 * 
 * BufferedReader br = new BufferedReader(new
 * InputStreamReader(urlConnection.getInputStream()));
 * 
 * String responseText = "";
 * 
 * String line;
 * 
 * while ((line = br.readLine()) != null) {
 * 
 * responseText += line;
 * 
 * }
 * 
 * JsonObject totalObj = new JsonParser().parse(responseText).getAsJsonObject();
 * 
 * 
 * JsonObject responseObj = totalObj.getAsJsonObject("response");
 * 
 * JsonObject bodyObj = responseObj.getAsJsonObject("body");
 * 
 * JsonArray itemArr = bodyObj.getAsJsonArray("items");
 * 
 * ArrayList<AirVo> list = new ArrayList<>();
 * 
 * for (int i = 0; i < itemArr.size(); i++) {
 * 
 * AirVo air = new AirVo();
 * 
 * JsonObject item = itemArr.get(i).getAsJsonObject();
 * 
 * air.setStationName(item.get("stationName").getAsString());
 * 
 * air.setDataTime(item.get("dataTime").getAsString());
 * 
 * air.setKhaiValue(item.get("khaiValue").getAsString());
 * 
 * air.setPm10Value(item.get("pm10Value").getAsString());
 * 
 * air.setSo2Value(item.get("so2Value").getAsString());
 * 
 * air.setCoValue(item.get("coValue").getAsString());
 * 
 * air.setNo2Value(item.get("no2Value").getAsString());
 * 
 * air.setO3Value(item.get("o3Value").getAsString());
 * 
 * list.add(air);
 * 
 * } br.close();
 * 
 * urlConnection.disconnect();
 * 
 * for (AirVo a : list) {
 * 
 * System.out.println(a); System.out.println("뽑아와져?");
 * 
 * }
 * 
 * return list; } }
 */