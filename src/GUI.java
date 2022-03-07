import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;

public class GUI implements ActionListener {
    private JCheckBox checkbox, checkbox2, checkbox3;
    private JRadioButton radio1, radio2, radio3, radio4, radio5, radio6;
    private JTextField hours1, hours2, hours3, editingDayCount, coloringHourlyCount;
    private JButton button;
    private JPanel panel;
    private JLabel tekst, tekst2, tekst3, emptyText;
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        new GUI();
    }

    public GUI() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        JFrame frame = new JFrame("Pay Calculator");
        checkbox = new JCheckBox("Sony");
        checkbox.addActionListener(this);
        checkbox2 = new JCheckBox("BMPCC");
        checkbox3 = new JCheckBox("Droon");
        emptyText = new JLabel(" ");
        radio1 = new JRadioButton("1st day of Filming");
        hours1 = new JTextField("(Hours filmed)");
        radio2 = new JRadioButton("2nd day of Filming");
        hours2 = new JTextField("(Hours filmed)");
        radio3 = new JRadioButton("3rd day of Filming");
        hours3 = new JTextField("(Hours filmed)");
        editingDayCount = new JTextField("Editing Hours");
        coloringHourlyCount = new JTextField("NOT IMPLEMENTED!");
        button = new JButton("Calculate Pay!");
        button.addActionListener(this);
        tekst = new JLabel("Calculated Pay: ");
        tekst2 = new JLabel("Montaaz + Heli");
        tekst3 = new JLabel("Coloring (in Hours)");

        frame.setIconImage(new ImageIcon("RV_icon.png").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(8,2,8,8));
        panel.add(checkbox);
        panel.add(checkbox2);
        panel.add(checkbox3);
        panel.add(emptyText);
        panel.add(radio1);
        panel.add(hours1);
        panel.add(radio2);
        panel.add(hours2);
        panel.add(radio3);
        panel.add(hours3);
        panel.add(tekst2);
        panel.add(editingDayCount);
        panel.add(tekst3);
        panel.add(coloringHourlyCount);
        panel.add(button);
        panel.add(tekst);
        frame.setContentPane(panel);
        frame.pack();
        frame.setSize(300,600);
        frame.setLocation(1720, 720);
        frame.setVisible(true);
    }

    //AUDIO implementation method
    /*public static void SoundEffect(String filepath) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        File file = new File(filepath);
        AudioInputStream audio = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audio);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean rightPicks = false;
        boolean sonyCamera = false, bmpccCamera = false, drone = false;
        int firstDayFilmingHours = 0, secondDayFilmingHours = 0, thirdDayFilmingHours = 0;
        boolean oneDayEditing, twoDayEditing, threeDayEditing = false;
        int editingDays;
        try {
            editingDays = Integer.parseInt(editingDayCount.getText());
        } catch (Exception exception) {
            editingDays = 0;
        }
        if (e.getSource() == button) {
            if (!((checkbox.isSelected() || checkbox2.isSelected()) & (radio1.isSelected() || radio2.isSelected() || radio3.isSelected())) & editingDays == 0) {
                tekst.setText("Midagi jäi valimata!");
            } else {
                rightPicks = true;
            }
        }
        if (checkbox.isSelected()) {
            sonyCamera = true;
        }
        if (checkbox2.isSelected()) {
            bmpccCamera = true;
        }
        if (checkbox3.isSelected()) {
            drone = true;
        }
        HashMap<Integer, Integer> filmingDayAndHours = new HashMap<>();

        if (rightPicks) {
            if (radio1.isSelected()) {
                try {
                    firstDayFilmingHours = Integer.parseInt(hours1.getText());
                } catch (Exception exception) {
                    tekst.setText("TUNNID NUMBRITES!");
                }
                filmingDayAndHours.put(1, firstDayFilmingHours);
            }
            if (radio2.isSelected()) {
                try {
                    secondDayFilmingHours = Integer.parseInt(hours2.getText());
                } catch (Exception exception) {
                    tekst.setText("TUNNID NUMBRITES!");
                }
                filmingDayAndHours.put(2, secondDayFilmingHours);
            }
            if (radio3.isSelected()) {
                try {
                    thirdDayFilmingHours = Integer.parseInt(hours3.getText());
                } catch (Exception exception) {
                    tekst.setText("TUNNID NUMBRITES!");
                }
                filmingDayAndHours.put(3, thirdDayFilmingHours);
            }
            if (tekst.getText() == "TUNNID NUMBRITES!") {
            } else {
                if (filmingDayAndHours.size() > 0) {
                    Project projekt = new Project(filmingDayAndHours, sonyCamera, bmpccCamera, drone, editingDays);
                    Integer pay = projekt.calculatePay();
                    tekst.setText("Calculated Pay: " + pay + "€");
                } else {
                    Project projekt = new Project(editingDays);
                    Integer pay = projekt.calculateEditingPay();
                    tekst.setText("Calculated Pay: " + pay + "€");
                }
            }
        }
    }
}