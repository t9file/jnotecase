package text;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Snippet19 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	Text text = new Text (shell, SWT.BORDER | SWT.V_SCROLL);
	Rectangle clientArea = shell.getClientArea ();
	text.setBounds ( clientArea.x + 10, clientArea.y + 10, 200, 200);
	text.addListener (SWT.Verify, new Listener () {
		@Override
		public void handleEvent (Event e) {
			String string = e.text;
			char [] chars = new char [string.length ()];
			string.getChars (0, chars.length, chars, 0);
			for (int i=0; i<chars.length; i++) {
				if (!('0' <= chars [i] && chars [i] <= '9')) {
					e.doit = false;
					return;
				}
			}
		}
	});
	shell.open ();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 
