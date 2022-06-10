import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

public class GUI
{

    private JTextArea manhwaInfo;
    private JFrame frame;
    JTabbedPane tabbedPane;
    JPanel logoWelcomePanel;
    JSplitPane splitPane;
    JSplitPane splitPane0;
    JPanel lastPanel;
    JPanel panelPanel;
    JPanel chapterTwoPanel;



    public GUI()
    {
        tabbedPane = new JTabbedPane();
        manhwaInfo = new JTextArea(20, 40);
        setupGui();
    }

    public void setupGui()
    {
        frame = new JFrame("Manhwa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800,1050));
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
        manhwaInfo.setText("Title: Solo Leveling" + "\n" + "Author: Chugong" + "\n" + "status: Complete" + "\n" + "Description: " + "\n" + "\n" + "10 years ago, after “the Gate” that connected the real world with the monster world opened, some of the ordinary, everyday people received the power to hunt monsters within the Gate. They are known as “Hunters”. However, not all Hunters are powerful. My name is Sung Jin-Woo, an E-rank Hunter. I’m someone who has to risk his life in the lowliest of dungeons, the “World’s Weakest”. Having no skills whatsoever to display, I barely earned the required money by fighting in low-leveled dungeons… at least until I found a hidden dungeon with the hardest difficulty within the D-rank dungeons! In the end, as I was accepting death, I suddenly received a strange power, a quest log that only I could see, a secret to leveling up that only I know about! If I trained in accordance with my quests and hunted monsters, my level would rise. Changing from the weakest Hunter to the strongest S-rank Hunter!");
        manhwaInfo.setFont(new Font("Helvetica", Font.PLAIN, 16));
        manhwaInfo.setWrapStyleWord(true);
        manhwaInfo.setLineWrap(true);
        info.add(manhwaInfo, BorderLayout.NORTH);
        //button
        lastPanel = new JPanel();
        JLabel buttonLabel = new JLabel("Chapter 1");
        JButton chapterButton = new JButton();
        chapterButton.setHorizontalTextPosition(SwingConstants.CENTER);
        chapterButton.add(buttonLabel);
        lastPanel.add(chapterButton);
        JLabel buttonLabel2 = new JLabel("Chapter 2");
        JButton chapterButton2 = new JButton();
        chapterButton2.setHorizontalTextPosition(SwingConstants.CENTER);
        chapterButton2.add(buttonLabel2);
        lastPanel.add(chapterButton2);


        //add splitpane
        splitPane0 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, info, lastPanel);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, coverPanel, splitPane0);
        logoWelcomePanel = new JPanel(); // the panel is not visible in output
        logoWelcomePanel.add(pictureLabel);
        tabbedPane.addTab("Menu", splitPane);



