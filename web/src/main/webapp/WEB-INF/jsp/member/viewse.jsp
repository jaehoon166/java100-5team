<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel='stylesheet' href='../../css/m.css'>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
<link rel='stylesheet' href='../../css/form.css'>
<link rel='stylesheet' href='../../css/view.css'>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.7.5/css/bootstrap-select.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.7.5/js/bootstrap-select.min.js"></script>
<script type="text/javascript">
function previewImage(targetObj, View_area) {
    var preview = document.getElementById(View_area); //div id
    var ua = window.navigator.userAgent;

  //ie일때(IE8 이하에서만 작동)
    if (ua.indexOf("MSIE") > -1) {
        targetObj.select();
        try {
            var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
            var ie_preview_error = document.getElementById("ie_preview_error_" + View_area);


            if (ie_preview_error) {
                preview.removeChild(ie_preview_error); //error가 있으면 delete
            }

            var img = document.getElementById(View_area); //이미지가 뿌려질 곳

            //이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
            img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
        } catch (e) {
            if (!document.getElementById("ie_preview_error_" + View_area)) {
                var info = document.createElement("<p>");
                info.id = "ie_preview_error_" + View_area;
                info.innerHTML = e.name;
                preview.insertBefore(info, null);
            }
        }
  //ie가 아닐때(크롬, 사파리, FF)
    } else {
        var files = targetObj.files;
        for ( var i = 0; i < files.length; i++) {
            var file = files[i];
            var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
            if (!file.type.match(imageType))
                continue;
            var prevImg = document.getElementById("prev_" + View_area); //이전에 미리보기가 있다면 삭제
            if (prevImg) {
                preview.removeChild(prevImg);
            }
            var img = document.createElement("img"); 
            img.id = "prev_" + View_area;
            img.classList.add("obj");
            img.file = file;
            img.style.image-preview; 
            img.style.width = '150px'; 
            img.style.height = '155px';
            preview.appendChild(img);
            if (window.FileReader) { // FireFox, Chrome, Opera 확인.
                var reader = new FileReader();
                reader.onloadend = (function(aImg) {
                    return function(e) {
                        aImg.src = e.target.result;
                    };
                })(img);
                reader.readAsDataURL(file);
            } else { // safari is not supported FileReader
                //alert('not supported FileReader');
                if (!document.getElementById("sfr_preview_error_"
                        + View_area)) {
                    var info = document.createElement("p");
                    info.id = "sfr_preview_error_" + View_area;
                    info.innerHTML = "not supported FileReader";
                    preview.insertBefore(info, null);
                }
            }
        }
    }
}
</script>

</head>
  <body id="registrations-wrapper"
        data-controller="registrations"
        data-action="new"
        data-type=""
        data-sublayout="">

    <div class='background'>
        <jsp:include page="../header.jsp" />
    <div class="header-spacer"></div>

      <div id="container" class="haslayout ">


          <div class="content haslayout">
         <h2>정보변경</h2>

        <c:if test="${not empty member}">
            <form action='update' method='post' enctype="multipart/form-data">
            
                <div class='form-group row'>
                    <label for='m_no' class='col-sm-2 col-form-label'>번호</label>
                    <div class='col-sm-10'>
                        <input class='form-control' readonly id='m_no' type='number'
                            name='m_no' value='${member.m_no}'>
                    </div>
                </div>
