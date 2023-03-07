package oo;

public class RendezVous {
	public int idr;
	public String idp;
	public String date;
	public String description;
	
	public RendezVous(int idr, String idp, String date, String description) {
		this.idr = idr;
		this.idp = idp;
		this.date = date;
		this.description = description;
	}

	public int getIdr() {
		return idr;
	}

	public void setIdr(int idr) {
		this.idr = idr;
	}

	public String getIdp() {
		return idp;
	}

	public void setIdp(String idp) {
		this.idp = idp;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
