package util;

import java.io.Serializable;

public class Transaction implements Serializable {
    private int trans_id;
    private String type;
    private int person_id;
    private String id_type;
    private int amount;
    private String trans_date;

    public Transaction() {
    }

    public Transaction(int trans_id, String type, int person_id, String id_type, int amount, String trans_date) {
        this.trans_id = trans_id;
        this.type = type;
        this.person_id = person_id;
        this.id_type = id_type;
        this.amount = amount;
        this.trans_date = trans_date;
    }

    public int getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(int trans_id) {
        this.trans_id = trans_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(String trans_date) {
        this.trans_date = trans_date;
    }


}
