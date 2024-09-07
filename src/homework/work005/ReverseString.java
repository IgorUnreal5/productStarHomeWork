package homework.work005;

public class ReverseString {

    public static char[] reverseString(char[] str) {
        int left = 0, right = str.length - 1;

        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
        return str;
    }

    public static void main(String[] args) {
        String reversed = "Hello World";

        System.out.println(reverseString(reversed.toCharArray()));
    }
}
