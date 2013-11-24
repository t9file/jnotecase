package datetime;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet250 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	shell.setLayout (new RowLayout ());

	DateTime calendar = new DateTime (shell, SWT.CALENDAR);
	calendar.addSelectionListener (new SelectionAdapter () {
		@Override
		public void widgetSelected (SelectionEvent e) {
			System.out.println ("calendar date changed");
		}
	});

	DateTime time = new DateTime (shell, SWT.TIME);
	time.addSelectionListener (new SelectionAdapter () {
		@Override
		public void widgetSelected (SelectionEvent e) {
			System.out.println ("time changed");
		}
	});

	shell.pack ();
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 
