package stack;

import javax.swing.*;
import java.awt.*;

public class BrowserNavigation {
    private final Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentPage = "Página Inicial";
    private final JLabel pageLabel;
    private final JButton backButton;
    private final JButton forwardButton;

    public BrowserNavigation() {
        JFrame frame = new JFrame("Navegador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        pageLabel = new JLabel("Página Atual: " + currentPage, SwingConstants.CENTER);
        frame.add(pageLabel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        backButton = new JButton("← Voltar");
        forwardButton = new JButton("Avançar →");
        JButton newPageButton = new JButton("Nova Página");

        backButton.setEnabled(false);
        forwardButton.setEnabled(false);

        backButton.addActionListener(e -> goBack());
        forwardButton.addActionListener(e -> goForward());
        newPageButton.addActionListener(e -> visitNewPage());

        panel.add(backButton);
        panel.add(forwardButton);
        panel.add(newPageButton);

        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void visitNewPage() {
        String newPage = JOptionPane.showInputDialog("Digite o endereço da nova página:");
        if (newPage != null && !newPage.trim().isEmpty()) {
            backStack.push(currentPage);
            currentPage = newPage;
            forwardStack = new Stack<>();
            updateUI();
        }
    }

    private void goBack() {
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        updateUI();
    }

    private void goForward() {
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        updateUI();
    }

    private void updateUI() {
        pageLabel.setText("Página Atual: " + currentPage);
        backButton.setEnabled(!backStack.isEmpty());
        forwardButton.setEnabled(!forwardStack.isEmpty());
    }
}
