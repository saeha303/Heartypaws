package util;

import java.io.Serializable;

public class OldStaff implements Serializable {

    private int employee_id;

//    public OldStaff(int employee_id, String name, String contact_no, String email, String address, String date_of_birth, String gender, String job_position, int salary, String hire_date, String d) {
//        this.employee_id = employee_id;
//        this.name = name;
//        this.contact_no = contact_no;
//        this.email = email;
//        this.address = address;
//        this.date_of_birth = date_of_birth;
//        this.gender = gender;
//        this.job_position = job_position;
//        this.salary = salary;
//        this.hire_date = hire_date;
//        this.last_working_date=d;
//
//    }

    private String name;
    private String contact_no;
    private String email;
    private String address;
    private String date_of_birth;
    private String gender;
    private String job_position;
    private int salary;
     private String last_working_date;
    private String hire_date;
    public OldStaff(){}

    public String getLast_working_date() {
        return last_working_date;
    }

    public void setLast_working_date(String last_working_date) {
        this.last_working_date = last_working_date;
    }
//    public String getLastWorkDate() {
//        return last_working_date;
//    }
//
//    public void setLastWorkDate(String last_working_date) {
//        this.last_working_date = last_working_date;
//    }



    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob_position() {
        return job_position;
    }

    public void setJob_position(String job_position) {
        this.job_position = job_position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }


}
