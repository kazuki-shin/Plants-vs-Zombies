/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Saves scores and transfers the scores to the score log
 */

package Pvz;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Saves scores and transfers the scores to the score log
 */
public class ScoreReader{
	
	private static int lines = countLines("Score.txt")+1;
	public static String[][] list = new String[lines][4];
	public static String [][]list2 = new String[][] {
        {"          1", "Kazuki Shin", "3000","Whoops"},
        {"          2","ZozoSoccerStar","2999","Lol"},
        {"          3","-","-"},
        {"          4","-","-"},
        {"          5","-","-"},
        {"          6","-","-"},
        {"          7","-","-"},
        {"          8","-","-"},
        {"          9","-","-"},
        {"          10","-","-"},
        {"          11","-","-"},
        {"          12","-","-"},
        {"          13","-","-"},
        {"          14","-","-"},
        {"          15","-","-"},
        {"          16","-","-"},
        {"          17","-","-"},
        {"          18","-","-"},
        {"          19","-","-"},
        {"          20","-","-"},
    }; 
	
    /**
     * Saves the score at the end of the game
     * @throws IOException
     */
	public static void saveToFile() throws IOException
	{
		String name = JOptionPane.showInputDialog("Enter your name: ");
		String comment = JOptionPane.showInputDialog("Leave a comment down below ;) (in 3 to 4 words)");
		Formatter file;
		
		Scanner pastData = new Scanner(new File("Score.txt"));
		String data = "";
		if(lines>=20){
			for(int i = 0; i <19;i++)
			{
				data+= "\n" + pastData.nextLine();
			}
		}
		//data = "\nZoe 0 I tried\nKazuki infinite Im always #1";
		if(lines<20)
		{
			while(pastData.hasNextLine())
			{
				data+= "\n" + pastData.nextLine();
			}
		}
		
		try{
			file = new Formatter("Score.txt");
			file.format("%s", name + " " +Player.getDeaths() + " " + comment +data);
			file.close();
			System.out.println("File was saved");
		}catch(Exception e){
			
		}

		
	}
	
	/**
	 * transfers the files to the score log
	 * @return the data of scores
	 * @throws IOException
	 */
	public static String[][] loadFromFile() throws IOException
	{
		
		Scanner pastData = new Scanner(new File("Score.txt"));
		String data = "";
		while(pastData.hasNextLine())
		{
			for(int i = 0; i<lines ;i++)
			{
				data = pastData.nextLine();
				Scanner split = new Scanner(data);
				String name = split.next();
				String score = split.next();
				String comment = data.substring(name.length()+score.length()+2);
				System.out.println(name + " " + score + " " + comment);
				list[i][0] = "" + (i+1) + " game(s) ago";
				list[i][1] = name;
				list[i][2] = score;
				list[i][3] = comment;
			}
		}
		return list;
		
	}
	
	/**
	 * counts the number of lines in the file
	 * @param filename
	 * @return the number of lines in the file
	 */
	public static int countLines(String filename) {
		try{
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
		}catch(Exception e)
		{
			
		}
		return 0;
	}

}
