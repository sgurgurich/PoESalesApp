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
	RandomAccessFile randomAccessFile;


	public FileParser(){
		this.fileName = "F:/SteamLibrary/steamapps/common/Path of Exile/logs/Client.txt";
		//this.fileName = "C:/Program Files (x86)/Steam/steamapps/common/Path of Exile/logs/client.txt";
		this.file = new File(fileName);
		this.logData = new ClientLogDataManager();
		
		try {
			this.randomAccessFile = new RandomAccessFile(file, "r");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String lastLine = "";
	public void readLastLine() {
		int readLines = 0;
		int lines = 2; //read the last 2 lines, last line is empty
		StringBuilder builder = new StringBuilder();
		try {
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
			
			if (!builder.toString().equals(lastLine)) {
				logData.updateLastLine(builder.toString());
			} 
			lastLine = builder.toString();
			//System.out.println(builder.toString());
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
