package util;

import javafx.scene.control.CheckBox;

import java.io.Serializable;

public class Registered implements Serializable {

    private String user_name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
   // private String occupation;
    private int applied_for;
    //private String other_pets;
    private String application_date;
    private boolean check;
    public Registered(){}
    public Registered(String user_name, int applied_for, String application_date,String name) {
        this.user_name = user_name;
        this.applied_for = applied_for;
        this.application_date = application_date;
//        this.check=new CheckBox("");
        this.check=false;
        this.name=name;
    }
//private String contact_no;
   //private String address;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

//    public String getOccupation() {
//        return occupation;
//    }

//    @Override
//    public String toString() {
//        return "Registered{" +
//                "user_name='" + user_name + '\'' +
//                ", applied_for=" + applied_for +
//                ", application_date='" + application_date + '\'' +
//                '}';
//    }
//
//    public void setOccupation(String occupation) {
//        this.occupation = occupation;
//    }

    public int getApplied_for() {
        return applied_for;
    }

    public void setApplied_for(int applied_for) {
        this.applied_for = applied_for;
    }

//    public String getOther_pets() {
//        return other_pets;
//    }
//
//    public void setOther_pets(String other_pets) {
//        this.other_pets = other_pets;
//    }

    public String getApplication_date() {
        return application_date;
    }

    public void setApplication_date(String application_date) {
        this.application_date = application_date;
    }

    public boolean getCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
//    public String getContact_no() {
//        return contact_no;
//    }
//
//    public void setContact_no(String contact_no) {
//        this.contact_no = contact_no;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
}
