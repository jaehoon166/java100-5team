package java100.app.dao;

import java.util.List;

import java100.app.domain.UploadFile;

public interface FileDao {
    void insert(UploadFile file);

    List<UploadFile> findByBookNo(int no);

    void deleteAllByBookNo(int no);
}
