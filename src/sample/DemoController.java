package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import util.Animal;
import util.CombinedAnimal;

import java.io.IOException;

public class DemoController {
    @FXML
    private ImageView image;

    @FXML
    private Label name;

    @FXML
    private Label stay;
    @FXML
    private Label status;
    @FXML
    private Label room;

    private Main main;
    private CombinedAnimal animal;

    void setMain(Main main) {
        this.main = main;
    }

    public Image getPhoto() {
        return photo;
    }

    private Image photo;

    public void setImage(Image im) {
        photo = im;
    }

    public void setAnimal(CombinedAnimal animal) {   //     C:\Users\HP\Pictures\Saved Pictures\df.png
        this.animal = animal;
        name.setText(animal.getName());
        String[] tokens = animal.getStaying_since().split(" ");
        stay.setText("Staynig since: " + tokens[0]);
        status.setText(animal.getStatus());
        // room.setText("Room no: "+String.valueOf(animal.getRoom_no()));
        try {
//            String pic=animal.getPicture();
//            pic=pic.replace("\\","\\\\");
//            image.setImage(new Image(pic));
//            image=image.rep
            //image.se
//         image.setImage(new Image("src/server/Images/"+animal.getPicture()));
            //image.setImage(new Image("file:/C:/Users/HP/Pictures/Screenshots/+ve%20deviation.png"));
            String[] token = animal.getPicture().split("\\.");
            Integer i = Integer.parseInt(token[0]);
            image.setImage(new Image("src/server/Images/" + animal.getPicture()));
        } catch (NumberFormatException e) {
            try {
                image.setImage(new Image(animal.getPicture()));
            } catch (IllegalArgumentException ee) {
                image.setImage(new Image("src/server/Images/A1transparent.png"));
            }
        } catch (IllegalArgumentException e) {
//            image.setImage(new Image(animal.getPicture()));
            image.setImage(new Image("src/server/Images/A1transparent.png"));
            //image.setImage(new Image("HP/Pictures/Saved Pictures/df.png"));
        }
//        finally {
////            image.setImage(new Image("src/server/Images/A1transparent.png"));
//        }
//        image.setImage(new Image("src/server/Images/"+animal.getPicture()));
    }

    @FXML
    void showCard(MouseEvent event) throws IOException {
        main.alcontroller.setAnimalCard(animal);
    }
}
