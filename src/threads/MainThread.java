package threads;

import java.util.concurrent.TimeUnit;

import utils.FileParser;

public class MainThread implements Runnable {
	
	private FileParser fp;
	private boolean stopped;
	
	public MainThread(FileParser fp) {
		this.fp = fp;
		this.stopped = false;
	}

	@Override
	public void run() {
		
		while(!stopped) {
			fp.readLastLine();
			
			if (Thread.interrupted()) {
				  // Executor has probably asked us to stop
				stop();
			}
		}
		
	}
	
	public void stop() {
		stopped = true;
	}

	
	
}
