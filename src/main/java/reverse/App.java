package reverse;

public class App {

    static String reverseString(String s){
        if (s.length() == 0)
            return s;

        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println(reverseString("hsejaR"));

        int[] elements = new int[10];

        System.out.println(elements.length);

    }

}
