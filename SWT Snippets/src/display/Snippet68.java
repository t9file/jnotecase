package display;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class Snippet68 {

public static void main (String [] args) {
	final Display display = new Display ();
	final Color red = display.getSystemColor (SWT.COLOR_RED);
	final Color blue = display.getSystemColor (SWT.COLOR_BLUE);
	Shell shell = new Shell (display);
	shell.setLayout (new RowLayout ());
	Button button = new Button (shell, SWT.PUSH);
	button.setText ("Stop Timer");
	final Label label = new Label (shell, SWT.BORDER);
	label.setBackground (red);
	final int time = 500;
	final Runnable timer = new Runnable () {
		@Override
		public void run () {
			if (label.isDisposed ()) return;
			Color color = label.getBackground ().equals (red) ? blue : red;
			label.setBackground (color);
			display.timerExec (time, this);
		}
	};
	display.timerExec (time, timer);
	button.addListener (SWT.Selection, new Listener () {
		@Override
		public void handleEvent (Event event) {
			display.timerExec (-1, timer);
		}
	});
	button.pack ();
	label.setLayoutData (new RowData (button.getSize ()));
	shell.pack ();
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 