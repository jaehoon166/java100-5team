package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Score;

public interface ScoreService {
    List<Score> list(int pageNo, int pageSize, Map<String, Object> options);
    Score get(int no);
    int getTotalCount();
    int add(Score score);
    int update(Score score);
    int delete(int no);
}
