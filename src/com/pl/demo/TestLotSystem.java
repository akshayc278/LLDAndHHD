package com.pl.demo;

import java.util.Scanner;

public class TestLotSystem {
	private LotConfig config=new LotConfig();
	private WaitingListHandler waitingListHandler=new WaitingListHandler();
	public static void main(String[] args) {
		TestLotSystem testLotSystem=new TestLotSystem();
		testLotSystem.runSystem();
		
	}
	public String defaultMessage() {
	
		StringBuilder sb=new StringBuilder();
		sb.append("Please choose from below option\n");
		sb.append("Type 1 to add new vehicle\n");
		sb.append("Type 2 to remove vehicle\n");
		sb.append("Type 3 to check Status of parking lot \n");
		sb.append("Type 4 to exit from system\n");
		return sb.toString();
	}
	
	public void runSystem() {
		Scanner sc=new Scanner(System.in);
		System.out.println("welcome to Parking Lot system");
		
		boolean flag=true;
		while(flag) {
			System.out.print(defaultMessage());
			Integer input=sc.nextInt();
			
			switch(input) {
			case 1:	System.out.println("Enter Vehicle Number:");
					String numberPlate=sc.next();
					boolean addStatus=config.addLot(numberPlate);
					if(!addStatus) {
						System.out.println("Vehicle not added as parking is full");
						System.out.println("Do you want to Wait? yes/no?");
						String userAdvice=sc.next();
						if(userAdvice.equalsIgnoreCase("Yes")) {
							waitingListHandler.addVehicleToList(numberPlate);
						}
						else {
							System.out.println("thank you for visiting");
						}
					}
				break;
			case 2: System.out.println("Enter Vehicle Number:");
					config.releaseLot(sc.next());
					if(waitingListHandler.checkWaiting()) {
						String waitingCarPlate=waitingListHandler.getWaitingList().get(0);
						config.addLot(waitingCarPlate);
						waitingListHandler.getWaitingList().remove(0);
					}
				break;
			case 3: System.out.println("------------------");
					config.printLotStaus();
					System.out.println("------------------");
				break;
			case 4:	System.out.println("Thank you for using parking lot service");
					flag=false;
					break;
			default: System.out.println("Please provide valid input");
			}
		}
	}

}
