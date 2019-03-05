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
	private  Object[][] data ;
	public Object[][] getX() {
		return data;
	}
	public Model() 
	{
		data= new Object[7][15];
	}
	public void read(String mulu,String name) 
	{
		try {
			InputStream in = new FileInputStream(new File(mulu+name));
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
				System.out.println("对不起");
			}
			Sheet sheet = wb.getSheetAt(0);	//返回该文件的第0张Sheet页
			
//			double [][] zhans = new double[sheet.getRow(1).getLastCellNum()-1][7];
			int hang=0;
			int lie=1;
			if(sheet==null)
			{
				return;
			}
			//getLastRowNum()是返回该页有多少行
			for(int row=1;row<=sheet .getLastRowNum();row++)
			{
				//getRow（x）是返回当前页的x列----对象。
				Row hssrow = sheet.getRow(row);
				if(hssrow==null) 
				{
					continue;
				}
				//getLastCellNum()返回该行有多少列。
				for(int cell=1;cell<=hssrow.getLastCellNum();cell++) 
				{
					//getCell（x）是返回当前行的第x列----对象。
					Cell hsshell = hssrow.getCell(cell);
					if(hsshell==null) 
					{
						continue;
					}
					//getNumericCellValue()将该数据转换为一个double类型的数据。
					double xzi = hsshell.getNumericCellValue();
					data[hang][lie] = xzi;
					if(lie==hssrow.getLastCellNum()-1) 
					{
						lie=1;
					}else 
					{
						lie++;
					}
				}
				hang++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void pritshuzu() 
//	{
//		for(int i = 0;i<data.length;i++) 
//		{
//			for(int j = 0;j<data[i].length;j++) 
//			{
//				System.out.print(data[i][j]+"  ");
//			}
//			System.out.println();
//		}
//	}
	
//	public static void jisuan() 
//	{
//		double jg_x=0;
//		double  jg_y=0;
//		double jg_z=0;
//		for(int i = 0;i<x.length;i++) 
//		{
//			for(int j=0;j<y.length;j++) 
//			{
//				for(int k = 0;k<z.length;k++) 
//				{
////					jg_x = -x[i][1]-y[j][1]-z[k][1]-(y[j][0]*(x[i][6]-Sxy))-(z[k][0]*(x[i][5]+y[j][5]+Sxz);
//					jg_x = -x[i][1]-y[j][1]-z[k][1]-(y[j][0]*(x[i][6]-0))-(z[k][0]*(x[i][5]+y[j][5]+0));
////					jg_y = -x[i][2]-y[j][2]-z[k][2]+(z[k][0]*(x[i][4]+y[j][4]-Syz));
//					jg_y = -x[i][2]-y[j][2]-z[k][2]+(z[k][0]*(x[i][4]+y[j][4]-0));
//					jg_z = -x[i][3]-y[j][3]+z[k][3]+(y[j][0]*x[i][4]);
//					System.out.println(jg_x+"----"+jg_y+"----"+jg_z);
//				}
//			}
//		}
//	}
}
