package rikmuld.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SkinFileRquirements {

	private static boolean hasGoodAspectRatio(BufferedImage skinFile)
	{
		if(((skinFile.getHeight() % 32) == 0) && ((skinFile.getWidth() % 64) == 0) && ((skinFile.getWidth() / skinFile.getHeight()) == 2)) return true;
		else return false;
	}

	private static boolean hasGoodAspectRatio(File file)
	{
		BufferedImage skinFile = null;

		try
		{
			skinFile = ImageIO.read(file);
		}
		catch(IOException e)
		{

			e.printStackTrace();
		}

		return hasGoodAspectRatio(skinFile);
	}

	private static boolean isPngFile(File file)
	{
		if(file.getName().substring(file.getName().length() - 4, file.getName().length()).equals(".png")) return true;
		else return false;
	}

	public static boolean isSkinFile(BufferedImage file)
	{
		return hasGoodAspectRatio(file);
	}

	public static boolean isSkinFile(File file)
	{
		if(isPngFile(file) && hasGoodAspectRatio(file)) return true;
		return false;
	}
}
