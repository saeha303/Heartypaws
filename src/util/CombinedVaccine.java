package util;

import java.io.Serializable;

public class CombinedVaccine implements Serializable {
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String distemper;
    private String hepatitis;
    private String leptospirosis;
    private String  parvo;
    private String parainfluenza;
    private String adenovirus_type_1;
    public CombinedVaccine(){}
    public CombinedVaccine(int id,String name ,String distemper, String hepatitis, String leptospirosis, String parvo, String parainfluenza, String adenovirus_type_1, String adenovirus_type_2, String bordetella, String rabies, String felineherpesvirus, String calicivirus, String feline_leukemia_virus, String last_vaccinated, String next_vaccination_date) {
        this.id = id;
        this.name=name;
        this.distemper = distemper;
        this.hepatitis = hepatitis;
        this.leptospirosis = leptospirosis;
        this.parvo = parvo;
        this.parainfluenza = parainfluenza;
        this.adenovirus_type_1 = adenovirus_type_1;
        this.adenovirus_type_2 = adenovirus_type_2;
        this.bordetella = bordetella;
        this.rabies = rabies;
        this.felineherpesvirus = felineherpesvirus;
        this.calicivirus = calicivirus;
        this.feline_leukemia_virus = feline_leukemia_virus;
        this.last_vaccinated = last_vaccinated;
        this.next_vaccination_date = next_vaccination_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistemper() {
        return distemper;
    }

    public void setDistemper(String distemper) {
        this.distemper = distemper;
    }

    public String getHepatitis() {
        return hepatitis;
    }

    public void setHepatitis(String hepatitis) {
        this.hepatitis = hepatitis;
    }

    public String getLeptospirosis() {
        return leptospirosis;
    }

    public void setLeptospirosis(String leptospirosis) {
        this.leptospirosis = leptospirosis;
    }

    public String getParvo() {
        return parvo;
    }

    public void setParvo(String parvo) {
        this.parvo = parvo;
    }

    public String getParainfluenza() {
        return parainfluenza;
    }

    public void setParainfluenza(String parainfluenza) {
        this.parainfluenza = parainfluenza;
    }

    public String getAdenovirus_type_1() {
        return adenovirus_type_1;
    }

    public void setAdenovirus_type_1(String adenovirus_type_1) {
        this.adenovirus_type_1 = adenovirus_type_1;
    }

    public String getAdenovirus_type_2() {
        return adenovirus_type_2;
    }

    public void setAdenovirus_type_2(String adenovirus_type_2) {
        this.adenovirus_type_2 = adenovirus_type_2;
    }

    public String getBordetella() {
        return bordetella;
    }

    public void setBordetella(String bordetella) {
        this.bordetella = bordetella;
    }

    public String getRabies() {
        return rabies;
    }

    public void setRabies(String rabies) {
        this.rabies = rabies;
    }

    public String getFelineherpesvirus() {
        return felineherpesvirus;
    }

    public void setFelineherpesvirus(String felineherpesvirus) {
        this.felineherpesvirus = felineherpesvirus;
    }

    public String getCalicivirus() {
        return calicivirus;
    }

    public void setCalicivirus(String calicivirus) {
        this.calicivirus = calicivirus;
    }

    public String getFeline_leukemia_virus() {
        return feline_leukemia_virus;
    }

    public void setFeline_leukemia_virus(String feline_leukemia_virus) {
        this.feline_leukemia_virus = feline_leukemia_virus;
    }

    public String getLast_vaccinated() {
        return last_vaccinated;
    }

    public void setLast_vaccinated(String last_vaccinated) {
        this.last_vaccinated = last_vaccinated;
    }

    public String getNext_vaccination_date() {
        return next_vaccination_date;
    }

    public void setNext_vaccination_date(String next_vaccination_date) {
        this.next_vaccination_date = next_vaccination_date;
    }

    private String adenovirus_type_2;
    private String bordetella;
    private String rabies;
    private String felineherpesvirus;
    private String calicivirus;
    private String feline_leukemia_virus;
    private String last_vaccinated;
    private String next_vaccination_date;

}
