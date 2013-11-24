package menu;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet286 {

	public static void main(java.lang.String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout());
		
		Canvas blankCanvas = new Canvas(shell, SWT.BORDER);
		blankCanvas.setLayoutData(new GridData(200, 200));
		final Label statusLine = new Label(shell, SWT.NONE);
		statusLine.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Menu bar = new Menu (shell, SWT.BAR);
		shell.setMenuBar (bar);
		
		MenuItem menuItem = new MenuItem (bar, SWT.CASCADE);
		menuItem.setText ("Test");
		Menu menu = new Menu(bar);
		menuItem.setMenu (menu);
		
		for (int i = 0; i < 5; i++) {
			MenuItem item = new MenuItem (menu, SWT.PUSH);
			item.setText ("Item " + i);
			item.addArmListener(new ArmListener() {
				@Override
				public void widgetArmed(ArmEvent e) {
					statusLine.setText(((MenuItem)e.getSource()).getText());
				}
			});
		}
		
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}
}