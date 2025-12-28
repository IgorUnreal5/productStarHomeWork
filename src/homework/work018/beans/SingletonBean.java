package work018.beans;

public class SingletonBean {
    public SingletonBean() {
        System.out.println("SingletonBean создан: " + this.hashCode());
    }
}