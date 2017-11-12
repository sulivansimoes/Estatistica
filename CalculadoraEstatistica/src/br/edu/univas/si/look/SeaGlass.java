package br.edu.univas.si.look;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class SeaGlass {
	
	public final static void setlookAndFeel(String look){
	     try {
	    	 UIManager.setLookAndFeel(look);		
	     } catch (Exception e) {
	    	 JOptionPane.showMessageDialog(null,"Contate suporte técnico! Erro no look and Feel\n"+e);
	    	 System.exit(0);
	     }
	}
}
