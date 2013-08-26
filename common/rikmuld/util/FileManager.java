package rikmuld.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import rikmuld.main.SkinLoader;
import rikmuld.main.Start;
import rikmuld.skin3D.skin.SkinCollection;
import rikmuld.skin3D.world.Skin3DWorld;

public class FileManager {

	public static String dir = SkinLoader.skinFileFinder.getFileSystemView().getDefaultDirectory()+"/SkinViewer/";
	private static String request;

	public static void startUp()
	{
		if(!propsExist())
		{
			createProps();
			if(loadDefaultCollection()==false) createDefaultCollection();
		}
		else
		{
			if(!getCollection())
			{
				if(loadDefaultCollection()==false) createDefaultCollection();
			}
		}

		Start.gui.panel.repaint();
	}

	public static boolean getCollection()
	{
		File file = new File(FileManager.dir+"props.info");
		if(file.exists())
		{
			try
			{
				Scanner scanner = new Scanner(new FileReader(file));
				if(scanner.hasNext())
				{
					if(loadCollection(scanner.next()))
					{
						scanner.close();

						if(Skin3DWorld.skins.curr!=-1&&Skin3DWorld.skins.skins[Skin3DWorld.skins.curr]!=null)
						{
							Start.gui.panel.loader.setSkinFile(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].skinFile);
							Start.gui.panel.part = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].part;
							Start.gui.panel.view = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].view;
							Start.gui.panel.skinName = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].name;
							Start.gui.panel.skinSize = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].size;
							Start.gui.panel.size.setValue(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].size);
						}

						Start.gui.panel.repaint();
						return true;
					}
				}
				scanner.close();
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}

	public static void createProps()
	{
		(new File(FileManager.dir)).mkdir();

		File file = new File(FileManager.dir+"props.info");

		try
		{
			file.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write("default");
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void saveProps()
	{
		File file = new File(FileManager.dir+"props.info");

		file.delete();

		try
		{
			file.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(Skin3DWorld.skins.getName());
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void createDefaultCollection()
	{
		Skin3DWorld.skins = new SkinCollection("default", 100);
	}

	public static boolean loadDefaultCollection()
	{
		if(SkinCollection.loadCollectionFromDisk("default"))
		{
			if(Skin3DWorld.skins.skins[0]!=null)
			{
				Start.gui.panel.loader.setSkinFile(Skin3DWorld.skins.skins[0].skinFile);
				Start.gui.panel.part = Skin3DWorld.skins.skins[0].part;
				Start.gui.panel.view = Skin3DWorld.skins.skins[0].view;
				Start.gui.panel.skinName = Skin3DWorld.skins.skins[0].name;
				Start.gui.panel.skinSize = Skin3DWorld.skins.skins[0].size;
				Start.gui.panel.size.setValue(Skin3DWorld.skins.skins[0].size);
			}
			Start.gui.panel.repaint();
		}
		return false;
	}

	public static boolean propsExist()
	{
		return (new File(dir+"props.info")).exists();
	}

	public static boolean loadCollection(String name)
	{
		if(SkinCollection.loadCollectionFromDisk(name))
		{
			if(Skin3DWorld.skins.curr!=-1&&Skin3DWorld.skins.skins[Skin3DWorld.skins.curr]!=null)
			{
				Start.gui.panel.loader.setSkinFile(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].skinFile);
				Start.gui.panel.part = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].part;
				Start.gui.panel.view = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].view;
				Start.gui.panel.skinName = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].name;
				Start.gui.panel.skinSize = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].size;
				Start.gui.panel.size.setValue(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].size);
			}

			Start.gui.panel.repaint();
			return true;
		}
		return false;
	}

	public static void requestCollection(String string)
	{
		request = string;
	}

	public static void updateRequest()
	{
		if(request!="")
		{
			loadCollection(request);
			request = "";
		}
	}
}
