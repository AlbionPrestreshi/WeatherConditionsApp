import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import jdk.jfr.internal.tool.Main;
import org.weather.db.MainDB;
import org.tick.weather.model.Main;
import org.tick.weather.model.Weather;
import org.tick.weather.model.WeatherData;
import org.tick.weather.net.WeatherDataProvider;

public class CurrentWeatherFrame extends JFrame {

    private JPanel contentPane;
    private WeatherDataProvider dataProvider;
    private WeatherData weatherData;
    private JTextField txtQyteti;
    private JLabel valueTemperature;
    private JLabel valuePressure;
    private JLabel valueHumidity;
    private JLabel valueTempMin;
    private JLabel valueTemMax;
    private JLabel valueSeaLevel;
    private JLabel valueGroundLevel;
    private JProgressBar progressBar;
    private JLabel lblIcon;
    private JLabel lblC;
    private JLabel lblMb;
    private JLabel label;
    private JLabel lblC_1;
    private JLabel lblC_2;
    private JLabel lblHpa;
    private JLabel lblHpa_1;

    public CurrentWeatherFrame(WeatherDataProvider data) {

        this.dataProvider = data;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 580, 299);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel lblQyteti = new JLabel("Qyteti:");
        GridBagConstraints gbc_lblQyteti = new GridBagConstraints();
        gbc_lblQyteti.insets = new Insets(0, 0, 5, 5);
        gbc_lblQyteti.anchor = GridBagConstraints.EAST;
        gbc_lblQyteti.gridx = 0;
        gbc_lblQyteti.gridy = 0;
        contentPane.add(lblQyteti, gbc_lblQyteti);

        txtQyteti = new JTextField();
        GridBagConstraints gbc_txtQyteti = new GridBagConstraints();
        gbc_txtQyteti.insets = new Insets(0, 0, 5, 0);
        gbc_txtQyteti.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtQyteti.gridx = 1;
        gbc_txtQyteti.gridy = 0;
        contentPane.add(txtQyteti, gbc_txtQyteti);
        txtQyteti.setColumns(10);

        JButton btnGetData = new JButton("Get Data");
        btnGetData.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                progressBar.setVisible(true);
                new GetCurrentWeather().execute();
            }

        });
        GridBagConstraints gbc_btnGetData = new GridBagConstraints();
        gbc_btnGetData.insets = new Insets(0, 0, 5, 0);
        gbc_btnGetData.anchor = GridBagConstraints.WEST;
        gbc_btnGetData.gridx = 1;
        gbc_btnGetData.gridy = 1;
        contentPane.add(btnGetData, gbc_btnGetData);
        JLabel lblTeDhenatKryesore = new JLabel("Te dhenat kryesore");
        GridBagConstraints gbc_lblTeDhenatKryesore = new GridBagConstraints();
        gbc_lblTeDhenatKryesore.insets = new Insets(0, 0, 5, 0);
        gbc_lblTeDhenatKryesore.gridx = 1;
        gbc_lblTeDhenatKryesore.gridy = 3;
        contentPane.add(lblTeDhenatKryesore, gbc_lblTeDhenatKryesore);

        lblIcon = new JLabel(" ");
        GridBagConstraints gbc_lblIcon = new GridBagConstraints();
        gbc_lblIcon.insets = new Insets(0, 0, 5, 0);
        gbc_lblIcon.gridx = 1;
        gbc_lblIcon.gridy = 4;
        contentPane.add(lblIcon, gbc_lblIcon);

        JPanel pnlMain = new JPanel();
        GridBagConstraints gbc_pnlMain = new GridBagConstraints();
        gbc_pnlMain.insets = new Insets(0, 0, 5, 0);
        gbc_pnlMain.fill = GridBagConstraints.BOTH;
        gbc_pnlMain.gridx = 1;
        gbc_pnlMain.gridy = 5;
        contentPane.add(pnlMain, gbc_pnlMain);
        pnlMain.setLayout(new GridLayout(0, 3, 0, 0));

        JLabel lblNewLabel = new JLabel("Temperatura:");
        pnlMain.add(lblNewLabel);

        valueTemperature = new JLabel();
        pnlMain.add(valueTemperature);

        lblC = new JLabel("C");
        pnlMain.add(lblC);

        JLabel lblPressure = new JLabel("Shtypja");
        pnlMain.add(lblPressure);

        valuePressure = new JLabel();
        pnlMain.add(valuePressure);
        lblMb = new JLabel("Mb");
        pnlMain.add(lblMb);

        JLabel lblLHumidity = new JLabel("Lageshtia:");
        pnlMain.add(lblLHumidity);

        valueHumidity = new JLabel();
        pnlMain.add(valueHumidity);

        label = new JLabel("%");
        pnlMain.add(label);

        JLabel lblTemMax = new JLabel("Temperatura maxmimale:");
        pnlMain.add(lblTemMax);

        valueTemMax = new JLabel();
        pnlMain.add(valueTemMax);

        lblC_1 = new JLabel("C");
        pnlMain.add(lblC_1);

        JLabel lblTemMin = new JLabel("Temperatura minimale:");
        pnlMain.add(lblTemMin);

        valueTempMin = new JLabel();
        pnlMain.add(valueTempMin);

        lblC_2 = new JLabel("C");
        pnlMain.add(lblC_2);

        JLabel lblSeaLevel = new JLabel("Sea Level:");
        pnlMain.add(lblSeaLevel);

        valueSeaLevel = new JLabel();
        pnlMain.add(valueSeaLevel);
        lblHpa = new JLabel("hPA");
        pnlMain.add(lblHpa);

        JLabel lblGroundLevel = new JLabel("Ground Level:");
        pnlMain.add(lblGroundLevel);

        valueGroundLevel = new JLabel();
        pnlMain.add(valueGroundLevel);

        lblHpa_1 = new JLabel("hPA");
        pnlMain.add(lblHpa_1);

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setVisible(false);
        progressBar.setStringPainted(true);
        progressBar.setString("Duke marre shenimet...");

        GridBagConstraints gbc_progressBar = new GridBagConstraints();
        gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
        gbc_progressBar.gridx = 1;
        gbc_progressBar.gridy = 6;
        contentPane.add(progressBar, gbc_progressBar);

    }

    private class GetCurrentWeather extends SwingWorker<Void, Void> {
        ImageIcon icon;

        @Override
        protected Void doInBackground() throws Exception {

            try {
                String qyteti = txtQyteti.getText();
                weatherData = dataProvider.getCurrentWeather(qyteti);
                Weather cw = weatherData.getWeather().get(0);
                String iconURL = "http://openweathermap.org/img/w/" + cw.getIcon() +

                        ".png";
                URL imgURL = new URL(iconURL);
                icon = new ImageIcon(ImageIO.read(imgURL));
                MainDB.save(weatherData.getMain());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void done() {

            updateUI();

            progressBar.setVisible(false);

            lblIcon.setIcon(icon);
        }

    }

    public void updateUI() {

        if (weatherData != null) {
            Main main = weatherData.getMain();
            valueTemperature.setText("" + main.getTemp());
            valuePressure.setText("" + main.getPressure());
            valueHumidity.setText("" + main.getHumidity());
            valueTempMin.setText("" + main.getTempMin());
            valueTemMax.setText("" + main.getTempMax());
            valueSeaLevel.setText("" + main.getSeaLevel());
            valueGroundLevel.setText("" + main.getGrndLevel());

        }

    }

}