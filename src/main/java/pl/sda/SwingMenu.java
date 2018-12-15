package pl.sda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class SwingMenu {
    private JPanel MyFrame;
    final JFileChooser fc = new JFileChooser();
    public static void main(String[] args) {

        JFrame frame = new JFrame("SwingMenu");
        frame.setContentPane(new SwingMenu().MyFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //addMenu(frame);
        addMenu2(frame);
        frame.pack();
        frame.setVisible(true);
    }

    private static void addMenu2 (JFrame frame) {
        JMenuBar menuBar = new JMenuBar();


        JMenu fileMenu = new JMenu ("FIle");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fc = new JFileChooser();
                //Handle open button action.

                    int returnVal = fc.showOpenDialog(null);


                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fc.getSelectedFile();
                        //This is where a real application would open the file.
                        log.append("Opening: " + file.getName() + ".");
                    } else {
                        log.append("Open command cancelled by user.");
                    }
                }
        });

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        JMenu searchMenu = new JMenu("Search");
        menuBar.add(searchMenu);

        frame.setJMenuBar(menuBar);

    }
    private static void addMenu (JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

//Build the first menu.
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

//a group of JMenuItems
        menuItem = new JMenuItem("A text-only menu item",
                KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Both text and icon",
                new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);

//a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

//a group of check box menu items
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

//a submenu
        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        menu.add(submenu);

//Build second menu in the menu bar.
        menu = new JMenu("Another Menu");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);

//...
//        frame.setJMenuBar(theJMenuBar);
        // utworzyć 2 obiekty JMenu
        //utworzyć obiekty JMenuItem i powiązać je z JMenu

        //powiązać JMenu z JMenuBar
        frame.setJMenuBar(menuBar);
    }

}
