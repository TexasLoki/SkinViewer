package rikmuld.skin2D;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class SkinDrawer2D {

	public BufferedImage[] skinHead = new BufferedImage[6];
	public BufferedImage[] skinHeadWear = new BufferedImage[6];
	public BufferedImage[] body = new BufferedImage[6];
	public BufferedImage[] arm = new BufferedImage[6];
	public BufferedImage[] leg = new BufferedImage[6];
	public BufferedImage[] mirrored = new BufferedImage[6];

	public void drawSkin(Graphics g, int view, int part, TextureLoader2D loader, boolean isNotNotch)
	{
		this.setSkinFile(loader);

		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-arm[0].getWidth(), 0);
		AffineTransformOp mirror = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

		g.drawImage(skinHead[0].getScaledInstance(64, 64, Image.SCALE_SMOOTH), 1110, 21, null);
		if(isNotNotch) g.drawImage(skinHeadWear[0].getScaledInstance(80, 80, Image.SCALE_SMOOTH), 1101, 13, null);

		if(view==0)
		{
			if(part==0)
			{
				g.drawImage(skinHead[0].getScaledInstance(96, 96, Image.SCALE_SMOOTH), 250-110, 204+20, null);
				if(isNotNotch) g.drawImage(skinHeadWear[0].getScaledInstance(120, 120, Image.SCALE_SMOOTH), 238-110, 192+20, null);
				g.drawImage(arm[1].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 202-110, 300+20, null);
				g.drawImage(leg[1].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 250-110, 300+20+144, null);

				mirrored[1] = mirror.filter(leg[1], null);

				g.drawImage(mirrored[1].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 250-110+48, 300+20+144, null);

				mirrored[0] = mirror.filter(arm[1], null);

				g.drawImage(mirrored[0].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 346-110, 300+20, null);

				g.drawImage(body[0].getScaledInstance(96, 144, Image.SCALE_SMOOTH), 250-110, 300+20, null);
				g.drawImage(skinHead[3].getScaledInstance(96, 96, Image.SCALE_SMOOTH), 475-110, 204+20, null);
				if(isNotNotch) g.drawImage(skinHeadWear[3].getScaledInstance(120, 120, Image.SCALE_SMOOTH), 463-110, 192+20, null);
				g.drawImage(arm[2].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 571-110, 300+20, null);
				g.drawImage(leg[2].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 475-110+48, 300+20+144, null);

				mirrored[2] = mirror.filter(leg[2], null);

				g.drawImage(mirrored[2].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 475-110, 300+20+144, null);

				mirrored[3] = mirror.filter(arm[2], null);

				g.drawImage(mirrored[3].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 427-110, 300+20, null);
				g.drawImage(body[3].getScaledInstance(96, 144, Image.SCALE_SMOOTH), 475-110, 300+20, null);
			}

			else if(part==1)
			{
				g.drawString("Front", 242, 170);

				g.drawImage(skinHead[0].getScaledInstance(96, 96, Image.SCALE_SMOOTH), 250-110, 204-10, null);
				if(isNotNotch) g.drawImage(skinHeadWear[0].getScaledInstance(120, 120, Image.SCALE_SMOOTH), 238-110, 192-10, null);

				g.drawString("Back", 469, 170);

				g.drawImage(skinHead[3].getScaledInstance(96, 96, Image.SCALE_SMOOTH), 475-110, 204-10, null);
				if(isNotNotch) g.drawImage(skinHeadWear[3].getScaledInstance(120, 120, Image.SCALE_SMOOTH), 463-110, 192-10, null);

				g.drawString("Top", 360, 318);

				g.drawImage(skinHead[4].getScaledInstance(96, 96, Image.SCALE_SMOOTH), 350-21, 304+20, null);
				if(isNotNotch) g.drawImage(skinHeadWear[4].getScaledInstance(120, 120, Image.SCALE_SMOOTH), 338-21, 292+20, null);
			}

			else if(part==2)
			{
				g.drawString("Front", 242, 170);

				g.drawImage(body[0].getScaledInstance(96, 144, Image.SCALE_SMOOTH), 250-110, 182, null);

				g.drawString("Back", 469, 170);

				g.drawImage(body[3].getScaledInstance(96, 144, Image.SCALE_SMOOTH), 475-110, 182, null);

				g.drawString("Top", 360, 382);

				g.drawImage(body[4].getScaledInstance(96, 48, Image.SCALE_SMOOTH), 350-21, 394, null);
			}

			else if(part==3)
			{
				g.drawString("Front", 248, 170);

				g.drawImage(arm[0].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 250-110+24, 182, null);

				g.drawString("Back", 467, 170);

				g.drawImage(arm[3].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 475-110+24, 182, null);

				g.drawString("Top", 360, 382);

				g.drawImage(arm[4].getScaledInstance(48, 48, Image.SCALE_SMOOTH), 350-21+24, 394, null);
			}

			else if(part==4)
			{
				g.drawString("Front", 248, 170);

				g.drawImage(leg[0].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 250-110+24, 182, null);

				g.drawString("Back", 467, 170);

				g.drawImage(leg[3].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 475-110+24, 182, null);

				g.drawString("Top", 360, 382);

				g.drawImage(leg[4].getScaledInstance(48, 48, Image.SCALE_SMOOTH), 350-21+24, 394, null);
			}
		}
		if(view==1)
		{
			if(part==0)
			{
				g.drawImage(skinHead[1].getScaledInstance(96, 96, Image.SCALE_SMOOTH), 250-110, 204+20, null);
				if(isNotNotch) g.drawImage(skinHeadWear[1].getScaledInstance(120, 120, Image.SCALE_SMOOTH), 238-110, 192+20, null);
				g.drawImage(arm[0].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 250-110+24, 300+20, null);
				g.drawImage(leg[0].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 250-110+24, 300+20+144, null);

				g.drawImage(skinHead[2].getScaledInstance(96, 96, Image.SCALE_SMOOTH), 475-110, 204+20, null);
				if(isNotNotch) g.drawImage(skinHeadWear[2].getScaledInstance(120, 120, Image.SCALE_SMOOTH), 463-110, 192+20, null);

				mirrored[4] = mirror.filter(arm[0], null);
				mirrored[5] = mirror.filter(leg[0], null);

				g.drawImage(mirrored[4].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 475-110+24, 300+20, null);
				g.drawImage(mirrored[5].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 475-110+24, 300+20+144, null);
			}

			else if(part==1)
			{
				g.drawString("Left", 248, 170);

				g.drawImage(skinHead[1].getScaledInstance(96, 96, Image.SCALE_SMOOTH), 250-110, 204-10, null);
				if(isNotNotch) g.drawImage(skinHeadWear[1].getScaledInstance(120, 120, Image.SCALE_SMOOTH), 238-110, 192-10, null);

				g.drawString("Right", 467, 170);

				g.drawImage(skinHead[2].getScaledInstance(96, 96, Image.SCALE_SMOOTH), 475-110, 204-10, null);
				if(isNotNotch) g.drawImage(skinHeadWear[2].getScaledInstance(120, 120, Image.SCALE_SMOOTH), 463-110, 192-10, null);

				g.drawString("Bottom", 349, 318);

				g.drawImage(skinHead[5].getScaledInstance(96, 96, Image.SCALE_SMOOTH), 350-21, 304+20, null);
				if(isNotNotch) g.drawImage(skinHeadWear[5].getScaledInstance(120, 120, Image.SCALE_SMOOTH), 338-21, 292+20, null);
			}

			else if(part==2)
			{
				g.drawString("Left", 248, 170);

				g.drawImage(body[1].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 250-110+24, 182, null);

				g.drawString("Right", 467, 170);

				g.drawImage(body[2].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 475-110+24, 182, null);

				g.drawString("Bottom", 350, 382);

				g.drawImage(body[5].getScaledInstance(96, 48, Image.SCALE_SMOOTH), 350-21, 394, null);
			}

			else if(part==3)
			{
				g.drawString("Left", 248, 170);

				g.drawImage(arm[1].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 250-110+24, 182, null);

				g.drawString("Right", 467, 170);

				g.drawImage(arm[2].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 475-110+24, 182, null);

				g.drawString("Bottom", 350, 382);

				g.drawImage(arm[5].getScaledInstance(48, 48, Image.SCALE_SMOOTH), 350-21+24, 394, null);
			}

			else if(part==4)
			{
				g.drawString("Left", 248, 170);

				g.drawImage(leg[1].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 250-110+24, 182, null);

				g.drawString("Right", 467, 170);

				g.drawImage(leg[2].getScaledInstance(48, 144, Image.SCALE_SMOOTH), 475-110+24, 182, null);

				g.drawString("Bottom", 350, 382);

				g.drawImage(leg[5].getScaledInstance(48, 48, Image.SCALE_SMOOTH), 350-21+24, 394, null);
			}
		}
	}

	public void setSkinFile(TextureLoader2D loader)
	{
		this.skinHead = loader.head;
		this.arm = loader.arm;
		this.body = loader.body;
		this.leg = loader.leg;
		this.skinHeadWear = loader.headWear;
	}
}
