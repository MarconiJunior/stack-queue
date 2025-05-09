package queue;

import common.Node;
import queue.patient.Patient;
import queue.patient.QueueController;

import javax.swing.*;
import java.awt.*;

public class QueueApp {
    private final QueueController queueController;
    private final JLabel lastCalledLabel;
    private final JButton callNextButton = new JButton("Chamar Próximo Paciente");

    public QueueApp() {
        queueController = new QueueController();
        JFrame frame = new JFrame("Gerenciamento de Fila de Pacientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        lastCalledLabel = new JLabel("Último paciente chamado: Nenhum");
        frame.add(createTopPanel(), BorderLayout.NORTH);
        frame.add(createCenterPanel(), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    /**
     * Creates the top panel which displays the last called patient.
     *
     * @return The top panel.
     */
    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.add(lastCalledLabel);
        return topPanel;
    }

    /**
     * Creates the center panel with buttons for registering a new patient,
     * calling the next patient, and displaying called patients.
     *
     * @return The center panel.
     */
    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new GridLayout(3, 1));

        JButton registerButton = new JButton("Registrar Novo Paciente");
        JButton showCalledButton = new JButton("Mostrar Pacientes Chamados");
        callNextButton.setEnabled(false);

        registerButton.addActionListener(_ -> registerPatient());
        callNextButton.addActionListener(_ -> callNextPatient());
        showCalledButton.addActionListener(_ -> showCalledPatients());

        centerPanel.add(registerButton);
        centerPanel.add(callNextButton);
        centerPanel.add(showCalledButton);

        return centerPanel;
    }

    /**
     * Registers a new patient by prompting the user to input their name.
     * If the name is empty, an error message is displayed.
     */
    private void registerPatient() {
        String name;
        do {
            name = JOptionPane.showInputDialog("Digite o nome do paciente:");
            if (name == null || name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "O nome não pode estar vazio!",
                        "Erro", JOptionPane.ERROR_MESSAGE
                );
            }
        } while (name == null || name.trim().isEmpty());

        queueController.registerAndEnqueuePatient(name);
        callNextButton.setEnabled(true);
    }

    /**
     * Calls the next patient in the queue and updates the display.
     * If there are no patients left in the queue, the button is disabled.
     */
    private void callNextPatient() {
        if (!queueController.getPatientInQueue().isEmpty()) {
            queueController.callNextPatient();
            String name = queueController.getLastCalledPatient().getName();
            lastCalledLabel.setText("Último paciente chamado: " + name);
        }
        callNextButton.setEnabled(!queueController.getPatientInQueue().isEmpty());
    }

    /**
     * Displays a list of all patients who have been called.
     */
    private void showCalledPatients() {
        StringBuilder sb = new StringBuilder("Pacientes chamados:\n");
        Node<Patient> current = queueController.getCalledPatients().peek();
        while (current != null) {
            String name = current.getValue().getName();
            sb.append("- ").append(name).append("\n");
            current = current.getNext();
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
