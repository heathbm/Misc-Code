import java.io.*;

public class Meths {

	private static Writer writer;

	public static int password() throws IOException {

		String c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 1;) {
			c = br.readLine();

			switch (c) {
			case "pass":
				System.out.println("Welcome");
				menu();
				return 1;

			default:
				System.out.println("Please try again ");
				break;
			}
		}
		return 0;
	}

	public static void menu() throws IOException {

		System.out.println("1: Modify Main Database"
				+ "\n2: Create new File\n3: Logout");

		int i = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		i = br.read();

		switch (i) {
		case '1':
			Database(); break; // modify main database
		case '2':
			newFile(); break; // create new file
		case '3':
			System.out.println("Thank you, see you soon!");// logout
			break;
		}

	}

	public static void Database() throws IOException {

		System.out.println("1: Read and Write to Main Database\n2: Wrtie to Main Database");
		int cz = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cz = br.read();
		switch (cz) {

		case '1':
			String s;
			BufferedReader br2 = new BufferedReader(new FileReader(
					"database.txt"));
			{ // the file must be in the project folder
				while ((s = br2.readLine()) != null) {
					System.out.println(s);
				}
			}
			break;

		case '2':
			break;

		default:
			System.out.println("Sorry try again");
			Database();
			break;
		}

		System.out.println("Please append to the Main Database\nEnter 'stop' to exit");
		try (FileWriter fw = new FileWriter("database.txt", true)) {
			String str;
			do {
				System.out.println(": ");
				str = br.readLine();

				if (str.compareTo("stop") == 0)
					break;

				str = str + "\r\n"; // add newline
				fw.write(str);
			} while (str.compareTo("stop") != 0);
		} catch (IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
		
		menu();

	}
	
	public static void newFile() throws IOException {
System.out.println("Type the name of your new file: ");
		String c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = br.readLine(); 
		
		writer = new BufferedWriter(new OutputStreamWriter ( new FileOutputStream(c+".txt"), "utf-8"));
		
		System.out.println("Please Write to new file\nEnter 'stop' to exit");
		try (FileWriter fw = new FileWriter(c+".txt", true)) {
			String str;
			do {
				str = br.readLine();

				if (str.compareTo("stop") == 0)
					break;

				str = str + "\r\n"; // add newline
				fw.write(str);
			} while (str.compareTo("stop") != 0);
		} catch (IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
		
		menu();
			
		}
	 
}
