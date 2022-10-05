package edu.neu.coe.info6205.threesum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import edu.neu.coe.info6205.util.Stopwatch;

/**
 * Implementation of ThreeSum which follows the simple optimization of
 * requiring a sorted array, then using binary search to find an element x where
 * -x the sum of a pair of elements.
 * <p>
 * The array provided in the constructor MUST be ordered.
 * <p>
 * This algorithm runs in O(N^2 log N) time.
 */
class ThreeSumQuadrithmic implements ThreeSum {
    /**
     * Construct a ThreeSumQuadrithmic on a.
     * @param a a sorted array.
     */
    public ThreeSumQuadrithmic(int[] a) {
        this.a = a;
        length = a.length;
    }

    public Triple[] getTriples() {
        List<Triple> triples = new ArrayList<>();
        for (int i = 0; i < length; i++)
            for (int j = i + 1; j < length; j++) {
                Triple triple = getTriple(i, j);
                if (triple != null) triples.add(triple);
            }
        Collections.sort(triples);
        return triples.stream().distinct().toArray(Triple[]::new);
    }

    public Triple getTriple(int i, int j) {
        int index = Arrays.binarySearch(a, -a[i] - a[j]);
        if (index >= 0 && index > j) return new Triple(a[i], a[j], a[index]);
        else return null;
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
		ThreeSumQuadrithmic target = new ThreeSumQuadrithmic(nums);
		Triple[] triples = target.getTriples();
		long time = watch.lap();
		System.out.println("N=8000");
		System.out.println("Time taken:"+time+"ms");
	}
	
    }
    

    private final int[] a;
    private final int length;
}
