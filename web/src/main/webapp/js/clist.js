var  prevBtn =  $('#prevBtn'),
    main = $('#main'),
     currBtn =  $('#currBtn'),
    nextBtn =  $('#nextBtn'),
    div = $('#list > #coli'),
    currPageNo = 1,
    friendmainuserPic = $('#js-friendloginuserPic'),
    friendmainuserId = $('#js-friendloginuserId'),
    friendmainuserName = $('#js-friendloginuserName');
 
template2Src = $('#templete2').html();
template2Engine = Handlebars.compile(template2Src);

template3Src = $('#templete3').html();
template3Engine = Handlebars.compile(template3Src);

var codyView = $('#codyView > div');
var mytbody = $('#mylist > tbody');
var tbody = $('#list > tbody');

var modalh = $('#modalsample > h5');

// 검색조건 함수 -------------------------------------------------
function PantsSize(value){
    
    if(value == 'pants') {
        location.href = 'list.html';
    } else {
    
        var pants = value;
    console.log( pants);

     load(1, {
         "pants": pants
     }) 
}
  
   
 }


function TopSize(value) {
    
    if(value == 'tops') {
        location.href = 'list.html';
    } else {
        
        var  tops = value;
        console.log( tops);

         load(1, {
             "tops": tops
         }) 
    }
         
 }

function sex(value){
   
  
    if(value == 'sexsum'){
        location.href = 'list.html';
    } else {
        
        var word = value;
        console.log(word);

         load(1, {
             "words": word
         }) 
        
    }
 } 


// ---------------------------------------------------- 검색조건 함수 끝

template2Src = $('#templete2').html();
template2Engine = Handlebars.compile(template2Src);

template3Src = $('#templete3').html();
template3Engine = Handlebars.compile(template3Src);

load2(1);
load3();

// 친구 목록 load -----------------------------------------------------
function load2(pageNo, options) {

    if (options == undefined) options = {};
    options.pn = pageNo;



    $.ajax('../json/friend/list', {
        /* method: 'GET', */
        data: options,
        dataType: 'json',
        success: (result) => {
                       if(result.loginUser.m_no == 0) {
                $('._ikq0n').css('display', 'none');
            } else {
          
            const friendfilename = result.findByMyNo.m_photo;
            if (friendfilename == null) {
                friendmainuserPic.prop('src', '../images/profile.gif');
            } else {
                friendmainuserPic.prop('src', '/download/' + friendfilename);
                
            }
            
            $('.mi').prop('href', '../member/form.html?no='+  result.loginUser.m_no);
            
           friendmainuserId.prop('href', '../member/view.html?no=' + result.loginUser.m_no);
           friendmainuserId.text(result.findByMyNo.id);
           friendmainuserName.text(result.findByMyNo.name);
        
           for (var friend of result.findFriend) {
            
               
               const divCount = $('div.js-newFriend').length;
               // 현재 접근하는 Form을 변수에 할당.
               var tempDiv = $('div.js-newFriend')[divCount - 1];
               
               FriendForm (result.loginUser.m_no, result.loginUser.id,
                           result.loginUser.m_photo,
                            friend.id, friend.m_no2, friend.f_photo, friend.intro)
            
           }
        }
       
            
            currPageNo = result.pageNo;
            currBtn.html(currPageNo);
       
            
            
            if (result.pageNo == 1) {
                $(prevBtn.parent()).addClass("disabled");
            } else {
                $(prevBtn.parent()).removeClass("disabled");
            }
            
            if (result.lastPageNo == result.pageNo) {
                $(nextBtn.parent()).addClass("disabled");
            } else {
                $(nextBtn.parent()).removeClass("disabled");
            }
        },
        error: () => {
            console.log('서버 실행 오류!');
        }
    });
    }



// ----------------------------------------------------- 친구 목록 load 끝
$('#main').load('../header.html', () => {
    
    load(1);
});

