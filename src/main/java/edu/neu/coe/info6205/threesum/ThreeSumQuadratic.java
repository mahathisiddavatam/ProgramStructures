
package edu.neu.coe.info6205.threesum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

import edu.neu.coe.info6205.util.Stopwatch;

/**
 * Implementation of ThreeSum which follows the approach of dividing the
 * solution-space into N sub-spaces where each sub-space corresponds to a fixed
 * value for the middle index of the three values. Each sub-space is then solved
 * by expanding the scope of the other two indices outwards from the starting
 * point. Since each sub-space can be solved in O(N) time, the overall
 * complexity is O(N^2).
 * <p>
 * NOTE: The array provided in the constructor MUST be ordered.
 */
public class ThreeSumQuadratic implements ThreeSum {
	/**
	 * Construct a ThreeSumQuadratic on a.
	 * 
	 * @param a a sorted array.
	 */
	public ThreeSumQuadratic(int[] a) {
		this.a = a;
		length = a.length;
	}

	public Triple[] getTriples() {
		List<Triple> triples = new ArrayList<>();
		for (int i = 0; i < length; i++) {

			triples.addAll(getTriples(i));

		}
		Collections.sort(triples);

		return triples.stream().distinct().toArray(Triple[]::new);
	}

	/**
	 * Get a list of Triples such that the middle index is the given value j.
	 *
	 * @param j the index of the middle value.
	 * @return a Triple such that
	 */
	public List<Triple> getTriples(int j) {

		List<Triple> triples = new ArrayList<>();

		// Get initial left and right values
		int left = j - 1;
		int right = j + 1;
		while (left >= 0 && right < length) {
			// And then, using the sum of a[left], a[right], a[j], figure out if we need to
			int sum = a[left] + a[right] + a[j];
			if (sum == 0) {
				triples.add(new Triple(a[left], a[right], a[j]));
				left--;
				right++;
			} else if (sum > 0) {
				left--;
			} else if (sum < 0) {
				right++;
			}
		}

		return triples;
	}

	public static void main(String args[]) {
    	
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("src/main/resources/nums8000"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int [] nums = new int [8000];
		int i = 0;
		while(scanner.hasNextInt())
		{
		  nums[i++] = scanner.nextInt();
		}

		try (Stopwatch watch = new Stopwatch()) {
			Arrays.sort(nums);
			ThreeSumQuadratic target = new ThreeSumQuadratic(nums);
			Triple[] triples = target.getTriples();
			long time = watch.lap();
			System.out.println("N=8000");
			System.out.println("Time taken:"+time+"ms");
		}
		
	    }

	// for

	// Supplier<int[]> intsSupplier = new Source(10, 15, 2L).intsSupplier(3);
	// int[] ints = intsSupplier.get();

	private final int[] a;
	private final int length;
}