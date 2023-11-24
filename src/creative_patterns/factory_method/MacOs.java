package creative_patterns.factory_method;

public class MacOs implements  OperationalSystem{
    @Override
    public void getOs() {
        System.out.println("Установить программу для Mac OS");
    }
}
