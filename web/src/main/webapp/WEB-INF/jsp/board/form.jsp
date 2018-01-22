<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<h1>게시물 상세 정보</h1>

<form action="add" method='post' enctype="multipart/form-data">

<div class='form-group row'>
<label for='title' class='col-sm-2 col-form-label'>제목</label>
<div class='col-sm-10'>
<input class='form-control' id='title' type='text' name='title'>
</div>
</div>
<div class='form-group row'>
<label for='content' class='col-sm-2 col-form-label'>내용</label>
<div class='col-sm-10'>
<input class='form-control' id='content' type='text' name='content'>
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
<button class='btn btn-primary btn-sm'>추가</button>
</div>
</div>
</form>
<jsp:include page="../footer.jsp"></jsp:include>
</div>
<jsp:include page="../jslib.jsp"/>
</body>
</html>
    