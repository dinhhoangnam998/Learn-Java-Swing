package com.example.demo.gui.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import org.springframework.stereotype.Component;

import com.example.demo.gui.component.form.TabbedPanel;
import com.example.demo.gui.component.table.TablePanel;
import com.example.demo.gui.eventlistener.AddPersonSubmitListener;
import com.example.demo.gui.eventlistener.QueryPersonSubmitListener;
import com.example.demo.gui.eventobject.AddPersonEvent;
import com.example.demo.gui.eventobject.QueryPersonEvent;

public class MainFrame extends JFrame {

	private TablePanel table;
	private TabbedPanel tabbedPanel;

	private JFileChooser fileChooser;

	public MainFrame() {
		super("Hello Swing");
		buildMenuBar();
		buildComponents();
		display();
	}

	private void buildComponents() {

		table = new TablePanel();
		add(table, BorderLayout.CENTER);

		tabbedPanel = new TabbedPanel(new AddPersonHandler(), new QueryPersonHandler());
		add(tabbedPanel, BorderLayout.WEST);
	}

	private void buildMenuBar() {
		fileChooser = new JFileChooser();
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		JMenuItem importItem = new JMenuItem("Import");
		importItem.setMnemonic(KeyEvent.VK_I);
		importItem.addActionListener(e -> {
			if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {

			}
		});

		JMenuItem exportItem = new JMenuItem("Export");
		exportItem.setMnemonic(KeyEvent.VK_E);
		exportItem.addActionListener(e -> {
			if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {

			}
		});

		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		exitItem.addActionListener(e -> {
			if (JOptionPane.showConfirmDialog(MainFrame.this, "Do you realy want exit?") == JOptionPane.OK_OPTION) {
				System.exit(1);
			}

		});

		fileMenu.add(importItem);
		fileMenu.add(exportItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);

		setJMenuBar(menuBar);
	}

	private void display() {
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	class AddPersonHandler implements AddPersonSubmitListener {
		public void formSubmitOccur(AddPersonEvent e) {

		}

	}

	class QueryPersonHandler implements QueryPersonSubmitListener {
		public void queryPersonOccur(QueryPersonEvent e) {

		}

	}

}