prevBtn.click (() => {
    load(currPageNo - 1) 
 });

 nextBtn.click (() => {
    load(currPageNo + 1) 
 });
 
 // 데일리 트랜드 게시물 로드 -------------------------------------------------
 function load3(options) {
     

     if (options == undefined) options = {};

     $.ajax('../json/trend/list', {
         dataType: 'json',
         success: (result) => {
          
         for (var trend of result.list1) {
     fillTrendForm (trend.tr_no, trend.photo, trend.op_tag);
   
     // 추가된 Form 개수를 변수에 할당
     const ulCount = $('ul.js-newTrend').length;
     // 현재 접근하는 Form을 변수에 할당.
     var tempUl = $('ul.js-newArticle')[ulCount - 1];
 }
 }, 
 error: () => {
     window.alert('서버실행 오류!');
 }
});
}
 
 // ------------------------------------------------데일리 트렌드 로드 끝
 
 
 // 메인 코디 리스트 로드 ----------------------------------------------
 function load (pageNo, options) {
     
     if (options == undefined) {
         options = {};
     }
     
    
     options.pn = pageNo;
 
     $('#coli').html("");
     
     
     $.ajax('../json/cody/list', {
         data: options,
         dataType: 'json',
         success: (result) => {
         
             console.log('결과------------------------------------------');
             console.log(result);
             console.log('결과------------------------------------------');
             for (var data of result.list) {
                
                 fillArticleForm(data.writer.m_photo, data.wtest, data.co_photo,
                             data.co_no, data.writer_no, data.likedcount, result.loginUser.id
                             );
             // 추가된 Form 개수를 변수에 할당.
             const articleCount = $('article.js-newArticle').length;
             
             // 현재 접근하는 Form을 변수에 할당.
             var tempArticle = $('article.js-newArticle')[articleCount - 1];

             
                 // CASE :: 게시글 작성자와 로그인한 유저가 다른 경우, 수정/삭제 기능을 블록.
                 if (data.writer_no !== result.loginUser.m_no) {
                     const targetDom = $(tempArticle).find('.js-editwrap');
                     $(targetDom).css('display', 'none');
                 }
                 
                 // CASE :: 게시글 작성자와 로그인한 유저가 다른 경우, 수정/삭제 기능을 블록.
                 if (data.writer_no == result.loginUser.m_no) {
                     
                     const targetFriend = $(tempArticle).find('#js-followbtn' + data.co_no);
                     $(targetFriend).css('display', 'none');
                 }
           
      
                 // CASE :: 로그인한 유저가 좋아요를 클릭한 게시물인 경우,
                 // 좋아요 버튼 초록색 / 아닌경우는 흰색.
                   
                    for (var likedMember of result.likedAll) {
                        
                        if (likedMember.m_no == result.loginUser.m_no && likedMember.co_no == data.co_no) {
                           var targetDom3 = $(tempArticle).find('#js-likebtn' + data.co_no);
                            targetDom3.removeClass('js-button').addClass('js-hoverbutton');
                        } 
                    }
                    
         }
             
             currPageNo = result.pageNo;
             currBtn.html(currPageNo);
             
             /* console.log(result); */
             
             if (result.pageNo == 1) {
                 $(prevBtn.parent()).addClass("disabled");
             } else {
                 $(prevBtn.parent()).removeClass("disabled");
             }
             
             if (result.lastPageNo == result.pageNo) {   
                 $(nextBtn.parent()).addClass("disabled");
             } else {
                 $(nextBtn.parent()).removeClass("disabled");
             }
             
         },
         
         error: () => {
             window.alert('서버실행 오류!');
         }
     });
 }
 
 
 // ---------------------------------------------- 메인 코디 리스트 로드 끝
 
 /**
	 * DESC :: Article 템플릿을 동적으로 생성하는 함수입니다.
	 * 
	 * @param userPic :
	 *            String / 유저 사진
	 * @param userId :
	 *            String / 유저 아이디
	 * @param contentPic :
	 *            String / 게시물 사진
	 * @param contentNO :
	 *            int / 게시물 번호
	 * @param writerNo :
	 *            int / 게시물 작성자번호
	 * @param listLikedCount:
	 *            int / 좋아요 갯수
	 * @return null
	 */
 
