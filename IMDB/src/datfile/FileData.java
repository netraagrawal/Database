package datfile;
import java.io.IOException;

public class FileData {
	static String[] input;
	
	public static String[] readinput(String fileN)
	{
		String fileName = "src/datfile/" + fileN;
		
		try{
			ReadFile file = new ReadFile(fileName);
			input = file.openFile();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		return input;
	}
	
	public static void main(String args[])
	{
		readinput("movie_countries.dat");
		String[] temp;
		for(int i =1;i<input.length;i++)
		{
			temp = input[i].split("//t");
			for(String temp1:temp)
			{
				System.out.print(temp1);
			}
			System.out.println();
		}
	}
}

