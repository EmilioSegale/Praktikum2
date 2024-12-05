package guiStaedtischeEinrichtungen;

import javafx.stage.Stage;
import business.Model;
import javafx.stage.Stage;

public class StaedtischeEinrichtungenControl {
	
	private StaedtischeEinrichtungenView roboteruebersichtView;
	private Model haushaltsroboterModel;
	
	public StaedtischeEinrichtungenControl(Stage primaryStage){
			this.haushaltsroboterModel = Model.getInstance(); 		
			this.roboteruebersichtView = new StaedtischeEinrichtungenView(this, primaryStage, haushaltsroboterModel);
}

}
