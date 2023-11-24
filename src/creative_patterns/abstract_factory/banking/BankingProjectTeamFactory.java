package creative_patterns.abstract_factory.banking;

import creative_patterns.abstract_factory.Developer;
import creative_patterns.abstract_factory.ProjectManager;
import creative_patterns.abstract_factory.ProjectTeamFactory;
import creative_patterns.abstract_factory.Tester;

public class BankingProjectTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingProjectManager();
    }
}
