import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogAnalyzer {

    public static void main(String[] args) {

        String logFilePath = "logs/sample.log";
        int totalLines = 0;
        int errorCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                totalLines++;

                if (line.contains("ERROR")) {
                    errorCount++;
                }
            }

            System.out.println("Log Analysis Summary");
            System.out.println();
            System.out.println("Total log entries: " + totalLines);
            System.out.println("ERROR entries: " + errorCount);

        } catch (IOException e) {
            System.out.println("Error reading log file: " + e.getMessage());
        }
    }
}
