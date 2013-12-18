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

import org.eclipse.swt.widgets.Shell;

import de.bsvrz.buv.rw.basislib.util.SavedDialogPosition;

/**
 * Erweiterung des DemoDialogs, der beim Betätigen der OK-Taste seine Position
 * speichert.
 * 
 * @author Uwe Peuker
 */
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
