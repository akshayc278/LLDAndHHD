package com.pl.demo;

import java.util.LinkedList;
import java.util.Queue;

public class LotConfig {
	private Lot []lotArray=new Lot[5];
	Queue<Lot> que = new LinkedList<>();
	public LotConfig() {
		for(int i=0;i<lotArray.length;i++) {
			lotArray[i]=new Lot(i+1,null);
			que.add(lotArray[i]);
		}
	}
	public Lot getVacantLot() {
		Lot lot=que.poll();
		return lot;
	}
	
	public boolean addLot(String numberPlate) {
		Lot l=getVacantLot();
		if(l!=null) {
		l.setNumberPlate(numberPlate);
		aquireLot(l);
		return true;
		}
		else {
			return false;
		}
		
		
		
	}
	public void aquireLot(Lot lot) {
		Integer lotId=lot.getLotId();
		lotArray[lotId-1]=lot;
	}
	public void releaseLot(String numberPlate) {
		for(int i=0;i<lotArray.length;i++) {
			if(lotArray[i].getNumberPlate()!=null) {
				if(lotArray[i].getNumberPlate().equals(numberPlate)){
					lotArray[i].setNumberPlate(null);
					que.add(lotArray[i]);
					break;
					
				}
			}
		}
	}
	
	public void  printLotStaus() {
		for(int i=0;i<lotArray.length;i++) {
			System.out.println(lotArray[i].getLotId()+" "+lotArray[i].getNumberPlate());
		}
	}
}
