public class Brush implements Tool{
    @Override
    public void useOnCircle(Circle circle) {
        System.out.println("Using brush on circle");
    }
    @Override
    public void useOnSquare(Square square) {
        System.out.println("Using brush on square");
    }
}
