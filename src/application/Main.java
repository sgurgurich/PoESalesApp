package application;
	
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import controllers.FrontEndController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import threads.MainThread;
import utils.FileParser;


public class Main extends Application {
	
	FrontEndController myController;
	FileParser parser;
	ExecutorService executor;
	Runnable mainWorker;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("notifierUi.fxml"));
		    Parent root = loader.load();

		    myController = loader.getController();
		    
		    parser = new FileParser();
		    
		    Scene scene = new Scene(root);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("PoE Sales Assitant");
		    primaryStage.show();

		    //Set Data to FXML through controller
		    myController.initializeData();
		    
		    // Create the backend
		    final int NTHREADS = 1;
		    executor   = Executors.newFixedThreadPool(NTHREADS);
            mainWorker = new MainThread(parser);
            executor.execute(mainWorker);
	        executor.shutdown();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop(){
	    executor.shutdownNow();
	    // Save file
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
