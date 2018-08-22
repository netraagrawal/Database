package datfile;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {
	
	String path;
	
	public ReadFile(String file_path)
	{
		path = file_path;
	}
	
	public String[] openFile() throws IOException
	{
		FileReader filereader = new FileReader(path);
		BufferedReader textreader = new BufferedReader(filereader);
		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];
		for(int i=0;i<numberOfLines;i++){
			textData[i] = textreader.readLine();
		}
		textreader.close();
		return textData;
	}
	
	public int readLines() throws IOException
	{
		FileReader filereader = new FileReader(path);
		BufferedReader bf = new BufferedReader(filereader);
		String line;
		int numberOflines = 0;
		while(( line =bf.readLine()) != null){
			numberOflines++;
		}	
		bf.close();
		return numberOflines;
	}

}
