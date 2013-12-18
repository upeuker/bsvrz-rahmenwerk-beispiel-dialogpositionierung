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
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import de.bsvrz.buv.rw.basislib.util.DialogPosition;

/**
 * einfacher Dialog, der entsprechend positioniert wird und lediglich seinen
 * Name anzeigt.
 * 
 * Die Positionierung des Dialogs erfolgt mit Hilfe der Instanzen der
 * Schnittstelle {@link DialogPosition} aus dem Rahmenwerk in der Funktion
 * {@link DemoDialog#getInitialLocation(Point)}.
 * 
 * @author Uwe Peuker
 */
public class DemoDialog extends Dialog {

	/** der Name des Dialogs. */
	private final String name;

	/** die gewünschte initiale Dialogposition. */
	private final DialogPosition dialogPosition;

	/**
	 * Konstruktor, erzeugt eine Instanz des Dialogs.
	 * 
	 * @param parent
	 *            die übergeordnete Shell
	 * @param name
	 *            der Name des Dialogs
	 * @param dialogPosition
	 *            die zu verwendende initiale Position
	 */
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

		/*
		 * aus der verwendeten Instanz der DialogPosition wird für den Dialog
		 * und die gewünschte Größe die gewünschte Zielposition ermittelt.
		 */
		final Point position = dialogPosition.getLocation(this, initialSize);

		/*
		 * Die Position wird potentiell korrigiert, um zu Erreichen, dass der
		 * gesamte Dialog sichtbar bleibt.
		 */
		final Rectangle bounds = getConstrainedShellBounds(new Rectangle(
				position.x, position.y, initialSize.x, initialSize.y));
		return new Point(bounds.x, bounds.y);
	}

	/**
	 * liefert den Name des Dialogs.
	 * 
	 * @return den Name
	 */
	public String getName() {
		return name;
	}
}
