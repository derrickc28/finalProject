import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

public class GUI implements ActionListener
{

    private JTextArea manhwaInfo;
    private JFrame frame;
    JTabbedPane tabbedPane;
    JPanel logoWelcomePanel;
    JSplitPane splitPane;
    JPanel lastPanel;
    JPanel panelPanel;



    public GUI()
    {
        tabbedPane = new JTabbedPane();
        manhwaInfo = new JTextArea(30, 40);
        setupGui();
    }

    public void setupGui()
    {
        frame = new JFrame("Manhwa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800,1030));
        //logo
        ImageIcon image = new ImageIcon("src/logo.jpg");
        Image imageData = image.getImage(); // transform it
        Image scaledImage = imageData.getScaledInstance(200, 80, Image.SCALE_SMOOTH); // scale it the smooth way
        image = new ImageIcon(scaledImage);  // transform it back
        JLabel pictureLabel = new JLabel(image);
        //cover
        ImageIcon cover = new ImageIcon("src/cover.jpg");
        Image coverData = cover.getImage();
        Image scaledCover = coverData.getScaledInstance(250, 375, Image.SCALE_SMOOTH);
        cover = new ImageIcon(scaledCover);
        JLabel coverLabel = new JLabel(cover);
        JPanel coverPanel = new JPanel();
        coverPanel.add(coverLabel);
        //info
        JPanel info = new JPanel();
        manhwaInfo.setText("Title: Solo Leveling" + "\n" + "Author: Chugong" + "\n" +  "\n" + "10 years ago, after “the Gate” that connected the real world with the monster world opened, some of the ordinary, everyday people received the power to hunt monsters within the Gate. They are known as “Hunters”. However, not all Hunters are powerful. My name is Sung Jin-Woo, an E-rank Hunter. I’m someone who has to risk his life in the lowliest of dungeons, the “World’s Weakest”. Having no skills whatsoever to display, I barely earned the required money by fighting in low-leveled dungeons… at least until I found a hidden dungeon with the hardest difficulty within the D-rank dungeons! In the end, as I was accepting death, I suddenly received a strange power, a quest log that only I could see, a secret to leveling up that only I know about! If I trained in accordance with my quests and hunted monsters, my level would rise. Changing from the weakest Hunter to the strongest S-rank Hunter!");
        manhwaInfo.setFont(new Font("Helvetica", Font.PLAIN, 16));
        manhwaInfo.setWrapStyleWord(true);
        manhwaInfo.setLineWrap(true);
        info.add(manhwaInfo);
        //add splitpane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, coverPanel, info);
        logoWelcomePanel = new JPanel(); // the panel is not visible in output
        logoWelcomePanel.add(pictureLabel);
        JComponent component = splitPane;
        tabbedPane.addTab("Tab 1", component);

        //button
        lastPanel = new JPanel();
        JLabel buttonLabel = new JLabel("Chapter 1");
        JButton chapterButton = new JButton();
        chapterButton.setHorizontalTextPosition(SwingConstants.CENTER);
        chapterButton.add(buttonLabel);
        lastPanel.add(chapterButton);

        //chapter 1.1
        panelPanel = new JPanel();
        panelPanel.setLayout(new BoxLayout(panelPanel, BoxLayout.PAGE_AXIS));
        ImageIcon panel1 = new ImageIcon("src/Chapter1.1.jpg");
        Image panelData = panel1.getImage();
        Image scaledPanel = panelData.getScaledInstance(700, 8000, Image.SCALE_SMOOTH);
        panel1 = new ImageIcon(scaledPanel);
        JLabel panelLabel = new JLabel(panel1);
        panelPanel.add(panelLabel);

        //chapter 1.2
        ImageIcon panel2 = new ImageIcon("src/Chapter1.2.jpg");
        Image panelData2 = panel2.getImage();
        Image scaledPanel2 = panelData2.getScaledInstance(700, 11000, Image.SCALE_SMOOTH);
        panel2 = new ImageIcon(scaledPanel2);
        JLabel panelLabel2 = new JLabel(panel2);
        panelPanel.add(panelLabel2);
        //chapter 1.3
        ImageIcon panel3 = new ImageIcon("src/Chapter1.3.jpg");
        Image panelData3 = panel3.getImage();
        Image scaledPanel3 = panelData3.getScaledInstance(700, 11000, Image.SCALE_SMOOTH);
        panel3 = new ImageIcon(scaledPanel3);
        JLabel panelLabel3 = new JLabel(panel3);
        panelPanel.add(panelLabel3);

        //Chapter Panel
        JScrollPane scrollPane = new JScrollPane(panelPanel);
        scrollPane.setPreferredSize(new Dimension(100, 500));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JComponent component2 = scrollPane;
        tabbedPane.addTab("Tab 2", component2);


        frame.add(logoWelcomePanel, BorderLayout.NORTH);
        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.add(lastPanel, BorderLayout.SOUTH);

        chapterButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton) (e.getSource());
        System.out.println("Hello");
        String text = button.getText();
        if(text.equals("Chapter 1"))
        {
            tabbedPane.getComponentAt(1).setVisible(true);


        }
    }


}
