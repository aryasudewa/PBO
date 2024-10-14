import java.util.logging.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SupportSystem {
    private static final Logger logger = Logger.getLogger(SupportSystem.class.getName());
    private InputReader reader;
    private Responder responder;
    
    public SupportSystem() {
        setupLogger();
        reader = new InputReader();
        responder = new Responder();
    }

    private void setupLogger() {
        logger.setUseParentHandlers(false);
        try {
            Handler fileHandler = new FileHandler("support_system.log", true);
            fileHandler.setFormatter(new CustomFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);
        }
        catch(Exception e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }
    }

    private class CustomFormatter extends Formatter {
        private boolean headerWritten = false;

        public String format(LogRecord record) {
            StringBuilder sb = new StringBuilder();

            if(!headerWritten) {
                sb.append("Support System Log - ")
                  .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                  .append("\n");
                headerWritten = true;
            }

            sb.append(String.format("%s: %s%n", record.getLevel(), record.getMessage()));
            return sb.toString();
        }
    }

    public void start() {
        boolean finished = false;

        printWelcome();

        while(!finished) {
            String input = reader.getInput();
            logger.info("User input: " + input);

            if(input.toLowerCase().startsWith("bye")) {
                finished = true;
            }
            else {
                String response = responder.generateResponse(input.toLowerCase());
                System.out.println(response);
                logger.info("System response: " + response);
            }
        }
        printGoodbye();
    }

    private void printWelcome() {
        System.out.println("Welcome to the Arsud Technical Support System.");
        System.out.println();
        System.out.println("Please tell us about your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    private void printGoodbye() {
        System.out.println("Nice talking to you. Bye...");
    }
}