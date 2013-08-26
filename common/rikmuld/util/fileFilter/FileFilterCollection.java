package rikmuld.util.fileFilter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FileFilterCollection extends FileFilter {

	@Override
	public boolean accept(File f)
	{
		return f.getName().endsWith("collection")||f.isDirectory();
	}

	@Override
	public String getDescription()
	{
		return null;
	}
}
