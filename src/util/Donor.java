package util;

import java.io.Serializable;

public class Donor implements Serializable {
    private int donor_id;
    private String name;
    private String contact_no;
    private String email;
    public Donor(){}
    public Donor(int donor_id, String name, String contact_no, String email, String address, double years_active, int assigned_worker) {
        this.donor_id = donor_id;
        this.name = name;
        this.contact_no = contact_no;
        this.email = email;
        this.address = address;
        this.years_active = years_active;
        this.assigned_worker = assigned_worker;
    }

    private String address;

    @Override
    public String toString() {
        return "Donor{" +
                "donor_id=" + donor_id +
                ", name='" + name + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", years_active=" + years_active +
                ", assigned_worker=" + assigned_worker +
                '}';
    }

    private double years_active;
    private int assigned_worker;

    public int getDonor_id() {
        return donor_id;
    }

    public void setDonor_id(int donor_id) {
        this.donor_id = donor_id;
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

    public double getYears_active() {
        return years_active;
    }

    public void setYears_active(double years_active) {
        this.years_active = years_active;
    }

    public int getAssigned_worker() {
        return assigned_worker;
    }

    public void setAssigned_worker(int assigned_worker) {
        this.assigned_worker = assigned_worker;
    }


}
