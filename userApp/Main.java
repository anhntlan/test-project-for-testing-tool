public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();

        System.out.println(service.registerUser("Lana", 19));
        System.out.println(service.registerUser("Tom", 15));

        System.out.println(service.login("Lana", 12345));
        System.out.println(service.login("Tom", 99999));
    }
}


