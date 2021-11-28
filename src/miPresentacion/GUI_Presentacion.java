package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame
{
    //atributos
    private JButton miFoto, misHobby, misExpectativas;
    private Titulos titulo;
    private JPanel panelBotones, panelDatos;
    private Escucha escucha;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;
    private Font fuenteExpectativas;

    //métodos
    public GUI_Presentacion()
    {
        imitGUI();
        //configuración base de la ventana
        this.setTitle("Mi Presentación");
        this.setSize(600,540);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void imitGUI()
    {
        //Definir Container y Layout del JFrame
        //Crear objetos Escucha y Control
        escucha = new Escucha();
        //Configurar JComponents
        titulo = new Titulos("Hola soy Juan Esteban, oprime los botones:",Color.GRAY);
        this.add(titulo, BorderLayout.NORTH);

        miFoto = new JButton("Así me veo");
        miFoto.addMouseListener(escucha);
        miFoto.addKeyListener(escucha);
        miFoto.setFocusable(true);
        misHobby = new JButton("Este es mi Hobby");
        misHobby.addMouseListener(escucha);
        misHobby.addKeyListener(escucha);
        misHobby.setFocusable(true);
        misExpectativas = new JButton("Creo que...");
        //misExpectativas.addKeyListener(escucha);
        //misExpectativas.setFocusable(true);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(misHobby);
        //panelBotones.add(misExpectativas);
        panelBotones.addKeyListener(escucha);
        panelBotones.setFocusable(true);
        this.add(panelBotones, BorderLayout.SOUTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco mas de mi:", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Calibri",Font.PLAIN,20),Color.BLACK));

        this.add(panelDatos,BorderLayout.CENTER);

        labelImagen = new JLabel();

        textoExpectativas = new JTextArea(10,12);
        fuenteExpectativas = new Font("Calibri",Font.PLAIN,20);
        textoExpectativas.setFont(fuenteExpectativas);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    private class Escucha extends MouseAdapter implements KeyListener
    {
        private ImageIcon image;
        private Image imgOtroTamaño;
        private Icon imageNuevoTamaño;

        @Override
        public void mouseClicked(MouseEvent e)
        {
            panelDatos.removeAll();
            if(e.getSource()==miFoto)
            {
                image = new ImageIcon(getClass().getResource("/recursos/miFoto.jpeg"));
                imgOtroTamaño = image.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
                imageNuevoTamaño = new ImageIcon(imgOtroTamaño);
                labelImagen.setIcon(imageNuevoTamaño);
                panelDatos.add(labelImagen);
            }
            else if(e.getSource()==misHobby)
            {
                if(e.getClickCount()==2)
                {
                    image = new ImageIcon(getClass().getResource("/recursos/misHobby.jpg"));
                    imgOtroTamaño = image.getImage().getScaledInstance(550, 400, Image.SCALE_SMOOTH);
                    imageNuevoTamaño = new ImageIcon(imgOtroTamaño);
                    labelImagen.setIcon(imageNuevoTamaño);
                    panelDatos.add(labelImagen);
                }
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e)
        {

        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            panelDatos.removeAll();
            if(e.getSource()==miFoto)
            {
                if (e.VK_M == e.getKeyCode())
                {
                    textoExpectativas.setText("Una vez vi un poco de java pero fue solo lo básico, \n" +
                            "me encantaría poder aprender a usar este lenguaje \n" +
                            "tan interesante y con tanto potencial para \n" +
                            "fabricar programas. Tengo conocimiento de programación \n" +
                            "funcional y orientada a objetos.");
                    textoExpectativas.setBackground(null);
                    panelDatos.add(textoExpectativas);
                }
                revalidate();
                repaint();
            }
            else if(e.getSource()==misHobby)
            {
                if (e.VK_M == e.getKeyCode())
                {
                    textoExpectativas.setText("Una vez vi un poco de java pero fue solo lo básico, \n" +
                            "me encantaría poder aprender a usar este lenguaje \n" +
                            "tan interesante y con tanto potencial para \n" +
                            "fabricar programas. Tengo conocimiento de programación \n" +
                            "funcional y orientada a objetos.");
                    textoExpectativas.setBackground(null);
                    panelDatos.add(textoExpectativas);
                }
                revalidate();
                repaint();
            }
            else
            {
                if (e.VK_M == e.getKeyCode()) {
                    textoExpectativas.setText("Una vez vi un poco de java pero fue solo lo básico, \n" +
                            "me encantaría poder aprender a usar este lenguaje \n" +
                            "tan interesante y con tanto potencial para \n" +
                            "fabricar programas. Tengo conocimiento de programación \n" +
                            "funcional y orientada a objetos.");
                    textoExpectativas.setBackground(null);
                    panelDatos.add(textoExpectativas);
                }
                revalidate();
                repaint();
            }
        }

        @Override
        public void keyReleased(KeyEvent e)
        {

        }
    }
}