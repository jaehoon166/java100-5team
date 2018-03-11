<%@page import="java100.app.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel='stylesheet'
    href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
    <div class='container'>

        <jsp:include page="../header.jsp" />

        <h1>회원 목록</h1>

        <div class="toolbar">
            <a href='form' class='btn btn-primary btn-sm'>추가</a>
            <form action="list" method="get" class="searchbox">
                <input type="text" name="name">
                <button>검색</button>
            </form>
        </div>

        <table class='table table-hover'>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>아이디</th>
                    <th>나이</th>
                    <th>성별</th>
                <th>폰 번호 </th>
                <th>설명 </th>
                <th>상의 </th>
                <th>하의 </th>
                </tr>
            </thead>
            <tbody>

                <c:forEach items="${list}" var="member">

                    <tr>
                        <td>${member.m_no}</td>
                        <td><a href='${member.m_no}'>${member.name}</a></td>
                          <td>${member.email}</td>
                          <td>${member.id}</td>
                        <td>${member.age}</td>
                        <td>${member.gender}</td>
                        <td>${member.phone}</td>
                        <td>${member.intro}</td>
                        <td>${member.top}</td>
                        <td>${member.pants}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

        <jsp:include page="../pageng.jsp" />

        <jsp:include page="../footer.jsp" />

    </div>

    <jsp:include page="../jslib.jsp" />
</body>
</html>