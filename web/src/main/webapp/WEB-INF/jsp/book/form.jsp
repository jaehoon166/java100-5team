<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
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

		<h1>새 게시물</h1>

		<form action="add" method='post' enctype="multipart/form-data">

			<!-- <div class='form-group row'>
				<label for='no' class='col-sm-2 col-form-label'>도서번호</label>
				<div class='col-sm-10'>
					<input class='form-control' id='no' type='text' name='no'>
				</div>
			</div> -->
			<div class='form-group row'>
				<label for='bname' class='col-sm-2 col-form-label'>도서명</label>
				<div class='col-sm-10'>
					<input class='form-control' id='bname' type='text' name='bname'>
				</div>
			</div>
			<div class='form-group row'>
				<label for='publisher' class='col-sm-2 col-form-label'>출판사</label>
				<div class='col-sm-10'>
					<input class='form-control' id='publisher' type='text' name='publisher'>
				</div>
			</div>
			<div class='form-group row'>
				<label for='date' class='col-sm-2 col-form-label'>출판일</label>
				<div class='col-sm-10'>
					<input class='form-control' id='date' type='date' name='date'>
				</div>
			</div>
			<div class='form-group row'>
				<label for='price' class='col-sm-2 col-form-label'>가격</label>
				<div class='col-sm-10'>
					<input class='form-control' id='price' type='text' name='price'>
				</div>
			</div>

			<div class='form-group row'>
				<label for='ex' class='col-sm-2 col-form-label'>설명</label>
				<div class='col-sm-10'>
					<textarea class='form-control' id='ex' name='ex'></textarea>
				</div>
			</div>

			<div class='form-group row'>
				<label for='file' class='col-sm-2 col-form-label'>파일1</label>
				<div class='col-sm-10'>
					<input type="file" class="form-control-file" id="file" name="file">
				</div>
			</div>

			<div class='form-group row'>
				<div class='col-sm-10'>
					<button class='btn btn-primary btn-sm'>등록</button>
				</div>
			</div>
		</form>

		<jsp:include page="../footer.jsp" />

	</div>

	<jsp:include page="../jslib.jsp" />

</body>
</html>
