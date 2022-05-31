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
					<a onclick="createInstance();">신규 개설</a>
					<i class="fa-solid fa-plus"></i>
				</div>
				
				<div class="inner-middle">
					<h4><c:out value="${program.program_name }"/></h4>
				</div>
				
				<div class="inner-right">
					<p>조회</p>
					<input type="date" name="query">
				</div>
			</div>
			<input type="hidden" class="programCode" id="programCode" value="${program.code }"/>
			<div class="instList-wrap">
				<table>
					<thead>
						<tr>
							<th rowspan="2">No</th>
							<th colspan="2">개설 날짜</th>
							<th colspan="2">강의 시간</th>
							<th rowspan="2">운영 방식</th>
							<th rowspan="2">평가 상태</th>
						</tr>
						<tr>
							<th>시작</th>
							<th>종료</th>
							<th>시작</th>
							<th>종료</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty programInst }">
								<c:forEach	items="${programInst }" var="inst" varStatus="status">
									<tr id="instList-item" class="instList-item" ondblclick="updateInstance(this)">
										<td><c:out value="${status.count }" /></td>
										<td><c:out value="${inst.start_day }" /></td>
										<td><c:out value="${inst.end_day }" /></td>
										<td><c:out value="${inst.start_time }" /></td>
										<td><c:out value="${inst.end_time }" /></td>
										<td><c:out value="${inst.operating_method }" /></td>
										<c:choose>
											<c:when test="${inst.operating_result eq '' or empty inst.operating_result }">
												<td><i class="fa-solid fa-xmark" style="color:red;"></i></td>
											</c:when>
											<c:otherwise>
												<td><i class="fa-solid fa-check ok" style="color:green;"></i></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="7">
										개설 이력이 없습니다.
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
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
