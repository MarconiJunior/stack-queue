import queue.QueueApp;
import stack.BrowserNavigation;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createMenu);
    }

    private static void createMenu() {
        JFrame frame = new JFrame("Escolha a Aplicação");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 1));

        JButton queueAppButton = createQueueAppButton(frame);
        JButton browserAppButton = createBrowserAppButton(frame);

        frame.add(queueAppButton);
        frame.add(browserAppButton);

        frame.setVisible(true);
    }

    private static JButton createQueueAppButton(JFrame frame) {
        JButton button = new JButton("Gerenciamento de Fila de Pacientes");
        button.addActionListener(e -> {
            openQueueApp();
            frame.dispose();
        });
        return button;
    }

    private static JButton createBrowserAppButton(JFrame frame) {
        JButton button = new JButton("Navegador");
        button.addActionListener(e -> {
            openBrowserNavigation();
            frame.dispose();
        });
        return button;
    }

    private static void openQueueApp() {
        SwingUtilities.invokeLater(QueueApp::new);
    }

    private static void openBrowserNavigation() {
        SwingUtilities.invokeLater(BrowserNavigation::new);
    }
}
