package jxWork;

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
	String[] ab = new String[15] ;
	//记录数据的数组
	Object[][] data ;
	
	public Object[][] getData() {
		return data;
	}

	//区分是哪个表格的标识
	int bz;
	/**
	 * 构造函数，通过构造函数来对三个表格进行区分，并将第一列数据显示在表格上
	 * 
	 */
	public tableModel(int bz,Object[][] x) 
	{
		this.data =x;
		//注册表格监听器
//		mytbE = new mytableEvent();
		if(bz==1) 
		{
			data[0][0]="x/mm";
			data[1][0]="dxx/mm";
			data[2][0]="dyx/mm";
			data[3][0]="dzx/mm";
			data[4][0]="exx/mm";
			data[5][0]="eyx/mm";
			data[6][0]="ezx/mm";
			ab=new String[]{null,"x1","x2","x3","x4","x5","x6","x7","x8","x9","x10","x11","x12","x13","x14"};
		}
		else if(bz==2) 
		{
			data[0][0]="y/mm";
			data[1][0]="dxy/mm";
			data[2][0]="dyy/mm";
			data[3][0]="dzy/mm";
			data[4][0]="exy/mm";
			data[5][0]="eyy/mm";
			data[6][0]="ezy/mm";
			ab=new String[]{null,"y1","y2","y3","y4","y5","y6","y7","y8","y9","y10","y11","y12","y13","y14"};
		}
		else if(bz==3)
		{
			data[0][0]="z/mm";
			data[1][0]="dxz/mm";
			data[2][0]="dyz/mm";
			data[3][0]="dzz/mm";
			data[4][0]="exz/mm";
			data[5][0]="eyz/mm";
			data[6][0]="ezz/mm";
			ab=new String[]{null,"z1","z2","z3","z4","z5","z6","z7","z8","z9","z10","z11","z12","z13","z14"};
		}
		this.bz=bz;
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
		return 15;
	}
	
	
	
//	@Override
//	public Object getValueAt(int rowIndex, int columnIndex) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
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
    }
    
//    class mytableEvent implements TableModelListener
//	{
//
//		@Override
//		public void tableChanged(TableModelEvent e) 
//		{
//			// TODO Auto-generated method stub
//		}
//		
//	}
}
