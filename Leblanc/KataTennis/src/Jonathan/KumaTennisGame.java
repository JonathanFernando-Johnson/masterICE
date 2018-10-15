package Jonathan;
public class KumaTennisGame implements EmilyBache.TennisGame{
	
	private int scorePlayer1;
	private int scorePlayer2;
	public static final String tabScores[] = {"Love","Fifteen", "Thirty", "Forty"};
	private String player1Name;
    private String player2Name;
	
	public KumaTennisGame() {
		this.scorePlayer1 = 0;
		this.scorePlayer2 = 0;
	}
	
	public KumaTennisGame(String player1Name, String player2Name) {
		this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.scorePlayer1 = 0;
		this.scorePlayer2 = 0;
    }
	
	public String currentScore() {
		if (this.player1Won()) {
			return "Win for player1";
		}
		
		if (this.player2Won()) {
			return "Win for player2";
		}
		
		if (this.gameThatLastsALongTime()) {
			return this.DeuceOrAdvantage();
		}
		
		if (this.scorePlayer1 == this.scorePlayer2) {
			if (this.scorePlayer1 < 3) {
				return tabScores[this.scorePlayer1] + "-All";
			}
			return this.DeuceOrAdvantage();
		}
		
		return tabScores[this.scorePlayer1] + "-" + tabScores[this.scorePlayer2];
	}
	
	private String DeuceOrAdvantage() {
		if (this.scorePlayer1 == this.scorePlayer2) {
			return "Deuce";
		}	
		
		if (this.scorePlayer1 > this.scorePlayer2) {
			return ("Advantage player1");
		}
		
		return ("Advantage player2");
	}
	
	private boolean gameThatLastsALongTime() {
		return (this.scorePlayer1 >=3 && this.scorePlayer2 >=3);
	}
	
	private boolean player1Won() {
		return playerWon(this.scorePlayer1,this.scorePlayer2);
	}
	
	private boolean player2Won() {
		return playerWon(this.scorePlayer2,this.scorePlayer1);
	}
	
	private boolean playerWon(int score1, int score2) {
		return (score1 >=4 && score1 - score2 >= 2);
	}
	
	public void player1Scores() {
		this.scorePlayer1+=1;
	}
	
	public void player2Scores() {
		this.scorePlayer2+=1;
	}
	
	/*Fonctions supplémentaire pour pouvoir passer le test d'Emily*/
	
	public void wonPoint(String playerName) {
        if (playerName == "player1")
        	player1Scores();
        else
        	player2Scores();
    }
	
	public String getScore() {
		return currentScore();
	}
}