package warGame;

import java.util.Scanner;

public class WarGame {
	
	public static void main(String[] args) {		
		Scanner in = new Scanner(System.in);
		Intro intro = new Intro();
		StarText st = new StarText();
		War war;
		String p1, p2;
		String quit = "0";
		boolean gameEnd;
		boolean playAgain = true;
		
		System.out.println(st.toStarText(intro.getTitle()) + "\n");
		
		do {
			gameEnd = false;
			
			//print rules
			for(String rule : intro.getRules()) {
				System.out.println(rule);
			}//for
			
			System.out.print("\nPlayer 1 name: ");
			p1 = in.nextLine();
			System.out.print("\nPlayer 2 name: ");
			p2 = in.nextLine();
			war = new War(p1, p2);
			war.getDeck().shuffle();
			
			//Deal cards to start game
			war.start();
			System.out.println("\nBoth hands have been dealt.");
			System.out.println(war.getP1Name() + " has " + war.getP1Cards().size() + " cards to start.");
			System.out.println(war.getP2Name() + " has " + war.getP2Cards().size() + " cards to start.");
			
			while(!quit.equalsIgnoreCase("Q")) {
				System.out.printf("\n%s plays %s. %s plays %s\n", war.getP1Name(), war.getP1Cards().peek().toString(), war.getP2Name(), war.getP2Cards().peek().toString());
				
				switch(war.play()) {
				case E:
					System.out.println(war.getWinner() + " has WON the game!");
					gameEnd = true;
					quit = "Q";
					break;
				case W:
					System.out.println(war.getRndWinner() + " WON this hand.");
					break;
				case T:
					System.out.println("It's a tie! Each player lays 3 cards face down.");
					System.out.println("Kitty has " + war.getKitty().size() + " cards.");
					break;
				}//switch
				
				System.out.printf("%s has %d cards left.\n%s has %d cards left.\n", war.getP1Name(), war.getP1Cards().size(), war.getP2Name(), war.getP2Cards().size());
				
				if(!gameEnd) {
					System.out.print("\nPress any key to continue or Q to quit: ");
					quit = in.nextLine();
				}//if		
			}//while game loop
			
			if(gameEnd) {
				System.out.print("\nPress any key to play again or Q to quit: ");
				quit = in.nextLine();
			}//if		
		}while(!quit.equalsIgnoreCase("Q"));
		
		System.out.println("Thank you for playing the WAR GAME! Goodbye!");
	}//main
}//class WarGame
