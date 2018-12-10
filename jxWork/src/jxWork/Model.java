package jxWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Model 
{
	private static double[][] x ;
	private static double[][] y ;
	private static double[][] z;
	public static void main(String[] args)
	{
//			jisuan();
		 read("123","C:\\Users\\yao\\Desktop\\123.xls",2);
		 pritshuzu();
	}
	public static void read(String mulu,String name,int pand) 
	{
		try {
//			InputStream in = new FileInputStream(new File("C:\\Users\\yao\\Desktop\\123.xls"));
			InputStream in = new FileInputStream(new File(name));
			String pdwenjian = (String) name.subSequence(name.length()-4, name.length());
			Workbook wb = null;
			if(pdwenjian.equals(".xls"))
			{
				wb = new HSSFWorkbook(in);
			}else if(pdwenjian.equals("xlsx")) 
			{
				wb = new XSSFWorkbook(in);
			}else 
			{
				System.out.println("¶Ô²»Æð");
			}
//			InputStream in = new FileInputStream(new File(mulu+name));
//			XSSFWorkbook wb = new XSSFWorkbook(in);
//			Workbook wb = new HSSFWorkbook(in);
			Sheet sheet = wb.getSheetAt(0);	
			
			double [][] zhans = new double[sheet.getRow(1).getLastCellNum()-1][7];
			System.out.println(sheet.getRow(1).getLastCellNum());
			int one=0;
			int two=0;
			if(sheet==null)
			{
				return;
			}
			for(int row=1;row<=sheet .getLastRowNum();row++)
			{
				Row hssrow = sheet.getRow(row);
				if(hssrow==null) 
				{
					continue;
				}
				for(int cell=1;cell<=hssrow.getLastCellNum();cell++) 
				{
					Cell hsshell = hssrow.getCell(cell);
					if(hsshell==null) 
					{
						continue;
					}
					double xzi = hsshell.getNumericCellValue();
					zhans[one][two] = xzi;
					if(one==zhans.length-1) 
					{
						one=0;
					}else 
					{
						one++;
					}
				}
				two++;
			}
			if(pand==1) 
			{
				x = zhans;
			}else if(pand==2) 
			{
				y = zhans;
			}else 
			{
				z = zhans;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void jisuan() 
	{
		double jg_x=0;
		double  jg_y=0;
		double jg_z=0;
		for(int i = 0;i<x.length;i++) 
		{
			for(int j=0;j<y.length;j++) 
			{
				for(int k = 0;k<z.length;k++) 
				{
//					jg_x = -x[i][1]-y[j][1]-z[k][1]-(y[j][0]*(x[i][6]-Sxy))-(z[k][0]*(x[i][5]+y[j][5]+Sxz);
					jg_x = -x[i][1]-y[j][1]-z[k][1]-(y[j][0]*(x[i][6]-0))-(z[k][0]*(x[i][5]+y[j][5]+0));
//					jg_y = -x[i][2]-y[j][2]-z[k][2]+(z[k][0]*(x[i][4]+y[j][4]-Syz));
					jg_y = -x[i][2]-y[j][2]-z[k][2]+(z[k][0]*(x[i][4]+y[j][4]-0));
					jg_z = -x[i][3]-y[j][3]+z[k][3]+(y[j][0]*x[i][4]);
					System.out.println(jg_x+"----"+jg_y+"----"+jg_z);
				}
			}
		}
	}
	
	
	
	public static void pritshuzu() 
	{
		for(int i = 0;i<y.length;i++) 
		{
			for(int j = 0;j<y[i].length;j++) 
			{
				System.out.print(y[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
}
