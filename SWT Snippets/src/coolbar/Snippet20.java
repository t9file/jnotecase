package coolbar;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Snippet20 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	CoolBar bar = new CoolBar (shell, SWT.BORDER);
	for (int i=0; i<2; i++) {
		CoolItem item = new CoolItem (bar, SWT.NONE);
		Button button = new Button (bar, SWT.PUSH);
		button.setText ("Button " + i);
		Point size = button.computeSize (SWT.DEFAULT, SWT.DEFAULT);
		item.setPreferredSize (item.computeSize (size.x, size.y));
		item.setControl (button);
	}
	Rectangle clientArea = shell.getClientArea ();
	bar.setLocation (clientArea.x, clientArea.y);
	bar.pack ();
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 