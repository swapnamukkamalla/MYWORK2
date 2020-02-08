/*NAME          :SWAPNA MUKKAMALLA
  DATE          :09-23-2019
  COURSE        :IT-516 DATA STRUCTURES AND ALGORITHMS
  HOMEWORK      :HW02
  TITLE         :MultiCompare
  DESCRIPTION   :This application gets the run time for all the sort methods mentioned
                 and compare  the sort methods with the same size of random number
                     samples and trials.It then SORT those results to get a better understanding
                     of which sort methods perform best for these types of number sets.*/

import java.util.*;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;

public class MultiCompare {


    public static void main(String[] args) {
        int n = 10000;                          // Number of random numbers generated for each test
        int trials = 100;                       // Number of trials for each test
        String[] sortTypes = new String[6];     // Array to store different sort types
        sortTypes[0] = "Insertion";             //All this sort types are defined in SortCompare.java
        sortTypes[1] = "Selection";
        sortTypes[2] = "Shell";
        sortTypes[3] = "Merge";
        sortTypes[4] = "MergeBU";
        sortTypes[5] = "MergeX";


        Double[] sortTimes = new Double[6];     // Array to store the execution time for each sort type
        SortCompare[] s = new SortCompare[6];   //Array to store SortCompare variables name and time



        // header displaying the number of random numbers and trails
        StdOut.println("Running " + trials + " trials of " + n + " random numbers each...");
        StdOut.println("--------------------------------------------------");

        // Performing each of the sort methods  in the sortTypes array...
        //calling the timeRandomInput method to get the run time bypassing sort type ,number of
        // random number and trails.
        for (int i = 0; i <= sortTypes.length - 1; i++) {
            sortTimes[i] = SortCompare.timeRandomInput(sortTypes[i], n, trials);
        }


        //creating the array of sortCompare objects
        for ( int i=0; i<s.length; i++) {
            s[i]=new SortCompare();
        }

        //Displaying the header before sorting
        StdOut.println("------------------------------------------------- ");
        StdOut.println("...............BEFORE SORTING.................... ");
        StdOut.println("------------------------------------------------- ");

        //Displaying the sort types and sort times before sorting them.
        //Copying the sort types and sort times from different arrays into a array of SortCompare objects
        //which includes both sort name and time for sorting purpose.
        for (int i = 0; i <= sortTypes.length - 1; i++) {
            String pad = new String();
            s[i].name = sortTypes[i];
            s[i].die[0] = 1;
            for (int c = 12 - sortTypes[i].length(); c > 0; c--) {
                pad += " ";
            }
            s[i].time = sortTimes[i];
            StdOut.print(pad + sortTypes[i]);
            if (sortTimes[i] < 0.1) {
                StdOut.println(" < 1/10 second (avg)");
            } else if (sortTimes[i] < 10){
                StdOut.printf(" =  %.3f seconds (avg)\n", sortTimes[i]);
            } else{
                StdOut.printf(" = %.3f seconds (avg)\n", sortTimes[i]);
            }
        }

        //Displaying the header for after sorting the methods based on time.
        StdOut.println("------------------------------------------------- ");
        StdOut.println("...........AFTER SORTING BY TIME................. ");
        StdOut.println(".......SORT TYPES FROM FASTEST TO SLOWEST........ ");
        StdOut.println("------------------------------------------------- ");

        //calling the comparator Sortbytime to sort the array based on the time
     Arrays.sort(s, new SortCompare.Sortbytime());

       //Displaying the sort methods from fastest to slowest  along with their run time
        for(int i=0;i<s.length;i++)
        {
            String pad = new String();
            for (int c = 12 - s[i].name.length(); c > 0; c--) {
                pad += " ";
            }
            StdOut.print(pad + s[i].name);
            if (s[i].time < 0.1) {
                StdOut.println(" < 1/10 second (avg)");
            } else if (s[i].time < 10) {
                StdOut.printf(" =  %.3f seconds (avg)\n", s[i].time);
            } else {
                StdOut.printf(" = %.3f seconds (avg)\n", s[i].time);
            }

        }

    }
}
