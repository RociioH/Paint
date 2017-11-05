import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class VentanaD {
    
private JPanel panelFiguras, panelJava2D, panelNorte;

    private PanelDibujo panelDibujo;

    //componentes de panelFiguras 
    private JButton botonUndoJButton, botonClearJButton;
    private JComboBox coloresJComboBox, tipoFiguraJComboBox;
    private JCheckBox rellenoJCheckBox;
    private JButton color1Java2DJButton;
    private static final String[] nombresFiguras = {"Lineas", "Ovalos", "Rectangulos"};

    //constructor
    public VentanaD() {
        super("Paint");

        JLabel barraEdo = new JLabel();
        panelDibujo = new PanelDibujo(barraEdo);

        panelNorte = new JPanel();
        panelNorte.setLayout(new GridLayout(2, 1));

        /////////////////PANEL FIGURAS ///////////////////////////////////////////////
        panelFiguras = new JPanel();
        panelFiguras.setLayout(new FlowLayout());

        botonUndoJButton = new JButton("DESHACER");
        botonUndoJButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                panelDibujo.borrarUltimaFigura();
            }

        });

        botonClearJButton = new JButton("BORRAR TODO");
        botonClearJButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                panelDibujo.borrarDibujo();
            }

        });

        tipoFiguraJComboBox = new JComboBox(nombresFiguras);
        tipoFiguraJComboBox.addItemListener(
                new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    panelDibujo.establecerTipoFigura(tipoFiguraJComboBox.getSelectedIndex());
                }

            }

        });

        rellenoJCheckBox = new JCheckBox("Filled");
   

        panelFiguras.add(botonUndoJButton);
        panelFiguras.add(botonClearJButton);

        panelFiguras.add(tipoFiguraJComboBox);
        panelFiguras.add(rellenoJCheckBox);

        panelNorte.add(panelFiguras);

        /////////////////PANEL JAVA2D ///////////////////////////////////////////////
        panelJava2D = new JPanel();
        panelJava2D.setLayout(new FlowLayout());

        color1Java2DJButton = new JButton("Color 1");
        color1Java2DJButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                panelDibujo.establecerColor1(JColorChooser.showDialog(MarcoDibujo.this, "Escoge el color 1", Color.BLACK));

            }

        });



    }//fin de constructor MarcoDibujo
}
