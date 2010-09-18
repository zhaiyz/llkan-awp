package com.zyz.control;

public class SoundThread extends Thread {
	/**
	 * �������Ҫ���������0�ɹ���1ʧ��
	 */
	private int flag;
	
	public SoundThread (int flag) {
		this.flag = flag;
	}

	public void run() {
		if (flag == 0) {
			// ��ɹ�������
			SoundPlayer sound = new SoundPlayer(getClass().getResource("sound/right.wav"));
			sound.start();
		} else {
			// ��ʧ�ܵ�����
			SoundPlayer sound = new SoundPlayer(getClass().getResource("sound/wrong.wav"));
			sound.start();
		}
	}
}
