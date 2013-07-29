package rikmuld.main;

import rikmuld.skin3D.world.Skin3DWorld;

public class Start {

	public static MainGui gui = new MainGui();
	
	public static void main(String[] args)
	{
		Skin3DWorld.load3DWorld();
		gui.setupStartGui();
	}
}
