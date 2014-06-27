package controller;

import javax.swing.table.AbstractTableModel;

/**
 * Created by Gergo on 2014.06.21..
 */
public class ModellCtrl {

    class InvoicesTableModel extends AbstractTableModel {


        @Override
        public int getRowCount() {
            return 0;
        }

        @Override
        public int getColumnCount() {
            return 0;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }
    }
}
