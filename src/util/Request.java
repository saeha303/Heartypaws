package util;

import java.io.Serializable;

public class Request implements Serializable {

private  int serial_no;
    private String application_date;
    private String name;
    private String contact_no;
    private String address;
    private String email;
    private String rescue_date;

    public Request() {
    }

    public Request(int serial_no, String application_date, String name, String contact_no, String address, String email, String rescue_date, String animal_type, String physical_condition) {
        this.serial_no = serial_no;
        this.application_date = application_date;
        this.name = name;
        this.contact_no = contact_no;
        this.address = address;
        this.email = email;
        this.rescue_date = rescue_date;
        this.animal_type = animal_type;
        this.physical_condition = physical_condition;
    }

    private String animal_type;
    private String physical_condition;

    public int getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(int serial_no) {
        this.serial_no = serial_no;
    }

    public String getApplication_date() {
        return application_date;
    }

    public void setApplication_date(String application_date) {
        this.application_date = application_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRescue_date() {
        return rescue_date;
    }

    public void setRescue_date(String rescue_date) {
        this.rescue_date = rescue_date;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }

    public String getPhysical_condition() {
        return physical_condition;
    }

    public void setPhysical_condition(String physical_condition) {
        this.physical_condition = physical_condition;
    }
}
