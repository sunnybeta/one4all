public class Overloading {
    public static void main(String[] args) {
        name("Sunny", "Beta");
        name("Sunny Beta");
    }

    public static void name(String firstname, String lastname) {
        System.out.println("First Name: " + firstname + ", Last Name: " + lastname);
    }

    public static void name(String fullname) {
        System.out.println("Full Name: " + fullname);
    }
}
