package net.upeuker.bsvrz.buv.sample.dialogpos;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import de.bsvrz.buv.rw.basislib.util.DialogPosition;

public class DemoDialog extends Dialog {

	private final String name;
	private final DialogPosition dialogPosition;

	protected DemoDialog(final Shell parent, final String name,
			final DialogPosition dialogPosition) {
		super(parent);
		this.name = name;
		this.dialogPosition = dialogPosition;
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite panel = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(panel);
		final Label label = new Label(panel, SWT.NONE);
		label.setText(name);
		return panel;
	}

	@Override
	protected Point getInitialLocation(final Point initialSize) {
		final Point position = dialogPosition.getLocation(this, initialSize);
		final Rectangle bounds = getConstrainedShellBounds(new Rectangle(
				position.x, position.y, initialSize.x, initialSize.y));
		return new Point(bounds.x, bounds.y);
	}

	public String getName() {
		return name;
	}
}
