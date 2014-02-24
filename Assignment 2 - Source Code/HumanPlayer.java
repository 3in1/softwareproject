import java.util.Scanner;

public class HumanPlayer extends Board {
	public void quitorpassorcontinuefunction(){
		Scanner quitornot = new Scanner(System.in);
		
		System.out.println("Enter q to quit, c to continue, p to pass:");
		String takingchoice = quitornot.nextLine();
		if (takingchoice.equalsIgnoreCase("c")){
			System.out.println("*Continue function occurred! Backgammon: Go ahead!*\n");
			RollDice();
			System.out.printf("Please enter your move(s) - ");
			if (dice1st!=dice2nd){
				System.out.printf("[Note: Available valid moves %d %d]:\n",dice1st,dice2nd);
			}
			else {
				System.out.printf("[Note: Available valid moves %d %d %d %d]:\n",dice1st,dice2nd,dice1st,dice2nd);
			}
		}
		else if (takingchoice.equalsIgnoreCase("p")){
			System.out.println("*Pass function occurred! Backgammon: Player gives up!*\n");
			settinguptheboard();
			quitorpassorcontinuefunction();
		}
		else if (takingchoice.equalsIgnoreCase("q")){
			System.out.println("*Quit function occurred! Backgammon: GoodBye!*\n");
			System.exit(0);
		}
		else {
			System.out.println("*Invalid Inputs! Backgammon: Re-enter!*\n");
			quitorpassorcontinuefunction();
		}
	}
	
	
}
	