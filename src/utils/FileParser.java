package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import data.ClientLogDataManager;

public class FileParser {

	private String fileName;
	private File file;
	private ClientLogDataManager logData;


	public FileParser(ClientLogDataManager logData){
		//this.fileName = "F:/SteamLibrary/steamapps/common/Path of Exile/logs/client.txt";
		this.fileName = "E:/Testing/testClient.txt";
		this.file = new File(fileName);
		this.logData = logData;
	}

	public void readLastLine() {
		int readLines = 0;
		int lines = 2; //read the last 2 lines, last line is empty
		StringBuilder builder = new StringBuilder();
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile = new RandomAccessFile(file, "r");
			long fileLength = file.length() - 1;
			// Set the pointer at the last of the file
			randomAccessFile.seek(fileLength);
			for(long pointer = fileLength; pointer >= 0; pointer--){
				randomAccessFile.seek(pointer);
				char c;
				// read from the last one char at the time
				c = (char)randomAccessFile.read(); 
				// break when end of the line
				if(c == '\n'){
					readLines++;
					if(readLines == lines)
						break;
				}
				builder.append(c);
			}
			// Since line is read from the last so it 
			// is in reverse so use reverse method to make it right
			builder.reverse();
			//System.out.println(builder.toString());
			
			logData.updateLastLine(builder.toString());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(randomAccessFile != null){
				try {
					randomAccessFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