function fillArticleForm (userPic, userId, contentPic, contentNo, writerNo,
                          listLikedCount) {
 
        const article = document.createElement('article');
        const $article = $(article);
    article.innerHTML = $('#postTemplate')[0].innerHTML;
    
    // Article 태그에 클래스 적용.
    $article.addClass('post-wrap');
    $article.addClass('js-newArticle');
    
    // [1] Template의 User pic의 src 값을 변경한다.
    if(userPic == null) {
        $($article.find('.js-userPic')).prop('src', '../images/profile.gif');
    } else {
        $($article.find('.js-userPic')).prop('src', '/download/' + userPic);
    }
    
    
    // [2] Template의 User ID 의 값을 변경한다.
    $($article.find('.js-userId')).text(userId);
    
    // [3] Template 의 cldeletBtn 실행시 게시물의 번호값 받아서 삭제 실행
    $($article.find('.cldeleteBtn')).attr('onclick','deleteposterFunction('+ contentNo + ')');
    
    // [4] Template 의 cldeletBtn 실행시 게시물 번호, 작성자 번호값 받아서 view로 이동
    $($article.find('.clchangeBtn')).attr('onclick','changeposterFunction('+ contentNo + ',' + writerNo +')');
    
    // [5] Template의 Content pic의 src 값을 변경한다.
    $($article.find('.js-contentPic')).prop('src', '/download/' + contentPic);
    
    // [6] Template의 좋아요 버튼에 name값에 게시물 번호 삽입.
    $($article.find('.js-likedBtn')).prop('id', 'js-likebtn' + contentNo);
    
    // [6-1] listLikedCount 게시물 번호로 id 값 지정 / 좋아요 수를 p태그에 삽입
    $($article.find('.js-countliked')).prop('id', 'js-countlike' + contentNo).text('좋아요' + listLikedCount + '개');
    
    // [6-2] Template의 listLikedCount 증가.
    $($article.find('.js-likedBtn')).attr('onclick','uplikedcountFunction('+ contentNo + ')');
    
   
    // [6-3] Template의 js-likebtn 의 값을 찾아 마우스가 중심으로 이동시 text 값에 +1 출력
    $($article.find('#js-likebtn' + contentNo)).mouseenter(function(){
        $('#js-countlike' + contentNo).text('+1');
      });
 // [6-3] Template의 js-likebtn 의 값을 찾아 마우스가 중심을 벗어 날 경우 text 값에 좋아요수 출력
    $($article.find('#js-likebtn' + contentNo)).mouseleave(function(){
        $('#js-countlike' + contentNo).text('좋아요' + listLikedCount + '개');
      });
    
    
    $($article.find('.js-followBtn')).prop('id', 'js-followbtn' + contentNo);
    $($article.find('.js-followBtn')).attr('onclick','followFunction('+ writerNo + ')');
    
    $($article.find('.js-modalBtn')).prop('data-mno4', 'js-modalbtn' + contentNo);
    $($article.find('.js-modalBtn')).prop('data-mno5', 'js-modalbtn' + writerNo);
    $($article.find('.js-modalBtn')).attr('onclick','modalViewFunction('+ writerNo + ',' + contentNo + ')');
    
    /*
	 * // Template 의 Content No 의 값을 설정 나중에 필요없으면 삭제할 것!!
	 * $($article.find('.js-contentNo')).text(contentNo);
	 */
  
    // coli 라는 div에 article 추가.
    $('#coli').append(article);
    
}

function modalViewFunction(writerNo,contentNo) {
    
    
    $.ajax('../json/friend/list', {
        data: {
            codyNo : contentNo,
            codyWno : writerNo
        },
        dataType: 'json',
        success: (result) => {
         
            codyView.html(template3Engine(result));
            
            $('.bd-example-modal-lg').modal('show')
            
            /*--------------------------- 덧글등록  ---------------------------------------------*/
            var commentBtn =  $('#commentBtn');
            
            
            
            commentBtn.click((event) => {
                
                var commentForm = new FormData($("#commentForm")[0]);
                
                $.ajax('../json/cody_comment/add', {
                    /* method: 'GET', */
                    data: commentForm,
                    method: 'POST',
                    processData : false,
                    contentType : false,
                    dataType: 'json',
                    success: (result) => {
                        $.ajax('../json/friend/list', {
                            data: {
                                codyNo : contentNo,
                                codyWno : writerNo
                            },
                            dataType: 'json',
                            success: (result) => {
                             
                                codyView.html(template3Engine(result));
                                
                                $('.bd-example-modal-lg').modal('show');
                            },
                            error: () => {
                                console.log('덧글 실행 오류!');
                            }
                        });
                    },
                    error: () => {
                        console.log('덧글 실행 오류!');
                    }
                });
               
            });

            console.log(result);
            for (var comm of result.comment) {
                const commentdelete = $('#commentdeleteBtn' + comm.com_no);
                commentdelete.click(() => {
                    
                    $.ajax('../json/cody_comment/delete', {
                        data: {
                            com_no : comm.com_no
                        },
                        dataType: 'json',
                        success: (result) => {
                           
                            $.ajax('../json/friend/list', {
                                data: {
                                    codyNo : contentNo,
                                    codyWno : writerNo
                                },
                                dataType: 'json',
                                success: (result) => {
                                    
                                    codyView.html(template3Engine(result));
                                    
                                    $('.bd-example-modal-lg').modal('show');
                                },
                                error: () => {
                                    console.log('덧글 실행 오류!');
                                }
                            });
                        },
                        error: () => {
                            console.log('덧글 삭제 오류!');
                        }
                    });
                   
                });
            }
            
         
           
    },
    error: () => {
        window.alert('서버실행오류');
    }
});
}



function followFunction(writerNo) {
  
    $.ajax('../json/friend/add', {
        data: {
            writer_no : writerNo
        },
        dataType: 'json',
        success: (result) => {
            location.href = 'list.html';
    },
    error: () => {
        window.alert('서버실행오류');
    }
});
}

// 삭제 버튼을 누르면 실행되는 함수
function  deleteposterFunction(contentNo) {
    
    $.ajax('../json/cody/delete', {
        data: {
            co_no : contentNo
        },
        dataType: 'json',
        success: (result) => {
            location.href = 'list.html';
    },
    error: () => {
        window.alert('서버실행오류');
    }
});
}

