package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

public class StringCalculatorTest {

  private Scanner scanner;

  StringCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new StringCalculator();
  }

  @DisplayName("입력한 문자열 값에 따라 사칙연산 수행")
  @ParameterizedTest
  @CsvSource({"2 + 3 * 4 / 2, 10", "5 - 3 * 10, 20"})
  void name(String input, int expected) {

    Assertions.assertThat(calculator.calculating(input)).isEqualTo(expected);

  }

  @DisplayName("입력한 값이 공백인 경우")
  @ParameterizedTest
  @ValueSource(strings = {" ", ""})
  void emptyException(String input) {

    Assertions.assertThatNullPointerException()
            .isThrownBy(() -> calculator.calculating(input))
            .isInstanceOf(NullPointerException.class);
  }

}