package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Board;
import java100.app.domain.UploadFile;

public interface BoardService {
    List<Board> list(int pageNo, int pageSize, Map<String, Object> options);
    Board get(int no);
    int getTotalCount();
    int add(Board board);
    int update(Board board);
    int delete(int no);
    void addFiles(List<UploadFile> files, int boardNo);
}
