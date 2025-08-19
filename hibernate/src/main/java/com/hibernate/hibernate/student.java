package com.hibernate.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
// @table(name="students table") isse aap table ka naam change kar sakte ho ye laga ke 
public class student {
    @Id
    int ID;
    String name;
    String StudentClass;
    public int getID(){
        return ID;
    }
    public void setID( int ID){
        this.ID=ID;
    }
     public String getname(){
        return name;
    }
    public void setname( String name){
        this.name=name;
    }
     public String getStudentClass(){
        return StudentClass;
    }
    public void setStudentClass( String StudentClass){
        this.StudentClass=StudentClass;
    }

}
