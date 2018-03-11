package java100.app.service;

import java.util.List;

import java100.app.domain.Liked;

public interface LikedService {
    List<Liked> list(int co_no);
    Liked get(int co_no);
    int add(Liked liked);
    int delete(int co_no);
   
    //Liked 테이블  코디 리스트에서 한번에 출력
    List<Liked> getAll();
}
