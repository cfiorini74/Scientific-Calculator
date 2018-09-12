package RealCalculator;


//Class implements basic calculator operations to be used 
//with function buttons in GUI
public class calculator {
  private static double prev;
  private static double curr;
  private static double output;
  public static int input;
  private static boolean calculated = false;
  public static boolean fUsed = false;

  public static double setFunction() {
    if (input == 1) {
      output = prev + curr;
    }
    if (input == 2) {
      output = prev - curr;

    }
    if (input == 3) {
      output = prev * curr;
    }
    if (input == 4) {
      output = prev / curr;
    }
    return output;
  }

  public static void setInput(int in) {
    input = in;
  }

  public static double getOutput() {
    return output;
  }
  public void reset() {
    curr=0;
    prev=0;
    output=0;
  }
  public static void setPrev(double input) {
    prev=input;
  }
  public static void setCurr(double input) {
    curr=input;
  }
  public static void setCalculated(boolean input) {
    if (input==true) {
      calculated=true;
    }else {
      calculated=false;
    }
  } 
  public static boolean getCalculated() {
    return calculated;
  }
  public static double getPrev() {
    return prev;
  }
  public static double getCurr() {
    return curr;
  }
  public static void setOutput(double input) {
    output=input;
  }
  
 


}



