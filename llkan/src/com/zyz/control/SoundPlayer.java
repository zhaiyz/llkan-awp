package com.zyz.control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundPlayer {
	private AudioStream as;
	public SoundPlayer(URL url) {
		try {
			// ��һ�������ļ�����Ϊ����
			as = new AudioStream(url.openStream());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// һ���Բ��� ��ʼ
	public void start() {
		if (as == null) {
			System.out.println("AudioStream object is not created!");
			return;
		} else {
			AudioPlayer.player.start(as);
		}
	}

	// һ���Բ��� ֹͣ
	public void stop() {
		if (as == null) {
			System.out.println("AudioStream object is not created!");
			return;
		} else {
			AudioPlayer.player.stop(as);
		}
	}
}