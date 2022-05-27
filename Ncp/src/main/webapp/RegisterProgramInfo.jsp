<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>서원대학교</title>
<link rel="stylesheet" type="text/css" href="css/Base.css" />
<link rel="stylesheet" type="text/css" href="css/Main.css" />
<link rel="stylesheet" type="text/css" href="css/Main_Content.css" />
<link rel="stylesheet" type="text/css" href="css/LoginPopup.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
	integrity="sha512-rqQltXRuHxtPWhktpAZxLHUVJ3Eombn3hvk9PHjV/N5DMUYnzKPC1i3ub0mEXgFzsaZNeJcoE0YHq0j/GFsdGg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" type="text/css"
	href="css/RegisterProgramInfo.css" />
<link rel="stylesheet" type="text/css" href="css/Spinner.css" />
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
					<div class="info_text_area">
						<img
							src="https://semsplus.seowon.ac.kr/contents/images/client/sub/icon_tit_lg.png" />
						<h3 class="info_text">비교과 프로그램 기본 정보 등록</h3>
					</div>

					<jsp:include page="Spinner.jsp" />

					<div id="tableArea" class="tableArea show">
						<div>
							<table>
								<tbody>
									<tr>
										<th>프로그램 코드</th>
										<td><input id="code" type="text" name="code"
											value="${program.code }" readonly="readonly" /></td>
										<th>프로그램 명</th>
										<td><input id="program_name" type="text"
											name="program_name" value="${program.program_name }" /></td>
									</tr>
									<tr>
										<th>운영 유형</th>
										<td><select id="operating_type" name="operating_type">
												<c:forEach items="${operatingTypeList}" var="operatingType"
													varStatus="status">
													<c:choose>
														<c:when
															test="${operatingType.code eq program.operating_type }">
															<option value="${operatingType.code }" selected>
																<c:out value="${operatingType.category_name }" />
															</option>
														</c:when>
														<c:otherwise>
															<option value="${operatingType.code }">
																<c:out value="${operatingType.category_name }" />
															</option>
														</c:otherwise>
													</c:choose>

												</c:forEach>
										</select></td>
										<th>이수시간</th>
										<td><input id="completation_time" type="number"
											name="completation_time"
											value="${program.completation_time }" /> 시간</td>
									</tr>
									<tr>
										<th>대분류</th>
										<td><select id="category_large" name="category_large" onchange="onChange();">
												<c:forEach items="${largeCategoryList}" var="largeCategory"
													varStatus="status">
													<c:choose>
														<c:when
															test="${largeCategory.code eq program.category_large}">
															<option value="${largeCategory.code }" selected>
																<c:out value="${largeCategory.category_name }" />
															</option>
														</c:when>
														<c:otherwise>
															<option value="${largeCategory.code }">
																<c:out value="${largeCategory.category_name }" />
															</option>
														</c:otherwise>
													</c:choose>

												</c:forEach>
										</select> 중분류 <select id="category_middle" name="category_middle" onchange="onChange();">
												<c:forEach items="${middleCategoryList}"
													var="middleCategory" varStatus="status">
													<c:choose>
														<c:when
															test="${middleCategory.code eq program.category_middle}">
															<option value="${middleCategory.code }" selected>
																<c:out value="${middleCategory.category_name }" />
															</option>
														</c:when>
														<c:otherwise>
															<option value="${middleCategory.code }">
																<c:out value="${middleCategory.category_name }" />
															</option>
														</c:otherwise>
													</c:choose>

												</c:forEach>
										</select></td>
										<th>연계직무</th>
										<td><select id="related_NCS_part" name="related_NCS_part">
												<c:forEach items="${ncsList}" var="ncs" varStatus="status">
													<c:choose>
														<c:when test="${ncs.code eq program.related_NCS_part}">
															<option value="${ncs.code }" selected>
																<c:out value="${ncs.category_name }" />
															</option>
														</c:when>
														<c:otherwise>
															<option value="${ncs.code }">
																<c:out value="${ncs.category_name }" />
															</option>
														</c:otherwise>
													</c:choose>

												</c:forEach>
										</select></td>
									</tr>
									<tr>
										<th>선수 프로그램</th>
										<td><select id="previous_program" name="previous_program">
												<option value="0"><c:out value="없음" /></option>
												<c:forEach items="${programList}" var="program"
													varStatus="status">
													<option value="${program.code }">
														<c:out value="${program.program_name }" />
													</option>
												</c:forEach>
										</select></td>
										<th>사후 프로그램</th>
										<td><select id="after_program" name="after_program">
												<option value="0"><c:out value="없음" /></option>
												<c:forEach items="${programList}" var="program"
													varStatus="status">
													<option value="${program.code }">
														<c:out value="${program.program_name }" />
													</option>
												</c:forEach>
										</select></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div>
							<table>
								<tbody>
									<tr>
										<th colspan="7">관련 TALENT 역량</th>
									</tr>
									<tr>
										<th>역량명</th>
										<td>의사소통 역량</td>
										<td>리더쉽 역량</td>
										<td>자기관리 역량</td>
										<td>문제해결 역량</td>
										<td>글로컬 역량</td>
										<td>현장실무 역량</td>
									</tr>
									<tr>
										<th>반영률</th>
										<td><input id="TALENT_capability_01" type="number"
											name="TALENT_capability_01" value="${TALENT_capability[0] }" />
										</td>
										<td><input id="TALENT_capability_02" type="number"
											name="TALENT_capability_02" value="${TALENT_capability[1] }" />
										</td>
										<td><input id="TALENT_capability_03" type="number"
											name="TALENT_capability_03" value="${TALENT_capability[2] }" />
										</td>
										<td><input id="TALENT_capability_04" type="number"
											name="TALENT_capability_04" value="${TALENT_capability[3] }" />
										</td>
										<td><input id="TALENT_capability_05" type="number"
											name="TALENT_capability_05" value="${TALENT_capability[4] }" />
										</td>
										<td><input id="TALENT_capability_06" type="number"
											name="TALENT_capability_06" value="${TALENT_capability[5] }" />
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div>
							<table>
								<tbody>
									<tr>
										<th>프로그램 목표</th>
										<td><textarea id="program_gaol" name="program_goal"
												placeholder="입력하세요"><c:out
													value="${program.program_goal }"></c:out></textarea></td>
									</tr>
									<tr>
										<th>프로그램 세부내용</th>
										<td><textarea id="program_detail" name="program_detail"
												placeholder="입력하세요"><c:out
													value="${program.program_detail }"></c:out></textarea></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="btnArea">
							<c:choose>
								<c:when test="${not empty program.code}">
									<button id="btnRemove" class="btnRemove"
										onclick="deleteProgramInformation();">삭제</button>
									<button id="btnRegister" class="btnRegister"
										onclick="updateProgramInformation();">수정</button>
								</c:when>
								<c:otherwise>
									<button id="btnRegister" class="btnRegister"
										onclick="insertProgramInformation();">등록</button>
								</c:otherwise>
							</c:choose>
						</div>
					</div>

				</div>
			</section>
		</div>
	</main>
	<jsp:include page="SitemapPopup.jsp" />
	<jsp:include page="LoginPopup.jsp" />

	<script src="js/SitemapPopup.js"></script>
	<script src="js/LoginPopup.js"></script>
	<script src="js/RegisterProgramInfo.js"></script>
</body>
</html>
