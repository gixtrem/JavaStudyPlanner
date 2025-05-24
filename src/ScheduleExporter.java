import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ScheduleExporter {

    public static void exportToCSV(List<Schedule> schedules, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append(Schedule.csvHeader()).append("\n");

            for (Schedule schedule : schedules) {
                writer.append(schedule.toCSVFormat()).append("\n");
            }

            System.out.println(" Successfully exported schedules to " + filename);

        } catch (IOException e) {
            System.err.println(" Failed to export schedules: " + e.getMessage());
        }
    }
}
