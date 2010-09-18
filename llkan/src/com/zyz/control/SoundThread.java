package com.zyz.control;

public class SoundThread extends Thread {
	/**
	 * 用来标记要响的声音，0成功，1失败
	 */
	private int flag;
	
	public SoundThread (int flag) {
		this.flag = flag;
	}

	public void run() {
		if (flag == 0) {
			// 响成功的声音
			SoundPlayer sound = new SoundPlayer(getClass().getResource("sound/right.wav"));
			sound.start();
		} else {
			// 响失败的声音
			SoundPlayer sound = new SoundPlayer(getClass().getResource("sound/wrong.wav"));
			sound.start();
		}
	}
}
