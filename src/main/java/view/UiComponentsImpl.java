package view;

import javax.swing.*;
import java.awt.*;

public class UiComponentsImpl implements UiComponents {

    private static final String FETCH_QUOTE = "Random quote!";
    private JTextArea quoteTextArea;
    private JTextField characterTextField;
    private JButton fetchQuoteButton;
    private JPanel contentPanel;

    public UiComponentsImpl() {
        buildUI();
        setStyle();
    }

    @Override
    public void openWindow() {
        JFrame frame = new JFrame();
        frame.setContentPane(contentPanel);
        frame.setMinimumSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void buildUI() {
        addContentPanel();
        addFetchQuotePanel();
        addQuoteTextPanel();
        addQuoteCharacterPanel();
    }

    private void addContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
    }

    private void addFetchQuotePanel() {
        JPanel fetchQuotePanel = new JPanel();
        fetchQuotePanel.setLayout(new BorderLayout());
        fetchQuotePanel.setMaximumSize(new Dimension(400, 50));
        fetchQuoteButton = new JButton(FETCH_QUOTE);
        fetchQuotePanel.add(fetchQuoteButton);
        contentPanel.add(fetchQuotePanel);
    }

    private void addQuoteTextPanel() {
        JPanel quoteTextPanel = new JPanel();
        quoteTextPanel.setLayout(new BorderLayout());
        quoteTextPanel.setMaximumSize(new Dimension(400, 300));
        quoteTextArea = new JTextArea();
        quoteTextArea.setLineWrap(true);
        quoteTextArea.setWrapStyleWord(true);
        quoteTextPanel.add(quoteTextArea);
        contentPanel.add(quoteTextPanel);
    }

    private void addQuoteCharacterPanel() {
        JPanel quoteCharacterPanel = new JPanel();
        quoteCharacterPanel.setLayout(new BorderLayout());
        quoteCharacterPanel.setMaximumSize(new Dimension(400, 50));
        characterTextField = new JTextField();
        quoteCharacterPanel.add(characterTextField);
        contentPanel.add(quoteCharacterPanel);
    }

    private void setStyle() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JTextArea getQuoteTextArea() {
        return quoteTextArea;
    }

    @Override
    public JButton getFetchQuoteButton() {
        return fetchQuoteButton;
    }

    @Override
    public JTextField getCharacterTextField() {
        return characterTextField;
    }
}
