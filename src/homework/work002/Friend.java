package work002;

public class Friend {
    String name;
    int age;
    boolean isFriendFromSchool;
    float hoursSpentTogetherLastWeek;

    public Friend(String name, int age, boolean isFriendFromSchool, float hoursSpentTogetherLastWeek) {
        this.name = name;
        this.age = age;
        this.isFriendFromSchool = isFriendFromSchool;
        this.hoursSpentTogetherLastWeek = hoursSpentTogetherLastWeek;
    }

    @Override
    public String toString() {
        return "[name=" + name + "," +
                " age=" + age + "," +
                " isFriendFromSchool: " + isFriendFromSchool + "," +
                " hoursSpentTogetherLastWeek: " + hoursSpentTogetherLastWeek + "]\n";
    }
}
