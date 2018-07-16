import java.util.Random;
public class IcecreamDivision
{
	int[] priceArray=new int[20];
		boolean foundPrice2;
	int Price1;
	int Price2;
	
	
	//*********Constructor starts here to initialize trhe ice creak price list array*********
	public IcecreamDivision()
	{
		
		for(int i=0;i<priceArray.length;i++)
		{
			priceArray[i]=generateNumer10To100();
			System.out.print(" ," +priceArray[i]);
		}
		
	}
		
	public int generateNumer10To100()
	{
		Random randomNumObj = new Random();
		int randomNumber = randomNumObj.nextInt(100-10) + 10;
		return randomNumber;
	}
	//***********Constructor ends  here *************************************//

	
	public void divideIceCreamShare(int moneyShare)
	{
			//start with first Element
			for(int i=0;i<priceArray.length;i++)
			{
				Price1=priceArray[i];
				Price2=moneyShare-Price1;
				foundPrice2=findPrice2inpriceArray(Price2);
				if(foundPrice2==true)
				{ break;}
				else{continue;}
			}
			if(foundPrice2==false)
			{ System.out.println("Sorry..there seems to be no possible distibution.. Try again!!"); 
			}else{
				System.out.println("Here is how you can divide the share money: ");
				System.out.println(" First: "+Price1);
				System.out.println(" Second: "+Price2);
				
			}
			
			
	
	
	}
	
	public boolean findPrice2inpriceArray(int priceToMatch)
	{
		for(int i=0;i<priceArray.length;i++)
		{
			if(priceToMatch==priceArray[i]){ return true;}
			else{continue;}
		}
		return false;
		
	}

	//****Main function ****
	public static void main(String[] args)
	{
		int moneyShare;
		IcecreamDivision iceCreamObj=new IcecreamDivision();
		if(args.length!=0)
		{
			moneyShare=Integer.parseInt(args[0]);
			System.out.println("Moneyshare is :"+moneyShare);
			iceCreamObj.divideIceCreamShare(moneyShare);
		}else{
			System.out.println("Please Enter moneyshare as command line argument. E.g: java IcecreamDivision <moneyshare in integer>");
		}
		
		
		
	}
	
}
