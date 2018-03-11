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

        <h1>Cody View </h1>
       
        <c:if test="${not empty cody}">
            <form action='update' method='post' enctype="multipart/form-data">
                
                <img src="${contextPath}/download/${cody.co_photo}" width=500 style="margin-bottom: 50px;">
              
                
                <table class='table table-hover' style="margin-bottom: 20px;">
                    <thead>
                        <tr>
                            <th>Top Size</th><th>Pants Size</th><th>Style-gender</th><th>No.</th>
                        </tr>
                    </thead>
                    <tbody>
                            <tr>
                                  <td>${cody.top}</td><td>${cody.pants}</td><td>${cody.gender}</td><td>${cody.co_no}</td>
                            </tr>
                    </tbody>
               </table>
                
                <div class='form-group row'>
                    <label for='title' class='col-sm-2 col-form-label'><h5>Cody-Title</h5></label>
                    <div class='col-sm-10'>
                        <p id="title">${cody.title}</p>
                    </div>
                </div>
                
                
                <div class='form-group row'>
                    <label for='conts' class='col-sm-2 col-form-label'></label>
                    <div class='col-sm-10'>
                        <textarea class='form-control' id='conts' name='conts' cols="50" rows="10">${cody.conts}</textarea>
                    </div>
                </div>
                <div class='form-group row'>
                    <label for='gender' class='col-sm-2 col-form-label'><h5>Style-gender</h5></label>
                    <div class='col-sm-10'>
                        ${cody.gender}
                    </div>
                </div>
                <div class='form-group row'>
                    <label for='datetime' class='col-sm-2 col-form-label'><h5>Date</h5></label>
                    <div class='col-sm-10'>
                        ${cody.datetime}
                    </div>
                </div>
               
                
                
                <div class='form-group row'>
                    <label for='views' class='col-sm-2 col-form-label'><h5>Count</h5></label>
                    <div class='col-sm-10'>
                        ${cody.views}
                    </div>
                </div>
                <div class='form-group row'>
                    <label for='views' class='col-sm-2 col-form-label'><h5>Like+ </h5></label>
                    <div class='col-sm-10'>
                        ${cody.likedcount}
                    </div>
                </div>
                
                <button class="btn btn-dark" formaction="liked?co_no=${cody.co_no}&wtest=${cody.wtest}" value="${cody.co_no},${cody.wtest}">좋아요!</button>
                
                
               
                    
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
                    <h5>작성자</h5><input class='form-control' id='email' type="text" name='email' placeholder="E-mail" value="${formcomment.email}" readonly="readonly">
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
      <img src="${contextPath}/download/dut.jpg" width=300 style="margin-bottom: 50px; margin-top: 20px;" align="middle" >
     </c:if>
    </div>
    
    
    
    
    <jsp:include page="../jslib.jsp" />

</body>
</html>