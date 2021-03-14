package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import backend.Docx4JAPI;

/** gui for fil-liste og visning. 
 * Panel med en scrollpane for fillisten
 * og en label for visning av meta-info
 * samt en funksjon for å tømme begge viewene
*/

public class MetaInformationViewer extends JPanel {

	private Docx4JAPI metagrensesnitt;
	DefaultListModel<String> model;

	final JList<String> list = new JList<>(model = new DefaultListModel<String>());
	final JLabel label = new JLabel("Select a file");
	final JScrollPane scroll = new JScrollPane(list);

	MetaInformationViewer() {

		scroll.setPreferredSize(new Dimension(350, 300));

		setLayout(new BorderLayout());
		add(scroll, BorderLayout.WEST);
		add(label, BorderLayout.EAST);

		label.setPreferredSize(new Dimension(350, 300));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				if (!list.isSelectionEmpty()) {
					metagrensesnitt = new Docx4JAPI(list.getSelectedValue().toString());
					label.setText("<html><body><h2 align=center>Docx Meta Information</h2>"
							+ "<h4 align=center>for file: </h4><p align=center>" + metagrensesnitt.getFilename()
							+ "</p><hr/><table>" + "<tr><td>Title: </td><td>" + metagrensesnitt.getTitle()
							+ "</td></tr><tr><td>Creator: </td><td>" + metagrensesnitt.getCreator()
							+ "</td></tr><tr><td>Created: </td><td>" + metagrensesnitt.getCreated()
							+ "</td></tr><tr><td>Modified: </td><td>" + metagrensesnitt.getModified()
							+ "</td></tr><tr><td>Last Modified by: </td><td>" + metagrensesnitt.getLastModifiedBy()
							+ "</td></tr><tr><td>Last printed: </td><td>" + metagrensesnitt.getLastPrinted()
							+ "</td></tr><tr><td>Revision: </td><td>" + metagrensesnitt.getRevision()
							+ "</td></tr></table></body></html>");
				}
			}
		});

	}
	
	void clear() {
		label.setText("Select a file");
		model.removeAllElements();
	}
}