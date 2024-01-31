package com.kh.opendata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.opendata.model.vo.AirVo;

import lombok.extern.slf4j.Slf4j;

@Controller
public class APIController {

	public static final String serviceKey = "tBhs%2BeP21YQWjouzL%2Bo61rme7aEi8MVhTCLRboQhhyuU1VlY2nvOraY2N8ul0OMFPUypbskeazz64VCcJqv4%2Bg%3D%3D";
	
	@ResponseBody
	@RequestMapping(value = "disaster.do", produces = "application/json; charset=UTF-8")
	public String getShelterList() throws IOException {

	String url = "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List";

	url += "?serviceKey="+serviceKey;

	url += "&type=json";

	url += "&pageNo=1";

	url += "&numOfRows=20";

	URL requestUrl = new URL(url);

	HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();

	urlConnection.setRequestMethod("GET");

	BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

	String responseText = "";

	String line;

	while((line = br.readLine()) != null) {

	responseText += line;

	}
System.out.println(responseText);
	return responseText;

	}

}
