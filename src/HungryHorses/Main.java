package HungryHorses;

import Modulos.Estados;
import Modulos.Minimax;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    private int filas = 8;
    private int columnas = 8;
    int k = 1;

    int[][] Matriz = new int[8][8];
    int nivel = 0, contador = 0, ax = 0, ay = 0;
    double puntosBlanco = 0.0, puntosNegro = 0.0;
    String txtJugadas = "";
    Point[] punt = null; //posiciones
    Estados raiz = Estados.crearEstadoInicial(filas);
    Estados Nuevo;

    //Iconos Tablero
    private PintarTablero tablero[][];
    private ImageIcon arregloDeImagenes[] = new ImageIcon[5];

    public Main() {

        super("Hungry Horses 1.0.");
        initComponents();

        //NIveles:
        comboDificultad.addItem("");
        comboDificultad.addItem("Principiante");
        comboDificultad.addItem("Amateur");
        comboDificultad.addItem("Experto");

        this.setVisible(true);
        this.setLocationRelativeTo(null);
        btnJugador2.setEnabled(false);

        //Imagenes Tablero

        arregloDeImagenes[0] = new ImageIcon(this.getClass().getResource("/imagenes/vacia.png"));
        arregloDeImagenes[1] = new ImageIcon(this.getClass().getResource("/imagenes/botonBlanco.png"));
        arregloDeImagenes[2] = new ImageIcon(this.getClass().getResource("/imagenes/botonNegro.png"));
        arregloDeImagenes[3] = new ImageIcon(this.getClass().getResource("/imagenes/cesped2.png"));
        arregloDeImagenes[4] = new ImageIcon(this.getClass().getResource("/imagenes/flor2.png"));

        tablero = new PintarTablero[filas][columnas];


        crearTablero(raiz.getTablero());
        btnJugador2.setEnabled(false);
    }

    public void crearTablero(int[][] matriz) {

        panelTablero.removeAll();
        panelTablero.setLayout(new GridLayout(filas, columnas));
        for (int x=0;x<filas;x++){
            for(int y=0; y<columnas;y++){

                tablero[x][y] = new PintarTablero();
                tablero[x][y].setIcon(retornarImagen(matriz[x][y]));
                tablero[x][y].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                tablero[x][y].setBorder(BorderFactory.createLineBorder(Color.black));

                panelTablero.add(tablero[x][y]);
            }
            panelTablero.updateUI();
        }

    }

    private Icon retornarImagen(int pos){

        switch(pos){
            case 0:
                return arregloDeImagenes[0];//vacio
            case 1:
                return arregloDeImagenes[1];//caballo blanco
            case 2:
                return arregloDeImagenes[2];//caballo negro
            case 3:
                return arregloDeImagenes[3];//Cesped
            case 4:
                return arregloDeImagenes[4];//Flores
            default:
                return arregloDeImagenes[0];//vacio;

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelPuntajeBlanco = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        panelTablero = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        comboDificultad = new javax.swing.JComboBox<>();
        btnJugador1 = new javax.swing.JButton();
        labelDificultad = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        l2 = new javax.swing.JLabel();
        campoFila = new javax.swing.JTextField();
        l1 = new javax.swing.JLabel();
        campoColumna = new javax.swing.JTextField();
        btnJugador2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jugadas = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        labelPuntajeNegro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hungry Horses");
        setBackground(new java.awt.Color(0, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(640, 601));
        setMinimumSize(new java.awt.Dimension(640, 601));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Puntaje Caballo Blanco: ");

        labelPuntajeBlanco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelPuntajeBlanco.setText("0");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonBlanco.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addGap(0, 16, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(jLabel3)
                                                .addGap(54, 54, 54)
                                                .addComponent(labelPuntajeBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                                .addComponent(jLabel3)
                                                .addContainerGap())
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(labelPuntajeBlanco)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "Tablero", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 500));

        panelTablero.setBackground(new java.awt.Color(255, 255, 255));
        panelTablero.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout panelTableroLayout = new javax.swing.GroupLayout(panelTablero);
        panelTablero.setLayout(panelTableroLayout);
        panelTableroLayout.setHorizontalGroup(
                panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        panelTableroLayout.setVerticalGroup(
                panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        comboDificultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDificultadActionPerformed(evt);
            }
        });

        btnJugador1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnJugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonBlanco.png"))); // NOI18N
        btnJugador1.setText("Jugador 1");
        btnJugador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugador1ActionPerformed(evt);
            }
        });

        labelDificultad.setText("Niveles:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(comboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(labelDificultad)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(btnJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(labelDificultad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        l2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l2.setText("Fila");

        l1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l1.setText("Columna");

        campoColumna.setText(" ");

        btnJugador2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnJugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonNegro.png"))); // NOI18N
        btnJugador2.setText("Jugador 2");
        btnJugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugador2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addComponent(l1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(l2)
                                                                .addGap(13, 13, 13)))
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(campoFila)
                                                        .addComponent(campoColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(btnJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l2)
                                        .addComponent(campoFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(l1)
                                        .addComponent(campoColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Posibles Jugadas:"));

        jugadas.setColumns(20);
        jugadas.setRows(5);
        jScrollPane1.setViewportView(jugadas);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botonNegro.png"))); // NOI18N

        labelPuntajeNegro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelPuntajeNegro.setText("0");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Puntaje Caballo Negro:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(jLabel9)
                                                .addGap(58, 58, 58)
                                                .addComponent(labelPuntajeNegro, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(labelPuntajeNegro))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 15, Short.MAX_VALUE)
                                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugador1ActionPerformed

        btnJugador1.setEnabled(false);
        if ((Double.parseDouble(labelPuntajeBlanco.getText()) + Double.parseDouble(labelPuntajeNegro.getText())) < 35) {
            campoFila.setText("");
            campoColumna.setText("");

            if (comboDificultad.getSelectedItem() == "Principiante") {        nivel = 2;    }
            else if (comboDificultad.getSelectedItem() == "Amateur") {        nivel = 4;    }
            else if (comboDificultad.getSelectedItem() == "Experto") {        nivel = 6;    }

            Minimax mov = new Minimax(raiz);
            mov.decisionMx(raiz, nivel);
            Point movida = mov.getMovida();
            Nuevo = raiz.resultado(movida);
            puntosBlanco = puntosBlanco + Nuevo.getPuntosBlanco();
            String puntosBlanco1 = Double.toString(puntosBlanco);
            labelPuntajeBlanco.setText(puntosBlanco1);

            crearTablero(Nuevo.getTablero());

            Minimax mov1 = new Minimax(Nuevo);
            punt = mov1.decisionMn(Nuevo, nivel);
            Point movida1 = mov1.getMovida();

            jugadas.append( "Jugada "+k+"\n"+"\n");
            for (int i = 0; i < punt.length; i++) {
                Point nuevop = punt[i];
                int ax = (int) nuevop.getX();
                int ay = (int) nuevop.getY();

                txtJugadas = "[" + ax + "," + ay + "]";
                jugadas.append("la jugadas son: " + txtJugadas + "\n");
            }
            jugadas.append("\n"+ "--------------------------------------------"+ "\n");
            k+=1;
        }
        else {
            jugadas.append("fin " + puntosBlanco + " ------- " + puntosNegro);

            String estadoJuego;
            if (puntosBlanco < puntosNegro) {
                estadoJuego = "Eres Grande, Ganastes!";
            } else {
                estadoJuego = "Sigue intentandolo, Perdiste!";
            }
            JOptionPane.showMessageDialog(null, "... Por fin termino! " + estadoJuego ,"REPORTE",
                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/estadoJuego.png"));
        }
        btnJugador2.setEnabled(true);
    }//GEN-LAST:event_btnJugador1ActionPerformed


    private void btnJugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugador2ActionPerformed

        btnJugador2.setEnabled(false);
        if ((Double.parseDouble(labelPuntajeBlanco.getText()) + Double.parseDouble(labelPuntajeNegro.getText())) < 35) {

            if ((campoFila.getText().length() == 0) || (campoColumna.getText().length() == 0)) {
                JOptionPane.showMessageDialog(null, "ingresar fila y columna para jugar");
            } else {
                String ex = campoFila.getText();
                String ey = campoColumna.getText();
                int entradax = Integer.parseInt(ex);
                int entraday = Integer.parseInt(ey);
                boolean val = false;

                for (int i = 0; i < punt.length; i++) {
                    Point nuevop = punt[i];
                    int axs = (int) nuevop.getX();
                    int ays = (int) nuevop.getY();

                    if ((entradax == axs) && (entraday == ays)) {
                        ax = axs;
                        ay = ays;
                        val = true;
                    }
                }

                if (val) {

                    Point movidanueva = new Point(ax, ay);
                    raiz = Nuevo.resultado(movidanueva);
                    if (raiz.getPuntosNegro() == 3) {
                        puntosNegro = puntosNegro + 3;
                    } else {
                        puntosNegro = puntosNegro + raiz.getPuntosNegro();
                    }

                    labelPuntajeNegro.setText(Double.toString(puntosNegro));
                    crearTablero(raiz.getTablero());
                    campoFila.setText("");
                    campoColumna.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Jugada no valida !No sea Bruto","ERROR",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/error.png"));
                }

            }
        } else {
            jugadas.append("MIlagro, Se acabo! " + puntosBlanco + " ------- " + puntosNegro);
            String estadoJuego;
            if (puntosBlanco < puntosNegro) {
                estadoJuego = "Eres Grande,Ganaste!";
            } else {
                estadoJuego = "Sigue Intendandolo, Perdiste! Malo!";
            }
            JOptionPane.showMessageDialog(null, "... por fin!!! " + estadoJuego , "REPORTE",
                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/reporte.png"));
        }

        btnJugador1.setEnabled(true);
    }//GEN-LAST:event_btnJugador2ActionPerformed

    private void comboDificultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDificultadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDificultadActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugador1;
    private javax.swing.JButton btnJugador2;
    private javax.swing.JTextField campoColumna;
    private javax.swing.JTextField campoFila;
    private javax.swing.JComboBox<String> comboDificultad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jugadas;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel labelDificultad;
    private javax.swing.JLabel labelPuntajeBlanco;
    private javax.swing.JLabel labelPuntajeNegro;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables


}
