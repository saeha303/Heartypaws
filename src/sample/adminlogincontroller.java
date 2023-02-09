package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import util.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class adminlogincontroller {
    private Main main;
    private CombinedAnimal animal;

    @FXML
    private Label pageNameLabel;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button addRecordButton;

    @FXML
    private Button refreshButton;

    @FXML
    private Button saveChangesButton;

    @FXML
    private Button approveButton;

    @FXML
    private ImageView Exit;

    @FXML
    private ImageView Min;

    @FXML
    private Label MenuClose;

    @FXML
    private Label Menu;

    @FXML
    private Label adminName;

    @FXML
    private AnchorPane slider;

    @FXML
    private Button animalsMenu;

    @FXML
    private Button phyCon;

    @FXML
    private Button vaccine;

    @FXML
    private Button staff;

    @FXML
    private Button donor;

    @FXML
    private Button reqToDrop;

    @FXML
    private Button supplier;

    @FXML
    private Button history;

    @FXML
    private Button registered;

    @FXML
    private Button transaction;

    @FXML
    private Label name1;

    @FXML
    private Label name2;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane scrollAnchorPane;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;
    @FXML
    private TableView<CombinedPhyCon> phyConditionTable;


    @FXML
    private TableColumn<CombinedPhyCon, String> id2;

    @FXML
    private TableColumn<CombinedPhyCon, String> injury_statusCol;

    @FXML
    private TableColumn<CombinedPhyCon, String> diseaseCol;

    @FXML
    private TableColumn<CombinedPhyCon, String> therapyCol;

    @FXML
    private TableView<Vaccine> vaccinationTable;

    @FXML
    private TableColumn<Vaccine, String> id3;

    @FXML
    private TableColumn<Vaccine, String> DISTEMPERcol;

    @FXML
    private TableColumn<Vaccine, String> HEPATITIScol;

    @FXML
    private TableColumn<Vaccine, String> LEPTOSPIROSIScol;

    @FXML
    private TableColumn<Vaccine, String> PARVOcol;

    @FXML
    private TableColumn<Vaccine, String> PARAINFLUENZAcol;

    @FXML
    private TableColumn<Vaccine, String> ADENOVIRUS_TYPE_1col;

    @FXML
    private TableColumn<Vaccine, String> ADENOVIRUS_TYPE_2col;

    @FXML
    private TableColumn<Vaccine, String> BORDETELLAcol;

    @FXML
    private TableColumn<Vaccine, String> RABIEScol;

    @FXML
    private TableColumn<Vaccine, String> FELINEHERPESVIRUScol;

    @FXML
    private TableColumn<Vaccine, String> CALICIVIRUScol;

    @FXML
    private TableColumn<Vaccine, String> FELINE_LEUKEMIA_VIRUScol;

    @FXML
    private TableColumn<Vaccine, String> LAST_VACCINATEDcol;

    @FXML
    private TableColumn<Vaccine, String> NEXT_VACCINATION_DATEcol;

    @FXML
    private TableView<Staff> staffTable;

    @FXML
    private TableColumn<Staff, Integer> employeIdCol4;

    @FXML
    private TableColumn<Staff, String> namecol4;

    @FXML
    private TableColumn<Staff, String> CONTACT_NOcol4;

    @FXML
    private TableColumn<Staff, String> dob4;

    @FXML
    private TableColumn<Staff, String> gender4;

    @FXML
    private TableColumn<Staff, String> jobPosition4;

    @FXML
    private TableColumn<Staff, String> address4;

    @FXML
    private TableColumn<Staff, Integer> salary4;

    @FXML
    private TableColumn<Staff, String> hire_date;

    @FXML
    private TableColumn<Staff, String> email4;

    @FXML
    private TableView<Donor> donorTable;

    @FXML
    private TableColumn<Donor, Integer> donor_id5;

    @FXML
    private TableColumn<Donor, String> name5;

    @FXML
    private TableColumn<Donor, String> contact_no5;

    @FXML
    private TableColumn<Donor, String> email5;

    @FXML
    private TableColumn<Donor, String> address5;

    @FXML
    private TableColumn<Donor, Double> yearsActiveCol;

    @FXML
    private TableColumn<Donor, Integer> assigned_worker5;

    @FXML
    private TableView<Registered> registeredPeopleTable;

    @FXML
    private TableColumn<Registered, String> userName6;

    @FXML
    private TableColumn<Registered, String> occupation6;

    @FXML
    private TableColumn<Registered, Integer> appliedForCol;

    @FXML
    private TableColumn<Registered, String> apptoAdopt;

    @FXML
    private TableColumn<Registered, String> otherPetsCol;

    @FXML
    private TableColumn<Registered, String> application_date6;

//    @FXML
//    private TableColumn<Registered, Void> approve6;

    @FXML
    private TableColumn<Registered, String> contactNo6;

    @FXML
    private TableColumn<Registered, CheckBox> select;

    @FXML
    private TableColumn<Registered, String> address6;

    @FXML
    private TableView<Supplier> suppliersTable;

    @FXML
    private TableColumn<Supplier, Integer> supplierId;

    @FXML
    private TableColumn<Supplier, String> name7;

    @FXML
    private TableColumn<Supplier, String> contact_no7;

    @FXML
    private TableColumn<Supplier, String> description7;

    @FXML
    private TableColumn<Supplier, String> address7;

    @FXML
    private TableView<Transaction> transactionsTable;

    @FXML
    private TableColumn<Transaction, Integer> transactionIdCol;

    @FXML
    private TableColumn<Transaction, String> transDateCol;

    @FXML
    private TableColumn<Transaction, String> type8;

    @FXML
    private TableColumn<Transaction, Integer> person_id8;

    @FXML
    private TableColumn<Transaction, String> id_type8;

    @FXML
    private TableColumn<Transaction, Integer> amount8;

    @FXML
    private TableView<Request> requestToDropTable;

    @FXML
    private TableColumn<Request, Integer> serial_no9;

    @FXML
    private TableColumn<Request, String> application_date9;

    @FXML
    private TableColumn<Request, String> name9;

    @FXML
    private TableColumn<Request, String> contact_no9;

    @FXML
    private TableColumn<Request, String> email9;

    @FXML
    private TableColumn<Request, String> address9;

    @FXML
    private TableColumn<Request, String> rescueDate9;

    @FXML
    private TableColumn<Request, String> animal_type9;

    @FXML
    private TableColumn<Request, String> physical_condition9;

    @FXML
    private TableColumn<Request, Void> approve9;

    @FXML
    private TableView<AdoptedShow> adoptedAnimalsTable;

    @FXML
    private TableColumn<AdoptedShow, Integer> id10;

    @FXML
    private TableColumn<AdoptedShow, String> adoptedByCol;

    @FXML
    private TableColumn<AdoptedShow, String> adName;

    @FXML
    private TableColumn<AdoptedShow, String> contact_no_10;

    @FXML
    private TableColumn<AdoptedShow, String> address10;

    @FXML
    private TableColumn<AdoptedShow, String> email10;

    @FXML
    private TableColumn<AdoptedShow, String> adoptionDate10;

    @FXML
    private AnchorPane adminAnimalCard;

    @FXML
    private Label backToWhereItcameButton;

    @FXML
    private ImageView GeneralImage;

    @FXML
    private Label breedL;

    @FXML
    private Label genderL;

    @FXML
    private Label sizeL;

    @FXML
    private Label stayingSinceL;

    @FXML
    private Label shelteredTimeAgeL;

    @FXML
    private Label houseTrainedL;

    @FXML
    private Label idLabel;

    @FXML
    private Label typelabel;

    @FXML
    private Label nameL;

    @FXML
    private Label accomodationL;

    @FXML
    private Label roomL;

    @FXML
    private Label injuryL;

    @FXML
    private Label diseaseL;

    @FXML
    private Label therapyL;

    @FXML
    private Label lastVacDateL;

    @FXML
    private Label nextVacL;

    @FXML
    private Label distemperL;

    @FXML
    private Label hepatiisL;

    @FXML
    private Label LeptospirosisL;

    @FXML
    private Label parvoL;

    @FXML
    private Label ParainfluenzaL;

    @FXML
    private Label Adenovirus_type_1L;

    @FXML
    private Label BordetellaL;

    @FXML
    private Label Feline_Leukemia_VirusL;

    @FXML
    private Label RabiesL;

    @FXML
    private Label FelineherpevirusL;

    @FXML
    private Label CalicivirusL;

    @FXML
    private Label Adenovirus_type_2L;

    private int latestsize;

    int command = 0;
    int RequestToDropindex;
    List<CombinedAnimal> animalList = new ArrayList<>();
    List<CombinedPhyCon> physicalConditionNormalList = new ArrayList<>();
    List<Vaccine> vaccineNormalList = new ArrayList<>();
    List<Request> requestNormalList = new ArrayList<>();
    List<Donor> donorNormalList = new ArrayList<>();
    List<AdoptedShow> historyNormalList = new ArrayList<>();
    List<Registered> registeredNormalList = new ArrayList<>();
    List<Staff> staffNormalList = new ArrayList<>();
    List<Supplier> supplierNormalList = new ArrayList<>();
    List<Transaction> transactionNormalList = new ArrayList<>();
    List<OldStaff> oldStaffNormalList = new ArrayList<>();

    ObservableList<Donor> DonorList;
    ObservableList<AdoptedShow> HistoryList;
    ObservableList<CombinedPhyCon> PhysicalConditionList;
    ObservableList<Vaccine> VaccineList;
    ObservableList<Registered> RegisteredList;
    ObservableList<Request> RequestList;
    ObservableList<Staff> StaffList;
    ObservableList<Supplier> SupplierList;
    ObservableList<Transaction> TransactionList;
    ObservableList<OldStaff> OldStaffList;

    @FXML
    void refresh(ActionEvent event) throws IOException {
        loadFirst();
    }

    void setMain(Main main) {
        this.main = main;
    }

    public void init(List<CombinedAnimal> list) throws IOException {
        command = 1;
        adminName.setText(main.clientName);

//        animalList = list;
        Exit.setOnMouseClicked(event -> {
            try {
                main.getNetworkUtil().write("end session");//"end session"
                main.getNetworkUtil().write(main.clientName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.exit(0);
        });
        Min.setOnMouseClicked(event -> {
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            stage.setIconified(true);
        });
        slider.setTranslateX(-176);
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(slider);

        slide.setToX(0);
        slide.play();

        slider.setTranslateX(-176);

        slide.setOnFinished((ActionEvent e) -> {
            Menu.setVisible(false);
            MenuClose.setVisible(true);
        });
        approveButton.setVisible(false);
        FIREBUTTON.setVisible(false);
        addRecordButton.setVisible(false);
        donorTable.setVisible(false);
        adoptedAnimalsTable.setVisible(false);
        phyConditionTable.setVisible(false);
        registeredPeopleTable.setVisible(false);
        requestToDropTable.setVisible(false);
        staffTable.setVisible(false);
        suppliersTable.setVisible(false);
        transactionsTable.setVisible(false);
        vaccinationTable.setVisible(false);
        adminAnimalCard.setVisible(false);
        //addRecordButton.setVisible(true);
        saveChangesButton.setVisible(false);
        OldEmployeeTable.setVisible(false);
        //addAnimalButton.setVisible(true);
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    int column = 0;
//                    int row = 1;
//                    for (int i = 0; i < animalList.size(); i++) {
//                        FXMLLoader loader = new FXMLLoader();
//                        loader.setLocation(getClass().getResource("demo.fxml"));
//                        AnchorPane anchor = loader.load();
//                        DemoController controller = loader.getController();
//                        controller.setAnimal(animalList.get(i));
//                        controller.setMain(main);
//                        if (column == 3) {
//                            column = 0;
//                            row++;
//                        }
//                        grid.add(anchor, column++, row);
//                        GridPane.setMargin(anchor, new Insets(10, 10, 10, 10));
//                    }
//                    latestsize = animalList.size();
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//            }
//        });
        loadFirst();
    }

    private void loadFirst() throws IOException {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    main.getNetworkUtil().write("updated animal list for admin");
                    main.getNetworkUtil().write(null);
                    main.getNetworkUtil().write("donor");
                    main.getNetworkUtil().write(null);
                    main.getNetworkUtil().write("adopted");
                    main.getNetworkUtil().write(null);
                    main.getNetworkUtil().write("phycon");
                    main.getNetworkUtil().write(null);
                    main.getNetworkUtil().write("registered");
                    main.getNetworkUtil().write(null);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    main.getNetworkUtil().write("reqtodrop");
                    main.getNetworkUtil().write(null);
                    main.getNetworkUtil().write("staff");
                    main.getNetworkUtil().write(null);
                    main.getNetworkUtil().write("supplier");
                    main.getNetworkUtil().write(null);
                    main.getNetworkUtil().write("transaction");
                    main.getNetworkUtil().write(null);
                    main.getNetworkUtil().write("vaccine");
                    main.getNetworkUtil().write(null);
                    main.getNetworkUtil().write("oldstaff");
                    main.getNetworkUtil().write(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        main.getNetworkUtil().write("updated animal list for admin");
//        main.getNetworkUtil().write(null);
//        main.getNetworkUtil().write("donor");
//        main.getNetworkUtil().write(null);
//        main.getNetworkUtil().write("adopted");
//        main.getNetworkUtil().write(null);
//        main.getNetworkUtil().write("phycon");
//        main.getNetworkUtil().write(null);
//        main.getNetworkUtil().write("registered");
//        main.getNetworkUtil().write(null);
//        main.getNetworkUtil().write("reqtodrop");
//        main.getNetworkUtil().write(null);
//        main.getNetworkUtil().write("staff");
//        main.getNetworkUtil().write(null);
//        main.getNetworkUtil().write("supplier");
//        main.getNetworkUtil().write(null);
//        main.getNetworkUtil().write("transaction");
//        main.getNetworkUtil().write(null);
//        main.getNetworkUtil().write("vaccine");
//        main.getNetworkUtil().write(null);
    }

    @FXML
    void tologinAction(ActionEvent event) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    main.getNetworkUtil().write("admin/user logout");
                    main.getNetworkUtil().write(main.clientName);
                    main.showLoginPageHP();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    void animalsAction(ActionEvent event) throws IOException {
        pageNameLabel.setText("Animals");
        addRecordButton.setVisible(false);
        donorTable.setVisible(false);
        addAnimalButton.setVisible(true);
        adoptedAnimalsTable.setVisible(false);
        phyConditionTable.setVisible(false);
        registeredPeopleTable.setVisible(false);
        requestToDropTable.setVisible(false);
        staffTable.setVisible(false);
        suppliersTable.setVisible(false);
        transactionsTable.setVisible(false);
        vaccinationTable.setVisible(false);
        adminAnimalCard.setVisible(false);
        //addRecordButton.setVisible(true);
        saveChangesButton.setVisible(true);
        OldEmployeeTable.setVisible(false);
//        if (command == 0) {
//            main.getNetworkUtil().write("updated animal list for admin");
//            main.getNetworkUtil().write(null);
//        }

    }

    void residual(List<CombinedAnimal> list) {
        animalList = list;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                try {
                        grid.getChildren().clear();

                    int column = 0;
                    int row = 1;
                    for (int i = 0; i < animalList.size(); i++) {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("demo.fxml"));
                        AnchorPane anchor = loader.load();
                        DemoController controller = loader.getController();
                        controller.setAnimal(animalList.get(i));
                        controller.setMain(main);
                        if (column == 3) {
                            column = 0;
                            row++;
                        }
                        grid.add(anchor, column++, row);
                        GridPane.setMargin(anchor, new Insets(10, 10, 10, 10));
                    }
                    latestsize = animalList.size();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    @FXML
    void donorAction(ActionEvent event) throws IOException {
        command = 5;
        pageNameLabel.setText("Donors");
        donorTable.setVisible(true);
        adoptedAnimalsTable.setVisible(false);
        phyConditionTable.setVisible(false);
        registeredPeopleTable.setVisible(false);
        requestToDropTable.setVisible(false);
        staffTable.setVisible(false);
        suppliersTable.setVisible(false);
        transactionsTable.setVisible(false);
        vaccinationTable.setVisible(false);
        adminAnimalCard.setVisible(false);
        addRecordButton.setVisible(true);
        saveChangesButton.setVisible(true);
        addAnimalButton.setVisible(false);
        OldEmployeeTable.setVisible(false);
        donor_id5.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("donor_id"));
        donor_id5.setCellFactory(TextFieldTableCell.<Donor, Integer>forTableColumn(new IntegerStringConverter()));
        donor_id5.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Donor, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Donor, Integer> t) {
                        ((Donor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDonor_id(t.getNewValue());
                        Donor p = t.getRowValue();
                        int index = donorNormalList.indexOf(p);
                        donorNormalList.get(index).setDonor_id(t.getNewValue());
                    }
                }
        );
        name5.setCellValueFactory(new PropertyValueFactory<Donor, String>("name"));
        name5.setCellFactory(TextFieldTableCell.forTableColumn());
        name5.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Donor, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Donor, String> t) {
                        ((Donor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
                        Donor p = t.getRowValue();
                        int index = donorNormalList.indexOf(p);
                        donorNormalList.get(index).setName(t.getNewValue());
                    }
                }
        );
        contact_no5.setCellValueFactory(new PropertyValueFactory<Donor, String>("contact_no"));
        contact_no5.setCellFactory(TextFieldTableCell.forTableColumn());
        contact_no5.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Donor, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Donor, String> t) {
                        ((Donor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setContact_no(t.getNewValue());
                        Donor p = t.getRowValue();
                        int index = donorNormalList.indexOf(p);
                        donorNormalList.get(index).setContact_no(t.getNewValue());
                    }
                }
        );
        email5.setCellValueFactory(new PropertyValueFactory<Donor, String>("email"));
        email5.setCellFactory(TextFieldTableCell.forTableColumn());
        email5.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Donor, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Donor, String> t) {
                        ((Donor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEmail(t.getNewValue());
                        Donor p = t.getRowValue();
                        int index = donorNormalList.indexOf(p);
                        donorNormalList.get(index).setEmail(t.getNewValue());
                    }
                }
        );
        address5.setCellValueFactory(new PropertyValueFactory<Donor, String>("address"));
        address5.setCellFactory(TextFieldTableCell.forTableColumn());
        address5.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Donor, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Donor, String> t) {
                        ((Donor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAddress(t.getNewValue());
                        Donor p = t.getRowValue();
                        int index = donorNormalList.indexOf(p);
                        donorNormalList.get(index).setAddress(t.getNewValue());
                    }
                }
        );
        yearsActiveCol.setCellValueFactory(new PropertyValueFactory<Donor, Double>("years_active"));
        yearsActiveCol.setCellFactory(TextFieldTableCell.<Donor, Double>forTableColumn(new DoubleStringConverter()));
        yearsActiveCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Donor, Double>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Donor, Double> t) {
                        ((Donor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setYears_active(t.getNewValue());
                        Donor p = t.getRowValue();
                        int index = donorNormalList.indexOf(p);
                        donorNormalList.get(index).setYears_active(t.getNewValue());
                    }
                }
        );
        assigned_worker5.setCellValueFactory(new PropertyValueFactory<Donor, Integer>("assigned_worker"));
        assigned_worker5.setCellFactory(TextFieldTableCell.<Donor, Integer>forTableColumn(new IntegerStringConverter()));
        assigned_worker5.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Donor, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Donor, Integer> t) {
                        ((Donor) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAssigned_worker(t.getNewValue());
                        Donor p = t.getRowValue();
                        int index = donorNormalList.indexOf(p);
                        donorNormalList.get(index).setAssigned_worker(t.getNewValue());
                    }
                }
        );
