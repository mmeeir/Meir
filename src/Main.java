public class Main {
  public static void main(String[] args) {

    Rectangle r1 = new Rectangle();
    Rectangle r2 = new Rectangle(3, 4);

    System.out.println(r1);
    System.out.println("Area: " + r1.area());
    System.out.println("Perimeter: " + r1.perimeter());

    System.out.println();

    System.out.println(r2);
    System.out.println("Area: " + r2.area());
    System.out.println("Perimeter: " + r2.perimeter());
  }
}



