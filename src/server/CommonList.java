package server;

import util.Animal;
import util.CombinedAnimal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

class BufferC <S>{
    List<S> list;
    String query;
    String object;
    BufferC(List<S> list,String query,String object){//
        this.list=list;
        this.query=query;
        this.object=object;
    }

    boolean valueSet = false;//no product to consume
    synchronized void consume() {
        while (!valueSet) { // always use while instead of if
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        valueSet = false;
        notifyAll();
    }

    synchronized void produce() {
        while (valueSet) { // always use while instead of if
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        try{
            OracleConnect oc=new OracleConnect();
            ResultSet rs = oc.searchDB(query);
            if(object.equals("ANIMAL")){
                while (rs.next()) {
                    Animal a = new Animal();
                    a.setId(rs.getInt("id"));
                    a.setName(rs.getString("name"));
                    a.setType(rs.getString("type"));
                    a.setBreed(rs.getString("breed"));
                    a.setGender(rs.getString("gender"));
                    a.setShort_description(rs.getString("short_description"));
                    a.setHealth_status(rs.getString("health_status"));
                    a.setStaying_since(rs.getString("staying_since"));
                    a.setSheltered_time_age(rs.getString("sheltered_time_age"));
                    //a.setRoom_no(rs.getInt("room_no"));
                    a.setPicture(rs.getString("picture"));
                    a.setAnimal_size(rs.getString("animal_size"));
                    a.setHousetrained(rs.getString("housetrained"));
                    list.add((S)a);
                }
            }else if(object.equals("COMBINED ANIMAL")){
                while (rs.next()) {
                    CombinedAnimal a = new CombinedAnimal();
                    a.setId(rs.getInt("id"));
                    a.setName(rs.getString("name"));
                    a.setType(rs.getString("type"));
                    a.setBreed(rs.getString("breed"));
                    a.setGender(rs.getString("gender"));
                    a.setShort_description(rs.getString("short_description"));
                    a.setHealth_status(rs.getString("health_status"));
                    a.setStaying_since(rs.getString("staying_since"));
                    a.setSheltered_time_age(rs.getString("sheltered_time_age"));
                    a.setStatus(rs.getString("status"));
                    //a.setRoom_no(rs.getInt("room_no"));
                    a.setPicture(rs.getString("picture"));
                    a.setAnimal_size(rs.getString("animal_size"));
                    a.setHousetrained(rs.getString("housetrained"));
                    a.setDisease(rs.getString("disease"));
                    a.setInjury_status(rs.getString("injury_status"));
                    a.setTherapy(rs.getString("therapy"));
                    a.setDistemper(rs.getString("distemper"));
                    a.setHepatitis(rs.getString("hepatitis"));
                    a.setLeptospirosis(rs.getString("leptospirosis"));
                    a.setParvo(rs.getString("parvo"));
                    a.setParainfluenza(rs.getString("parainfluenza"));
                    a.setAdenovirus_type_1(rs.getString("adenovirus_type_1"));
                    a.setAdenovirus_type_2(rs.getString("adenovirus_type_2"));
                    a.setBordetella(rs.getString("bordetella"));
                    a.setRabies(rs.getString("rabies"));
                    a.setFelineherpesvirus(rs.getString("felineherpesvirus"));
                    a.setCalicivirus(rs.getString("calicivirus"));
                    a.setFeline_leukemia_virus(rs.getString("feline_leukemia_virus"));
                    a.setLast_vaccinated(rs.getString("last_vaccinated"));
                    a.setNext_vaccination_date(rs.getString("next_vaccination_date"));
                    list.add((S) a);

                }
            }
            valueSet = true;
            notifyAll(); // always use notifyAll instead of notify
        }catch (Exception e){
            System.out.println(e);
        }

    }
}


class ServerThread implements Runnable {
    BufferC buffer;
    public Thread t;
    ServerThread(BufferC buffer, String name) {
        this.buffer=buffer;
        this.t = new Thread(this,name);
        this.t.start();
    }

    public void run() {
        int i = 0;
        while (i < 1) {
            buffer.produce();
            i++;
        }
    }
}

class ClientThread implements Runnable {
    BufferC buffer;
    public Thread t;
    ClientThread(BufferC buffer, String name) {
        this.buffer = buffer;
        this.t = new Thread(this,name);
        this.t.start();
    }

    public void run() {
        int i=0;
        while (i++ < 1) {
            buffer.consume();
        }
    }
}
