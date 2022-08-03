package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameStarterTest {

  GameStarter starter = new GameStarter();

  @DisplayName("1~9 범위 내의 서로 다른 숫자로 이루어진 3자리 야구숫자 생성")
  @Test
  void generateNumber() {
    String baseballNumber = starter.generateNumber();
    System.out.println(baseballNumber);
  }

  @DisplayName("만들어진 숫자의 각 자리가 유니크한지 확인")
  @Test
  void isUnique() {
    String generatedNumber = "111";
    boolean result = starter.isUnique(generatedNumber);
    assertThat(result).isEqualTo(false);
  }

  @DisplayName("입력한 숫자의 결과를 판별하여 출력")
  @Test
  void judgeNumber_1ball() {
    String programNum = "123";
    String userNum = "671";
    String result = starter.judgeNumber(programNum, userNum);
    assertThat(result).isEqualTo("1볼");
  }

  @Test
  void judgeNumber_3strike() {

    String programNum = "123";
    String userNum = "123";
    String result = starter.judgeNumber(programNum, userNum);
    assertThat(result).isEqualTo("3스트라이크");
  }

  @Test
  void judgeNumber_nothing() {
    String programNum = "123";
    String userNum = "456";
    String result = starter.judgeNumber(programNum, userNum);
    assertThat(result).isEqualTo("Nothing");
  }
}
