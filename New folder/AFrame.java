package com.wordpress.bgiorev.gui.code;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class AFrame extends Frame  implements ActionListener, WindowListener{
	
	public AFrame(String s) {
		super(s);
		setBackground(Color.yellow);
		setLayout(new FlowLayout());
		addWindowListener((WindowListener) this);
		Button button = new Button("Press me");
		add(button);
		button.addActionListener(this);
	}
	
	public void actionPerformer(ActionEvent event) {
		final char bell = '\u0007';
        if (event.getActionCommand().equals("press me"))
        { 
        	System.out.println("The shit is being pressed");
        	System.out.print(bell);
        } 
	}
	
	public void windowClosing1(WindowEvent event) { System.exit(0); }
    public void windowClosed1(WindowEvent event)  {} //do nothing for now
    public void windowDeiconified1(WindowEvent event){}
    public void windowIconified1(WindowEvent event){}
    public void windowActivated1(WindowEvent event){}
    public void windowDeactivated1(WindowEvent event){}
    public void windowOpened1(WindowEvent event){}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	} 
}
