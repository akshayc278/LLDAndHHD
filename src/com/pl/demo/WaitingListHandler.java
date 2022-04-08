package com.pl.demo;

import java.util.LinkedList;
import java.util.List;

public class WaitingListHandler {
	private List<String> waitingList=new LinkedList<>();
	
	public void addVehicleToList(String numberPlate){
		waitingList.add(numberPlate);
	}
	public boolean checkWaiting() {
		if(!waitingList.isEmpty()) {
			return true;
		}
		else return false;
	}
	public List<String> getWaitingList() {
		return waitingList;
	}
	public void setWaitingList(List<String> waitingList) {
		this.waitingList = waitingList;
	}
	
	
}
