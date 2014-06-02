package rinoceronte;

public class Library {

    public static void sayMyName(String name) {
        System.out.println(name + ", bitch!");
    }

    public static void foo(Object bar) {
        System.out.println(bar instanceof String);
        System.out.println(bar);
    }
}
