public class Pen implements Tool{
    @Override
    public void useOnCircle(Circle circle) {
        System.out.println("Using pen on circle");
    }

    @Override
    public void useOnSquare(Square square) {
        System.out.println("Using pen on square");
    }
}
