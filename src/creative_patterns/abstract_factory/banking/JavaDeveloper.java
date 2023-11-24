package creative_patterns.abstract_factory.banking;

import creative_patterns.abstract_factory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java Developer writes code");
    }
}
