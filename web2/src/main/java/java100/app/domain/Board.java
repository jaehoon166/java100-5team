package java100.app.domain;

import java.sql.Date;
import java.util.List;

public class Board {
    protected int no;
    protected String title;
    protected String content;
    protected Date regDate;
    protected int viewCount;
    protected Member writer;
<<<<<<< HEAD
    String filename;
    protected List<UploadFile> files;
    
=======
    protected List<UploadFile> files;
>>>>>>> 18e9bd3c43c2b64fe3dd1a31a70bfef9dcdfc888

    @Override
    public String toString() {
        return "Board [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", viewCount="
<<<<<<< HEAD
                + viewCount + ", writer=" + writer + ", files=" + files + ", filename=" + filename + "]";
=======
                + viewCount + "]";
>>>>>>> 18e9bd3c43c2b64fe3dd1a31a70bfef9dcdfc888
    }

    public Member getWriter() {
        return writer;
    }

    public void setWriter(Member writer) {
        this.writer = writer;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public List<UploadFile> getFiles() {
        return files;
    }

    public void setFiles(List<UploadFile> files) {
        this.files = files;
    }

<<<<<<< HEAD
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    
=======

>>>>>>> 18e9bd3c43c2b64fe3dd1a31a70bfef9dcdfc888
}
