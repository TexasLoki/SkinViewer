package rikmuld.skin3D.world;

import java.awt.Toolkit;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import rikmuld.main.MainGui;
import rikmuld.skin3D.skin.Skin;
import rikmuld.skin3D.skin.SkinCollection;
import rikmuld.util.FileManager;

public class Skin3DWorld implements Runnable {

	boolean[] keys = new boolean[256];
	public static Camera camera;
	public static Texture grassTop, grassSide;
	boolean flag = false, saveFlag = false;
	public static Skin3DWorld thread = null;
	public static SkinCollection skins;
	static boolean request = false;

	public static void load3DWorld()
	{
		thread = new Skin3DWorld();
		(new Thread(thread)).start();
	}

	public static void saveCollection()
	{
		skins.saveCollectionToDisk();
	}

	public static void requestDefaultCollection()
	{
		request = true;
	}

	private void loadTextures()
	{
		try
		{
			grassTop = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("textures/grassTop.png"));
			grassSide = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("textures/grassSide.png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void render()
	{
		clearScreen();
		camera.translatePostion();
		skins.updateSkins();

		for(Skin skin : skins.skins)
		{
			if(skin!=null) skin.renderUpdate();
		}
	}

	public void update()
	{
		if(request)
		{
			request = false;
			FileManager.loadDefaultCollection();
		}

		if(Display.isActive())
		{
			if(camera.mouseClose==true) Mouse.setGrabbed(true);
			if(this.saveFlag==true) this.saveFlag = false;
		}
		if(!Display.isActive()&&saveFlag==false)
		{
			this.saveFlag = true;
			saveCollection();
		}

		mapKeys();
		camera.update();
	}

	private void mapKeys()
	{
		for(int i = 0; i<keys.length; i++)
		{
			keys[i] = Keyboard.isKeyDown(i);
		}
		if(flag==false&&Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
		{
			if(camera.mouseClose) camera.mouseClose = false;
			else camera.mouseClose = true;
		}
		flag = Keyboard.isKeyDown(Keyboard.KEY_ESCAPE);

	}

	public void setupDisplay()
	{
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();

		GLU.gluPerspective((float) 100, 1, 0.001f, 750);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glEnable(GL11.GL_TEXTURE_2D);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0);

		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glClearColor(1.0f, 1.0f, 1.0f, 0f);
		GL11.glClearDepth(1.0f);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
	}

	public void clearScreen()
	{
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();
	}

	@Override
	public void run()
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(750, 750));
			Display.create();
			Display.setParent(MainGui.canvas);
		}
		catch(LWJGLException e)
		{
			e.printStackTrace();
		}

		Display.setTitle("RikMuld's 3D Skin Viewer");

		this.setupDisplay();

		camera = new Camera(this);
		loadTextures();
		Display.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().width/1.8), Toolkit.getDefaultToolkit().getScreenSize().height/6);

		FileManager.startUp();

		while(!Display.isCloseRequested())
		{
			this.render();
			this.update();
			FileManager.updateRequest();
			Display.update();
			Display.sync(90);
		}
		saveCollection();

		Display.destroy();
		System.exit(0);
	}
}
