package RealCalculator;

import java.util.ArrayList;
import RealCalculator.Function;
//Class for interpreting Strings into mathematical statements and simplifying them
//. Supports in paranthesis order of operations, i.e. 1+(3*2) will produce an 
//output of 7, but does not yet support operator based order of operations, 
//i.e. 1+3*2 will produce an output of 8. 

public class TextParser {

  public static String toParse;
  static ArrayList<Double> function;
  static int set = 0;
  
  
  // Viable characters that can be used in digits string
  static ArrayList<Character> digits = new ArrayList<Character>();

  public TextParser(String s) {
    toParse = s;
    digits.add('0');
    digits.add('1');
    digits.add('2');
    digits.add('3');
    digits.add('4');
    digits.add('5');
    digits.add('6');
    digits.add('7');
    digits.add('8');
    digits.add('9');
    digits.add('.');
  }

  // Calls inspectParanthesis method, simplifies call of inspectParanthesis
  // as this method has no arguments
  public double parse() throws Exception {
    return inspectParanthesis(0, toParse.length());
  }

  // Method that simplifies mathematical statement between characters specified
  // in
  // arguments using recursion.
  public double inspectParanthesis(int first, int last) throws Exception {
    int setFirst = 0, setLast = 0;
    int r = 0;
    double solution = 0;
    boolean numFound = false;
    int func = 1;
    // Tests for edge case if there is no input
    if (first == last) {
      String answer = "";
      return Double.parseDouble(answer + toParse.charAt(first));
    } else {
      for (r = first; r < last; r++) {
        // edge case for if multiplication is attempted without * operator,
        // i.e. 8(8)
        if (toParse.charAt(r) == '(') {
          if (r > 0) {
            if (toParse.charAt(r - 1) == ')'
                || digits.contains(toParse.charAt(r - 1))) {
              func = 3;
            }
          }
          int findPara = 0;
          r++;
          setFirst = r;
          // Finds and matches pairs of parenthesis
          while (toParse.charAt(r) != ')' || findPara > 0) {
            if (r > last) {
              throw new Exception("Not enough paranthesis");
            }
            if (toParse.charAt(r) == '(') {
              findPara++;
              r++;
            } else if (toParse.charAt(r) == ')' && findPara > 0) {
              findPara--;
              r++;
            } else if (toParse.charAt(r) == ')' && findPara == 0) {
              break;
            } else {
              r++;
            }
          }
          setLast = r;
          solution = determineFuncRecursively(func, solution, setFirst,
              setLast);
          if (r + 1 != toParse.length()) {
            r++;
          }
        }
        func = determineFunc(func, toParse.charAt(r));
        if (digits.contains(toParse.charAt(r)) == true) {
          String number = determineNum(r);
          r += number.length()-1;
          double include = Double.parseDouble(number);
          solution = resolveFunc(func, solution, include);
        }
      }

    }
    return solution;
  }
  //Method to find a string of numbers
  public String determineNum(int r) throws Exception {
    String number = "";
    int numOfDots = 0;
    while (digits.contains(toParse.charAt(r)) == true) {
      number += toParse.charAt(r);
      if (toParse.charAt(r) == '.') {
        numOfDots++;
      }
      if (numOfDots > 1) {
        throw new Exception("More than one decimal point.");
      }
      if (r < toParse.length() - 1 && digits.contains(toParse.charAt(r + 1))) {
        r++;
      } else {
        break;
      }
    }
    return number;
  }
  //Method calls inspectParenthesis() between pairs of parenthesis, recursively
  //solving equation
  public double determineFuncRecursively(int func,double solution,int setFirst, int setLast) throws Exception {
    
    if (func == 1) {
      solution += inspectParanthesis(setFirst, setLast);
    } else if (func == 2) {
      solution -= inspectParanthesis(setFirst, setLast);
    } else if (func == 3) {
      solution *= inspectParanthesis(setFirst, setLast);
    } else if (func == 4) {
      solution /= inspectParanthesis(setFirst, setLast);
    } else if (func == 5) {
      double bounds= inspectParanthesis(setFirst,setLast);
      solution=Math.pow(solution, bounds);
    }
    return solution;
  }
  //Method returns the operator to be used based on char argument
  public int determineFunc(int funcIn,char op) {
    int func=funcIn;
    if (op == '+') {
      func = 1;
    }
    if (op == '-') {
      func = 2;
    }
    if (op == '*') {
      func = 3;
    }
    if (op == '/') {
      func = 4;
    }
    if (op == '^') {
      func = 5;
    }
    return func;
  }
  //Method resolves function 
  public double resolveFunc(int func, double solution, double include) {
    if (func == 1) {
      solution += include;
    } else if (func == 2) {
      solution -= include;
    } else if (func == 3) {
      solution *= include;
    } else if (func == 4) {
      solution /= include;
    } else if (func == 5) {
      solution=Math.pow(solution, include);
    }
    return solution;
  }

}
