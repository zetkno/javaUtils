class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("yummy");
    }
}
class Peeler {
    static Apple peel(Apple apple) {
        return apple;
    }
}

class Apple {
    int i;

    Apple getPeeled() {
        i++;
        return Peeler.peel(this);
    }
}

public class PassingThis {
    int j;
    public void print(){
        System.out.println(j);
    }

    static void printArray(Object... args) {
        for (Object obj: args)
            System.out.print(obj +" ");
        System.out.println();
    }

    public static void main(String[] args) {
//        PassingThis pass = new PassingThis();
//        printArray(new Integer(47), new Float(3.14), new Double(11.11));
//        printArray(11,"String", 'c', 3.2);
//        Spiciness howHot = Spiciness.MEDIUM;
//        System.out.println(howHot);
        for (Spiciness s : Spiciness.values()) {
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }
}


