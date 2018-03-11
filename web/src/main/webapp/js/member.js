var addBtn = $('#addBtn'),
    updateBtn = $('#updateBtn'),
    deleteBtn = $('#deleteBtn'),
    noItem = $('#m_no'),
    pwdItem = $('#pwd'),
    pwdcheck = $('#pwdcheck'),
    nameItem = $('#name'),
    idItem = $('#id'),
    emailItem = $('#email'),
    ageItem = $('#age'),
    phoneItem = $('#phone'),
    introItem = $('#intro'),
    levelItem = $('#level'),
    photo = $('#photo'),
    gender = $("input[type=radio][name=gender]:checked").val(),
    imd = $('#imdiv');



$('header').load('../header.html');

var index = location.href.indexOf('?');

if (index != -1) { // 상세보기 데이터를 가져오는경우
    var qs = location.href.substr(index + 1);
    
    var arr = qs.split('=');
    
     $('.my-new').css('display', 'none');
    // $(딱한번만 호출할 함수);
$(() => {
     
     $.ajax('../json/member/' + arr[1], {
         dataType: 'json',
         success: (result) => {
             noItem.val(result.data.m_no);
             nameItem.val(result.data.name);
             idItem.val(result.data.id);
             emailItem.val(result.data.email);
             ageItem.val(result.data.age);
             phoneItem.val(result.data.phone);
             introItem.val(result.data.intro);
             levelItem.val(result.data.level);
             result.data.gender;
            console.log(result.data.m_photo);
            
             // 파일 값을 받아서
            var filename = result.data.m_photo;
 
            if (filename == null) {
                // 없으면 기본사진
                imd.html('<img id="imag" style="border-radius:100%" width="150px" height="150px" src="../images/profile.gif">');
            } else
                // 있으면 선택사진
                imd.html( '<img id="imag" style="border-radius:100%" width="150px" height="150px" src="/download/'+ filename + '">');
             
         }, // filename if문
             
         error: () => {
             window.alert('서버 실행 오류');
         } // end error
         
     }); // end success
 }); // end ajax
    
} else { // if 문 end 신규 데이터 입력일 경우
    $('.my-view').css('display', 'none');
} 


function check() {

    if(pwdItem.val() == "") {
       $('#pwd').focus();
      return false;
    } else if(emailItem.val() == "") {

        $('#email').focus();
        $('#email').html("<p style='color:red;'> 이메일 주소를 입력해 주세요</p>");
      return false;

    } else if(nameItem.val() == "") {
        $('#name').focus();
        $('#name').html("<p style='color:red;'> 이름 입력해 주세요</p>");
      return false;
    } else if(idItem.val() == "") {
        $('#id').focus();
        $('#id').html("<p style='color:red;'> 아이디를 입력해 주세요</p>");
      return false;
    
    
    }
    else 
        return true;

  }

$('#pwdcheck').keyup(() => {
    if (pwdItem.val().length == 0) {
        $('#pwsame').html("<p></p>");
        
    }  else  if (pwdItem.val() == pwdcheck.val()) {
        $('#pwsame').html("<p style='color:blue;'>일치합니다.</p>");
    } else {
        $('#pwsame').html("<p style='color:red;'>비밀번호가 틀렸습니다. 다시 입력해 주세요</p>");
    }
});