//        if (command == 0) {
//            main.getNetworkUtil().write("donor");
//            main.getNetworkUtil().write(null);
//        }

    }

    void donorLoad(List<Donor> list) throws Exception {
        DonorList = FXCollections.observableArrayList();
        DonorList.addAll(list);
        donorTable.setEditable(true);
        donorTable.setItems(DonorList);
        donorNormalList = list;
//        donorNormalList.add(new Donor(-1,"","","","",-1,-1));
    }

    @FXML
    void historyAction(ActionEvent event) throws IOException {
        command = 10;
        pageNameLabel.setText("Adopted Animals");
        donorTable.setVisible(false);
        adoptedAnimalsTable.setVisible(true);
        phyConditionTable.setVisible(false);
        registeredPeopleTable.setVisible(false);
        requestToDropTable.setVisible(false);
        staffTable.setVisible(false);
        suppliersTable.setVisible(false);
        transactionsTable.setVisible(false);
        vaccinationTable.setVisible(false);
        adminAnimalCard.setVisible(false);
        addRecordButton.setVisible(false);
        saveChangesButton.setVisible(false);
        addAnimalButton.setVisible(false);
        OldEmployeeTable.setVisible(false);

        id10.setCellValueFactory(new PropertyValueFactory<AdoptedShow, Integer>("id"));
        id10.setCellFactory(TextFieldTableCell.<AdoptedShow, Integer>forTableColumn(new IntegerStringConverter()));
        adName.setCellValueFactory(new PropertyValueFactory<AdoptedShow, String>("name"));
//        id10.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<AdoptedShow, Integer>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<AdoptedShow, Integer> t) {
//                        ((AdoptedShow) t.getTableView().getItems().get(t.getTablePosition().getRow())).setId(t.getNewValue());
//                        AdoptedShow p = t.getRowValue();
//                        int index = historyNormalList.indexOf(p);
//                        historyNormalList.get(index).setId(t.getNewValue());
//                    }
//                }
//        );
        adoptedByCol.setCellValueFactory(new PropertyValueFactory<AdoptedShow, String>("adopted_by"));
//        adoptedByCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        adoptedByCol.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<AdoptedShow, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<AdoptedShow, String> t) {
//                        ((AdoptedShow) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdopted_by(t.getNewValue());
//                        AdoptedShow p = t.getRowValue();
//                        int index = historyNormalList.indexOf(p);
//                        historyNormalList.get(index).setAdopted_by(t.getNewValue());
//                    }
//                }
//        );
        contact_no_10.setCellValueFactory(new PropertyValueFactory<AdoptedShow, String>("contact_no"));
//        contact_no_10.setCellFactory(TextFieldTableCell.forTableColumn());
//        contact_no_10.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<AdoptedShow, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<AdoptedShow, String> t) {
//                        ((AdoptedShow) t.getTableView().getItems().get(t.getTablePosition().getRow())).setContact_no(t.getNewValue());
//                        AdoptedShow p = t.getRowValue();
//                        int index = historyNormalList.indexOf(p);
//                        historyNormalList.get(index).setContact_no(t.getNewValue());
//                    }
//                }
//        );
        address10.setCellValueFactory(new PropertyValueFactory<AdoptedShow, String>("address"));
//        address10.setCellFactory(TextFieldTableCell.forTableColumn());
//        address10.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<AdoptedShow, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<AdoptedShow, String> t) {
//                        ((AdoptedShow) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAddress(t.getNewValue());
//                        AdoptedShow p = t.getRowValue();
//                        int index = historyNormalList.indexOf(p);
//                        historyNormalList.get(index).setAddress(t.getNewValue());
//                    }
//                }
//        );
        email10.setCellValueFactory(new PropertyValueFactory<AdoptedShow, String>("email"));
//        email10.setCellFactory(TextFieldTableCell.forTableColumn());
//        email10.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<AdoptedShow, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<AdoptedShow, String> t) {
//                        ((AdoptedShow) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEmail(t.getNewValue());
//                        AdoptedShow p = t.getRowValue();
//                        int index = historyNormalList.indexOf(p);
//                        historyNormalList.get(index).setEmail(t.getNewValue());
//                    }
//                }
//        );
        adoptionDate10.setCellValueFactory(new PropertyValueFactory<AdoptedShow, String>("adoption_date"));
//        adoptionDate10.setCellFactory(TextFieldTableCell.forTableColumn());
//        adoptionDate10.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<AdoptedShow, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<AdoptedShow, String> t) {
//                        ((AdoptedShow) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdoption_date(t.getNewValue());
//                        AdoptedShow p = t.getRowValue();
//                        int index = historyNormalList.indexOf(p);
//                        historyNormalList.get(index).setAdoption_date(t.getNewValue());
//                    }
//                }
//        );
//        if (command == 0) {
//            main.getNetworkUtil().write("adopted");
//            main.getNetworkUtil().write(null);
//        }

    }

    void historyLoad(List<AdoptedShow> list) throws Exception {
        HistoryList = FXCollections.observableArrayList();
        HistoryList.addAll(list);
        adoptedAnimalsTable.setEditable(true);
        adoptedAnimalsTable.setItems(HistoryList);
        historyNormalList = list;
    }

    @FXML
    void phyConAction(ActionEvent event) throws IOException {
        command = 2;
        pageNameLabel.setText("Physical Condition");
        donorTable.setVisible(false);
        adoptedAnimalsTable.setVisible(false);
        phyConditionTable.setVisible(true);
        registeredPeopleTable.setVisible(false);
        requestToDropTable.setVisible(false);
        staffTable.setVisible(false);
        suppliersTable.setVisible(false);
        transactionsTable.setVisible(false);
        vaccinationTable.setVisible(false);
        adminAnimalCard.setVisible(false);
        addRecordButton.setVisible(true);
        saveChangesButton.setVisible(true);
        addAnimalButton.setVisible(false);
        OldEmployeeTable.setVisible(false);
        id2.setCellValueFactory(new PropertyValueFactory<CombinedPhyCon, String>("name"));
        id2.setCellFactory(TextFieldTableCell.forTableColumn());
        id2.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<CombinedPhyCon, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<CombinedPhyCon, String> t) {
                        ((CombinedPhyCon) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getOldValue());
                        CombinedPhyCon p = t.getRowValue();
                        int index = physicalConditionNormalList.indexOf(p);
                        ((CombinedPhyCon) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
                        p = t.getRowValue();
                        physicalConditionNormalList.get(index).setName(t.getNewValue());
                    }
                }
        );
        injury_statusCol.setCellValueFactory(new PropertyValueFactory<CombinedPhyCon, String>("injury_status"));
        injury_statusCol.setCellFactory(TextFieldTableCell.forTableColumn());
        injury_statusCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<CombinedPhyCon, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<CombinedPhyCon, String> t) {
                        ((CombinedPhyCon) t.getTableView().getItems().get(t.getTablePosition().getRow())).setInjury_status(t.getNewValue());
                        CombinedPhyCon p = t.getRowValue();
                        int index = physicalConditionNormalList.indexOf(p);
                        physicalConditionNormalList.get(index).setInjury_status(t.getNewValue());
                    }
                }
        );
        diseaseCol.setCellValueFactory(new PropertyValueFactory<CombinedPhyCon, String>("disease"));
        diseaseCol.setCellFactory(TextFieldTableCell.forTableColumn());
        diseaseCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<CombinedPhyCon, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<CombinedPhyCon, String> t) {
                        ((CombinedPhyCon) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDisease(t.getNewValue());
                        CombinedPhyCon p = t.getRowValue();
                        int index = physicalConditionNormalList.indexOf(p);
                        physicalConditionNormalList.get(index).setDisease(t.getNewValue());
                    }
                }
        );
        therapyCol.setCellValueFactory(new PropertyValueFactory<CombinedPhyCon, String>("therapy"));
        therapyCol.setCellFactory(TextFieldTableCell.forTableColumn());
        therapyCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<CombinedPhyCon, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<CombinedPhyCon, String> t) {
                        ((CombinedPhyCon) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTherapy(t.getNewValue());
                        CombinedPhyCon p = t.getRowValue();
                        int index = physicalConditionNormalList.indexOf(p);
                        physicalConditionNormalList.get(index).setTherapy(t.getNewValue());
                    }
                }
        );
