<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.pronail {
    display: block;
    width: 50px;
    height: 50px;
    background-color: #fff;
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center center;
    line-height: 1.42857143;
    -webkit-transition: border .2s ease-in-out;
    -o-transition: border .2s ease-in-out;
    transition: border .2s ease-in-out;
    border-radius: 100%;
}
</style>

<header style="z-index: 9999;">

    
<nav class='navbar navbar-expand-lg navbar-dark bg-dark'>
      
      <a class='navbar-brand' href='../cody/list'> FIT PLANET </a>

<div id='navbarNav'
        style="width: 200px; position: absolute; left: 50%; transform: translateX(-50%);">
  </div>

<!-- <div id='navbarNav' style="border: 3px solid red; float:right; "> -->


 
<!--  <div class='collapse navbar-collapse' id='navbarNav'> -->
 
  <ul class='navbar-nav mr-auto'>
                
  <c:if test="${sessionScope.loginUser.m_no != 0}">
  <li class='nav-item'><a class='nav-link' href='../../member/form.html?no=${sessionScope.loginUser.m_no}'>${sessionScope.loginUser.id}</a>
  <li class='nav-item'><img src="${contextPath}/download/${sessionScope.loginUser.m_photo}" 
  width=35 height="35" style="margin-bottom: 50px; border-radius: 50%;">
  </li>
  </c:if>
</ul>
            
     <c:choose>
<c:when test="${sessionScope.loginUser.m_no != 0}">
<a href="${contextPath}/app/auth/logout" class='btn btn-light btn-sm'>로그아웃</a>
</c:when>

<c:otherwise>
<form action="../auth/login" method='post'>
    <a data-target="#exampleModalCenter" data-toggle="modal"
            class='btn btn-light btn-sm' style="vertical-align: middle;">LOGIN</a>
            
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
    aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">LOGIN</h5>
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            
            
<div class="modal-body">

    <div class='form-group row'>
        <label for='email' class='col-sm-2 col-form-label'>이메일</label>
        <div class='col-sm-10'>
            <input class='form-control' id='email' type='text'
                name='email' value='${cookie.email.value}'>
    </div>
</div>

<div class='form-group row'>
    <label for='pwd' class='col-sm-2 col-form-label'>암호</label>
    <div class='col-sm-10'>
        <input class='form-control' id='pwd' type='password'
            name='pwd'>
    </div>
</div>

<div class='form-group row'>
    <div class="col-sm-2"></div>
    <div class="col-sm-10">
        <div class="form-check">
            <label class="form-check-label" for="saveEmail"> 이메일 저장</label>
            <input type="checkbox" class="form-check-input" id="saveEmail" name="saveEmail"> 
        </div>
    </div>
</div>
<div class="modal-footer">
    <button class='btn btn-sm' style='background-color: #FF0080'>로그인</button>
<button formaction="../../member/form.html" class='btn btn-primary btn-sm'>Join us</button>
<button class='btn btn-sm' style='background-color: #FF0080'
data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>
  </form>          

         </c:otherwise>
     </c:choose>
 <!-- </div> -->
<!-- </div> -->
    </nav>
</header>

