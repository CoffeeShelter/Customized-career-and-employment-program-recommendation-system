<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="rlogic.Rlogic"%>
<%@ page import="java.util.Vector"%>
<%@ page import="data.RecommendationResult"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>서원대학교</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="css/Main.css" />
<link rel="stylesheet" type="text/css" href="./css/MyPage.css" />
<link rel="stylesheet" type="text/css" href="css/LoginPopup.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" integrity="sha512-rqQltXRuHxtPWhktpAZxLHUVJ3Eombn3hvk9PHjV/N5DMUYnzKPC1i3ub0mEXgFzsaZNeJcoE0YHq0j/GFsdGg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://kit.fontawesome.com/46fda0e82e.js" crossorigin="anonymous"></script>
</head>
<body>
	<%
	Vector<Vector<RecommendationResult>> results = (Vector<Vector<RecommendationResult>>) request.getAttribute("results");
	%>
	<jsp:include page="TopArea.jsp" />

	<main class="main_contents">
		<div class="contents">
			<section class="section_marea">
				<div class="info_text_area">
					<img src="https://semsplus.seowon.ac.kr/contents/images/client/sub/icon_tit_lg.png" />
					<h3 class="info_text">기본 정보</h3>
				</div>

				<div class="base_info_table">
					<table>
						<tbody>
							<tr>
								<th>단과대학</th>
								<td>미디어융합대학</td>
								<th>소속</th>
								<td>소프트웨어학부 (컴퓨터공학)</td>
							</tr>
							<tr>
								<th>부/복수/연계/융합전공</th>
								<td></td>
								<th>학년</th>
								<td>4학년</td>
							</tr>
							<tr>
								<th>학번</th>
								<td>201711245</td>
								<th>이름</th>
								<td>이주훈(남성)</td>
							</tr>
							<tr>
								<th>연락처</th>
								<td>010-3685-2935</td>
								<th>이메일</th>
								<td>ij238950@gmail.com</td>
							</tr>
							<tr>
								<th>주소</th>
								<td colspan="3">충청북도 청주시 흥덕구 덕암로108번길 44</td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>

			<section class="section_area">
				<div class="recommendation_result_area">
					<div class="info_text_area">
						<img src="https://semsplus.seowon.ac.kr/contents/images/client/sub/icon_tit_lg.png" />
						<h3 class="info_text">비교과 프로그램 추천 목록</h3>
					</div>

					<%
					for (Vector<RecommendationResult> datum : results) {
					%>
					<div class="recommendation_result">
						<p>최하위 역량(1) (진로탐색)_준비도: 67.1%</p>

						<div class="recommendation_result_table_area">
							<table>
								<tbody>
									<tr>
										<th rowspan="2">프로그램 코드</th>
										<th colspan="2">프로그램 단계</th>
										<th colspan="3">프로그램 세부내용</th>
										<th rowspan="2">운영 상황</th>
										<th rowspan="2">최종 적합도</th>
									</tr>
									<tr>
										<th>대분류</th>
										<th>중분류</th>
										<th>프로그램명</th>
										<th>운영기간</th>
										<th>이수시간</th>
									</tr>

									<%
									for (RecommendationResult result : datum) {
									%>
									<tr>
										<td><%=result.getProgramCode()%></td>
										<td><%=result.getLargeCategory()%></td>
										<td><%=result.getMiddleCategory()%></td>
										<td><%=result.getProgramName()%></td>
										<td><%=result.getOpenTerm()%>
											학기
										</td>
										<td><%=result.getCompletationTime()%></td>
										<td><%=result.getOperatingState()%></td>
										<td><%=result.getRecommendationDegree()%>
											%
										</td>
									</tr>
									<%
									}
									%>
								</tbody>
							</table>
						</div>
					</div>

					<%
					}
					%>

				</div>
			</section>
		</div>
	</main>

	<jsp:include page="SitemapPopup.jsp" />
	<jsp:include page="LoginPopup.jsp" />

	<script src="js/SitemapPopup.js"></script>
	<script src="js/LoginPopup.js"></script>
</body>
</html>