//        if (command == 0) {
//            main.getNetworkUtil().write("phycon");
//            main.getNetworkUtil().write(null);
//        }

    }

    @FXML
    void saveChangesAction(ActionEvent event) throws IOException {
        if (command == 2) {
//            int i=physicalConditionNormalList.indexOf(new PhysicalCondition(-1, "", "", ""));
//            System.out.println(i);
//            List<PhysicalCondition> cut = physicalConditionNormalList.stream().filter(p->physicalConditionNormalList.indexOf(p)>i).collect(Collectors.toList());
            main.getNetworkUtil().write(physicalConditionNormalList);
            main.getNetworkUtil().write("new phycon");
        } else if (command == 3) {
            main.getNetworkUtil().write(vaccineNormalList);
            main.getNetworkUtil().write("new vaccine");
        } else if (command == 4) {
            main.getNetworkUtil().write(staffNormalList);
            main.getNetworkUtil().write("new staff");
            staffNormalList.forEach(e -> {
                e.setAdded(false);
                e.setUpdated(false);
            });
        } else if (command == 5) {
            main.getNetworkUtil().write(donorNormalList);
            main.getNetworkUtil().write("new donor");
        } else if (command == 6) {

        } else if (command == 7) {
            main.getNetworkUtil().write(supplierNormalList);
            main.getNetworkUtil().write("new supplier");
        } else if (command == 8) {
            main.getNetworkUtil().write(transactionNormalList);
            main.getNetworkUtil().write("new transaction");
        } else if (command == 9) {

        } else if (command == 10) {

        }
    }

    @FXML
    void addRecordAction(ActionEvent event) {
        if (command == 2) {
            CombinedPhyCon p = new CombinedPhyCon(0,"Add","Add", "Add", "Add");
            PhysicalConditionList.add(p);
            physicalConditionNormalList.add(p);
            phyConditionTable.setItems(PhysicalConditionList);
        } else if (command == 3) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
            Vaccine p = new Vaccine(0, "Add", "Add", "Add", "Add", "Add", "Add", "Add", "Add", "Add", "Add", "Add", "Add", LocalDate.now() + " " + LocalTime.now().format(df), LocalDate.now() + " " + LocalTime.now().format(df));
            VaccineList.add(p);
            vaccineNormalList.add(p);
            vaccinationTable.setItems(VaccineList);
        } else if (command == 4) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
            Staff p = new Staff(staffNormalList.size() + 1, "Add", "Add", "Add", "Add", LocalDate.now() + " " + LocalTime.now().format(df), "Add", "Add", 0, LocalDate.now() + " " + LocalTime.now().format(df));
            p.setAdded(true);
            StaffList.add(p);
            staffNormalList.add(p);
            staffTable.setItems(StaffList);
        } else if (command == 5) {
            Donor p = new Donor(donorNormalList.size() + 1, "Add", "Add", "Add", "Add", 0, 0);
            DonorList.add(p);
            donorNormalList.add(p);
            donorTable.setItems(DonorList);
        } else if (command == 6) {
//            Registered p = new Registered( "Add",0, "Add");
//            RegisteredList.add(p);
//            registeredNormalList.add(p);
//            registeredPeopleTable.setItems(RegisteredList);

        } else if (command == 7) {
            Supplier p = new Supplier(supplierNormalList.size() + 1, "Add", "Add", "Add", "Add");
            SupplierList.add(p);
            supplierNormalList.add(p);
            suppliersTable.setItems(SupplierList);
        } else if (command == 8) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
            Transaction p = new Transaction(transactionNormalList.get(transactionNormalList.size() - 1).getTrans_id() + 1, "Add", 0, "Add", 0, LocalDate.now() + " " + LocalTime.now().format(df));
            TransactionList.add(p);
            transactionNormalList.add(p);
            transactionsTable.setItems(TransactionList);
        } else if (command == 9) {
//            Request p = new Request( requestNormalList.size()+1, "Add","Add","Add","Add","Add","Add","Add","Add");
//            RequestList.add(p);
//            requestNormalList.add(p);
//            requestToDropTable.setItems(RequestList);

        } else if (command == 10) {
//            AdoptedShow p = new AdoptedShow( historyNormalList.size()+1, "Add","Add","Add","Add","Add");
//            HistoryList.add(p);
//            historyNormalList.add(p);
//            adoptedAnimalsTable.setItems(HistoryList);

        }
    }

    void phyconLoad(List<CombinedPhyCon> list) throws Exception {
//        command = 2;
        PhysicalConditionList = FXCollections.observableArrayList();
        PhysicalConditionList.addAll(list);
        phyConditionTable.setEditable(true);
        phyConditionTable.setItems(PhysicalConditionList);
        physicalConditionNormalList = list;
//        physicalConditionNormalList.add(new PhysicalCondition(-1, "", "", ""));
    }


    @FXML
    void registeredAction(ActionEvent event) throws IOException {
        pageNameLabel.setText("Registered People");
        command = 6;
        approveButton.setVisible(true);
        donorTable.setVisible(false);
        adoptedAnimalsTable.setVisible(false);
        phyConditionTable.setVisible(false);
        registeredPeopleTable.setVisible(true);
        requestToDropTable.setVisible(false);
        staffTable.setVisible(false);
        suppliersTable.setVisible(false);
        transactionsTable.setVisible(false);
        vaccinationTable.setVisible(false);
        adminAnimalCard.setVisible(false);
        addRecordButton.setVisible(false);
        saveChangesButton.setVisible(false);
        addAnimalButton.setVisible(false);
        OldEmployeeTable.setVisible(false);
        userName6.setCellValueFactory(new PropertyValueFactory<Registered, String>("user_name"));
        userName6.setCellFactory(TextFieldTableCell.forTableColumn());
//        userName6.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Registered, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Registered, String> t) {
//                        ((Registered) t.getTableView().getItems().get(t.getTablePosition().getRow())).setUser_name(t.getNewValue());
//                        Registered p = t.getRowValue();
//                        int index = registeredNormalList.indexOf(p);
//                        registeredNormalList.get(index).setUser_name(t.getNewValue());
//                    }
//                }
//        );
        appliedForCol.setCellValueFactory(new PropertyValueFactory<Registered, Integer>("applied_for"));
        apptoAdopt.setCellValueFactory(new PropertyValueFactory<Registered, String>("name"));
//        appliedForCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//        appliedForCol.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Registered, Integer>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Registered, Integer> t) {
//                        ((Registered) t.getTableView().getItems().get(t.getTablePosition().getRow())).setApplied_for(t.getNewValue());
//                        Registered p = t.getRowValue();
//                        int index = registeredNormalList.indexOf(p);
//                        registeredNormalList.get(index).setApplied_for(t.getNewValue());
//                    }
//                }
//        );
        application_date6.setCellValueFactory(new PropertyValueFactory<Registered, String>("Application_date"));
//        application_date6.setCellFactory(TextFieldTableCell.forTableColumn());
//        application_date6.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Registered, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Registered, String> t) {
//                        ((Registered) t.getTableView().getItems().get(t.getTablePosition().getRow())).setApplication_date(t.getNewValue());
//                        Registered p = t.getRowValue();
//                        int index = registeredNormalList.indexOf(p);
//                        registeredNormalList.get(index).setApplication_date(t.getNewValue());
//                    }
//                }
//        );
//        if (command == 0) {
//            main.getNetworkUtil().write("registered");
//            main.getNetworkUtil().write(null);
//        }
//        select.setCellValueFactory(new PropertyValueFactory<Registered, CheckBox>("check"));
        select.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Registered, CheckBox>, ObservableValue<CheckBox>>() {

            @Override
            public ObservableValue<CheckBox> call(TableColumn.CellDataFeatures<Registered, CheckBox> arg0) {
                Registered user = arg0.getValue();
                CheckBox checkBox = new CheckBox();
                checkBox.selectedProperty().setValue(user.getCheck());
                checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    public void changed(ObservableValue<? extends Boolean> ov,
                                        Boolean old_val, Boolean new_val) {

                        user.setCheck(new_val);

                    }
                });

                return new SimpleObjectProperty<CheckBox>(checkBox);

            }

        });
