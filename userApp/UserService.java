public class UserService {

    public boolean checkAge(int age) {
        if (age < 0) {
            return false;
        } else if (age >= 18 && age <= 150) {
            return true;
        } else {
            return false;
        }
    }

     public String registerUser(String name, int age) {
        if (name == null) {
            return "Name cannot be null. Registration failed.";
        } else if (name.trim().isEmpty()) {
            return "Name cannot be empty. Registration failed.";
        } else if (!isValidName(name)) {
            return "Invalid name. Must be at least 3 characters.";
        } else if (containsDigits(name)) {
            return "Invalid name. No digits allowed in name.";
        } else if (isBlacklistedName(name)) {
            return "Registration blocked: name '" + name + "' is not allowed.";
        }

        if (age < 0) {
            return "Invalid age. Registration failed.";
        } else if (age > 150) {
            return "Unrealistic age provided. Please verify.";
        } else if (!checkAge(age)) {
            if (age >= 13) {
                return "User " + name + " is a minor (" + age + ") — parental consent required.";
            }
            return "User " + name + " is under 18. Registration failed.";
        } else if (age == 18) {
            sendVerificationEmail(name);
            return "User " + name + " just turned 18 — welcome! Verification email sent.";
        } else if (age > 18 && age <= 21) {
            sendVerificationEmail(name);
            return "User " + name + " registered with limited access until 21. Email sent.";
        } else {
            sendVerificationEmail(name);
            return "User " + name + " registered successfully and email sent!";
        }
    }

    public void printWelcome(String username) {
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Welcome, guest!");
        } else if (isBlacklistedName(username)) {
            System.out.println("Welcome, valued user.");
        } else if (username.equalsIgnoreCase("admin")) {
            System.out.println("Welcome back, Administrator " + username + "!");
        } else {
            System.out.println("Welcome, " + username + "!");
        }
    }
    
    public boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        String trimmed = name.trim();
        if (trimmed.length() < 3) {
            return false;
        }
        return !trimmed.matches("^[^a-zA-Z0-9]+$");
    }

    public String greetUser(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello!";
        
        } else if (name.equalsIgnoreCase("admin")) {
            return "Welcome back, Admin!";
        } else {
            return "Hello, " + name + "!";
        }
    }

    public void printFarewell(String username) {
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Goodbye!");
        } else if (username.equalsIgnoreCase("admin")) {
            System.out.println("Goodbye, Administrator " + username + "!");
        } else {
            System.out.println("Goodbye, " + username + "!");
        }
    }
    public void sendVerificationEmail(String username) {
        
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

    private boolean isUnrealisticAge(int age) {
        return age < 0 || age > 150;
    }
}
