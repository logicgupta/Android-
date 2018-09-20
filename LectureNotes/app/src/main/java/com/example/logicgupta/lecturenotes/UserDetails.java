package com.example.logicgupta.lecturenotes;

public class UserDetails {
    String name,email,phone,college,branch;
   public UserDetails(){

    }
    public UserDetails(String name,String email,String phone,String college,String branch){
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.college=college;
        this.branch=branch;
    }

    public String getName(){
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getEmail() {
        return email;
    }

    public String getCollege() {
        return college;
    }

    public String getPhone() {
        return phone;
    }
}
