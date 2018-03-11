package java100.app.web.bind;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice // 모든 페이지 컨트롤러에 충고한다.
public class DefaultControllerAdvice {

    @InitBinder // 요청 핸들러가 호출되기 전에 먼저 실행된다.
    protected void initBinder(WebDataBinder binder) {
        System.out.println("DefaultControllerAdvice.initBinder()");

        // 문자열을 날짜 객체로 만들어줄 도구를 준비한다.
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // 날짜 형식을 엄격하게 검사하라!

        // 스프링에서 제공하는 문자열을 날짜 객체로 변환시켜주는
        // 커스텀 에디터를 준비하여
        // WebDataBinder에 등록한다.
        binder.registerCustomEditor(Date.class, // 문자열을 어떤 타입으로 바꿀지 설정한다
                new CustomDateEditor( // 문자열을 java.util.Date 객체로 만들어 준다.
                        dateFormat, // 실제로는 그 작업을 SimpleDateFormat이 한다.
                        false)); // 문자열 값이 비어 있는 것을 허락할 것인지 여부!
    }
}