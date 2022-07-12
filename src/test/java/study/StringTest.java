package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.PrimitiveIterator;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("'1,2'를 ,로 split했을 때 잘 분리된다.")
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1", "2");

        //containsExactily는 순서를 포함해서 정확히 일치해야 한다.
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String의 substring() 메소드를 활용해 특정 문자를 제외하고 반환할 수 있다.")
    void subString() {
        String str = "(1,2)";
        String result = str.substring(1, str.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt()메서드를 활용해 특정 위치의 문자를 가져온다.")
    void charAt() {
        String str = "abc";
        char result = str.charAt(1);

        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt() 사용시 가능한 index 범위를 벗어나면 exception이 발생한다.")
    void charAt_exception1() {
        String str = "abc";

        assertThatThrownBy(() -> {
            str.charAt(10);
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 10");
    }

    @Test
    @DisplayName("charAt() 사용시 가능한 index 범위를 벗어나면 exception이 발생한다.")
    void charAt_exception2() {
        String str = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(11);
                })
                .withMessageContaining("%d", 11);
    }


}
