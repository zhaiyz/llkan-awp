package com.zyz.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 2436864599750998867L;
	
	private int width = 650;
	
	private int height = 650;
	
	private ControlPanel control = new ControlPanel();
	
	private MapPanel map = new MapPanel();
	
	public MainFrame() {
		this.setSize(width, height);
		
		this.setLayout(new BorderLayout());
		
		this.add(control, BorderLayout.NORTH);
		this.add(map, BorderLayout.CENTER);
	}
}
