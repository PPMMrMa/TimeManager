package tool;

public class Time {
    private int year;
    private  int month;
    private  int day;
    private  int hour;
    private int minute;

    public static boolean CheckTime(String time){
        Time t=StringToTime(time);

        return true;
    }
    public  static Time StringToTime(String time){
      Time t=new Time();
      t.setYear((time.indexOf(0)-'0')*1000+(time.indexOf(1)-'0')*100+(time.indexOf(2)-'0')*10+(time.indexOf(3)-'0'));
      t.setMonth((time.indexOf(4)-'0')*10+(time.indexOf(5)-'0'));
      t.setDay((time.indexOf(6)-'0')*10+(time.indexOf(7)-'0'));
      t.setHour((time.indexOf(8)-'0')*10+(time.indexOf(9)-'0'));
      t.setMinute((time.indexOf(10)-'0')*10+(time.indexOf(11)-'0'));
        return  t;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

}
