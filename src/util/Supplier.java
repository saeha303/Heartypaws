package util;

import java.io.Serializable;

public class Supplier implements Serializable {

    private int supplier_id;
    private String name;
    private String contact_no;
    private String description;
    private String address;

    public Supplier() {
    }

    public Supplier(int supplier_id, String name, String contact_no, String description, String address) {
        this.supplier_id = supplier_id;
        this.name = name;
        this.contact_no = contact_no;
        this.description = description;
        this.address = address;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