//        select.setCellFactory(tc -> new CheckBoxTableCell<>());
//        select.setCellFactory(
//                CheckBoxTableCell.forTableColumn((Callback<Integer, ObservableValue<Boolean>>) select)
//        );
//        select.setCellFactory(TextFieldTableCell.forTableColumn());
//        Callback<TableColumn<Registered, Void>, TableCell<Registered, Void>> cellFactory = new Callback<TableColumn<Registered, Void>, TableCell<Registered, Void>>() {
//            @Override
//            public TableCell<Registered, Void> call(final TableColumn<Registered, Void> param) {
//                final TableCell<Registered, Void> cell = new TableCell<Registered, Void>() {
//
//                    private final Button button = new Button("OK");
//
//                    {
//                        button.setOnAction(e -> {
//                                    Platform.runLater(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            Alert a = new Alert(Alert.AlertType.INFORMATION);
//                                            a.setContentText("This request is approved");
//                                            a.showAndWait();
////                                            ArrayList<Registered> list = new ArrayList<>(registeredPeopleTable.getSelectionModel().getSelectedItems());
////                                            int index=registeredPeopleTable.getSelectionModel().getSelectedIndex();
//                                            ArrayList<Registered> list = new ArrayList<>();
//                                            registeredNormalList.forEach(e -> {
//                                                if (e.getCheck()) {
//                                                    list.add(e);
//                                                }
//                                            });
//                                            if (list.size() > 0)//index
//                                            {
//                                                try {
//                                                    registeredNormalList.removeAll(list);
//                                                    registeredPeopleTable.getItems().removeAll(list);
//                                                    main.getNetworkUtil().write(list);
//                                                    main.getNetworkUtil().write("trigger registered to adopted");//registeredNormalList.get(index).getApplied_for()
//                                                } catch (IOException ioException) {
//                                                    ioException.printStackTrace();
//                                                } catch (Exception e) {
//
//                                                }
//                                            }
//                                        }
//                                    });
//
//                                }
//                        );
//                    }
//
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(button);
//                        }
//                    }
//                };
//                return cell;
//            }
//        };
//        approve6.setCellFactory(cellFactory);
    }

    void registeredLoad(List<Registered> list) throws Exception {
        RegisteredList = FXCollections.observableArrayList();
        RegisteredList.addAll(list);
        registeredPeopleTable.setEditable(true);
        registeredPeopleTable.setItems(RegisteredList);
        registeredNormalList = list;
    }
    @FXML
    void approveAction(ActionEvent event) {
        ArrayList<Registered> list = new ArrayList<>();
        registeredNormalList.forEach(e -> {
            if (e.getCheck()) {
                list.add(e);
            }
        });
        if (list.size() > 0)//index
        {
            try {
                boolean  flag=false;
                for(int i=0;i<list.size();i++){
                    for(int j=0;j<list.size();j++){
                        if(list.get(i).getApplied_for()==list.get(j).getApplied_for() && i!=j){
                            flag=true;
                        }
                    }
                }
                if(!flag){
                    registeredNormalList.removeAll(list);
                    registeredPeopleTable.getItems().removeAll(list);
                    main.getNetworkUtil().write(list);
                    main.getNetworkUtil().write("trigger registered to adopted");//registeredNormalList.get(index).getApplied_for()
                }
                else {
                    main.showAlert("Multiple adoption request for a single animal cannot be permitted");
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception e) {

            }
        }
    }
    @FXML
    void reqToDropAction(ActionEvent event) throws IOException {
        command = 9;
        pageNameLabel.setText("Request To Drop");
        donorTable.setVisible(false);
        adoptedAnimalsTable.setVisible(false);
        phyConditionTable.setVisible(false);
        registeredPeopleTable.setVisible(false);
        requestToDropTable.setVisible(true);
        staffTable.setVisible(false);
        suppliersTable.setVisible(false);
        transactionsTable.setVisible(false);
        vaccinationTable.setVisible(false);
        adminAnimalCard.setVisible(false);
        addRecordButton.setVisible(false);
        saveChangesButton.setVisible(false);
        addAnimalButton.setVisible(false);
        OldEmployeeTable.setVisible(false);
        serial_no9.setCellValueFactory(new PropertyValueFactory<Request, Integer>("serial_no"));

        application_date9.setCellValueFactory(new PropertyValueFactory<Request, String>("Application_date"));
        application_date9.setCellFactory(TextFieldTableCell.forTableColumn());
//        application_date9.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Request, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Request, String> t) {
//                        ((Request) t.getTableView().getItems().get(t.getTablePosition().getRow())).setApplication_date(t.getNewValue());
//                        Request p = t.getRowValue();
//                        int index = requestNormalList.indexOf(p);
//                        requestNormalList.get(index).setApplication_date(t.getNewValue());
//                    }
//                }
//        );
        name9.setCellValueFactory(new PropertyValueFactory<Request, String>("name"));
//        name9.setCellFactory(TextFieldTableCell.forTableColumn());
//        name9.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Request, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Request, String> t) {
//                        ((Request) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
//                        Request p = t.getRowValue();
//                        int index = requestNormalList.indexOf(p);
//                        requestNormalList.get(index).setName(t.getNewValue());
//                    }
//                }
//        );
        contact_no9.setCellValueFactory(new PropertyValueFactory<Request, String>("Contact_no"));
//        contact_no9.setCellFactory(TextFieldTableCell.forTableColumn());
//        contact_no9.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Request, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Request, String> t) {
//                        ((Request) t.getTableView().getItems().get(t.getTablePosition().getRow())).setContact_no(t.getNewValue());
//                        Request p = t.getRowValue();
//                        int index = requestNormalList.indexOf(p);
//                        requestNormalList.get(index).setContact_no(t.getNewValue());
//                    }
//                }
//        );
        email9.setCellValueFactory(new PropertyValueFactory<Request, String>("email"));
//        email9.setCellFactory(TextFieldTableCell.forTableColumn());
//        email9.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Request, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Request, String> t) {
//                        ((Request) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEmail(t.getNewValue());
//                        Request p = t.getRowValue();
//                        int index = requestNormalList.indexOf(p);
//                        requestNormalList.get(index).setEmail(t.getNewValue());
//                    }
//                }
//        );
        address9.setCellValueFactory(new PropertyValueFactory<Request, String>("address"));
//        address9.setCellFactory(TextFieldTableCell.forTableColumn());
//        address9.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Request, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Request, String> t) {
//                        ((Request) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAddress(t.getNewValue());
//                        Request p = t.getRowValue();
//                        int index = requestNormalList.indexOf(p);
//                        requestNormalList.get(index).setAddress(t.getNewValue());
//                    }
//                }
//        );
        rescueDate9.setCellValueFactory(new PropertyValueFactory<Request, String>("rescue_date"));
//        rescueDate9.setCellFactory(TextFieldTableCell.forTableColumn());
//        rescueDate9.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Request, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Request, String> t) {
//                        ((Request) t.getTableView().getItems().get(t.getTablePosition().getRow())).setRescue_date(t.getNewValue());
//                        Request p = t.getRowValue();
//                        int index = requestNormalList.indexOf(p);
//                        requestNormalList.get(index).setRescue_date(t.getNewValue());
//                    }
//                }
//        );
        animal_type9.setCellValueFactory(new PropertyValueFactory<Request, String>("animal_type"));
//        animal_type9.setCellFactory(TextFieldTableCell.forTableColumn());
//        animal_type9.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Request, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Request, String> t) {
//                        ((Request) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAnimal_type(t.getNewValue());
//                        Request p = t.getRowValue();
//                        int index = requestNormalList.indexOf(p);
//                        requestNormalList.get(index).setAnimal_type(t.getNewValue());
//                    }
//                }
//        );
        physical_condition9.setCellValueFactory(new PropertyValueFactory<Request, String>("physical_condition"));
//        physical_condition9.setCellFactory(TextFieldTableCell.forTableColumn());
//        physical_condition9.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Request, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Request, String> t) {
//                        ((Request) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPhysical_condition(t.getNewValue());
//                        Request p = t.getRowValue();
//                        int index = requestNormalList.indexOf(p);
//                        requestNormalList.get(index).setPhysical_condition(t.getNewValue());
//                    }
//                }
//        );
//        if (command == 0) {
//            main.getNetworkUtil().write("reqtodrop");
//            main.getNetworkUtil().write(null);
//        }
        Callback<TableColumn<Request, Void>, TableCell<Request, Void>> cellFactory = new Callback<TableColumn<Request, Void>, TableCell<Request, Void>>() {
            @Override
            public TableCell<Request, Void> call(final TableColumn<Request, Void> param) {
                final TableCell<Request, Void> cell = new TableCell<Request, Void>() {

                    private final Button button = new Button("OK");

                    {
                        button.setOnAction(e -> {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            RequestToDropindex = requestToDropTable.getSelectionModel().getSelectedIndex();
                                            if (RequestToDropindex >= 0) {
                                                try {
//                                                    main.getNetworkUtil().write("trigger request to animal");
//                                                    main.getNetworkUtil().write(requestNormalList.get(index));
                                                    AdditionalInfoPane.setVisible(true);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }

                                        }
                                    });

                                }
                        );
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
                return cell;
            }
        };
        approve9.setCellFactory(cellFactory);
    }

    void reqToDropLoad(List<Request> list) throws Exception {
        RequestList = FXCollections.observableArrayList();
        RequestList.addAll(list);
        requestToDropTable.setEditable(true);
        requestToDropTable.setItems(RequestList);
        requestNormalList = list;
    }

    @FXML
    void backToRequestToDrop(MouseEvent event) {
        AdditionalInfoPane.setVisible(false);
    }

    @FXML
    void staffAction(ActionEvent event) throws IOException {
        command = 4;
        pageNameLabel.setText("Staffs");
        FIREBUTTON.setVisible(true);
        donorTable.setVisible(false);
        adoptedAnimalsTable.setVisible(false);
        phyConditionTable.setVisible(false);
        registeredPeopleTable.setVisible(false);
        requestToDropTable.setVisible(false);
        staffTable.setVisible(true);
        suppliersTable.setVisible(false);
        transactionsTable.setVisible(false);
        vaccinationTable.setVisible(false);
        adminAnimalCard.setVisible(false);
        addRecordButton.setVisible(true);
        saveChangesButton.setVisible(true);
        approveButton.setVisible(false);
        addAnimalButton.setVisible(false);
        OldEmployeeTable.setVisible(false);
        employeIdCol4.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("employee_id"));
        employeIdCol4.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        employeIdCol4.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, Integer> t) {
                        ((Staff) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEmployee_id(t.getNewValue());
                        Staff p = t.getRowValue();
                        int index = staffNormalList.indexOf(p);
                        staffNormalList.get(index).setEmployee_id(t.getNewValue());
                        staffNormalList.get(index).setUpdated(true);
                    }
                }
        );
        namecol4.setCellValueFactory(new PropertyValueFactory<Staff, String>("name"));
        namecol4.setCellFactory(TextFieldTableCell.forTableColumn());
        namecol4.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
                        Staff p = t.getRowValue();
                        int index = staffNormalList.indexOf(p);
                        staffNormalList.get(index).setName(t.getNewValue());
                        staffNormalList.get(index).setUpdated(true);
                    }
                }
        );
        CONTACT_NOcol4.setCellValueFactory(new PropertyValueFactory<Staff, String>("contact_no"));
        CONTACT_NOcol4.setCellFactory(TextFieldTableCell.forTableColumn());
        CONTACT_NOcol4.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(t.getTablePosition().getRow())).setContact_no(t.getNewValue());
                        Staff p = t.getRowValue();
                        int index = staffNormalList.indexOf(p);
                        staffNormalList.get(index).setContact_no(t.getNewValue());
                        staffNormalList.get(index).setUpdated(true);
                    }
                }
        );
        dob4.setCellValueFactory(new PropertyValueFactory<Staff, String>("Date_of_birth"));
        dob4.setCellFactory(new Callback<TableColumn<Staff, String>, TableCell<Staff, String>>() {
            @Override
            public TableCell<Staff, String> call(final TableColumn<Staff, String> param) {
                final TableCell<Staff, String> cell = new TableCell<Staff, String>() {

                    private DatePicker dt = new DatePicker();

                    {
                        dt.setOnAction(e -> {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
//                                            SimpleDateFormat sf=new SimpleDateFormat("");
                                            int index = staffTable.getSelectionModel().getSelectedIndex();
                                            try {
//                                            staffNormalList.get(index).setDate_of_birth(sf.format(java.sql.Date.valueOf(dt.getValue())));
                                                staffNormalList.get(index).setDate_of_birth(String.valueOf(dt.getValue()) + " 00:00:00");
                                                staffNormalList.get(index).setUpdated(true);
//                                            System.out.println(staffNormalList.get(index).getDate_of_birth());
                                            } catch (Exception e) {
//                                                System.out.println("Select a/the row first");
                                            }
                                            //sf.format(java.sql.Date.valueOf(tokens[4]))
                                        }
                                    });
                                }
                        );
                    }

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
//                            setGraphic(dt);
                        } else {
//                            SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy");
//                            DateTimeFormatter formatter =new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd-MMM-yyyy").toFormatter(Locale.ENGLISH);
                            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//input date from database
//                            dt.setValue(LocalDate.parse(item,df));
//                            dt.setValue(LocalDate.parse(getItem()));
                            dt.setValue(LocalDate.parse(item, df));
                            setGraphic(dt);
                        }
                    }
                };
                return cell;
            }
        });
