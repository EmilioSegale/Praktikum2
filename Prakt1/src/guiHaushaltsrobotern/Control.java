package guiHaushaltsrobotern;

import java.io.IOException;
import java.util.Vector;

import business.Model;
import javafx.beans.Observable;
import javafx.stage.Stage;
import ownUtil.Observer;


public class Control implements Observer{
	
	private Model m;
	private View v;
	
	public Control (Stage st) throws Exception{
		this.m = Model.getInstance();
		this.v = new View(st, this, m);
		this.m.addObserver(this);
	}
	

	Vector<Observer> observer = new Vector<Observer>();
	
	public void schreibeHaushaltroboterInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				this.m.schreibeHaushaltroboterInCsvDatei();
				this.v.zeigeInformationsfensterAn("Die Haushaltroboter wurden gespeichert");
			} else {
				this.v.zeigeInformationsfensterAn("Noch nicht implementiert");
			}
		} 
		catch (IOException ioe) {
			v.zeigeFehlermeldungsfensterAn("IOException");
			ioe.printStackTrace();
		} catch(Exception exc) {
			v.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
			exc.printStackTrace();
		} 
	}
	
	public void leseAusDatei(String typ) {
        try {
            if ("csv".equals(typ)) {
            	m.leseHaushaltroboterAusCsvDatei();
                v.zeigeInformationsfensterAn("Die Haushaltsroboter wurden gelesen!");
            }
            else if("txt".equals(typ)) {
            	m.leseHaushaltroboterAusTxtDatei();
                v.zeigeInformationsfensterAn("Die Haushaltsroboter wurden gelesen!");
            }
            else {
                v.zeigeInformationsfensterAn("Noch nicht implementiert!");
            }
        } catch (IOException exc) {
            v.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
        } catch (Exception exc) {
            v.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
            exc.printStackTrace();
        }
    }

	@Override
	public void addObserver(Observer obs) {
		this.observer.addElement(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observer.removeElement(obs);
	}

	@Override
	public void notifyObserver() {
		for(Observer ob : observer) {
			this.observer.notify();
		}
	}
}


