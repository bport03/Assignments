package sql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class data {
    public static class Main extends JFrame implements ActionListener {

        private JComboBox<String> tablesComboBox;
        private DefaultTableModel tableModel;
        private JFrame frame;
        private JTable table;
        private JButton addButton;
        private JButton deleteButton;

        public Main() {
            super("Table Viewer");
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // create components
            tablesComboBox = new JComboBox<>();
            tablesComboBox.addActionListener(this);



            JButton addButton =  new JButton("Add User");
            addButton.addActionListener(this);
            JButton deleteButton = new JButton("Delete User");
            deleteButton.addActionListener(this);
            JButton Average =  new JButton("Average");
            Average.addActionListener(this);



            // create layout
            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            topPanel.add(new JLabel("Select a Table: "));
            topPanel.add(tablesComboBox);

            topPanel.add(addButton);
            topPanel.add(deleteButton);
            topPanel.add(Average);



            add(topPanel, BorderLayout.NORTH);

            tableModel = new DefaultTableModel();
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);

            Average.addActionListener(e -> {

                final JFrame parent = new JFrame();
                JButton button = new JButton();

                button.setText("Calculate Avg ");
                parent.setSize(900, 800);
                parent.add(button);
                parent.pack();
                parent.setVisible(true);
                button.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        String name = JOptionPane.showInputDialog(parent, "Enter table name: ", null);
                        String col = JOptionPane.showInputDialog(parent, "Enter table column: ", null);
                        try {
                            calculateAverage(name,col);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });


                // calculateAverage();

            });

            addButton.addActionListener(e -> {
                // add new row to table model
                tableModel.addRow(new Object[]{"", "", ""});
            });


            deleteButton.addActionListener(e -> {
                // get selected row index
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // if row is selected
                    // remove row from table model
                    tableModel.removeRow(selectedRow);
                }
            });

            // populate the tables combo box
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJECT", "root", "bp813562");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SHOW TABLES");
                while (rs.next()) {
                    String tableName = rs.getString(1);
                    tablesComboBox.addItem(tableName);
                }
                conn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == tablesComboBox || e.getActionCommand().equals("View Table")) {
                String selectedTable = tablesComboBox.getSelectedItem().toString();
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJECT", "root", "bp813562");
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM " + selectedTable);

                    // get column names
                    int columnCount = rs.getMetaData().getColumnCount();
                    Vector<String> columnNames = new Vector<>();
                    for (int i = 1; i <= columnCount; i++) {
                        columnNames.add(rs.getMetaData().getColumnName(i));
                    }
                    tableModel.setColumnIdentifiers(columnNames);

                    // get row data
                    Vector<Vector<Object>> data = new Vector<>();
                    while (rs.next()) {
                        Vector<Object> row = new Vector<>();
                        for (int i = 1; i <= columnCount; i++) {
                            row.add(rs.getObject(i));
                        }
                        data.add(row);
                    }
                    tableModel.setDataVector(data, columnNames);

                    conn.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }
        }

        public static void main(String[] args) {
            Main main = new Main();
            main.setVisible(true);


        }


        public void calculateAverage(String tableName, String columnName) throws Exception {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJECT", "root", "bp813562");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT AVG(" + columnName + ") FROM " + tableName);
            if (rs.next()) {
                final JFrame parent = new JFrame();
                JButton button = new JButton();

                button.setText("Average of " + columnName + ": " + rs.getDouble(1));
                parent.setSize(900, 800);
                parent.add(button);
                parent.pack();
                parent.setVisible(true);
            }

            rs.close();
            stmt.close();

        }
    }
}
