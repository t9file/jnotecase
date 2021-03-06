package tree;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;

public class Snippet358 {
	
public static void main(String [] args) {
	Display display = new Display();
	Shell shell = new Shell(display);
	shell.setLayout(new GridLayout ());
	final Tree tree = new Tree(shell, SWT.NONE);
	tree.setLayoutData(new GridData(200, 200));
	for (int i = 0; i < 9; i++) {
		TreeItem item = new TreeItem(tree, SWT.NONE);
		item.setText("root-level item " + i);
		for (int j = 0; j < 9; j++) {
			new TreeItem(item, SWT.NONE).setText("item " + i + "-" + j);
		}
	}

	Button button = new Button(shell, SWT.PUSH);
	button.setText("Print item visibilities");
	button.addListener(SWT.Selection, new Listener() {
		@Override
		public void handleEvent(Event event) {
			Rectangle treeBounds = new Rectangle(0, 0, 0, 0);
			Point treeSize = tree.getSize();
			treeBounds.width = treeSize.x;
			treeBounds.height = treeSize.y;
			TreeItem[] rootItems = tree.getItems();
			for (int i = 0; i < rootItems.length; i++) {
				TreeItem rootItem = rootItems[i];
				System.out.println(rootItem.getText() + " is at least partially visible? " + treeBounds.intersects(rootItem.getBounds()));
				TreeItem[] childItems = rootItem.getItems();
				for (int j = 0; j < childItems.length; j++) {
					TreeItem childItem = childItems[j];
					System.out.println(childItem.getText() + " is at least partially visible? " + treeBounds.intersects(childItem.getBounds()));
				}
			}
		}
	});

	shell.pack();
	shell.open();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch()) display.sleep();
	}
	display.dispose ();
}

}