package Utinity;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import Model.*;

public class ClassTableModel {
	public DefaultTableModel setTableFruit(List<Fruit> listitem, String[] listColumn) {
		int columns = listColumn.length;
		DefaultTableModel dtm = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int colIdenx) {
				return false;
			}

		};
		dtm.setColumnIdentifiers(listColumn);
		Object[] obj = null;
		int num = listitem.size();
		for (int i = 0; i < num; i++) {
			Fruit f = listitem.get(i);
			obj = new Object[columns];
			obj[0] = f.getId();
			obj[1] = f.getName();
			obj[2] = f.getPrice();
			

			dtm.addRow(obj);
		}
		return dtm;
	}
}
