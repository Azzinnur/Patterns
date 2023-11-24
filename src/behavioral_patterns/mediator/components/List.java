package behavioral_patterns.mediator.components;

import behavioral_patterns.mediator.mediator.Mediator;
import behavioral_patterns.mediator.mediator.Note;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class List extends JList implements Component {
    private Mediator mediator;
    private final DefaultListModel defListModel;

    public List(DefaultListModel listModel) {
        super(listModel);
        this.defListModel = listModel;
        setModel(listModel);
        this.setLayoutOrientation(JList.VERTICAL);
        Thread thread = new Thread(new Hide(this));
        thread.start();
    }


    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void addElement(Note note) {
        defListModel.addElement(note);
        int index = defListModel.size() - 1;
        setSelectedIndex(index);
        ensureIndexIsVisible(index);
        mediator.sendToFilter(defListModel);
    }

    public void deleteElement() {
        int index = this.getSelectedIndex();
        try {
            defListModel.remove(index);
            mediator.sendToFilter(defListModel);
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }


    public Note getCurrentElement() {
        return (Note) getSelectedValue();
    }

    @Override
    public String getName() {
        return "List";
    }

    private class Hide implements Runnable {
        private List list;

        Hide(List list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                mediator.hideElements(list.isSelectionEmpty());
            }
        }
    }
}
