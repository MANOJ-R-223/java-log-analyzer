import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogAnalyzer {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Run with Filepath  Example: java LogAnalyzer <log-file-path>");
            return;
        }

        String logFilePath = args[0];

        analyzeLogFile(logFilePath);
        
    }

    private static void analyzeLogFile(String logFilePath) {

        int totalLines = 0;
        int errorCount = 0;
        int failedLoginCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                totalLines++;

                if (line.contains("ERROR")) {
                    errorCount++;
                }

                if (line.contains("Failed login")) {
                    failedLoginCount++;
                }
            }

            printSummary(totalLines, errorCount, failedLoginCount);

        } catch (IOException e) {
            System.out.println("Error reading log file: " + e.getMessage());
        }

    }

    private static void printSummary(int total, int errors, int failedLogins){

        System.out.println("Log Analysis Summary");
            System.out.println();
            System.out.println("Total log entries: " + total);
            System.out.println("ERROR entries: " + errors);
            System.out.println("Failed login attempts: " + failedLogins);

    }
        
    
}
