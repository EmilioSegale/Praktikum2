package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import factory.ConcreteCreatorCsv;
import factory.ConcreteCreatorTxt;
import factory.Creator;
import factory.Product;
import ownUtil.Observable;
import ownUtil.Observer;


public class Model implements Observable{
	
	private ArrayList<Haushaltroboter> haushaltroboter = new ArrayList<Haushaltroboter>();
	
	private static Model haushaltsroboterModel;
	
	public static Model getInstance() {
		if(haushaltsroboterModel == null) {
			haushaltsroboterModel = new Model();
		}
		return haushaltsroboterModel;
	}
	
	private Vector<Observer> observers = new Vector<Observer>();
		
	private Model() {

	}
	
	public ArrayList<Haushaltroboter> getHaushaltroboter() {
		return this.haushaltroboter;
	}
//	public void setHaushaltroboter(Haushaltroboter haushaltroboter) {
//	    this.haushaltroboter = haushaltroboter;
//	}
	public void addHaushaltsroboter(Haushaltroboter haushaltroboter){
		this.haushaltroboter.add(haushaltroboter);
	}
	
	
	public void schreibeHaushaltroboterInCsvDatei() throws IOException {
		if (this.haushaltroboter == null) {
	        throw new IllegalStateException("Haushaltroboter can not be Ini.");
	    }
			BufferedWriter aus = new BufferedWriter(new FileWriter("Haushaltsroboter.csv", true));
			
			for(Haushaltroboter haushaltrobot : this.getHaushaltroboter()) {
				aus.write(haushaltrobot.gibHausroboternZurueck(';'));
			}
			aus.close();

	}
	public void leseHaushaltroboterAusCsvDatei() throws IOException {
		
		Creator  readerCreator = new ConcreteCreatorCsv();
		Product reader = readerCreator.factoryMethod();
		
        String[] zeile = reader.leserAusDatei();
        
        this.addHaushaltsroboter(new Haushaltroboter(Integer.parseInt(zeile[0]), 
            Float.parseFloat(zeile[1]), 
            zeile[2], 
            zeile[3],
            zeile[4].split("_"))); 
        reader.schlieesenDatei();
        
        notifyObserver();

	}
	
	public void leseHaushaltroboterAusTxtDatei() throws IOException {
			
			Creator  readerCreator = new ConcreteCreatorTxt();
			Product reader = readerCreator.factoryMethod();
			
	        String[] zeile = reader.leserAusDatei();
	        
	        this.addHaushaltsroboter(new Haushaltroboter(Integer.parseInt(zeile[0]), 
	            Float.parseFloat(zeile[1]), 
	            zeile[2], 
	            zeile[3], 
	            zeile[4].split("_"))); 
	        reader.schlieesenDatei();
	        
	        notifyObserver();

	}
	@Override
	public void addObserver(Observer obs) {
		observers.addElement(obs);
	}
	@Override
	public void removeObserver(Observer obs) {
		observers.removeElement(obs);
	}
	@Override
	public void notifyObserver() {
		
		for(Observer obs: observers) {
			obs.update();
		}
		
	}
}
