package myObjectTests;

class MyNewClass {
    int a;
    String b;

    void printMyFields() {
        System.out.println("Field a is: " + a);
        System.out.println("Field b is: " + b);
    }
}

public class MyObjectTest_OO {
    public static void main(String[] args) {
        MyNewClass object1 = new MyNewClass();
        MyNewClass object2 = new MyNewClass();

        object1.a = 42;
        object1.b = "my string value";

        object2.a = 23;
        object2.b = "my other string value";

        System.out.println("Fields of object1:");
        object1.printMyFields();

        System.out.println("Fields of object2:");
        object2.printMyFields();
    }
}
