package util;

import java.io.Serializable;

public class CombinedAnimal implements Serializable {


    private int id;
    private String name;
    private String type;
    private String breed;
    private String gender;
    private String short_description;
    private String health_status;
    private String staying_since;
    private String sheltered_time_age;
    private String status;
    private String picture;
    private String animal_size;
    private String housetrained;
    private String injury_status;
    private String disease;
    private String therapy;
    private String distemper;
    private String hepatitis;
    private String leptospirosis;
    private String  parvo;
    private String parainfluenza;
    private String adenovirus_type_1;
    private String adenovirus_type_2;
    private String bordetella;
    private String rabies;
    private String felineherpesvirus;
    private String calicivirus;
    private String feline_leukemia_virus;
    private String last_vaccinated;
    private String next_vaccination_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        System.out.println("inside get");
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getHealth_status() {
        return health_status;
    }

    public void setHealth_status(String health_status) {
        this.health_status = health_status;
    }

    public String getStaying_since() {
        return staying_since;
    }

    public void setStaying_since(String staying_since) {
        this.staying_since = staying_since;
    }

    public String getSheltered_time_age() {
        return sheltered_time_age;
    }

    public void setSheltered_time_age(String sheltered_time_age) {
        this.sheltered_time_age = sheltered_time_age;
    }
//
//    public int getRoom_no() {
//        return room_no;
//    }

//    public void setRoom_no(int room_no) {
//        this.room_no = room_no;
//    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAnimal_size() {
        return animal_size;
    }

    public void setAnimal_size(String animal_size) {
        this.animal_size = animal_size;
    }

    public String getHousetrained() {
        return housetrained;
    }

    public void setHousetrained(String housetrained) {
        this.housetrained = housetrained;
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


}
