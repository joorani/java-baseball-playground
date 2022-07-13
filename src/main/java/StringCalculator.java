public class StringCalculator {


  public int calculator(String sign, int a, int b) {
    int result = 0;
    if (sign == "+") result = a + b;
    if (sign == "*") result = a * b;
    if (sign == "-") result = a - b;
    if (sign == "/") result = a / b;
    return result;
  }
}
