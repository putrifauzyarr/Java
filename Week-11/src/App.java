import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class App {
    private final DefaultTableModel tableModel;
    private final JTextField nameField;
    private final JTextField emailField;
    private final JTextField phoneField;
    private JTable table;

    public App() {
        tableModel = new DefaultTableModel(
                new String[]{"Name", "Email", "Phone"},
                0
        );

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);

        JFrame frame = new JFrame("Contact Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        frame.add(createFormPanel(), BorderLayout.NORTH);
        frame.add(createTablePanel(), BorderLayout.CENTER);
        frame.add(createButtonPanel(), BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Input Contact"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        panel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(phoneField, gbc);

        JButton addButton = new JButton("Add to List");
        addButton.addActionListener(e -> addContact());

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 0;
        panel.add(addButton, gbc);

        return panel;
    }

    private JScrollPane createTablePanel() {
        table = new JTable(tableModel);
        table.setRowHeight(24);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Contact List"));
        scrollPane.setPreferredSize(new Dimension(500, 200));
        return scrollPane;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
 
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
 
        editButton.addActionListener(e -> editContact());
        deleteButton.addActionListener(e -> deleteContact());
 
        panel.add(editButton);
        panel.add(deleteButton);
        return panel;
    }

    private void addContact() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please fill in Name, Email, and Phone.",
                    "Validation",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        tableModel.addRow(new Object[]{name, email, phone});
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        nameField.requestFocus();
    }

    private void editContact() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please select a contact to edit.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
 
        String name = (String) tableModel.getValueAt(selectedRow, 0);
        String email = (String) tableModel.getValueAt(selectedRow, 1);
        String phone = (String) tableModel.getValueAt(selectedRow, 2);
 
        nameField.setText(name);
        emailField.setText(email);
        phoneField.setText(phone);
 
        tableModel.removeRow(selectedRow);
        nameField.requestFocus();
    }
 
    private void deleteContact() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please select a contact to delete.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
 
        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to delete this contact?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );
 
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.removeRow(selectedRow);
        }
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}