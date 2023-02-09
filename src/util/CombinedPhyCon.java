package util;

import java.io.Serializable;
import java.util.Objects;

public class CombinedPhyCon implements Serializable {

    private int id;
    private String injury_status;
    private String disease;
    private String therapy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "PhysicalCondition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", injury_status='" + injury_status + '\'' +
                ", disease='" + disease + '\'' +
                ", therapy='" + therapy + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
    public CombinedPhyCon() {

    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        CombinedPhyCon that = (CombinedPhyCon) o;
        return id == that.id && Objects.equals(name, that.name)&&Objects.equals(injury_status, that.injury_status) && Objects.equals(disease, that.disease) && Objects.equals(therapy, that.therapy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name,injury_status, disease, therapy);
    }

    public CombinedPhyCon(int id, String name,String injury_status, String disease, String therapy) {
        this.id = id;
        this.name=name;
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
