package com.weltevree.harmonica.ui.internal.views;

import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.sound.sampled.Mixer.Info;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.widgets.pshelf.PShelf;
import org.eclipse.nebula.widgets.pshelf.PShelfItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import be.hogent.tarsos.dsp.util.Shared;

public class Pitch {

	private static class ContentProvider implements IStructuredContentProvider {
		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Vector) {
				return ((Vector<?>) inputElement).toArray();
			}
			return new Object[0];
		}

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table table;
	private TableViewer tableViewer;

	@PostConstruct
	public void createPart(Composite parent) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = formToolkit.createComposite(parent, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		composite.setLayout(new GridLayout(1, false));

		PShelf shelf = new PShelf(composite, SWT.NONE);
		shelf.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.adapt(shelf);
		formToolkit.paintBordersFor(shelf);

		PShelfItem shelfItem = new PShelfItem(shelf, SWT.NONE);
		shelfItem.setText("Input");
		shelfItem.getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite_1 = new Composite(shelfItem.getBody(), SWT.NONE);
		formToolkit.adapt(composite_1);
		formToolkit.paintBordersFor(composite_1);
		TableColumnLayout tcl_composite_1 = new TableColumnLayout();
		composite_1.setLayout(tcl_composite_1);

		tableViewer = new TableViewer(composite_1, SWT.CHECK | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		formToolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return null;
			}

			@Override
			public String getText(Object element) {
				if (element instanceof Info) {
					return ((Info) element).getDescription();
				}
				return "not a mixer";
			}
		});
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tcl_composite_1.setColumnData(tblclmnNewColumn, new ColumnWeightData(1, ColumnWeightData.MINIMUM_WIDTH, true));
		tblclmnNewColumn.setText("New Column");
		tableViewer.setContentProvider(new ContentProvider());

		PShelfItem shelfItem_1 = new PShelfItem(shelf, SWT.NONE);
		shelfItem_1.setText("Properties");
		shelfItem_1.getBody().setLayout(new GridLayout(1, false));

		Section sctnNewSection = formToolkit.createSection(shelfItem_1.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("New Section");

		setInput();
	}

	private void setInput() {

		tableViewer.setInput(Shared.getMixerInfo(false, true));

	}

	@Focus
	protected void focus() {
		if(tableViewer == null)
			return;
		tableViewer.getControl().setFocus();
	}
}
