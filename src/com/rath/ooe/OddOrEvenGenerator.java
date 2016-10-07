
package com.rath.ooe;

/**
 * This class generates bad JavaScript with chains of boolean ORs to determine
 * whether a given number is odd or even.
 * 
 * @author Tim Backus tbackus127@gmail.com
 * 
 */
public class OddOrEvenGenerator {

  /**
   * Builds the script as a String.
   * @param min the minimum value we have to check.
   * @param max the maximum value we have to check.
   * @param num the number we're checking.
   * @return the entire JavaScript script as a String.
   */
  public static String generate(int min, int max, int num) {

    // -1, 100, -1 = problem
    String result = "";
    result += "function isEven(num) {\n";
    result += "  if(";

    // Check if min/max are even by "rounding" towards 0.
    min = (Math.abs(min % 2) == 1) ? (min < 0) ? min + 1 : min - 1 : min;
    max = (Math.abs(max % 2) == 1) ? (max > 0) ? max - 1 : max + 1 : max;

    // The massive chain of ORs.
    result += "num == " + min;
    for (int i = min + 2; i <= max; i += 2) {
      result += " || num == " + i;
    }

    result += ") {\n";
    result += "    return true;\n";
    result += "  } else {\n";
    result += "    return false;\n";
    result += "  }\n}\n";
    result += "ieres = isEven(ienum);";

    return result;
  }
}
