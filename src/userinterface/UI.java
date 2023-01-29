package userinterface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
	
	static String path = System.getProperty("user.dir");
	static File searchdir = new File(path);

	public static void displayMenu()
	{
		System.out.println("FileMng by Bogdan Balas");
		System.out.println("Main Menu");
		System.out.println("Choose one of the options");
		System.out.println("1. Display All Files");
		System.out.println("2. Edit Files");
		System.out.println("3. Logout");
		
	}
	
	public static void editMenu()
	{	
		System.out.println("File Edit Menu");
		System.out.println("1 Add a new File");
		System.out.println("2 Delete a File");
		System.out.println("3 Search for a File");
		System.out.println("4 Return to main menu");
	}
	
	public static void main(String[] args) throws IOException {
		boolean main = true;
		Scanner sc = new Scanner(System.in);

		while(main) {
			displayMenu();
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				GetFiles();
				System.out.println();
				break;
			case 2: 
				boolean edit = true;
				while(edit) { 
				editMenu();
				int choiceedit = sc.nextInt();
				switch(choiceedit) {
					case 1:
						System.out.println("Enter the file name to add");
						String addfile = sc.next();
						sc.nextLine();
						AddFile(addfile);
						System.out.println();
						break;
					case 2:
						System.out.println("Enter the file name to delete");
						String delfile = sc.next();
						sc.nextLine();
						DelFile(delfile);						
						System.out.println();
						break;
					case 3:
						System.out.println("Enter the file name to seach for");
						String srchfile = sc.next();
						sc.nextLine();
						SearchFile(srchfile);
						System.out.println();
						break;
					case 4:
						System.out.println("Exiting to main menu");
						System.out.println();
						edit=false;
						break;
					}
				}
				break;
			case 3:
				System.out.println("Exiting FileMng");
				main = false;
				break;

			}
		
		}
		System.out.println("Logged out successfully");
	}

	

	private static void SearchFile(String srchfile) {
		boolean found = false;
		String path =  System.getProperty("user.dir");
		File files = new File(path);
		List<String> list = new ArrayList<>();
		
		for (File f:files.listFiles())
				list.add(f.getName());
		
		for(int i=0; i<list.size(); i++)
			 if (list.get(i).equals(srchfile))
				found = true;
		if (found)
			System.out.println("file found");
		else
			System.out.println("FNF");
	}
	

	private static void DelFile(String delfile) {
		String path =  System.getProperty("user.dir");
		File file = new File(path, delfile);
		if(file.delete())
			System.out.println("File deleted successfully");
		else
			System.out.println("File not found in working directory");
	}

	private static void AddFile(String addfile) {
		String path =  System.getProperty("user.dir");
		File file = new File(path, addfile);
		try {
			if(file.createNewFile())
				System.out.println("file created successfully");
			else
				System.out.println("File already exists");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void GetFiles() {
		System.out.println("Files in current directory:");
		String path =  System.getProperty("user.dir");
		File files = new File(path);
		List<String> list = new ArrayList<>();
		for (File f:files.listFiles())
				list.add(f.getName());
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		System.out.println();
	}
}