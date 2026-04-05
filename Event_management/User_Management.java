import java.util.*;

class User_Management {
    private ArrayList<String> users = new ArrayList<>();
    private String currentUser = null;

    public void register(String name, String email, String profession, String password) {
        String user = name + "," + email + "," + profession + "," + password;
        users.add(user);
        System.out.println("Registered successfully!");
    }

    public boolean login(String email, String password) {
        for (String u : users) {
            String[] parts = u.split(",");

            if (parts[1].equals(email) && parts[3].equals(password)) {
                currentUser = u;
                System.out.println("Login successful");
                return true;
            }
        }
        System.out.println("Invalid credentials");
        return false;
    }

    public void logout() {
       
        currentUser = null;
        System.out.println("Logged out Successfully");
    }

    public void viewProfile() {
        

        String[] parts = currentUser.split(",");
        System.out.println("\n--- Profile ---");
        System.out.println("Name: " + parts[0]);
        System.out.println("Email: " + parts[1]);
        System.out.println("Profession: " + parts[2]);
        System.out.println("------------------");
    }

    public void editProfile(String newName, String newProfession) {
        if (currentUser == null) {
            System.out.println("Please login first!");
            return;
        }

        String[] parts = currentUser.split(",");
        String updated = newName + "," + parts[1] + "," + newProfession + "," + parts[3];

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(currentUser)) {
                users.set(i, updated);
                break;
            }
        }

        currentUser = updated;
        System.out.println("Profile updated!");
    }

    public String getCurrentUserEmail() {
        return currentUser.split(",")[1];
    }   

    public boolean isLoggedIn() {
        if(currentUser!=null){
            return true;
        }
        return false;
    }

    public ArrayList<String> getUsers() {
    return users;
}
}

