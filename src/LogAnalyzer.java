import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogAnalyzer {

    private static final String[] Failed_Login_Attempts = {
        "FAILED LOGIN",
        "LOGIN FAILED",
        "AUTHENTICATION FAILED",
        "INVALID PASSWORD"
    };
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
        int warnCount = 0;
        int infoCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {

            String orgLine;

            while ((orgLine = br.readLine()) != null) {
                totalLines++;

                String line = orgLine.toUpperCase();

                if (line.contains("ERROR")) {
                    errorCount++;
                }

                if (line.contains("WARN")) {
                    warnCount++;
                }

                if (line.contains("INFO")) {
                    infoCount++;
                }

                if (isFailedLogin(line)) {
                    failedLoginCount++;
                }
            }

            printSummary(totalLines, errorCount, failedLoginCount, infoCount, warnCount);

        } catch (IOException e) {
            System.out.println("Error reading log file: " + e.getMessage());
        }

    }

    private static void printSummary(int total, int errors, int failedLogins, int infoCount, int warnCount){

        System.out.println("-----------------------------------------------------");
        System.out.println("Log Analysis Summary");
        System.out.println("-----------------------------------------------------");
        System.out.println("Total log entries: " + total);

        if (total>0) {
            System.out.printf("ERROR entries: %d (%.2f%%)%n" , errors, percentage(errors, total));
            System.out.printf("Failed login attempts: %d (%.2f%%)%n", failedLogins, percentage(failedLogins, total));
            System.out.printf("INFO entries: %d (%.2f%%)%n", infoCount, percentage(infoCount, total));
            System.out.printf("WARN entries: %d (%.2f%%)%n", warnCount, percentage(warnCount, total));
        }

    }

    private static boolean isFailedLogin(String line) {
        for (String keyword : Failed_Login_Attempts) {
            if (line.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    private static double percentage(double num, double total) {
        double perc = (num/total)*100; 
        return perc;
    }   
    
}
