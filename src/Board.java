import java.util.Random;


public class Board {
	public static String[][] ChipsSetUpNumbers = new String[25][25];
	public void Initialization(){
		//Initialising values
		ChipsSetUpNumbers[1][0]="O"; ChipsSetUpNumbers[1][1]="2";
		ChipsSetUpNumbers[6][0]="X"; ChipsSetUpNumbers[6][1]="5";
		ChipsSetUpNumbers[8][0]="X"; ChipsSetUpNumbers[8][1]="3";
		ChipsSetUpNumbers[12][0]="O"; ChipsSetUpNumbers[12][1]="5";
		
		ChipsSetUpNumbers[13][0]="X"; ChipsSetUpNumbers[13][1]="5";
		ChipsSetUpNumbers[17][0]="O"; ChipsSetUpNumbers[17][1]="3";
		ChipsSetUpNumbers[19][0]="O"; ChipsSetUpNumbers[19][1]="5";
		ChipsSetUpNumbers[24][0]="X"; ChipsSetUpNumbers[24][1]="2";
	}
	

	
	
	public void settinguptheboard(int start, int end){
		int validmovechecking=0;
		//Top Frame
		for (int TopLine =13; TopLine<25; TopLine++){
			if (TopLine == 13 | TopLine == 18 | TopLine == 19 | TopLine == 24){
				System.out.print(TopLine);
				if (TopLine == 13 || TopLine == 19)
					System.out.print("--");
				else if (TopLine == 24)
					System.out.print(" off");
				else
					System.out.print(" Bar ");
			}
			else{ 
				System.out.print("+");
				for (int PrintDash=0;PrintDash<3;PrintDash++){
					System.out.print("-");
				}
			}
		}
				//Making a simple move{
				if (start>=0 && end>=0){
					//Check invalid moves such as you cannot move X onto O or vice versa
					if (ChipsSetUpNumbers[end][0]!=ChipsSetUpNumbers[start][0] && ChipsSetUpNumbers[end][0]!="|"){
						validmovechecking++;
					}
					else if (ChipsSetUpNumbers[start][0]!="X" && ChipsSetUpNumbers[start][0]!="O"){
						validmovechecking++;
					}
					else if (ChipsSetUpNumbers[start][0]=="O" && start>end){
						//O cannot move from right to left
						validmovechecking++;
					}
					else if (ChipsSetUpNumbers[start][0]=="X" && end>start){
						//X cannot move from left to right
						validmovechecking++;
					}
					//If moves are valid, then:
					else {
						//If we move to a new place which means no chips at all,  then:
						if (ChipsSetUpNumbers[end][0]!="X" && ChipsSetUpNumbers[end][0]!="O"){
							ChipsSetUpNumbers[end][0]=ChipsSetUpNumbers[start][0];
							ChipsSetUpNumbers[end][1]="1";
						}
						//Otherwise: basically, increase the number of chips by one at the new position
						else {
							int checkinginexistence=Integer.parseInt(ChipsSetUpNumbers[end][1]);
							checkinginexistence++;
							String movingchipsin = Integer.toString(checkinginexistence);
							ChipsSetUpNumbers[end][1]=movingchipsin;
							ChipsSetUpNumbers[end][0]=ChipsSetUpNumbers[start][0];
						}
						//No matter what moves we make, we will always need to decrease the number of chips by one at where we start
						int converttointeger=Integer.parseInt(ChipsSetUpNumbers[start][1]);
						converttointeger--;
						//If one position has been moved to have no chips, then we replace it by "|"
						if(converttointeger>0){
							String convertbacktostring = Integer.toString(converttointeger);
							ChipsSetUpNumbers[start][1]=convertbacktostring;
						}
						else{
							ChipsSetUpNumbers[start][0]=ChipsSetUpNumbers[start][1]=null;
						}
					}
				}
				//Making a simple move}
				
				for (int InitialValuesNumbers=0;InitialValuesNumbers<24;InitialValuesNumbers++){
					if (ChipsSetUpNumbers[InitialValuesNumbers][0]==null | ChipsSetUpNumbers[InitialValuesNumbers][1]==null){
						ChipsSetUpNumbers[InitialValuesNumbers][0]="|";
						ChipsSetUpNumbers[InitialValuesNumbers][1]=" ";
						//Its "|"+" ", so that to make it like "X" or "O"+ "Numbers" such as "X5"
					}
				}
				System.out.println();
				
				//Place Chips
				for (int PlaceChips=13;PlaceChips<25;PlaceChips++){
					System.out.print(ChipsSetUpNumbers[PlaceChips][0]);
					System.out.print(ChipsSetUpNumbers[PlaceChips][1]);
					if (PlaceChips==18){
						for (int PrintEmptySpace=0;PrintEmptySpace<3;PrintEmptySpace++){
							System.out.print(" ");
						}
					}
					for (int PrintEmptySpace=0;PrintEmptySpace<2;PrintEmptySpace++){
						System.out.print(" ");
					}
				}
						
				System.out.println();
				
				for (int PrintSpace=0;PrintSpace<21;PrintSpace++){
					System.out.print(" ");
				}
				System.out.println();
						
				//Place Chips
				for (int PlaceChips=12;PlaceChips>0;PlaceChips--){
					System.out.print(ChipsSetUpNumbers[PlaceChips][0]);
					System.out.print(ChipsSetUpNumbers[PlaceChips][1]);
					if (PlaceChips==7){
						for (int PrintEmptySpace=0;PrintEmptySpace<3;PrintEmptySpace++){
							System.out.print(" ");
						}
					}
				    for (int PrintEmptySpace=0;PrintEmptySpace<2;PrintEmptySpace++){
						System.out.print(" ");
					}
				}
						
				System.out.println();
				
		//The board: Bottom frame
				for (int BottomLine =12; BottomLine>0; BottomLine--){
					if (BottomLine == 12 | BottomLine == 7 | BottomLine == 6 | BottomLine == 1){
						if(BottomLine ==7 | BottomLine ==6 | BottomLine ==1){
							System.out.print("0"+BottomLine);
						}
						else {
							System.out.print(BottomLine);
						}
						if (BottomLine == 12 | BottomLine == 6)
							System.out.print("--");
						else if (BottomLine == 1)
							System.out.print(" off");
						else
							System.out.print(" Bar ");
						
					}
					else{ 
						System.out.print("+");
						for (int PrintDash=0;PrintDash<3;PrintDash++){
							System.out.print("-");
						}
					}
				}
				//Invalid moves checking
				if (validmovechecking>=1){
					System.out.print("\nInvalid Move: " +
							"1. Cannot move X onto O or vice versa!"+
							" or 2. Cannot move from an empty place.");
				}
				System.out.println("\n");
				
	}
}
class Dice {
	// The number of spots on the visible face
		private int value;
		// The class pseudo random number generator
		private static Random random = new Random ();
		public Dice () {
			roll (); // Initial value is random
		}
	// Sets value to a number in the range 1 , 2 , 3 , ... , 6
		public void roll () {
			value = random.nextInt (6) + 1;
			
		}
	// Draws the visible face in text -based graphics
		public int value() {
				//System.out.println("+-------+");
				if ( value == 1) {
					return 1;
					/*System.out.println("|       |");
					System.out.println("|   *   |");
					System.out.println("|       |");*/
				} else if ( value == 2) {
					return 2;
					/*System.out.println("| *     |");
					System.out.println("|       |");
					System.out.println("|     * |");*/
				} else if ( value == 3) {
					return 3;
					/*System.out.println("|     * |");
					System.out.println("|   *   |");
					System.out.println("| *     |");*/
				} else if ( value == 4) {
					return 4;
					/*System.out.println("| *   * |");
					System.out.println("|	|");
					System.out.println("| *   * |");*/
				} else if ( value == 5) {
					return 5;
					/*System.out.println("| *   * |");
					System.out.println("|   *   |");
					System.out.println("| *   * |");*/
				} else if ( value == 6) {
					return 6;
					/*System.out.println("| * * * |");
					System.out.println("|       |");
					System.out.println("| * * * |");*/
				} else { // Defensive catch all:
					System.out.println(" *** Error : illegal die value ***");
				}
				//System.out.println("+-------+");
				return value;
				}
		}

