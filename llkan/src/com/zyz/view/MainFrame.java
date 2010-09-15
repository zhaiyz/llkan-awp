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
	
    private JButton start = new JButton("���¿�ʼ");
	
	private JButton refresh = new JButton("ˢ��(3��)");
	
	private int count = 3;
	
	public MainFrame() {
		this.setTitle("����������");
		this.setSize(width, height);
		
		this.setLayout(new BorderLayout());
		
		start.addActionListener(this);
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
			count--;
			refresh.setText("ˢ��(" + count + "��)");
			if (count == 0) {
				refresh.setEnabled(false);
			}
		} else if (e.getSource() == start) {
			map.restart();
			refresh.setEnabled(true);
			count = 3;
			refresh.setText("ˢ��(" + count + "��)");
		}
	}
}
