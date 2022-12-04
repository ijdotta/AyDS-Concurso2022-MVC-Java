package view;

import javax.swing.*;

public interface UiComponents {
    void openWindow();
    JTextArea getQuoteTextArea();
    JButton getFetchQuoteButton();
    JTextField getCharacterTextField();
}
