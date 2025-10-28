public class UserService {

    public boolean checkAge(int age) {
        if (age < 0) {
            return false;
        }
        if (age >= 18 && age <= 100) {
            return true;
        }
        return false;
    }

     public String registerUser(String name, int age) {
        if (name == null) {
            return "Name cannot be null. Registration failed.";
        }
        if (name.trim().isEmpty()) {
            return "Name cannot be empty. Registration failed.";
        }
        if (!isValidName(name)) {
            return "Invalid name. Must be at least 3 characters.";
        }
        if (containsDigits(name)) {
            return "Invalid name. No digits allowed in name.";
        }
        if (isBlacklistedName(name)) {
            return "Registration blocked: name '" + name + "' is not allowed.";
        }

        if (age < 0) {
            return "Invalid age. Registration failed.";
        }
        if (age > 150) {
            return "Unrealistic age provided. Please verify.";
        }
        if (!checkAge(age)) {
            if (age <18){
                return "User " + name + " is under 18. Registration failed.";
            }
           
        }
        if (age == 18) {
            sendVerificationEmail(name);
            return "User " + name + " just turned 18 — welcome! Verification email sent.";
        }
        if (age > 18 && age <= 21) {
            sendVerificationEmail(name);
            return "User " + name + " registered with limited access until 21. Email sent.";
        }
        sendVerificationEmail(name);
        return "User " + name + " registered successfully and email sent!";
    }

    public void printWelcome(String username) {
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Welcome, guest!");
            return;
        }
        if (isBlacklistedName(username)) {
            System.out.println("Welcome, valued user.");
            return;
        }
        if (username.equalsIgnoreCase("admin")) {
            System.out.println("Welcome back, Administrator " + username + "!");
            return;
        }
        System.out.println("Welcome, " + username + "!");
    }
    
    
    public String greetUser(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello!";
        }
        if (name.equalsIgnoreCase("admin")) {
            return "Welcome back, Admin!";
        }
        return "Hello, " + name + "!";
    }

    public void printFarewell(String username) {
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Goodbye!");
            return;
        }
        if (username.equalsIgnoreCase("admin")) {
            System.out.println("Goodbye, Administrator " + username + "!");
            return;
        }
        System.out.println("Goodbye, " + username + "!");
    }
    public void sendVerificationEmail(String username) {
        if (username == null || username.trim().isEmpty()) {
            System.out.println("No username provided — cannot send verification email.");
            return;
        }
        if (isBlacklistedName(username)) {
            System.out.println("Verification suppressed for blacklisted name: " + username);
            return;
        }
        System.out.println("Verification email sent to " + username);
      
    }
  

    private boolean isBlacklistedName(String name) {
        if (name == null) return false;
        String lower = name.trim().toLowerCase();
        if (lower.isEmpty()) return false;
        if (lower.equals("root") || lower.equals("system") || lower.equals("null")) {
            return true;
        }
        return false;
    }

    private boolean containsDigits(String s) {
        if (s == null) return false;
        return s.matches(".*\\d.*");
    }

    private boolean isValidName(String name) {
        if (name == null) return false;
        return name.trim().length() >= 6;
    }

     public String login(String username, int passwordHash) {
        if (username == null || username.trim().isEmpty()) {
            return "Username required.";
        }
        if (passwordHash <= 0) {
            return "Invalid password provided.";
        }

        if (username.equals("admin")) {
            if (passwordHash == 12345) {
                return "Admin login successful!";
            }
            if (passwordHash == 0) {
                return "Admin login failed: weak password.";
            }
            return "Admin login failed: incorrect password.";
           
        }

        if (passwordHash % 2 == 0) {
            return "Login successful!";
        }
        return "Login failed.";
    }

}
