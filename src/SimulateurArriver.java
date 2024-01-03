import java.util.Scanner;

public class SimulateurArriver 
{
	public static void main ( String[] args )
	{
		Scanner scan = new Scanner(System.in);
		Boolean continBool = true;
		
		while(continBool)
		{
			System.out.println("combien de chevaux sont dans la course ? (12 a 20 chevaux) : ");
			int horsesNumber = scan.nextInt();
			System.out.println("quel est le type de couse ? (tierce, quarte, quinte) : ");
			String runType = scan.next();
			
			System.out.println("voulez vous rejouez ? : ");
			String continueAnswerString = scan.next();
			
			if(continueAnswerString.equals("O"))
			{
				continBool = true;
			}
			else 
			{
				continBool = false;
				System.out.println(" a bientot ");
			}
		}
		scan.close();
	}
}
