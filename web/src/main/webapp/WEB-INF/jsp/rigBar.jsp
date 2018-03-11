<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
figure {
    display: block;
    margin: 0;
}

.tag {
    color: gray;
    font-size: 15px;
}

.images {
    position: relative;
}

.images.text {
    position: absolute;
    top: 0;
    left: 0;
    color: white;
    text-align: center;
    line-height: 143px;
}

.tint {
    position: relative;
    float: left;
    cursor: pointer;
    width: 143px;
    height: 143px;
}

.tint:before {
    background: rgba(255, 0, 0, 0.5);
    content: attr(lang);
    display: block;
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    -moz-transition: all .3s linear;
    -webkit-transition: all .3s linear;
    -ms-transition: all .3s linear;
    -o-transition: all .3s linear;
    transition: all .3s linear;
}

.tint:hover:before {
    background: none;
}

.t:before {
    background: rgba(0, 0, 0, 0.2);
}
</style>

<link rel="stylesheet"
    href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script
    src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<div id="right">
   
    <div id="firend">
        <ul class='navbar-nav mr-auto'>
                <c:if test="${not empty sessionScope.loginUser.m_no}">
                    <li class='nav-item'>
                    <a class='nav-link' href='../cody/${sessionScope.loginUser.id}'>
                    <img class="img-rounded" src="${contextPath}/download/${sessionScope.loginUser.m_photo}" width="50" height="50" align="middle">
                           ${sessionScope.loginUser.id} ${sessionScope.loginUser.name} ${sessionScope.loginUser.intro}</a>
                           </li>
                </c:if>
            </ul>
    </div>

    
    <div id="daily">
        <div class="daily_tit">
            <h4>데일리트렌드</h4>
            <a class="nav-link disabled" href="../trend/form">게시물 올리기</a>
        </div>

        <ul>
            <c:forEach items="${list1}" var="trend">
                <li>
                    <div class="images">
                       	<a href='../trend/delete?tr_no=${trend.tr_no}' class="tag"> <img
							src="${contextPath}/download/${trend.photo}" width=143
							height="143">
                        </a>
                        <!-- 사용자 검색  버튼 -->
                        <div class="images text tint t" lang="${trend.op_tag}" onclick="location.href='../cody/list?tag=${trend.op_tag}'"></div>
                        <!-- 운영자 삭제 버튼 -->
<%--                        <div class="images text tint t" lang="${trend.op_tag}" onclick="location.href='../trend/delete?tr_no=${trend.tr_no}'"></div> --%>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>