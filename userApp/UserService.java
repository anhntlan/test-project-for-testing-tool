public class UserService {

    public boolean checkAge(int age) {
        if(age >= 18){
            return true;
        } 
        return false;
    }

    public String registerUser(String name, int age) {
        if (!checkAge(age)) {
            return "User " + name + " is under 18. Registration failed.";
        }
        return "User " + name + " registered successfully!";
    }

    public void printWelcome(String username) {
        System.out.println("Welcome, " + username + "!");
    }

    public boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public String greetUser(String name) {
        if (!isValidName(name)) {
            return "Hello!";
        }
        return "Hello, " + name + "!";
    }

    public String getUserSummary(String name, int age) {
        String valid = isValidName(name) ? name : "(unknown)";
        String status = checkAge(age) ? "(adult)" : "(minor)";
        return "Name: " + valid + ", Age: " + age + " " + status;
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
}
