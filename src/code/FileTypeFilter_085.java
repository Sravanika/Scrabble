package code;

import java.io.File;

import javax.swing.filechooser.*;

public class FileTypeFilter_085 extends FileFilter{
	private final String extension;
	private final String description;
	/**
	 * Supports the save class with a FileTypeFilter 
	 * @author ziangzha (Ziang Zhao)
	 * @param extension
	 * @param description
	 */
	public FileTypeFilter_085(String extension, String description){
		this.extension = extension;
		this.description = description;
	}
	/**
	 * An boolean method that returns true if the file is in the directory
	 * @author ziangzha (Ziang Zhao)
	 */
	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		return file.getName().endsWith(extension);
	}
	/**
	 * Gets the decription of the file
	 */
	@Override
	public String getDescription() {
		return description + String.format(" (*%s)", extension);
	}
}


