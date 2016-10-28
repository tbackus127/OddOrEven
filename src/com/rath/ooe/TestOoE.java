
package com.rath.ooe;

import java.util.Scanner;

public class TestOoE {

  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    OddOrEvenFactory ooef = new OddOrEvenFactory();
    OddOrEven ooe = ooef.getOddOrEven();
    boolean running = true;

    while(running) {
      System.out.print("Enter a number: ");
      int num = 0;
      try {
        num = cin.nextInt();
      }
      catch (NumberFormatException nfe) {
        System.out.println("Please enter a valid 32-bit number.");
        running = false;
      }

      if (ooe.isEven(num)) {
        System.out.println("Your number is even!");
      } else {
        System.out.println("Your number is odd!");
      }
    }

    cin.close();
  }
}
