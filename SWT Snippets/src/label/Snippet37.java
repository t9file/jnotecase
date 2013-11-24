package label;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class Snippet37 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	shell.setLayout (new FillLayout ());
	new Label (shell, SWT.SEPARATOR | SWT.HORIZONTAL);
	new Label (shell, SWT.SEPARATOR | SWT.VERTICAL);
	shell.setSize (200, 200);
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 
