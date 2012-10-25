import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Yellow{

    public static void main(String[] args) throws Exception {
	
		String s = args[0];
        BufferedReader CSVFile = new BufferedReader(new FileReader(s + ".csv"));
		FileWriter saveFile = new FileWriter(s + "_result.csv");

        String dataRow = CSVFile.readLine(); 
        while (dataRow != null){
            String[] dataArray = dataRow.split(",");
			int rand = Integer.parseInt(dataArray[1])/2;
			int y = (int)((Math.random() * 1000)%rand);
			saveFile.write(dataArray[0] + ',' + dataArray[1] + ',' + y + '\n');
            dataRow = CSVFile.readLine();
        }

		saveFile.close();
        CSVFile.close();

        System.out.println();

    }
}
