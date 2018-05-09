package com.developergmail.jjb;

import java.sql.SQLException;
import java.util.Map;

public abstract class Ref {

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

    public abstract String getBaseTypeName() throws SQLException;

    public abstract Object getObject(Map<String, Class<?>> map) throws SQLException;

    public abstract Object getObject() throws SQLException;

    public abstract void setObject(Object o) throws SQLException;
}