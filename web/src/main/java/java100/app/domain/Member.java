package java100.app.domain;

<<<<<<< HEAD
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



=======

public class Member {

    protected int no;
    protected String name;
    protected String email;
    protected String password;
    protected int age;
    protected String phone;
    protected String gender;
    protected int level;


    public Member() {
    }

    public Member(int no, String name, String email, int age, String phone, String gender,int level) {
        this.no = no;
        this.name = name;
        this.email = email;
        this.age =age;
        this.phone =phone;
        this.gender =gender;
        this.level =level;
    }

    @Override
    public String toString() {
        return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", age=" + age
                + ", phone=" + phone + ", gender=" + gender + ", level=" + level + "]";
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

>>>>>>> a5885bab4d7bce10150506e430fc8763e9a6a31c
    public String getName() {
        return name;
    }

<<<<<<< HEAD


=======
>>>>>>> a5885bab4d7bce10150506e430fc8763e9a6a31c
    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD


=======
>>>>>>> a5885bab4d7bce10150506e430fc8763e9a6a31c
    public String getEmail() {
        return email;
    }

<<<<<<< HEAD


=======
>>>>>>> a5885bab4d7bce10150506e430fc8763e9a6a31c
    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD


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



=======
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

>>>>>>> a5885bab4d7bce10150506e430fc8763e9a6a31c
    public int getAge() {
        return age;
    }

<<<<<<< HEAD


=======
>>>>>>> a5885bab4d7bce10150506e430fc8763e9a6a31c
    public void setAge(int age) {
        this.age = age;
    }

<<<<<<< HEAD


    public String getGender() {
        return gender;
    }



    public void setGender(String gender) {
        this.gender = gender;
    }



=======
>>>>>>> a5885bab4d7bce10150506e430fc8763e9a6a31c
    public String getPhone() {
        return phone;
    }

<<<<<<< HEAD


=======
>>>>>>> a5885bab4d7bce10150506e430fc8763e9a6a31c
    public void setPhone(String phone) {
        this.phone = phone;
    }

<<<<<<< HEAD


    public String getIntro() {
        return intro;
    }



    public void setIntro(String intro) {
        this.intro = intro;
    }



=======
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

>>>>>>> a5885bab4d7bce10150506e430fc8763e9a6a31c
    public int getLevel() {
        return level;
    }

<<<<<<< HEAD


=======
>>>>>>> a5885bab4d7bce10150506e430fc8763e9a6a31c
    public void setLevel(int level) {
        this.level = level;
    }


<<<<<<< HEAD
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









=======
}
>>>>>>> a5885bab4d7bce10150506e430fc8763e9a6a31c