//        dob4.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
//                        ((Staff) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDate_of_birth(t.getNewValue());
//                        Staff p = t.getRowValue();
//                        int index = staffNormalList.indexOf(p);
//                        staffNormalList.get(index).setDate_of_birth(t.getNewValue());
//                    }
//                }
//        );
        gender4.setCellValueFactory(new PropertyValueFactory<Staff, String>("gender"));
        gender4.setCellFactory(TextFieldTableCell.forTableColumn());
        gender4.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGender(t.getNewValue());
                        Staff p = t.getRowValue();
                        int index = staffNormalList.indexOf(p);
                        staffNormalList.get(index).setGender(t.getNewValue());
                        staffNormalList.get(index).setUpdated(true);
                    }
                }
        );
        jobPosition4.setCellValueFactory(new PropertyValueFactory<Staff, String>("job_position"));
        jobPosition4.setCellFactory(TextFieldTableCell.forTableColumn());
        jobPosition4.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(t.getTablePosition().getRow())).setJob_position(t.getNewValue());
                        Staff p = t.getRowValue();
                        int index = staffNormalList.indexOf(p);
                        staffNormalList.get(index).setJob_position(t.getNewValue());
                        staffNormalList.get(index).setUpdated(true);
                    }
                }
        );
        address4.setCellValueFactory(new PropertyValueFactory<Staff, String>("address"));
        address4.setCellFactory(TextFieldTableCell.forTableColumn());
        address4.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAddress(t.getNewValue());
                        Staff p = t.getRowValue();
                        int index = staffNormalList.indexOf(p);
                        staffNormalList.get(index).setAddress(t.getNewValue());
                        staffNormalList.get(index).setUpdated(true);
                    }
                }
        );
        salary4.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("salary"));
        salary4.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        salary4.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, Integer> t) {
                        ((Staff) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSalary(t.getNewValue());
                        Staff p = t.getRowValue();
                        int index = staffNormalList.indexOf(p);
                        staffNormalList.get(index).setSalary(t.getNewValue());
                        staffNormalList.get(index).setUpdated(true);
                    }
                }
        );
        hire_date.setCellValueFactory(new PropertyValueFactory<Staff, String>("hire_date"));
        hire_date.setCellFactory(new Callback<TableColumn<Staff, String>, TableCell<Staff, String>>() {
            @Override
            public TableCell<Staff, String> call(final TableColumn<Staff, String> param) {
                final TableCell<Staff, String> cell = new TableCell<Staff, String>() {

                    private final DatePicker dt = new DatePicker();

                    {
                        dt.setOnAction(e -> {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            int index = staffTable.getSelectionModel().getSelectedIndex();
                                            try {
                                                staffNormalList.get(index).setHire_date(String.valueOf(dt.getValue()) + " 00:00:00");
                                                staffNormalList.get(index).setUpdated(true);
//                                            System.out.println(staffNormalList.get(index).getHire_date());
                                            } catch (Exception e) {

                                            }

                                        }
                                    });
                                }
                        );
                    }

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
//                            setGraphic(dt);
                        } else {
                            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            dt.setValue(LocalDate.parse(item, df));
                            setGraphic(dt);
                        }
                    }
                };
                return cell;
            }
        });
//        hire_date.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
//                        ((Staff) t.getTableView().getItems().get(t.getTablePosition().getRow())).setHire_date(t.getNewValue());
//                        Staff p = t.getRowValue();
//                        int index = staffNormalList.indexOf(p);
//                        staffNormalList.get(index).setHire_date(t.getNewValue());
//                    }
//                }
//        );
        email4.setCellValueFactory(new PropertyValueFactory<Staff, String>("email"));
        email4.setCellFactory(TextFieldTableCell.forTableColumn());
        email4.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Staff, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Staff, String> t) {
                        ((Staff) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEmail(t.getNewValue());
                        Staff p = t.getRowValue();
                        int index = staffNormalList.indexOf(p);
                        staffNormalList.get(index).setEmail(t.getNewValue());
                        staffNormalList.get(index).setUpdated(true);
                    }
                }
        );
//        if(command==0){
//            main.getNetworkUtil().write("staff");
//            main.getNetworkUtil().write(null);
//        }

    }

    void staffLoad(List<Staff> list) throws Exception {
        StaffList = FXCollections.observableArrayList();
        StaffList.addAll(list);
        staffTable.setEditable(true);
        staffTable.setItems(StaffList);
        staffNormalList = list;
//        staffNormalList.add(new Staff(-1, "Add", "Add", "Add","Add","Add","Add","Add",0,"Add"));
    }

    @FXML
    void supplierAction(ActionEvent event) throws IOException {
        command = 7;
        pageNameLabel.setText("Suppliers");
        donorTable.setVisible(false);
        adoptedAnimalsTable.setVisible(false);
        phyConditionTable.setVisible(false);
        registeredPeopleTable.setVisible(false);
        requestToDropTable.setVisible(false);
        staffTable.setVisible(false);
        suppliersTable.setVisible(true);
        transactionsTable.setVisible(false);
        vaccinationTable.setVisible(false);
        adminAnimalCard.setVisible(false);
        addRecordButton.setVisible(true);
        saveChangesButton.setVisible(true);
        addAnimalButton.setVisible(false);
        OldEmployeeTable.setVisible(false);
        supplierId.setCellValueFactory(new PropertyValueFactory<Supplier, Integer>("supplier_id"));
        supplierId.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        supplierId.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Supplier, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Supplier, Integer> t) {
                        ((Supplier) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSupplier_id(t.getNewValue());
                        Supplier p = t.getRowValue();
                        int index = supplierNormalList.indexOf(p);
                        supplierNormalList.get(index).setSupplier_id(t.getNewValue());
                    }
                }
        );
        name7.setCellValueFactory(new PropertyValueFactory<Supplier, String>("name"));
        name7.setCellFactory(TextFieldTableCell.forTableColumn());
        name7.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Supplier, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Supplier, String> t) {
                        ((Supplier) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
                        Supplier p = t.getRowValue();
                        int index = supplierNormalList.indexOf(p);
                        supplierNormalList.get(index).setName(t.getNewValue());
                    }
                }
        );
        contact_no7.setCellValueFactory(new PropertyValueFactory<Supplier, String>("contact_no"));
        contact_no7.setCellFactory(TextFieldTableCell.forTableColumn());
        contact_no7.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Supplier, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Supplier, String> t) {
                        ((Supplier) t.getTableView().getItems().get(t.getTablePosition().getRow())).setContact_no(t.getNewValue());
                        Supplier p = t.getRowValue();
                        int index = supplierNormalList.indexOf(p);
                        supplierNormalList.get(index).setContact_no(t.getNewValue());
                    }
                }
        );
        description7.setCellValueFactory(new PropertyValueFactory<Supplier, String>("description"));
        description7.setCellFactory(TextFieldTableCell.forTableColumn());
        description7.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Supplier, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Supplier, String> t) {
                        ((Supplier) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDescription(t.getNewValue());
                        Supplier p = t.getRowValue();
                        int index = supplierNormalList.indexOf(p);
                        supplierNormalList.get(index).setDescription(t.getNewValue());
                    }
                }
        );
        address7.setCellValueFactory(new PropertyValueFactory<Supplier, String>("address"));
        address7.setCellFactory(TextFieldTableCell.forTableColumn());
        address7.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Supplier, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Supplier, String> t) {
                        ((Supplier) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAddress(t.getNewValue());
                        Supplier p = t.getRowValue();
                        int index = supplierNormalList.indexOf(p);
                        supplierNormalList.get(index).setAddress(t.getNewValue());
                    }
                }
        );
