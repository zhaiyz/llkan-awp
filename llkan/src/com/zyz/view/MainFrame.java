package com.zyz.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 2436864599750998867L;
	
	private int width = 650;
	
	private int height = 650;
	
	private ControlPanel control = new ControlPanel();
	
	private MapPanel map = new MapPanel();
	
    private JButton start = new JButton("开始");
	
	private JButton refresh = new JButton("刷新");
	
	public MainFrame() {
		this.setTitle("人渣连连看");
		this.setSize(width, height);
		
		this.setLayout(new BorderLayout());
		
		refresh.addActionListener(this);
		
		control.add(start);
		control.add(refresh);
		
		this.add(control, BorderLayout.NORTH);
		this.add(map, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == refresh) {
			map.paint();
		}
	}
}
