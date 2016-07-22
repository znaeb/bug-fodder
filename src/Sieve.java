import java.util.ArrayList;

/**
 * @author MIT
 * @author Bill Laboon
 * @author Benjamin Nimchinsky.
 */
public class Sieve {
  /**
   * max is highest number to be checked if prime.
   */
  private static int max;

  /**
   * "Debug" version of printSieve.  This will show all numbers
   * along with their T/F mark of primality.
   * @param results - list of ints from 1 to n
   * @param prime - boolean array indicating primality
   */
  public static void printSieve(final int[] results, final boolean[] prime) {
    System.out.print("> ");
    char eerie;
    // Just loop through the array and print the values.
    // Put a (T) after each one if it has been marked
    // prime; put a (F) after one if it has  been marked
    // composite (not prime).

    for (int j = 0; j < results.length;j++) {
      eerie = prime[j] ? 'T' : 'F';
      System.out.print(results[j] + "(" + eerie + ") ");
    }
    System.out.println();
  }

  /**
   * Prints out an array which should contain all prime values.
   * Really, will print out any array.
   * @param results array of ints to print out
   */

  public static void printSieve(int[] results) {
    // As long as there are elements in the array,
    // print it.  Otherwise, print "BLANK".
    if (results == null) {
      System.out.println("BLANK");
    } else if (results.length == 0) {
      System.out.println("BLANK");
    } else {
      System.out.print("> ");
      for (int j = 0; j < results.length;j++) {
        System.out.print(results[j] + " ");
      }
    }
  }

  /**
   * @param size the size of the array to return.
   * @return an array of booleans filled with only true values 
   */

  public static boolean[] getTrueArray(int size) {
    boolean[] toReturn = new boolean[size];
    for (int j = 0; j < size; j++) {
      toReturn[j] = true;
    }
    // Return an all-true array.
    return toReturn;
  }

  /**
   * Convert our "behind the scenes" arrays - the list of ints from
   * 1 to n and the same-size array which indicates their primality -
   * into a simple array of all prime values.
   * @param results an array with all ints from 1 to n
   * @param prime an array boolean indicating whether the same index value in results is prime
   * @return int[] the prime numbers from 1 to n 
   */

  public static int[] convertResults(int[] results, boolean[] prime ) {

    // Create an ArrayList. If a value is true for primality,
    //add it to the array list.

    ArrayList<Integer> actual = new ArrayList<>();
    for (int j = 0; j < results.length; j++) {
      if (prime[j]) {
        actual.add(j + 1);
      }
    }

    // Since we want to turn this back into a plain old array
    // of ints, create an array of the same size as the ArrayList.
    // Then add each element from the ArrayList into the proper
    // (sorted ascending) location in the returned array.

    // Note that the elements in the ArrayList are Integers, and
    // the toReturn variable is an int array, but Java will
    // automatically convert thanks to autoboxing as long as
    // you are using Java 1.5 or higher.

    int[] toReturn = new int[actual.size()];

    for (int j = 0; j < actual.size(); j++) {
      toReturn[j] = actual.get(j);
    }
    return toReturn;
  }

  /**
   * Given an array of ints, starting at 1, calculate which ones 
   * are prime using the Sieve2 of Eratosthenes.
   * Uncomment println statements to watch it work.
   * @param results array of ints starting at 1
   * @return int[] array of all prime ints
   */

  public static int[] calculateSieve(int[] results) {
    int ptr = 1; // means value 2
    int size = results.length;    
    // At this point, assume all numbers are prime.
    boolean[] prime = getTrueArray(size);
    if (size>0)prime[0]=false;
    while (ptr < Math.sqrt(results.length)) {
      // if this number is marked false, ignore it - all other
      // numbers which are multiples of it will also already
      // be marked false
      // Otherwise, loop through and look for any multiples of
      // it, which should now be marked false
      if (prime[ptr] == true) {
        int val = results[ptr]; // value pointed at 
        int localPtr = ptr; // secondary pointer
        int counter = 2; // multiple counter
        int comp; // computer value
        // System.out.println("Ptr = " + ptr + ",  val = " + val);

        // Loop through the rest of the loop (starting past ptr,
        // which is what localPtr is equal to now) and look for
        // any multiples of that number.

        // These numbers are composite, so mark their prime[localPtr]
        // value as false.

        while (localPtr <= size) {
          comp = val * counter;
          // System.out.println("\t" + val + " * " + counter + " = " + comp);
          localPtr = comp - 1;
          if (localPtr < size) {
            // System.out.println("\tSetting " + results[localPtr] + " to F");
            prime[localPtr] = false;
          }
          counter++;
        }
      } 
      ptr++;
    }
    // Debug-print the behind the scenes Sieve2 values
    // printSieve(results, prime);
    results = convertResults(results, prime);
    return results;
  }

  /**
   * Generates our "off-by-one" array which will be all numbers that we 
   * calculate for the Sieve2. That is, the zeroth element will contain the
   * value 1, element 1 will contain the value 2,
   * etc.
   * @param maxSize - the size of the array to return
   * @return int[] array of correct format, as indicated above
   */

  public static int[] generateSieve(int maxSize) {
    int size = maxSize;
    int[] toReturn = new int[size];
    for (int j = 1; j <= size; j++) {
      toReturn[j - 1] = j;
    }
    return toReturn;    
  }

  /**
   * Based on args provided, calculate the maximum value to calculate.
   * @param args first element 
   * @return maximum size of array
   */
  public static int calculateMax(String[] args) {
    int toReturn = -1; // default (invalid) value
    if (args.length > 0) {
      toReturn = (int) Integer.parseInt(args[0]);
      if (toReturn < 1) {
        // User did not enter a valid integer
        throw new IllegalArgumentException();
      } 
    } else {
      // User forgot to enter an argument!  
      throw new IllegalArgumentException();
    }
    return toReturn;
  }    

  /**
   * Main method.  Accepts one argument, which should be able to be parsed 
   * as an integer, ignores any other arguments.  This argument is 
   * the maximum value to calculate for the Sieve2.
   * If no argument is provided, or it cannot be parsed, assume the user meant 100.
   * @param args maximum value for Sieve2 as first arg
   */

  public static void main(String[] args) {
    System.out.println("Sieve of Eratosthenes");

    // Get the passed-in argument of the maximum value for
    // the Sieve2 to calculate the primality of.

    // If the user did not enter any arguments, or the argument
    // is not a positive integer (1 or greater), then the
    // program should assume that the user meant 100.

    // Other arguments past the first will be ignored.

    try {
      max = calculateMax(args);
    } catch (IllegalArgumentException ex) {
      System.out.println("You forgot to enter a valid integer (> 0)!");
      System.out.println("Assuming you meant to type 100...");
      max = 100;
    }

    // Calculate Sieve2 and print it out
    final int[] sieve = generateSieve(max);
    final int[] results = calculateSieve(sieve);
    Sieve.printSieve(results);
  }
}