$('#pwd').keyup(() => {
    if (pwdItem.val().length == 0) {
        $('#pwsame').html("<p></p>");
    } else if (!pwdItem.val().length == 0 && pwdcheck.val().length == 0) {
        $('#pwsame').html("<p style='color:red;'>비빌번호 확인을 해주세요</p>");
        $('#pwdcheck').focus();
        return;
    }
    else if (pwdItem.val() == pwdcheck.val()) {
        $('#pwsame').html("<p style='color:blue;'>일치합니다.</p>");
    } else {
        $('#pwsame').html("<p style='color:red;'>비밀번호가 틀렸습니다. 다시 입력해 주세요</p>");
    } 
});


       
$('#pwd').keyup(() => {
    if (pwdItem.val().length == 0) {
        $('#pwdinput').html("<p style='color:red;'>비밀번호를 입력해주세요</p>");
        $('#pwd').focus(); 
    } else if (!pwdItem.val().match(/^.*(?=^.{8,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/)) {
        $('#pwdinput').html("<p style='color:red;'>비밀번호 형식에 맞게 입력해주세요</p>");
        $('#pwd').focus();
        return;
    } else if (pwdItem.val().match(/^.*(?=^.{8,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/)) {
        $('#pwdinput').html("<p style='color:green;'>적당합니다</p>");
        $('#pwd').focus();
        return;
    }
});
addBtn.click (() => {
    $.ajax('../json/member/add', {
        data: {
            name: nameItem.val(),
            email : emailItem.val(),
            id: idItem.val(),
            pwd: pwdItem.val(),
            gender : $("input[type=radio][name=gender]:checked").val(),
            level : levelItem.val()
            
        },
        dataType: 'json',    
        method: 'POST',
        success: (result) => {
            if (pwdItem.val() == '') {
                $('#pwdinput').html("<p style='color:red;'>비밀번호를 입력해주세요</p>");
                $('#pwd').focus();
                
                return;
            }
            location.href = "list.html";
        },
        error: () => {
            window.alert('서버 실행 오류');
        }
    });
});

$(() => {
    $("#photo").on('change', function(){
        readURL(this);
    });
});
    function readURL(input) {
        if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
                $('#imag').attr('src', e.target.result);
        }
          reader.readAsDataURL(input.files[0]);
        } 
    }

function checkEmail() {
    var userEmail = $('#email').val();
    $
                    .ajax('../json/member/check-memb-email', {
                        dataType: 'json',
                data : {    
                    email : userEmail
                },
                success : function(data) {
                    var result = JSON.parse(data);
                    if (result.success) {
                        console.log("success");
                        passEmail = true;
                        $('#email').removeClass("form-control");
                        $('#email').removeClass(
                                "form-control is-invalid");
                        $('#email').addClass("form-control is-valid");
                        $('#validEmail').removeClass("valid-feedback");
                        $('#validEmail')
                                .removeClass("invalid-feedback");
                        $('#validEmail').addClass("valid-feedback");
                        document.querySelector('#validEmail').innerHTML = "사용 가능한 Email입니다";
                      /*   checkPass();  */
                    } else {
                        console.log("fail");
                        passEmail = false;
                        $('#email').removeClass("form-control");
                        $('#email').removeClass("form-control is-valid");
                        $('#email').addClass("form-control is-invalid");
                        $('#validEmail').removeClass("invalid-feedback");
                        $('#validEmail').removeClass("valid-feedback");
                        $('#validEmail').addClass("invalid-feedback");
                        document.querySelector('#validEmail').innerHTML = "이미 사용중인 Email입니다. 다른 Email을 입력해주세요";
                      /*   checkPass(); */
                    }
                }
            });
}

function checkID() {
    var userID = $('#id').val();
    
    $.ajax('../json/member/check-memb-id', {
               dataType: 'json',
                data : {
                    id : userID
                },
                success : function(data) {
                    var result = JSON.parse(data);
                    if (result.success) {
                        passID = true;
                        $('#id').removeClass("form-control");
                        $('#id').removeClass("form-control is-invalid");
                        $('#id').addClass("form-control is-valid");
                        $('#validID').removeClass("valid-feedback");
                        $('#validID').removeClass("invalid-feedback");
                        $('#validID').addClass("valid-feedback");
                        document.querySelector('#validID').innerHTML = "사용 가능한 ID입니다";
                     /*   checkPass();*/
                    } else {
                        passID = false;
                        $('#id').removeClass("form-control");
                        $('#id').removeClass("form-control is-valid");
                        $('#id').addClass("form-control is-invalid");
                        $('#validID').removeClass("invalid-feedback");
                        $('#validID').removeClass("valid-feedback");
                        $('#validID').addClass("invalid-feedback");
                        document.querySelector('#validID').innerHTML = "사용 불가능한 ID입니다. 다른 ID를 입력해주세요";
                   /*     checkPass();*/
                    }
                }
            });
}
    
  
updateBtn.click (() => {
    var formData = new FormData($("#form")[0]);
    $.ajax('../json/member/update', {
        data : formData,
        dataType: 'json',
        method: 'POST',
        processData : false,
        contentType : false,
        success: (result) => {
            
            $('#imag').change(() => {
                imd.html("");
                for (var data of result.status) {
                    var filename = data.photoName;
                  
                    return imd.html( '<img id="imag"  align="middle" src="/download/' + filename + '">');
                    }
                })
            if (pwdItem.val() == '') {
                $('#pwdinput').html("<p style='color:red;'>비밀번호를 입력해주세요</p>");
                $('#pwd').focus();
                return;
            } 
                location.href = "list.html";
            },
        error: () => {
            window.alert('서버 실행 오류');
        }
    });
});

deleteBtn.click (() => {
   
    $.ajax('../json/member/delete', {
        data: {
            m_no: noItem.val()
        },
        dataType: 'json',
        method: 'GET',
        success: (result) => {
            location.href = "list.html";
        },
        error: () => {
            window.alert('서버 실행 오류');
        }
    });
});