        //Close Tab
        tabbedPane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    int index = tabbedPane.getSelectedIndex();
                    if(index > 0) {
                        JPopupMenu popupMenu = new JPopupMenu();
                        JMenuItem close = new JMenuItem("Close");
                        close.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                tabbedPane.remove(index);
                            }
                        });
                        popupMenu.add(close);
                        popupMenu.show(frame, e.getX() + 15, e.getY() + 90);
                    }
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });



        frame.add(logoWelcomePanel, BorderLayout.NORTH);
        frame.add(tabbedPane, BorderLayout.CENTER);

        chapterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.addTab("Chapter 1", getChapterOneInfo());
            }
        });

        chapterButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.addTab("Chapter 2", getChapterTwoInfo());
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public JComponent getChapterOneInfo()
    {
        //chapter 1.1
        panelPanel = new JPanel();
        panelPanel.setLayout(new BoxLayout(panelPanel, BoxLayout.PAGE_AXIS));
        ImageIcon panel1 = new ImageIcon("src/Chapter1.1.jpg");
        Image panelData = panel1.getImage();
        Image scaledPanel = panelData.getScaledInstance(720, 8000, Image.SCALE_SMOOTH);
        panel1 = new ImageIcon(scaledPanel);
        JLabel panelLabel = new JLabel(panel1);
        panelPanel.add(panelLabel);
        panelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //chapter 1.1
        ImageIcon panel15 = new ImageIcon("src/Chapter1.15.jpg");
        Image panelData15 = panel15.getImage();
        Image scaledPanel15 = panelData15.getScaledInstance(700, 8000, Image.SCALE_SMOOTH);
        panel1 = new ImageIcon(scaledPanel15);
        JLabel panelLabel15 = new JLabel(panel15);
        panelPanel.add(panelLabel15);
        //chapter 1.2
        ImageIcon panel2 = new ImageIcon("src/Chapter1.2.jpg");
        Image panelData2 = panel2.getImage();
        Image scaledPanel2 = panelData2.getScaledInstance(720, 11000, Image.SCALE_SMOOTH);
        panel2 = new ImageIcon(scaledPanel2);
        JLabel panelLabel2 = new JLabel(panel2);
        panelPanel.add(panelLabel2);
        //chapter 1.3
        ImageIcon panel3 = new ImageIcon("src/Chapter1.3.jpg");
        Image panelData3 = panel3.getImage();
        Image scaledPanel3 = panelData3.getScaledInstance(720, 11000, Image.SCALE_SMOOTH);
        panel3 = new ImageIcon(scaledPanel3);
        JLabel panelLabel3 = new JLabel(panel3);
        panelPanel.add(panelLabel3);
        //chapter 1.4
        ImageIcon panel4 = new ImageIcon("src/Chapter1.4.jpg");
        Image panelData4 = panel4.getImage();
        Image scaledPanel4 = panelData4.getScaledInstance(720, 10000, Image.SCALE_SMOOTH);
        panel4 = new ImageIcon(scaledPanel4);
        JLabel panelLabel4 = new JLabel(panel4);
        panelPanel.add(panelLabel4);
        //chapter 1.4
        ImageIcon panel5 = new ImageIcon("src/Chapter1.5.jpg");
        Image panelData5 = panel5.getImage();
        Image scaledPanel5 = panelData5.getScaledInstance(720, 5000, Image.SCALE_SMOOTH);
        panel5 = new ImageIcon(scaledPanel5);
        JLabel panelLabel5 = new JLabel(panel5);
        panelPanel.add(panelLabel5);
        //Next Button
        JLabel buttonLabel = new JLabel("Next");
        JButton nextButton = new JButton();
        nextButton.setHorizontalTextPosition(SwingConstants.CENTER);
        nextButton.add(buttonLabel);
        panelPanel.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tabbedPane.getSelectedIndex();
                tabbedPane.addTab("Chapter 2", getChapterTwoInfo());
                tabbedPane.remove(index);
            }
        });


        //Chapter Panel
        JScrollPane scrollPane = new JScrollPane(panelPanel);
        scrollPane.setPreferredSize(new Dimension(50, 500));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JComponent component2 = scrollPane;

        return component2;
    }

    public JComponent getChapterTwoInfo()
    {
        //chapter 2.1
        chapterTwoPanel = new JPanel();
        chapterTwoPanel.setLayout(new BoxLayout(chapterTwoPanel, BoxLayout.PAGE_AXIS));
        ImageIcon panelChapter2 = new ImageIcon("src/Chapter2.1.jpg");
        Image panelDataChapter2 = panelChapter2.getImage();
        Image scaledPanelChapter2 = panelDataChapter2.getScaledInstance(720, 4500, Image.SCALE_SMOOTH);
        panelChapter2 = new ImageIcon(scaledPanelChapter2);
        JLabel panelLabelChapter2 = new JLabel(panelChapter2);
        chapterTwoPanel.add(panelLabelChapter2);
        //chapter 2.2
        ImageIcon panelChapter22 = new ImageIcon("src/Chapter2.2.jpg");
        Image panelDataChapter22 = panelChapter22.getImage();
        Image scaledPanelChapter22 = panelDataChapter22.getScaledInstance(720, 4500, Image.SCALE_SMOOTH);
        panelChapter22 = new ImageIcon(scaledPanelChapter22);
        JLabel panelLabelChapter22 = new JLabel(panelChapter22);
        chapterTwoPanel.add(panelLabelChapter22);
        //chapter 2.3
        ImageIcon panelChapter23 = new ImageIcon("src/Chapter2.3.jpg");
        Image panelDataChapter23 = panelChapter23.getImage();
        Image scaledPanelChapter23 = panelDataChapter23.getScaledInstance(720, 4500, Image.SCALE_SMOOTH);
        panelChapter23 = new ImageIcon(scaledPanelChapter23);
        JLabel panelLabelChapter23 = new JLabel(panelChapter23);
        chapterTwoPanel.add(panelLabelChapter23);
        //Chapter 2.4
        ImageIcon panelChapter24 = new ImageIcon("src/Chapter2.4.jpg");
        Image panelDataChapter24 = panelChapter24.getImage();
        Image scaledPanelChapter24 = panelDataChapter24.getScaledInstance(720, 4500, Image.SCALE_SMOOTH);
        panelChapter24 = new ImageIcon(scaledPanelChapter24);
        JLabel panelLabelChapter24 = new JLabel(panelChapter24);
        chapterTwoPanel.add(panelLabelChapter24);
        //Chapter 2.5
        ImageIcon panelChapter25 = new ImageIcon("src/Chapter2.5.jpg");
        Image panelDataChapter25 = panelChapter25.getImage();
        Image scaledPanelChapter25 = panelDataChapter25.getScaledInstance(720, 4500, Image.SCALE_SMOOTH);
        panelChapter25 = new ImageIcon(scaledPanelChapter25);
        JLabel panelLabelChapter25 = new JLabel(panelChapter25);
        chapterTwoPanel.add(panelLabelChapter25);
        //Chapter 2.6
        ImageIcon panelChapter26 = new ImageIcon("src/Chapter2.6.jpg");
        Image panelDataChapter26 = panelChapter26.getImage();
        Image scaledPanelChapter26 = panelDataChapter26.getScaledInstance(720, 4500, Image.SCALE_SMOOTH);
        panelChapter26 = new ImageIcon(scaledPanelChapter26);
        JLabel panelLabelChapter26 = new JLabel(panelChapter26);
        chapterTwoPanel.add(panelLabelChapter26);
        //Chapter 2.7
        ImageIcon panelChapter27 = new ImageIcon("src/Chapter2.7.jpg");
        Image panelDataChapter27 = panelChapter27.getImage();
        Image scaledPanelChapter27 = panelDataChapter27.getScaledInstance(720, 4500, Image.SCALE_SMOOTH);
        panelChapter27 = new ImageIcon(scaledPanelChapter27);
        JLabel panelLabelChapter27 = new JLabel(panelChapter27);
        chapterTwoPanel.add(panelLabelChapter27);
        //Chapter 2.8
        ImageIcon panelChapter28 = new ImageIcon("src/Chapter2.8.jpg");
        Image panelDataChapter28 = panelChapter28.getImage();
        Image scaledPanelChapter28 = panelDataChapter28.getScaledInstance(720, 4500, Image.SCALE_SMOOTH);
        panelChapter28 = new ImageIcon(scaledPanelChapter28);
        JLabel panelLabelChapter28 = new JLabel(panelChapter28);
        chapterTwoPanel.add(panelLabelChapter28);
        //Chapter 2.9
        ImageIcon panelChapter29 = new ImageIcon("src/Chapter2.9.jpg");
        Image panelDataChapter29 = panelChapter29.getImage();
        Image scaledPanelChapter29 = panelDataChapter29.getScaledInstance(720, 4500, Image.SCALE_SMOOTH);
        panelChapter29 = new ImageIcon(scaledPanelChapter29);
        JLabel panelLabelChapter29 = new JLabel(panelChapter29);
        chapterTwoPanel.add(panelLabelChapter29);
        //Chapter 2.10
        ImageIcon panelChapter210 = new ImageIcon("src/Chapter2.10.jpg");
        Image panelDataChapter210 = panelChapter210.getImage();
        Image scaledPanelChapter210 = panelDataChapter210.getScaledInstance(720, 5000, Image.SCALE_SMOOTH);
        panelChapter210 = new ImageIcon(scaledPanelChapter210);
        JLabel panelLabelChapter210 = new JLabel(panelChapter210);
        chapterTwoPanel.add(panelLabelChapter210);
        //Chapter 2.11
        ImageIcon panelChapter211 = new ImageIcon("src/Chapter2.11.jpg");
        Image panelDataChapter211 = panelChapter211.getImage();
        Image scaledPanelChapter211 = panelDataChapter211.getScaledInstance(720, 5000, Image.SCALE_SMOOTH);
        panelChapter211 = new ImageIcon(scaledPanelChapter211);
        JLabel panelLabelChapter211 = new JLabel(panelChapter211);
        chapterTwoPanel.add(panelLabelChapter211);

        //Back Button
        JLabel buttonLabel = new JLabel("Back");
        JButton backButton = new JButton();
        backButton.setHorizontalTextPosition(SwingConstants.CENTER);
        backButton.add(buttonLabel);
        chapterTwoPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tabbedPane.getSelectedIndex();
                tabbedPane.addTab("Chapter 1", getChapterOneInfo());
                tabbedPane.remove(index);
            }
        });


        JScrollPane scrollPane2 = new JScrollPane(chapterTwoPanel);
        scrollPane2.setPreferredSize(new Dimension(50, 500));
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JComponent component3 = scrollPane2;

        return component3;
    }




}
