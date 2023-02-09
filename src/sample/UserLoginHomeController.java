package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import util.Animal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserLoginHomeController {
    private Main main;
    private Animal animal;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label userName;

    @FXML
    private Button homeButton;

    @FXML
    private Button AllAnimalsButton;

    @FXML
    private Button aboutUsButton;

    @FXML
    private Button contactUsButton;

    @FXML
    private Button logOut;

    @FXML
    private AnchorPane homeAnchor;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView catimg;

    @FXML
    private ImageView dogimg;

    @FXML
    private Button CatButton;

    @FXML
    private Button DogButton;

    @FXML
    private AnchorPane allAnimalsAnchor;

    @FXML
    private Label labelForScrollPurpose;

    @FXML
    private GridPane grid;

    @FXML
    private Label backToWhereItcameButton2;

    @FXML
    private AnchorPane aboutUs;

    @FXML
    private AnchorPane contactUs;

    @FXML
    private AnchorPane animalCard;

    @FXML
    private Label nameL;

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
    private Button adoptMeButton;

    @FXML
    private Label healthStatusL;

    @FXML
    private Text descriptionLabel;

    @FXML
    private ImageView i34;

    @FXML
    private Label backToWhereItcameButton;

    @FXML
    private AnchorPane ApplicationForm;

    @FXML
    private Label backToWhereItcameButton1;

    @FXML
    private TextField userNameText;

    @FXML
    private TextField occupationText;

    @FXML
    private TextField applierForText;

    @FXML
    private TextField otherPetText;

    @FXML
    private TextField contactNoText;

    @FXML
    private TextField addressText;
    @FXML
    private Button submitButton;

    @FXML
    private Pane emPane;

    @FXML
    private ImageView eximg;

    @FXML
    private ImageView min;

    List<Animal> animalList=new ArrayList<>();
    private int latestsize;
    void setMain(Main main) {
        this.main = main;
        userName.setText(main.clientName);
    }
    @FXML
    void exitAction(MouseEvent event) {
        try {
            main.getNetworkUtil().write("end session");//"end session"
            main.getNetworkUtil().write(main.clientName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    @FXML
    void logOutAction(MouseEvent event) {
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
    void minimizeAction(MouseEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void showHome(MouseEvent event) {
        contactUs.setVisible(false);
        allAnimalsAnchor.setVisible(false);
        aboutUs.setVisible(false);
        homeAnchor.setVisible(true);
        animalCard.setVisible(false);
        ApplicationForm.setVisible(false);
    }

    @FXML
    void showCats(ActionEvent event) throws IOException {
        backToWhereItcameButton2.setVisible(true);
        contactUs.setVisible(false);
        allAnimalsAnchor.setVisible(true);
        aboutUs.setVisible(false);
//        homeAnchor.setVisible(false);
        animalCard.setVisible(false);
        ApplicationForm.setVisible(false);
        labelForScrollPurpose.setText("Cats");
        grid.getChildren().clear();
        main.getNetworkUtil().write("cat");
        main.getNetworkUtil().write(null);
    }
    void residual(List<Animal> list) {
        animalList=list;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                try {
//                    if (animalList.size() < latestsize) {
                        grid.getChildren().clear();
//                    }
                    int column = 0;
                    int row = 1;
                    for (int i = 0; i < animalList.size(); i++) {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("demoUser.fxml"));
                        AnchorPane anchor = loader.load();
                        DemoUserController controller = loader.getController();
                        controller.setAnimal(animalList.get(i));
                        controller.setMain(main);
                        if (column == 4) {
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
    void showDogs(ActionEvent event) throws IOException {
        backToWhereItcameButton2.setVisible(true);
        contactUs.setVisible(false);
        allAnimalsAnchor.setVisible(true);
        aboutUs.setVisible(false);
//        homeAnchor.setVisible(false);
        animalCard.setVisible(false);
        ApplicationForm.setVisible(false);
        labelForScrollPurpose.setText("Dogs");
        grid.getChildren().clear();
        main.getNetworkUtil().write("dog");
        main.getNetworkUtil().write(null);
    }

    @FXML
    void showAnimals(MouseEvent event) throws IOException {
        backToWhereItcameButton2.setVisible(false);
        contactUs.setVisible(false);
        allAnimalsAnchor.setVisible(true);
        aboutUs.setVisible(false);
        homeAnchor.setVisible(false);
        animalCard.setVisible(false);
        ApplicationForm.setVisible(false);
        labelForScrollPurpose.setText("All animals");
        grid.getChildren().clear();
        main.getNetworkUtil().write("updated animal list for user");
        main.getNetworkUtil().write(null);
    }

    @FXML
    void showAboutUs(MouseEvent event) {
        contactUs.setVisible(false);
        allAnimalsAnchor.setVisible(false);
        aboutUs.setVisible(true);
        homeAnchor.setVisible(false);
        animalCard.setVisible(false);
        ApplicationForm.setVisible(false);
    }

    @FXML
    void showContactUs(MouseEvent event) {
        contactUs.setVisible(true);
        allAnimalsAnchor.setVisible(false);
        aboutUs.setVisible(false);
        homeAnchor.setVisible(false);
        animalCard.setVisible(false);
        ApplicationForm.setVisible(false);
    }
    @FXML
    void backToWhereItcamePage(MouseEvent event) {
        animalCard.setVisible(false);
    }
    @FXML
    void backToWhereItcamePage1(MouseEvent event) {
        ApplicationForm.setVisible(false);
    }
    @FXML
    void backToWhereItcamePage2(MouseEvent event) {
        allAnimalsAnchor.setVisible(false);
    }
    @FXML
    void showRequest(ActionEvent event) {
        contactUs.setVisible(false);
        allAnimalsAnchor.setVisible(false);
        aboutUs.setVisible(false);
        homeAnchor.setVisible(false);
        animalCard.setVisible(false);
        ApplicationForm.setVisible(false);
    }
    @FXML
    void adoptMeAction(ActionEvent event) throws IOException {
        String name=main.clientName;
        String id= String.valueOf(animal.getId());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Adoption in progress");
        alert.setHeaderText("Congratulations");
        alert.setContentText("Your request to adopt this animal is in process");
        alert.showAndWait();
        main.getNetworkUtil().write(name+"_"+id);
        main.getNetworkUtil().write(null);
        main.showAfterUserLoginPage();
        //ApplicationForm.setVisible(true);
//        userNameText.setText(main.clientName);
//        applierForText.setText(animal.getName());
    }
    @FXML
    void submitAction(ActionEvent event) throws IOException {//adopt me,_ separator
//        Date today=new Date();
//        SimpleDateFormat ft=new SimpleDateFormat("DD-MMM-YYYY");
//        System.out.println(ft.format(today));
        main.getNetworkUtil().write(userNameText.getText()+"_"+occupationText.getText()+"_"+animal.getId()+"_"+otherPetText.getText()+"_"+contactNoText.getText()+"_"+addressText.getText());
        main.getNetworkUtil().write(null);
        userNameText.setText(null);
        occupationText.setText(null);
        applierForText.setText(null);
        otherPetText.setText(null);
        contactNoText.setText(null);
        addressText.setText(null);
    }

    void setAnimalCard(Animal animal)
    {
//        allAnimalsAnchor.setVisible(false);
        this.animal=animal;
        animalCard.setVisible(true);
        nameL.setText(animal.getName());
        breedL.setText(animal.getBreed());
        genderL.setText(animal.getGender());
        sizeL.setText(animal.getAnimal_size());
        stayingSinceL.setText(animal.getStaying_since());
        shelteredTimeAgeL.setText(animal.getSheltered_time_age());
        houseTrainedL.setText(animal.getHousetrained());
        healthStatusL.setText(animal.getHealth_status());
        descriptionLabel.setText(animal.getShort_description());
        try{
            i34.setImage(new Image("src/server/Images/"+animal.getPicture()));
        }catch (IllegalArgumentException e){
            i34.setImage(new Image("src/server/Images/A1transparent.png"));
        }
    }

    @FXML
    private ImageView rfrshImage;
    @FXML
    void refreshAction(MouseEvent event) {

        loadFirst2();

    }

    private void loadFirst2() {
        try {
            main.getNetworkUtil().write("updated animal list for user");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            main.getNetworkUtil().write(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
