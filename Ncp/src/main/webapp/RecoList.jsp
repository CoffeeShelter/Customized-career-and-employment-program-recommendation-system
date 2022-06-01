<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="rlogic.Recommendation_Program"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>서원대학교</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="./css/Base.css" />
<link rel="stylesheet" type="text/css" href="./css/MyPage.css" />
<link rel="stylesheet" type="text/css" href="./css/Reco.css" />
<link rel="stylesheet" type="text/css" href="css/Base.css" />
<link rel="stylesheet" type="text/css"
	href="css/RegisterProgramInfo.css" />
<link rel="stylesheet" type="text/css" href="css/Main.css" />
<link rel="stylesheet" type="text/css" href="css/Main_Content.css" />
<link rel="stylesheet" type="text/css" href="css/LoginPopup.css" />
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

	<main class="main_contents">
		<div class="contents">
			<section>
				<div>

					<div class="input_div_ex">
						<a class="input_label">프로그램 명</a>
						<div class="input_div_in">
							<input type="text" id="programName" name="programName"
								placeholder="프로그램명을 입력하세요" />
							<button class="btn" onclick="searchSBP();">검색</button>
						</div>
					</div>

					<div>

						<table>
							<thead>
								<tr>
									<th colspan='9'><strong id="targetProgram"><c:out
												value="${programName }" /></strong><br>프로그램 추천
										적합도 순위</th>
								</tr>
								<tr>
									<th>순번</th>
									<th>이름</th>
									<th>소속학과(코드)</th>
									<th>소속학과</th>
									<th>학번</th>
									<th>학년</th>
									<th>성별</th>
									<th>희망직무</th>
									<th>프로그램 추천 적합도</th>
								</tr>
							</thead>

							<tbody id="sbpTable">
								<c:if test="${not empty recoList }">
									<c:forEach items="${recoList }" var="reco" varStatus="status">
										<tr>
											<td><c:out value="${status.count }" /></td>
											<td><c:out value="${reco['name'] }" /></td>
											<td><c:out value="${reco['major_number'] }" /></td>
											<td><c:out value="${reco['major'] }" /></td>
											<td><c:out value="${reco['university_number'] }" /></td>
											<td><c:out value="${reco['grade'] }" /></td>
											<td><c:out value="${reco['sex'] }" /></td>
											<td><c:out value="${reco['ncp'] }" /></td>
											<td><c:out value="${reco['degree'] }" /> %</td>
										</tr>
									</c:forEach>
								</c:if>
								<c:if test="${empty recoList }">
									<tr>
										<td colspan="9">조회 결과가 없습니다.</td>
									</tr>
								</c:if>

							</tbody>

						</table>

					</div>
				</div>
			</section>
		</div>
	</main>

	<jsp:include page="SitemapPopup.jsp" />
	<jsp:include page="LoginPopup.jsp" />

	<script src="js/RecoList.js"></script>
</body>

<script src="js/SitemapPopup.js"></script>
<script src="js/LoginPopup.js"></script>
</html>
