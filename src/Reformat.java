import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**Reformats Java source code from next-line brace style to end-of-line brace style.
 * 
 * @author Darryl Karney
 * @version 09082018
 */
public class Reformat {

	public static void main(String[] args) {
		//Check if correct argument amount was sent to the program
		if (args.length != 1) {
			System.out.println("Argument count is not correct. Please only send 1 argument.");
			System.exit(1);
		}
		
		//Read text from file into arraylist
		File file = new File(args[0]);
		ArrayList<String> text = new ArrayList<>();
		Scanner input = null;
		
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File " + args[0] + " does not exist!");
			System.exit(1);
		}
		
		while(input.hasNext()) {
			text.add(input.nextLine());
		}
		
		//Convert text in the arraylist
		for(int i = 0; i < text.size(); i++) {
			if (text.get(i).trim().equals("{")) {
				text.set(i - 1, text.get(i - 1) + " {");
				text.remove(i);
			}
		}
		
		//Write to new file
		PrintWriter output = null;
		
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.out.println("File " + args[0] + " does not exist!");
			System.exit(1);
		}
		
		for(int i = 0; i < text.size(); i++) {
			output.println(text.get(i));
			output.println("TEST");
			System.out.println(text.get(i));
		}
		
		output.close();
	}

}
