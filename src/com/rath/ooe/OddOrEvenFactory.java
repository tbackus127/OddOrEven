package com.rath.ooe;

/**
 * Factory design class to generated OddOrEven objects
 */
public class OddOrEvenFactory {

  public OddOrEvenFactory() {

  }

  /**
   * @return a new OddOrEven object.
   */
  public OddOrEven getOddOrEven() {
    return new OddOrEven();
  }
}
