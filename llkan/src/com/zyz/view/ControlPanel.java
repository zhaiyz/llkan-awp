package com.zyz.view;

import java.awt.Color;

import javax.swing.JPanel;

public class ControlPanel extends JPanel {

	private static final long serialVersionUID = 1739902581487695003L;
	
	private int width = 400;
	
	private int height = 100;
	
	public ControlPanel() {
		this.setSize(width, height);
		this.setBackground(Color.BLUE);
	}

}
