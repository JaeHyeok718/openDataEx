<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
				<body>
				
					<h2>지진해일대피소 정보</h2>
				
				<input type="button" value="실행" id="btn2">
				
				<table id="result2" border="1">
				
				<thead>
				
				<th>일련번호</th>
				
				<th>시도명</th>
				
				<th>시군구명</th>
				
				<th>대피장소명</th>
				
				<th>주소</th>
				
				<th>수용가능인원(명)</th>
				
				<th>해변으로부터의거리</th>
				
				<th>대피소분류명</th>
				
				</thead>
				
				<tbody>
				
				</tbody>
				
				</table>
				
				<script>
				
	$(function() {
				
				$("#btn2").click(function() {
				
				$.ajax({
				
				url : "disaster.do",
				
				type : "get",
				
				success : function(data) {
				console.log(itemArr);
				var itemArr = data.TsunamiShelter[1].row;
				
				var value = "";
				
				for(var i = 0; i < itemArr.length; i++) {
				
				var item = itemArr[i];
						
						value += "<tr>"
						
						+ "<td>" + item.id + "</td>"
						
						+ "<td>" + item.sido_name + "</td>"
						
						+ "<td>" + item.sigungu_name + "</td>"
						
						+ "<td>" + item.shel_nm + "</td>"
						
						+ "<td>" + item.address + "</td>"
						
						+ "<td>" + item.shel_av + "</td>"
						
						+ "<td>" + item.lenth + "</td>"
						
						+ "<td>" + item.shel_div_type + "</td>"
						
						+ "</tr>"
						
						}
				
				$("#result2 tbody").html(value);
				
				},
				error : function() {
				
				console.log("ajax 통신 실패!")
				
				}
				
				});
				
				});
				
				});
				




	
	</script>
	
</body>
</html>