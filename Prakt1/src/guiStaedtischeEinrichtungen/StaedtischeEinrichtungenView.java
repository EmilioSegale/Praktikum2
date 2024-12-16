package guiStaedtischeEinrichtungen;
import business.Model;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;


public class StaedtischeEinrichtungenView {
	
	private StaedtischeEinrichtungenControl roboteruebersichtControl;
	private Model haushaltsroboterModel;		
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeHaushaltsroboter     
 		= new Label("Anzeige Haushaltsroboter");
    	private TextArea txtAnzeigeHaushaltsroboter  = new TextArea();
    	private Button btnAnzeigeHaushaltsroboter 
 		= new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public StaedtischeEinrichtungenView(StaedtischeEinrichtungenControl roboteruebersichtControl, Stage primaryStage, Model haushaltsroboterModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Robotern");
    		primaryStage.show();
    		this.roboteruebersichtControl = roboteruebersichtControl;
	 		this.haushaltsroboterModel = haushaltsroboterModel;
	 		
	 		
	 		this.initKomponenten();
			this.initListener();
    	}

 	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeHaushaltsroboter.setLayoutX(310);
    		lblAnzeigeHaushaltsroboter.setLayoutY(40);
    		lblAnzeigeHaushaltsroboter.setFont(font);
    		lblAnzeigeHaushaltsroboter.setStyle(
 			"-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeHaushaltsroboter);           
// Textbereich	
        	txtAnzeigeHaushaltsroboter.setEditable(false);
     		txtAnzeigeHaushaltsroboter.setLayoutX(310);
    		txtAnzeigeHaushaltsroboter.setLayoutY(90);
     		txtAnzeigeHaushaltsroboter.setPrefWidth(220);
    		txtAnzeigeHaushaltsroboter.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeHaushaltsroboter);       	
        	// Button
          	btnAnzeigeHaushaltsroboter.setLayoutX(310);
        	btnAnzeigeHaushaltsroboter.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeHaushaltsroboter); 
   }
   
   private void initListener() {
	    btnAnzeigeHaushaltsroboter.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeHaushaltsroboterAn();
	        	} 
   	    });
    }
   
    public void zeigeHaushaltsroboterAn(){
    		if(haushaltsroboterModel.getHaushaltroboter() != null){
    			txtAnzeigeHaushaltsroboter.setText(
    				haushaltsroboterModel.getHaushaltroboter().gibHausroboternZurueck(' '));
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Haushaltsroboter" 
 				+ " aufgenommen!");
    		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	

}
