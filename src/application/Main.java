package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();

			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			Parent root = FXMLLoader.load(getClass().getResource("notifierUi.fxml"));

			//Scene scene = new Scene(root,600,800);
			
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
