import java.io.*;
import java.util.*;


public class RankStudent {

public static int findMarks(int id, int[] students, int[] marks, int count) {

	for(int i=0; i<count; i++) {
		if(id == students[i])
		return marks[i];
	}
	return 0;

}

public static int findRank(int[] marks, int scores) {

	int rank;
	List<Integer> arrayList = new ArrayList<Integer>(marks.length);
	for (int i : marks) {
		arrayList.add(i);
	}

	Collections.sort(arrayList, Collections.reverseOrder());
	rank = arrayList.indexOf(scores) + 1;
	return rank;
}
public static void fileWriter(int[] ranks, int count) {
	for(int i=0; i<count; i++)
		System.out.println(ranks[i]);
	  
	try {
		PrintWriter outFile = new PrintWriter(new FileWriter("rank.out"));
       for(int i=0; i<count; i++)
       outFile.write(ranks[i] + "\n");
       outFile.close();
       System.out.print("\n The File was created and written successfully !!\n");
	   }
	   catch (IOException e) {
	   }
} 
  
public static void main(String args[]) {
	String line;
	int[] students = new int[1000];
	int[] marks = new int[90];
	int[] ranks = new int[40];
	int i = 0, j = 0, rank, id = 0, scores = 0, count = 0;

	  
	   try {
		   BufferedReader inFile = new BufferedReader(new FileReader("rank.in"));
		   while((line=inFile.readLine()) != null) {
			   if(Integer.parseInt(line.split("\\s")[1]) != 0) {
				   students[i] = Integer.parseInt(line.split("\\s")[0]);
				   marks[i] = Integer.parseInt(line.split("\\s")[1]);
				   i = i + 1;

			   }
			   else { 
				   if(i != 0) {
					   count = i;
					   scores = findMarks(id, students, marks, count);
					   rank = findRank(marks, scores);
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
		   scores = findMarks(id, students, marks, count);
		   rank = findRank(marks, scores);
		   ranks[j] = rank;
		   fileWriter(ranks, j+1);
		   inFile.close();

	   }
	   catch(IOException e) {}

	} 
}

