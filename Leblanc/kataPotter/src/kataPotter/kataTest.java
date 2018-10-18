package kataPotter;

import static org.junit.Assert.*;

import org.junit.Test;

public class kataTest {

	@Test
	public void testBasicBookPrice() {
		assertEquals(8.00, new Books(1, 0, 0, 0, 0).calculatePrice(), 0.0001);
	}
	@Test
	public void testBasicBookPriceMultipleBooks() {
		assertEquals(80.00, new Books(10, 0, 0, 0, 0).calculatePrice(), 0.0001);
	}
	@Test
	public void testBasicBookPriceMultipleBooks2() {
		assertEquals(64.00, new Books(0, 0, 0, 8, 0).calculatePrice(), 0.0001);
	}
	
	@Test
	public void testEmptyBasket() {
		assertEquals(00.00, new Books(0, 0, 0, 0, 0).calculatePrice(), 0.0001);
	}
	
	@Test
	public void testfiveDifferentBooks() {
		assertEquals(30.00, new Books(1, 1, 1, 1, 1).calculatePrice(), 0.0001);
	}
	
	@Test
	public void testFourDifferentBooks() {
		assertEquals(23.60, new Books(1, 1, 0, 1, 1).calculatePrice(), 0.0001);
	}
	
	@Test
	public void testThreeDifferentBooks() {
		assertEquals(51.20, new Books(2,2,2,1,1).calculatePrice(), 0.0001);
	}

}
