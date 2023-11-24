package creative_patterns.abstract_factory.banking;

import creative_patterns.abstract_factory.ProjectManager;

public class BankingProjectManager implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Manager manages banking project");
    }
}
