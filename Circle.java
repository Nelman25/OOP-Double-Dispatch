public class Circle implements Shape{
    @Override
    public void drawWith(Tool tool) {
        tool.useOnCircle(this);
    }
}
