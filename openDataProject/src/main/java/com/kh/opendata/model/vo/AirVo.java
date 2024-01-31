package com.kh.opendata.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AirVo {

	
	private String stationName;//측정소명
	private String dataTime;//측정일시
	private String sidoName;//시도이름
	private String khaiValue;//통함대기환경수치
	private String pm10Value;//미세먼지농도
	private String so2Value;//아황산가스 농도
	private String coValue;//일산화농도
	private String no2Value;//이산화질소 농도
	private String o3Value;
}
