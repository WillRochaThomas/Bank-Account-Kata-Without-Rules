package willjt.printing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ConsolePrinterTest {

    private static final String TEXT_TO_PRINT = "Test";
    private final ByteArrayOutputStream printerOutput = new ByteArrayOutputStream();
    private ConsolePrinter printer;

    @Before
    public void setup() {
        System.setOut(new PrintStream(printerOutput));
    }

    @After
    public void cleanUp() {
        System.setOut(System.out);
    }

    @Test
    public void ensureThatInputTextIsPrintedToTheScreen() throws Exception {
        givenSomeInputText(TEXT_TO_PRINT);
        whenTheConsolePrinterPrints();
        thenTheTextPrintedToTheConsoleIs(TEXT_TO_PRINT);
    }

    private void givenSomeInputText(String inputText) {
        printer = new ConsolePrinter(inputText);
    }

    private void whenTheConsolePrinterPrints() {
        printer.print();
    }

    private void thenTheTextPrintedToTheConsoleIs(String textThatShouldBePrinted) {
        assertThat(printerOutput.toString(), equalTo(textThatShouldBePrinted));
    }
}