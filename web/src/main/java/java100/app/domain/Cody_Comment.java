package java100.app.domain;

import java.sql.Date;

public class Cody_Comment {
    protected int com_no;
    protected int co_no;
    protected int m_no;
    protected String conts;
    protected Date date;
    protected String changetime;
    protected String id;
    protected String m_photo;
    protected String comment_photo;


    @Override
    public String toString() {
        return "Cody_Comment [com_no=" + com_no + ", co_no=" + co_no + ", m_no=" + m_no + ", conts=" + conts + ", date="
                + date + ", changetime=" + changetime + ", id=" + id + ", m_photo=" + m_photo + ", comment_photo="
                + comment_photo + "]";
    }


    public String getComment_photo() {
        return comment_photo;
    }


    public void setComment_photo(String comment_photo) {
        this.comment_photo = comment_photo;
    }


    public String getM_photo() {
        return m_photo;
    }


    public void setM_photo(String m_photo) {
        this.m_photo = m_photo;
    }


    public int getCom_no() {
        return com_no;
    }


    public void setCom_no(int com_no) {
        this.com_no = com_no;
    }


    public int getCo_no() {
        return co_no;
    }


    public void setCo_no(int co_no) {
        this.co_no = co_no;
    }


    public int getM_no() {
        return m_no;
    }


    public void setM_no(int m_no) {
        this.m_no = m_no;
    }


    public String getConts() {
        return conts;
    }


    public void setConts(String conts) {
        this.conts = conts;
    }


    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getChangetime() {
        return changetime;
    }


    public void setChangetime(String changetime) {
        this.changetime = changetime;
    }



    
}
