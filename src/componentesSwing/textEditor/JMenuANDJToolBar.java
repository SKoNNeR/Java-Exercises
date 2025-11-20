package componentesSwing.textEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class JMenuANDJToolBar {
	public static void main(String[] args) {
		MyFrame frame= new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("SKoNNeR - Text Editor");
		setBounds(500, 300, 700, 500);
		add(new MyLayer());
		setVisible(true);
	}
}

class MyLayer extends JPanel {
	private JMenuBar navBar;
	private JMenu font, style, size;
	private JMenuItem comicSans, dubai, inkFree, bold, italic, size12, size14, size16, size18, size20, size22, size24, size26;
	private JTextPane textPane;
	private JPanel north, west, center;
	private JScrollPane scrollPane;
	private JToolBar toolBar;
	private JButton buttonBold, buttonItalic, buttonUnderline, buttonBlue, buttonRed, buttonYellow, buttonLeft, buttonCenter, buttonRight, buttonJustify;
	
	public MyLayer() {
		
		setLayout(new BorderLayout());
		
		north= new JPanel();
		west= new JPanel();
		center= new JPanel();
		
		navBar= new JMenuBar();
		toolBar= new JToolBar(JToolBar.VERTICAL);
		
		
		textPane= new JTextPane();
		scrollPane= new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(650, 400));
		
		/* --------------------- JMenu Instances --------------------- */
		font= new JMenu("Fonts");
		style= new JMenu("Styles");
		size= new JMenu("Size");
		
		
		/* --------------------- JMenuItem Instances --------------------- */
		comicSans= new JMenuItem("Comic Sans MS");
		dubai= new JMenuItem("Dubai");
		inkFree= new JMenuItem("Ink Free");
		
		bold= new JMenuItem("Bold");
		italic= new JMenuItem("Italic");
		
		size12= new JMenuItem("12");
		size14= new JMenuItem("14");
		size16= new JMenuItem("16");
		size18= new JMenuItem("18");
		size20= new JMenuItem("20");
		size22= new JMenuItem("22");
		size24= new JMenuItem("24");
		size26= new JMenuItem("26");
		
		/* --------------------- ToolBar JButtons & Listeners --------------------- */
		buttonBold= new JButton(new ImageIcon(getClass().getResource("/componentesSwing/textEditor/bold-24.png")));
		buttonBold.addActionListener(new StyledEditorKit.BoldAction());
		buttonItalic= new JButton(new ImageIcon(getClass().getResource("/componentesSwing/textEditor/italic-24.png")));
		buttonItalic.addActionListener(new StyledEditorKit.ItalicAction());
		buttonUnderline= new JButton(new ImageIcon(getClass().getResource("/componentesSwing/textEditor/underline-24.png")));
		buttonUnderline.addActionListener(new StyledEditorKit.UnderlineAction());
		
		buttonRed= new JButton(new ImageIcon(getClass().getResource("/componentesSwing/textEditor/red.png")));
		buttonRed.addActionListener(new StyledEditorKit.ForegroundAction("color red", Color.RED));
		buttonBlue= new JButton(new ImageIcon(getClass().getResource("/componentesSwing/textEditor/blue.png")));
		buttonBlue.addActionListener(new StyledEditorKit.ForegroundAction("color blue", Color.BLUE));
		buttonYellow= new JButton(new ImageIcon(getClass().getResource("/componentesSwing/textEditor/yellow.png")));
		buttonYellow.addActionListener(new StyledEditorKit.ForegroundAction("color yellow", Color.YELLOW));
		
		buttonLeft= new JButton(new ImageIcon(getClass().getResource("/componentesSwing/textEditor/align-left-24.png")));
		buttonLeft.addActionListener(new StyledEditorKit.AlignmentAction(textPane.getSelectedText(), StyleConstants.ALIGN_LEFT));
		buttonCenter= new JButton(new ImageIcon(getClass().getResource("/componentesSwing/textEditor/align-center-24.png")));
		buttonCenter.addActionListener(new StyledEditorKit.AlignmentAction(textPane.getSelectedText(), StyleConstants.ALIGN_CENTER));
		buttonRight= new JButton(new ImageIcon(getClass().getResource("/componentesSwing/textEditor/align-right-24.png")));
		buttonRight.addActionListener(new StyledEditorKit.AlignmentAction(textPane.getSelectedText(), StyleConstants.ALIGN_RIGHT));
		buttonJustify= new JButton(new ImageIcon(getClass().getResource("/componentesSwing/textEditor/align-justify-24.png")));
		buttonJustify.addActionListener(new StyledEditorKit.AlignmentAction(textPane.getSelectedText(), StyleConstants.ALIGN_JUSTIFIED));

		
		/* --------------------- Listeners Here --------------------- */
		comicSans.addActionListener(new StyledEditorKit.FontFamilyAction(textPane.getSelectedText(), "Comic Sans MS"));
		dubai.addActionListener(new StyledEditorKit.FontFamilyAction(textPane.getSelectedText(), "Dubai"));
		inkFree.addActionListener(new StyledEditorKit.FontFamilyAction(textPane.getSelectedText(), "Ink Free"));
		
		bold.addActionListener(new StyledEditorKit.BoldAction());
		italic.addActionListener(new StyledEditorKit.ItalicAction());
		
		size12.addActionListener(new StyledEditorKit.FontSizeAction(textPane.getSelectedText(), 12));
		size14.addActionListener(new StyledEditorKit.FontSizeAction(textPane.getSelectedText(), 14));
		size16.addActionListener(new StyledEditorKit.FontSizeAction(textPane.getSelectedText(), 16));
		size18.addActionListener(new StyledEditorKit.FontSizeAction(textPane.getSelectedText(), 18));
		size20.addActionListener(new StyledEditorKit.FontSizeAction(textPane.getSelectedText(), 20));
		size22.addActionListener(new StyledEditorKit.FontSizeAction(textPane.getSelectedText(), 22));
		size24.addActionListener(new StyledEditorKit.FontSizeAction(textPane.getSelectedText(), 24));
		size26.addActionListener(new StyledEditorKit.FontSizeAction(textPane.getSelectedText(), 26));
		
		
		/* --------------------- Add to JToolBar --------------------- */
		toolBar.add(buttonBold);
		toolBar.add(buttonItalic);
		toolBar.add(buttonUnderline);
		toolBar.addSeparator();
		toolBar.add(buttonRed);
		toolBar.add(buttonBlue);
		toolBar.add(buttonYellow);
		toolBar.addSeparator();
		toolBar.add(buttonLeft);
		toolBar.add(buttonCenter);
		toolBar.add(buttonRight);
		toolBar.add(buttonJustify);
		
		/* --------------------- Add to JMenuBar --------------------- */
		navBar.add(font);
		navBar.add(style);
		navBar.add(size);

		/* --------------------- Add to JMenu --------------------- */
		font.add(comicSans);
		font.add(dubai);
		font.add(inkFree);

		style.add(bold);
		style.add(italic);
		
		size.add(size12);
		size.add(size14);
		size.add(size16);
		size.add(size18);
		size.add(size20);
		size.add(size22);
		size.add(size24);
		size.add(size26);

		/* --------------------- Add to Layer --------------------- */
		north.add(navBar);
		center.add(scrollPane);
		west.add(toolBar);
		
		add(north, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
	}
}