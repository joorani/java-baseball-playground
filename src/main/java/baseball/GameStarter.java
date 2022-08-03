package baseball;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * 1. 하나씩 난수를 생성할 때마다 생성된 숫자가 유니크한지 확인하는 방법
 * 2. 3자리의 숫자를 생성한 후 유니크한 지 확인하는 방법?
 */
public class GameStarter {

  public static final int NUMBER_SIZE = 3;
  /**
   *   1부터 9까지 서로 다른 수로 이루어진 3자리 수 생성
   */
  public String generateNumber() {

    String result = "";
    Random random = new Random();

    for (int i = 0; i < NUMBER_SIZE; i++) {
      result += random.nextInt(9) + 1;
    }
    return result;
  }

  /**
   * 서로 다른 숫자인지 확인
   */
  public boolean isUnique(String number) {
    char[] numbers = number.toCharArray();
    char num = numbers[0];
    for (int i = 1; i < NUMBER_SIZE; i++) {
      if (num == numbers[i]) {
        return false;
      }

      if (num != numbers[i]) {
        num = numbers[i];
      }
    }
    return true;
  }

  /**
   * 입력된 숫자의 결과를 판별하여 출력한다.
   * 3-1. 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼
   * 3-2. 같은 수가 전혀 없으면 낫싱을 출력한다.
   */
  public String judgeNumber(String programNumber, String userNumber) {
    String strike = "스트라이크";
    String ball = "볼";

    char[] programNums = programNumber.toCharArray();
    char[] userNums = userNumber.toCharArray();

    int strikeCount = 0;
    int ballCount = 0;

    // 같은 개수 -> 볼
    for (int i = 0; i < NUMBER_SIZE; i++) {
      for (int j = 0; j < NUMBER_SIZE; j++) {
        if (programNums[i] == userNums[j] && i == j) {
          strikeCount += 1;
        }

        if (programNums[i] == userNums[j] && i != j) {
          ballCount += 1;
        }

      }
    }

    // 결과 출력
    String result = ballCount + ball +" "+ strikeCount + strike;

    if (strikeCount == 0 && ballCount == 0) {
      result = "Nothing";
    }
    if (strikeCount == 0 && ballCount != 0) {
      result = ballCount + ball;
    }

    if (ballCount == 0 && strikeCount != 0) {
      result = strikeCount + strike;
    }

    return result;
  }

}
