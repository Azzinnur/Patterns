package creative_patterns.factory_method.factories;

import creative_patterns.factory_method.LinuxOs;
import creative_patterns.factory_method.OperationalSystem;

public class LinuxOSFactory implements OSFactory{
    @Override
    public OperationalSystem determineOs() {
        return new LinuxOs();
    }
}
