package tabfolderitem;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet82 {
	
public static void main(String[] args) {
	Display display = new Display();
	Shell shell = new Shell(display);
	shell.setLayout(new FillLayout());
	CTabFolder folder = new CTabFolder(shell, SWT.BORDER);
	for (int i = 0; i < 4; i++) {
		CTabItem item = new CTabItem(folder, SWT.CLOSE);
		item.setText("Item "+i);
		Text text = new Text(folder, SWT.MULTI);
		text.setText("Content for Item "+i);
		item.setControl(text);
	}
	
	final CTabItem specialItem = new CTabItem(folder, SWT.CLOSE);
	specialItem.setText("Don't Close Me");
	Text text = new Text(folder, SWT.MULTI);
	text.setText("This tab can never be closed");
	specialItem.setControl(text);
		
	folder.addCTabFolder2Listener(new CTabFolder2Adapter() {
		@Override
		public void close(CTabFolderEvent event) {
			if (event.item.equals(specialItem)) {
				event.doit = false;
			}
		}
	});
	
	final CTabItem noCloseItem = new CTabItem(folder, SWT.NONE);
	noCloseItem.setText("No Close Button");
	Text text2 = new Text(folder, SWT.MULTI);
	text2.setText("This tab does not have a close button");
	noCloseItem.setControl(text2);
	
	shell.pack();
	shell.open();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch())
			display.sleep();
	}
	display.dispose();
}
}