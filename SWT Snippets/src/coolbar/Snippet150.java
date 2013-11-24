package coolbar;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class Snippet150 {

static int itemCount;
static CoolItem createItem(CoolBar coolBar, int count) {
    ToolBar toolBar = new ToolBar(coolBar, SWT.FLAT);
    for (int i = 0; i < count; i++) {
        ToolItem item = new ToolItem(toolBar, SWT.PUSH);
        item.setText(itemCount++ +"");
    }
    toolBar.pack();
    Point size = toolBar.getSize();
    CoolItem item = new CoolItem(coolBar, SWT.NONE);
    item.setControl(toolBar);
    Point preferred = item.computeSize(size.x, size.y);
    item.setPreferredSize(preferred);
    return item;
}

public static void main(String[] args) {
    Display display = new Display();
    final Shell shell = new Shell(display);
    CoolBar coolBar = new CoolBar(shell, SWT.NONE);
    createItem(coolBar, 3);
    createItem(coolBar, 2);
    createItem(coolBar, 3);
    createItem(coolBar, 4);
    int style = SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL;
    Text text = new Text(shell, style);
    FormLayout layout = new FormLayout();
    shell.setLayout(layout);
    FormData coolData = new FormData();
    coolData.left = new FormAttachment(0);
    coolData.right = new FormAttachment(100);
    coolData.top = new FormAttachment(0);
    coolBar.setLayoutData(coolData);
    coolBar.addListener(SWT.Resize, new Listener() {
        @Override
		public void handleEvent(Event event) {
            shell.layout();
        }
    });
    FormData textData = new FormData();
    textData.left = new FormAttachment(0);
    textData.right = new FormAttachment(100);
    textData.top = new FormAttachment(coolBar);
    textData.bottom = new FormAttachment(100);
    text.setLayoutData(textData);
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) display.sleep();
    }
    display.dispose();
}
}
