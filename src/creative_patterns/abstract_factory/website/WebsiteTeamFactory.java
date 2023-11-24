package creative_patterns.abstract_factory.website;

import creative_patterns.abstract_factory.Developer;
import creative_patterns.abstract_factory.ProjectManager;
import creative_patterns.abstract_factory.ProjectTeamFactory;
import creative_patterns.abstract_factory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new WebTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsiteProjectManager();
    }
}
