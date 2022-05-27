<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="login_popup">
	<div class="login_popup_body">
		<div class="login_wrapper">
			<h1>
				<img src="https://semsplus.seowon.ac.kr/contents/images/client/common/header_logo.svg" alt="서원대학교" /> <img src="https://semsplus.seowon.ac.kr/contents/images/client/main/img_sems.svg" alt="학생지원통합시스템 로그인 입니다" />
			</h1>
			<form action="/login" method="get">
				<p class="login_input login_id">
					<label for="login_id">Username</label>
					<input type="text" id="usrId" placeholder="아이디를 입력해주세요" name="number" />
				</p>
				<p class="login_input login_pw">
					<label for="login_id">Password</label>
					<input type="password" id="token" placeholder="비밀번호를 입력해주세요" autocomplete="off" maxlength="10" />
				</p>
				<p class="check_row" tabindex="0">
					<input type="checkbox" />
					<label for="idSaveChk" name="save" id="idSaveChk" class="hidden">아이디 저장</label>
				</p>
				<button class="btn_login_submit" id="loginBtn" >LOGIN</button>
			</form>

			<span class="font_gray"> ※ 아이디는 학사행정서비스 사용자 계정 (학번 또는 교직번)을 입력해 주세요. </span> <a class="login_popup_close"></a>
		</div>
	</div>
</div>