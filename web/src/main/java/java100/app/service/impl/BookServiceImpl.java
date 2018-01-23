package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.BookDao;
import java100.app.dao.FileDao;
import java100.app.domain.Book;
import java100.app.domain.UploadFile;
import java100.app.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;
    @Autowired
    FileDao fileDao;

    @Override
    public List<Book> list(int pageNo, int pageSize, Map<String, Object> options) {

        HashMap<String, Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);

        if (options != null) {
            params.putAll(options);
        }

        return bookDao.findAll(params);
    }

    @Override
    public int getTotalCount() {
        return bookDao.countAll();
    }

    @Override
    public Book get(int no) {
        Book book = bookDao.findByNo(no);
        return book;
    }


    @Override
    public int add(Book book) {

        int count = bookDao.insert(book);

        this.addFiles(book.getFiles(), book.getNo());

        return count;
    }

    @Override
    public int update(Book book) {

        int count = bookDao.update(book);

        fileDao.deleteAllByBookNo(book.getNo());

        addFiles(book.getFiles(), book.getNo());

        return count;
    }

    @Override
    public int delete(int no) {


        return bookDao.delete(no);
    }

    @Override
    public void addFiles(List<UploadFile> files, int bookNo) {
        for (UploadFile file : files) {
            file.setBookNo(bookNo);
            fileDao.insert(file);
        }
    }

}
