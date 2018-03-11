package java100.app.domain;

public class Member {
    
    protected int m_no;
    protected String m_photo;
    protected String name;
    protected String email;
    protected String id;
    protected String pwd;
    protected int age;
    protected String gender;
    protected String phone;
    protected String intro;
    protected int level;
    
        
    protected int friend_count;
    protected int likeAll_count;
    protected int title_count;
    
    public Member() {}


    @Override
    public String toString() {
        return "Member [m_no=" + m_no + ", m_photo=" + m_photo + ", name=" + name + ", email=" + email + ", id=" + id
                + ", pwd=" + pwd + ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", intro=" + intro
                + ", level=" + level + ", friend_count=" + friend_count + ", likeAll_count=" + likeAll_count
                + ", title_count=" + title_count + "]";
    }






    public int getM_no() {
        return m_no;
    }



    public void setM_no(int m_no) {
        this.m_no = m_no;
    }



    public String getM_photo() {
        return m_photo;
    }



    public void setM_photo(String m_photo) {
        this.m_photo = m_photo;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



    public String getPwd() {
        return pwd;
    }



    public void setPwd(String pwd) {
        this.pwd = pwd;
    }



    public int getAge() {
        return age;
    }



    public void setAge(int age) {
        this.age = age;
    }



    public String getGender() {
        return gender;
    }



    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getIntro() {
        return intro;
    }



    public void setIntro(String intro) {
        this.intro = intro;
    }



    public int getLevel() {
        return level;
    }



    public void setLevel(int level) {
        this.level = level;
    }


    public int getFriend_count() {
        return friend_count;
    }


    public void setFriend_count(int friend_count) {
        this.friend_count = friend_count;
    }


    public int getLikeAll_count() {
        return likeAll_count;
    }


    public void setLikeAll_count(int likeAll_count) {
        this.likeAll_count = likeAll_count;
    }


    public int getTitle_count() {
        return title_count;
    }


    public void setTitle_count(int title_count) {
        this.title_count = title_count;
    }


  
    
}









