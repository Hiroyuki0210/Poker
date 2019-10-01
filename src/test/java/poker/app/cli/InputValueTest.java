package poker.app.cli;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InputValueTest {
    @Test(expected = IllegalArgumentException.class)
    public void inputNumberOfCompute_over() {
        int out = PlayPoker.inputNumberOfComputer("");
        int expect = 0;
        assertThat(out, is(expect));
    }

    @Test
    public void inputNumberOfCompute() {
        int out = PlayPoker.inputNumberOfComputer("2");
        int expect = 2;
        assertThat(out, is(expect));
    }

    @Test
    public void inputValueIsQuit_empty() {
        assertThat(PlayPoker.inputValueIsQuit(""), is(false));
    }

    @Test
    public void inputValueIsQuit() {
        assertThat(PlayPoker.inputValueIsQuit("q"), is(true));
    }

    @Test
    public void parseInputValueTest_empty() {
        String in = "";
        int[] out = PlayPoker.parseInputValue(in);
        int[] expect = {};
        assertThat(out, is(expect));
    }

    @Test
    public void parseInputValueTest() {
        String in = "0,2,4";
        int[] out = PlayPoker.parseInputValue(in);
        int[] expect = {0, 2, 4};
        assertThat(out, is(expect));
    }

}
