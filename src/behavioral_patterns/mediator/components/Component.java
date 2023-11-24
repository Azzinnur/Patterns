package behavioral_patterns.mediator.components;

import behavioral_patterns.mediator.mediator.Mediator;

// Общий интерфейс компонента
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
