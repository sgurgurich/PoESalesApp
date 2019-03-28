package UnitTests;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import data.ClientLogDataManager;
import utils.FileParser;

public class FileParserTest {

	@Test
	public void test() {
		
		//ClientLogDataManager dm = new ClientLogDataManager();
		FileParser fp = new FileParser();
		
	    while (true) {
	    	fp.readLastLine();
	    	
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
		
	}

}
