/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package edu.neu.coe.info6205.sort.elementary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;

public class InsertionSort<X extends Comparable<X>> extends SortWithHelper<X> {

	/**
	 * Constructor for any sub-classes to use.
	 *
	 * @param description the description.
	 * @param N           the number of elements expected.
	 * @param config      the configuration.
	 */
	protected InsertionSort(String description, int N, Config config) {
		super(description, N, config);

	}

	/**
	 * Constructor for InsertionSort
	 *
	 * @param N      the number elements we expect to sort.
	 * @param config the configuration.
	 */
	public InsertionSort(int N, Config config) {
		this(DESCRIPTION, N, config);
	}

	public InsertionSort(Config config) {
		this(new BaseHelper<>(DESCRIPTION, config));
	}

	/**
	 * Constructor for InsertionSort
	 *
	 * @param helper an explicit instance of Helper to be used.
	 */
	public InsertionSort(Helper<X> helper) {
		super(helper);
	}

	public InsertionSort() {
		this(BaseHelper.getHelper(InsertionSort.class));
	}

	/**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
    public void sort(X[] xs, int from, int to) {
        final Helper<X> helper = getHelper();

       
        
        // END 
        
        for (int j = from; j < to-1; ++j) {  
            X key = xs[j];  
            int i = j+1;  
            while ( i>0 && helper.swapStableConditional(xs, i) ) {  
            	
            	
                  
                i--;  
            }  
            
        } 
        
        
        
        
    }
    
    public static void main(String[] args) {
    	
    	// N = 500
    	
    	Scanner scanner = null;
		try {
			scanner = new Scanner(new File("src/main/resources/num500.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer [] nums = new Integer [500];
		int i = 0;
		while(scanner.hasNextInt())
		{
		  nums[i++] = scanner.nextInt();
		  
		}
		
		
		BaseHelper<Integer> helper = null;
		try {
			helper = new BaseHelper<>("InsertionSort", 500, Config.load(InsertionSort.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SortWithHelper<Integer> sorter = new InsertionSort<>(helper);
        
		
        
        
		Benchmark_Timer<Integer[]> bm = new Benchmark_Timer<>("Insertion sort",  sorter::preProcess , sorter::sort, null);
    	
		
		double random500time = bm.run(nums, 1000);
		
		System.out.println("Time taken to sort 500 random elements:"+random500time);
		
		Arrays.sort(nums);
		
		double sorted500time = bm.run(nums,1000);
		
		System.out.println("Time taken to sort 500 sorted elements:"+sorted500time);
		
		Arrays.sort(nums,Collections.reverseOrder());
		
		double reverse500time = bm.run(nums,1000);
		
		System.out.println("Time taken to sort 500 reversly sorted elements:"+reverse500time);
		
		
		// N = 1000
    	
		try {
			scanner = new Scanner(new File("src/main/resources/num1000.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer [] nums1000 = new Integer [1000];
		i=0;
		while(scanner.hasNextInt())
		{
		  nums1000[i++] = scanner.nextInt();
		  
		}
		
		BaseHelper<Integer> helper1000 = null;
		try {
			helper1000 = new BaseHelper<>("InsertionSort", 1000, Config.load(InsertionSort.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SortWithHelper<Integer> sorter1000 = new InsertionSort<>(helper1000);
        
		
        
        
		Benchmark_Timer<Integer[]> bm1000 = new Benchmark_Timer<>("Insertion sort",  sorter1000::preProcess , sorter1000::sort, null);
		

    	
		
		double random1000time = bm1000.run(nums1000, 1000);
		
		System.out.println("Time taken to sort 1000 random elements:"+random1000time);
		
		Arrays.sort(nums1000);
		
		double sorted1000time = bm1000.run(nums1000,1000);
		
		System.out.println("Time taken to sort 1000 sorted elements:"+sorted1000time);
		
		Arrays.sort(nums1000,Collections.reverseOrder());
		
		double reverse1000time = bm1000.run(nums1000,1000);
		
		System.out.println("Time taken to sort 1000 reversly sorted elements:"+reverse1000time);
		
		
		// N=2000
		
		try {
			scanner = new Scanner(new File("src/main/resources/nums2000"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer [] nums2000 = new Integer [2000];
		i=0;
		while(scanner.hasNextInt())
		{
		  nums2000[i++] = scanner.nextInt();
		  
		}
		
		BaseHelper<Integer> helper2000 = null;
		try {
			helper2000 = new BaseHelper<>("InsertionSort", 2000, Config.load(InsertionSort.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SortWithHelper<Integer> sorter2000 = new InsertionSort<>(helper2000);
        
		
        
        
		Benchmark_Timer<Integer[]> bm2000 = new Benchmark_Timer<>("Insertion Sort",  sorter2000::preProcess , sorter2000::sort, null);
		

    	
		
		double random2000time = bm2000.run(nums2000, 1000);
		
		System.out.println("Time taken to sort 2000 random elements:"+random2000time);
		
		Arrays.sort(nums2000);
		
		double sorted2000time = bm2000.run(nums2000,1000);
		
		System.out.println("Time taken to sort 2000 sorted elements:"+sorted2000time);
		
		Arrays.sort(nums2000,Collections.reverseOrder());
		
		double reverse2000time = bm2000.run(nums2000,1000);
		
		System.out.println("Time taken to sort 2000 reversly sorted elements:"+reverse2000time);
		
		// N=4000
		
		try {
			scanner = new Scanner(new File("src/main/resources/nums4000"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer [] nums4000 = new Integer [4000];
		i=0;
		while(scanner.hasNextInt())
		{
		  nums4000[i++] = scanner.nextInt();
		  
		}
		
		BaseHelper<Integer> helper4000 = null;
		try {
			helper4000 = new BaseHelper<>("InsertionSort", 4000, Config.load(InsertionSort.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SortWithHelper<Integer> sorter4000 = new InsertionSort<>(helper4000);
        
		
        
        
		Benchmark_Timer<Integer[]> bm4000 = new Benchmark_Timer<>("Insertion Sort",  sorter4000::preProcess , sorter4000::sort, null);
		

    	
		
		double random4000time = bm4000.run(nums4000, 1000);
		
		System.out.println("Time taken to sort 4000 random elements:"+random4000time);
		
		Arrays.sort(nums4000);
		
		double sorted4000time = bm4000.run(nums4000,1000);
		
		System.out.println("Time taken to sort 4000 sorted elements:"+sorted4000time);
		
		Arrays.sort(nums4000,Collections.reverseOrder());
		
		double reverse4000time = bm4000.run(nums4000,1000);
		
		System.out.println("Time taken to sort 4000 reversly sorted elements:"+reverse4000time);
		
		// N=8000
		
		try {
			scanner = new Scanner(new File("src/main/resources/nums8000"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer [] nums8000 = new Integer [8000];
		i=0;
		while(scanner.hasNextInt())
		{
		  nums8000[i++] = scanner.nextInt();
		  
		}
		
		BaseHelper<Integer> helper8000 = null;
		try {
			helper8000 = new BaseHelper<>("InsertionSort", 8000, Config.load(InsertionSort.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SortWithHelper<Integer> sorter8000 = new InsertionSort<>(helper8000);
        
		
        
        
		Benchmark_Timer<Integer[]> bm8000 = new Benchmark_Timer<>("Insertion Sort",  sorter8000::preProcess , sorter8000::sort, null);
		

    	
		
		double random8000time = bm8000.run(nums8000, 1000);
		
		System.out.println("Time taken to sort 8000 random elements:"+random8000time);
		
		Arrays.sort(nums8000);
		
		double sorted8000time = bm8000.run(nums8000,1000);
		
		System.out.println("Time taken to sort 8000 sorted elements:"+sorted8000time);
		
		Arrays.sort(nums8000,Collections.reverseOrder());
		
		double reverse8000time = bm8000.run(nums8000,1000);
		
		System.out.println("Time taken to sort 8000 reversly sorted elements:"+reverse8000time);
		
		
		
    	
    	
    }

	public static final String DESCRIPTION = "Insertion sort";

	public static <T extends Comparable<T>> void sort(T[] ts) {
		new InsertionSort<T>().mutatingSort(ts);
	}
}
