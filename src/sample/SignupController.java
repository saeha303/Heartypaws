package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {
    private Main main;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField nameField;

    @FXML
    private TextField nameField1;

    @FXML
    private TextField nameField2;

    @FXML
    private PasswordField nameField3;

    @FXML
    private PasswordField nameField4;

    @FXML
    private TextField occupationField;

    @FXML
    private TextField other_pet_field;

    @FXML
    private TextField addressField;

    @FXML
    private TextField contactNoField;


    @FXML
    private Text login;

    @FXML
    private Button resetButton;

    @FXML
    private Button signup;

    @FXML
    private ImageView image;

    @FXML
    private ImageView minimize;

    @FXML
    private Label name1;

    @FXML
    private Label name2;
    @FXML
    private RadioButton yr;

    @FXML
    private ToggleGroup tgr1;

    @FXML
    private RadioButton nr;


    @FXML
    void exitAction(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void loginAction(MouseEvent event){
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
    }

    @FXML
    void minimizeAction(MouseEvent event) {
        Stage stage=(Stage) anchorPane.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void resetAction(ActionEvent event) {
        nameField.setText(null);//name
        nameField1.setText(null);//user name
        nameField2.setText(null);//email
        nameField3.setText(null);//pass
        nameField4.setText(null);//con_pass
        occupationField.setText(null);
        contactNoField.setText(null);


        addressField.setText(null);
    }

    public void init() {
        Image img = new Image(Main.class.getResourceAsStream("Images/exit.png"));
        image.setImage(img);
        Image img2=new Image(Main.class.getResourceAsStream("Images/Remove.png"));
        minimize.setImage(img2);
    }
    void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void signUpAction(ActionEvent event) throws IOException {

        String name=nameField.getText();
        String username=nameField1.getText();
        String email=nameField2.getText();
        String pass1=nameField3.getText();
        String pass2=nameField4.getText();
        String ad =addressField.getText();
        String con=contactNoField.getText();
        String pet=null;
        if(yr.isSelected())
            pet=yr.getText();
        else pet= nr.getText();

        String occ=occupationField.getText();
        if(nameField.getText().equals("")||nameField1.getText().equals("")||nameField2.getText().equals("")||nameField3.getText().equals("")||nameField4.getText().equals("")||occupationField.getText().equals("")||addressField.getText().equals("")||contactNoField.getText().equals("")||(!yr.isSelected()&&!nr.isSelected())){
            main.showAlert("Please fill up all the necessary information");
        }else if(pass1.equals(pass2)){
            main.getNetworkUtil().write(username+"<"+pass1+"<"+name+"<"+email+"<"+occ+"<"+pet+"<"+con+"<"+ad);
            main.getNetworkUtil().write(null);
        }else {
            main.showAlert("Incorrect password");
        }
    }

}
