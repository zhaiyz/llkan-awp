package com.zyz.test;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.zyz.view.MapUI;

public class Test extends JFrame{

	private static final long serialVersionUID = -5927301424073883403L;

	public Test(String title) {

		this.setTitle(title); // ���ñ���

		this.setSize(new Dimension(600, 600));
		
		MapUI map = new MapUI();
		this.add(map);
	}

	public static void main(String args[]) {

		Test test = new Test("�ҵĴ���");
		test.setDefaultCloseOperation(EXIT_ON_CLOSE);
		test.setLocationRelativeTo(null);
		test.setVisible(true);

	}
}
