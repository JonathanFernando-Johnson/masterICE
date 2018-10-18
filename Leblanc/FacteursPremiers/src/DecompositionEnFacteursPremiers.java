import java.util.ArrayList;
import java.util.List;

public class DecompositionEnFacteursPremiers {
	List<Integer> factors;

	public List<Integer> compute(int n) {
		this.factors = new ArrayList<Integer>();

		for (int facteurPremier = 2; facteurPremier < n; facteurPremier += 1) {
			for (; n % facteurPremier == 0; n /= facteurPremier) {
				this.factors.add(facteurPremier);				
			}
		}

		if (n > 1) {
			this.factors.add(n);
		}

		return factors;
	}
}