package menu;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class Snippet131 {
public static void main (String [] args) {
	final Display display = new Display ();
	final Shell shell = new Shell (display);
	shell.addListener (SWT.MenuDetect, new Listener () {
		@Override
		public void handleEvent (Event event) {
			Menu menu = new Menu (shell, SWT.POP_UP);
			MenuItem item = new MenuItem (menu, SWT.PUSH);
			item.setText ("Menu Item");
			item.addListener (SWT.Selection, new Listener () {
				@Override
				public void handleEvent (Event e) {
					System.out.println ("Item Selected");
				}
			});
			menu.setLocation (event.x, event.y);
			menu.setVisible (true);
			while (!menu.isDisposed () && menu.isVisible ()) {
				if (!display.readAndDispatch ()) display.sleep ();
			}
			menu.dispose ();
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
