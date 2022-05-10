<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="rlogic.Recommendation_Program" %>

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
</head>
<body>
<%
Recommendation_Program recoProgram = new Recommendation_Program();
List<Map<String, String>> datum = recoProgram.getPrettyRecommendation("12001");
%>
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
			<section>
                <div>
                    <div class="input_div_ex">
                        <a class="input_label">프로그램 명</a>
                        <div class="input_div_in">
                            <input type="text" placeholder="프로그램명을 입력하세요"/>
                            <input type="button" value="검색"/>
                        </div>
                    </div>
                    <div>
                        <table>
                            <tbody>
                                <tr>
                                    <th colspan="9"><strong><%=datum.get(0).get("programName") %></strong><br>프로그램 추천 적합도 순위</th>
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
                                </tr>
<% for(int i=0; i<datum.size(); i++) { %>
                                <tr>
                                    <td><%=i+1 %></td>
                                    <td><%=datum.get(i).get("name") %></td>
                                    <td><%=datum.get(i).get("major_number") %></td>
                                    <td><%=datum.get(i).get("major") %></td>
                                    <td><%=datum.get(i).get("university_number") %></td>
                                    <td><%=datum.get(i).get("grade") %></td>
                                    <td><%=datum.get(i).get("sex") %></td>
                                    <td><%=datum.get(i).get("ncp") %></td>
                                    <td><%=datum.get(i).get("degree") %></td>
                                </tr>
<%} %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
		</div>
	</main>
</body>
</html>
