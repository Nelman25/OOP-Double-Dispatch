public class Pen implements Tool {

    MainFrame mainFrame = new MainFrame();
    @Override
    public void useOnCircle(Circle circle) {
        mainFrame.text.setText("Using pen on Circle");
    }

    @Override
    public void useOnSquare(Square square) {
        mainFrame.text.setText("Using pen on Square");
    }
}
