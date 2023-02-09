package util;

import java.io.Serializable;
import java.util.Objects;

public class PhysicalCondition implements Serializable {

    private int id;
    private String injury_status;
    private String disease;
    private String therapy;

    @Override
    public String toString() {
        return "PhysicalCondition{" +
                "id=" + id +
                ", injury_status='" + injury_status + '\'' +
                ", disease='" + disease + '\'' +
                ", therapy='" + therapy + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
    public PhysicalCondition() {

    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        PhysicalCondition that = (PhysicalCondition) o;
        return id == that.id && Objects.equals(injury_status, that.injury_status) && Objects.equals(disease, that.disease) && Objects.equals(therapy, that.therapy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, injury_status, disease, therapy);
    }

    public PhysicalCondition(int id, String injury_status, String disease, String therapy) {
        this.id = id;
        this.injury_status = injury_status;
        this.disease = disease;
        this.therapy = therapy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInjury_status() {
        return injury_status;
    }

    public void setInjury_status(String injury_status) {
        this.injury_status = injury_status;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }
}
