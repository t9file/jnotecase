package sash;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Snippet54 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	shell.setSize(400, 300);
	final Sash sash = new Sash (shell, SWT.BORDER | SWT.VERTICAL);
	Rectangle clientArea = shell.getClientArea ();
	sash.setBounds (180, clientArea.y, 32, clientArea.height);
	sash.addListener (SWT.Selection, new Listener () {
		@Override
		public void handleEvent (Event e) {
			sash.setBounds (e.x, e.y, e.width, e.height);
		}
	});
	shell.open ();
	sash.setFocus ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 
