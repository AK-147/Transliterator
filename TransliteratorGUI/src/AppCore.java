// header files
import java.awt.*; import java.awt.event.*; import javax.swing.*;
import javax.swing.border.*; import javax.swing.event.*;
import javax.swing.table.*; import javax.swing.plaf.basic.*;

// graphical user interface for transliterator
public class AppCore {
	
	// instantiate containers and components
	private JFrame display; private JLabel menuLabel; private JLabel engToArLabel;
	private JLabel alphaLabel; private JLabel numLabel; private JLabel quitLabel;
	private CardLayout layer; public JTextArea engText; public JTextArea arText;
	private JLabel[] pages = {menuLabel, engToArLabel, alphaLabel, numLabel, quitLabel};
	private String[] pageNames = {"menu", "engToArPage", "alphaPage", "numPage", "quitPage"};
	
	// define dimensions
	private int displayLength; private int displayWidth; private Dimension displaySize;
	private Dimension buttonSize; private Dimension buttonSpacing; private Dimension menuUpperMargin;
	private Dimension menuLowerMargin; private Dimension pageUpperMargin; private Dimension pageLowerMargin;
	private Dimension textAreaSize; private Dimension listSize;
	
	// initialize theme colours
	private Color main = new Color(255, 252, 234); private Color border = new Color(122, 138, 153);

	// define references to transliteration index
	static AppIndex index = AppIndex.values()[0]; static AppIndex[] arabic = AppIndex.values();
	
