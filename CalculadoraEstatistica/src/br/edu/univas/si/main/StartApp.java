package br.edu.univas.si.main;

import br.edu.univas.si.frameCalc.FrameCalculadora;
import br.edu.univas.si.look.SeaGlass;

public class StartApp {

	public static void main(String[] args){
		SeaGlass.setlookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		FrameCalculadora f = new FrameCalculadora();
		f.setVisible(true);
	}
}
