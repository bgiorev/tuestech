import java.io.*;
import java.net.URL;
import java.util.logging.Logger;
import java.util.Arrays;
import java.util.ArrayList;

public class Homeworks {

	public static void main (String[] args) throws Exception{
		File[] files = new File("./").listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.getName().endsWith(".csv");
			}
		});
		ArrayList<Student> a = new ArrayList<Student> ();
		ArrayList<Student> b = new ArrayList<Student> ();
		
		int k = 1;
		for(File f:files) {
			
			BufferedReader CSVFile = new BufferedReader(new FileReader(f.getName()));
			String header = CSVFile.readLine();
			//String[] headers = {"Клас", "Номер", "Име", "Имейл"};
			String dataRow = CSVFile.readLine(); 
			while (dataRow != null){
				String[] dataArray = dataRow.split(",");
				Student s = new Student();
				if(dataArray.length > 4) {
					s.set_clas(dataArray[1].toUpperCase());
					s.set_number(dataArray[2]);
					s.set_name(dataArray[3]);
					s.set_email(dataArray[4]);
					if (dataArray[1].toUpperCase().contains("A") | dataArray[1].toUpperCase().contains("А") ) {
						
						a.add(s);
						System.out.println(s.get_clas() + " " + s.get_number() + " " + s.get_name() + " " + s.get_email());
					}
					else {//if (dataArray[1].toUpperCase().contains("B") & dataArray[1].toUpperCase().contains("Б") ) {
						System.out.println(s.get_clas() + " " + s.get_number() + " " + s.get_name() + " " + s.get_email());
						b.add(s);
					}
				}
				dataRow = CSVFile.readLine();
			}
			CSVFile.close();
			System.out.println();
		}
		
		FileWriter saveFile = new FileWriter("SAVED 11A.csv");
		for(Student stud : a) {
			saveFile.write(stud.get_clas() + ",");
			saveFile.write(stud.get_number() + ",");
			saveFile.write(stud.get_name() + ",");
			saveFile.write(stud.get_email() + ",");
			saveFile.write("\n");
		}
		saveFile.close();
		
		saveFile = new FileWriter("SAVED 11b.csv");
		for(Student stud : b) {
			saveFile.write(stud.get_clas() + ",");
			saveFile.write(stud.get_number() + ",");
			saveFile.write(stud.get_name() + ",");
			saveFile.write(stud.get_email() + ",");
			saveFile.write("\n");
		}
		saveFile.close();
	}
}