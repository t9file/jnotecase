package shell;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class Snippet248 {
public static void main (String [] args) {
	Display display = new Display ();
	final Shell shell = new Shell (display);
	shell.setLayout (new FillLayout ());
	shell.addListener (SWT.Traverse, new Listener () {
		@Override
		public void handleEvent (Event event) {
			switch (event.detail) {
				case SWT.TRAVERSE_ESCAPE:
					shell.close ();
					event.detail = SWT.TRAVERSE_NONE;
					event.doit = false;
					break;
			}
		}
	});
	Button button = new Button (shell, SWT.PUSH);
	button.setText ("A Button (that doesn't process Escape)");
	shell.pack ();
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
}
