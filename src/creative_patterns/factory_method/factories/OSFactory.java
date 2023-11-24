package creative_patterns.factory_method.factories;

import creative_patterns.factory_method.LinuxOs;
import creative_patterns.factory_method.MacOs;
import creative_patterns.factory_method.OperationalSystem;
import creative_patterns.factory_method.WindowsOs;

public interface OSFactory {
    OperationalSystem determineOs();

    static OperationalSystem selectOperationSystem(String system) {
        OperationalSystem operationalSystem = null;
        switch (system.toLowerCase()) {
            case ("windows"):
                operationalSystem = new WindowsOs();
                break;
            case ("linux"):
                operationalSystem = new LinuxOs();
                break;
            case ("macos"):
                operationalSystem = new MacOs();
                break;
            default:
                throw new RuntimeException(system + " is not a valid Operational System");
        }
        return operationalSystem;
    }
}
