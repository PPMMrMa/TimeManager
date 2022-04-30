package dao;

//时间类： 格式为12位的字符串，如2022年4月30日14点30 的对应字符串为：“202204301400”
public class Time {
    private int year;
    private  int month;
    private  int day;
    private  int hour;
    private int minute;
   //检查时间格式是否正确
    public static boolean CheckTime(String time){
        Time t=StringToTime(time);
        if(time.length()!=12) {
            return false;
        }
        else {
          return juge(t.year,t.month,t.day);
        }
    }
    //将时间字符串转为时间类
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
    private static boolean juge(int year,int month,int day) {
        //定义一个数组，数组里是每个月的合法天数
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        //判断平年闰年
        if ( ( year % 4 == 0 && year % 100 != 0 ) || ( year % 400 == 0 ) ) {
            arr[1] = 29;//闰年二月有29天
        } else {
            arr[1] = 28;//平年二月有28天
        }

        //首先月份只有1到12月
        if (month > 0 && month < 13) {
            if ( day <= arr[month - 1] && day > 0 ) {  //天数从0到该月的最大天数
                return true;  //如果合法，返回true
            }
        }
        return false;
    }
}
