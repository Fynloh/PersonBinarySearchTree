
import java.util.UUID;

/**
 * Die Person Klasse von JBook, ein Adressverwaltungsprogramm entwickelt in Java.
 * Diese Klasse ist dient als Modell fÃ¼r die Kontakte. 
 * 
 * @author Fynn Lohse, Bastian Wrede
 * @version 1.0 R
 *
 */

public class Person implements ComparableContent<Person>
{
  
  public enum Haarfarbe
  {
    Schwarz, Weiß, Braun, Blond, Grün, Blau, Grau, Rot, Gelb, Lila, Orange, unbekannt
  }
  
  public enum Hautfarbe
  {
    Schwarz, Weiß, unbekannt
  }
  
  public enum Augenfarbe
  {
    Braun, Grün, Blau, Grau, unbekannt
  }
  
  public enum Geschlecht
  {
    MÃ¤nnlich, Weiblich, Sonstiges, unbekannt
  }
  
  public enum Religion
  {
    Muslimisch, Katholisch, Evangelisch, Jüdisch, Atheistisch, unbekannt
  }
  
  public enum Monat
  {
    Januar, Februar, März, April, Mai, Juni, Juli, August, September, Oktober, November, Dezember, unbekannt
  }
  
  // Anfang Attribute
	  private UUID uuid = UUID.randomUUID();
	  private String vorname = "---";
	  private String nachname = "---";
	  private String land = "---";
	  private String postleitzahl = "---";
	  private String ort = "---";
	  private String strasse = "---";
	  private String hausnummer = "---";
	  private String adresszusatz = "---";
	  private String email = "---";
	  private String bild = "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";
	  private String bildFormat = "---";
	  private int groesse = 0;
	  private int gewicht = 0;
	  private Augenfarbe augenfarbe = Augenfarbe.unbekannt;
	  private String telefon = "---";
	  private String telefonMobil = "---";
	  private String nationalitaet = "---";
	  private String firma = "---";
	  private Religion religion = Religion.unbekannt;
	  private Haarfarbe haarfarbe = Haarfarbe.unbekannt;
	  private Hautfarbe hautfarbe = Hautfarbe.unbekannt;
	  private Geschlecht geschlecht = Geschlecht.unbekannt;
	  private int geburtsjahr = 0;
	  private Monat geburtsmonat = Monat.unbekannt;
	  private int geburtstag = 0;
	  private String compare = "";
  // Ende Attribute
  
  // Anfang Methoden
	  public String getVorname() 
	  {
	    return vorname;
	  }
	
	  public void removeEmpty()
	  {
		  String[] temp = {vorname,nachname,land,postleitzahl,ort,strasse,hausnummer,email,telefon,telefonMobil,firma};
		  
		  for (int i = 0; i<temp.length; i++)
		  {
			  switch (temp[i])
			  {
			  case "": temp[i] = "---";
			  }
		  }
		  
		  vorname = temp[0];
		  nachname = temp[1];
		  land = temp[2];
		  postleitzahl = temp[3];
		  ort = temp[4];
		  strasse = temp[5];
		  hausnummer = temp[6];
		  email = temp[7];
		  telefon = temp[8];
		  telefonMobil = temp[9];
		  firma = temp[10];
		
	  }
	  
	  public void setVorname(String vorname) 
	  {
	    this.vorname = vorname;
	  }
	
	  
	  public String getNachname() 
	  {
	    return nachname;
	  }
	
	  
	  public void setNachname(String nachname) 
	  {
	    this.nachname = nachname;
	  }
	
	  
	  
	  
	  public String getLand() {
	    return land;
	  }
	
	  public String getFirma() 
	  {
		    return firma;
	  }
	  
	  public void setLand(String land) {
	    this.land = land;
	  }
	
	  
	  public String getPostleitzahl() {
	    return postleitzahl;
	  }  
	  
	  public void setPostleitzahl(String postleitzahl) 
	  {
	    this.postleitzahl = postleitzahl;
	  }       
	  
	  public String getOrt() 
	  {
	    return ort;
	  }
	
	  
	  public void setOrt(String ort) 
	  {
	    this.ort = ort;
	  }
	
	  
	  public String getStrasse()
	  {
	    return strasse;
	  }
	
	  
	  public void setStrasse(String strasse) 
	  {
	    this.strasse = strasse;
	  }
	
	  
	  public String getHausnummer() 
	  {
	    return hausnummer;
	  }
	
	  
	  public void setHausnummer(String hausnummer) 
	  {
	    this.hausnummer = hausnummer;
	  }
	
	  
	  public String getAdresszusatz() 
	  {
	    return adresszusatz;
	  }
	
	  
	  public void setAdresszusatz(String adresszusatz) 
	  {
	    this.adresszusatz = adresszusatz;
	  }
	
	  
	  public String getEmail() 
	  {
	    return email;
	  }
	
	  
	  public void setEmail(String email) 
	  {
	    this.email = email;
	  }
	
	  
	  public int getGroesse()
	  {
	    return groesse;
	  }
	
	  
	  public void setGroesse(int groesse)
	  {
	    this.groesse = groesse;
	  }
	
	  
	  public int getGewicht()
	  {
	    return gewicht;
	  }
	
	  
	  public void setGewicht(int gewicht) 
	  {
	    this.gewicht = gewicht;
	  }
	
	  
	  public Augenfarbe getAugenfarbe()
	  {
	    return augenfarbe;
	  }
	
	  
	  public void setAugenfarbe(Augenfarbe augenfarbe) 
	  {
	    this.augenfarbe = augenfarbe;
	  }
	
	  
	  public String getTelefon() 
	  {
	    return telefon;
	  }
	
	  
	  public void setTelefon(String telefon)
	  {
	    this.telefon = telefon;
	  }
	
	  
	  public String getTelefonMobil() 
	  {
	    return telefonMobil;
	  }
	
	  
	  public void setTelefonMobil(String telefonMobil) 
	  {
	    this.telefonMobil = telefonMobil;
	  }
	
	  
	  public String getNationalitaet() 
	  {
	    return nationalitaet;
	  }
	
	  
	  public void setNationalitaet(String nationalitaet) 
	  {
	    this.nationalitaet = nationalitaet;
	  }
	  
