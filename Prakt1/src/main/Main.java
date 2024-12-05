package main;

import guiHaushaltsrobotern.Control;
import guiStaedtischeEinrichtungen.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		new Control(primaryStage);
		Stage fensterStaedtischeEinrichtungen = new Stage();
		new StaedtischeEinrichtungenControl(fensterStaedtischeEinrichtungen);
	}
	
	public static void main(String[] args){
		launch(args);
	}


}
