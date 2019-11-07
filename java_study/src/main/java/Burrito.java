enum Spiciness {
    NOT, MILD, MEDIUM, HOT, FLAMING
}

public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }
    public void describe() {
        System.out.print("This burrito is ");
        switch(degree) {
            case NOT:
                System.out.println("NOT");
                break;
            case MILD:
                System.out.println("MILD");
                break;
            case HOT:
                System.out.println("HOT");
                break;
            case FLAMING:
            default:
                System.out.println("FLAMING");
        }
    }

    public static void main(String[] args) {
        Burrito
            plain = new Burrito(Spiciness.NOT),
            greenChild = new Burrito(Spiciness.MEDIUM),
            jalapeno = new Burrito(Spiciness.HOT);
        plain.describe();
        greenChild.describe();
        jalapeno.describe();
    }
}
