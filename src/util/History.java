package util;

import java.io.Serializable;

public class History implements Serializable {
    private int id;
    private String adopted_by;
    //private String contact_no;
    //private String address;
    //private String email;
    private String adoption_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdopted_by() {
        return adopted_by;
    }

    public void setAdopted_by(String adopted_by) {
        this.adopted_by = adopted_by;
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
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getAdoption_date() {
        return adoption_date;
    }

    public void setAdoption_date(String adoption_date) {
        this.adoption_date = adoption_date;
    }
}
