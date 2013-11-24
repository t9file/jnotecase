package text;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.events.*;

public class Snippet258 {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(2, false));
		
		final Text text = new Text(shell, SWT.SEARCH | SWT.ICON_CANCEL);
		Image image = null;
		if ((text.getStyle() & SWT.ICON_CANCEL) == 0) {
			image = display.getSystemImage(SWT.ICON_ERROR);
			ToolBar toolBar = new ToolBar (shell, SWT.FLAT);
			ToolItem item = new ToolItem (toolBar, SWT.PUSH);
			item.setImage (image);
			item.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					text.setText("");
					System.out.println("Search cancelled");
				}
			});
		}
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		text.setText("Search text");
		text.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				if (e.detail == SWT.CANCEL) {
					System.out.println("Search cancelled");
				} else {
					System.out.println("Searching for: " + text.getText() + "...");
				}
			}
		});

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		if (image != null) image.dispose();
		display.dispose();
	}
}
