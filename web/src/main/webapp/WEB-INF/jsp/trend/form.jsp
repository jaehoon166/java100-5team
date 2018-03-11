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

            <div class='form-group row'>
                <label for='op_tag' class='col-sm-2 col-form-label'>태그</label>
                <div class='col-sm-10'>
                    <input class='form-control' id='op_tag' type='text' name='op_tag'>
                </div>
            </div>

            <div class='form-group row'>
                <label for='file' class='col-sm-2 col-form-label'>사진</label>
                <div class='col-sm-10'>
                    <input type="file" class="form-control-file" id="file1" name="file">
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
