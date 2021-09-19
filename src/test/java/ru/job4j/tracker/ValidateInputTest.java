package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }
@Test
    public void whenInvalidInputTrue() {
Output output = new StubOutput();
Input in = new  StubInput( new  String[]{ "1"});
    ValidateInput input = new ValidateInput(output, in);
    int selected = input.askInt("Enter menu:");
    assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInputDoubleTrue() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[]{"1", "2", "3"});
        Input input = new  ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
         selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(3));

    }

    @Test
    public void whenInvalidInputNedat() {
        Output output = new StubOutput();
        Input in = new  StubInput( new  String[]{ "-1"});
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }

}