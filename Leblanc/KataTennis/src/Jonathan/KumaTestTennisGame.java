package Jonathan;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KumaTestTennisGame {

	private KumaTennisGame partie;
	
	@Before
	public void setUp() throws Exception {
		this.partie = new KumaTennisGame();
	}

	@After
	public void tearDown() throws Exception {
		this.partie = null;
	}
	
	private void setterScore(int score1, int score2) {
		for(int i=0; i<score1; i++) {
			this.partie.player1Scores();
		}
		for(int j=0; j<score2; j++) {
			this.partie.player2Scores();
		}
	}
	
	@Test
	public void testCurrentScore40Player130Player2() {
		setterScore(3, 2);
		assertEquals("Forty-Thirty", this.partie.currentScore());
	}

	@Test
	public void testCurrentScoreLoveAll() {
		setterScore(0, 0);
		assertEquals("Love-All", this.partie.currentScore());
	}
	
	@Test
	public void testCurrentScoreThirtyAll() {
		setterScore(2, 2);
		assertEquals("Thirty-All", this.partie.currentScore());
	}
	
	@Test
	public void testCurrentScorePlayer1Won() {
		setterScore(4, 1);
		assertEquals("Win for player1", this.partie.currentScore());
	}
	
	@Test
	public void testCurrentScorePlayer2Won() {
		setterScore(1, 4);
		assertEquals("Win for player2", this.partie.currentScore());
	}
	
	@Test
	public void testCurrentScoreDeuce() {
		setterScore(6, 6);
		assertEquals("Deuce", this.partie.currentScore());
	}
	
	@Test
	public void testCurrentScorePlayer1Advantage() {
		setterScore(5, 4);
		assertEquals("Advantage player1", this.partie.currentScore());
	}
	
	@Test
	public void testCurrentScorePlayer1WinAdvantage() {
		setterScore(6, 4);
		assertEquals("Win for player1", this.partie.currentScore());
	}
	
	@Test
	public void testCurrentScorePlayer2Advantage() {
		setterScore(4, 5);
		assertEquals("Advantage player2", this.partie.currentScore());
	}
	
	@Test
	public void testCurrentScorePlayer2WinAdvantage() {
		setterScore(4, 6);
		assertEquals("Win for player2", this.partie.currentScore());
	}

}
