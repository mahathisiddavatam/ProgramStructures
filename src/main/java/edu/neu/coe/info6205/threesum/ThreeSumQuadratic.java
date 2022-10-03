
package edu.neu.coe.info6205.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of ThreeSum which follows the approach of dividing the solution-space into
 * N sub-spaces where each sub-space corresponds to a fixed value for the middle index of the three values.
 * Each sub-space is then solved by expanding the scope of the other two indices outwards from the starting point.
 * Since each sub-space can be solved in O(N) time, the overall complexity is O(N^2).
 * <p>
 * NOTE: The array provided in the constructor MUST be ordered.
 */
public class ThreeSumQuadratic implements ThreeSum {
    /**
     * Construct a ThreeSumQuadratic on a.
     * @param a a sorted array.
     */
    public ThreeSumQuadratic(int[] a) {
        this.a = a;
        length = a.length;
    }

    public Triple[] getTriples() {
        List<Triple> triples = new ArrayList<>();
        Arrays.sort(a);
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
        
        int left = (j - (int) length/2) + 1;
        int right = length-1;
        
        
        
        while(left<=right) {
        	
        	
        	if(right<length -1 && a[right]==a[right+1]) {
        		
        		right--;
        	}
        	if( a[j] + a[left]+ a[right] > 0) {
        		
        			
        		right--;
        	}
        	else if(a[j]+a[left]+a[right]<0) {
        		
        		
        		left++;
        		
        	}
        	
        	else {
        		
        	
        		
        		triples.add(new Triple(a[j],a[left],a[right]));
        		left++;
        		right--;
        	}
        }
        
        return triples;
    }
    
   public static void main(String args[]) {
    	
    	int[] a = {30,-40,-20,-10,40,0,10,5};
    	Arrays.sort(a);
    	
    	ThreeSumQuadratic target = new ThreeSumQuadratic(a);
    	List<Triple> trip = target.getTriples(3);
    	System.out.println(trip);
    }
   

    private final int[] a;
    private final int length;
}
