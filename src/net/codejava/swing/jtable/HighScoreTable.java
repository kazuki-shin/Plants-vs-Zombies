/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * 
 */

package net.codejava.swing.jtable;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import Pvz.CustomButton;
import Pvz.ScoreReader;
 
/**
 * A HighScoreTable keeps a log of the scores for the 20 most recent players of the game
 */
public class HighScoreTable extends JFrame implements ActionListener {
 
    private JTable table;
    private DefaultTableModel tableModel;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemRemove;
    private JMenuItem menuItemRemoveAll;
     
    /**
     * Constructs a table and adds data for the scores
     */
    public HighScoreTable() {
        super("Plants vs Zombies: 20 Most Recent Scores");
         
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        Font font2 = new Font("MonoSpaced", Font.BOLD, 20);
        JButton button = new JButton("Back to Menu");
        CustomButton.makeButton2(button);
        button.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
            	setVisible(false);
            }
        });
        panel.add(button);
        
        
        // sample table data
        String[] columnNames = new String[] {"Game Log", "Name", "Zombies Killed","Comments"};
        String[][] rowData = ScoreReader.list2;
         
        // constructs the table with sample data
        try {
			tableModel = new DefaultTableModel(ScoreReader.loadFromFile(), columnNames);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        table = new JTable(tableModel);
        table.getTableHeader().setBackground(Color.BLACK);
        table.getTableHeader().setForeground(Color.GREEN);
        Font font = new Font("MonoSpaced", Font.PLAIN, 20);
        table.getTableHeader().setFont(font);
        table.setFont(font);
        table.setForeground(Color.GREEN);
        table.setRowHeight(30);
        table.setBackground(Color.BLACK);
         
        // adds the table to the frame
        add(panel, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane(table,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(Color.black);
        add(scrollPane, BorderLayout.CENTER);
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 688);
        setLocationRelativeTo(null);
    }

 
    /**
     * Determines the action that is being performed in the table
     */
    public void actionPerformed(ActionEvent event) {
        JMenuItem menu = (JMenuItem) event.getSource();
        if (menu == menuItemAdd) {
            addNewRow();
        } else if (menu == menuItemRemove) {
            removeCurrentRow();
        } else if (menu == menuItemRemoveAll) {
            removeAllRows();
        }
    }
     
    /**
     * Adds a new row to the table
     */
    private void addNewRow() {
        tableModel.addRow(new String[0]);
    }
    
    /**
     * Removes the selected row fromt the table
     */
    private void removeCurrentRow() {
        int selectedRow = table.getSelectedRow();
        tableModel.removeRow(selectedRow);
    }
     
    /**
     * Removes all the rows in the table
     */
    private void removeAllRows() {
        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tableModel.removeRow(0);
        }
    }
    
}