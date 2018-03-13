var mydiv = $('#mylist > div');

template0Src = $('#mytemp').html();
template0Engine = Handlebars.compile(template0Src);


load2();

function load2() {

    /*if (options == undefined) options = {};
    options.pn = pageNo;*/

    
    var index = location.href.indexOf('?');
    var qs = location.href.substr(index + 1);
    var arr = qs.split('=');
    
    $.ajax('../json/member/' + arr[1], {
        method: 'GET',
       /* data: options,*/
        dataType: 'json',
        success: (result) => {
            console.log(result);
            
            mydiv.html(template0Engine(result));
          /*  
            currPageNo = result.pageNo;
            currBtn.html(currPageNo);*/
       
            
            
    /*        if (result.pageNo == 1) {
                $(prevBtn.parent()).addClass("disabled");
            } else {
                $(prevBtn.parent()).removeClass("disabled");
            }
            
            if (result.lastPageNo == result.pageNo) {
                $(nextBtn.parent()).addClass("disabled");
            } else {
                $(nextBtn.parent()).removeClass("disabled");
            }*/
        },
        error: () => {
            console.log('서버 실행 오류!');
        }
    });
    }






$('#main').load('../header.html', () => {
    
    load2();
});


 







