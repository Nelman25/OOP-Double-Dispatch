public class Pen implements Tool {
    @Override
    public void useOnCircle(Circle circle) {
        MainFrame.text.setText("Using pen on Circle");
    }

    @Override
    public void useOnSquare(Square square) {
        MainFrame.text.setText("Using pen on Square");
    }
}
