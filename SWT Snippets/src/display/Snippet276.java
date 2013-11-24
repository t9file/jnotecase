package display;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Snippet276 {

public static void main (String[] args) {
	final Display display = new Display ();
	Shell shell = new Shell (display);
	shell.setBounds (200, 200, 400, 400);
	Label label = new Label (shell, SWT.NONE);
	label.setText ("click in shell to print display-relative coordinate");
	Listener listener = new Listener () {
		@Override
		public void handleEvent (Event event) {
			Point point = new Point (event.x, event.y);
			System.out.println (display.map ((Control)event.widget, null, point));
		}
	};
	shell.addListener (SWT.MouseDown, listener);
	label.addListener (SWT.MouseDown, listener);
	Rectangle clientArea = shell.getClientArea();
	label.setLocation(clientArea.x, clientArea.y);
	label.pack ();
	shell.open ();
	while (!shell.isDisposed ()){
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}

}
