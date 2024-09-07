package homework.work005;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsRight {
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (final char c : s.toCharArray())
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String text = "(){}[]";

        System.out.println(isValid(text));
    }
}
