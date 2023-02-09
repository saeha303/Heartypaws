package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginHPcontroller {
    private Main main;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Pane loginPane;

    @FXML
    private TextField nameField;

    @FXML
    private Button login;

    @FXML
    private Button resetButton;

    @FXML
    private PasswordField passField;

    @FXML
    private Text signUp;

    @FXML
    private ImageView image;

    @FXML
    private ImageView minimize;

    @FXML
    private Label name1;

    @FXML
    private Label name2;

    @FXML
    private ScrollPane FormPane;

    @FXML
    private TextField NameText;

    @FXML
    private TextField animalTypeText;

    @FXML
    private DatePicker RescueDateText;

    @FXML
    private TextField phyCon;

    @FXML
    private TextField contactNoText1;

    @FXML
    private TextField addressText1;

    @FXML
    private TextField EmailText;

    @FXML
    private RadioButton rcatButton;

    @FXML
    private ToggleGroup tg1;

    @FXML
    private RadioButton rdogButton;


    @FXML
    private Button submitButton1;

    @FXML
    private Button logInButton;

    @FXML
    private Button RequestButton;

    @FXML
    private Text backLabel;

    @FXML
    void loginAction(ActionEvent event) throws Exception{
        String name = nameField.getText();
        String pass=passField.getText();
        main.getNetworkUtil().write(name);
        main.getNetworkUtil().write(pass);//null
    }
    @FXML
    void loginButtonAction(MouseEvent event) {
        FormPane.setVisible(false);
        loginPane.setVisible(true);
        backLabel.setVisible(false);

    }
    @FXML
    void resetAction(ActionEvent event) {
        nameField.setText(null);
        passField.setText(null);
        backLabel.setVisible(false);
    }


    @FXML
    void requestAction(MouseEvent event) {
        FormPane.setVisible(true);
        loginPane.setVisible(false);
        backLabel.setVisible(true);

    }
    @FXML
    void signUpAction(MouseEvent event) throws Exception {
        main.showSignUpPage();
        backLabel.setVisible(false);
    }
    @FXML
    void submitAction1(ActionEvent event) throws IOException {//request,= separator

        if (rcatButton.isSelected())
        { String t=rcatButton.getText();
            main.getNetworkUtil().write(NameText.getText()+">"+contactNoText1.getText()+">"+EmailText.getText()+">"+addressText1.getText()+">"+RescueDateText.getValue()+">"+t+">"+phyCon.getText());
        }
        else {
            String t=rdogButton.getText();
            main.getNetworkUtil().write(NameText.getText()+">"+contactNoText1.getText()+">"+EmailText.getText()+">"+addressText1.getText()+">"+RescueDateText.getValue()+">"+t+">"+phyCon.getText());
        }
        if(nameField.getText().equals("")||NameText.getText().equals("")||contactNoText1.getText().equals("")||EmailText.getText().equals("")||addressText1.getText().equals("")||RescueDateText.getValue().equals(null)||phyCon.getText().equals("")||(!rcatButton.isSelected()&&!rdogButton.isSelected())){
            main.showAlert("Please fill up all the necessary information");}
        main.getNetworkUtil().write(null);
        NameText.setText(null);
        contactNoText1.setText(null);
        EmailText.setText(null);
        addressText1.setText(null);
        RescueDateText.setValue(null);
        // animalTypeText.setText(null);
        phyCon.setText(null);

    }
    void setMain(Main main) {
        this.main = main;
    }
    public void init() {
        loginPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5); -fx-background-radius: 10;");
        Image img = new Image(Main.class.getResourceAsStream("Images/exit.png"));
        image.setImage(img);
        Image img2=new Image(Main.class.getResourceAsStream("Images/Remove.png"));
        minimize.setImage(img2);
    }
    @FXML
    void exitAction(MouseEvent event) throws Exception{
        System.exit(0);
    }
    @FXML
    void minimizeAction(MouseEvent event) {
        Stage stage=(Stage) anchorPane.getScene().getWindow();
        stage.setIconified(true);
    }
}
