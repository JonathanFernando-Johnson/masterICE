package kataPotter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Books {
	ArrayList<Integer> bookList;
	double finalPrice = 0.0;

	Books(int NumberFirstBook, int NumberSecondBook, int NumberThirdBook, int NumberFourthBook, int NumberFifthBook) {
		bookList = new ArrayList<Integer>(5);
		bookList.add(NumberFirstBook);
		bookList.add(NumberSecondBook);
		bookList.add(NumberThirdBook);
		bookList.add(NumberFourthBook);
		bookList.add(NumberFifthBook);
	}

	public double calculatePrice() {
		
		// final condition
		if (bookList.get(0) == 0 && bookList.get(1) == 0 && bookList.get(2) == 0 && bookList.get(3) == 0
				&& bookList.get(4) == 0) {
			System.out.println(finalPrice);
			return finalPrice;
		}
		
		// are they all of the same type ?
		for (int i = 0; i < 5; i++) {
			if (bookList.get(i) > 0 && bookList.get((i + 1) % 5) == 0 && bookList.get((i + 2) % 5) == 0
					&& bookList.get((i + 3) % 5) == 0 && bookList.get((i + 4) % 5) == 0) {
				finalPrice += 8.00 * bookList.get(i);
				bookList.set(i, 0);
				return calculatePrice();
			}
		}
		
		// find biggest discount set
		
		// if there is no number that is zero, there are five different books ==> 25% discount
		if (bookList.get(0) > 0 && bookList.get(1) > 0 && bookList.get(2) > 0 && bookList.get(3) > 0
				&& bookList.get(4) > 0) {
			finalPrice += 30.00;
			for (int i = 0; i < 5; i++)
				bookList.set(i, bookList.get(i) - 1);
			return calculatePrice();

		}
		
		// if there is one number that is zero, there are four different books ==> 20% discount
		for (int i = 0; i < 5; i++) {
			if (bookList.get(i) == 0 && bookList.get((i + 1) % 5) != 0 && bookList.get((i + 2) % 5) != 0
					&& bookList.get((i + 3) % 5) != 0 && bookList.get((i + 4) % 5) != 0) {
				finalPrice += 23.60;
				for (int j = 0; j < 5; j++) {
					if (bookList.get(j) != 0)
						bookList.set(j, bookList.get(j) - 1);
				}
				return calculatePrice();
			}
		}
		//set for all indexes of array
		Set<Integer> allIndexes = new HashSet<Integer>();
		allIndexes.addAll(Arrays.asList(new Integer[] {0,1,2,3,4})); 
		// if there are two numbers that are zero, there are three different books ==> 10% discount
		for (int k = 0; k < 5; k++) {
			
			for (int i = ((k + 1) % 5); i < 5; i++) {
				Set<Integer> currentIndexPos = new HashSet<Integer>();
				currentIndexPos.addAll(Arrays.asList(k,i));
				Set<Integer> difference = new HashSet<Integer>(allIndexes);
				difference.removeAll(currentIndexPos);
				Integer[] a = difference.toArray(new Integer[difference.size()]);
				if (bookList.get(k) == 0 && bookList.get((i)) == 0 && bookList.get(a[0]) != 0
						&& bookList.get(a[1]) != 0 && bookList.get(a[2]) != 0) {
					
					finalPrice += 21.60;
					for (int j = 0; j < 5; j++) {
						if (j != k && j!=i)
							bookList.set(j, bookList.get(j) - 1);
					}
					return calculatePrice();
				}
			}
		}
		// if there are three numbers that are zero, there are two different books ==> 5% discount
		
		// calculate price of the rest
		return 0.0;
	}
}
