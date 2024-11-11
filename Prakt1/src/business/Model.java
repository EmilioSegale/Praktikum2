package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import factory.ConcreteCreatorCsv;
import factory.ConcreteCreatorTxt;
import factory.Creator;
import factory.Product;


public class Model {
	
	public Haushaltroboter haushaltroboter;
	
		
	public Haushaltroboter getHaushaltroboter() {
		return haushaltroboter;
	}
	public void setHaushaltroboter(Haushaltroboter haushaltroboter) {
	    this.haushaltroboter = haushaltroboter;
	}
	
	
	public void schreibeHaushaltroboterInCsvDatei() throws IOException {
		if (this.haushaltroboter == null) {
	        throw new IllegalStateException("Haushaltroboter can not be Ini.");
	    }
			BufferedWriter aus = new BufferedWriter(new FileWriter("Haushaltsroboter.csv", true));
			aus.write(this.getHaushaltroboter().gibHausroboternZurueck(';'));
			aus.close();

	}
	public void leseHaushaltroboterAusCsvDatei() throws IOException {
		
		Creator  readerCreator = new ConcreteCreatorCsv();
		Product reader = readerCreator.factoryMethod();
		
        String[] zeile = reader.leserAusDatei();
        
        this.setHaushaltroboter(new Haushaltroboter(Integer.parseInt(zeile[0]), 
            Float.parseFloat(zeile[1]), 
            zeile[2], 
            zeile[3], 
            zeile[4].split("_"))); 
        reader.schlieesenDatei();
	}
	
	public void leseHaushaltroboterAusTxtDatei() throws IOException {
			
			Creator  readerCreator = new ConcreteCreatorTxt();
			Product reader = readerCreator.factoryMethod();
			
	        String[] zeile = reader.leserAusDatei();
	        
	        this.setHaushaltroboter(new Haushaltroboter(Integer.parseInt(zeile[0]), 
	            Float.parseFloat(zeile[1]), 
	            zeile[2], 
	            zeile[3], 
	            zeile[4].split("_"))); 
	        reader.schlieesenDatei();
		}
	
}
