public class UserService {

    public boolean checkAge(int age) {
        return age >= 18;
    }

     public String registerUser(String name, int age) {
        if (!isValidName(name)) {
            return "Invalid name. Must be at least 3 characters.";
        }
        if (!checkAge(age)) {
            return "User " + name + " is under 18. Registration failed.";
        }

        sendVerificationEmail(name);  
        return "User " + name + " registered successfully and email sent!";
    }

    public void printWelcome(String username) {
        System.out.println("Welcome, " + username + "!");
    }
    
    public boolean isValidName(String name) {
        return name != null && name.length() >= 3;
    }

    public String greetUser(String name) {
        if (!isValidName(name)) {
            return "Hello!";
        }
        return "Hello, " + name + "!";
    }

  

    public String updateUserAge(String name, int newAge) {
        if (!isValidName(name)) {
            return "Invalid user name. Update failed.";
        }
        if (!checkAge(newAge)) {
            return "User " + name + " must be 18 or older. Update failed.";
        }
        return "User " + name + " age updated to " + newAge + ".";
    }

    public void printFarewell(String username) {
        System.out.println("Goodbye, " + username + "!");
    }
    public void sendVerificationEmail(String username) {
        System.out.println("Verification email sent to " + username);
    }
    public String login(String username, int passwordHash) {
        if (username.equals("admin") && passwordHash == 12345) {
            return "Login successful!";
        } else {
            return "Login failed.";
        }
    }
}