	// construct application
	public AppCore() { init(); }
	
	
	// initialize required containers and components
	private void init() {
		
		// set component dimensions
		displayWidth = 600; displayLength = 440; displaySize = new Dimension(displayWidth, displayLength);
		buttonSize = new Dimension(300, 50); buttonSpacing = new Dimension(displayWidth, 5);
		menuUpperMargin = new Dimension(displayWidth, 140); menuLowerMargin = new Dimension(displayWidth, 100);
		pageUpperMargin = new Dimension(displayWidth, 70); pageLowerMargin = new Dimension(displayWidth, 15);
		textAreaSize = new Dimension(500, 110); listSize = new Dimension(500, 220);
		
		// create main display frame and set layout
		display = new JFrame("Transliterator"); display.setPreferredSize(displaySize); layer = new CardLayout();
		display.setResizable(false); display.setLocationRelativeTo(null); display.setLayout(layer);
		
		// define and set window icon
		Image icon = Toolkit.getDefaultToolkit().getImage("assets\\icon.png");
		display.setIconImage(icon);
		
		// locate background images for pages
		ImageIcon menuImg = new ImageIcon("assets\\menu.png"); ImageIcon background = new ImageIcon("assets\\bg.png");
		ImageIcon peace = new ImageIcon("assets\\peace.png");
		
		// initialize labels for each page and set layouts
		for (int i = 0; i < pages.length; i++) {
			
			// create menu page
			if (i == 0) { pages[i] = new JLabel(menuImg, JLabel.CENTER); }
			
			// create quitting page
			else if (i == pages.length - 1) { pages[i] = new JLabel(peace, JLabel.CENTER); }
			
			// create other pages
			else { pages[i] = new JLabel(background, JLabel.CENTER); }
			
			// set boundaries and layout
			pages[i].setBounds(0, 0, displayWidth, displayLength);
			pages[i].setLayout(new BoxLayout(pages[i], BoxLayout.PAGE_AXIS));
		}

		// define menu button images
		ImageIcon engToArImg; ImageIcon alphaListImg; ImageIcon numListImg;
		ImageIcon backImg; ImageIcon quitImg;engToArImg = new ImageIcon("assets\\buttonT.png");
		alphaListImg = new ImageIcon("assets\\buttonA.png"); numListImg = new ImageIcon("assets\\buttonN.png");
		backImg = new ImageIcon("assets\\buttonB.png"); quitImg = new ImageIcon("assets\\buttonQ.png");
		
		// create array of menu button names
		String[] menuButtonNames = {"engToAr", "alphaListBtn", "numListBtn", "quit"};
		
		// create menu buttons for navigation
		JButton engToAr; JButton alphaListBtn; JButton numListBtn; JButton quit; JButton back;
		JButton[] buttons = {engToAr = new JButton(engToArImg), alphaListBtn = new JButton(alphaListImg),
		numListBtn = new JButton(numListImg), quit = new JButton(quitImg)};
		
		// define components for nested pages
		JTable alphaList; JTable numList; int rowHeight = 40; String[] alphaColumns = {"Phonetics", "English", "Arabic"};
		String[] numColumns = {"Standard", "Arabic"}; Object[][] alphaData = {index.phonetics, index.english, arabic};
		String[][] numData = {index.stdNums, index.arNums};
		
		// set up button template and interaction
		for (int i = 0; i < buttons.length; i++) { designButton(buttons[i], buttonSize, menuButtonNames[i]); }
		
		// add buttons and spacing to menu page
		pages[0].add(Box.createRigidArea(menuUpperMargin)); for (JButton b : buttons) {
			
			if (b.equals(quit)) { pages[0].add(b); pages[0].add(Box.createRigidArea(menuLowerMargin)); }
			else { pages[0].add(b); pages[0].add(Box.createRigidArea(buttonSpacing)); }
		}
		
		
		// add components and spacing to nested pages
		for (JLabel i : pages) {
			
			// add spacing and define table model
			i.add(Box.createRigidArea(pageUpperMargin)); TableModel model;
			
			// add to transliteration page
			if (i.equals(pages[1])) {
				
				// create and design text areas
				engText = new JTextArea(); i.add(designTextArea(engText, "English", textAreaSize, true));
				arText = new JTextArea(); i.add(designTextArea(arText, "Arabic", textAreaSize, false));
			}
			
			// add to alphabetical conversions page
			else if (i.equals(pages[2])) {
				
				// set table model and design
				model = new TableModel(alphaColumns, alphaData); alphaList = new JTable(model);
				
				// add designed table to page
				i.add(designTable(alphaList, rowHeight, listSize));
			}
			
			// add to numerical conversions page
			else if (i.equals(pages[3])) {
				
				// set table model and design
				model = new TableModel(numColumns, numData); numList = new JTable(model);
				
				// add designed table to page
				i.add(designTable(numList, rowHeight, listSize));
			}
			
			// add back button to nested pages
			if (!i.equals(pages[4])) {
				
				i.add(Box.createRigidArea(pageLowerMargin)); back = new JButton(backImg);
				designButton(back, buttonSize, "back"); i.add(back);	
			}
		}
		
		// add label pages to display
		for (int i = 0; i < pages.length; i++) { display.add(pages[i], pageNames[i]); }
		
		// show display frame
		display.pack(); display.setVisible(true);
		
	} // end of function
	
	
	// create button with specified attributes
	private void designButton(JButton b, Dimension size, String commandName) {
		
		// define button size and center vertically along display
		b.setMaximumSize(size); b.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// remove default fill
		b.setContentAreaFilled(false); b.setFocusPainted(false);
		
		// define action upon interaction
		b.setActionCommand(commandName); b.addActionListener(new ButtonClickListener());

	} // end of function
	
	
	// create text area with specified attributes
	private JScrollPane designTextArea(JTextArea area, String title, Dimension size, boolean editable) {
		
		// define pane to allow scrolling
		JScrollPane scrollPane = designScrollPane(area, size);
		
		// set dimension and field colour
		area.setMaximumSize(size); area.setBackground(main);
		
		// allow text wrapping and define editing permissions
		area.setLineWrap(true); area.setWrapStyleWord(true); area.setEditable(editable);
		
		// manage borders and fonts to match theme
		TitledBorder titledBorder; Font titleFont; Font mainFont; area.setBorder(BorderFactory.createEmptyBorder());
		titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(border), title);
		titleFont = new Font(titledBorder.getTitleFont().toString(), Font.PLAIN, titledBorder.getTitleFont().getSize());
		titledBorder.setTitleFont(titleFont); scrollPane.setBorder(titledBorder);
		mainFont = new Font(titledBorder.getTitleFont().toString(), Font.PLAIN, 20); area.setFont(mainFont);
		
		// define maximum lines that can fit without scrolling
		final int ROW_LIMIT = 5;
		
