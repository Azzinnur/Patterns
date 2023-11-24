package behavioral_patterns.command.editor;

import behavioral_patterns.command.commands.Command;
import behavioral_patterns.command.commands.CommandHistory;
import behavioral_patterns.command.commands.CopyCommand;
import behavioral_patterns.command.commands.CutCommand;
import behavioral_patterns.command.commands.PasteCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor {
    private JTextArea textField;

    private String clipboard;
    private CommandHistory history = new CommandHistory();

    public void init() {
        JFrame frame = new JFrame("Редактор текста (можно печатать и использовать кнопки)");
        JPanel content = new JPanel();
        frame.setContentPane((content));
        frame.setDefaultCloseOperation((WindowConstants.EXIT_ON_CLOSE));
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Copy");
        JButton ctrlX = new JButton("Cut");
        JButton ctrlV = new JButton("Paste");
        JButton ctrlZ = new JButton("Undo");
        Editor editor = this;
        ctrlC.addActionListener(e -> executeCommand(new CopyCommand(editor)));
        ctrlX.addActionListener(e -> executeCommand(new CutCommand(editor)));
        ctrlV.addActionListener(e -> executeCommand(new PasteCommand(editor)));
        ctrlZ.addActionListener(e -> undo());
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        content.add(buttons);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    private void undo() {
        if (history.isEmpty()) return;

        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }

    public JTextArea getTextField() {
        return textField;
    }

    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }

}
