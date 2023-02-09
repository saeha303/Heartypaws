package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.*;

import java.io.IOException;
import java.util.List;

public class Main extends Application {
    double x,y=0;
    public String clientName;
    private Stage stage;
    private NetworkUtil networkUtil;
    public Stage getStage() {
        return stage;
    }
    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }
    public adminlogincontroller alcontroller;
    public UserLoginHomeController ulhcontroller;
    public void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText(s);
        alert.setContentText("Try again");
        alert.showAndWait();
    }
    public void showConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Successful login");
        alert.setHeaderText("Congratulations");
        alert.setContentText("You can now browse freely");
        alert.showAndWait();
    }
    void showDemo() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("demo.fxml"));

        Parent root = loader.load();
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
        DemoController controller=loader.getController();
        stage.setResizable(false);
        stage.setScene(new Scene(root, 200, 200));///1280/680,640/340
        stage.show();

    }

    void getUpdatedList(List<CombinedAnimal> list){
        alcontroller.residual(list);
    }
    void getUpdatedCatDogList(List<Animal> list){
        ulhcontroller.residual(list);
    }
    void donorLoad(List<Donor> list) throws Exception {
        alcontroller.donorLoad(list);
    }
    void phyconLoad(List<CombinedPhyCon> list) throws Exception{
        alcontroller.phyconLoad(list);
    }
    void vaccineLoad(List<Vaccine> list) throws Exception{
        alcontroller.vaccineLoad(list);
    }
    void historyLoad(List<AdoptedShow> list) throws Exception {
        alcontroller.historyLoad(list);
    }
    void registeredLoad(List<Registered> list)throws Exception {
        alcontroller.registeredLoad(list);

    }
    void reqToDropLoad(List<Request> list)throws Exception {
        alcontroller.reqToDropLoad(list);
    }
    void staffLoad(List<Staff> list)throws Exception {
        alcontroller.staffLoad(list);
    }
    void oldstaffLoad(List<OldStaff> list)throws Exception {
        alcontroller.oldstaffLoad(list);
    }
    void supplierLoad(List<Supplier> list)throws Exception {
        alcontroller.supplierLoad(list);
    }
    void transLoad(List<Transaction> list)throws Exception {
        alcontroller.transLoad(list);
    }
    void showAdminLogin(List<CombinedAnimal> list) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("adminlogin.fxml"));

        Parent root = loader.load();
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        alcontroller=loader.getController();
        alcontroller.setMain(this);
        alcontroller.init(list);
        stage.setResizable(false);
        stage.setScene(new Scene(root, 1280, 680));///1280/680,640/340
        stage.setMaximized(true);
        stage.show();

    }
    public void showAfterUserLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("UserLoginHome.fxml"));

        Parent root = loader.load();
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        // Loading the controller
        ulhcontroller = loader.getController();
        ulhcontroller.setMain(this);

        // Set the primary stage
        stage.setResizable(false);
        stage.setScene(new Scene(root, 1240, 680));///930/710
        stage.setMaximized(true);
        stage.show();
    }
    public void showSignUpPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("signup.fxml"));

        Parent root = loader.load();
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
        SignupController controller = loader.getController();
        controller.init();
        controller.setMain(this);
        stage.setResizable(false);
        stage.setScene(new Scene(root, 683, 680));///1280/680,640/340
        stage.show();
    }
    public void showLoginPageHP() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("newlogintry.fxml"));

        Parent root = loader.load();

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
        LoginHPcontroller controller = loader.getController();
        controller.init();
        controller.setMain(this);
        stage.setResizable(false);
        stage.setScene(new Scene(root, 934, 680));///1280/680,640/340
        stage.show();
    }
    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new ReadThread(this);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.initStyle(StageStyle.UNDECORATED);
        connectToServer();
        showLoginPageHP();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
