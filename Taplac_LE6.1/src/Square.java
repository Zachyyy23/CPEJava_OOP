// Square.java
public class Square extends DrawableShape {
    private int side;


    public Square(int x, int y, String color, int side) {
        super(x, y, color);
        this.side = side;
    }


    public int getSide() { return side; }
    public void setSide(int side) { this.side = side; }


    public int getArea() {
        return side * side;
    }


    public int getPerimeter() {
        return 4 * side;
    }


    @Override
    public void draw() {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}