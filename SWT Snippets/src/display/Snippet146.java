package display;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class Snippet146 {

public static void main(String[] args) {
	final Display display = new Display();
	final Shell shell = new Shell(display);
	final Text text = new Text(shell, SWT.BORDER);
	text.setSize(text.computeSize(150, SWT.DEFAULT));
	shell.pack();
	shell.open();
	new Thread(){
		@Override
		public void run(){
			String string = "Love the method.";
			for (int i = 0; i < string.length(); i++) {
				char ch = string.charAt(i);
				boolean shift = Character.isUpperCase(ch);
				ch = Character.toLowerCase(ch);
				if (shift) {
					Event event = new Event();
					event.type = SWT.KeyDown;
					event.keyCode = SWT.SHIFT;
					display.post(event);	
				}
				Event event = new Event();
				event.type = SWT.KeyDown;
				event.character = ch;
				display.post(event);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {}
				event.type = SWT.KeyUp;
				display.post(event);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
				if (shift) {
					event = new Event();
					event.type = SWT.KeyUp;
					event.keyCode = SWT.SHIFT;
					display.post(event);	
				}
			}
		}	
	}.start();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch()) display.sleep();
	}
	display.dispose();
}
}
