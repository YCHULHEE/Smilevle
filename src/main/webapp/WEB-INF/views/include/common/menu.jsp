<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
      <a class="navbar-brand" href="index.html">smilevle.</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="oi oi-menu"></span> 메뉴
      </button>

      <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active"><a href="index.jsp" class="nav-link">메인</a></li>
          <li class="nav-item"><a href="/WEB-INF/views/introduction.jsp" class="nav-link">스마이블 소개</a></li>
          <li class="nav-item"><a href="tour.jsp" class="nav-link">여행지</a></li>
          <li class="nav-item"><a href="stay.jsp" class="nav-link">숙소</a></li>
          <li class="nav-item"><a href="usedtrade.jsp" class="nav-link">동네마켓</a></li>
          <li class="nav-item"><a href="rivew.jsp" class="nav-link">리뷰</a></li>
          <u:notLogin>
          <li class="nav-item cta"><a href="login.do" ><span>로그인</span></a></li>
          </u:notLogin>
          <u:isLogin>
          <li class="nav-item cta"><a href="logout.do"><span>로그아웃</span></a></li>
          </u:isLogin>
        </ul>
      </div>
    </div>
</nav>