import java.util.*;
import java.time.*;
public class Notification
{
    public void notify(ArrayList<String> events)
    {
        boolean f=false;
    LocalDate today = LocalDate.now();
    for(String e:events)
    {
        String[] p=e.split(",");
        String s=p[1];
        LocalDate date = LocalDate.parse(s);
        if(today.isEqual(date))
    {
            if(today.isEqual(date)) {
    System.out.println("Event:" + p[2] + " | Event ID:" + p[7]);

    String[] time = p[5].split("-");

    if(p[4].equals("offline")) {
        System.out.println("Mode: Offline | Time:" + time[2]);
    } else {
        System.out.println("Mode: Online | Time:" + time[1]);
    }

    f = true;
}

    }
    }
    if(f==false){
        System.out.println("No NOTIFICATIONS");
    }
    }
}
