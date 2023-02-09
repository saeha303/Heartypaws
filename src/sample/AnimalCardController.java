
package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.Animal;

import java.io.IOException;

public class AnimalCardController {
    private Main main;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView eximg;

    @FXML
    private ImageView min;

    @FXML
    private Label backToWhereItcameButton;

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

    public void setMain(Main main){
        this.main=main;
    }


    public void init(Animal animal){
        nameL.setText(animal.getName());
        breedL.setText(animal.getBreed());
        genderL.setText(animal.getGender());
        sizeL.setText(animal.getAnimal_size());
        stayingSinceL.setText(animal.getStaying_since());
        shelteredTimeAgeL.setText(animal.getSheltered_time_age());
        houseTrainedL.setText(animal.getHousetrained());
        healthStatusL.setText(animal.getHealth_status());
        descriptionLabel.setText(animal.getShort_description());
//        anchorPane.toFront();
    }
}
