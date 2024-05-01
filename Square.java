public class Square implements Shape{
    @Override
    public String drawWith(Tool tool) {
        tool.useOnSquare(this);
        return null;
    }
}