		// prevent resizing upon exceeding maximum row limit
		area.getDocument().addDocumentListener(new DocumentListener() {

			// update text area upon detecting insert
            public void insertUpdate(DocumentEvent e) { resetDocumentRows(); }

            // update text area upon detecting removal
            public void removeUpdate(DocumentEvent e) { resetDocumentRows(); }

            // update text area upon detecting change of attributes
            public void changedUpdate(DocumentEvent e) { resetDocumentRows(); }

            // reset text area to default number of rows
            private void resetDocumentRows() {
            	
            	// set the number of rows
                if (area.getLineCount() <= ROW_LIMIT) { area.setRows(area.getLineCount()); }
            }
        });
		
		// return final result
		return scrollPane;
		
	} // end of function
	
	
	// create dynamic table with specified attributes
	private JScrollPane designTable(JTable table, int rowHeight, Dimension size) {
		
		// define pane to allow scrolling
		JScrollPane scrollPane = designScrollPane(table, size);
		
		// disable modifications to table
		table.getTableHeader().setReorderingAllowed(false); table.setEnabled(false);
		table.getTableHeader().setResizingAllowed(false);
		
		// set font and center text
		Font font = new Font("Times New Roman", Font.PLAIN, 24); table.setFont(font);
		DefaultTableCellRenderer centerText = new DefaultTableCellRenderer();
		centerText.setHorizontalAlignment(SwingConstants.CENTER); table.setDefaultRenderer(Object.class, centerText);
		
		// set dimensions and sizes
		table.setRowHeight(rowHeight); table.setPreferredScrollableViewportSize(size);
		
		// set table colours
		table.getTableHeader().setBackground(main); table.setBackground(main);
		
		// return final result
		return scrollPane;
		
	} // end of function
	
	
	// create scroll pane with specified attributes
	private JScrollPane designScrollPane(JComponent component, Dimension size) {
		
		// define pane to allow scrolling
		JScrollPane scrollPane = new JScrollPane(component);
		
		// set dimension and pane colour
		scrollPane.setMaximumSize(size); scrollPane.setBackground(main);
		
		// set scroll bar colours
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {

			@Override
			protected void configureScrollBarColors() {

				// set scroll track colour
				this.trackColor = main; this.trackHighlightColor = border;

				// set scroll bar colour
				this.thumbColor = main; this.thumbHighlightColor = border;
			}

			@Override
			protected JButton createIncreaseButton(int orientation) {

				// set upwards scroll button and colour
				JButton upButton = super.createIncreaseButton(orientation);
				upButton.setBackground(main); return upButton;
			}

			@Override
			protected JButton createDecreaseButton(int orientation) {

				// set downwards scroll button and colour
				JButton downButton = super.createDecreaseButton(orientation);
				downButton.setBackground(main); return downButton;
			}
		});
		
		// return final result
		return scrollPane;
	}
	
	
	// table format model
	private class TableModel extends DefaultTableModel {
		
		// define model constructor and add data columns
		public TableModel(String[] columnNames, Object[][] data) {

			for (int i = 0; i < data.length; i++) { this.addColumn(columnNames[i], data[i]); }
		}
		
		// disable cell editing
		@Override
		public boolean isCellEditable(int row, int column) { return false; }
	}
	 
	
	// button click event detector
	private class ButtonClickListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			// define button event
			String command = e.getActionCommand();
			
			// user clicks transliterate
			if (command.equals("engToAr")) { layer.show(display.getContentPane(), "engToArPage"); }
			
			// user clicks alphabetical conversions
			else if (command.equals("alphaListBtn")) { layer.show(display.getContentPane(), "alphaPage"); }
			
			// user clicks numerical conversions
			else if (command.equals("numListBtn")) { layer.show(display.getContentPane(), "numPage"); }
			
			// user clicks quit program
			else if (command.equals("quit")) {
				
				// show quit page briefly
				layer.show(display.getContentPane(), "quitPage");
				
				// create timer for 500 milliseconds
				Timer timer = new Timer(500, new ActionListener() {
					
					public void actionPerformed(ActionEvent e) { System.exit(0); }
				});
				
				// set to only occur once
				timer.setRepeats(false); timer.start();
			}
			
			// display menu page on default
			else { layer.show(display.getContentPane(), "menu"); }
			
		} // end of function
	}
	
} // end of class
