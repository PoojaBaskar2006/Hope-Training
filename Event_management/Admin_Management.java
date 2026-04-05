import java.util.*;

public class Admin_Management {

    public void showUser(ArrayList<String> users){
        if (users.isEmpty()) {
            System.out.println("No users found!");
            return;
        }
        System.out.println("\n--- User Details ---");
        int i=1;
        for(String u:users){
            String name=u.split(",")[0];
            System.out.println(i+"."+name);
            i++;
        }

    }

    public void showEvents(ArrayList<String> events){
        if (events.isEmpty()) {
        System.out.println("No events found!");
        return;
    }

    int i = 1;

    System.out.println("\n--- Event Details ---");

    for (String e : events) {
        String[] p = e.split(",");

        String email = p[0];   
        String eventName = p[2]; 
        String id=p[7];

        System.out.println(i + ". " + email + " - " + eventName+" - "+id);
        i++;
    }
    }

    // public void showUserEventStats(ArrayList<String> users, ArrayList<String> events) {

    //     if (users.isEmpty()) {
    //         System.out.println("No users found!");
    //         return;
    //     }

        

    //     System.out.println("\n--- User Event Statistics ---");

    //     for (String u : users) {
    //         String[] userParts = u.split(",");
    //         String name = userParts[0];
    //         String email = userParts[1];

    //         int count = 0;

    //         for (String e : events) {
    //             if (e.split(",")[0].equals(email)) {
    //                 count++;
    //             }
    //         }

    //         System.out.println("User: " + name + " (" + email + ")");
    //         System.out.println("Number of Events: " + count);
    //         System.out.println("--------------------------");
    //     }

    //     System.out.println("Total Users: " + users.size());
    //     System.out.println("Total Events: " + events.size());
    // }
}
