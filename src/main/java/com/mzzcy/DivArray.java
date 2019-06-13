package com.mzzcy;

/**
 * Created by changyin.zhao on 9/25/18
 */
public class DivArray {

  public static void main(String args[]) {

  }

  private static int[] divArray(int[] inputArray) {
    if (inputArray == null || inputArray.length == 0) {
      return null;
    }
    if (inputArray[0] == 0) {
      return inputArray;
    }
    for (int i = inputArray.length - 1; i >= 0; i--) {
      inputArray[i] = inputArray[i] / inputArray[0];
    }
    return inputArray;
  }

  private static int[] divArray2(int[] inputArray) {
    if (inputArray == null || inputArray.length == 0) {
      return null;
    }
    if (inputArray[0] == 0) {
      return inputArray;
    }
    int firstArr = inputArray[0];
    for (int i = 0; i < inputArray.length; i++) {
      inputArray[i] = inputArray[i] / firstArr;
    }
    return inputArray;
  }
}
