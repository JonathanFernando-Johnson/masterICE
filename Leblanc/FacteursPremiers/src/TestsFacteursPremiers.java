import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestsFacteursPremiers {
	private DecompositionEnFacteursPremiers d;

	@Before
	public void setUp() throws Exception {
		this.d = new DecompositionEnFacteursPremiers();
	}

	@After
	public void tearDown() throws Exception {
		this.d = null;
	}

	@Test
	public void UnNapasDeFacteursPremiers() {
		assertEquals(Arrays.asList(), d.compute(1));
	}

	@Test
	public void DeuxAUnFacteurPremierDeux() {
		assertEquals(Arrays.asList(2), d.compute(2));
	}
	
	@Test
	public void TroisAUnFacteurPremierTrois() {
		assertEquals(Arrays.asList(3), d.compute(3));
	}
	
	@Test
	public void QuatreADeuxFacteurPremierDeuxEtDeux() {
		assertEquals(Arrays.asList(2,2), d.compute(4));
	}
	
	@Test
	public void CinqAUnFacteurPremierCinq() {
		assertEquals(Arrays.asList(5), d.compute(5));
	}
	
	@Test
	public void SixADeuxFacteurPremierDeuxEtTrois() {
		assertEquals(Arrays.asList(2,3), d.compute(6));
	}
	
	@Test
	public void HuitATroisFacteurPremierDeuxEtDeuxEtDeux() {
		assertEquals(Arrays.asList(2,2,2), d.compute(8));
	}
	
	@Test
	public void NeufADeuxFacteurPremierTroisEtTrois() {
		assertEquals(Arrays.asList(3,3), d.compute(9));
	}
	
	@Test
	public void DixADeuxFacteurPremierDeuxEtCinq() {
		assertEquals(Arrays.asList(2,5), d.compute(10));
	}
	
	@Test
	public void QuaranteDeuxATroisFacteurPremierDeuxTroisSept() {
		assertEquals(Arrays.asList(2,3,7), d.compute(42));
	}
}