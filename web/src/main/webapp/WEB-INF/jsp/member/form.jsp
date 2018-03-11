<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link type="image/x-icon" href="/favicon.ico" rel="shortcut icon"/>
<link rel='stylesheet'
    href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/m.css'>
<link rel='stylesheet' href='../../css/common.css'>
<link rel='stylesheet' href='../../css/form.css'>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.7.5/css/bootstrap-select.min.css">
</head>
  <body id="registrations-wrapper"
        data-controller="registrations"
        data-action="new"
        data-type=""
        data-sublayout="">

<script type="text/javascript">
$(".fileDrop").on("drop", function(event) {
    event.preventDefault(); 
    var files = event.originalEvent.dataTransfer.files;
    var file = files[0];
    console.log(file);
    var formData = new FormData();
    formData.append("file", file);

    $.ajax({
        type: "post",
        url: "${path}/upload/uploadAjax",
        data: formData,
        dataType: "text",
        processData: false,
        contentType: false,
        // 업로드 성공하면
        success: function(data) {
            var str = "";
            // 이미지 파일이면 썸네일 이미지 출력
            if(checkImageType(data)){ 
                str = "<div><a href='${path}/upload/displayFile?fileName="+getImageLink(data)+"'>";
                str += "<img src='${path}/upload/displayFile?fileName="+data+"'></a>";
            // 일반파일이면 다운로드링크
            } else { 
                str = "<div><a href='${path}/upload/displayFile?fileName="+data+"'>"+getOriginalName(data)+"</a>";
            }
            // 삭제 버튼
            str += "<span data-src="+data+">[삭제]</span></div>";
            $(".uploadedList").append(str);
        }
    });
});
</script>
<div class='background'>
        <jsp:include page="../header.jsp" />
    <div class="header-spacer"></div>

      <div id="container" class="haslayout ">


          <div class="content haslayout">


              <h2>Join our FITPLANET of fashion lovers!</h2>

<section class="registration">

  <div class="box reg-facebook">
    <h3>Sign Up with Facebook</h3>

    <div class="main">
      <p>
        Connecting with Facebook is fast and
        easy and you can see which of your
        friends are already using FIT PLANET.
      </p>
      <p>
        We won't post anything without your
        permission.
      </p>
    </div>

    <button class="facebook-connect-button"
         data-view="FacebookConnectButton"
        data-url="https://lookbook.nu/register"
        data-permissions="register">
      <i class="fa fa-facebook"></i>
      <span>Continue with Facebook</span>
    </button>

  </div>

  <div class="mid">
    <div class="or">or</div>
  </div>

  <div class="box reg-email " data-view="EmailSignupBox">
    <h3>Sign Up with Email</h3>
    <form id="register-email" action="add" method="POST" data-remote="true">
    
      <div class="fields">
      
      
      <div class="fileDrop"></div>
<!-- 업로드된 파일 목록 -->
<div class="uploadedList"></div>
      
        <div class="input-error-field">
          <input type="text" name="name" placeholder="First Name">

          <div class="error-tooltip first_name invisible">
            <div>First Name is invalid</div>
          </div>
        </div>

        <div class="input-error-field">
          <input type="text" name="id" placeholder="NickName">

          <div class="error-tooltip email invisible">
            <div>Email is invalid</div>
          </div>
        </div>
        
        <div class="input-error-field">
          <input type="email" name="email" placeholder="Email">

          <div class="error-tooltip email invisible">
            <div>Email is invalid</div>
          </div>
        </div>

        <div class="input-error-field">
          <input type="password" name="pwd" placeholder="Password">

          <div class="error-tooltip password two-lines invisible">
            <div>
              Password is too short
              <br>
              (minimum is 6 characters)
            </div>
          </div>
        </div>

        <div class="input-error-field">
          <div class="genders">
            <div class="gender male">
              <input type="radio" name="gender" id="gender-male" value="guy">
              <label for="gender-male">male</label>
            </div>

            <div class="gender female">
              <input type="radio" name="gender" id="gender-female" value="girl">
              <label for="gender-female">female</label>
            </div>
          </div>

          <div class="error-tooltip genders invisible">
            <div>Select a gender</div>
          </div>
        </div>

      </div>

<input type="hidden" id='level' name='level' value="1">
      <div class="bottom">
        <div class="disclaimer">
        </div>
        <input type="submit" value="Join">
      </div>
    </form>
  </div>
</section>


          </div>

        </div>

      </div>
      
        <!-- <jsp:include page="../footer.jsp" /> -->

    <jsp:include page="../jslib.jsp" />
</body>
</html>