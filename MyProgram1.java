public class MyProgram1
{

	int[] heightArray=new int[]{7,5,3,10,2,6,8,4,2,1};
	
int[] downSight=new int[10];
int[] UpSight=new int[10];
int[] TotalSight=new int[10];
	
	public void printDriverHeights()
	{
		for(int i=0;i<heightArray.length;i++)
		{
			System.out.println(heightArray[i]);
		}
	}
	
	
	public int getDriversBehindMe(int myposition)
	{	int count=0;
		if((heightArray.length -1) == myposition ){return count ;}
		
		for(int i=myposition+1;i<heightArray.length;i++)
		{
			if(heightArray[i]<=heightArray[myposition])
			{
				count++;
		
			}
			if(heightArray[i] >=heightArray[myposition])
			{ count++; 
				break;
			}
		
		}
		return count;
	}
	
	public void setdownSightArray()
	{
		for(int i=0;i<heightArray.length;i++)
		{
			downSight[i]=getDriversBehindMe(i);
		}
	}
	
	public void printdownSightArray()
	{	System.out.println("Printing down array");
		for(int i=0;i<downSight.length;i++)
		{
			System.out.println(downSight[i]);
		}
	}
	
	public void setUpSightArray()
	{
			for(int i=0;i<heightArray.length;i++)
			{
				UpSight[i]=getDriversBeforeMe(i);
			}
	}
	
	public int getDriversBeforeMe(int myposition)
	{ int count=0;
		if(myposition==0){ return count;}
		for(int i=myposition-1;i>=0;i--)
		{
			if(heightArray[i]<heightArray[myposition])
			{
				count++;
				
			}
			if(heightArray[i]>=heightArray[myposition])
			{
				count++;
				break;
			}
		}
		return count;
		
	}
	
	public void printUpSightArray()
	{	System.out.println("Printing upsight array");
		for(int i=0;i<UpSight.length;i++)
		{
			System.out.println(UpSight[i]);
		}
	}
	
	public void setTotalSightArray()
	{
		for(int i=0;i<TotalSight.length;i++)
		{
			if(i==0){TotalSight[i]=(downSight[i]+UpSight[i])*1;}
			else{
			TotalSight[i]=(downSight[i]+UpSight[i])*(i+1);
			}
		}
		
	}
	
	public void printTotalsightArray()
	{
		System.out.println("Total print array");
		for(int i=0;i<TotalSight.length;i++)
		{
			System.out.println(TotalSight[i]);
		}
	}
	
	
	public void findWinner()
	{ int max=TotalSight[0];
		int winnerLoc=0;
		for(int i=1;i<TotalSight.length;i++)
		{	
			if(TotalSight[i]<=max)
			{ continue;}
			else{
				max=TotalSight[i];
				winnerLoc=i;
			}
		}
		winnerLoc++;
		System.out.println("And the winner is.. position No-"+winnerLoc);
	}
	
	public static void main(String[] args)	
	{
		MyProgram1 m=new MyProgram1();
		m.printDriverHeights();
		m.setdownSightArray();
		m.printdownSightArray();
		m.setUpSightArray();
		m.printUpSightArray();
		m.setTotalSightArray();
		m.printTotalsightArray();
		
		m.findWinner();
		
		
	}
	

}