//        if(command==0){
//            main.getNetworkUtil().write("supplier");
//            main.getNetworkUtil().write(null);
//        }

    }

    void supplierLoad(List<Supplier> list) throws Exception {
        SupplierList = FXCollections.observableArrayList();
        SupplierList.addAll(list);
        suppliersTable.setEditable(true);
        suppliersTable.setItems(SupplierList);
        supplierNormalList = list;
//        supplierNormalList.add(new Supplier( -1, "Add","Add","Add","Add"));
    }

    @FXML
    void transactionAction(ActionEvent event) throws IOException {
        command = 8;
        pageNameLabel.setText("Trasactions");
        donorTable.setVisible(false);
        adoptedAnimalsTable.setVisible(false);
        phyConditionTable.setVisible(false);
        registeredPeopleTable.setVisible(false);
        requestToDropTable.setVisible(false);
        staffTable.setVisible(false);
        suppliersTable.setVisible(false);
        transactionsTable.setVisible(true);
        vaccinationTable.setVisible(false);
        adminAnimalCard.setVisible(false);
        addRecordButton.setVisible(true);
        saveChangesButton.setVisible(true);
        addAnimalButton.setVisible(false);
        OldEmployeeTable.setVisible(false);
        transactionIdCol.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("trans_id"));
        transactionIdCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        transactionIdCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Transaction, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Transaction, Integer> t) {
                        ((Transaction) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTrans_id(t.getNewValue());
                        Transaction p = t.getRowValue();
                        int index = supplierNormalList.indexOf(p);
                        supplierNormalList.get(index).setSupplier_id(t.getNewValue());
                    }
                }
        );
        transDateCol.setCellValueFactory(new PropertyValueFactory<Transaction, String>("trans_date"));
        transDateCol.setCellFactory(new Callback<TableColumn<Transaction, String>, TableCell<Transaction, String>>() {
            @Override
            public TableCell<Transaction, String> call(final TableColumn<Transaction, String> param) {
                final TableCell<Transaction, String> cell = new TableCell<Transaction, String>() {

                    private DatePicker dt = new DatePicker();

                    {
                        dt.setOnAction(e -> {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            int index = transactionsTable.getSelectionModel().getSelectedIndex();
                                            try {
                                                transactionNormalList.get(index).setTrans_date(String.valueOf(dt.getValue()) + " 00:00:00");
                                            } catch (Exception e) {

                                            }
                                        }
                                    });
                                }
                        );
                    }

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(dt);
                        } else {
                            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//input date from database
                            dt.setValue(LocalDate.parse(item, df));
                            setGraphic(dt);
                        }
                    }
                };
                return cell;
            }
        });
//        transDateCol.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Transaction, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Transaction, String> t) {
//                        ((Transaction) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTrans_date(t.getNewValue());
//                        Transaction p = t.getRowValue();
//                        int index = transactionNormalList.indexOf(p);
//                        transactionNormalList.get(index).setTrans_date(t.getNewValue());
//                    }
//                }
//        );
        type8.setCellValueFactory(new PropertyValueFactory<Transaction, String>("type"));
        type8.setCellFactory(TextFieldTableCell.forTableColumn());
        type8.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Transaction, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Transaction, String> t) {
                        ((Transaction) t.getTableView().getItems().get(t.getTablePosition().getRow())).setType(t.getNewValue());
                        Transaction p = t.getRowValue();
                        int index = transactionNormalList.indexOf(p);
                        transactionNormalList.get(index).setType(t.getNewValue());
                    }
                }
        );
        person_id8.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("person_id"));
        person_id8.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        person_id8.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Transaction, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Transaction, Integer> t) {
                        ((Transaction) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPerson_id(t.getNewValue());
                        Transaction p = t.getRowValue();
                        int index = transactionNormalList.indexOf(p);
                        transactionNormalList.get(index).setPerson_id(t.getNewValue());
                    }
                }
        );
        id_type8.setCellValueFactory(new PropertyValueFactory<Transaction, String>("id_type"));
        id_type8.setCellFactory(TextFieldTableCell.forTableColumn());
        id_type8.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Transaction, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Transaction, String> t) {
                        ((Transaction) t.getTableView().getItems().get(t.getTablePosition().getRow())).setId_type(t.getNewValue());
                        Transaction p = t.getRowValue();
                        int index = transactionNormalList.indexOf(p);
                        transactionNormalList.get(index).setId_type(t.getNewValue());
                    }
                }
        );
        amount8.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("amount"));
        amount8.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        amount8.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Transaction, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Transaction, Integer> t) {
                        ((Transaction) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAmount(t.getNewValue());
                        Transaction p = t.getRowValue();
                        int index = transactionNormalList.indexOf(p);
                        transactionNormalList.get(index).setAmount(t.getNewValue());
                    }
                }
        );
//        if(command==0){
//            main.getNetworkUtil().write("transaction");
//            main.getNetworkUtil().write(null);
//        }

    }

    void transLoad(List<Transaction> list) throws Exception {
        TransactionList = FXCollections.observableArrayList();
        TransactionList.addAll(list);
        transactionsTable.setEditable(true);
        transactionsTable.setItems(TransactionList);
        transactionNormalList = list;
//        transactionNormalList.add(new Transaction(-1, "Add",0, "Add",0, "Add"));
    }

    @FXML
    void vaccineAction(ActionEvent event) throws IOException {
        command = 3;
        pageNameLabel.setText("Vaccination Status");
        donorTable.setVisible(false);
        adoptedAnimalsTable.setVisible(false);
        phyConditionTable.setVisible(false);
        registeredPeopleTable.setVisible(false);
        requestToDropTable.setVisible(false);
        staffTable.setVisible(false);
        suppliersTable.setVisible(false);
        transactionsTable.setVisible(false);
        vaccinationTable.setVisible(true);
        adminAnimalCard.setVisible(false);
        addRecordButton.setVisible(true);
        saveChangesButton.setVisible(true);
        addAnimalButton.setVisible(false);
        OldEmployeeTable.setVisible(false);
        id3.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("name"));
        id3.setCellFactory(TextFieldTableCell.forTableColumn());
        id3.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setName(t.getNewValue());
                    }
                }
        );
        DISTEMPERcol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("distemper"));
        DISTEMPERcol.setCellFactory(TextFieldTableCell.forTableColumn());
        DISTEMPERcol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDistemper(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setDistemper(t.getNewValue());
                    }
                }
        );
        HEPATITIScol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("hepatitis"));
        HEPATITIScol.setCellFactory(TextFieldTableCell.forTableColumn());
        HEPATITIScol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setHepatitis(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setHepatitis(t.getNewValue());
                    }
                }
        );
        LEPTOSPIROSIScol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("leptospirosis"));
        LEPTOSPIROSIScol.setCellFactory(TextFieldTableCell.forTableColumn());
        LEPTOSPIROSIScol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLeptospirosis(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setLeptospirosis(t.getNewValue());
                    }
                }
        );
        PARVOcol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("parvo"));
        PARVOcol.setCellFactory(TextFieldTableCell.forTableColumn());
        PARVOcol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setParvo(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setParvo(t.getNewValue());
                    }
                }
        );
        PARAINFLUENZAcol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("parainfluenza"));
        PARAINFLUENZAcol.setCellFactory(TextFieldTableCell.forTableColumn());
        PARAINFLUENZAcol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setParainfluenza(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setParainfluenza(t.getNewValue());
                    }
                }
        );
        ADENOVIRUS_TYPE_1col.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("adenovirus_type_1"));
        ADENOVIRUS_TYPE_1col.setCellFactory(TextFieldTableCell.forTableColumn());
        ADENOVIRUS_TYPE_1col.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdenovirus_type_1(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setAdenovirus_type_1(t.getNewValue());
                    }
                }
        );
        ADENOVIRUS_TYPE_2col.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("adenovirus_type_2"));
        ADENOVIRUS_TYPE_2col.setCellFactory(TextFieldTableCell.forTableColumn());
        ADENOVIRUS_TYPE_2col.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAdenovirus_type_2(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setAdenovirus_type_2(t.getNewValue());
                    }
                }
        );
        BORDETELLAcol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("bordetella"));
        BORDETELLAcol.setCellFactory(TextFieldTableCell.forTableColumn());
        BORDETELLAcol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBordetella(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setBordetella(t.getNewValue());
                    }
                }
        );
        RABIEScol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("rabies"));
        RABIEScol.setCellFactory(TextFieldTableCell.forTableColumn());
        RABIEScol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setRabies(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setRabies(t.getNewValue());
                    }
                }
        );
        FELINEHERPESVIRUScol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("felineherpesvirus"));
        FELINEHERPESVIRUScol.setCellFactory(TextFieldTableCell.forTableColumn());
        FELINEHERPESVIRUScol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFelineherpesvirus(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setFelineherpesvirus(t.getNewValue());
                    }
                }
        );
        CALICIVIRUScol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("calicivirus"));
        CALICIVIRUScol.setCellFactory(TextFieldTableCell.forTableColumn());
        CALICIVIRUScol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCalicivirus(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setCalicivirus(t.getNewValue());
                    }
                }
        );
        FELINE_LEUKEMIA_VIRUScol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("feline_leukemia_virus"));
        FELINE_LEUKEMIA_VIRUScol.setCellFactory(TextFieldTableCell.forTableColumn());
        FELINE_LEUKEMIA_VIRUScol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFeline_leukemia_virus(t.getNewValue());
                        Vaccine p = t.getRowValue();
                        int index = vaccineNormalList.indexOf(p);
                        vaccineNormalList.get(index).setFeline_leukemia_virus(t.getNewValue());
                    }
                }
        );
        LAST_VACCINATEDcol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("last_vaccinated"));
        LAST_VACCINATEDcol.setCellFactory(new Callback<TableColumn<Vaccine, String>, TableCell<Vaccine, String>>() {
            @Override
            public TableCell<Vaccine, String> call(final TableColumn<Vaccine, String> param) {
                final TableCell<Vaccine, String> cell = new TableCell<Vaccine, String>() {

                    private final DatePicker dt = new DatePicker();

                    {
                        dt.setOnAction(e -> {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            int index = vaccinationTable.getSelectionModel().getSelectedIndex();
                                            try {
                                                vaccineNormalList.get(index).setLast_vaccinated(String.valueOf(dt.getValue()));
                                            } catch (Exception e) {

                                            }
                                        }
                                    });
                                }
                        );
                    }

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(dt);
                        } else {
//                            SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy");
//                            DateTimeFormatter formatter =new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd-MMM-yyyy").toFormatter(Locale.ENGLISH);
                            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//                            dt.setValue(LocalDate.parse(item,df));
//                            dt.setValue(LocalDate.parse(getItem()));
                            dt.setValue(LocalDate.parse(item, df));
                            setGraphic(dt);
                        }
                    }
                };
                return cell;
            }
        });
