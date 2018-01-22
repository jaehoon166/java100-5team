package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Board;
import java100.app.domain.Score;
import java100.app.domain.UploadFile;

// 역할을 강조할 떄는 객체 라는 말보다는 컴퓨넌트라는 말을 사용한다.
// Service 컴포넌트
public interface BoardService {

    List<Board> list(int pageNo, int pageSize, Map<String,Object> options);
    Board get(int no);
    int getTotalCount();
    int add(Board score);
    int update(Board score);
    int delete(int no);
    void addFiles(List<UploadFile> files, int boardNo);
    
}
