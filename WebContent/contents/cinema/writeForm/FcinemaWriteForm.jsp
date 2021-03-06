<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화관 추가</title>
<script src="<%=request.getContextPath() %>/contents/main/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%@include file="../../common/loginbar.jsp" %>
		<main>
		<%@include file="../../common/header.jsp" %>
	<div style="width: 800px; position: absolute; left:25%;">
	<form name="insertCinema" action="<%= request.getContextPath() %>/InsertFCinema.do" method="post"  id="insert">
	
	
		<label>지점명 : </label><input type="text" size = "50"name="cinema_name" id="cinema_name"><br>
		<label>소개글 : </label><input type="text" size ="50" name="topic" id ="topic"><br>
		<label>지역 : </label><input type="text" size ="30" name="area" id="area"><br>
		<label>영화관 사이트 : </label><input type="text" size ="50" name="site" id="site"><br>
		<label>길찾기 사이트 : </label><input type="text" size ="50" name="map" id="map"><br>
		<label>카테고리</label><br>
		<select name ="code" id="code">
			<option value="1">친구</option>
			<option value="2">연인</option>
			<option value="3">혼자</option>
		</select><br>
		
		<label>영화관</label><br>
		<select name ="company" id="company">
			<option value="cgv.png">CGV</option>
			<option value="megabox.png">MEGABOX</option>
		</select>
		<br><br>
		<fieldset>
			<label>층별 안내 작성</label><br>
			<textarea rows="10" cols="110" name="floor" id="floorarea" readonly="readonly" style="resize: none;"></textarea><br>
					<input type="text" size = "85" id="floortext">
			<button type="button"onclick="addFloor();">작성추가</button>
			<button type="button"onclick="resetFloor();">초기화</button><br>
			<br>
			<label>교통안내 작성</label>
			
			<br>
			<label>도로명 주소 : </label><input type="text" size = "90" name="adress" id="adress">
			
			<fieldset>
				<legend>주차</legend>
				<label>주차안내 </label><br>
					<textarea rows="5" cols="70" name="guide" id ="guide"style="resize: none;"></textarea><br>
				<label>주차확인 </label><br>
					<textarea rows="5" cols="70" name="confirm" id ="confirm"style="resize: none;"></textarea><br>
				<label>주차요금 </label><br>
				<div id="parking">
					<textarea rows="10" cols="70" name="pay" id="parkingarea" readonly="readonly" style="resize: none;"></textarea><br>
					<input type="text" size = "50" id="parkingtext">
					<button type="button"onclick="addParkingPay();">작성추가</button>
					<button type="button"onclick="resetParkingPay();">초기화</button>
				</div>
			</fieldset>
			
			<br>
			<legend>시설안내 작성</legend>
			<label>보유 시설 작성</label><br>
			
			<input type="checkbox" name="avail" value = "normal" checked><label>일반열람석</label>
			<input type="checkbox" name="avail" value = "disabled"><label>장애인석</label>
			<input type="checkbox" name="avail" value = "cafe"><label>카페</label>
			<input type="checkbox" name="avail" value = "sofa"><label>2인소파</label>
			<br>
			<br>
		</fieldset>
		
			<fieldset>
				<legend>대중교통</legend>
				<label>버스</label><br>
				<textarea rows="10" cols="110" name="bus" id ="busarea"readonly="readonly" style="resize: none;"></textarea><br>
				<input type="text" size = "85" id="bustext">
					<button type="button"onclick="addBus();">작성추가</button>
					<button type="button"onclick="resetBus();">초기화</button>
				<br>	
				<label>지하철</label><br>
				<textarea rows="10" cols="110" name="metro" id="metroarea"readonly="readonly" style="resize: none;"></textarea><br>
				<input type="text" size = "85" id="metrotext">
					<button type="button"onclick="addMetro();">작성추가</button>
					<button type="button"onclick="resetMetro();">초기화</button>
			</fieldset>
			<br><br>
			<div style="text-align: center;">
				
				<input type="button" id="submitBtn" value="버튼">
				<input type="button" id="cancelBtn" onclick="location.href='javascript:history.go(-1)'" value="취소하기">
			</div>
			<br><br>
	</form>
	</div>
	</main>
</body>
<script>
$('#submitBtn').click(function(){
	var flag=true;
	var msg = "빈곳인 ";
	if($.trim($('#cinema_name').val())==''){
		flag = false;
		msg += "지점명, ";
		console.log(msg);
	}
	if($.trim($('#topic').val())==''){
		flag = false;
		msg += "소개글, ";
		console.log(msg);
	}
	if($.trim($('#area').val())==''){
		flag = false;
		msg += "지역, ";
		console.log(msg);
	}
	if($.trim($('#site').val())==''){
		flag = false;
		msg += "영화관 사이트, ";
		console.log(msg);
	}
	if($.trim($('#code').val())==''){
		flag = false;
		msg += "길찾기 사이트, ";
		console.log(msg);
	}
	if($.trim($('#company').val())==''){
		flag = false;
		msg += "영화관, ";
		console.log(msg);
	}
	if($.trim($('#floorarea').val())==''){
		flag = false;
		msg += "층별안내, ";
		console.log(msg);
	}
	if($.trim($('#adress').val())==''){
		flag = false;
		msg += "도로명주소, ";
		console.log(msg);
	}
	if($.trim($('#guide').val())==''){
		flag = false;
		msg += "주차안내, ";
		console.log(msg);
	}
	if($.trim($('#confirm').val())==''){
		flag = false;
		msg += "주차확인, ";
		console.log(msg);
	}
	if($.trim($('#parkingarea').val())==''){
		flag = false;
		msg += "주차요금, ";
		console.log(msg);
	}
	if($.trim($('#metroarea').val())==''){
		flag = false;
		msg += "지하철, ";
		console.log(msg);
	}
	if($.trim($('#busarea').val())==''){
		flag = false;
		msg += "버스, ";
		console.log(msg);
	}
	msg += "를 입력해주세요";
	if(flag){
		$('#insert').submit();
	}else{
		alert(msg);
	}
});

	//주차
	function addParkingPay(){
		
		var parkingtext = document.getElementById('parkingtext');
		var parkingtextArea = document.getElementById('parkingarea');
		
		parkingtextArea.innerHTML += parkingtext.value  +">"+ "\n";
		parkingtext.value ="";
	};
	
	function resetParkingPay(){
		var parkingtextArea = document.getElementById('parkingarea');
		parkingtextArea.innerHTML = "";
		
	};
	//층별
	function addFloor(){
		
		var text = document.getElementById('floortext');
		var textArea = document.getElementById('floorarea');
		
		textArea.innerHTML += text.value  +">"+ "\n";
		text.value ="";
	};
	
	function resetFloor(){
		var textArea = document.getElementById('floorarea');
		textArea.innerHTML = "";
		
	};
	//버스
	function addBus(){
		
		var text = document.getElementById('bustext');
		var textArea = document.getElementById('busarea');
		
		textArea.innerHTML += text.value  +">"+ "\n";
		text.value ="";
	};
	
	function resetBus(){
		var textArea = document.getElementById('busarea');
		textArea.innerHTML = "";
		
	};
	//지하철
	function addMetro(){
		
		var text = document.getElementById('metrotext');
		var textArea = document.getElementById('metroarea');
		
		textArea.innerHTML += text.value  +">"+ "\n";
		text.value ="";
	};
	
	function resetMetro(){
		var textArea = document.getElementById('metroarea');
		textArea.innerHTML = "";
		
	};
	
</script>

</html>