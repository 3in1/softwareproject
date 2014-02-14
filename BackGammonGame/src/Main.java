/*
 ============================================================================
 Name        : Main.java
 Author      : 3in1 Team
 Version     :
 Copyright   : 3in1 Team
 Description : 
 ============================================================================
 */

import java.util.Scanner;

public class Main {
	
	
	public static void main (String[] agrs){		
		Board game =new Board();
		Scanner a = new Scanner(System.in);
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		int positionfirstselection=-1;
		int positionsecondselection=-1;
		int choice;
		int n=0;	
		
		System.out.println("\n\t **Welcome to Backgammon Game!**\n");
		game.Initialization();
		
		do{
			game.settinguptheboard(positionfirstselection,positionsecondselection);
			dice1.roll();
			dice2.roll();
			System.out.println("\t    Dice One: " + dice1.value()+  " ; Dice Two: "+dice2.value() +"\n");	
			System.out.println("Please enter a position you wanna move: ");
				positionfirstselection=a.nextInt();
				System.out.println("Move to where (Integer position number)?: ");
				positionsecondselection=a.nextInt();
				
				System.out.println("Enter 1 to Display Results or 2 to Quit");
				choice=a.nextInt();
				if (choice==2){
					exit(0);
				}
				else if (choice==1){
					n++;
				}
			
		}while(n<100);
	}
		
	private static void exit(int i) {
		// TODO Auto-generated method stub
		
	}  
}
