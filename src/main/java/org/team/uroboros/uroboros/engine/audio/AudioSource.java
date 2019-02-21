package org.team.uroboros.uroboros.engine.audio;

import static javax.sound.sampled.Clip.LOOP_CONTINUOUSLY;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.team.uroboros.uroboros.engine.Component;

public class AudioSource extends Component {

	private Boolean enable = false;
	private File file;
	private String route;
	private AudioInputStream audio;
	private Clip clip;

	public AudioSource(String route) {
		this.route = route;
	}

	@Override
	protected void onAttach() {
		enable = true;
	}

	@Override
	protected void onDettach() {
		enable = false;
	}

	private void createAudioClip() {
		if (file == null) {

			try {
				file = new File("src/main/resources/" + route);
				audio = AudioSystem.getAudioInputStream(file.toURI().toURL());
				clip = AudioSystem.getClip();
				clip.open(audio);
			}

			catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			}

			catch (IOException e) {
				e.printStackTrace();
			}

			catch (LineUnavailableException e) {
				e.printStackTrace();
			}

		}
	}

	public void play() {
		if (enable) {
			this.createAudioClip();
			clip.stop();
			clip.start();
		}
	}

	public void loop() {
		if (enable) {
			this.createAudioClip();
			clip.stop();
			clip.loop(LOOP_CONTINUOUSLY);
		}
	}

	public void pause() {
		if (enable && clip != null) {
			clip.stop();
		}
	}

	public void resume() {
		if (enable && clip != null) {
			clip.start();
		}
	}

	public void stop() {
		if (enable && clip != null) {
			clip.stop();
			clip.close();
		}
	}

}