<div id='View_area' class="thumbnail circle" style="background-image:url('${contextPath}/download/${member.m_photo}')"
    ></div>
   <div class='form-group row'>
   <label for='m_photo' class='col-sm-2 col-form-label'>프로필</label>
        <input type="file" class="form-control-file" id="m_photo1" name="file"
        onchange="previewImage(this,'View_area')" >
   <div class='col-sm-10'>
  
         </div>
         </div>
 

                
                <div class='form-group row'>
                    <label for='name' class='col-sm-2 col-form-label'>이름</label>
                    <div class='col-sm-10'>
                        <input class='form-control' id='name' type='text' name='name'
                            value='${member.name}'>
                    </div>
                </div>
                <div class='form-group row'>
                    <label for='email' class='col-sm-2 col-form-label'>이메일</label>
                    <div class='col-sm-10'>
                        <input class='form-control' readonly id='email' type='email' name='email'
                            value='${member.email}'>
                    </div>
                </div>
                
                <div class='form-group row'>
                    <label for='id' class='col-sm-2 col-form-label'>닉네임</label>
                    <div class='col-sm-10'>
                        <input class='form-control' id='id' type='text'
                            name='id'>
                    </div>
                </div>
                
                <div class='form-group row'>
                    <label for='pwd' class='col-sm-2 col-form-label'>암호</label>
                    <div class='col-sm-10'>
                        <input class='form-control' id='pwd' type='password'
                            name='pwd'>
                    </div>
                </div>

                <div class='form-group row'>
                    <label for='age' class='col-sm-2 col-form-label'>나이</label>
                    <div class='col-sm-10'>
                        <input class='form-control' id='age' type='number'
                            name='age'>
                    </div>
                </div>
                
                
                <div class='form-group row'>
                    <label for='phone' class='col-sm-2 col-form-label'>휴대전화</label>
                    <div class='col-sm-10'>
                        <input class='form-control' id='phone' type='text'
                            name='phone'>
                    </div>
                </div>
                
                <div class='form-group row'>
                    <label for='intro' class='col-sm-2 col-form-label'>설명</label>
                    <div class='col-sm-10'>
                        <input class='form-control' id='intro' type='text'
                            name='intro'>
                    </div>
                </div>
                
                
<div class="btn-group btn-group-toggle" data-toggle="buttons">
  <label class="btn btn-secondary active">
    <input type="radio" name="top" value="상의" autocomplete="off" value="상의" checked> 상의
  </label>
  <label class="btn btn-secondary">
    <input type="radio" name="top" value="90" autocomplete="off"> 90(S)
  </label>
  <label class="btn btn-secondary">
    <input type="radio" name="top" value="95" autocomplete="off"> 95(M)
  </label>
  <label class="btn btn-secondary">
    <input type="radio" name="top" value="1OO" autocomplete="off"> 100(L)
  </label>
  <label class="btn btn-secondary">
    <input type="radio" name="top" value="105" autocomplete="off"> 105(XL)
  </label>
  
</div>
                
<div class="btn-group btn-group-toggle" data-toggle="buttons">
  <label class="btn btn-secondary active">
    <input type="radio" name="pants" value="하의" autocomplete="off" checked> 하의
  </label>
  <label class="btn btn-secondary">
    <input type="radio" name="pants" value="26" autocomplete="off"> 26 
  </label>
  
  <label class="btn btn-secondary">
    <input type="radio" name="pants" value="27" autocomplete="off"> 27 
  </label>
  
  <label class="btn btn-secondary">
    <input type="radio" name="pants" value="28" autocomplete="off"> 28
  </label>
  <label class="btn btn-secondary">
    <input type="radio" name="pants" value="29" autocomplete="off"> 29
  </label>
  <label class="btn btn-secondary">
    <input type="radio" name="pants" value="30" autocomplete="off"> 30
  </label>
  <label class="btn btn-secondary">
    <input type="radio" name="pants" value="32" autocomplete="off"> 32  
  </label>


</div>



                <div class='form-group row'>
                    <div class='col-sm-10'>
                        <button class='btn btn-primary btn-sm'>변경</button>
                        <a href='delete?m_no=${member.m_no}' class='btn btn-primary btn-sm'>삭제</a>
                    </div>
                </div>
            </form>
        </c:if>
        <c:if test="${empty member}">
            <p>'${param.m_no}'번 회원 정보가 없습니다.</p>
        </c:if>
</div>
</div>
    </div>

    <jsp:include page="../jslib.jsp" />
</body>
</html>
