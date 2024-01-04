import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SimulateurArriver 
{
	public static void main ( String[] args )
	{
		Scanner scan = new Scanner(System.in);
		Boolean continueBool = true;
		
		while(continueBool)
		{
			System.out.println("combien de chevaux sont dans la course ? (12 a 20 chevaux) : ");
			int horsesNumber = scan.nextInt();
			System.out.println("quel est le type de couse ? (tierce, quarte, quinte) : ");
			String runType = scan.next();
			
			while( !runType.equals("tierce") && !runType.equals("quarte") && !runType.equals("quinte"))
			{
				System.out.println("tierce , quarte ou quinte uniquement : ");
				runType = scan.next();
			}
			
			System.out.println("resultat de la course : " +  horsesToString(horsesResult(horsesNumber, runType)));
			System.out.println("voulez vous rejouez ? : ");
			String continueAnswer = scan.next();
			
			if(continueAnswer.toUpperCase().equals("O"))
			{
				continueBool = true;
			}
			else 
			{
				continueBool = false;
				System.out.println("a bientot ");
			}
		}
		scan.close();
	}
	
	public static int numberGenerate ( int nbMin , int nbMax)
	{
			 Random random = new Random();
			 int nb;
			 nb = nbMin+random.nextInt(nbMax-nbMin);
			 return nb;
	}
	
	public static ArrayList<Integer> horsesResult (int horsesNumber , String runType)
	{
		ArrayList<Integer> runResult = new ArrayList<>();
		int numberWinnerHorses = 0;
		
		if(runType.equals("tierce"))
		{
			numberWinnerHorses = 3;
		}
		else if (runType.equals("quarte"))
		{
			numberWinnerHorses = 4;
		}
		else
		{
			numberWinnerHorses = 6;
		}
		
		for(int i = 1 ; i < numberWinnerHorses + 1 ; i++)
		{
			int random = numberGenerate(1 , horsesNumber); 
			runResult.add(random);
		}
		
		return runResult;
	}
	
	public static String horsesToString ( ArrayList<Integer> horseResult)
	{
		String horsesString = "";
		for (int intostring : horseResult)
		{
			horsesString += intostring + "" + " ";
		}
		return horsesString;
	}
}
