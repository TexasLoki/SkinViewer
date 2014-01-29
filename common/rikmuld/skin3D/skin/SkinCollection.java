package rikmuld.skin3D.skin;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.newdawn.slick.opengl.Texture;

import rikmuld.main.Start;
import rikmuld.skin2D.Stats2D;
import rikmuld.skin3D.Stats3D;
import rikmuld.skin3D.Stats3D.Background;
import rikmuld.skin3D.world.Skin3DWorld;
import rikmuld.util.FileManager;

public class SkinCollection {

	public static boolean loadCollectionFromDisk(String name)
	{
		SkinCollection collect = null;
		File file = new File(FileManager.dir + name + "/" + name + ".collection");
		int skinNum = 0;
		int current = 0;
		int background = 0;
		String[] nameSkin = null;
		boolean[][] skinPart = null;
		boolean[] hasBlock = null;
		Skin[] skin = null;

		if(file.exists())
		{
			try
			{
				Scanner scanner = new Scanner(new FileReader(file));

				skinNum = Integer.parseInt(scanner.next());
				current = Integer.parseInt(scanner.next());

				nameSkin = new String[skinNum];
				skinPart = new boolean[7][skinNum];
				hasBlock = new boolean[skinNum];

				Skin3DWorld.camera.vector.x = Float.parseFloat(scanner.next());
				Skin3DWorld.camera.vector.y = Float.parseFloat(scanner.next());
				Skin3DWorld.camera.vector.z = Float.parseFloat(scanner.next());
				Skin3DWorld.camera.rotation.x = Float.parseFloat(scanner.next());
				Skin3DWorld.camera.rotation.y = Float.parseFloat(scanner.next());
				Skin3DWorld.camera.rotation.z = Float.parseFloat(scanner.next());
				background = Integer.parseInt(scanner.next());

				Skin3DWorld.camera.setVector[0] = true;
				Skin3DWorld.camera.setVector[1] = true;

				for(int j = 0; j < skinNum; j++)
				{
					if(scanner.hasNext())
					{
						nameSkin[j] = scanner.next();
						skinPart[0][j] = Boolean.parseBoolean(scanner.next());
						skinPart[1][j] = Boolean.parseBoolean(scanner.next());
						skinPart[2][j] = Boolean.parseBoolean(scanner.next());
						skinPart[3][j] = Boolean.parseBoolean(scanner.next());
						skinPart[4][j] = Boolean.parseBoolean(scanner.next());
						skinPart[5][j] = Boolean.parseBoolean(scanner.next());
						skinPart[6][j] = Boolean.parseBoolean(scanner.next());
						hasBlock[j] = Boolean.parseBoolean(scanner.next());
					}
				}
				scanner.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

			try
			{
				collect = new SkinCollection(name, (skinNum == 0)? 1:100);

				skin = new Skin[skinNum];

				for(int i = 0; i < skinNum; i++)
				{
					if(nameSkin[i] != null)
					{
						BufferedImage skinFile = ImageIO.read((new File(FileManager.dir + name + "/" + nameSkin[i] + ".png")));
						String nameS = nameSkin[i];

						skin[i] = new Skin(skinFile, i, Skin3DWorld.grassTop, Skin3DWorld.grassSide, Skin3DWorld.grassBottom, nameS, collect);
						skin[i].stats.head = skinPart[0][i];
						skin[i].stats.headWear = skinPart[1][i];
						skin[i].stats.body = skinPart[2][i];
						skin[i].stats.armL = skinPart[3][i];
						skin[i].stats.armR = skinPart[4][i];
						skin[i].stats.legL = skinPart[5][i];
						skin[i].stats.legR = skinPart[6][i];
						skin[i].stats.hasBlock = hasBlock[i];
					}
				}

				collect.skins = skin;
				collect.stats.background = Background.values()[background];
				Skin3DWorld.skins = collect;
				Skin3DWorld.skins.curr = current;
				collect.saveCollectionToDisk();

				return true;
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	public int curr = 0;
	String name;

	public Skin[] skins;
	int id = -1;
	BufferedImage img;
	Texture texTop;
	Texture texSide;
	Texture texBottom;
	String skinName;

	public Stats3D stats = new Stats3D();

	public SkinCollection(String name, int size)
	{
		this.name = name.replaceAll("\\s", "");
		skins = new Skin[size];
	}

	public String getName()
	{
		return name;
	}

	public int getNextId()
	{
		int i = 0;
		for(Skin skin: skins)
		{
			if(skin == null) return i;
			i++;
		}
		return -1;
	}

	public void saveCollectionToDisk()
	{
		FileManager.saveProps();

		(new File(FileManager.dir)).mkdir();
		(new File(FileManager.dir + name)).mkdir();

		for(File file2: new File(FileManager.dir + name).listFiles())
		{
			file2.delete();
		}

		File file = new File(FileManager.dir + name + "/" + name + ".collection");

		try
		{
			file.createNewFile();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(Integer.toString(skins.length));
			out.newLine();
			out.write(Integer.toString(curr) + "\n");
			out.newLine();

			out.write(Float.toString(Skin3DWorld.camera.vector.getX()));
			out.newLine();
			out.write(Float.toString(Skin3DWorld.camera.vector.getY()));
			out.newLine();
			out.write(Float.toString(Skin3DWorld.camera.vector.getZ()));
			out.newLine();
			out.write(Float.toString(Skin3DWorld.camera.rotation.getX()));
			out.newLine();
			out.write(Float.toString(Skin3DWorld.camera.rotation.getY()));
			out.newLine();
			out.write(Float.toString(Skin3DWorld.camera.rotation.getZ()));
			out.newLine();
			out.write(Integer.toString(stats.background.ordinal()));
			out.newLine();

			for(int i = 0; i < skins.length; i++)
			{
				if(skins[i] != null)
				{
					out.write(skins[i].name.replaceAll("\\s", ""));
					out.newLine();
					out.write(Boolean.toString(skins[i].stats.head));
					out.newLine();
					out.write(Boolean.toString(skins[i].stats.headWear));
					out.newLine();
					out.write(Boolean.toString(skins[i].stats.body));
					out.newLine();
					out.write(Boolean.toString(skins[i].stats.armL));
					out.newLine();
					out.write(Boolean.toString(skins[i].stats.armR));
					out.newLine();
					out.write(Boolean.toString(skins[i].stats.legL));
					out.newLine();
					out.write(Boolean.toString(skins[i].stats.legR));
					out.newLine();
					out.write(Boolean.toString(skins[i].stats.hasBlock));
					out.newLine();

					String fileName = name + "/" + skins[i].name + ".png";

					ImageIO.write(skins[i].skinFile, "png", (new File(FileManager.dir + fileName.replaceAll("\\s", ""))));
				}
			}

			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void setSkin(int id, BufferedImage img, Texture texTop, Texture texSide, Texture texBottom, String name)
	{
		curr = id;
		this.id = id;
		this.img = img;
		this.texTop = texTop;
		this.texSide = texSide;
		this.texBottom = texBottom;
		skinName = name;
	}

	public void updateSkins()
	{
		if(id != -1)
		{
			skins[id] = new Skin(img, id, texTop, texSide, texBottom, skinName, this);
			id = -1;
			img = null;
			texTop = null;
			texSide = null;
			skinName = "";

			saveCollectionToDisk();
			Stats2D.sync = true;
			Start.gui.panel.repaint();
		}
	}
}
