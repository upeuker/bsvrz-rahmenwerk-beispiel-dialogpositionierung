/*
 * Beispiel-Plugin zur Demonstration der Positionierung von Dialogen mit den 
 * Hilfsklassen aus dem Rahmenwerk-Basis-Pluig-in.
 *
 * Copyright (c) 2013 Uwe Peuker.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GPL v3.
 */

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

/**
 * Implementierung eines Dialog, der als Parent für einen relativ zu einem
 * Parent zu positionierenden Dialog dient.
 * 
 * Der Dialog enthält ledigliche einen Button, um den zu positionierenden Dialog
 * zu öffnen.
 * 
 * @author Uwe Peuker
 */
public class DemoParentDialog extends Dialog {

	/** der Name des zu erzeugenden untergeordneten Dialogs. */
	private final String name;
	/** die gewünschte Zielposition des zu erzeugenden untergeordneten Dialogs. */
	private final DefaultDialogPosition position;

	/**
	 * Konstruktor, erzeugt einen Dialog mit dem ein Unterdialog mit dem
	 * angegebenen Name und der angegebenen Zielposition geöffnet werden soll.
	 * 
	 * @param shell
	 *            die übergeordnete Shell
	 * @param name
	 *            der Name des zu erzeugenden Unterdialogs
	 * @param position
	 *            die Position des zu erzeugenden Unterdialogs
	 */
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
