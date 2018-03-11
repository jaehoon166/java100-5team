package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Trend;

public interface TrendDao {
    List<Trend> findAll(Map<String,Object> params);
    Trend findByNo(int tr_no);
    int insert(Trend trend);
    int update(Trend trend);
    int delete(int tr_no);
}
