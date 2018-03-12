var caddBtn = $('#caddBtn'),
    title = $('#title'),
    conts = $('#conts'),
    gender = $('#gender'),
    no = $('#co_no'),
    htag = $('#h_tag'),
    top = $("input[type=radio][name=top]:checked").val(),
    gender = $("input[type=radio][name=gender]:checked").val(),
    pants = $("input[type=radio][name=pants]:checked").val(),
    file = $('#file1');


$('header').load('../header.html');
var index = location.href.indexOf('?'); 

if (index != -1) {
var qs = location.href.substr(index + 1);
var arr = qs.split('=');
$('.my-new').css('display', 'none');
// $(딱한번만 호출할 함수);

$ (() => {
    
    $.ajax('../json/cody/' + arr[1], {
        dataType: 'json',
        success: (result) => {
            title.val(result.data.title);   
            conts.val(result.data.conts);
            htag.val(result.data.htag);
            gender.val(result.data.gender);
            top.val(result.data.top);
            pants.val(result.data.pants);
            console.log(result.data.co_photo);
        },
        
        error: () => {
            window.alert('서버 실행 오류');
        }
    });
});

} else {
    $('.my-view').css('display', 'none');
}

caddBtn.click (() => {
    var formData = new FormData($("#codyform")[0]);
    $.ajax('../json/cody/add', {
       data: formData,
       dataType: 'json',
       method: 'POST',
       processData : false,
       contentType : false,
       success: (result) => {
           location.href = "list.html";
       }, 
       error: () => {
           window.alert('서버 실행 오류');
       }
    });
});



