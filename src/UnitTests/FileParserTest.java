package UnitTests;

import org.junit.Test;

import data.ClientLogDataManager;
import utils.FileParser;

public class FileParserTest {

	@Test
	public void test() {
		
		ClientLogDataManager dm = new ClientLogDataManager();
		FileParser fp = new FileParser(dm);
		
		fp.readLastLine();
		
		
	}

}
