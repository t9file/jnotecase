package text;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class Snippet24 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	shell.setLayout (new RowLayout ());
	Combo combo = new Combo (shell, SWT.NONE);
	combo.setItems (new String [] {"A-1", "B-1", "C-1"});
	Text text = new Text (shell, SWT.SINGLE | SWT.BORDER);
	text.setText ("some text");
	combo.addListener (SWT.DefaultSelection, new Listener () {
		@Override
		public void handleEvent (Event e) {
			System.out.println (e.widget + " - Default Selection");
		}
	});
	text.addListener (SWT.DefaultSelection, new Listener () {
		@Override
		public void handleEvent (Event e) {
			System.out.println (e.widget + " - Default Selection");
		}
	});
	shell.pack ();
	shell.open ();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 
