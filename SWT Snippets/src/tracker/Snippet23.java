package tracker;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Snippet23 {

public static void main (String [] args) {
	Display display = new Display ();
	final Shell shell = new Shell (display);
	shell.open ();
	shell.addListener (SWT.MouseDown, new Listener () {
		@Override
		public void handleEvent (Event e) {
			Tracker tracker = new Tracker (shell, SWT.NONE);
			tracker.setRectangles (new Rectangle [] {
				new Rectangle (e.x, e.y, 100, 100),
			});
			tracker.open ();
		}
	});
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 

