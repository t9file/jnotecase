package text;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet116  {
public static void main(String[] args) {
	Display display = new Display();
	Shell shell = new Shell(display);
	shell.setLayout(new GridLayout());
	Text text = new Text(shell, SWT.SINGLE | SWT.BORDER);
	text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	text.setText("Here is some text");
	text.addSelectionListener(new SelectionAdapter() {
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			System.out.println("Text default selected (overrides default button)");
		}
	});
	text.addTraverseListener(new TraverseListener() {
		@Override
		public void keyTraversed(TraverseEvent e) {
			if (e.detail == SWT.TRAVERSE_RETURN) {
				e.doit = false;
				e.detail = SWT.TRAVERSE_NONE;
			}
		}
	});
	Button button = new Button(shell, SWT.PUSH);
	button.setText("Ok");
	button.addSelectionListener(new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
			System.out.println("Button selected");
		}
	});
	shell.setDefaultButton(button);
	shell.pack();
	shell.open();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch())
			display.sleep();
	}
	display.dispose();
}
}
