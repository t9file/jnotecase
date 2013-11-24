package display;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Snippet7 {
	
public static void main (String [] args) {
	final Display display = new Display ();
	final Image image = new Image (display, 16, 16);
	GC gc = new GC (image);
	gc.setBackground (display.getSystemColor (SWT.COLOR_RED));
	gc.fillRectangle (image.getBounds ());
	gc.dispose ();
	final Shell shell = new Shell (display);
	shell.setText ("Lazy Table");
	shell.setLayout (new FillLayout ());
	final Table table = new Table (shell, SWT.BORDER | SWT.MULTI);
	table.setSize (200, 200);
	Thread thread = new Thread () {
		@Override
		public void run () {
			for (int i=0; i<20000; i++) {
				if (table.isDisposed ()) return;
				final int [] index = new int [] {i};
				display.syncExec (new Runnable () {
					@Override
					public void run () {
						if (table.isDisposed ()) return;
						TableItem item = new TableItem (table, SWT.NONE);
						item.setText ("Table Item " + index [0]);
						item.setImage (image);
					}
				});
			}
		}
	};
	thread.start ();
	shell.setSize (200, 200);
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	image.dispose ();
	display.dispose ();
}
}
