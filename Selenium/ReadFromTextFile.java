package tryIt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromTextFile {
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "./data/howdy.txt";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null){
		    //process the line
		    System.out.println(line);
		}
		
	}

}
