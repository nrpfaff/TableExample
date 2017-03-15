package tableexample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class View extends ViewPart {
	public View() {
	}
	public static final String ID = "TableExample.view";
	private static final int DEFAULT_COLUMN_WIDTH = 60;
	
	private Text inputTextBox;
	private Table tableA;
	private Table tableB;
	private NumberTable tabA;
	private TableColumn tblclmnNewColumn;
	private TableViewerColumn tableViewerColumn;
	private TableColumn tblclmnNewColumn_1;
	private TableViewerColumn tableViewerColumn_1;
	private TableColumn tblclmnNewColumn_2;
	private TableViewerColumn tableViewerColumn_2;
	private TableColumn tblclmnNewColumn_3;
	private TableViewerColumn tableViewerColumn_3;
	private TableColumn tblclmnNewColumn_4;
	private TableViewerColumn tableViewerColumn_4;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		
		Composite c2 = new Composite(parent, SWT.NONE);
		c2.setLayout(new FormLayout());
		
		tabA = new NumberTable();
		int[][] numsA = tabA.getTable();

		inputTextBox = new Text(c2, SWT.BORDER);
		FormData fd_inputTextBox = new FormData();
		fd_inputTextBox.top = new FormAttachment(0, 106);
		fd_inputTextBox.left = new FormAttachment(0, 10);
		inputTextBox.setLayoutData(fd_inputTextBox);
		
		Button addButton = new Button(c2, SWT.NONE);
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				try{
					int num = Integer.parseInt(inputTextBox.getText());
					tabA.addNext(num);
					redrawTable(tabA);
					
				}catch(NumberFormatException ex){}
				
				inputTextBox.setText("");
			}
		});
		fd_inputTextBox.right = new FormAttachment(addButton, -6);
		FormData fd_addButton = new FormData();
		fd_addButton.top = new FormAttachment(0, 104);
		fd_addButton.left = new FormAttachment(0, 205);
		addButton.setLayoutData(fd_addButton);
		addButton.setText("Add");
		
		TableViewer tableViewerA = new TableViewer(c2, SWT.BORDER | SWT.FULL_SELECTION);
		tableA = tableViewerA.getTable();
		fd_inputTextBox.bottom = new FormAttachment(tableA, -11);
		FormData fd_tableA = new FormData();
		fd_tableA.left = new FormAttachment(0, 10);
		fd_tableA.bottom = new FormAttachment(100, -10);
		fd_tableA.top = new FormAttachment(32);
		tableA.setLayoutData(fd_tableA);
		
		tableViewerColumn = new TableViewerColumn(tableViewerA, SWT.NONE);
		tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(DEFAULT_COLUMN_WIDTH);
		tblclmnNewColumn.setText("Col 0");
		tableViewerColumn.getColumn().setResizable(false);
		
		tableViewerColumn_1 = new TableViewerColumn(tableViewerA, SWT.NONE);
		tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(DEFAULT_COLUMN_WIDTH);
		tblclmnNewColumn_1.setText("Col 1");
		tableViewerColumn_1.getColumn().setResizable(false);
		
		tableViewerColumn_2 = new TableViewerColumn(tableViewerA, SWT.NONE);
		tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setWidth(DEFAULT_COLUMN_WIDTH);
		tblclmnNewColumn_2.setText("Col 2");
		tableViewerColumn_2.getColumn().setResizable(false);
		
		tableViewerColumn_3 = new TableViewerColumn(tableViewerA, SWT.NONE);
		tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_3.setWidth(DEFAULT_COLUMN_WIDTH);
		tblclmnNewColumn_3.setText("Col 3");
		tableViewerColumn_3.getColumn().setResizable(false);
		
		tableViewerColumn_4 = new TableViewerColumn(tableViewerA, SWT.NONE);
		tblclmnNewColumn_4 = tableViewerColumn_4.getColumn();
		tblclmnNewColumn_4.setWidth(DEFAULT_COLUMN_WIDTH);
		tblclmnNewColumn_4.setText("Col 4");
		tableViewerColumn_4.getColumn().setResizable(false);
		
		tableA.setHeaderVisible(true);
		
		TableViewer tableViewerB = new TableViewer(c2, SWT.BORDER | SWT.FULL_SELECTION);
		tableB = tableViewerB.getTable();
		fd_tableA.right = new FormAttachment(48);
		FormData fd_tableB = new FormData();
		fd_tableB.left = new FormAttachment(tableA, 6);
		
		fd_tableB.right = new FormAttachment(100, -10);
		fd_tableB.bottom = new FormAttachment(100, -10);
		fd_tableB.top = new FormAttachment(32);
		tableB.setLayoutData(fd_tableB);
		
	}
	
	public void redrawTable(NumberTable t){
		for(int j = 0; j < 5; j++){
			TableItem item = new TableItem(tableA, SWT.NONE);
			for(int i =0; i < 5; i++){
				if(t.getTable()[i][j] != 0){
					item.setText(i, Integer.toString(t.getTable()[i][j]));	
				}
			}
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
//		viewer.getControl().setFocus();
	}
}