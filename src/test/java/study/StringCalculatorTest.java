package study;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

  private Scanner scanner;

  @ParameterizedTest
  @ValueSource(strings = {"2 + 3 * 4 / 2"})
  void name(String input) {
    InputStream in = generateUserInput(input);
    System.setIn(in);
    scanner = new Scanner(System.in);
    String value = scanner.nextLine();
    String[] values = value.split(" ");

    //
    List<Integer> numbers = new ArrayList<>();
    List<String> signs = new ArrayList<>();

    for (String v : values) {
      if (v == "+" || v == "*" || v == "/" || v == "-") {
        signs.add(v);
      }
      numbers.add(Integer.parseInt(v));
    }




  }


  public static InputStream generateUserInput(String input) {
    return new ByteArrayInputStream(input.getBytes());
  }
}
