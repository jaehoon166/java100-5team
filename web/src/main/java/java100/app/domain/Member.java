package java100.app.domain;

import java.sql.Date;

public class Member {

    protected int no;
    protected String name;
    protected String email;
    protected String password;
    protected Date createDate;
   
    
    public Member() {
        
    }
    public Member(int no, String name, String email, Date createDate) {
        this.no = no;
        this.name = name;
        this.email = email;
        this.createDate = createDate;
       
    }
    
   
    
    
    @Override
    public String toString() {
        return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", createDate="
                + createDate + "]";
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    
    
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
   
    
    
   
    
}
