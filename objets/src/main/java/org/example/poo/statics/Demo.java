package org.example.poo.statics;

public class Demo {

    public static void main(String[] args) {


        User user = new User();
        System.out.println(user);
        User user1 = new User(2, "Clara");
        System.out.println(user1);
        System.out.println(User.getCounter());
        Employee e = new Employee();
        System.out.println(e);

    }
}
