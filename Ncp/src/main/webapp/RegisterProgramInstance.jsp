<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>서원대학교</title>
    <link rel="stylesheet" type="text/css" href="css/Base.css" />
    <link rel="stylesheet" type="text/css" href="css/RegisterProgramInfo.css" />
    <link rel="stylesheet" type="text/css" href="css/Main.css" />
	<link rel="stylesheet" type="text/css" href="css/Main_Content.css" />
	<link rel="stylesheet" type="text/css" href="css/LoginPopup.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" integrity="sha512-rqQltXRuHxtPWhktpAZxLHUVJ3Eombn3hvk9PHjV/N5DMUYnzKPC1i3ub0mEXgFzsaZNeJcoE0YHq0j/GFsdGg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script src="https://kit.fontawesome.com/46fda0e82e.js" crossorigin="anonymous"></script>
  </head>
  <body>

   	<jsp:include page="TopArea.jsp" >
		<jsp:param name="visual_image" value="https://semsplus.seowon.ac.kr/contents/images/client/main/img_mainvisual.png" />
	</jsp:include>

    <main class="main_contents">
      <div class="contents">
        <section>
          <div>
            <div>
              <p>비교과 프로그램 개설 및 관리</p>
            </div>
            <div>
              <p>1. 비교과 프로그램 개설 정보</p>
              <div>
                <table>
                  <tbody>
                    <tr>
                      <th>운영 년도</th>
                      <td>
                        <select id="" name="">
                          <option value="">선택하세요</option>
                        </select>
                      </td>
                      <th>운영 학기</th>
                      <td>
                        <select id="" name="">
                          <option value="">선택하세요</option>
                        </select>
                      </td>
                    </tr>
                    <tr>
                      <th>운영 부서</th>
                      <td>교육혁신원</td>
                      <th>회차 정보</th>
                      <td>1회차</td>
                    </tr>
                    <tr>
                      <th>프로그램 형식</th>
                      <td>
                        <input type="radio" value="" name="program_type" />
                        신규개설
                        <input type="radio" value="" name="program_type" />
                        추가개설(다회차인 경우)
                      </td>
                      <th>운영 부서</th>
                      <td>
                        <select id="" name="">
                          <option value="">선택하세요</option>
                        </select>
                      </td>
                    </tr>
                    <tr>
                      <th>운영 방식</th>
                      <td>
                        <input type="radio" value="" name="operation" />
                        대면
                        <input type="radio" value="" name="operation" />
                        비대면(실시간)
                        <input type="radio" value="" name="operation" />
                        비대면(LMS)
                        <input type="radio" value="" name="operation" />
                        대면 비대면 동시진행
                      </td>
                      <th>담당자</th>
                      <td>
                        <input type="text" />
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
            <div>
              <p>2. 핵심 역량 및 마일리지</p>
              <div>
                <div>
                  <table>
                    <tbody>
                      <tr>
                        <th>인증 여부</th>
                        <td>
                          <input type="checkbox" name="auth" value="" /> 미인증
                          <input type="checkbox" name="auth" value="" />
                          일반인증
                          <input type="checkbox" name="auth" value="" />
                          우수인증
                          <input type="checkbox" name="auth" value="" />
                          학생추천
                        </td>
                        <th>참여시간</th>
                        <td>
                          <input
                            type="text"
                            name=""
                            value=""
                            placeholder="참여시간"
                          />
                        </td>
                      </tr>
                      <tr>
                        <th>운영 기간</th>
                        <td>
                          <select id="" name="">
                            <option value="">선택하세요</option>
                          </select>
                        </td>
                        <th>CUKI 마일리지</th>
                        <td>
                          <input
                            type="text"
                            name=""
                            value=""
                            placeholder="CUKI 마일리지"
                          />
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
                          <input type="text" name="capability" value="0" />
                        </td>
                        <td>
                          <input type="text" name="capability" value="0" />
                        </td>
                        <td>
                          <input type="text" name="capability" value="0" />
                        </td>
                        <td>
                          <input type="text" name="capability" value="0" />
                        </td>
                        <td>
                          <input type="text" name="capability" value="0" />
                        </td>
                        <td>
                          <input type="text" name="capability" value="0" />
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <div>
              <p>3. 운영 내용</p>
              <div>
                <div>
                  <table>
                    <tbody>
                      <tr>
                        <th>장소</th>
                        <td>
                          <input type="text" name="" value="" />
                        </td>
                        <th>사전 공개 여부</th>
                        <td>
                          <input type="radio" value="" name="release" />
                          공개
                          <input type="radio" value="" name="release" />
                          비공개
                        </td>
                        <th>모집 기간</th>
                        <td>
                          <input type="date" name="" id="" /> ~
                          <input type="date" name="" id="" />
                        </td>
                      </tr>
                      <tr>
                        <th>모집 인원</th>
                        <td>
                          <input type="text" name="" value="" />
                        </td>
                        <th>대기 인원</th>
                        <td>
                          <input type="text" name="" value="" />
                        </td>
                        <th>운영 기간</th>
                        <td>
                          <input type="date" name="" id="" /> ~
                          <input type="date" name="" id="" />
                        </td>
                      </tr>
                      <tr>
                        <th>참여 대상</th>
                        <td>
                          <input
                            type="checkbox"
                            name="participating"
                            value=""
                          />
                          전체
                          <input
                            type="checkbox"
                            name="participating"
                            value=""
                          />
                          1학년
                          <input
                            type="checkbox"
                            name="participating"
                            value=""
                          />
                          2학년
                          <input
                            type="checkbox"
                            name="participating"
                            value=""
                          />
                          3학년
                          <input
                            type="checkbox"
                            name="participating"
                            value=""
                          />
                          4학년
                          <input
                            type="checkbox"
                            name="participating"
                            value=""
                          />
                          졸업자
                        </td>
                        <th>추천 대상</th>
                        <td>
                          <input type="text" name="" value="" />
                        </td>
                        <th>교육 시간</th>
                        <td>
                          <input type="time" name="" id="" /> ~
                          <input type="time" name="" id="" />
                        </td>
                      </tr>
                      <tr>
                        <th>문의</th>
                        <td>
                          <input type="text" name="" value="" />
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
                            단과대학
                            <select id="" name="">
                              <option value="">선택하세요</option>
                            </select>
                          </div>
                        </td>
                        <td>
                          <div>
                            학부
                            <select id="" name="">
                              <option value="">선택하세요</option>
                            </select>
                          </div>
                        </td>
                        <td>
                          <div>
                            학부/전공
                            <select id="" name="">
                              <option value="">선택하세요</option>
                            </select>
                          </div>
                        </td>
                        <td>
                          <div>
                            <select id="" name="">
                              <option value="">선택하세요</option>
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
              <p>4. 운영 결과</p>
              <div>
                <table>
                  <tbody>
                    <tr>
                      <th>참여 인원</th>
                      <td>
                        <input type="text" name="" value="" />
                      </td>
                    </tr>
                    <tr>
                      <th>운영 평가</th>
                      <td>
                        <textarea name="" id=""></textarea>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
            <div>
              <input type="button" value="등록" />
            </div>
          </div>
        </section>
      </div>
    </main>
    
   	<script src="js/SitemapPopup.js"></script>
	<script src="js/LoginPopup.js"></script>
  </body>
</html>
