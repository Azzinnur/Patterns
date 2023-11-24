package creative_patterns.abstract_factory.website;

import creative_patterns.abstract_factory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("PHP Developer writes website");
    }
}
