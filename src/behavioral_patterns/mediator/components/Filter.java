package behavioral_patterns.mediator.components;

import behavioral_patterns.mediator.mediator.Mediator;
import behavioral_patterns.mediator.mediator.Note;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Filter extends JTextField implements Component {
    private Mediator mediator;
    private ListModel listModel;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void processComponentKeyEvent(KeyEvent keyEvent) {
        String start = getText();
        searchElements(start);
    }

    public void setList(ListModel listModel) {
        this.listModel = listModel;
    }

    private void searchElements(String s) {
        if (listModel == null) {
            return;
        }

        if (s.isEmpty()) {
            mediator.setElementsList(listModel);
            return;
        }

        List<Note> notes = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            notes.add((Note) listModel.getElementAt(i));
        }
        DefaultListModel<Note> defListModel = new DefaultListModel<>();
        for (Note note : notes) {
            if(note.getName().contains(s)) {
                defListModel.addElement(note);
            }
        }
        mediator.setElementsList(defListModel);
    }

    @Override
    public String getName() {
        return "Filter";
    }
}
