package willjt.printing;

public class ConsolePrinter {

    private String textToPrint;

    public ConsolePrinter(String textToPrint) {
        this.textToPrint = textToPrint;
    }

    public void print() {
        System.out.print(textToPrint);
    }
}
