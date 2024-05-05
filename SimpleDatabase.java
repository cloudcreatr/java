import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

class DatabaseUI extends JFrame {
    private SimpleDatabase db;
    private JTextField tableNameField;
    private JTextField columnNamesField;
    private JTextField rowField;
    private JTable outputTable;
    private JLabel feedbackLabel; // Label to provide feedback to the user

    public DatabaseUI() {
        db = new SimpleDatabase();

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        tableNameField = new JTextField(20);
        columnNamesField = new JTextField(20);
        rowField = new JTextField(20);
        outputTable = new JTable();
        feedbackLabel = new JLabel(); // Initialize the feedback label

        JButton createTableButton = new JButton("Create Table");
        createTableButton.addActionListener(e -> {
            String tableName = tableNameField.getText();
            if (tableName.isEmpty()) {
                feedbackLabel.setText("Error: Table name cannot be empty.");
                return;
            }
            List<String> columns = Arrays.asList(columnNamesField.getText().split(","));
            if (columns.isEmpty()) {
                feedbackLabel.setText("Error: Column names cannot be empty.");
                return;
            }
            db.createTable(tableName, columns);
            feedbackLabel.setText("Success: Table " + tableName + " created.");
        });

        JButton addRowButton = new JButton("Add Row");
        addRowButton.addActionListener(e -> {
            String tableName = tableNameField.getText();
            if (tableName.isEmpty()) {
                feedbackLabel.setText("Error: Table name cannot be empty.");
                return;
            }
            List<String> row = Arrays.asList(rowField.getText().split(","));
            if (row.isEmpty()) {
                feedbackLabel.setText("Error: Row data cannot be empty.");
                return;
            }
            SimpleDatabase.Table table = db.getTable(tableName);
            if (table != null) {
                table.addRow(row);
                feedbackLabel.setText("Success: Row added to " + tableName + ".");
            } else {
                feedbackLabel.setText("Error: Table " + tableName + " does not exist.");
            }
        });

        JButton displayTableButton = new JButton("Display Table");
        displayTableButton.addActionListener(e -> {
            String tableName = tableNameField.getText();
            if (tableName.isEmpty()) {
                feedbackLabel.setText("Error: Table name cannot be empty.");
                return;
            }
            SimpleDatabase.Table table = db.getTable(tableName);
            if (table != null) {
                Vector<String> columnNames = new Vector<>(table.getColumnNames());
                Vector<Vector<String>> data = new Vector<>();
                for (List<String> row : table.getRows()) {
                    data.add(new Vector<>(row));
                }
                outputTable.setModel(new DefaultTableModel(data, columnNames));
                feedbackLabel.setText("Success: Displaying table " + tableName + ".");
            } else {
                feedbackLabel.setText("Error: Table " + tableName + " does not exist.");
            }
        });

        add(new JLabel("Table Name:"));
        add(tableNameField);
        add(new JLabel("Column Names (comma separated):"));
        add(columnNamesField);
        add(new JLabel("Row (comma separated):"));
        add(rowField);
        add(createTableButton);
        add(addRowButton);
        add(displayTableButton);
        add(new JScrollPane(outputTable));
        add(feedbackLabel); // Add the feedback label to the JFrame

        getContentPane().setBackground(Color.LIGHT_GRAY); // Set the background color to light gray for better visibility
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
public class SimpleDatabase {
    private List<Table> tables = new ArrayList<>();

    public void createTable(String tableName, List<String> columnNames) {
        tables.add(new Table(tableName, columnNames));
    }

    public Table getTable(String tableName) {
        for (Table table : tables) {
            if (table.getTableName().equals(tableName)) {
                return table;
            }
        }
        return null;
    }

    public static class Table {
        private String tableName;
        private List<String> columnNames;
        private List<List<String>> rows = new ArrayList<>();

        public Table(String tableName, List<String> columnNames) {
            this.tableName = tableName;
            this.columnNames = columnNames;
        }

        public String getTableName() {
            return tableName;
        }

        public List<String> getColumnNames() {
            return columnNames;
        }

        public List<List<String>> getRows() {
            return rows;
        }

        public void addRow(List<String> row) {
            if (row.size() != columnNames.size()) {
                throw new IllegalArgumentException("Row size doesn't match column size");
            }
            rows.add(row);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DatabaseUI::new);
    }
}