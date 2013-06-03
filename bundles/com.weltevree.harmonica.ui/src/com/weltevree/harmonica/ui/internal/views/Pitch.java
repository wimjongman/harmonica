package com.weltevree.harmonica.ui.internal.views;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class Pitch {

	@PostConstruct
	public void createPart(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

	}

	@Focus
	protected void focus() {
	}

}
