package behavioral_patterns.mediator.components;

import behavioral_patterns.mediator.mediator.Mediator;
import behavioral_patterns.mediator.mediator.Note;

import javax.swing.*;
import java.awt.event.ActionEvent;

//  Конкретные компоненты никак не связаны между собой. У них есть только один канал общения – через посредника.
public class AddButton extends JButton implements Component {
    private Mediator mediator;

    public AddButton() {
        super("Add");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void fireActionPerformed(ActionEvent actionEvent) {
        mediator.addNewNote(new Note());
    }

    @Override
    public String getName() {
        return "AddButton";
    }
}
