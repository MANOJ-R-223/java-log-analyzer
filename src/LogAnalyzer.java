import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogAnalyzer {

    public static void main(String[] args) {

        String logFilePath = "logs/sample.log";
        int totalLines = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                totalLines++;
                System.out.println(line);
            }

            System.out.println("\nTotal log entries: " + totalLines);

        } catch (IOException e) {
            System.out.println("Error reading log file: " + e.getMessage());
        }
    }
}
