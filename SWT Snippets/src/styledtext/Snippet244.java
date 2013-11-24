package styledtext;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet244 {
	static String SEARCH_STRING = "box";
    public static void main(String[] args) {
        final Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        final StyledText text = new StyledText(shell, SWT.NONE);
        StyleRange style = new StyleRange();
        style.borderColor = display.getSystemColor(SWT.COLOR_RED);
        style.borderStyle = SWT.BORDER_SOLID;
        StyleRange[] styles = {style};
        String contents = "This demonstrates drawing a box\naround every occurrence of the word\nbox in the StyledText";
        text.setText(contents);
		int index = contents.indexOf(SEARCH_STRING);
		while (index != -1) {
			text.setStyleRanges(0, 0, new int[] {index, SEARCH_STRING.length()}, styles);
			index = contents.indexOf(SEARCH_STRING, index + 1);
		}
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}
