package net.upeuker.bsvrz.buv.sample.dialogpos;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import de.bsvrz.buv.rw.basislib.util.DefaultDialogPosition;

public class DemoParentDialog extends Dialog {

	private final String name;
	private final DefaultDialogPosition position;

	public DemoParentDialog(final Shell shell, final String name,
			final DefaultDialogPosition position) {
		super(shell);
		this.name = name;
		this.position = position;
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite panel = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(panel);
		GridDataFactory.fillDefaults().grab(true, true).hint(300, 300)
				.applyTo(panel);

		final Button button = new Button(panel, SWT.PUSH);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(button);
		button.setText(name);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final DemoDialog dialog = new DemoDialog(getShell(), name,
						position);
				dialog.open();
			}
		});

		return panel;
	}

}
