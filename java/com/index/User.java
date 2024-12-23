package com.index;

public class User {
    
	private int id;
    private long age;
    private String phoneNo;
    private String username;
    private String gender;
    private String email;
    private String password;
    private String confirm_password;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        
            this.phoneNo = phoneNo;
        } 

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
       
            this.gender = gender;
        } 
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
       
            this.username = username;
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

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirmPassword(String confirm_Password) {

            this.confirm_password = confirm_Password;
        } 
}
