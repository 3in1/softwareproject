import java.util.Random;
public class Dice {
// The number of spots on the visible face
	private int value;
	// The class ’s pseudorandom number generator
	private static Random random = new Random ();
	public Dice () {
		roll (); // Initial value is random
	}
// Sets value to a number in the range 1 , 2 , 3 , ... , 6
	public void roll () {
		value = random.nextInt (6) + 1;
	}
// Draws the visible face in text -based graphics
	public int show() {
			if ( value == 1) {
				return 1;
				
			} else if ( value == 2) {
				return 2;
				
			} else if ( value == 3) {
				return 3;
				
			} else if ( value == 4) {
				return 4;
				
			} else if ( value == 5) {
				return 5;
				
			} else if ( value == 6) {
				return 6;
				
			} else { // Defensive catch all:
				System.out.println(" *** Error : illegal die value ***");
			}
			
			return value;
			}
	}

