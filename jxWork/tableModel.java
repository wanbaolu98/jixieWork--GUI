package model;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;


/**
 * 创建表格的模型类
 * @author yao
 *
 */
public class tableModel extends AbstractTableModel    
{
//	   private mytableEvent mytbE;
	
	//列名
	String[] ab = new String[30] ;
	//记录数据的数组
	Object[][] data = new Object[7][30] ;
	
//	public Object[][] getData() {
//		return data;
//	}
	public void dataChange(Object[][] x) {
		for(int i=0;i<x.length;i++) {
			for(int j=0;j<x[i].length;j++) 
			{
				try {
					this.data[i][j+1]=x[i][j];
				} catch (ArrayIndexOutOfBoundsException e) {
					// TODO: handle exception
				}
					
			}
		}
	}

	/**
	 * 构造函数，通过构造函数来对三个表格进行区分，并将第一列数据显示在表格上
	 * 
	 */
	public tableModel(String tab,Object[][] x) 
	{
		if(x!=null) {
			dataChange(x);
		}
		
		ab[0] = null;
		switch (tab) 
		{
			case "x":
				data[0][0]="x/mm";
				data[1][0]="dxx/mm";
				data[2][0]="dyx/mm";
				data[3][0]="dzx/mm";
				data[4][0]="exx/mm";
				data[5][0]="eyx/mm";
				data[6][0]="ezx/mm";
				for (int i=1;i<ab.length;i++) {
					ab[i] = "x"+i;
				}
				break;
			case "y":
				data[0][0]="y/mm";
				data[1][0]="dxy/mm";
				data[2][0]="dyy/mm";
				data[3][0]="dzy/mm";
				data[4][0]="exy/mm";
				data[5][0]="eyy/mm";
				data[6][0]="ezy/mm";
				for (int i=1;i<ab.length;i++) {
					ab[i] = "y"+i;
				}
				break;
			case "z":
				data[0][0]="z/mm";
				data[1][0]="dxz/mm";
				data[2][0]="dyz/mm";
				data[3][0]="dzz/mm";
				data[4][0]="exz/mm";
				data[5][0]="eyz/mm";
				data[6][0]="ezz/mm";
				for (int i=1;i<ab.length;i++) {
					ab[i] = "z"+i;
				}
				break;
		}
	}
	/**
	 * 选择表格存储的数据结构
	 */
	 public String getColumnName(int column)  
     {  
            return ab[column];  
     }
	 
	 /**
	  * 设置表格的行数
	  */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 7;
	}
	
	/**
	 * 设置表格的列数
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 30;
	}
	
	/** 
              * 得到数据所对应对象 
     */  
    @Override  
    public Object getValueAt(int rowIndex, int columnIndex)  
    {  
        return data[rowIndex][columnIndex];  
    }  
	
    /**
     * 将第一行设置为不可编辑
     */
	public boolean isCellEditable(int rowIndex, int columnIndex)  
    {  
        if (columnIndex < 1)  
            return false;  
        else  
            return true;  
    } 
	
	 /** 
     * 如果数据单元为可编辑，则将编辑后的值替换原来的值 
     */  
    @Override  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)  
    {  
        data[rowIndex][columnIndex] = aValue;
        System.out.println("aValue:"+aValue+"  rowIndex:"+rowIndex+"  columnIndex:"+columnIndex);
        /*通知监听器数据单元数据已经改变*/  
        fireTableCellUpdated(rowIndex, columnIndex);  
        for(int i = 0;i<data.length;i++) 
		{
			for(int j = 0;j<data[i].length;j++) 
			{
				System.out.print(data[i][j]+"  ");
			}
			System.out.println();
		}
    }
    
	public double[][] zhuanhuan() 
	{
		int leng = 0;
		outer:for(int i = 0;i<7;i++) 
		{
			for(int j = 1;j<30;j++) 
			{
				if(data[i][j]==null) 
				{
					if(j<leng||leng==0) {
						leng = j;
					}
					break;
				}
			}
		}
		System.out.println(leng);
		double[][] jieg = new double[7][leng-1];
		for(int i = 0;i<7;i++) 
		{
			for(int j = 0,k=1;j<leng-1;j++) 
			{
				jieg[i][j]=Double.parseDouble(data[i][k].toString()) ;
				k++;
			}
		}
		return jieg;
	}
}
