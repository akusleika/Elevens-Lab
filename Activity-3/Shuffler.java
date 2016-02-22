/* Author: Gloria Ngan
 *
 * This class contains methods to shuffle a 
 * deck of cards.
 */
public class Shuffler {

 private static final int shuffleCount = 1;    //The number of shuffles to be implemented.
 private static final int valueCount = 4;      //The number of values to shuffle.

 //Tests shuffling methods.
 public static void main(String[] args) {
  System.out.println("Results of " + shuffleCount +
         " consecutive perfect shuffles:");
  int[] values1 = new int[valueCount];
  for (int i = 0; i < values1.length; i++) {
   values1[i] = i;
   }
  for (int j = 1; j <= shuffleCount; j++) {
   perfectShuffle(values1);
   System.out.print("  " + j + ":");
   for (int k = 0; k < values1.length; k++) {
    System.out.print(" " + values1[k]);
   }
   System.out.println();
  }
  System.out.println();

  System.out.println("Results of " + shuffleCount +
         " consecutive efficient selection shuffles:");
  int[] values2 = new int[valueCount];
  for (int i = 0; i < values2.length; i++) {
   values2[i] = i;
   }
  for (int j = 1; j <= shuffleCount; j++) {
   selectionShuffle(values2);
   System.out.print("  " + j + ":");
   for (int k = 0; k < values2.length; k++) {
    System.out.print(" " + values2[k]);
   }
   System.out.println();
  }
  System.out.println();
 }


 //Apply a "perfect shuffle" to the argument.
 public static void perfectShuffle(int[] values) {
  int[] temp = new int[values.length];
  int mid = (values.length + 1) / 2;

  // Interleave elements 0 ... mid-1 with elements mid ... length-1
  int unshuffledPos = 0;
  int k = 0;
  for ( ; k < mid; k++) {
   temp[unshuffledPos] = values[k];
   unshuffledPos += 2;
  }
  unshuffledPos = 1;
  for ( ; k < values.length; k++) {
   temp[unshuffledPos] = values[k];
   unshuffledPos += 2;
  }

  // Copy elements back to values
  for (k = 0; k < values.length; k++) {
   values[k] = temp[k];
  }
 }

 /**
  * Apply an "efficient selection shuffle" to the argument.
  * The selection shuffle algorithm conceptually maintains two sequences
  * of cards: the selected cards (initially empty) and the not-yet-selected
  * cards (initially the entire deck). It repeatedly does the following until
  * all cards have been selected: randomly remove a card from those not yet
  * selected and add it to the selected cards.
  * An efficient version of this algorithm makes use of arrays to avoid
  * searching for an as-yet-unselected card.
  * @param values is an array of integers simulating cards to be shuffled.
  */
 public static void selectionShuffle(int[] values) {
  for (int k = values.length - 1; k > 0; k--) {
   int pos = (int) (Math.random() * (k + 1));  // range 0 to k, inclusive
   int temp = values[pos];
   values[pos] = values[k];
   values[k] = temp;
  }
 }
}
