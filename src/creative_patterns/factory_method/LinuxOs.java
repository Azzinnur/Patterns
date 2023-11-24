package creative_patterns.factory_method;

public class LinuxOs implements OperationalSystem{
    @Override
    public void getOs() {
        System.out.println("Установить программу для Linux");
    }
}
