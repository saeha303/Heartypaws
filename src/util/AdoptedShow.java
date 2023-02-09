package util;
import java.io.Serializable;


public class AdoptedShow implements Serializable{
    private int id;
    private String adopted_by;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String contact_no;
    private String address;
    private String email;

    public AdoptedShow() {
    }

    public AdoptedShow(int id,String name, String adopted_by, String contact_no, String address, String email, String adoption_date) {
        this.id = id;
        this.name=name;
        this.adopted_by = adopted_by;
        this.contact_no = contact_no;
        this.address = address;
        this.email = email;
        this.adoption_date = adoption_date;
    }

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

    public String getAdoption_date() {
        return adoption_date;
    }

    public void setAdoption_date(String adoption_date) {
        this.adoption_date = adoption_date;
    }
}
