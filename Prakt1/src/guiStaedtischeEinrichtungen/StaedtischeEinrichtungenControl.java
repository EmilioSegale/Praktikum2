package guiStaedtischeEinrichtungen;

import javafx.stage.Stage;
import ownUtil.Observer;
import business.Model;
import javafx.stage.Stage;

public class StaedtischeEinrichtungenControl implements Observer{
	
	private StaedtischeEinrichtungenView roboteruebersichtView;
	private Model haushaltsroboterModel;
	
	public StaedtischeEinrichtungenControl(Stage primaryStage){
			this.haushaltsroboterModel = Model.getInstance(); 		
			this.roboteruebersichtView = new StaedtischeEinrichtungenView(this, primaryStage, haushaltsroboterModel);
			
			this.haushaltsroboterModel.addObserver(this);
}

	@Override
	public void update() {
		this.roboteruebersichtView.zeigeHaushaltsroboterAn();
	}

}
