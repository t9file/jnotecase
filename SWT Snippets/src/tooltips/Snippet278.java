package tooltips;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet278 {

public static void main (String [] args) {
	final Display display = new Display ();
	Shell shell = new Shell (display);
	shell.setBounds (10, 10, 300, 100);
	shell.setLayout (new FillLayout ());
	final Label label = new Label (shell, SWT.NONE);
	label.setText ("resize the Shell then hover over this Label");
	label.addListener (SWT.MouseEnter, new Listener () {
		@Override
		public void handleEvent (Event event) {
			Point requiredSize = label.computeSize (SWT.DEFAULT, SWT.DEFAULT);
			Point labelSize = label.getSize ();
			boolean fullyVisible = requiredSize.x <= labelSize.x && requiredSize.y <= labelSize.y;
			System.out.println ("Label is fully visible: " + fullyVisible);
			label.setToolTipText (fullyVisible ? null : label.getText ());
		}
	});
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}

}
