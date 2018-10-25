package com.practiceprobs;

import java.util.Scanner;

public class SETGETTrans {

	static Scanner scan;
	static StackForComm stackA=new StackForComm(60);
	
	public static void main(String[] args) {
		scan=new Scanner(System.in);
		String inputCommand;
		while(scan.hasNext()) {
			inputCommand=scan.nextLine();
			String[] commandToArray=inputCommand.split(" ");
			switch(commandToArray[0]) {
				case "SET":
					stackA.set(commandToArray[1],commandToArray[2]);
					break;
				case "GET":
					System.out.print(" ");
					if(stackA.getVal(commandToArray[1])==null)
						System.out.print(" null");
					else
						System.out.println(stackA.getVal(commandToArray[1]));
					break;
				case "UNSET":
					stackA.unset(commandToArray[1]);
					break;
				case "UPDATE":
					boolean ret=stackA.update(commandToArray[1],commandToArray[2]);
					if(!ret) {
						System.out.println("No Variable Named \""+commandToArray[1]+"\"");
					}
					break;
				case "COUNT":
					int val=stackA.countVal(commandToArray[1]);
					if(val>=1)
						System.out.print(" "+val);
					else
						System.out.print(" 0");
					break;
				case "BEGIN":
					stackA.push(commandToArray[0]);
					break;
				case "ROLLBACK":
					stackA.rollBack();
					break;
				case "COMMIT":
					break;
				default:
					System.out.println("Invalid input");
			}
		}
		
	}

}
