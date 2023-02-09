//package util;
//
//import java.io.Serializable;
//
//public class Animal implements Serializable {
//    private String name;
//    private String stay;
//    private int room;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getStay() {
//        return stay;
//    }
//
//    public void setStay(String stay) {
//        this.stay = stay;
//    }
//
//    public int getRoom() {
//        return room;
//    }
//
//    public void setRoom(int room) {
//        this.room = room;
//    }
//}

package util;

import java.io.Serializable;

public class Animal implements Serializable {
    private int id;
    private String name;
    private String type;
    private String breed;

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
//
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

    private String gender;
    private String short_description;
    private String health_status;
    private String staying_since;
    private String sheltered_time_age;
    private int room_no;
    private String picture;
    private String animal_size;
    private String housetrained;


}