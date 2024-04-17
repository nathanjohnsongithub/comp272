
/*
 * Main Routine
 *
 * This routine will exercise methods for the class CuckooHash, it does not
 * perform unit testing. Instead, this  routine is intentionally inserts
 * <key,value> pairs such that they will cause hash collisions, including
 * several rehashing due to cycles forming.
 */

public class Main {
  public static void main(String[] args) {

      // Initially 10 buckets
      CuckooHash<String, String> table = new CuckooHash<String, String>(10);

      // The following quick test is inserting <key, value> pairs, such
      // that the code is exercising hash collisions and the resultant
      // reshuffling of <key, value> pairs in the hashmap. Additionally,
      // based on the current hash function formulas and the hashmap
      // growth function for rehashing, several of these insertions will
      // also cause rehashing / hashmap growth.

      table.put("A", "AA");
      System.out.println(table.printTable() + "    " + table.size());
      table.put("A", "LL");
      System.out.println(table.printTable() + "    " + table.size());
      table.put("B", "BB");
      System.out.println(table.printTable() +"    " + table.size());
      table.put("C", "CC");
      System.out.println(table.printTable() +"    " + table.size());

      // The following insert will result in a cycle and rehashing
      table.put("C", "HH");
      System.out.println(table.printTable() +"    " + table.size());
      table.put("S", "XX");
      System.out.println(table.printTable() +"    " + table.size());

      // The following insert will result in cycle and rehash
      table.put("S", "SS");
      System.out.println(table.printTable() +"    " + table.size());
      table.put("B", "KK");
      System.out.println(table.printTable() +"    " + table.size());

      System.out.println();
      System.out.println("KEYS: " + table.keys());
      System.out.println("VALUES: " + table.values());

      System.out.println();
      table.remove("A", "AA");
      table.remove("B", "KK");
      System.out.println(table.printTable() +"    " + table.size());

      table.clear();
 
  }

}