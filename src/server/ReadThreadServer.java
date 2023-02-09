package server;

import util.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.sql.ResultSet;

public class ReadThreadServer implements Runnable {
    private final Thread thr;
    private final NetworkUtil networkUtil;
    public static HashMap<String, NetworkUtil> clientMap = new HashMap<>();

    public ReadThreadServer(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();//gets stuck here until client writes something
                Object o1 = networkUtil.read();
                if (o instanceof String && o1 instanceof String && !((String) o).equals("admin/user logout") && !((String) o).equals("end session")) {
                    OracleConnect oc = null;
                    boolean flag = false;
                    try {
                        if (!clientMap.containsKey((String) o)) {
                            oc = new OracleConnect();
                            String queryuser = String.format("select username from users where username = '%s' and password='%s'", (String) o, (String) o1);
                            String queryadmin = String.format("select username from admin where username = '%s' and password='%s'", (String) o, (String) o1);
                            ResultSet rsuser = oc.searchDB(queryuser);
                            ResultSet rsadmin = oc.searchDB(queryadmin);
                            if (rsuser.next()) {
                                networkUtil.write(1);//for user
                                networkUtil.write((String) o);
                                clientMap.put((String) o, networkUtil);
                            } else if (rsadmin.next()) {
                                List<CombinedAnimal> list = new ArrayList<>();
                                String query="select * from animals natural join PHYSICAL_CONDITION natural join VACCINATION_STATUS";
                                BufferC buffer = new BufferC(list,query,"COMBINED ANIMAL");//ANIMAL ATTRIBUTES//change query
                                ServerThread s = new ServerThread(buffer, "Server");
                                ClientThread c = new ClientThread(buffer, "Client");
                                try {
                                    s.t.join();
                                    c.t.join();
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                networkUtil.write(buffer.list);//for admin
                                networkUtil.write("Animal" + " " + (String) o);
                                //no write in readthread,new buffer,new server,new client
                                clientMap.put((String) o, networkUtil);
                            } else {
                                networkUtil.write(-1);
                                networkUtil.write(null);
                            }

                        } else {

                            clientMap.get((String) o).write("exit");
                            clientMap.get((String) o).write(null);
                            clientMap.remove((String) o);
                            flag = true;
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            if (!flag)
                                oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else if (o instanceof String && ((String) o).contains("<")) {///sign up page
                    String line = (String) o;
                    String[] tokens = line.split("<");
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
//                        String query = String.format("select username from users where username = '%s'", tokens[1]);
//                        ResultSet rs = oc.searchDB(query);
//                        if (rs.next()) {
//                            networkUtil.write("user repeat");//username erpeat
//                            networkUtil.write(null);
//                        } else {
                        String query = String.format("insert into users values('%s','%s','%s','%s','%s','%s','%s','%s')", tokens[0], tokens[1], tokens[2], tokens[3],tokens[4], tokens[5], tokens[6], tokens[7]);
                        oc.updateDB(query);
                        networkUtil.write("login page");
                        networkUtil.write(null);
//                        }
                    } catch (Exception e) {
                        networkUtil.write("user repeat");
                        networkUtil.write(null);
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
//                else if (o instanceof String && ((String) o).contains("!")) {///add animal
//                    String line = (String) o;
//                    String[] tokens = line.split("!");
//                    OracleConnect oc = null;
//                    try {
//                        oc = new OracleConnect();
//                        SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy");
//                        String query = "INSERT INTO ANIMALS VALUES("+Integer.valueOf(tokens[0])+",'"+tokens[1]+"','"+tokens[2]+"','"+tokens[3]+"','"+tokens[4]+"','"+tokens[5]+"','"+tokens[6]+"','"+sf.format(java.sql.Date.valueOf(tokens[7]))+"','"+tokens[8]+"',"+"'"+tokens[0]+".png','"+tokens[9]+"','"+tokens[10]+"')";
//                        oc.updateDB(query);
//                    } catch (Exception e) {
//                        System.out.println(e);
//                    } finally {
//                        try {
//                            oc.close();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
                else if (o instanceof String && ((String) o).contains("!")) {///add animal
                    String line = (String) o;
                    String[] tokens = line.split("!");
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy");
                        String query = "INSERT INTO ANIMALS VALUES(ANIMAL_ID_SEQ.NEXTVAL,'"+tokens[0]+"','"+tokens[1]+"','"+tokens[2]+"','"+tokens[3]+"','"+tokens[4]+"','"+tokens[5]+"','"+sf.format(java.sql.Date.valueOf(tokens[6]))+"','"+tokens[7]+"',ANIMAL_ID_SEQ.CURRVAL||'.png','"+tokens[8]+"','"+tokens[9]+"','Available')";
                        oc.updateDB(query);
                        query="DECLARE\n" +
                                "BEGIN\n" +
                                "\taddnullFieldsForAnimal(ANIMAL_ID_SEQ.CURRVAL);\n" +
                                "end;";
                        oc.updateDB(query);
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o instanceof String && ((String) o).contains("#")) {
                    String line = (String) o;
                    String[] tokens = line.split("#");
                    OracleConnect oc = null;
                    try {
                        System.out.println("HI");
                        oc = new OracleConnect();
                        String query = "INSERT INTO ANIMALS VALUES(ANIMAL_ID_SEQ.NEXTVAL,'"+tokens[0]+"','"+tokens[1]+"','"+tokens[2]+"','"+tokens[3]+"','"+tokens[4]+"','"+tokens[5]+"',SYSDATE,'"+tokens[6]+"',ANIMAL_ID_SEQ.CURRVAL||'.png','"+tokens[7]+"','"+tokens[8]+"','Available')";
                        oc.updateDB(query);
                        query="delete from request_to_drop where serial_no="+tokens[9];
                        oc.updateDB(query);
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o instanceof String && (((String) o).equals("admin/user logout") || ((String) o).equals("end session"))) {
                    clientMap.remove((String) o1);
                } else if (o instanceof String && (((String) o).equals("updated animal list for admin"))) {

                    try {
                        List<CombinedAnimal> list = new ArrayList<>();
                        String query="select * from animals full outer join PHYSICAL_CONDITION on ANIMALS.ID=PHYSICAL_CONDITION.ID full outer join VACCINATION_STATUS on ANIMALS.ID=VACCINATION_STATUS.ID";
                        BufferC buffer = new BufferC(list,query,"COMBINED ANIMAL");//ANIMAL ATTRIBUTES//change query
                        ServerThread s = new ServerThread(buffer, "Server");
                        ClientThread c = new ClientThread(buffer, "Client");
                        try {
                            s.t.join();
                            c.t.join();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        networkUtil.write(list);//for admin
                        networkUtil.write("updated animal list for admin");
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                }
                else if (o instanceof String && o.equals("donor")) {
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        String query = String.format("select * from donors");
                        ResultSet rs = oc.searchDB(query);
                        List<Donor> list=new ArrayList<Donor>();
                        while (rs.next()) {
                            Donor a = new Donor();
                            a.setDonor_id(rs.getInt("donor_id"));
                            a.setName(rs.getString("name"));
                            a.setContact_no(rs.getString("contact_no"));
                            a.setEmail(rs.getString("email"));
                            a.setAddress(rs.getString("address"));
                            a.setYears_active(rs.getInt("years_active"));
                            a.setAssigned_worker(rs.getInt("assigned_worker"));
                            list.add(a);
                        }
                        networkUtil.write(list);//for user
                        networkUtil.write("donor");
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o instanceof String && o.equals("adopted")) {
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        String query = String.format("select  ADOPTED_ANIMALS.ID, ANIMALS.NAME, ADOPTED_ANIMALS.ADOPTED_BY,USERS.contact_no,USERS.address,USERS.EMAIL,ADOPTED_ANIMALS.ADOPTION_DATE\n" +
                                "from   ADOPTED_ANIMALS JOIN USERS \n" +
                                "ON ADOPTED_ANIMALS.ADOPTED_BY=USERS.USERNAME \n" +
                                "JOIN ANIMALS \n" +
                                "ON ADOPTED_ANIMALS.ID=ANIMALS.ID");

                        ResultSet rs = oc.searchDB(query);
                        List<AdoptedShow> list=new ArrayList<AdoptedShow>();
                        while (rs.next()) {
                            AdoptedShow a = new AdoptedShow();
                            a.setId(rs.getInt("id"));
                            a.setName(rs.getString("name"));
                            a.setAdopted_by(rs.getString("adopted_by"));
                            a.setContact_no(rs.getString("contact_no"));
                            a.setAddress(rs.getString("address"));
                            a.setEmail(rs.getString("email"));
                            a.setAdoption_date(rs.getString("Adoption_date"));
                            list.add(a);
                        }
                        networkUtil.write(list);//for user
                        networkUtil.write("adopted");
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o instanceof String && o.equals("phycon")) {
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        String query = String.format("select p.id,a.name,p.INJURY_STATUS,p.DISEASE,p.therapy from physical_condition p  join animals a on (a.ID=p.id)");
                        ResultSet rs = oc.searchDB(query);
                        List<CombinedPhyCon> list=new ArrayList<CombinedPhyCon>();
                        while (rs.next()) {
                            CombinedPhyCon a = new CombinedPhyCon();
                            a.setId(rs.getInt("id"));
                            a.setName(rs.getString("name"));
                            a.setInjury_status(rs.getString("Injury_status"));
                            a.setDisease(rs.getString("disease"));
                            a.setTherapy(rs.getString("therapy"));
                            list.add(a);
                        }
                        networkUtil.write(list);//for user
                        networkUtil.write("phycon");
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o instanceof String && o.equals("registered")) {
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        String query = String.format("select r.USER_NAME,r.APPLIED_FOR,a.NAME,r.APPLICATION_DATE\n" +
                                "from REGISTERED_PEOPLE r join animals a\n" +
                                "on r.APPLIED_FOR=a.ID");
                        ResultSet rs = oc.searchDB(query);
                        List<Registered> list=new ArrayList<Registered>();
                        while (rs.next()) {
                            Registered a = new Registered();
                            a.setUser_name(rs.getString("user_name"));
                            //a.setOccupation(rs.getString("occupation"));
                            a.setApplied_for(rs.getInt("applied_for"));
                            a.setName(rs.getString("name"));
                            // a.setOther_pets(rs.getString("Other_pets"));
                            a.setApplication_date(rs.getString("Application_date"));
                            //a.setContact_no(rs.getString("Contact_no"));
                            //a.setAddress(rs.getString("address"));

                            list.add(a);
                        }
                        networkUtil.write(list);//for user
                        networkUtil.write("registered");
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o instanceof String && o.equals("reqtodrop")) {
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        String query = String.format("select * from request_to_drop");
                        ResultSet rs = oc.searchDB(query);
                        List<Request> list=new ArrayList<Request>();
                        while (rs.next()) {
                            Request a = new Request();
                            a.setSerial_no(rs.getInt("serial_no"));
                            a.setApplication_date(rs.getString("Application_date"));
                            a.setName(rs.getString("name"));
                            a.setContact_no(rs.getString("Contact_no"));
                            a.setEmail(rs.getString("email"));
                            a.setAddress(rs.getString("address"));
                            a.setRescue_date(rs.getString("rescue_date"));
                            a.setAnimal_type(rs.getString("animal_type"));
                            a.setPhysical_condition(rs.getString("physical_condition"));
                            list.add(a);
                        }
                        networkUtil.write(list);//for user
                        networkUtil.write("reqtodrop");
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o instanceof String && o.equals("staff")) {
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        String query = String.format("select * from staffs");
                        ResultSet rs = oc.searchDB(query);
                        List<Staff> list=new ArrayList<Staff>();
                        while (rs.next()) {
                            Staff a = new Staff();
                            a.setEmployee_id(rs.getInt("employee_id"));
                            a.setName(rs.getString("name"));
                            a.setContact_no(rs.getString("contact_no"));
                            a.setDate_of_birth(rs.getString("Date_of_birth"));
                            a.setGender(rs.getString("gender"));
                            a.setJob_position(rs.getString("job_position"));
                            a.setAddress(rs.getString("address"));
                            a.setSalary(rs.getInt("salary"));
                            a.setHire_date(rs.getString("hire_date"));
                            a.setEmail(rs.getString("email"));


                            list.add(a);
                        }
                        networkUtil.write(list);//for user
                        networkUtil.write("staff");
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o instanceof String && o.equals("supplier")) {
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        String query = String.format("select * from suppliers");
                        ResultSet rs = oc.searchDB(query);
                        List<Supplier> list=new ArrayList<Supplier>();
                        while (rs.next()) {
                            Supplier a = new Supplier();
                            a.setSupplier_id(rs.getInt("supplier_id"));
                            a.setName(rs.getString("name"));
                            a.setContact_no(rs.getString("contact_no"));
                            a.setDescription(rs.getString("description"));
                            a.setAddress(rs.getString("address"));

                            list.add(a);
                        }
                        networkUtil.write(list);//for user
                        networkUtil.write("supplier");
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }


                else if (o instanceof String && o.equals("oldstaff")) {
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        String query = String.format("select * from old_employee_history");
                        ResultSet rs = oc.searchDB(query);
                        List<OldStaff> list=new ArrayList<OldStaff>();
                        while (rs.next()) {
                            OldStaff a = new OldStaff();
                            a.setEmployee_id(rs.getInt("employee_id"));
                            a.setName(rs.getString("name"));
                            a.setContact_no(rs.getString("contact_no"));
                            a.setDate_of_birth(rs.getString("Date_of_birth"));
                            a.setGender(rs.getString("gender"));
                            a.setJob_position(rs.getString("job_position"));
                            a.setAddress(rs.getString("address"));
                            a.setSalary(rs.getInt("salary"));
                            a.setEmail(rs.getString("email"));
                            a.setHire_date(rs.getString("hire_date"));
                            a.setLast_working_date(rs.getString("last_working_date"));

                            list.add(a);
                        }
                        networkUtil.write(list);//for user
                        networkUtil.write("oldstaff");
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }else if (o instanceof String && ((String) o).equals("staffDelete") && o1 instanceof Integer) {///drop request,Integer
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        // for(int i=0;i<((List<Staff>) o).size();i++){
                        System.out.println(o);
                        String query = "delete from staffs where employee_id="+o1;
                        oc.updateDB(query);
                        //}
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                else if (o instanceof String && o.equals("transaction")) {
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        String query = String.format("select * from transactions");
                        ResultSet rs = oc.searchDB(query);
                        List<Transaction> list=new ArrayList<Transaction>();
                        while (rs.next()) {
                            Transaction a = new Transaction();
                            a.setTrans_id(rs.getInt("trans_id"));
                            a.setTrans_date(rs.getString("trans_date"));
                            a.setType(rs.getString("type"));
                            a.setPerson_id(rs.getInt("person_id"));
                            a.setId_type(rs.getString("id_type"));
                            a.setAmount(rs.getInt("amount"));

                            list.add(a);
                        }
                        networkUtil.write(list);//for user
                        networkUtil.write("transaction");
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o instanceof String && o.equals("vaccine")) {
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        String query = String.format("\n" +
                                "SELECT v.id,a.NAME,v.DISTEMPER,v.HEPATITIS,v.LEPTOSPIROSIS,v.PARVO,v.PARAINFLUENZA,v.ADENOVIRUS_TYPE_1,v.ADENOVIRUS_TYPE_2,v.BORDETELLA,v.RABIES,v.FELINEHERPESVIRUS,v.CALICIVIRUS,v.FELINE_LEUKEMIA_VIRUS,v.LAST_VACCINATED,v.NEXT_VACCINATION_DATE\n" +
                                "from VACCINATION_STATUS v join animals a\n" +
                                "on v.id=a.id");
                        ResultSet rs = oc.searchDB(query);
                        List<Vaccine> list=new ArrayList<Vaccine>();
                        while (rs.next()) {
                            Vaccine a = new Vaccine();

                            a.setName(rs.getString("name"));
                            a.setDistemper(rs.getString("Distemper"));
                            a.setHepatitis(rs.getString("Hepatitis"));
                            a.setLeptospirosis(rs.getString("Leptospirosis"));
                            a.setParvo(rs.getString("Parvo"));
                            a.setParainfluenza(rs.getString("parainfluenza"));
                            a.setAdenovirus_type_1(rs.getString("Adenovirus_type_1"));
                            a.setAdenovirus_type_2(rs.getString("Adenovirus_type_2"));
                            a.setBordetella(rs.getString("Bordetella"));
                            a.setRabies(rs.getString("Rabies"));
                            a.setFelineherpesvirus(rs.getString("Felineherpesvirus"));
                            a.setCalicivirus(rs.getString("Calicivirus"));
                            a.setFeline_leukemia_virus(rs.getString("Feline_leukemia_virus"));
                            a.setLast_vaccinated(rs.getString("Last_vaccinated"));
                            a.setNext_vaccination_date(rs.getString("Next_vaccination_date"));

                            list.add(a);
                        }
                        networkUtil.write(list);//for user
                        networkUtil.write("vaccine");
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if(o instanceof String && o.equals("cat")){
                    try {
                        List<Animal> list = new ArrayList<>();
                        String query=String.format("select * from animals where type='Cat'");
                        BufferC buffer = new BufferC(list,query,"ANIMAL");
                        ServerThread s = new ServerThread(buffer, "Server");
                        ClientThread c = new ClientThread(buffer, "Client");
                        try {
                            s.t.join();
                            c.t.join();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        networkUtil.write(list);//for user
                        networkUtil.write("cat");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }else if(o instanceof String && o.equals("dog")){
                    try {
                        List<Animal> list = new ArrayList<>();
                        String query=String.format("select * from animals where type='Dog'");
                        BufferC buffer = new BufferC(list,query,"ANIMAL");
                        ServerThread s = new ServerThread(buffer, "Server");
                        ClientThread c = new ClientThread(buffer, "Client");
                        try {
                            s.t.join();
                            c.t.join();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        networkUtil.write(list);//for user
                        networkUtil.write("dog");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }else if (o instanceof String && (((String) o).equals("updated animal list for user"))) {
                    try {
                        List<Animal> list = new ArrayList<>();
                        BufferC buffer = new BufferC(list,"select * from animals where status='Available'","ANIMAL");
                        ServerThread s = new ServerThread(buffer, "Server");
                        ClientThread c = new ClientThread(buffer, "Client");
                        try {
                            s.t.join();
                            c.t.join();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        networkUtil.write(list);//for admin
                        networkUtil.write("updated animal list for user");
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                }
//                else if (o instanceof String && o.equals("delete animal")) {
//                    OracleConnect oc = null;
//                    try {
//                        oc = new OracleConnect();
//                        String query = String.format("delete from animals where id=%d",(Integer)o1);
//                        oc.updateDB(query);
//
//                        List<CombinedAnimal> list = new ArrayList<>();
//                        String squery="select * from animals natural join PHYSICAL_CONDITION natural join VACCINATION_STATUS";
//
//                        BufferC buffer = new BufferC(list,squery,"COMBINED ANIMAL");//ANIMAL ATTRIBUTES
//                        ServerThread s = new ServerThread(buffer, "Server");
//                        ClientThread c = new ClientThread(buffer, "Client");
//                        try {
//                            s.t.join();
//                            c.t.join();
//                        } catch (Exception e) {
//                            System.out.println(e);
//                        }
//                        networkUtil.write(list);//for admin
//                        networkUtil.write("updated animal list for admin");
//                    } catch (Exception e) {
//                        System.out.println(e);
//                    } finally {
//                        try {
//                            oc.close();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
                else if (o instanceof String && ((String) o).contains("_")) {///adoption request
                    String line = (String) o;
                    String[] tokens = line.split("_");
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        String query = "INSERT INTO REGISTERED_PEOPLE VALUES('"+tokens[0]+"',"+Integer.valueOf(tokens[1])+",SYSDATE"+")";
                        oc.updateDB(query);
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o instanceof String && ((String) o).contains(">")) {///drop request
                    String line = (String) o;
                    String[] tokens = line.split(">");
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy");
                        String query = "INSERT INTO REQUEST_TO_DROP VALUES(SERIAL_NO_SEQ.NEXTVAL,SYSDATE,'"+tokens[0]+"',"+Integer.valueOf(tokens[1])+",'"+tokens[2]+"','"+tokens[3]+"','"+sf.format(java.sql.Date.valueOf(tokens[4]))+"','"+tokens[5]+"','"+tokens[6]+"')";
                        oc.updateDB(query);
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o1 instanceof String && ((String) o1).equals("trigger registered to adopted") && o instanceof List) {///drop request,Integer
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        for(int i=0;i<((List<Registered>) o).size();i++){
//                            String query = "delete from registered_people where applied_for="+((List<Registered>) o).get(i).getApplied_for();
//                            oc.updateDB(query);
//                            query = "INSERT INto ADOPTED_ANIMALS VALUES("+((List<Registered>) o).get(i).getApplied_for()+",'"+((List<Registered>) o).get(i).getUser_name()+"',SYSDATE)";
//                            oc.updateDB(query);
//                            query = "INSERT INto ADOPTED_ANIMALS VALUES("+((List<Registered>) o).get(i).getApplied_for()+((List<Registered>) o).get(i).getUser_name()+"SYSDATE)";
//                            oc.updateDB(query);
                            String query="declare\n" +
                                    "BEGIN\n" +
                                    "\tdeletefromRegisteredToAdopted("+((List<Registered>) o).get(i).getApplied_for()+",'"+((List<Registered>) o).get(i).getUser_name()+"',SYSDATE);\n"+
                                    "end;\n";
                            System.out.println(query);
                            oc.updateDB(query);
                            System.out.println(query);
                        }
                    } catch (SQLIntegrityConstraintViolationException e){
//                        networkUtil.write("Adoption request for a single animal");
//                        networkUtil.write(null);
                        System.out.println(e);
                    }catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o instanceof String && ((String) o).equals("trigger request to animal") && o1 instanceof Request) {///drop request
                    OracleConnect oc = null;
                    try {
                        oc = new OracleConnect();
                        String query = "delete from request_to_drop where serial_no="+((Request) o1).getSerial_no();
                        oc.updateDB(query);

                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (o instanceof List && o1 instanceof String && o1.equals("new phycon")) {
                    OracleConnect oc = null;
                        oc = new OracleConnect();
                        String query = String.format("delete from physical_condition");
                        oc.updateDB(query);
                        List<PhysicalCondition> list=(List<PhysicalCondition>)o;
                        OracleConnect finalOc = oc;
                        list.forEach(e-> {
                            try {
                                finalOc.updateDB("insert into physical_condition values("+e.getId()+",'"+e.getInjury_status()+"','"+e.getDisease()+"','"+e.getTherapy()+"')");
                            } catch (Exception exception) {
                                try {
                                    networkUtil.write("animal doesn't exist");
                                    networkUtil.write(null);
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                            }
                        });
                }
                else if (o instanceof List && o1 instanceof String && o1.equals("new vaccine")) {
                    OracleConnect oc = null;
                    oc = new OracleConnect();
                    String query = String.format("delete from vaccination_status");
                    oc.updateDB(query);
                    List<Vaccine> list=(List<Vaccine>)o;
                    OracleConnect finalOc = oc;
                    list.forEach(e-> {
                        try {
                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                            finalOc.updateDB("insert into vaccination_status values("+e.getId()+",'"+e.getDistemper()+"','"+e.getHepatitis()+"','"+e.getLeptospirosis()+"','"+e.getParvo()+"','"+e.getParainfluenza()+"','"+e.getAdenovirus_type_1()+"','"+e.getAdenovirus_type_2()+"','"+e.getBordetella()+"','"+e.getRabies()+"','"+e.getFelineherpesvirus()+"','"+e.getCalicivirus()+"','"+e.getFeline_leukemia_virus()+"','"+formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(e.getLast_vaccinated()))+"','"+formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(e.getNext_vaccination_date()))+"')");
                        } catch (Exception exception) {
                            try {
                                networkUtil.write("animal doesn't exist");
                                networkUtil.write(null);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                    });
                }
                else if (o instanceof List && o1 instanceof String && o1.equals("new staff")) {
                    OracleConnect oc = new OracleConnect();
//                    String query = String.format("delete from staffs");
//                    oc.updateDB(query);
                    List<Staff> list=(List<Staff>)o;
                    OracleConnect finalOc = oc;
                    list.forEach(e-> {
                        try {
                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                            if(e.isAdded()){
                                finalOc.updateDB("insert into staffs values(employee_id_seq.nextval,'"+e.getName()+"',"+e.getContact_no()+",'"+formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(e.getDate_of_birth()))+"','"+e.getGender()+"','"+e.getJob_position()+"','"+e.getAddress()+"',"+e.getSalary()+",'"+formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(e.getHire_date()))+"','"+e.getEmail()+"')");
                            }else if(e.isUpdated()){
                                finalOc.updateDB("UPDATE STAFFS set name='"+e.getName()+"',contact_no="+e.getContact_no()+",date_of_birth='"+formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(e.getDate_of_birth()))+"',gender='"+e.getGender()+"',job_position='"+e.getJob_position()+"',address='"+e.getAddress()+"',salary="+e.getSalary()+",hire_date='"+formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(e.getHire_date()))+"',email='"+e.getEmail()+"' where employee_id="+e.getEmployee_id());
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    });

                }
                else if (o instanceof List && o1 instanceof String && o1.equals("new donor")) {
                    OracleConnect oc = null;
                    oc = new OracleConnect();
                    String query = String.format("delete from donors");
                    oc.updateDB(query);
                    List<Donor> list=(List<Donor>)o;
                    OracleConnect finalOc = oc;
                    list.forEach(e-> {
                        try {
                            finalOc.updateDB("insert into donors values("+e.getDonor_id()+",'"+e.getName()+"',"+e.getContact_no()+",'"+e.getEmail()+"','"+e.getAddress()+"',"+e.getYears_active()+","+e.getAssigned_worker()+")");
                        } catch (Exception exception) {
                            System.out.println("All information are not given properly");                        }
                    });
                }
                else if (o instanceof List && o1 instanceof String && o1.equals("new supplier")) {
                    OracleConnect oc = null;
                    oc = new OracleConnect();
                    String query = String.format("delete from suppliers");
                    oc.updateDB(query);
                    List<Supplier> list=(List<Supplier>)o;
                    OracleConnect finalOc = oc;
                    list.forEach(e-> {
                        try {
                            finalOc.updateDB("insert into suppliers values("+e.getSupplier_id()+",'"+e.getName()+"',"+e.getContact_no()+",'"+e.getDescription()+"','"+e.getAddress()+"')");
                        } catch (Exception exception) {
                            System.out.println("All information are not given properly");
                        }
                    });
                }
                else if (o instanceof List && o1 instanceof String && o1.equals("new transaction")) {
                    OracleConnect oc = null;
                    oc = new OracleConnect();
                    String query = String.format("delete from transactions");
                    oc.updateDB(query);
                    List<Transaction> list=(List<Transaction>)o;
                    OracleConnect finalOc = oc;
                    list.forEach(e-> {
                        try {
                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                            finalOc.updateDB("insert into transactions values("+e.getTrans_id()+",'"+formatter.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(e.getTrans_date()))+"','"+e.getType()+"',"+e.getPerson_id()+",'"+e.getId_type()+"',"+e.getAmount()+")");
                        } catch (Exception exception) {
                            System.out.println("All information are not given properly");
                        }
                    });
                }
                else if(o instanceof File && o1 instanceof String && ((String)o1).contains("picturechange ")){
                    System.out.println(o1);
                    String line = (String) o1;
                    String[] tokens = line.split(" ");
                    OracleConnect oc = null;
                    //String fp=(String) o;
                    try {
                        oc = new OracleConnect();
                        //SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy");
                        //String str = FileUtils.readFileToString(file);
                        String s=((File)o).getAbsolutePath();
                        System.out.println("printing");
                        String str=s.replace("\\","/");
                        System.out.println(str);
                        String query = "UPDATE ANIMALS SET PICTURE='file:/"+str+"' where id="+tokens[1];
                        System.out.println(query);
                        oc.updateDB(query);
                    } catch (Exception e) {
                        System.out.println(e);
                    } finally {
                        try {
                            oc.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}



