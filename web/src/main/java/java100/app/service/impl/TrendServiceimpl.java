package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.FileDao;
import java100.app.dao.TrendDao;
import java100.app.domain.Trend;
import java100.app.domain.UploadFile;
import java100.app.service.TrendService;
@Service
public class TrendServiceimpl implements TrendService {
    @Autowired
    TrendDao trendDao;
    @Autowired
    FileDao fileDao;
    
    @Override
    public List<Trend> list1(int pageNo, int pageSize, Map<String, Object> options) {
      
        HashMap<String, Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);


        if (options != null) {
            params.putAll(options);
        }

        return trendDao.findAll(params);
    }

    @Override
    public Trend get(int tr_no) {
        Trend trend = trendDao.findByNo(tr_no);
        return trend;
    }

    @Override
    public int add(Trend trend) {
        return trendDao.insert(trend);
    }

    @Override
    public int update(Trend trend) {
        int count = trendDao.update(trend);
        return count;
    }

    @Override
    public int delete(int tr_no) {
        return trendDao.delete(tr_no);
    }

}
