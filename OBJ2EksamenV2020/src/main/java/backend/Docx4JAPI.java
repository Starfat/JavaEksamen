package backend;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

/** Grensesnittet mot docx4j
 * her finnes funksjoner for å hente ut 
 * filenavn og data fra core.xml
*/

public class Docx4JAPI {
		
	private String inputfilepath;
	private String title;
	private String creator;
	private String created;
	private String modified;
	private String lastModifiedBy;
	private String lastPrinted;
	private String revision;

	public Docx4JAPI(String filepath) {
		
		inputfilepath = filepath;
		
		WordprocessingMLPackage wordMLPackage = null;
		try {
			wordMLPackage = WordprocessingMLPackage.load(new java.io.File(inputfilepath));
		} catch (Docx4JException e) {
			e.printStackTrace();
		}
		
		org.docx4j.openpackaging.parts.DocPropsCorePart docPropsCorePart = wordMLPackage.getDocPropsCorePart();
		org.docx4j.docProps.core.CoreProperties coreProps = (org.docx4j.docProps.core.CoreProperties)docPropsCorePart.getJaxbElement();
			
		title = "?";
		List<String> titleList = coreProps.getTitle().getValue().getContent();
		if (titleList.size() > 0) {
			title = titleList.get(0);
		}
		
		creator = "?";
		List<String> creatorList = coreProps.getCreator().getContent();
		if (creatorList.size() > 0) {
			creator = creatorList.get(0);
		}
		
		created = "?";
		List<String> createdList = coreProps.getCreated().getContent();
		if (createdList.size() > 0) {
			created = createdList.get(0).replaceAll("T", " - ").replaceAll("Z", "");
		}
		
		modified = "?";
		List<String> modifiedList = coreProps.getModified().getContent();
		if (modifiedList.size() > 0) {
			modified = modifiedList.get(0).replaceAll("T", " - ").replaceAll("Z", "");
		}
		lastModifiedBy = coreProps.getLastModifiedBy();
		if (lastModifiedBy.equals(null)) {
			lastModifiedBy = "?";
		}
		
		lastPrinted = "?";
		XMLGregorianCalendar lastPrintedTemp = coreProps.getLastPrinted();
		if (lastPrintedTemp != null) {
			lastPrinted = lastPrintedTemp.toString().replaceAll("T", " - ").replaceAll("Z", "");
		}
		
		revision = "?";
		String revisionTemp = coreProps.getRevision();
		if (!revisionTemp.isEmpty()) {
			revision = revisionTemp.toString();
		}			
	}
			
	public String getTitle() {
		return this.title;
	}
	
	public String getCreator() {
		return this.creator;
	}
	
	public String getCreated() {
		return this.created;
	}
	
	public String getModified() {
		return this.modified;
	}
	
	public String getLastModifiedBy() {
		return this.lastModifiedBy;
	}
	
	public String getLastPrinted() {
		return this.lastPrinted;
	}
	
	public String getRevision() {
		return this.revision;
	}
	
	public String getFilepath() {
		return this.inputfilepath;
	}
	
	public String getFilename() {	
		Path p = Paths.get(inputfilepath);
		String filename = p.getFileName().toString();
		return filename;
	}
}
