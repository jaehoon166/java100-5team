<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<link rel='stylesheet'
	href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
	<div class='container'>

		<jsp:include page="../header.jsp" />

		<h1>도서 목록</h1>
		<div class="toolbar">
			<a href='form' class='btn btn-primary btn-sm'>추가</a>
			<!-- <form action="list" method="get" class="searchbox">
				<input type="text" name="title">
				<button>검색</button>
			</form> -->
		</div>

		<table class='table table-hover'>
			<thead>
				<tr>
					<th>사진</th>
					<!-- <th>번호</th> -->
					<th>도서명</th>
					<th>출판사</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${list}" var="book">
					<c:set var="bname"
						value="${fn:length(book.bname) == 0 ? '(제목이없습니다.)' : book.bname}" />
					<tr>
						<td>
						<c:forEach items="${book.files}" var="file">
						<img width="50" height="70" src="${contextPath}/download/${file.filename}">
						</c:forEach>
						</td>
						<%-- <td>${book.no}</td> --%>
						<td><a href='${book.no}'><span class="d-inline-block text-truncate" style="max-width: 300px;">${bname}</span></a></td>
						<td>${book.publisher}</td>
						<td>${book.price}</td>
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