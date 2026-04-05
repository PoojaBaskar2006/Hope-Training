import java.util.*;
class Main
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User_Management manager = new User_Management();
        Event_Management eventManager = new Event_Management();
        Admin_Management admin = new Admin_Management();
        Notification n=new Notification();

        while (true) {
            
            // System.out.println("\n1.Register | 2.Login | 3.View Profile | 4.Edit Profile | 5.Logout | 6.Create Event | 7.View My Events | 8.Admin View | 9.Notification | 10.Delete Event | 11.Exit");
            System.out.println("\n----------------------------------------------------------------");
            System.out.println("User Management     Event Management      Admin Management");
            System.out.println("----------------------------------------------------------------");
            System.out.println("1. Registeration    6. Create Event       9. User Statistics");
            System.out.println("2. Login            7. View Event         10. Event Statistics");
            System.out.println("3. View Profile     8. Delete Event");
            System.out.println("4. Edit Profile");
            System.out.println("5. Logout");

            System.out.println("----------------------------------------------------------------");
            System.out.println("11.Notification | 12.Exit");
            
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
             {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Profession: ");
                    String prof = sc.nextLine();

                    System.out.print("Password: ");
                    String pass = sc.nextLine();

                    manager.register(name, email, prof, pass);
                    break;

                case 2:
                    if (manager.isLoggedIn()) {
                        System.out.println("Already logged in!");
                        break;
                    }

                    System.out.print("Email: ");
                    String logEmail = sc.nextLine();

                    System.out.print("Password: ");
                    String logPass = sc.nextLine();

                    manager.login(logEmail, logPass);
                    break;

                case 3:

                    if (!manager.isLoggedIn()) {
                        System.out.println("Please login first!");
                         break;
                  }
                    manager.viewProfile();
                    break;

                case 4:
                    if (!manager.isLoggedIn()) {
                        System.out.println("Please login first!");
                        break;
                    }

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Profession: ");
                    String newProf = sc.nextLine();

                    manager.editProfile(newName, newProf);
                    break;

                case 5:
                    if (!manager.isLoggedIn()) {
                        System.out.println("Please login first!");
                        break;
                    }
                    manager.logout();
                    break;

                

                case 6:
                     if (!manager.isLoggedIn()) {
                        System.out.println("Please login first!");
                        break;
                    }
                    eventManager.createEvent(sc, manager.getCurrentUserEmail());
                    break;

                case 7:
                    if (!manager.isLoggedIn()) {
                        System.out.println("Please login first!");
                        break;
                    }
                    eventManager.viewMyEvents(manager.getCurrentUserEmail());
                    break;
                
                case 9:
                    admin.showUser(manager.getUsers());
                    break;

                case 10:
                    admin.showEvents(eventManager.getEvents());
                    break;
                    
                case 11:
                    n.notify(eventManager.getEvents());
                    break;

                case 8:
                    if (!manager.isLoggedIn()) {
                    System.out.println("Please login first!");
                    break;
                    }
                    eventManager.deleteEvent(sc, manager.getCurrentUserEmail());
                    break;
                case 12:
                    System.out.println("Done with User Management");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
