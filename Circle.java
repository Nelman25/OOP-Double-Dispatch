public class Circle implements Shape{
    @Override
    public String drawWith(Tool tool) {
        tool.useOnCircle(this);
        return null;
    }
}
