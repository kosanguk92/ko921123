<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
	// /mvc/index.jsp =>memberLoggedIn = null;
	// /mvc/member/login => memberLoggedin = member 객체
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello MVC</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" />
<script src="<%=request.getContextPath() %>/js/jquery-3.4.1.js"></script>
<script>
function loginValidate(){
	let $memberId = $("#login-memberId");
	let $password = $("#login-password");
	//1. 아이디검사
	if($memberId.val().trim().length < 4 ){
		alert("올바른 아이디를 입력해라");
		$memberId.focus();
		return false;
	}
	//2. 비밀번호 검사
	if($password.val().trim().length < 4 ){
		alert("올바른 비밀번호를 입력하셍.");
		$password.select();
		return false;
	}
	return true;
}
</script>
</head>
<body>
	<div id="container">
		<header>
			<h1>Hello MVC</h1>
			<!-- 로그인 메뉴 시작-->
			<div class="login-container">
			
			<%if(memberLoggedIn != null){%>
			<!-- 로그인한경우 -->	
			<table id="logged-in">
				<tr>
					<td><%=memberLoggedIn.getMemberName() %>님,안녕하세요.</td>
				</tr>
				<tr>
					<td>
						<button>내정보보기</button>
						<button onclick="location.href='<%=request.getContextPath()%>/member/logout'">로그아웃</button>
					</td>
				</tr>
			</table>
			
			<% } else{ %>
			<!-- 로그인하지 않은 경우 -->
			<form action="<%=request.getContextPath()%>/member/login" id="loginFrm" method="POST" onsubmit="return loginValidate();">
				<table>
					<tr>
						<td><input type="text" name="memberId" id="login-memberId" placeholder="아이디" value="로그인" tabindex="1"/></td>
					</tr>
					<tr>
						<td><input type="password" name="password" id="login-password" placeholder="비밀번호" tabindex="2"/></td>
						<td><input type="submit" value="로그인" tabindex="3"/></td>
					</tr>
					<tr>
						<td colspan ="2">
							<input type="checkbox" name="saveId" id="saveId" />
							<label for="saveId">아이디 저장</label>
							&nbsp;&nbsp;
							<input type="button" value="회원가입" />
						</td>
					</tr>
				</table>
				</form>
			<% }%>
			
			
			
			
			

			</div>
			<!-- 로그인 메뉴 끝 -->
			<!-- 메인메뉴 시작-->
			<nav>
				<ul class="main-nav">
					<li><a href="<%=request.getContextPath()%>">Home</a></li>
					<li><a href="<%=request.getContextPath()%>/board/boardList">게시판</a></li>
				</ul>
			</nav>			
		</header>
		<section id="content">