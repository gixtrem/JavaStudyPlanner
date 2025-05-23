public class Schedule {
    private String subject;
    private String date;
    private String time;
    private String notes;

    public Schedule(String subject, String date, String time, String notes) {
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    // Getters
    public String getSubject() { return subject; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getNotes() { return notes; }

    // CSV formatting methods
    public String toCSVFormat() {
        return String.format("%s,%s,%s,%s", subject, date, time, notes);
    }

    public static String csvHeader() {
        return "Subject,Date,Time,Notes";
    }
}
