package business;

import java.util.ArrayList;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class Haushaltroboter {
	
    private int seriennummer;
    private float preis;
    private String modell;
    private String sensortyp;
    private ArrayList<String> farbe;
    

    public Haushaltroboter(int seriennummer, float preis, String modell,
    	String sensortyp, String[] farbe){
   		this.seriennummer = seriennummer;
  	    this.preis = preis;
   	    this.modell = modell;
   	    this.sensortyp = sensortyp;
   	    this.setFarbeAusStringArray(farbe);;
    }
    
    public void setFarbeAusStringArray(String [] farbe) {
    	this.farbe = new ArrayList<String>();
    	for(int i = 0; i < farbe.length; i++) {
    		this.farbe.add(i, farbe[i]);
    	}
    }
    //Getter and Setter

	public int getSeriennummer() {
		return seriennummer;
	}


	public void setSeriennummer(int seriennummer) {
		this.seriennummer = seriennummer;
	}


	public float getPreis() {
		return preis;
	}


	public void setPreis(float preis) {
		this.preis = preis;
	}


	public String getModell() {
		return modell;
	}


	public void setModell(String modell) {
		this.modell = modell;
	}


	public String getSensorTyp() {
		return sensortyp;
	}


	public void setSensorTyp(String sensortyp) {
		this.sensortyp = sensortyp;
	}


	public ArrayList<String> getFarbe() {
		return farbe;
	}
	
	//GetColor
	public String getColor(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getFarbe().size() - 1; i++) {
			ergebnis = ergebnis + this.getFarbe().get(i) + trenner; 
		}
		return ergebnis	+ this.getFarbe().get(i);
	}
	
	//GetHaushaltroboter
	public String gibHausroboternZurueck(char trenner){
  		return String.valueOf(this.getSeriennummer()) + trenner 
  			+ String.valueOf(this.getPreis()) + trenner
  		    + this.getModell() + trenner
  		    + this.getSensorTyp() + trenner
  		    + this.getColor(trenner) + "\n";
  	}

	

}
