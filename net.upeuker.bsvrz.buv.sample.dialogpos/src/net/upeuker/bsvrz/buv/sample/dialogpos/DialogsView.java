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
import org.eclipse.ui.part.ViewPart;

import de.bsvrz.buv.rw.basislib.util.DefaultDialogPosition;

/**
 * Testansicht, mit dem Dialoge mit verschiedenen Positionierungen geöffnet
 * werden können.
 * 
 * Für alle Positionen vom Typ {@link DefaultDialogPosition} und 5 mit Namen
 * versehene Dialoge sind Schaltflächen vorhanden, über dem der jeweilige Dialog
 * angezeigt wird.
 * 
 * @author Uwe Peuker
 * 
 */
public class DialogsView extends ViewPart {

	@Override
	public void createPartControl(final Composite parent) {

		final Composite panel = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(5).applyTo(panel);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(panel);

		addButtonFor(panel, "TopLeftScreen",
				DefaultDialogPosition.SCREEN_TOP_LEFT);
		addButtonFor(panel, "TopRightScreen",
				DefaultDialogPosition.SCREEN_TOP_RIGHT);
		addButtonFor(panel, "BottomLeftScreen",
				DefaultDialogPosition.SCREEN_BOTTOM_LEFT);
		addButtonFor(panel, "BottomRightScreen",
				DefaultDialogPosition.SCREEN_BOTTOM_RIGHT);
		addButtonFor(panel, "CenterScreen", DefaultDialogPosition.SCREEN_CENTER);

		addButtonFor(panel, "TopLeftApp", DefaultDialogPosition.APP_TOP_LEFT);
		addButtonFor(panel, "TopRightApp", DefaultDialogPosition.APP_TOP_RIGHT);
		addButtonFor(panel, "BottomLeftApp",
				DefaultDialogPosition.APP_BOTTOM_LEFT);
		addButtonFor(panel, "BottomRightApp",
				DefaultDialogPosition.APP_BOTTOM_RIGHT);
		addButtonFor(panel, "CenterApp", DefaultDialogPosition.APP_CENTER);

		addDialogButtonFor(panel, "TopLeftParent",
				DefaultDialogPosition.PARENT_TOP_LEFT);
		addDialogButtonFor(panel, "TopRightParent",
				DefaultDialogPosition.PARENT_TOP_RIGHT);
		addDialogButtonFor(panel, "BottomLeftParent",
				DefaultDialogPosition.PARENT_BOTTOM_LEFT);
		addDialogButtonFor(panel, "BottomRightParent",
				DefaultDialogPosition.PARENT_BOTTOM_RIGHT);
		addDialogButtonFor(panel, "CenterParent",
				DefaultDialogPosition.PARENT_CENTER);

		addButtonFor(panel, "Saveable1", null);
		addButtonFor(panel, "Saveable2", null);
		addButtonFor(panel, "Saveable3", null);
		addButtonFor(panel, "Saveable4", null);
		addButtonFor(panel, "Saveable5", null);
	}

	private void addButtonFor(final Composite panel, final String name,
			final DefaultDialogPosition position) {
		final Button button = new Button(panel, SWT.PUSH);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(button);
		button.setText(name);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				Dialog dialog;
				if (position != null) {
					dialog = new DemoDialog(getSite().getShell(), name,
							position);
				} else {
					dialog = new SaveableDemoDialog(getSite().getShell(), name);
				}
				dialog.open();
			}
		});
	}

	private void addDialogButtonFor(final Composite panel, final String name,
			final DefaultDialogPosition position) {
		final Button button = new Button(panel, SWT.PUSH);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(button);
		button.setText(name);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final Dialog dialog = new DemoParentDialog(
						getSite().getShell(), name, position);
				dialog.open();
			}
		});
	}

	@Override
	public void setFocus() {
		// wird nicht behandelt
	}
}
