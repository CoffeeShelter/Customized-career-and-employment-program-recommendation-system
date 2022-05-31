<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" integrity="sha512-rqQltXRuHxtPWhktpAZxLHUVJ3Eombn3hvk9PHjV/N5DMUYnzKPC1i3ub0mEXgFzsaZNeJcoE0YHq0j/GFsdGg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" type="text/css" href="css/RegisterProgramInst.css" />
<script src="https://kit.fontawesome.com/46fda0e82e.js" crossorigin="anonymous"></script>
</head>
<body>

	<jsp:include page="TopArea.jsp">
		<jsp:param name="visual_image" value="https://semsplus.seowon.ac.kr/contents/images/client/main/img_mainvisual.png" />
	</jsp:include>

	<main class="main_contents">
		<div class="contents">
			<section>
				<div>
					<div class="info_text_area">
						<img src="https://semsplus.seowon.ac.kr/contents/images/client/sub/icon_tit_lg.png" />
						<h3 class="info_text">비교과 프로그램 개설 및 관리</h3>
					</div>
					<div>
						<input type="hidden" value="${programCode }" id="code" />
						<h4>1. 비교과 프로그램 개설 정보</h4>
						<div>
							<table>
								<tbody>
									<tr>
										<th>운영 부서</th>
										<td>교육혁신원</td>
										<th>회차 정보</th>
										<td>1회차</td>
									</tr>
									<tr>
										<th>프로그램 형식</th>
										<td>
											<input type="radio" value="0" name="program_type" />
											신규개설
											<input type="radio" value="1" name="program_type" checked="checked" />
											추가개설(다회차인 경우)
										</td>
										<th>운영 부서</th>
										<td>
											<select name="operating_department">
												<option value="01">창업지원센터</option>
											</select>
										</td>
									</tr>
									<tr>
										<th>운영 방식</th>
										<td>
											<c:forEach items="${operating_method_list }" var="operating_method">
												<c:choose>
													<c:when test="${programInst.operating_method eq operating_method.code }">
														<input type="radio" value="${operating_method.code }" name="operating_method" checked="checked" />
													</c:when>
													<c:otherwise>
														<input type="radio" value="${operating_method.code }" name="operating_method" />
													</c:otherwise>
												</c:choose>

												<c:out value="${operating_method.category_name }" />
											</c:forEach>
										</td>
										<th>담당자</th>
										<td>
											<select id="manager" name="manager">
												<c:forEach items="${managers }" var="manager">
													<option value="${manager.staff_id }">
														<c:out value="${manager.staff_name } (${manager.staff_id })" />
													</option>
												</c:forEach>
											</select>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div>
						<h4>2. 핵심 역량 및 마일리지</h4>
						<div>
							<div>
								<table>
									<tbody>
										<tr>
											<th>인증 여부</th>
											<td>
												<input type="checkbox" name="auth" value="" checked="checked" />
												미인증
												<input type="checkbox" name="auth" value="" />
												일반인증
												<input type="checkbox" name="auth" value="" />
												우수인증
												<input type="checkbox" name="auth" value="" />
												학생추천
											</td>
											<th>참여시간</th>
											<td>
												<input type="number" name="" value="1" placeholder="참여시간" />
												시간
											</td>
										</tr>
										<tr>
											<!-- 
											<th>운영 기간</th>
											<td>
												<select id="" name="">
													<option value="">선택하세요</option>
												</select>
											</td>
											 -->

											<th>CUKI 마일리지</th>
											<td colspan="3">
												<input type="number" name="" value="50" placeholder="CUKI 마일리지" />
												점
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div>
								<table>
									<tbody>
										<tr>
											<th colspan="2">민주시민</th>
											<th colspan="2">창의인재</th>
											<th colspan="2">실용인</th>
										</tr>
										<tr>
											<th>의사소통 역량%</th>
											<th>리더쉽 역량%</th>
											<th>자기관리 역량%</th>
											<th>문제해결 역량%</th>
											<th>글로컬 역량%</th>
											<th>현장실무 역량%</th>
										</tr>
										<tr>
											<td>
												<input type="number" name="capability" value="${TALENT_capability[0] }" />
											</td>
											<td>
												<input type="number" name="capability" value="${TALENT_capability[1] }" />
											</td>
											<td>
												<input type="number" name="capability" value="${TALENT_capability[2] }" />
											</td>
											<td>
												<input type="number" name="capability" value="${TALENT_capability[3] }" />
											</td>
											<td>
												<input type="number" name="capability" value="${TALENT_capability[4] }" />
											</td>
											<td>
												<input type="number" name="capability" value="${TALENT_capability[5] }" />
											</td>

										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div>
						<h4>3. 운영 내용</h4>
						<div>
							<div>
								<table>
									<tbody>
										<tr>
											<th>장소</th>
											<td>
												<input id="operating_department" type="text" name="" value="${programInst.operating_department }" />
											</td>
											<th>사전 공개 여부</th>
											<td>
												<input type="radio" value="" name="release" checked="checked" />
												공개
												<input type="radio" value="" name="release" />
												비공개
											</td>
											<th>모집 기간</th>
											<td>
												<input type="date" name="" id="" value="${programInst.start_day }" />
												~
												<input type="date" name="" id="" value="${programInst.start_day }" />
											</td>
										</tr>
										<tr>
											<th>모집 인원</th>
											<td>
												<input type="number" name="recuiting_number" min="0" value="${programInst.recuiting_number }" id="recuiting_number"/>
												명
											</td>
											<th>대기 인원</th>
											<td>27 명</td>
											<th>운영 기간</th>
											<td>
												<input type="date" name="" id="start_day" value="${programInst.start_day }" />
												~
												<input type="date" name="" id="end_day" value="${programInst.end_day }" />
											</td>
										</tr>
										<tr>
											<th>참여 대상</th>
											<td colspan="3">
												<input type="checkbox" name="target_grade" value="0" checked="checked" />
												전체
												<input type="checkbox" name="target_grade" value="1" />
												1학년
												<input type="checkbox" name="target_grade" value="2" />
												2학년
												<input type="checkbox" name="target_grade" value="3" />
												3학년
												<input type="checkbox" name="target_grade" value="4" />
												4학년
												<input type="checkbox" name="target_grade" value="8" />
												졸업자
											</td>

											<th>교육 시간</th>
											<td>
												<input type="time" name="start_time" id="start_time" value="${programInst.start_time }"/>
												~
												<input type="time" name="end_time" id="end_time" value="${programInst.end_time }"/>
											</td>
										</tr>
										<tr>
											<th>문의</th>
											<td colspan="5">
												<input type="text" name="" value="043-721-5474" />
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div>
								<table>
									<tbody>
										<tr>
											<th colspan="4">참여 대상</th>
										</tr>
										<tr>
											<th colspan="3">소속</th>
											<th>성별</th>
										</tr>
										<tr>
											<td>
												<div>
													단과대학 <select id="college_information" name="college_information">
														<c:forEach items="${college_information_list }" var="college_information">
															<c:choose>
																<c:when test="${programInst.college_number eq college_information.code }">
																	<option value="${college_information.code }" selected="selected">
																		<c:out value="${college_information.category_name }" />
																	</option>
																</c:when>
																<c:otherwise>
																	<option value="${college_information.code }">
																		<c:out value="${college_information.category_name }" />
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
											</td>
											<td>
												<div>
													학부 <select id="department_information" name="department_information">
														<c:forEach items="${department_information_list }" var="department_information">
															<c:choose>
																<c:when test="${programInst.department_number eq department_information.code }">
																	<option value="${department_information.code }" selected="selected">
																		<c:out value="${department_information.category_name }" />
																	</option>
																</c:when>
																<c:otherwise>
																	<option value="${department_information.code }">
																		<c:out value="${department_information.category_name }" />
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
											</td>
											<td>
												<div>
													학부/전공 <select id="major_information" name="major_information">
														<c:forEach items="${major_information_list }" var="major_information">
															<c:choose>
																<c:when test="${programInst.major_number eq major_information.code }">
																	<option value="${major_information.code }" selected="selected">
																		<c:out value="${major_information.category_name }" />
																	</option>
																</c:when>
																<c:otherwise>
																	<option value="${major_information.code }">
																		<c:out value="${major_information.category_name }" />
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
											</td>
											<td>
												<div>
													<select id="target_sex" name="target_sex">
														<c:forEach items="${student_sex_list }" var="student_sex">
															<c:choose>
																<c:when test="${programInst.target_sex eq student_sex.code }">
																	<option value="${student_sex.code }" selected="selected">
																		<c:out value="${student_sex.category_name }" />
																	</option>
																</c:when>
																<c:otherwise>
																	<option value="${student_sex.code }">
																		<c:out value="${student_sex.category_name }" />
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div>
						<h4>4. 운영 결과</h4>
						<div>
							<table>
								<tbody>
									<tr>
										<th>참여 인원</th>
										<td>
											<input type="number" id="participation_number" name="participation_number" min="0" value="${programInst.participation_number }" />
										</td>
									</tr>
									<tr>
										<th>운영 평가</th>
										<td>
											<textarea name="" id="operating_result" placeholder="평가 내용을 입력해주세요"><c:out value="${programInst.operating_result }" /></textarea>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="btnArea">
						<c:choose>
							<c:when test="${not empty programInst}">
								<button id="btnRegister" class="btnRegister" onclick="updateProgramInstance();">수정</button>
							</c:when>
							<c:otherwise>
								<button id="btnRegister" class="btnRegister" onclick="insertProgramInstance();">등록</button>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</section>
		</div>
	</main>

	<jsp:include page="SitemapPopup.jsp" />
	<jsp:include page="LoginPopup.jsp" />

	<script src="js/RegisterProgramInstance.js"></script>
	<script src="js/SitemapPopup.js"></script>
	<script src="js/LoginPopup.js"></script>
</body>
</html>
