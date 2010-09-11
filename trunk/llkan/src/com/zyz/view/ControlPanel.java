package com.zyz.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {

	private static final long serialVersionUID = 1739902581487695003L;
	
	private int width = 400;
	
	private int height = 100;
	
    private JButton start = new JButton("¿ªÊ¼");
	
	private JButton refresh = new JButton("Ë¢ÐÂ");
	
	public ControlPanel() {
		this.setSize(width, height);
		this.setBackground(Color.BLUE);
		
		this.add(start);
		this.add(refresh);
	}

}
