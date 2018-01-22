<%@page import="java100.app.domain.Member"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java100.app.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>   
         
         
         <!DOCTYPE html>
         <html>
         <head>
         
         <link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
         
         <link rel='stylesheet' href='../../css/common.css'>
        
         </head>
         <body>
         <div class='container'>
         
        <jsp:include page="../header.jsp"></jsp:include>
        
         <h1>회원 목록</h1>
         
         <div class="toolbar">
        <form action="list" method="get" class="searchbox">
        <input type="text" name="nm">
        <button>검색</button>
        </form>
        <a href='form' class='btn btn-primary btn-sm'>추가</a>
        </div>
         
         <table class='table table-hover'>
         <thead>
         <tr>
         <th>번호</th><th>이름</th><th>이메일</th><th>가입날짜</th>
         </tr>
         </thead>
         <tbody>
      
        <c:forEach items="${list}" var="member">     
                <tr>
                <td>${member.no}</td>
                <td><a href='${member.no}'>${member.name}</a></td>
                <td>${member.email}</td>
                <td>${member.createDate}</td>
                </tr> 
         </c:forEach>   
      
         
         </tbody>
         </table>
         
         
         <jsp:include page="../page.jsp"></jsp:include>
         
         <jsp:include page="../footer.jsp"></jsp:include>
         </div>
         </body>
         <jsp:include page="../jslib.jsp"/>
         
         </html>