package net.upeuker.bsvrz.buv.sample.dialogpos;

import org.eclipse.swt.widgets.Shell;

import de.bsvrz.buv.rw.basislib.util.SavedDialogPosition;

public class SaveableDemoDialog extends DemoDialog {

	protected SaveableDemoDialog(final Shell parent, final String name) {
		super(parent, name, new SavedDialogPosition(name));
	}

	@Override
	protected void okPressed() {
		SavedDialogPosition.savePosition(this, getName());
		super.okPressed();
	}
}
