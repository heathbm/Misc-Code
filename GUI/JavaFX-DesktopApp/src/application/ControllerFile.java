package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerFile {
	
	@FXML
	private Button loginbtn;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Label loginDetails;

	public void loginAttempt() throws IOException {
		if(username.getText().equals("user") && password.getText().equals("pass")) {
			 Stage stage; 
		     Parent root;
		     stage=(Stage) loginbtn.getScene().getWindow();
		     root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		     Scene scene = new Scene(root);
		      stage.setScene(scene);
		      stage.show();
		} else 
			loginDetails.setText("Invalid Details");
	}
}