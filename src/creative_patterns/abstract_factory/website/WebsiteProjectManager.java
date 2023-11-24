package creative_patterns.abstract_factory.website;

import creative_patterns.abstract_factory.ProjectManager;

public class WebsiteProjectManager implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Project manager manages website");
    }
}
