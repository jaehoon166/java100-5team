package java100.app.domain;

public class Friend {
    
    protected int m_no;
    protected int m_no2;
  /*  protected String email;*/
    protected String f_photo;
    protected String m_photo;
    protected String id;
    protected String intro;
    protected String name;
        
    
    @Override
    public String toString() {
        return "Friend [m_no=" + m_no + ", m_no2=" + m_no2 + ", f_photo=" + f_photo + ", m_photo=" + m_photo + ", id="
                + id + ", intro=" + intro + ", name=" + name + "]";
    }
    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public int getM_no() {
        return m_no;
    }
    public void setM_no(int m_no) {
        this.m_no = m_no;
    }
    public int getM_no2() {
        return m_no2;
    }
    public void setM_no2(int m_no2) {
        this.m_no2 = m_no2;
    }
    public String getF_photo() {
        return f_photo;
    }
    public void setF_photo(String f_photo) {
        this.f_photo = f_photo;
    }
    public String getM_photo() {
        return m_photo;
    }
    public void setM_photo(String m_photo) {
        this.m_photo = m_photo;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
