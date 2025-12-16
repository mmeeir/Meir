public class Main {
  public static void main(String[] args) {

    //1task
    Rectangle r1 = new Rectangle();
    Rectangle r2 = new Rectangle(3, 4);

    System.out.println(r1);
    System.out.println("Area: " + r1.area());
    System.out.println("Perimeter: " + r1.perimeter());

    System.out.println();

    System.out.println(r2);
    System.out.println("Area: " + r2.area());
    System.out.println("Perimeter: " + r2.perimeter());
    //2task
    Book b1 = new Book("1984", "George Orwell", 1949);
    Book b2 = new Book("Harry Potter", "J.K. Rowling", 1997);

    System.out.println(b1);
    System.out.println(b2);

    // Проверка изменения статуса книги
    b1.markAsBorrowed();
    System.out.println("После взятия книги: " + b1);

    b1.markAsReturned();
    System.out.println("После возврата книги: " + b2);
  }
}



