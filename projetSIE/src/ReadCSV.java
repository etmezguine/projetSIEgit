import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadCSV {
	public static void main(String[] args) {
		 
		ReadCSV obj = new ReadCSV();
		obj.run();
	 
	  }
	
	 public void run() {
		 
			String csvFile = "./src/test.csv";
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ";";
		 
			try {
				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {
		 
				        // use comma as separator
					String[] element= line.split(cvsSplitBy);
		 
					System.out.println("Element : " + element[0]+" " + element[1]+" " + element[2]+" "+ element[3]+ " "+element[4]);
				}
		 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		  } 
}
