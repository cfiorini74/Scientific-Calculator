package RealCalculator;

import java.util.ArrayList;
import RealCalculator.Function;

public class TextParser {
  public static String toParse;
  static ArrayList<Double> function;
  static int set = 0;
  static char[] digitsList = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
      '9' };
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
  public double parse() throws Exception {
    return inspectParanthesis(0, toParse.length());
  }

  public double inspectParanthesis(int first, int last) throws Exception {
    int setFirst = 0, setLast = 0;
    int r = 0;
    double solution = 0;
    boolean numFound = false;
    int func = 1;
    if (first == last) {
      String answer = "";
      return Double.parseDouble(answer + toParse.charAt(first));
    } else {
      for (r = first; r < last; r++) {
        if (toParse.charAt(r) == '(') {
          System.out.println("woah1");
          if (r>0) {
            System.out.println("woah");
            if (toParse.charAt(r-1)==')'||digits.contains(toParse.charAt(r-1))){
              func=3;
              System.out.println("wow");
            }
          }
          int findPara = 0;
          r++;
          setFirst = r;
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
          if (r + 1 != toParse.length()) {
            r++;
          }
        }
        if (toParse.charAt(r) == '+') {
          func = 1;
        }
        if (toParse.charAt(r) == '-') {
          func = 2;
        }
        if (toParse.charAt(r) == '*') {
          func = 3;
        }
        if (toParse.charAt(r) == '/') {
          func = 4;
        }
        if (toParse.charAt(r) == '^') {
          func = 5;
        }
        if (digits.contains(toParse.charAt(r)) == true) {
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
            if (r < toParse.length() - 1
                && digits.contains(toParse.charAt(r + 1))) {
              r++;
            } else {
              break;
            }
          }
          double include = Double.parseDouble(number);

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
        }
      }

    }
    return solution;
  }

}
