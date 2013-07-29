package rikmuld.skin2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureLoader2D {

	public BufferedImage skinFile;
	public BufferedImage[] head = new BufferedImage[6];
	public BufferedImage[] headWear = new BufferedImage[6];
	public BufferedImage[] body = new BufferedImage[6];
	public BufferedImage[] arm = new BufferedImage[6];
	public BufferedImage[] leg = new BufferedImage[6];
	
	public void setSkinFile(BufferedImage file)
	{
		skinFile = file;
		
		head[0] = skinFile.getSubimage(skinFile.getHeight()/4, skinFile.getHeight()/4, skinFile.getHeight()/4, skinFile.getHeight()/4);
		head[1] = skinFile.getSubimage(0, skinFile.getHeight()/4, skinFile.getHeight()/4, skinFile.getHeight()/4);
		head[2] = skinFile.getSubimage((skinFile.getHeight()/4)*2, skinFile.getHeight()/4, skinFile.getHeight()/4, skinFile.getHeight()/4);
		head[3] = skinFile.getSubimage((skinFile.getHeight()/4)*3, skinFile.getHeight()/4, skinFile.getHeight()/4, skinFile.getHeight()/4);
		head[4] = skinFile.getSubimage(skinFile.getHeight()/4, 0, skinFile.getHeight()/4, skinFile.getHeight()/4);
		head[5] = skinFile.getSubimage((skinFile.getHeight()/4)*2, 0, skinFile.getHeight()/4, skinFile.getHeight()/4);
		
		headWear[0] = skinFile.getSubimage(skinFile.getHeight()/4+skinFile.getWidth()/2, skinFile.getHeight()/4, skinFile.getHeight()/4, skinFile.getHeight()/4);
		headWear[1] = skinFile.getSubimage(skinFile.getWidth()/2, skinFile.getHeight()/4, skinFile.getHeight()/4, skinFile.getHeight()/4);
		headWear[2] = skinFile.getSubimage((skinFile.getHeight()/4)*2+skinFile.getWidth()/2, skinFile.getHeight()/4, skinFile.getHeight()/4, skinFile.getHeight()/4);
		headWear[3] = skinFile.getSubimage((skinFile.getHeight()/4)*3+skinFile.getWidth()/2, skinFile.getHeight()/4, skinFile.getHeight()/4, skinFile.getHeight()/4);
		headWear[4] = skinFile.getSubimage(skinFile.getHeight()/4+skinFile.getWidth()/2, 0, skinFile.getHeight()/4, skinFile.getHeight()/4);
		headWear[5] = skinFile.getSubimage((skinFile.getHeight()/4)*2+skinFile.getWidth()/2, 0, skinFile.getHeight()/4, skinFile.getHeight()/4);
		
		body[0] = skinFile.getSubimage((int) (skinFile.getHeight()/1.6F), (int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/4, (skinFile.getHeight()/8)*3);
		body[1] = skinFile.getSubimage((int) (skinFile.getHeight()/(32.0F/28.001F)), (int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/8, (skinFile.getHeight()/8)*3);
		body[2] = skinFile.getSubimage(skinFile.getHeight()/2, (int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/8, (skinFile.getHeight()/8)*3);
		body[3] = skinFile.getSubimage(skinFile.getHeight(), (int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/4, (skinFile.getHeight()/8)*3);
		body[4] = skinFile.getSubimage((int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/2, skinFile.getHeight()/4, skinFile.getHeight()/8);
		body[5] = skinFile.getSubimage((int) (skinFile.getHeight()/(32.0F/28.001F)), skinFile.getHeight()/2, skinFile.getHeight()/4, skinFile.getHeight()/8);

		arm[0] = skinFile.getSubimage((int) (skinFile.getHeight()/0.8F), (int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/8, (skinFile.getHeight()/8)*3);
		arm[1] = skinFile.getSubimage((int) (skinFile.getHeight()/(32.0F/44.001F)), (int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/8, (skinFile.getHeight()/8)*3);
		arm[2] = skinFile.getSubimage((int) (skinFile.getHeight()/(32.0F/52.001F)), (int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/8, (skinFile.getHeight()/8)*3);
		arm[3] = skinFile.getSubimage((int) (skinFile.getHeight()/(32.0F/48.001F)), (int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/8, (skinFile.getHeight()/8)*3);
		arm[4] = skinFile.getSubimage((int) (skinFile.getHeight()/(32.0F/44.001F)), skinFile.getHeight()/2, skinFile.getHeight()/8, skinFile.getHeight()/8);
		arm[5] = skinFile.getSubimage((int) (skinFile.getHeight()/(32.0F/48.001F)), skinFile.getHeight()/2, skinFile.getHeight()/8, skinFile.getHeight()/8);
		
		leg[0] = skinFile.getSubimage(0, (int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/8, (skinFile.getHeight()/8)*3);
		leg[1] = skinFile.getSubimage((int) (skinFile.getHeight()/(32.0F/4.001F)), (int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/8, (skinFile.getHeight()/8)*3);
		leg[2] = skinFile.getSubimage((int) (skinFile.getHeight()/(32.0F/12.001F)), (int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/8, (skinFile.getHeight()/8)*3);
		leg[3] = skinFile.getSubimage((int) (skinFile.getHeight()/(32.0F/8.001F)), (int) (skinFile.getHeight()/1.6F), skinFile.getHeight()/8, (skinFile.getHeight()/8)*3);
		leg[4] = skinFile.getSubimage((int) (skinFile.getHeight()/(32.0F/4.001F)), skinFile.getHeight()/2, skinFile.getHeight()/8, skinFile.getHeight()/8);
		leg[5] = skinFile.getSubimage((int) (skinFile.getHeight()/(32.0F/8.001F)), skinFile.getHeight()/2, skinFile.getHeight()/8, skinFile.getHeight()/8);
	}
	public void setSkinFile(File file)
	{
		try 
		{
			skinFile = ImageIO.read(file);
			setSkinFile(skinFile);	
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
