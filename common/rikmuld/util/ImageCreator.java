package rikmuld.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class ImageCreator {

	public static boolean shot = false;
	private static File imgFile;
	
	public static void makeScreenshot()
	{
		shot = false;

		GL11.glReadBuffer(GL11.GL_FRONT);
		int width = Display.getDisplayMode().getWidth();
		int height= Display.getDisplayMode().getHeight();
		int bytesPerPixel = 4;
		ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * bytesPerPixel);
		GL11.glReadPixels(0, 0, width, height, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer);
				
		if(!imgFile.getName().endsWith(".png"))
		{
			imgFile = new File(imgFile.getAbsolutePath()+".png");
		}
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				int i = (x + (width * y)) * bytesPerPixel;
				int r = buffer.get(i) & 0xFF;
				int g = buffer.get(i + 1) & 0xFF;
				int b = buffer.get(i + 2) & 0xFF;
				image.setRGB(x, height - (y + 1), (0xFF << 24) | (r << 16) | (g << 8) | b);
			}
		}
		
		try 
		{
			ImageIO.write(image, "png", imgFile);
		} 
		catch (IOException e) 
		{ 
			e.printStackTrace();
		}
	}

	public static void requestScreenshot(File file)
	{
		shot = true;
		imgFile = file;
	}
}
