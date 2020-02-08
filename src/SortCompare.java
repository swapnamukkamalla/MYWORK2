/*NAME          :SWAPNA MUKKAMALLA
  DATE          :09-23-2019
  COURSE        :IT-516 DATA STRUCTURES AND ALGORITHMS
  HOMEWORK      :HW02
  TITLE         :SortCompare
  DESCRIPTION   :THIS APPLICATION INCLUDES SIX DIFFERENT SORT METHODS:
                 INSERTION,SELECTION,SHELL,MERGE,BOTTOM UP MERGE SORT AND
                 OPTIMIZED VERSION OF MERGE SORT.IT ALSO HAS COMPARATOR INTERFACE
                 TO SORT THE METHODS BY EXECUTION TIME.THIS CLASS ALSO HAS METHOD
                 WHICH RETURNS THE TIME ELAPSED FOR EACH SORT METHOD.*/

import edu.princeton.cs.algs4.*;
import java.util.Comparator;


public class SortCompare {
    String name;                   //CLASS VARIABLES FOR SORT NAME
    double time;                   //SORT TIME
    int[] die = new int[6];

    //comparator for sorting based on time
    static class Sortbytime implements Comparator<SortCompare> {
        //compare method to compare time
        public int compare(SortCompare a, SortCompare b) {
            if (a.time > b.time) {
                return 1;
            }
            if (a.time < b.time) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    //This method is called from timeRandomInput method
    //it returns the elapsed time
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("MergeBU")) MergeBU.sort(a);
        if (alg.equals("MergeX")) MergeX.sort(a);


        return timer.elapsedTime();
    }

    // This method is called from MultiCompare class and returns the run time for each sort method .

    public static double timeRandomInput(String alg, int n, int trials) {
        double total = 0.0;
        Double[] a = new Double[n];
        for (int t = 0; t < trials; t++) {
            for (int i = 0; i < n; i++)
                a[i] = StdRandom.uniform(0.0, 1.0);
            total += time(alg, a);          //calling the method time
        }
        return total;
    }

}
