package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Trend;

public interface TrendService {
    List<Trend> list1(int pageNo, int pageSize, Map<String, Object> options);
    Trend get(int tr_no);
    int add(Trend trend);
    int update(Trend trend);
    int delete(int tr_no);
}
