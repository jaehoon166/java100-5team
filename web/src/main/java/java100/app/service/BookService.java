package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Book;
import java100.app.domain.UploadFile;

public interface BookService {
    List<Book> list(int pageNo, int pageSize, Map<String, Object> options);
    int getTotalCount();
    Book get(int no);
    int add(Book book);
    int update(Book book);
    int delete(int no);
    void addFiles(List<UploadFile> files, int bookNo);
}
