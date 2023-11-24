package creative_patterns.factory_method.factories;

import creative_patterns.factory_method.OperationalSystem;
import creative_patterns.factory_method.WindowsOs;

public class WindowsOSFactory implements OSFactory{
    @Override
    public OperationalSystem determineOs() {
        return new WindowsOs();
    }
}