// 수정 버튼을 누르면 실행되는 함수
function  changeposterFunction(contentNo, writerNo) {
    location.href = 'view.html?no=' + contentNo +',' + writerNo;
}

// 좋아요 버튼 클릭시 실행
function uplikedcountFunction(contentNo) {
  
    $.ajax('../json/cody/liked', {
        data : {
          co_no : contentNo  
          
        },
        method : 'POST',
        dataType: 'json',
        success: function(result) {
           
            const finder = $('#js-likebtn' + contentNo);
           finder.removeClass('js-button').addClass('js-hoverbutton');
      
    },
    error: () => {
        window.alert('서버실행오류');
    }
      
});
    
}


/*******************************************************************************
 * * DESC :: Trend 템플릿을 동적으로 생성하는 함수입니다.
 * 
 * @param TrendNo :
 *            트렌드 게시물 번호
 * @param TrendPic :
 *            트렌드 사진
 * @param TrendTag :
 *            트렌드 해시태그
 * @return null
 */
function fillTrendForm (TrendNo, TrendPic, TrendTag) {

const trend = document.createElement('ul');
const $trend = $(trend);
trend.innerHTML = $('#TrendTemplete')[0].innerHTML;
    
    $trend.addClass('js-newTrend');
    
    $($trend.find('.js-link')).prop('id', 'js-alink' + TrendNo);

    $($trend.find('#js-alink' + TrendNo)).prop('href', '../trend/delete?tr_no=' + TrendNo);
    
    
    $($trend.find('.js-trendimage')).prop('id', 'js-trendpic' + TrendNo);
    $($trend.find('#js-trendpic' + TrendNo)).prop('src', '/download/' + TrendPic);
    
    
    $($trend.find('.js-trtag')).prop('id', 'js-trendtag' + TrendNo);
    $($trend.find('#js-trendtag' + TrendNo)).prop('lang', TrendTag);  
    $($trend.find('.js-trtag')).attr('onclick', 'if(this.lang) HashTag(this.lang);');
    
    $('#trendli').append(trend);


}

function HashTag(lang){

    alert(lang);
    
        var h_tag = lang;
        console.log(h_tag);

         load(1, {
             h_tag: h_tag
         }) 
        
   
 } 





// Friend Templete
/*******************************************************************************
 * 
 * @param MyNo :
 *            로그인한 User No
 * @param MyId :
 *            로그인한 User ID
 * @param MyProfile :
 *            로그인한 User 사진
 * @param FriendId :
 *            팔로우한 유저 ID
 * @param FriendNo :
 *            팔로우한 유저 No
 * @param FriendProfile :
 *            팔로우한 유저 사진
 * @param FriendComment :
 *            팔로우한 유저 코멘트
 * @returns NULL
 */
function FriendForm (MyNo, MyId, MyProfile, FriendId, FriendNo, FriendProfile, FriendComment) {

    const friend  = document.createElement('div');
    const $friend = $(friend);
    friend.innerHTML = $('#FriendTemplete')[0].innerHTML;
    
    $friend.addClass('_havey');
    $friend.addClass('js-newFriend');
    if(FriendProfile == null) {
        $($friend.find('.js-friendprofile')).prop('src', '../images/profile.gif');
    } else {
        $($friend.find('.js-friendprofile')).prop('src', '/download/' + FriendProfile);
    }
    $($friend.find('.js-friendview')).prop('href', '../member/view.html?no=' + FriendNo);
    
    
    $($friend.find('.js-friendId')).text(FriendId)
    
    if(FriendComment == null) {
        $($friend.find('.js-friendintro')).text('코멘트가 없습니다');   
    } else {
        $($friend.find('.js-friendintro')).text(FriendComment);
    }
    $($friend.find('.followdeleteBtn')).prop('id', 'js-frienddeleteBtn' + MyNo + FriendNo);
    $($friend.find('.followdeleteBtn')).attr('onclick', 'frienddeleteBtnFunction(' + MyNo +',' + FriendNo +')');
    $('#js-friendlist').append(friend);
}


/*
 * function modalViewFunction(FriendNo, FriendId) {
 * 
 * 
 * $.ajax('../json/friend/list', { data: { fd_no : FriendNo, show_no : FriendId },
 * dataType: 'json', success: (result) => {
 * 
 * 
 * 
 * $('#FollowDeleteModal').modal('show')
 * 
 *  }, error: () => { window.alert('서버실행오류'); } }); }
 */

function frienddeleteBtnFunction(MyNo, FriendNo)  {
$.ajax('../json/friend/delete', {
data: {
m_no : MyNo,
m_no2 : FriendNo
},
dataType: 'json',
success: (result) => {
 location.href = 'list.html';

},
error: () => {
window.alert('서버실행오류');
}

});

}


