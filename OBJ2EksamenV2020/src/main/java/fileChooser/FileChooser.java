package fileChooser;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/** Hent-fil dialog
*/

public class FileChooser {
	
	public FileChooser(DefaultListModel<String> model) {
	
    JFileChooser fileChooser = new JFileChooser();
    
    FileNameExtensionFilter filter = new FileNameExtensionFilter("doc","docx");
    fileChooser.setFileFilter(filter);
    fileChooser.setMultiSelectionEnabled(true);
    
    String location = FileLocation.FileLocation.get(System.getProperty("user.home"));
    fileChooser.setCurrentDirectory(new File(location));
    
    fileChooser.showOpenDialog(new JFrame());

    File[] selectedFiles = fileChooser.getSelectedFiles();
    for(File f : selectedFiles){
        model.addElement(f.getPath());
        FileLocation.FileLocation.put(f.getParentFile().getAbsolutePath());
    }
    
}
}
