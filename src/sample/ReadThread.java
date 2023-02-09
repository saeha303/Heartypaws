package sample;

import javafx.application.Platform;
import util.*;
import java.io.IOException;
import java.util.List;

public class ReadThread implements Runnable {
    private final Thread thr;
    private final Main main;

    public ReadThread(Main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {

                Object o1 = main.getNetworkUtil().read();
                Object o2 = main.getNetworkUtil().read();
                if (o1 instanceof Integer) {
                    Integer status = (Integer) o1;
                    if (status == -1 | status == 1|status==0) {//login page
                        Integer finalStatus = status;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if (finalStatus == 1) {//user
                                    try {
                                        main.clientName=(String) o2;
                                        main.showAfterUserLoginPage();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                else if (finalStatus == -1) {
                                    main.showAlert("Incorrect username or password");
                                }
                            }
                        });
                    }
                } else if (o1 instanceof String && o1.equals("user repeat")) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                main.showAlert("User already exists");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }else if (o1 instanceof String && o1.equals("animal doesn't exist")) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                main.showAlert("animal doesn't exist");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }else if (o1 instanceof String && o1.equals("Adoption request for a single animal")) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                main.showAlert("Multiple adoption request for a single animal cannot be permitted");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else if(o1 instanceof String && o1.equals("login page")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                main.showLoginPageHP();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }else if(o1 instanceof String && o1.equals("exit")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                System.exit(0);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }else if(o1 instanceof List && ((String)o2).contains("Animal")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                String s=(String) o2;
                                String[] tokens = s.split(" ");
                                main.clientName=tokens[1];
                                List<CombinedAnimal> list = (List<CombinedAnimal>) o1;
                                main.showAdminLogin(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }else if(o1 instanceof List && ((String)o2).equals("updated animal list for user")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<Animal> list = (List<Animal>) o1;
                                main.getUpdatedCatDogList(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }else if(o1 instanceof List && ((String)o2).equals("updated animal list for admin")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<CombinedAnimal> list = (List<CombinedAnimal>) o1;
                                main.getUpdatedList(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                /////////////////////////////////////////////////////////////////////////////
                else if(o1 instanceof List && ((String)o2).equals("donor")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<Donor> list = (List<Donor>) o1;
                                main.donorLoad(list);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else if(o1 instanceof List && ((String)o2).equals("adopted")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<AdoptedShow> list = (List<AdoptedShow>) o1;
                                main.historyLoad(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else if(o1 instanceof List && ((String)o2).equals("phycon")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<CombinedPhyCon> list = (List<CombinedPhyCon>) o1;
                                main.phyconLoad(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else if(o1 instanceof List && ((String)o2).equals("registered")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<Registered> list = (List<Registered>) o1;
                                main.registeredLoad(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else if(o1 instanceof List && ((String)o2).equals("reqtodrop")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<Request> list = (List<Request>) o1;
                                main.reqToDropLoad(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else if(o1 instanceof List && ((String)o2).equals("staff")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<Staff> list = (List<Staff>) o1;
                                main.staffLoad(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }

                else if(o1 instanceof List && ((String)o2).equals("oldstaff")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<OldStaff> list = (List<OldStaff>) o1;
                                main.oldstaffLoad(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else if(o1 instanceof List && ((String)o2).equals("supplier")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<Supplier> list = (List<Supplier>) o1;
                                main.supplierLoad(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else if(o1 instanceof List && ((String)o2).equals("transaction")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<Transaction> list = (List<Transaction>) o1;
                                main.transLoad(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else if(o1 instanceof List && ((String)o2).equals("vaccine")){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<Vaccine> list = (List<Vaccine>) o1;
                                main.vaccineLoad(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }else if(o1 instanceof List && (((String)o2).equals("cat")||((String)o2).equals("dog"))){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<Animal> list = (List<Animal>) o1;
                                main.getUpdatedCatDogList(list);/////////
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                main.getNetworkUtil().closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



