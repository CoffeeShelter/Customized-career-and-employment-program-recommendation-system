<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>서원대학교</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="css/Main.css" />
<link rel="stylesheet" type="text/css" href="css/MyPage.css" />
<link rel="stylesheet" type="text/css" href="css/LoginPopup.css" />
<link rel="stylesheet" type="text/css" href="css/ProgramManagement.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
	integrity="sha512-rqQltXRuHxtPWhktpAZxLHUVJ3Eombn3hvk9PHjV/N5DMUYnzKPC1i3ub0mEXgFzsaZNeJcoE0YHq0j/GFsdGg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://kit.fontawesome.com/46fda0e82e.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="TopArea.jsp">
		<jsp:param name="visual_image"
			value="https://semsplus.seowon.ac.kr/contents/images/client/main/img_mainvisual.png" />
	</jsp:include>

	<div class="main_content">
		<div class="contents">
			<div class="accordion">
				<input type="checkbox" id="pro01" /> 
				<label for="pro01">테스트 프로그램 01<i class="fa-solid fa-circle-arrow-down"></i></label>
				<div>
					<table>
						<tbody>
							<tr>
								<th>프로그램 코드</th>
								<td>00000</td>
							</tr>
							<tr>
								<th>프로그램 명</th>
								<td>테스트 프로그램 01</td>
							</tr>
							<tr>
								<th>운영 유형</th>
								<td>대면</td>
							</tr>
							<tr>
								<th>연계 직무</th>
								<td>IT/개발</td>
							</tr>
						</tbody>
					</table>
					<input type="button" value="수정" />
					<input type="button" value="개설" />
				</div>
				
				<input type="checkbox" id="pro02" /> 
				<label for="pro02">테스트 프로그램 02<i class="fa-solid fa-circle-arrow-down"></i></label>
				<div>
					<table>
						<tbody>
							<tr>
								<th>프로그램 코드</th>
								<td>11111</td>
							</tr>
							<tr>
								<th>프로그램 명</th>
								<td>테스트 프로그램 02</td>
							</tr>
							<tr>
								<th>운영 유형</th>
								<td>대면</td>
							</tr>
							<tr>
								<th>연계 직무</th>
								<td>IT/개발</td>
							</tr>
						</tbody>
					</table>
					<input type="button" value="수정" />
					<input type="button" value="개설" />
				</div>
			</div>
		</div>
	</div>

	<div class="footer"></div>

	<jsp:include page="SitemapPopup.jsp" />
	<jsp:include page="LoginPopup.jsp" />
</body>
<script src="js/SitemapPopup.js"></script>
<script src="js/LoginPopup.js"></script>
</html>
