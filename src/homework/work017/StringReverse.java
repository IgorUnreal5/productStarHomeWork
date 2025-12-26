package work017;

class StringReverser {
    public static String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public void sayHello() {
        System.out.println("Привет! Это код из моей собственной JAR-библиотеки.");
    }
}