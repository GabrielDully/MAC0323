public final class Date implements Comparable<Date> {
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Date y = (Date) obj;
        return this.day == y.day && this.month == y.month && this.year == y.year;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + day;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }

    @Override
    public int compareTo(Date date) {
        if (this.year != date.year)
            return this.year - date.year;
        if (this.month != date.month)
            return this.month - date.month;
        return this.day - date.day;
    }

    public static void main(String[] args) {
        Date date1 = new Date(10, 4, 2025);
        Date date2 = new Date(15, 4, 2025);

        System.out.println("date1 < date2? " + (date1.compareTo(date2) < 0));
        System.out.println("date1 == date2? " + date1.equals(date2));
    }
}
