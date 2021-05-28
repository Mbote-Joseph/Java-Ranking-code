//To import all necessary packages
import java.io.*;
import java.util.*;


public class RankStudent {
// Method to find Marks
public static int findMarks(int id, int[] student, int[] marks, int count) {

	for(int i=0; i<count; i++) {
		if(id == student[i])
		return marks[i];
	}
	return 0;

}
// Method to find Rank
public static int findRank(int[] marks, int score) {

	int rank;
	// convert array to arraylist
	List<Integer> lst = new ArrayList<Integer>(marks.length);
	for (int i : marks) {
		lst.add(i);
	}

	// sort the list in descending order - highest to lowest
	Collections.sort(lst, Collections.reverseOrder());
	rank = lst.indexOf(score) + 1;
	return rank;
}
// writes output to a file 'rank.out' . On running the code the file 'rank.out' is created with the output
public static void fileWrite(int[] ranks, int count) {
	for(int i=0; i<count; i++)
		System.out.println(ranks[i]);
	  
	try {
       BufferedWriter outFile = new BufferedWriter(new FileWriter("rank.out"));
       for(int i=0; i<count; i++)
       outFile.write(ranks[i] + "\n");
       outFile.close();
       System.out.print("\n The File was created and written successfully !!\n");
	   }
	   catch (IOException e) {
	   }
} 
  
// Main Method
public static void main(String args[]) {
	String line;
	int[] student = new int[1000];
	int[] marks = new int[1000];
	int[] ranks = new int[50];
	int i = 0, j = 0, rank, id = 0, score = 0, count = 0;

	  
	   // file read throws exception so file read code is embedded in try catch block
	   try {
		   // Read input from the file 'rank.in'
		   BufferedReader inFile = new BufferedReader(new FileReader("rank.in"));
		   while((line=inFile.readLine()) != null) {
			   if(Integer.parseInt(line.split("\\s")[1]) != 0) {
				   student[i] = Integer.parseInt(line.split("\\s")[0]);
				   marks[i] = Integer.parseInt(line.split("\\s")[1]);
				   i = i + 1;

			   }
			   else { 
				   if(i != 0) {
					   count = i;
					   score = findMarks(id, student, marks, count);
					   rank = findRank(marks, score);
					   ranks[j] = rank;
					   j = j + 1;
					   i = 0;

				   }
				   else {
				   id = Integer.parseInt(line.split("\\s")[0]);

				   }
				} 
		   } 
		   count = i;
		   score = findMarks(id, student, marks, count);
		   rank = findRank(marks, score);
		   ranks[j] = rank;
		   fileWrite(ranks, j+1);
		   inFile.close();

	   }
	   catch(IOException e) {}

	} 
}

