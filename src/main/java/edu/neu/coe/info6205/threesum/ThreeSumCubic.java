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
 * Implementation of ThreeSum which follows the brute-force approach of
 * testing every candidate in the solution-space.
 * The array provided in the constructor may be randomly ordered.
 * <p>
 * This algorithm runs in O(N^3) time.
 */
class ThreeSumCubic implements ThreeSum {
    /**
     * Construct a ThreeSumCubic on a.
     * @param a an array.
     */
    public ThreeSumCubic(int[] a) {
        this.a = a;
        length = a.length;
    }

    public Triple[] getTriples() {
        List<Triple> triples = new ArrayList<>();
        for (int i = 0; i < length; i++)
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (a[i] + a[j] + a[k] == 0)
                        triples.add(new Triple(a[i], a[j], a[k]));
                }
            }
        Collections.sort(triples);
        return triples.stream().distinct().toArray(Triple[]::new);
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
    		ThreeSumCubic target = new ThreeSumCubic(nums);
    		Triple[] triples = target.getTriples();
    		long time = watch.lap();
    		System.out.println("N=8000");
    		System.out.println("Time taken:"+time+"ms");
    	}
    	
        }

    private final int[] a;
    private final int length;
}
