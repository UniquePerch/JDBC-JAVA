package com.learning.entity;

public class MyStudent {
    private int myid;
    private String myname;
    private String myemail;
    private int myage;

    @Override
    public String toString() {
        return "MyStudent{" +
                "myid=" + myid +
                ", myname='" + myname + '\'' +
                ", myemail='" + myemail + '\'' +
                ", myage=" + myage +
                '}';
    }

    public int getMyid() {
        return myid;
    }

    public void setMyid(int myid) {
        this.myid = myid;
    }

    public String getMyname() {
        return myname;
    }

    public void setMyname(String myname) {
        this.myname = myname;
    }

    public String getMyemail() {
        return myemail;
    }

    public void setMyemail(String myemail) {
        this.myemail = myemail;
    }

    public int getMyage() {
        return myage;
    }

    public void setMyage(int myage) {
        this.myage = myage;
    }
}
