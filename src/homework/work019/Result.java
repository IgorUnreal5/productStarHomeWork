package work019;

public record Result(String name, String gender, String distance, String time) {

    /**
     * Конвертирует время в формате "MM:SS" в секунды для сравнения.
     *
     * @return время в секундах
     * @throws IllegalArgumentException если формат некорректный
     */
    public int getTimeInSeconds() {
        String[] parts = time.trim().split(":");

        try {
            if (parts.length == 2) {
                // MM:SS
                int minutes = Integer.parseInt(parts[0]);
                int seconds = Integer.parseInt(parts[1]);
                return minutes * 60 + seconds;
            }
            else if (parts.length == 3) {
                // H:MM:SS
                int hours = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);
                int seconds = Integer.parseInt(parts[2]);
                return hours * 3600 + minutes * 60 + seconds;
            }
            else {
                throw new IllegalArgumentException("Invalid time format: " + time);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid time value: " + time, e);
        }
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", distance='" + distance + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}