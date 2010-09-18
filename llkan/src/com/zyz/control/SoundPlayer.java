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
			// 打开一个声音文件流作为输入
			as = new AudioStream(url.openStream());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 一次性播放 开始
	public void start() {
		if (as == null) {
			System.out.println("AudioStream object is not created!");
			return;
		} else {
			AudioPlayer.player.start(as);
		}
	}

	// 一次性播放 停止
	public void stop() {
		if (as == null) {
			System.out.println("AudioStream object is not created!");
			return;
		} else {
			AudioPlayer.player.stop(as);
		}
	}
}