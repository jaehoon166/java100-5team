package java100.app.domain;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


}
