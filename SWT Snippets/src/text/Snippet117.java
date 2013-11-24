package text;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet117  {
public static void main(String[] args) {
	Display display = new Display();
	Shell shell = new Shell(display);
	shell.setLayout(new FillLayout());
	final Text t = new Text(shell, SWT.BORDER | SWT.MULTI);
	t.setText ("here is some text to be selected");
	Menu bar = new Menu (shell, SWT.BAR);
	shell.setMenuBar (bar);
	MenuItem editItem = new MenuItem (bar, SWT.CASCADE);
	editItem.setText ("Edit");
	Menu submenu = new Menu (shell, SWT.DROP_DOWN);
	editItem.setMenu (submenu);

	MenuItem item = new MenuItem (submenu, SWT.PUSH);
	item.addListener (SWT.Selection, new Listener () {
		@Override
		public void handleEvent (Event e) {
			t.selectAll();
		}
	});
	item.setText ("Select &All\tCtrl+A");
	item.setAccelerator (SWT.MOD1 + 'A');
	
	// Note that as long as your application has not overridden 
	// the global accelerators for copy, paste, and cut 
	//(CTRL+C or CTRL+INSERT, CTRL+V or SHIFT+INSERT, and CTRL+X or SHIFT+DELETE)
	// these behaviours are already available by default.
	// If your application overrides these accelerators,
	// you will need to call Text.copy(), Text.paste() and Text.cut()
	// from the Selection callback for the accelerator when the 
	// text widget has focus.

	shell.setSize(200, 200);
	shell.open();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch())
			display.sleep();
	}
	display.dispose();
}
}

