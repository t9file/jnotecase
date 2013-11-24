package shell;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Snippet4 {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		Button b = new Button(shell, SWT.PUSH);
		b.setText("Open Dialog ...");
		b.pack();
		Rectangle clientArea = shell.getClientArea();
		b.setLocation(clientArea.x + 10, clientArea.y + 10);
		b.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent se) {
				Shell dialog = new Shell(shell, SWT.DIALOG_TRIM);
				dialog.addListener(SWT.Traverse, new Listener() {
					@Override
					public void handleEvent(Event e) {
						if (e.detail == SWT.TRAVERSE_ESCAPE) {
							e.doit = false;
						}
					}
				});
				dialog.open();
			}
		});
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
