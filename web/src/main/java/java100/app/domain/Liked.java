package java100.app.domain;

public class Liked {
    protected int co_no;
    protected int m_no;
    protected String name;
    protected int likedcount;
   
    
    @Override
    public String toString() {
        return "Liked [co_no=" + co_no + ", m_no=" + m_no + ", name=" + name + ", likedcount=" + likedcount + "]";
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLikedcount() {
        return likedcount;
    }
    public void setLikedcount(int likedcount) {
        this.likedcount = likedcount;
    }
    
    
}