//        LAST_VACCINATEDcol.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
//                        Callback<TableColumn<Vaccine, String>, TableCell<Vaccine, String>> cellFactory = new Callback<TableColumn<Vaccine, String>, TableCell<Vaccine, String>>() {
//                            @Override
//                            public TableCell<Vaccine, String> call(final TableColumn<Vaccine, String> param) {
//                                final TableCell<Vaccine, String> cell = new TableCell<Vaccine, String>() {
//
//                                    private final DatePicker dt = new DatePicker();
//
//                                    {
//                                        dt.setOnAction(e -> {
//                                                    Platform.runLater(new Runnable() {
//                                                        @Override
//                                                        public void run() {
//                                                            System.out.println("date");
//                                                            ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLast_vaccinated(t.getNewValue());
//                                                            Vaccine p = t.getRowValue();
//                                                            int index = vaccineNormalList.indexOf(p);
//                                                            vaccineNormalList.get(index).setLast_vaccinated(t.getNewValue());
//
//                                                        }
//                                                    });
//
//                                                }
//                                        );
//                                    }
//
//                                    @Override
//                                    public void updateItem(String item, boolean empty) {
//                                        super.updateItem(item, empty);
//                                        if (empty) {
//                                            setGraphic(null);
//                                        } else {
//                                            setGraphic(dt);
//                                        }
//                                    }
//                                };
//                                return cell;
//                            }
//                        };
////                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLast_vaccinated(t.getNewValue());
////                        Vaccine p = t.getRowValue();
////                        int index = vaccineNormalList.indexOf(p);
////                        vaccineNormalList.get(index).setLast_vaccinated(t.getNewValue());
//                    }
//                }
//        );
        NEXT_VACCINATION_DATEcol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("next_vaccination_date"));
        NEXT_VACCINATION_DATEcol.setCellFactory(new Callback<TableColumn<Vaccine, String>, TableCell<Vaccine, String>>() {
            @Override
            public TableCell<Vaccine, String> call(final TableColumn<Vaccine, String> param) {
                final TableCell<Vaccine, String> cell = new TableCell<Vaccine, String>() {

                    private final DatePicker dt = new DatePicker();

                    {
                        dt.setOnAction(e -> {
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            int index = vaccinationTable.getSelectionModel().getSelectedIndex();
                                            try {
                                                vaccineNormalList.get(index).setLast_vaccinated(String.valueOf(dt.getValue()));
                                            } catch (Exception e) {

                                            }
                                        }
                                    });
                                }
                        );
                    }

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(dt);
                        } else {
//                            SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy");
//                            DateTimeFormatter formatter =new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd-MMM-yyyy").toFormatter(Locale.ENGLISH);
                            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//                            dt.setValue(LocalDate.parse(item,df));
//                            dt.setValue(LocalDate.parse(getItem()));
                            if (item != null) {
                                dt.setValue(LocalDate.parse(item, df));
                                setGraphic(dt);
                            }

                        }
                    }
                };
                return cell;
            }
        });
//        NEXT_VACCINATION_DATEcol.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<Vaccine, String>>() {
//                    @Override
//                    public void handle(TableColumn.CellEditEvent<Vaccine, String> t) {
//                        ((Vaccine) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNext_vaccination_date(t.getNewValue());
//                        Vaccine p = t.getRowValue();
//                        int index = vaccineNormalList.indexOf(p);
//                        vaccineNormalList.get(index).setNext_vaccination_date(t.getNewValue());
//                    }
//                }
//        );
//        if(command==0){
//            main.getNetworkUtil().write("vaccine");
//            main.getNetworkUtil().write(null);
//        }

    }

    void vaccineLoad(List<Vaccine> list) throws Exception {
        VaccineList = FXCollections.observableArrayList();
        VaccineList.addAll(list);
        vaccinationTable.setEditable(true);
        vaccinationTable.setItems(VaccineList);
        vaccineNormalList = list;
//        vaccineNormalList.add(new Vaccine(-1, "Add", "Add", "Add","Add","Add","Add","Add","Add","Add","Add","Add","Add","Add","Add"));
    }

    void setAnimalCard(CombinedAnimal animal) {
//        allAnimalsAnchor.setVisible(false);
        this.animal = animal;
        adminAnimalCard.setVisible(true);
        addRecordButton.setVisible(false);
        saveChangesButton.setVisible(false);
        refreshButton.setVisible(false);
        addAnimalButton.setVisible(false);
        nameL.setText(animal.getName());
        breedL.setText(animal.getBreed());
        genderL.setText(animal.getGender());
        sizeL.setText(animal.getAnimal_size());
        stayingSinceL.setText(animal.getStaying_since());
        shelteredTimeAgeL.setText(animal.getSheltered_time_age());
        houseTrainedL.setText(animal.getHousetrained());
        idLabel.setText(String.valueOf(animal.getId()));
        typelabel.setText(animal.getType());
//        roomL.setText(String.valueOf(animal.getRoom_no()));
        injuryL.setText(animal.getInjury_status());
        diseaseL.setText(animal.getDisease());
        therapyL.setText(animal.getTherapy());
        lastVacDateL.setText(animal.getLast_vaccinated());
        nextVacL.setText(animal.getNext_vaccination_date());
        distemperL.setText(animal.getDistemper());
        hepatiisL.setText(animal.getHepatitis());
        LeptospirosisL.setText(animal.getLeptospirosis());
        parvoL.setText(animal.getParvo());
        ParainfluenzaL.setText(animal.getParainfluenza());
        Adenovirus_type_1L.setText(animal.getAdenovirus_type_1());
        BordetellaL.setText(animal.getBordetella());
        Feline_Leukemia_VirusL.setText(animal.getFeline_leukemia_virus());
        RabiesL.setText(animal.getRabies());
        FelineherpevirusL.setText(animal.getFelineherpesvirus());
        CalicivirusL.setText(animal.getCalicivirus());
        Adenovirus_type_2L.setText(animal.getAdenovirus_type_2());
        try {
            String[] token = animal.getPicture().split("\\.");
            Integer i = Integer.parseInt(token[0]);
            GeneralImage.setImage(new Image("src/server/Images/" + animal.getPicture()));
        } catch (NumberFormatException e) {
            try {
                GeneralImage.setImage(new Image(animal.getPicture()));
            } catch (IllegalArgumentException ee) {
                GeneralImage.setImage(new Image("src/server/Images/A1transparent.png"));
            }
        } catch (IllegalArgumentException e) {
            GeneralImage.setImage(new Image("src/server/Images/A1transparent.png"));
        }
    }

    @FXML
    void backToWhereItcamePage(MouseEvent event) {
        adminAnimalCard.setVisible(false);
        addRecordButton.setVisible(false);
        saveChangesButton.setVisible(false);
        refreshButton.setVisible(true);
        addAnimalButton.setVisible(true);
    }

    public void backToAnimalPage(MouseEvent mouseEvent) {
        addRecordButton.setVisible(false);
        addanimalScrollPane.setVisible(false);
        addAnimalButton.setVisible(true);
        donorTable.setVisible(false);
        saveChangesButton.setVisible(true);
        adoptedAnimalsTable.setVisible(false);
        phyConditionTable.setVisible(false);
        registeredPeopleTable.setVisible(false);
        requestToDropTable.setVisible(false);
        staffTable.setVisible(false);
        suppliersTable.setVisible(false);
        transactionsTable.setVisible(false);
        vaccinationTable.setVisible(false);
        adminAnimalCard.setVisible(false);
        addRecordButton.setVisible(false);
        saveChangesButton.setVisible(false);
        OldEmployeeTable.setVisible(false);
        scroll.setVisible(true);

    }

