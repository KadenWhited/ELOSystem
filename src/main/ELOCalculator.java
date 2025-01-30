package main;

import java.util.Scanner;

public class ELOCalculator {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		//Variables
		
		String player1Name = "Matt";
		String player2Name = "Mawin";
		String player3Name = "Kaden";
		
		String playerA = "";
		String playerB = "";
		
		double base = 1500.0;
		double playerARating = base;
		double playerBRating = base;
		
		double KFactor = 32; // 32 For Weak Players, 16 For Professional
		
		double actualWinLossA = 0;
		double actualWinLossB = 0;

		
		//Initialize Player A

		System.out.println("Enter Player 1 Name: ");
		String InputPlayer1 = in.next();
		
		if (InputPlayer1.equals(player1Name)) {
			
			playerA = player1Name;
		}
		
		else if (InputPlayer1.equals(player2Name)) {
			
			playerA = player2Name;
		}
		
		else if (InputPlayer1.equals(player3Name)) {
			
			playerA = player3Name;
		}
		
		else {
			System.out.println("ERROR, Name Not Recognized for Simulation!");
		}
		
		System.out.println("Player 1: " + playerA);
		
		//Initialize Player B
		
		System.out.println("Enter Player 2 Name: ");
		String InputPlayer2 = in.next();
		
		if (InputPlayer2.equals(player1Name)) {
			
			playerB = player1Name;
		}
		
		else if (InputPlayer2.equals(player2Name)) {
			
			playerB = player2Name;
		}
		
		else if (InputPlayer2.equals(player3Name)) {
			
			playerB = player3Name;
		}
		
		else {
			System.out.println("ERROR, Name Not Suitable for Simulation!");
			System.exit(0);
		}
		
		System.out.println("Player 2: " + playerB);
		
		if (playerA.equals(playerB)) {
			System.out.println("ERROR, Duplicate Name Detected!");
			System.exit(0);
		}
		
		//Beginning Simulated Win/Loss
		
		while (true) {
			double playerAInitialRating = playerARating;
			double playerBInitialRating = playerBRating;
			
			//Predict Player Ratings Based on Formula
			double expectedWinLossA = (1.0/(1.0 + Math.pow(10.0, (playerBRating - playerARating)/400.0)));
			double expectedWinLossB = (1.0/(1.0 + Math.pow(10.0, (playerARating - playerBRating)/400.0)));
			
			//Determine Actual Score from User
			
			System.out.println("Did " + playerA + " Win? Enter 'WIN', 'LOSS', or 'DRAW'");
			String userWinLossDraw = in.next();
			
			
			if (userWinLossDraw.equalsIgnoreCase("DRAW")) {
				actualWinLossA = 0.5;
				actualWinLossB = 0.5;
				
				playerARating = playerARating + KFactor * (actualWinLossA - expectedWinLossA);
				playerBRating = playerBRating + KFactor * (actualWinLossB - expectedWinLossB);
			}
			
			else if (userWinLossDraw.equalsIgnoreCase("WIN")) {
				actualWinLossA = 1;
				actualWinLossB = 0;
				
				playerARating = playerARating + KFactor * (actualWinLossA - expectedWinLossA);
				playerBRating = playerBRating + KFactor * (actualWinLossB - expectedWinLossB);
			}
			
			else if (userWinLossDraw.equalsIgnoreCase("LOSS")){
				actualWinLossA = 0;
				actualWinLossB = 1;
				 
				playerARating = playerARating + KFactor * (actualWinLossA - expectedWinLossA);
				playerBRating = playerBRating + KFactor * (actualWinLossB - expectedWinLossB);
			}
			
			else {
				System.out.println("ERROR! PLEASE ENTER VALID TYPE! 'WIN', 'LOSS', or 'DRAW'! ELO UNCHANGED!");
			}
			
			System.out.println(playerA + ": " + Math.round(playerARating) + "      ELO CHANGE: " + Math.round(playerARating - playerAInitialRating));
			System.out.println(playerB + ": " + Math.round(playerBRating) + "      ELO CHANGE: " + Math.round(playerBRating - playerBInitialRating));
			
		}

		
	}
	
}