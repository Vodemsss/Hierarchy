package pattetns;

public class Main {

    public static void main(String[] args) {
        MessagePrinter messagePrinter = new ConsoleMessagePrinter();
        FileMessagePrinter fileMessagePrinter = new FileMessagePrinter ();
        messagePrinter.setNextMessagePrinter(fileMessagePrinter);
        fileMessagePrinter.setNextMessagePrinter(new DatabaseMessagePrinter());
        messagePrinter.print("hello");
    }
}
abstract class MessagePrinter {
    MessagePrinter nextMessagePrinter;
    void setNextMessagePrinter (MessagePrinter messagePrinter) {
        nextMessagePrinter = messagePrinter;
    }
    void print(String message) {
        printMessage(message);
        if (nextMessagePrinter !=null) {
            nextMessagePrinter.print(message);
        }
    }
    abstract void printMessage(String message);
}
class ConsoleMessagePrinter extends MessagePrinter {
    @Override
    void printMessage(String message) {
        System.out.println("print to console: " + message);

    }
}
class FileMessagePrinter extends MessagePrinter {
    @Override
    void printMessage(String message) {
        System.out.println("print to file: " + message);

    }
}
class DatabaseMessagePrinter extends MessagePrinter {
    @Override
    void printMessage(String message) {
        System.out.println("print to database: " + message);

    }
}