package org.example.enums;

public class Demo {

    public static void main(String[] args) {

        Priority priority = Priority.HIGH;

        switch (priority){
            case HIGH :
                System.out.println("High Priority");
            break;
            case MEDIUM :
                System.out.println("Medium Priority");
            break;
            default :
                System.out.println("Low priority");
        }

        Priority priority1 = Priority.valueOf("HIGH");
        Priority[] priorities = Priority.values();
        for (Priority p: priorities) {
            System.out.println("enum : " + p);
        }

    }
}
