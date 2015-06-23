package de.akquinet.engineering.vaadinator.produkt.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.akquinet.engineering.vaadinator.annotations.DisplayBean;
import de.akquinet.engineering.vaadinator.annotations.DisplayProperty;
import de.akquinet.engineering.vaadinator.annotations.DisplayPropertySetting;

@DisplayBean(captionText = "Produkt")
@Entity
public class Produkt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Produkt() {
		super();
	}

	public Produkt(String bezeichnung, String beschreibung, double preis, int mwstSatz) {
		super();
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.mwstSatz = mwstSatz;
		this.bezeichnung = bezeichnung;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@DisplayProperty(profileSettings = { @DisplayPropertySetting(required = true, showInTable = true) })
	private String bezeichnung;
	
	private String beschreibung;
	@DisplayProperty(captionText="Preis in €")
	private double preis;
	@DisplayProperty(captionText="Mehrwertsteuersatz")
	private int mwstSatz;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String nummer) {
		this.bezeichnung = nummer;
	}

	public String getBeschreibung() {
		return beschreibung;
	}
	
	@DisplayProperty(profileSettings = { @DisplayPropertySetting(showInTable = true) })
	public String getBeschreibungKurz() {
		return beschreibung.substring(0,30);
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public int getMwstSatz() {
		return mwstSatz;
	}

	public void setMwstSatz(int mwstSatz) {
		this.mwstSatz = mwstSatz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result
				+ ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + mwstSatz;
		long temp;
		temp = Double.doubleToLongBits(preis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produkt other = (Produkt) obj;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (id != other.id)
			return false;
		if (mwstSatz != other.mwstSatz)
			return false;
		if (Double.doubleToLongBits(preis) != Double
				.doubleToLongBits(other.preis))
			return false;
		return true;
	}
	
	
	
}
