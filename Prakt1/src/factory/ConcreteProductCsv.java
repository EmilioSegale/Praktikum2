package factory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductCsv extends Product{
		
	private BufferedReader ein;

	public ConcreteProductCsv() throws FileNotFoundException {
		this.ein = new BufferedReader(new FileReader("Haushaltsrobotern.csv"));;
	}
	
	@Override
	public String[] leserAusDatei() throws IOException {
		
		String[] zeile = ein.readLine().split(";");
		return zeile;
	}

	@Override
	public void schlieesenDatei() throws IOException {
		ein.close();
	}

}
