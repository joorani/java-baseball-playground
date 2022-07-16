package study;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

public class StringCalculator {

  public int calculator(int a, int b, String sign) {
    int result = 0;
    if (sign.equals("+")) result = a + b;
    if (sign.equals("*")) result = a * b;
    if (sign.equals("-")) result = a - b;
    if (sign.equals("/")) result = a / b;
    return result;
  }

  public int calculating(String input) {
    String[] values = generateInputScanner(input);

    ArrayDeque<String> dq = getDeque(values);

    int num1 = Integer.parseInt(dq.poll());

    while (!dq.isEmpty()) {
      String sign = dq.pollFirst();
      int num2 = Integer.parseInt(dq.poll());

      num1 = calculator(num1, num2, sign);
    }
    return num1;
  }

  private ArrayDeque<String> getDeque(String[] values) {
    ArrayDeque<String> dq = new ArrayDeque<>();

    for (String value : values) {
      dq.add(value);
    }
    return dq;
  }

  private String[] getSplitedValues(String input) {

    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    Scanner scanner = new Scanner(in);
    String str = scanner.nextLine();
    String[] values = str.split(" ");
    return values;
  }

  private String[] generateInputScanner(String input) {

    if (input==null || input.trim().isEmpty()) {
      throw new NullPointerException("Input is empty");
    }

    return getSplitedValues(input);
  }

}
