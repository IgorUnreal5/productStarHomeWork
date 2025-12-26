package work002;

import java.util.Arrays;

public class WorkShop {

    public static void main(String[] args) {

        String[] test = {
                String.valueOf(new Friend("Вася", 25, true, 12.5F)),
                String.valueOf(new Friend("Лиза", 23, false, 10.5F)),
                String.valueOf(new Friend("Петя", 24, false, 1.5F)),
                String.valueOf(new Friend("Саша", 24, false, 2.5F))
        };

/*        Friend[] myFriends = new Friend[4];
        myFriends[0] = new Friend("Вася", Integer.parseInt("25"), true, Float.parseFloat("12.5"));
        myFriends[1] = new Friend("Лиза", Integer.parseInt("23"), false, Float.parseFloat("10.5"));
        myFriends[2] = new Friend("Петя", Integer.parseInt("24"), false, Float.parseFloat("1.5"));
        myFriends[3] = new Friend("Саша", Integer.parseInt("24"), false, Float.parseFloat("2.5"));*/
        //System.out.println(Arrays.toString(myFriends));
        for (String s : test) {
            System.out.print(s);
        }
    }
}
