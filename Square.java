public class Square implements Shape{
    @Override
    public void drawWith(Tool tool) {
        tool.useOnSquare(this);
    }
}
