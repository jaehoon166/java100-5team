<%@page import="java100.app.domain.Board"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java100.app.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
          
            
            <!DOCTYPE html>
            <html>
            <head>
            <title>게시물관리</title>
            <link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
           
            
            <link rel='stylesheet' href='../../css/common.css'>
           
            </head>
            <body>
            <div class='container'>
            <jsp:include page="../header.jsp"></jsp:include>
            <h1>게시물 상세정보</h1>
             
            <jsp:useBean id="board" type="java100.app.domain.Board" scope="request"></jsp:useBean>
            
            <c:if test="${not empty board}">        
                    <form action='update' method='post' enctype="multipart/form-data">
                    <div class='form-group row'>
                    <label for='no' class='col-sm-2 col-form-label'>번호</label>
                    <div class='col-sm-10'>
                    <input class='form-control' readonly id='no' type='number' name='no' value='${board.no}'>
                    </div>
                    </div>
                    
                    <div class='form-group row'>
                    <label for='title' class='col-sm-2 col-form-label'>제목</label>
                    <div class='col-sm-10'>
                    <input class='form-control' id='title' type='text' name='title' value='${board.title}'>
                    </div>
                    </div>
                    
                    
                    <div class='form-group row'>
                    <label for='content' class='col-sm-2 col-form-label'>내용</label>
                    <div class='col-sm-10'>
                    <input class='form-control' id='content' type='text' name='content' value='${board.content}'>
                    </div>
                    </div>
                    
                    
                    <div class='form-group row'>
                    <label for='regdt' class='col-sm-2 col-form-label'>날짜</label>
                    <div class='col-sm-10'>
                    <input class='form-control' id='regdt' type='text' name='regdt' value='${board.regDate}'>
                    </div>
                    </div>
                    
                    
                    <div class='form-group row'>
                    <label for='no' class='col-sm-2 col-form-label'>조회수</label>
                    <div class='col-sm-10'>
                    <input class='form-control' readonly id='vwcnt' type='number' name='vwcnt' value='${board.viewCount}'>
                    </div>
                    </div>
                    
                    <div class='form-group row'>
                    <label class='col-sm-2 col-form-label'>첨부파일</label>
                    <div class='col-sm-10'>
	                    <c:forEach items="${board.files}" var="file">
	                    <a href="${contextPath}/download/${file.filename}">${file.filename}</a><br>
	                    </c:forEach>
                    </div>
                    </div>
                    
                    <div class='form-group row'>
                    <label for='file1' class='col-sm-2 col-form-label'>파일1</label>
                    <div class='col-sm-10'>
                    <input type="file" class="form-control-file" id="file1" name="file">
                    </div>
                    </div>
                    
                    <div class='form-group row'>
                    <label for='file1' class='col-sm-2 col-form-label'>파일2</label>
                    <div class='col-sm-10'>
                    <input type="file" class="form-control-file" id="file2" name="file">
                    </div>
                    </div>
                    
                    <div class='form-group row'>
                    <label for='file1' class='col-sm-2 col-form-label'>파일3</label>
                    <div class='col-sm-10'>
                    <input type="file" class="form-control-file" id="file3" name="file">
                    </div>
                    </div>
                    
                    <div class='form-group row'>
                    <div class='col-sm-10'>
                    <button class='btn btn-primary btn-sm'>변경</button>
                    <a href='delete?no=${board.no}' class='btn btn-primary btn-sm'>삭제</a>
                    </div>
                    </div>
                   
                    </form>
                    
                  
               </c:if>
               <c:if test="${empty board}">    
                    <p>'${param.no}' 의 게시물 정보가 없습니다.</p>
                </c:if>
            
           <jsp:include page="../footer.jsp"></jsp:include>
            </div>
            
           <jsp:include page="../jslib.jsp"/>
            
            </body>
            </html>