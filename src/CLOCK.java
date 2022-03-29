public class CLOCK {
    int seconds;
    int minutes;
    int hours;
    int days;
    int weeks;
    int months;
    int years;
    int decades;
    public CLOCK (int seconds, int minutes, int hours, int days, int weeks, int months, int years, int decades){
        seconds = 0;
        minutes = 0;
        hours = 0;
        days = 0;
        weeks = 0;
        months = 0;
        years = 0;
        decades = 0;
    }
    public void Tick() {
     if(seconds == 60){
         minutes ++;
         if(minutes == 60){
             hours ++;
             if(hours == 24){
                 days ++;
                 if(days == 7){
                     weeks ++;
                     if(weeks == 4){
                         months ++;
                         if(months == 12){
                             years ++;
                             if(years == 10);
                             decades ++;
                         }
                     }
                 }
             }
         }
     }
    }
}