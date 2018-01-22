package java100.app.dao;

import java.util.List;

import java100.app.domain.UploadFile;

public interface FileDao {
    
    List<UploadFile> findByBoardNo(int no);
    void insert(UploadFile file);
    void deleteAllByBoardNo(int no);
    

        
    
}
