import java.util.*;
import java.time.*;

class Event_Management {
    private ArrayList<String> events = new ArrayList<>();
    private int c = 1;

    public void createEvent(Scanner sc, String userEmail) {
        String eventId = "E" + c++;
        

        System.out.print("Event Name: ");
        String name = sc.nextLine();

        System.out.print("Event Type: ");
        String type = sc.nextLine();

        System.out.print("Event Date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.print("Online or Offline: ");
        String mode = sc.nextLine().toLowerCase();

        String extra = "";

        if (mode.equals("online")) {
            System.out.print("Platform: ");
            String platform = sc.nextLine();

            System.out.print("Time: ");
            String time = sc.nextLine();

            extra = platform + "-" + time;
        } else {
            System.out.print("Venue Name: ");
            String venue = sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            System.out.print("Time: ");
            String time = sc.nextLine();

            extra = venue + "-" + address + "-" + time;
        }

        System.out.print("Description: ");
        String desc = sc.nextLine();

        String event = userEmail + "," + date + "," + name + "," + type + "," + mode + "," + extra + "," + desc + "," + eventId;
        // String event = userEmail + "," + date + "," + name + "," + type + "," + mode + "," + extra + "," + desc;
        events.add(event);

        System.out.println("Event created!");
    }

    public void viewMyEvents(String userEmail) {

        
        ArrayList<String> myEvents = new ArrayList<>();

        // filter events for this user
        for (String e : events) {
            if (e.split(",")[0].equals(userEmail)) {
                myEvents.add(e);
            }
        }

        if (myEvents.isEmpty()) {
            System.out.println("No events found!");
            return;
        }

        // convert to array for Arrays.sort
        String[] arr = myEvents.toArray(new String[0]);

        Arrays.sort(arr, (a, b) -> {
            LocalDate d1 = LocalDate.parse(a.split(",")[1]);
            LocalDate d2 = LocalDate.parse(b.split(",")[1]);
            return d1.compareTo(d2);
        });

        System.out.println("\n--- My Events ---");

        for (String e : arr) {
            String[] parts = e.split(",");
            System.out.println("\nUserId   : " + parts[0]);
            System.out.println("\nDate     : " + parts[1]);
            System.out.println("Name     : " + parts[2]);
            System.out.println("Event ID : "+parts[7]);
            System.out.println("Type     : " + parts[3]);
            System.out.println("Mode     : " + parts[4]);

            String[] extra = parts[5].split("-");

            if (parts[4].equals("online")) {
            System.out.println("Platform : " + extra[0]);
            System.out.println("Time     : " + extra[1]);
            } 
            else {
            System.out.println("Venue    : " + extra[0]);
            System.out.println("Address  : " + extra[1]);
            System.out.println("Time     : " + extra[2]);
            }

            System.out.println("\nDescription: " + parts[6]);
            System.out.println("----------------------");
        }
    }

    public void deleteEvent(Scanner z, String userEmail) {

        System.out.print("Enter Event ID: ");
                    String eventId = z.nextLine();

    for (int i = 0; i < events.size(); i++) {
        String[] p = events.get(i).split(",");

        
        if (p[7].equals(eventId) && p[0].equals(userEmail)) {
            events.remove(i);
            System.out.println("Event deleted successfully!");
            return;
        }
    }

    System.out.println("Event not found!");
}

    public ArrayList<String> getEvents() {
         return events;
    }
}
