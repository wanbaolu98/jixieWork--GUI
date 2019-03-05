package jxWork;

public class algorithm 
{
	Object[][] x,y,z;
	double [][] doux,douy,douz;
	int xleng,yleng,zleng;
	public static void main(String[] args) 
	{
	}
	public algorithm(Object[][] x,Object[][] y,Object[][] z) 
	{
		this.x=x;
		this.y=y;
		this.z=z;
		count();
	}
	public void count() 
	{
		xleng = dataLeng(x);
		yleng = dataLeng(y);
		zleng = dataLeng(z);
		double jg_x=0;
		double  jg_y=0;
		double jg_z=0;
		doux = zhuanhuan(x,xleng);
		douy = zhuanhuan(y,yleng);
		douz = zhuanhuan(z,zleng);
		
//		for(int i = 0;i<doux.length;i++) 
//		{
//			for(int j = 0;j<doux[i].length;j++) 
//			{
//				System.out.print(doux[i][j]+"  ");
//			}
//			System.out.println();
//		}
		
		
		for(int i = 1;i<xleng-1;i++) 
		{
			for(int j=1;j<yleng-1;j++) 
			{
				for(int k = 1;k<zleng-1;k++) 
				{
//					jg_x = -x[i][1]-y[j][1]-z[k][1]-(y[j][0]*(x[i][6]-Sxy))-(z[k][0]*(x[i][5]+y[j][5]+Sxz);
					jg_x = -doux[1][i]-douy[1][j]-douz[1][k]-(douy[0][j]*(doux[6][i]-0))-(douz[0][k]*(doux[5][i]+douy[5][j]+0));
//					jg_y = -x[i][2]-y[j][2]-z[k][2]+(z[k][0]*(x[i][4]+y[j][4]-Syz));
//					jg_y = -doux[i][2]-douy[j][2]-douz[k][2]+(douz[k][0]*(doux[i][4]+douy[j][4]-0));
//					jg_z = -doux[i][3]-douy[j][3]+douz[k][3]+(douy[j][0]*doux[i][4]);
					System.out.println(jg_x+"----"+jg_y+"----"+jg_z);
				}
			}
		}
		
	}
	
	public int dataLeng(Object[][] data) 
	{
		int leng = 0;
		outer:for(int i = 0;i<7;i++) 
		{
			for(int j = 1;j<15;j++) 
			{
				if(data[i][j]==null) 
				{
					leng = j;
					break outer;
				}
			}
		}
		return leng;
	}
	public double[][] zhuanhuan(Object[][] data,int leng) 
	{
		System.out.println(leng);
		double[][] jieg = new double[7][leng-1];
		for(int i = 0;i<7;i++) 
		{
			for(int j = 0,k=1;j<leng-1;j++) 
			{
				jieg[i][j]=(double) data[i][k];
//				System.out.println(j);
//				System.out.println((double) data[i][k]);
				k++;
//				jieg[i][j]=(double) data[i][j+1];
//				jieg[i][j]=1.0;
			}
		}
		return jieg;
	}

}
