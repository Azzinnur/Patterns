package creative_patterns.factory_method.factories;

import creative_patterns.factory_method.MacOs;
import creative_patterns.factory_method.OperationalSystem;

public class MacOSFactory implements OSFactory{
    @Override
    public OperationalSystem determineOs() {
        return new MacOs();
    }
}
