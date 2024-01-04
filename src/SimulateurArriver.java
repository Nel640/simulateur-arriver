import java.util.ArrayList;
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
			
			horsesNumber = verificationNumberHorses(horsesNumber, scan);
			
			System.out.println("quel est le type de couse ? (tierce, quarte, quinte) : ");
			String runType = scan.next();
			
			runType = verificationType(runType, scan);
			
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
			 nb = random.nextInt(nbMax-nbMin);
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
			int random = numberGenerate(1 , horsesNumber)+1; 
			if(!runResult.contains(random))
			{
				runResult.add(random);
			}
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
	
	public static String verificationType ( String Type , Scanner scan)
	{
		while( !Type.equals("tierce") && !Type.equals("quarte") && !Type.equals("quinte"))
		{
			System.out.println("tierce , quarte ou quinte uniquement : ");
			Type = scan.next();
		}
		return Type;
	}
	
	public static int verificationNumberHorses ( int numberHorse , Scanner scan)
	{
		while(numberHorse > 20 || numberHorse < 12 )
		{
			System.out.println("nombre de chevaux entre 12 et 20 uniquement : ");
			numberHorse = scan.nextInt();
		}
		return numberHorse;
	}
}
