package warGame;

/*
 * Change text to large letters written with stars. 
 * NOT part of assignment 3 wargame. Only used to write the title of the game
 * I coded this during my first semester at heritage
 * 
 * 
 * 
 */

public class StarText {
	
	private final String r1 = "*      ", r1c = "* *    ", c = "  *    ", r2l2 = " * *   ", r2 =" *     ", f = "* * *  ";
	private final String l2 = "   *   ", cl1 = "  * *  ", l1 = "    *  ", space = "   ",r1l1 = "*   *  ", e = "       ";
	private String line1, line2, line3, line4, line5, line6;
	
	public StarText() {
		
	}
	
	private void setLines(String ln1, String ln2, String ln3, String ln4, String ln5){
		line1 += ln1;
		line2 += ln2;
		line3 += ln3;
		line4 += ln4;
		line5 += ln5;
	}
	public String toStarText(String words) {	
		String letter;
		line1 = "";
		line2 = "";
		line3 = "";
		line4 = "";
		line5 = "";
		
		
		for (int x=0;x<words.length();x++) {
			letter = words.substring(x, x+1);
			switch(letter.toUpperCase()) {
			case "A":
				setLines(c, r1l1, f, r1l1, r1l1);
				break;
			case "B":
				setLines(r1c, r1l1, r1c, r1l1, r1c);
				break;
			case "C":
				setLines(cl1, r1, r1, r1, cl1);
				break;
			case "D":
				setLines(r1c, r1l1, r1l1, r1l1, r1c);
				break;
			case "E":
				setLines(f, r1, r1c, r1, f);
				break;
			case "F":
				setLines(f, r1, r1c, r1, r1);
				break;
			case "G":
				setLines(cl1, r1, "*  **  ", r1l1, cl1);
				break;
			case "H":
				setLines(r1l1, r1l1, f, r1l1, r1l1);
				break;
			case "I":
				setLines("***  ", " *   ", " *   ", " *   ", "***  ");
				break;
			case "J": 
				setLines("  ***  ", l2, l2,"*  *   ", " **    ");
				break;
			case "K":
				setLines(r1l1, r1c, "**     ", r1c, r1l1);
				break;
			case "L":
				setLines(r1, r1, r1, r1, f);
				break;
			case "M":
				setLines(" ** **   ", "*  *  *  ", "*  *  *  ", "*     *  ", "*     *  ");
				break;
			case "N":
				setLines("**  *  ", f, f, f, "*  **  ");
				break;
			case "O":
				setLines(r2l2, r1l1, r1l1, r1l1, r2l2);
				break;
			case "P":
				setLines(r1c, r1l1, r1c, r1, r1);
				break;
			case "Q":
				setLines(r2l2, r1l1, r1l1, r2l2, l1);
				break;
			case "R":
				setLines(r1c, r1l1, r1c, "*  *   ", r1l1);
				break;
			case "S":
				setLines(cl1, r1, c, l1, r1c);
				break;
			case "T":
				setLines(f, c, c, c, c);
				break;
			case "U":
				setLines(r1l1, r1l1, r1l1, r1l1, r2l2);
				break;
			case "V":
				setLines(r1l1, r1l1, r1l1, r2l2, c);
				break;
			case "W":
				setLines("*     *  ", "*     *  ", "*  *  *  ", " * * *   ", "  * *    ");
				break;
			case "X":
				setLines(r1l1, r2l2, c, r2l2, r1l1);
				break;
			case "Y":
				setLines(r1l1, r2l2, c, c, c);
				break;
			case "Z":
				setLines(f, l2, c, r2, f);
				break;
			case " ":
				setLines(space, space, space, space, space);
				break;
			case ".":
				setLines(space, space, space, space, "*  ");
				break;
			case "?":
				setLines(c, r1l1, l2, e, l2);
				break;
			case "!":
				setLines("*  ", "*  ", "*  ",space, "*  ");
				break;
			case "0":
				setLines(r2l2, "*  **  ", f, "**  *  ",r2l2);
				break;
			case "1":
				setLines(" *   ", "**   ", " *   ", " *   ", "***  ");
				break;
			case "2":
				setLines(r1c, l1, c, r1, f);
				break;
			case "3":
				setLines(r1c, l1, " **    ", l1, r1c);
				break;
			case "4":
				setLines(r1l1, r1l1, f, l1, l1);
				break;
			case "5":
				setLines(f, r1, r1c, l1, r1c);
				break;
			case "6": 
				setLines(c, r1, r1c, r1l1, c);
				break;
			case "7":
				setLines(f, l2, c, r2, r1);
				break;
			case "8":
				setLines(c, r1l1, r2l2, r1l1, c);
				break;
			case "9":
				setLines(c, r1l1, cl1, l1, c);
				break;
			default:
				setLines(e, e, e, e, e);
			}
		}
		return (line1+"\n"+line2+"\n"+line3+"\n"+line4+"\n"+line5);
	}
}