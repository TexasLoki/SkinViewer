package rikmuld.skin3D;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.BufferedImageUtil;

import rikmuld.skin2D.TextureLoader2D;

public class TextureLoader3D extends TextureLoader2D {

	public Texture[] head3D = new Texture[6];
	public Texture[] headWear3D = new Texture[6];
	public Texture[] body3D = new Texture[6];
	public Texture[] arm3D = new Texture[6];
	public Texture[] leg3D = new Texture[6];

	public TextureLoader3D(BufferedImage img)
	{
		this.setSkinFile(img);
	}

	public void setSkinFile(BufferedImage file)
	{
		super.setSkinFile(file);
		this.setSkinTextures();
	}

	public void setSkinTextures()
	{
		for(int i = 0; i<6; i++)
		{
			try
			{
				head3D[i] = BufferedImageUtil.getTexture("PNG", head[i]);
				headWear3D[i] = BufferedImageUtil.getTexture("PNG", headWear[i]);
				body3D[i] = BufferedImageUtil.getTexture("PNG", body[i]);
				arm3D[i] = BufferedImageUtil.getTexture("PNG", arm[i]);
				leg3D[i] = BufferedImageUtil.getTexture("PNG", leg[i]);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
