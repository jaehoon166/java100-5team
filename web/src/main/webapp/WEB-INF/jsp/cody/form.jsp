<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<link rel='stylesheet'
    href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
function readURL(input){

    if(input.files && input.files[0]){

      var reader = new FileReader();

      reader.onload = function(e){

       $('#UploadedImg').html("<img id=img src=''>");

       $('#img').attr('src', e.target.result);

      }

      reader.readAsDataURL(input.files[0]);

    }  

   }
</script>


                    
</head>

<body>
   
    
    <div class='container'>

        <jsp:include page="../header.jsp" />
       

        <div class="aaa" id="UploadedImg">

     

        </div>
        
        <h1>새 게시물</h1>
        
        
        <form action="add" method='post' enctype="multipart/form-data">

            <div class='form-group row'>
                <label for='title' class='col-sm-2 col-form-label'>제목</label>
                <div class='col-sm-10'>
                    <input class='form-control' id='title' type='text' name='title'>
                </div>
            </div>

            <div class='form-group row'>
                <label for='conts' class='col-sm-2 col-form-label'>내용</label>
                <div class='col-sm-10'>
                    <textarea class='form-control' id='conts' name='conts'></textarea>
                </div>
            </div>
            <div class='form-group row'>
                <label for='gender' class='col-sm-2 col-form-label'>성별</label>
                <div class='col-sm-10'>
                    <textarea class='form-control' id='gender' name='gender'></textarea>
                </div>
            </div>
            <div class='form-group row'>
                <label for='top' class='col-sm-2 col-form-label'>상의 size</label>
                <div class='col-sm-10'>
                    <textarea class='form-control' id='top' name='top'></textarea>
                </div>
            </div>
            <div class='form-group row'>
                <label for='pants' class='col-sm-2 col-form-label'>하의 size</label>
                <div class='col-sm-10'>
                    <textarea class='form-control' id='pants' name='pants'></textarea>
                </div>
            </div>
            
            <div class='form-group row'>
                <label for='file1' class='col-sm-2 col-form-label'>파일1</label>
                <div class='col-sm-10'>
                    
                    <input type="file" class="form-control-file" id="file1" name="file" onchange="readURL(this)">
                     <div class="aaa" id="UploadedImg">
                  
                     </div>

                </div>
            </div>

            <div class='form-group row'>
                <label for='file2' class='col-sm-2 col-form-label'>파일2</label>
                <div class='col-sm-10'>
                    <input type="file" class="form-control-file" id="file2" name="file">
                </div>
            </div>

            <div class='form-group row'>
                <label for='file3' class='col-sm-2 col-form-label'>파일3</label>
                <div class='col-sm-10'>
                    <input type="file" class="form-control-file" id="file3" name="file">
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
