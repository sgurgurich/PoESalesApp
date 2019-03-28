package UnitTests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import utils.FileUtils;

public class FileUtilsTest {
	
	@Test
	public void testFileToStringUtf8() throws IOException {
		String backupJsonPath = "TestLogs/currencyoverview.json";
		int length = FileUtils.fileToStringUtf8(backupJsonPath).length();
		assertTrue(length > 0);
	}
	
	@Test
	public void testFileToString() throws IOException {
		String backupJsonPath = "TestLogs/currencyoverview.json";
		int length = FileUtils.fileToString(backupJsonPath,StandardCharsets.UTF_8).length();
		assertTrue(length > 0);
	}

}