//    public void addAction(ActionEvent event) {
//
//
//        if (nameField.getText().equals("") || animalIdField.getText().equals("") || (!rcat.isSelected() && !rdog.isSelected()) || breedField.getText().equals("") || (!rM.isSelected() && !rF.isSelected()) || shortDesField.getText().equals("") || healthStatusField.getText().equals("") || shelterdAgeField.getText().equals("") || (!rS.isSelected() && !rM1.isSelected() && !rL.isSelected()) || (!yesButton.isSelected() && !noButton.isSelected()) || stayingSinceField.getValue().equals("")) {
//            main.showAlert("Please fill up all the necessary information");
//        } else {
//
//            String id = animalIdField.getText();
//            String name = nameField.getText();
//            String type = null;
//            if (rcat.isSelected()) type = rcat.getText();
//            else
//                type = rdog.getText();
//            String breed = breedField.getText();
//            String gen = null;
//            if (rM.isSelected()) gen = rM.getText();
//            else if (rF.isSelected()) gen = rF.getText();
//            String des = shortDesField.getText();
//            String hel = healthStatusField.getText();
//            String stay = String.valueOf(stayingSinceField.getValue());
//            String shel = shelterdAgeField.getText();
//            String size;
//            if (rS.isSelected()) size = rS.getText();
//            else if (rM1.isSelected()) size = rM1.getText();
//            else
//                size = rL.getText();
//
//            String house = null;
//            if (yesButton.isSelected()) house = yesButton.getText();
//            else
//                house = noButton.getText();
//
//            try {
//                main.getNetworkUtil().write(id + "!" + name + "!" + type + "!" + breed + "!" + gen + "!" + des + "!" + hel + "!" + stayingSinceField.getValue() + "!" + shel + "!" + size + "!" + house);
//                main.getNetworkUtil().write(null);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Addition in Process");
//            alert.setHeaderText("Successfully added an animal");
//            alert.setContentText("A new animal is added to HeartyPaws");
//            alert.showAndWait();
//
//            addanimalScrollPane.setVisible(false);
//            donorTable.setVisible(false);
//            adoptedAnimalsTable.setVisible(false);
//            phyConditionTable.setVisible(false);
//            registeredPeopleTable.setVisible(false);
//            requestToDropTable.setVisible(false);
//            staffTable.setVisible(false);
//            suppliersTable.setVisible(false);
//            transactionsTable.setVisible(false);
//            vaccinationTable.setVisible(false);
//            adminAnimalCard.setVisible(false);
//            addRecordButton.setVisible(false);
//            saveChangesButton.setVisible(false);
//            OldEmployeeTable.setVisible(false);
//            scroll.setVisible(true);
//        }
//    }

    public void addAction(ActionEvent event) {


        if (nameField.getText().equals("") || (!rcat.isSelected() && !rdog.isSelected()) || breedField.getText().equals("") || (!rM.isSelected() && !rF.isSelected()) || shortDesField.getText().equals("") || healthStatusField.getText().equals("") || shelterdAgeField.getText().equals("") || (!rS.isSelected() && !rM1.isSelected() && !rL.isSelected()) || (!yesButton.isSelected() && !noButton.isSelected()) || stayingSinceField.getValue().equals("")) {
            main.showAlert("Please fill up all the necessary information");
        } else {

//            String id = animalIdField.getText();
            String name = nameField.getText();
            String type = null;
            if (rcat.isSelected()) type = rcat.getText();
            else
                type = rdog.getText();
            String breed = breedField.getText();
            String gen = null;
            if (rM.isSelected()) gen = rM.getText();
            else if (rF.isSelected()) gen = rF.getText();
            String des = shortDesField.getText();
            String hel = healthStatusField.getText();
            String stay = String.valueOf(stayingSinceField.getValue());
            String shel = shelterdAgeField.getText();
            String size;
            if (rS.isSelected()) size = rS.getText();
            else if (rM1.isSelected()) size = rM1.getText();
            else
                size = rL.getText();
            String house = null;
            if (yesButton.isSelected()) house = yesButton.getText();
            else
                house = noButton.getText();
            try {
                main.getNetworkUtil().write(name + "!" + type + "!" + breed + "!" + gen + "!" + des + "!" + hel + "!" + stayingSinceField.getValue() + "!" + shel + "!" + size + "!" + house);
                main.getNetworkUtil().write(null);
            } catch (IOException e) {
                e.printStackTrace();
            }


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Addition in Process");
            alert.setHeaderText("Successfully added an animal");
            alert.setContentText("A new animal is added to HeartyPaws");
            alert.showAndWait();
            addanimalScrollPane.setVisible(false);
            donorTable.setVisible(false);
            adoptedAnimalsTable.setVisible(false);
            phyConditionTable.setVisible(false);
            registeredPeopleTable.setVisible(false);
            requestToDropTable.setVisible(false);
            staffTable.setVisible(false);
            suppliersTable.setVisible(false);
            transactionsTable.setVisible(false);
            vaccinationTable.setVisible(false);
            adminAnimalCard.setVisible(false);
            addRecordButton.setVisible(false);
            saveChangesButton.setVisible(false);
            OldEmployeeTable.setVisible(false);
            scroll.setVisible(true);
            addAnimalButton.setVisible(true);

        }
    }
    @FXML
    private AnchorPane addanimalScrollPane;
    @FXML
    private Button addAnimalButton;
    @FXML
    private Button addButton;
    @FXML
    private AnchorPane AdditionalInfoPane;


    @FXML
    private TextField nameField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField breedField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField shortDesField;

    @FXML
    private TextField healthStatusField;

    @FXML
    private TextField shelterdAgeField;

    @FXML
    private TextField sizeField;

    @FXML
    private TextField houseTrainedField;

    @FXML
    private DatePicker stayingSinceField;
    @FXML
    private TableView<OldStaff> OldEmployeeTable;

    @FXML
    private TableColumn<OldStaff, Integer> employeIdCol41;

    @FXML
    private TableColumn<OldStaff, String> namecol41;

    @FXML
    private TableColumn<OldStaff, String> CONTACT_NOcol41;

    @FXML
    private TableColumn<OldStaff, String> dob41;

    @FXML
    private TableColumn<OldStaff, String> gender41;

    @FXML
    private TableColumn<OldStaff, String> jobPosition41;

    @FXML
    private TableColumn<OldStaff, String> address41;

    @FXML
    private TableColumn<OldStaff, Integer> salary41;

    @FXML
    private TableColumn<OldStaff, String> hire_date1;

    @FXML
    private TableColumn<OldStaff, String> email41;

    @FXML
    private TableColumn<OldStaff, String> last_wok;
    @FXML
    private Button oldEmployeeButton;
    @FXML
    private Button FIREBUTTON;

    @FXML
    void FireButtonAction(ActionEvent event) {
        int index=staffTable.getSelectionModel().getSelectedIndex();
        if(index>=0)
        {
            try {
                main.getNetworkUtil().write("staffDelete");
                main.getNetworkUtil().write(staffNormalList.get(index).getEmployee_id());//
                System.out.println(staffNormalList.get(index));

                staffTable.getItems().remove(staffNormalList.get(index));
                staffNormalList.remove(staffNormalList.get(index));
                System.out.println(staffNormalList.get(index));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    @FXML
    void oldEmployeeAction(ActionEvent event) {


        command = 12;
        pageNameLabel.setText("Old Employee History");
        donorTable.setVisible(false);
        adoptedAnimalsTable.setVisible(false);
        phyConditionTable.setVisible(false);
        registeredPeopleTable.setVisible(false);
        requestToDropTable.setVisible(false);
        staffTable.setVisible(false);
        suppliersTable.setVisible(false);
        transactionsTable.setVisible(false);
        vaccinationTable.setVisible(false);
        adminAnimalCard.setVisible(false);
        addRecordButton.setVisible(false);
        saveChangesButton.setVisible(false);
        addAnimalButton.setVisible(false);
        OldEmployeeTable.setVisible(true);

        employeIdCol41.setCellValueFactory(new PropertyValueFactory <OldStaff, Integer>("employee_id"));
        employeIdCol41.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        namecol41.setCellValueFactory(new PropertyValueFactory <OldStaff, String>("name"));
        //namecol41.setCellFactory(TextFieldTableCell.forTableColumn());
        CONTACT_NOcol41.setCellValueFactory(new PropertyValueFactory <OldStaff, String>("contact_no"));
        //CONTACT_NOcol41.setCellFactory(TextFieldTableCell.forTableColumn());
        dob41.setCellValueFactory(new PropertyValueFactory <OldStaff, String>("Date_of_birth"));
        gender41.setCellValueFactory(new PropertyValueFactory <OldStaff, String>("gender"));
        //gender41.setCellFactory(TextFieldTableCell.forTableColumn());
        jobPosition41.setCellValueFactory(new PropertyValueFactory <OldStaff, String>("job_position"));
        //jobPosition41.setCellFactory(TextFieldTableCell.forTableColumn());
        address41.setCellValueFactory(new PropertyValueFactory <OldStaff, String>("address"));
        //address41.setCellFactory(TextFieldTableCell.forTableColumn());
        salary41.setCellValueFactory(new PropertyValueFactory <OldStaff, Integer>("salary"));
        //salary41.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        email41.setCellValueFactory(new PropertyValueFactory <OldStaff, String>("email"));
        // email41.setCellFactory(TextFieldTableCell.forTableColumn());
        hire_date1.setCellValueFactory(new PropertyValueFactory <OldStaff, String>("hire_date"));
        last_wok.setCellValueFactory(new PropertyValueFactory <OldStaff, String>("last_working_date"));
    }


    void oldstaffLoad(List<OldStaff> list) throws Exception {
        OldStaffList = FXCollections.observableArrayList();
        OldStaffList.addAll(list);
        OldEmployeeTable.setEditable(true);
        OldEmployeeTable.setItems(OldStaffList);
        oldStaffNormalList = list;
//        staffNormalList.add(new Staff(-1, "Add", "Add", "Add","Add","Add","Add","Add",0,"Add"));
    }

    @FXML
    private RadioButton rcat;

    @FXML
    private ToggleGroup t1;

    @FXML
    private RadioButton rdog;

    @FXML
    private RadioButton rM;

    @FXML
    private ToggleGroup t2;

    @FXML
    private RadioButton rF;

    @FXML
    private RadioButton rS;

    @FXML
    private ToggleGroup t3;

    @FXML
    private RadioButton rM1;

    @FXML
    private RadioButton rL;

    @FXML
    private RadioButton yesButton;

    @FXML
    private ToggleGroup t4;

    @FXML
    private RadioButton noButton;
    @FXML
    private TextField nameField1;

    @FXML
    private TextField breedField1;

    @FXML
    private RadioButton genMButton;

    @FXML
    private ToggleGroup tt1;

    @FXML
    private RadioButton genFButton;

    @FXML
    private RadioButton sizeSButton;

    @FXML
    private ToggleGroup tt2;

    @FXML
    private RadioButton sizeMButton;

    @FXML
    private RadioButton sizeLbutton;

    @FXML
    private RadioButton rY;
    @FXML
    private RadioButton rN;

    @FXML
    private ToggleGroup tt3;


    @FXML
    private TextField shortDesField1;

    @FXML
    private TextField shelterdAgeField1;


    @FXML
    private Button addButton1;

    @FXML
    private Text back1;

    public void addAction1(ActionEvent event) {
        if (nameField1.getText().equals("") || breedField1.getText().equals("") || (!genMButton.isSelected() && !genFButton.isSelected()) || shortDesField1.getText().equals("") || shelterdAgeField1.getText().equals("") || (!sizeLbutton.isSelected() && !sizeMButton.isSelected() && !sizeSButton.isSelected()) || (!rY.isSelected() && !rN.isSelected())) {
            main.showAlert("Please fill up all the necessary information");
        } else {

            String name = nameField1.getText();
            String type = requestNormalList.get(RequestToDropindex).getAnimal_type();
            String breed = breedField1.getText();
            String gen = null;
            if (genMButton.isSelected()) gen = genMButton.getText();
            else if (genFButton.isSelected()) gen = genFButton.getText();
            String des = shortDesField1.getText();
            String hel = requestNormalList.get(RequestToDropindex).getPhysical_condition();
            String shel = shelterdAgeField1.getText();
            String size;
            if (sizeSButton.isSelected()) size = sizeSButton.getText();
            else if (sizeMButton.isSelected()) size = sizeMButton.getText();
            else
                size = sizeLbutton.getText();
            String house = null;
            if (rY.isSelected()) house = rY.getText();
            else
                house = rN.getText();
            try {
                main.getNetworkUtil().write(name + "#" + type + "#" + breed + "#" + gen + "#" + des + "#" + hel + "#" + shel + "#" + size + "#" + house + "#" + requestNormalList.get(RequestToDropindex).getSerial_no());
                main.getNetworkUtil().write(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Addition in Process");
            alert.setHeaderText("Successfully added an animal");
            alert.setContentText("A new animal is added to HeartyPaws");
            alert.showAndWait();
            AdditionalInfoPane.setVisible(false);

            requestToDropTable.getItems().remove(requestNormalList.get(RequestToDropindex));
            requestNormalList.remove(requestNormalList.get(RequestToDropindex));
//            addanimalScrollPane.setVisible(false);
//            donorTable.setVisible(false);
//            adoptedAnimalsTable.setVisible(false);
//            phyConditionTable.setVisible(false);
//            registeredPeopleTable.setVisible(false);
//            requestToDropTable.setVisible(false);
//            staffTable.setVisible(false);
//            suppliersTable.setVisible(false);
//            transactionsTable.setVisible(false);
//            vaccinationTable.setVisible(false);
//            adminAnimalCard.setVisible(false);
//            addRecordButton.setVisible(false);
//            saveChangesButton.setVisible(false);
//            scroll.setVisible(true);
        }
    }

    @FXML
    void showAddAnimalForm(ActionEvent event) {

        addanimalScrollPane.setVisible(true);
        addAnimalButton.setVisible(false);

    }

    @FXML
    private Button changePicButton;
    @FXML
//    void changePicAction(ActionEvent event) throws IOException {
//        //animal.
//        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
//        fileChooser=new FileChooser();
//        fileChooser.setTitle("open image");
//        this.filePath=fileChooser.showOpenDialog(stage);
//        //BufferedImage bufferedImage= ImageIO.read(filePath);
//        BufferedImage bufferedImage=ImageIO.read(filePath);
//        main.getNetworkUtil().write(filePath);
//        main.getNetworkUtil().write("picturechange "+animal.getId());
//        Image image= SwingFXUtils.toFXImage(bufferedImage,null);
//
//    }
    private FileChooser fileChooser;
    private File filePath;
}