	  public void setFirma(String firma) 
	  {
		    this.firma = firma;
		  }
	
	
	  
	  public Religion getReligion() 
	  {
	    return religion;
	  }
	
	  
	  public void setReligion(Religion religion) 
	  {
	    this.religion = religion;
	  }
	
	  
	  public Haarfarbe getHaarfarbe() 
	  {
	    return haarfarbe;
	  }
	
	  
	  public void setHaarfarbe(Haarfarbe haarfarbe) 
	  {
	    this.haarfarbe = haarfarbe;
	  }
	
	  
	  public Hautfarbe getHautfarbe() 
	  {
	    return hautfarbe;
	  }
	
	  public void setHautfarbe(Hautfarbe hautfarbe) 
	  {
	    this.hautfarbe = hautfarbe;
	  }
	
	  public Geschlecht getGeschlecht() 
	  {
	    return geschlecht;
	  }
	
	public void setGeschlecht(Geschlecht geschlecht) 
	{
	   this.geschlecht = geschlecht;
	}


	public int getGeburtsjahr()
	{
		return geburtsjahr;
	}
	
	
	public void setGeburtsjahr(int geburtsjahr)
	{
		this.geburtsjahr = geburtsjahr;
	}
	
	
	public Monat getGeburtsmonat()
	{
		return geburtsmonat;
	}
	
	
	public void setGeburtsmonat(Monat geburtsmonat)
	{
		this.geburtsmonat = geburtsmonat;
	}
	
	
	public int getGeburtstag()
	{
		return geburtstag;
	}
	
	
	public void setGeburtstag(int geburtstag)
	{
		this.geburtstag = geburtstag;
	}
	
	
	public String getBild()
	{
		return bild;
	}
	
	
	public void setBild(String bild)
	{
		this.bild = bild;
	}
	
	
	public String getBildFormat()
	{
		return bildFormat;
	}
	
	
	public void setBildFormat(String bildFormat)
	{
		this.bildFormat = bildFormat;
	}
	
	
	public UUID getUuid()
	{
		return uuid;
	}
	
	
	public void setUuid(UUID uuid)
	{
		this.uuid = uuid;
	}
	
	public void setComparable(String comp)
	{
		compare = comp;
	}
	
	public String getComparable()
	{
		return compare;
	}

	@Override
	public boolean isGreater(Person pContent)
	{
		switch (compare)
		{
		case "name":
			if (nachname.compareTo(pContent.getNachname()) > 0)
					return true;
			else if (nachname.equals(pContent.getNachname()))
					if (vorname.compareTo(pContent.getVorname()) > 0)
						return true;
			else
				return false;
				
		case "vorname":
			if (vorname.compareTo(pContent.getVorname()) > 0)
				return true;
			else
				return false;
		default:
			if (nachname.compareTo(pContent.getNachname()) > 0)
				return true;
			else
				return false;
		//case "alter":
		}
	}

	@Override
	public boolean isEqual(Person pContent)
	{
		switch (compare)
		{
		case "name":
			if (nachname.equals(pContent.getNachname()))
				if (vorname.equals(pContent.getVorname()))
					return true;
			else
				return false;
		case "vorname":
			if (vorname.equals(pContent.getVorname()))
				if (nachname.equals(pContent.getNachname()))
					return true;
				else
					return false;
			else
				return false;
		default:
			if (nachname.equals(pContent.getNachname()))
				return true;
			else
				return false;
		//case "alter":
		}
	}

	@Override
	public boolean isLess(Person pContent)
	{
		switch (compare)
		{
		case "name":
			if (nachname.compareTo(pContent.getNachname()) < 0)
				return true;
		else if (nachname.equals(pContent.getNachname()))
				if (vorname.compareTo(pContent.getVorname()) < 0)
				return true;
		else
			return false;
		case "vorname":
			if (vorname.compareTo(pContent.getVorname()) < 0)
				return true;
			else
				return false;
		default:
			if (nachname.compareTo(pContent.getNachname()) < 0)
				return true;
			else
				return false;
		//case "alter":
		}
	}

}
