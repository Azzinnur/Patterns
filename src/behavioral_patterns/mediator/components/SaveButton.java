package behavioral_patterns.mediator.components;

import behavioral_patterns.mediator.mediator.Mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveButton extends JButton implements Component {
    private Mediator mediator;

    public SaveButton() {
        super("Save");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void fireActionPerformed(ActionEvent actionEvent) {
        mediator.saveChanges();
    }

    @Override
    public String getName() {
        return "SaveButton";
    }
}
