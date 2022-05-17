<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>서원대학교</title>
<link rel="stylesheet" type="text/css" href="css/Base.css" />
<link rel="stylesheet" type="text/css" href="css/RegisterProgramInfo.css" />
</head>
<body>
	<div class="top_area">
		<div class="header_top">
			<img class="seowonLogo" src="https://semsplus.seowon.ac.kr/contents/images/client/common/header_logo.svg" />
		</div>

		<div class="header_bottom"></div>

		<div class="title_area">
			<h3>마이페이지</h3>
		</div>
	</div>

	<main class="main_contents">
		<div class="contents">
			<form action="/programs" method="post">
				<section>
					<div>
						<div>
							<p>비교과 프로그램 기본 정보 등록</p>
						</div>
						<div>
							<table>
								<tbody>
									<tr>
										<th>프로그램 코드</th>
										<td>
											<input type="text" name="code" />
										</td>
										<th>프로그램 명</th>
										<td>
											<input type="text" name="program_name" />
										</td>
									</tr>
									<tr>
										<th>프로그램 형식</th>
										<td>
											<select name="operation_type">
												<option value="none">선택하세요</option>
											</select>
										</td>
										<th>이수시간</th>
										<td>
											<select name="completation_time">
												<option value="none">선택하세요</option>
												<option value="1">1시간</option>
												<option value="2">2시간</option>
												<option value="3">3시간</option>
												<option value="4">4시간</option>
											</select>
										</td>
									</tr>
									<tr>
										<th>대분류</th>
										<td>
											<select name="category_large">
												<option value="none">선택하세요</option>
											</select>
										</td>
										<th>중분류</th>
										<td>
											<select name="category_middle">
												<option value="none">선택하세요</option>
											</select>
										</td>
									</tr>
									<tr>
										<th>운영유형</th>
										<td>
											<select id="" name="">
												<option value="none">선택하세요</option>
											</select>
										</td>
										<th>연계직무</th>
										<td>
											<select name="related_NCS_part">
												<c:forEach items="${ncsList} }" var="ncs" varStatus="status">
													<option value=${ncs.code }><c:out value="${ncs.category_name }" /></option>
												</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<th>선수 프로그램</th>
										<td>
											<select name="previous_program">
												<option value="none">선택하세요</option>
											</select>
										</td>
										<th>사후 프로그램</th>
										<td>
											<select name="after_program">
												<option value="none">선택하세요</option>
											</select>
										</td>
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
										<td>
											<input type="text" name="TALENT_capability_01" />
										</td>
										<td>
											<input type="text" name="TALENT_capability_02" />
										</td>
										<td>
											<input type="text" name="TALENT_capability_03" />
										</td>
										<td>
											<input type="text" name="TALENT_capability_04" />
										</td>
										<td>
											<input type="text" name="TALENT_capability_05" />
										</td>
										<td>
											<input type="text" name="TALENT_capability_06" />
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
										<td>
											<textarea name="program_goal" placeholder="입력하세요"></textarea>
										</td>
									</tr>
									<tr>
										<th>프로그램 세부내용</th>
										<td>
											<textarea name="program_detail" placeholder="입력하세요"></textarea>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div>
							<input type="submit" value="등록" />
						</div>
					</div>
				</section>
			</form>
		</div>
	</main>

</body>
</html>
