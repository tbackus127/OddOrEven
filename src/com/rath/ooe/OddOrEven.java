
package com.rath.ooe;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * This class emulates a novice programmer who doesn't know the modulo operation
 * and checks if a number is odd or even via a chain of boolean ORs.
 * 
 * @author Tim Backus tbackus127@gmail.com
 * 
 */
public class OddOrEven {

  /** The minimum value we're checking */
  private int min;

  /** The maximum value we're checking */
  private int max;

  /** The script that is generated by the engine to be evaluated */
  private String script;

  /** The enigne that will interpret the JavaScript generated */
  private ScriptEngine eng;

  /**
   * Default constructor.
   */
  public OddOrEven() {
    this.min = 0;
    this.max = 100;
    this.script = OddOrEvenGenerator.generate(this.min, this.max, 0);
    ScriptEngineManager mgr = new ScriptEngineManager();
    this.eng = mgr.getEngineByName("JavaScript");
  }

  /**
   * Checks whether a number is even.
   * 
   * @param n the number to check.
   * @return true if the number is even; false otherwise.
   */
  public boolean isEven(int n) {

    // Check if we have to regenerate the script
    if (n < this.min || n > this.max) {
      if (n < this.min) {
        this.min = n;
      } else {
        this.max = n;
      }
      regenerate(n);
    }

    // Evaluate the script and get the result
    boolean res = false;
    try {
      eng.put("ienum", n);
      eng.eval(this.script);
      res = (boolean) eng.get("ieres");
    }
    catch (ScriptException e) {
      System.err.println("Error with script:");
      System.err.println(this.script);
      e.printStackTrace();
    }

    return res;
  }

  /**
   * Checks if a number is odd.
   * 
   * @param n the number to check.
   * @return true if the number is odd; false otherwise.
   */
  public boolean isOdd(int n) {
    return !isEven(n);
  }

  /**
   * Regenerates the checking script.
   * 
   * @param num the number we're checking.
   */
  private void regenerate(int num) {
    this.script = OddOrEvenGenerator.generate(this.min, this.max, num);
  }

}
