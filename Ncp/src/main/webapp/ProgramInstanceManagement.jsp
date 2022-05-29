<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css" href="css/ProgramInstanceManagement.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" integrity="sha512-rqQltXRuHxtPWhktpAZxLHUVJ3Eombn3hvk9PHjV/N5DMUYnzKPC1i3ub0mEXgFzsaZNeJcoE0YHq0j/GFsdGg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://kit.fontawesome.com/46fda0e82e.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="TopArea.jsp">
		<jsp:param name="visual_image" value="https://semsplus.seowon.ac.kr/contents/images/client/main/img_mainvisual.png" />
	</jsp:include>

	<div class="main_content">
		<div class="contents">
			<div class="searchFormZone">
				<div class="inner-left">
					<a href="registerProgramInst?code=0">신규 개설</a>
					<i class="fa-solid fa-plus"></i>
				</div>
				
				<div class="inner-right">
					<p>조회</p>
					<input type="date" name="query">
				</div>
			</div>
			<div id="spinner" class="center show">
				<div class="ring">
				</div>
				<span>Loading...</span>
			</div>
			<div id="accordion" class="accordion"></div>
		</div>
	</div>

	<div class="footer"></div>

	<jsp:include page="SitemapPopup.jsp" />
	<jsp:include page="LoginPopup.jsp" />
</body>
<script src="js/ProgramInstanceManagement.js"></script>
<script src="js/SitemapPopup.js"></script>
<script src="js/LoginPopup.js"></script>
</html>
