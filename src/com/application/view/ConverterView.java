package com.application.view;
 
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
 
import com.application.controller.ConverterController;
 
public class ConverterView extends JFrame implements ActionListener {
 
    private JLabel lblFrom, lblTo;
    private JTextField txtFrom, txtTo;
    private JButton btnConvert;
    private JRadioButton rdbCelsius, rdbFarenheit;
 
    private JPanel panTextBox, panRadio, panButton;
     
    private ConverterController controller;
     
    public ConverterView(ConverterController controller){
        super("Temperature Converter");
        this.controller = controller;
        this.setLayout(new GridLayout(3,1));
        this.initializeComponents();
        this.addComponentsToPanels();
        this.addPanelstoWindow();
        this.setWindowProperties();
        this.registerListeners();
    }
     
    /**
     * Initializes all components 
     */
    private void initializeComponents() {
        lblFrom = new JLabel("From");
        lblTo = new JLabel("To");
 
        txtFrom = new JTextField(10);
        txtTo = new JTextField(10);
         
        btnConvert = new JButton("Convert");
         
        rdbCelsius = new JRadioButton("Celsius");
        rdbCelsius.setSelected(true);
        rdbFarenheit = new JRadioButton("Fahrenheit");
         
        ButtonGroup group = new ButtonGroup();
        group.add(rdbCelsius);
        group.add(rdbFarenheit);
        
       
         
        panTextBox = new JPanel(new GridLayout(1,4));
        panRadio = new JPanel(new GridLayout(1,2));
        panButton = new JPanel(new GridLayout(1,2));
    }
     
    /**
     * Adds components to panels
     */
    private void addComponentsToPanels(){
        panTextBox.add(lblFrom);panTextBox.add(txtFrom);panTextBox.add(lblTo);panTextBox.add(txtTo);
        panRadio.add(rdbCelsius);panRadio.add(rdbFarenheit);
        panButton.add(btnConvert);
    }

     
    /**
     * Adds Panels to the window
     */
    private void addPanelstoWindow() {
        this.add(panTextBox);
        this.add(panRadio);
        this.add(panButton);
    }
 
    /**
     * Sets the default window properties
     */
    private void setWindowProperties() {
        this.setSize(1024,680);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
     
    /**
     * Registers all the listeners
     */
    private void registerListeners() {
        btnConvert.addActionListener(this);
    }
     
    public void updateResult(String value) {
        txtTo.setText(value);
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource().equals(btnConvert)){
            String to = "";
            if(rdbCelsius.isSelected()){
                to = "celsius";
            } else {
                to = "fahrenheit";
            }
            this.controller.convertTemp(to, txtFrom.getText());
        }
    }
}