import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		BufferedReader br = new BufferedReader( new FileReader("input.txt"));
//		@SuppressWarnings("resource")
//		//Scanner sc = new Scanner(br);
		
		System.out.println("Welcome to Virtual File system.\n");
		System.out.println("Load old virtual file system press 1\n");
		System.out.println("Create new virtual file system press \n");
		System.out.println("Choice :: ");
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		Disk theDisk = new Disk();
		if(c == 1)
		{
			theDisk.Load();
		}
		else if (c == 2)
		{
			int blockSize;
			while(true)
			{
				System.out.print("Please Enter an even value for block size :: ");
				blockSize = sc.nextInt();
				if(blockSize % 2 == 0)
				{
					System.out.println();
					break;
				}
				System.out.println("\nERROR! Provided value is odd.");
			}
			theDisk = new Disk(blockSize);
			System.out.println("\nPress 1 for Contiguous Allocation  \n Press 2 for Index Allocation \n");
			int choice = sc.nextInt();
			while(choice != 1 && choice != 2){
				choice = sc.nextInt();
			}
			Allocation allocate;
			if(choice == 1){
				allocate = new ContiguousAllocation();
			}else{
				allocate = new IndexedAllocation();
			}
			theDisk.setAllocate(allocate);
			
		}
		else
		{
			
		}
		 
		
		@SuppressWarnings("unused")
		String ignore = sc.nextLine(); // :@@@@
		
		while(true)
		{
			System.out.print(">> ");
			String input = sc.nextLine();
			String [] inputArray = input.split(" ");
			
			if(inputArray[0].equals("CFile"))
			{
				theDisk.CreateFile(inputArray[1], inputArray[3], Integer.parseInt(inputArray[2]));
			}
			else if(inputArray[0].equals("CFolder"))
			{
				theDisk.CreateFolder(inputArray[1], inputArray[2]); // CFolder Folder1 VFSD: !! not !! CFolder Folder1 VFSD:\
			}
			else if(inputArray[0].equals("DeleteFile"))
			{
				theDisk.DeleteFile(inputArray[1]);
			}
			else if(inputArray[0].equals("DeleteFolder"))
			{
				theDisk.DeleteFolder(inputArray[1], inputArray[2]);
			}
			else if(inputArray[0].equals("DisplayDiskStatus"))
			{
				theDisk.DisplayDiskStatus();// check this function after testing !!!!!!!
			}
			else if(inputArray[0].equals("DisplayDiskStructure"))
			{
				theDisk.DisplayTreeStructure(); 
			}
			else if(inputArray[0].equals("Exit"))
			{
				theDisk.Save();
				System.out.println("Terminating Program ...");
				System.exit(0);
			}else if(inputArray[0].equals("Load")){
				theDisk.Load();
			}
			else
			{
				System.out.println("Provided Command is not valid !!!");
			}
		}
		
	}
	


}
