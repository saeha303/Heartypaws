package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import util.Animal;

import java.io.IOException;

public class DemoUserController {
    private Main main;
    @FXML
    private ImageView image;

    @FXML
    private Label desc;
    @FXML
    private Label name;
    private Animal animal;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
        name.setText(animal.getName());
        desc.setText(animal.getShort_description());
        try{
            image.setImage(new Image("src/server/Images/"+animal.getPicture()));
        }catch (IllegalArgumentException e){
            image.setImage(new Image("src/server/Images/A1transparent.png"));
        }    }

    @FXML
    void showCard(MouseEvent event) throws IOException {
        main.ulhcontroller.setAnimalCard(animal);
    }

}