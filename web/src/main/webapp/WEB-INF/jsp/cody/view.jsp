<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>코디게시판</title>
<link rel='stylesheet'
    href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
    <div class='container'>

        <jsp:include page="../header.jsp" />

        <h1>Cody View</h1>
        
        
<c:if test="${not empty cody}">
<form action='update' method='post' enctype="multipart/form-data">
    
<img src="${contextPath}/download/${cody.co_photo}" width=500 style="margin-bottom: 50px;">
<hr>

<div class='form-group row'>
    <label for='co_no' class='col-sm-2 col-form-label'><h5>No.</h5></label>
    <div class='col-sm-10'>
        <input class='form-control' readonly id='co_no' type='number'
            name='co_no' value='${cody.co_no}'>
    </div>
</div>


<div class='form-group row'>
    <label for='title' class='col-sm-2 col-form-label'><h5>Cody-Title</h5></label>
    <div class='col-sm-10'>
        <input class='form-control' id='title' type='text' name='title'
            value='${cody.title}'>
    </div>
</div>

<div class='form-group row'>
    <label for='conts' class='col-sm-2 col-form-label'><h5>Content</h5></label>
    <div class='col-sm-10'>
        <textarea class='form-control' id='conts' name='conts' cols="50" rows="10">${cody.conts}</textarea>
    </div>
</div>

<div class='form-group row'>
    <label for='gender' class='col-sm-2 col-form-label'><h5>Style-gender</h5></label>
    <div class='col-sm-10'>
        <textarea class='form-control' id='gender' name='gender'>${cody.gender}</textarea>
    </div>
</div>

<div class='form-group row'>
    <label for='datetime' class='col-sm-2 col-form-label'><h5>Date</h5></label>
    <div class='col-sm-10'>
        <input class='form-control' readonly id='datetime' type='date'
            value='${cody.datetime}'>
    </div>
</div>

<div class='form-group row'>
<label for='top' class='col-sm-2 col-form-label'><h5>Top Size</h5></label>
<div class='col-sm-10'>
    <textarea class='form-control' id='top' name='top'>${cody.top}</textarea>
    </div>
</div>

<div class='form-group row'>
    <label for='pants' class='col-sm-2 col-form-label'><h5>Pants Size</h5></label>
    <div class='col-sm-10'>
        <textarea class='form-control' id='pants' name='pants'>${cody.pants}</textarea>
    </div>
</div>
    
    
<div class='form-group row'>
    <label for='views' class='col-sm-2 col-form-label'><h5>Count</h5></label>
    <div class='col-sm-10'>
        <input class='form-control' readonly id='views' type='number'
            value='${cody.views}'>
    </div>
</div>

<div class='form-group row'>
    <label for='views' class='col-sm-2 col-form-label'><h5>Like+ </h5></label>
    <div class='col-sm-10'>
        ${cody.likedcount}
    </div>
</div>


<div class='form-group row'>
    <label for='views' class='col-sm-2 col-form-label'><h5></h5></label>
    <div class='col-sm-10'>
    
<table class='table table-hover'>
 <thead>
     <tr>
         <th>내 코디를 좋아해주는 사람들</th>
     </tr>
 </thead>
 <tbody>

     <c:forEach items="${lista}" var="liked">

        <tr>
              <td>${liked.name}</td>
         
        </tr>
    </c:forEach>

    </tbody>
</table>

            </div>
        </div>
        <hr color="black">
        <div class='form-group row'>
            <label class='col-sm-2 col-form-label'>첨부파일</label>
            <div class='col-sm-10'>
                <%-- <c:forEach items="${cody.files}" var="file"> --%>
                <a href="${contextPath}/download/${cody.co_photo}">${cody.co_photo}</a>
                <br>
            <%-- </c:forEach> --%>
        </div>
    </div>

    <div class='form-group row'>
        <label for='file1' class='col-sm-2 col-form-label'>파일1</label>
        <div class='col-sm-10'>
            <input type="file" class="form-control-file" id="file1"
                name="file">
        </div>
    </div>

    <div class='form-group row'>
        <label for='file2' class='col-sm-2 col-form-label'>파일2</label>
        <div class='col-sm-10'>
            <input type="file" class="form-control-file" id="file2"
                name="file">
        </div>
    </div>

    <div class='form-group row'>
        <label for='file3' class='col-sm-2 col-form-label'>파일3</label>
        <div class='col-sm-10'>
            <input type="file" class="form-control-file" id="file3"
                name="file">
        </div>
    </div>

    <div class='form-group row'>
        <div class='col-sm-10'>
            <button class="btn btn-dark">변경</button>
            <a href='delete?co_no=${cody.co_no}' class="btn btn-dark">삭제</a>
        </div>
    </div>
</form>
</c:if>
<c:if test="${empty cody}">
<p>'${param.co_no}'번 게시물이 없습니다.</p>
</c:if>


<hr color="black">
<form action="../cody_comment/add" method='POST'>
        
      <c:if test="${not empty formcomment}">
<div class='form-group row'>
    <!-- <label for='name' class='col-sm-2 col-form-label'>이름</label> -->
    <div class='col-sm-10'>
        <input class='form-control' id='co_no' type="number" name='co_no' placeholder="코디번호" value="${formcomment.co_no}" hidden="1">
    </div>
</div>

<div class='form-group row'>
<div class='col-sm-10'>
        <input class='form-control' id='m_no' type="number" name='m_no' placeholder="회원번호" value="${formcomment.m_no}" hidden="1">
    </div>
</div>

<div class='form-group row'>
<!-- <label for='name' class='col-sm-2 col-form-label'>작성자</label> -->
<div class='col-sm-10'>
        <h5>작성자</h5><input class='form-control' id='id' type="text" name='id' placeholder="nickname" value="${formcomment.id}" readonly="readonly">
    </div>
</div>
 </c:if>

<div class='form-group row'>
    <!-- <label for='name' class='col-sm-2 col-form-label'>이름</label> -->
        <div class='col-sm-10'>
            <input class='form-control' id='conts' type='text' name='conts' placeholder="주의! 남을 비방하는 내용은 금지하고 있습니다.">
        </div>
    </div>
    
    
    
    <div class='form-group row'>
        <div class='col-sm-10'>
            <button class="btn btn-dark">덧글 등록</button>
        </div>
    </div>
    
</form>


<c:if test="${not empty listcomment}">
<table class='table table-hover'>
        <thead>
           
        </thead>
        <tbody>

            <c:forEach items="${listcomment}" var="cody_comment">
       
      
        <tr>
              <td style="border: solid white; border-top: 1px solid black;"><h6>${cody_comment.email} (${cody_comment.date})</h6></td>   
        </tr>
        <tr>
            <c:if test="${cody_comment.m_no == formcomment.m_no}">
            <td style="border-bottom: 1px solid black"><a style="color:black;" href='../cody_comment/${cody_comment.com_no}'>${cody_comment.conts}</a><hr></td>
            </c:if>  
             
            <c:if test="${cody_comment.m_no != formcomment.m_no}">
            <td style="border-bottom: 1px solid black"><p style="color:black;">${cody_comment.conts}</p><hr></td>
            </c:if>
        </tr>
        
    </c:forEach>

    </tbody>
</table>

</c:if>


<c:if test="${empty listcomment}">
<img src="${contextPath}/download/dut.jpg" width=300 style="margin-bottom: 50px; margin-top: 20px;" align="middle">
</c:if>
</div>



    
    <jsp:include page="../jslib.jsp" />

</body>
</html>