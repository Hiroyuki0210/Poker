package poker.app.cli;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InputValueTest {
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
        int[] out = PlayPoker.parseInput(in);
        int[] expect = null;
        assertThat(out, is(expect));
    }

    @Test
    public void parseInputValueTest() {
        String in = "0,2,4";
        int[] out = PlayPoker.parseInput(in);
        int[] expect = {0, 2, 4};
        assertThat(out, is(expect));
    }
}
