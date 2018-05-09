package com.developergmail.jjb;

public class Ref {

    private String Firstname;
    private String Lastname;
    public Ref(String Firstname, String Lastname){
        this.Firstname=Firstname;
        this.Lastname=Lastname;

    }
    public Ref(){

}

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }
}