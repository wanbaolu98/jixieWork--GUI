package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class algorithm 
{
	double[] jieguo ;
	List<double[]> result = new ArrayList<>();
	/**
	 * ¼ÆËã¹¦ÄÜ
	 */
	public List<double[]> resultList(double[][] doux,double[][] douy,double[][] douz,double sxy,double syz,double sxz)
	{
		double jg_x=0;
		double  jg_y=0;
		double jg_z=0;
		System.out.println(doux.length+","+doux[0].length);
		for(int i = 0;i<doux[0].length;i++) 
		{
			for(int j=0;j<douy[0].length;j++) 
			{
				for(int k = 0;k<douz[0].length;k++) 
				{
					jg_x = -doux[1][i]-douy[1][j]+douz[1][k]-douy[0][j]*(doux[6][i]-sxy)-douz[0][k]*(doux[5][i]+douy[5][j]+sxz);
					jg_y = -doux[2][i]-douy[2][j]+douz[2][k]+douz[0][k]*(doux[4][i]+douy[4][j]-syz);
					jg_z = -doux[3][i]-douy[3][j]+douz[3][k]+douy[0][j]*doux[4][i];
					jieguo = new double[6];
					jieguo[0] = doux[0][i];
					jieguo[1] = douy[0][j];
					jieguo[2] = douz[0][k];
					jieguo[3] = jg_x;
					jieguo[4] = jg_y;
					jieguo[5] = jg_z;
					result.add(jieguo);
					System.out.println(jg_x+"----"+jg_y+"----"+jg_z);
				}
			}
		}
		Collections.sort(result, new Comparator<double[]>(){
			@Override
			public int compare(double[] o1, double[] o2) {
				System.out.println(o1[0]+","+o2[0]);
				if(o1[0]<o2[0]) {
					return -1;
				}
				if(o1[0]==o2[0]) {
					if(o1[1]<o2[1]) {
						return -1;
					}
					if(o1[1]==o2[1]) {
						if(o1[2]<o2[2]) {
							return -1;
						}
						if(o1[2]==o2[2]) {
							return 0;
						}
						return 1;
					}
					return 1;
				}
				// TODO Auto-generated method stub
				return 1;
			}});
		for(double[] i:result) {
			for(double j:i) {
				System.out.print(j+"  ");
			}
			System.out.println();
		}
		return result;
	
	}
}
