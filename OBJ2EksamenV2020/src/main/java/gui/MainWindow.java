package gui;

import java.awt.event.*;
import javax.swing.*;
import fileChooser.FileChooser;

/** Hovedvindu for gui med
 * meny og meny-actions
*/

public class MainWindow extends JFrame implements ActionListener{

    private MetaInformationViewer metaInformationViewer;
    
    public MainWindow() {
        setTitle("Docx Meta Information");
        setJMenuBar(new MenuBar(this));
        setSize(700, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(metaInformationViewer = new MetaInformationViewer());
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e) {
 	   
 	   String clickedMenuItem = e.getActionCommand();
 	   
 	   if (clickedMenuItem.equals("Add a file")) {
 		   new FileChooser(metaInformationViewer.model);	   
 	   }
 	   
 	   if (clickedMenuItem.equals("Clear")) {
 		   metaInformationViewer.clear();           
	   }
 	   
 	   if (clickedMenuItem.equals("Exit")) {
 		   System.exit(0);
 	   }	   
    }
    
    private class MenuBar extends JMenuBar {
    	
    	MenuBar(MainWindow mainwindow) {
    		JMenu fileMenu = new JMenu("File");
    	    JMenuItem menuItem = new JMenuItem("Add a file");
    	    JMenuItem menuClear = new JMenuItem("Clear");
    	    JMenuItem menuExit = new JMenuItem("Exit");
    	    fileMenu.add(menuItem);
    	    fileMenu.add(menuClear);
    	    fileMenu.add(menuExit);
    	    add(fileMenu);
    	    
    	    menuItem.addActionListener(mainwindow);
    	    menuClear.addActionListener(mainwindow);
    	    menuExit.addActionListener(mainwindow);
    	    
    	}	
    }
}