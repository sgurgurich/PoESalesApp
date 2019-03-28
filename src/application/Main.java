package application;
	
import controllers.FrontEndController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("notifierUi.fxml"));
		    Parent root = loader.load();

		    FrontEndController myController = loader.getController();

		    Scene scene = new Scene(root);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("PoE Sales Assitant");
		    primaryStage.show();

		    //Set Data to FXML through controller
		    myController.initializeData();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
