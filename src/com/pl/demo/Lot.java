package com.pl.demo;

public class Lot {
	private Integer lotId;
	private String numberPlate;
	
	public Lot(Integer lotId,String numberPlate) {
		this.numberPlate = numberPlate;
		this.lotId = lotId;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public Integer getLotId() {
		return lotId;
	}
	public void setLotId(Integer lotId) {
		this.lotId = lotId;
	}
	

}
