package creative_patterns.factory_method;

public class WindowsOs implements OperationalSystem{
    @Override
    public void getOs() {
        System.out.println("Установить программу для Windows");
    }
}
