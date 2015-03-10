package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import util.HibernateHelper;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Interfaz {
	
	int idQuestion;
	String texto, categoria;
	
	public JFrame frame;
	HibernateHelper hiber = new HibernateHelper();
	private JTextField textPregunta;
	private JTextField textRespuesta1;
	private JTextField textRespuesta2;
	private JTextField textRespuesta3;
	private JTextField textRespuesta4;
	private JTextField textId;
	private JRadioButton rdbtnVerdadera1;
	private JRadioButton rdbtnVerdadera2;
	private JRadioButton rdbtnVerdadera3;
	private JRadioButton rdbtnVerdadera4;
	private JLabel lblCategoria;
	private JTextField textCategoria;
	Boolean solucion1,solucion2,solucion3,solucion4;
	private JButton btnBuscar;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnGuardar;
	/**
	 * Launch the application.
	 */
	public static void lanzarVentana() {
		HibernateHelper hibernateHelper = new HibernateHelper();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Variables
		
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnInsertar = new JMenu("Insertar");
		mnInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBorrar.setEnabled(false);
				btnBuscar.setEnabled(false);
				btnModificar.setEnabled(false);
				btnGuardar.setEnabled(true);
			}
		});
		menuBar.add(mnInsertar);
		
		JMenu mnBorrar = new JMenu("Borrar");
		mnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnGuardar.setEnabled(false);
				btnModificar.setEnabled(false);
				btnBorrar.setEnabled(true);
				btnBuscar.setEnabled(true);
			}
		});
		menuBar.add(mnBorrar);
		
		JMenu mnModificar = new JMenu("Modificar");
		mnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnModificar.setEnabled(true);
				btnBuscar.setEnabled(true);
				btnBorrar.setEnabled(false);
				btnGuardar.setEnabled(false);
			}
		});
		menuBar.add(mnModificar);
		
		JLabel lblPregunta = new JLabel("Pregunta:");
		
		textPregunta = new JTextField();
		textPregunta.setColumns(10);
		
		JLabel lblRespuesta = new JLabel("Respuesta 1:");
		
		textRespuesta1 = new JTextField();
		textRespuesta1.setColumns(10);
		
		JLabel lblRespuesta_1 = new JLabel("Respuesta 2:");
		
		textRespuesta2 = new JTextField();
		textRespuesta2.setColumns(10);
		
		rdbtnVerdadera1 = new JRadioButton("Verdadera");
		
		rdbtnVerdadera2 = new JRadioButton("Verdadera");
		
		JLabel lblRespuesta_2 = new JLabel("Respuesta 3:");
		
		textRespuesta3 = new JTextField();
		textRespuesta3.setColumns(10);
		
		rdbtnVerdadera3 = new JRadioButton("Verdadera");
		
		JLabel lblRespuesta_3 = new JLabel("Respuesta 4:");
		
		textRespuesta4 = new JTextField();
		textRespuesta4.setColumns(10);
		
		 rdbtnVerdadera4 = new JRadioButton("Verdadera");
		
		 btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GuardarPregunta();
			}
		});
		
		JLabel lblId = new JLabel("ID:");
		
		textId = new JTextField();
		textId.setColumns(10);
		
		lblCategoria = new JLabel("Categoria:");
		
		textCategoria = new JTextField();
		textCategoria.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Buscar();
				
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BorrarPregunta();
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Update();
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(178)
					.addComponent(lblPregunta)
					.addPreferredGap(ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
					.addComponent(lblId)
					.addGap(32))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textPregunta, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
							.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textRespuesta3, Alignment.LEADING)
								.addComponent(textRespuesta1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
							.addGap(102)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textRespuesta4)
								.addComponent(textRespuesta2, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addComponent(textCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addComponent(rdbtnVerdadera3)
					.addPreferredGap(ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
					.addComponent(rdbtnVerdadera4)
					.addGap(148))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(rdbtnVerdadera1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(lblRespuesta_2)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
							.addComponent(rdbtnVerdadera2)
							.addGap(78)
							.addComponent(btnBuscar)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(143)
							.addComponent(lblRespuesta_3)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(187)
					.addComponent(btnGuardar)
					.addGap(18)
					.addComponent(btnBorrar)
					.addGap(18)
					.addComponent(btnModificar)
					.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addComponent(lblRespuesta)
					.addGap(172)
					.addComponent(lblRespuesta_1)
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addComponent(lblCategoria)
					.addGap(31))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPregunta)
						.addComponent(lblId))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textPregunta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRespuesta)
						.addComponent(lblRespuesta_1)
						.addComponent(lblCategoria))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textRespuesta1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textRespuesta2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnVerdadera1)
								.addComponent(rdbtnVerdadera2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRespuesta_2)
								.addComponent(lblRespuesta_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textRespuesta3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textRespuesta4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnVerdadera3)
								.addComponent(rdbtnVerdadera4))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBorrar)
								.addComponent(btnGuardar)
								.addComponent(btnModificar)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(btnBuscar)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	public void GuardarPregunta(){
		
		solucion1 = rdbtnVerdadera1.isSelected();
		solucion2 = rdbtnVerdadera2.isSelected();
		solucion3 = rdbtnVerdadera3.isSelected();
		solucion4 = rdbtnVerdadera4.isSelected();
		
		hiber.addQuestion(Integer.parseInt(textId.getText()), textPregunta.getText(), textCategoria.getText());
		hiber.addAnswer(textRespuesta1.getText(), solucion1, Integer.parseInt(textId.getText()));
		hiber.addAnswer(textRespuesta2.getText(), solucion2, Integer.parseInt(textId.getText()));
		hiber.addAnswer(textRespuesta3.getText(), solucion3, Integer.parseInt(textId.getText()));
		hiber.addAnswer(textRespuesta4.getText(), solucion4, Integer.parseInt(textId.getText()));
	}
	public void BorrarPregunta(){
		hiber.deleteQuestion(Integer.parseInt(textId.getText()));
	}
	public void Update(){
		//Pregunta
		hiber.updatePregunta(Integer.parseInt(textId.getText()), textPregunta.getText(), textCategoria.getText());
		//Respuesta
		hiber.listUpdateAnswer(Integer.parseInt(textId.getText()), textRespuesta1.getText(), rdbtnVerdadera1.isSelected(), Integer.parseInt(textId.getText()));
		hiber.listUpdateAnswer(Integer.parseInt(textId.getText()), textRespuesta2.getText(), rdbtnVerdadera2.isSelected(), Integer.parseInt(textId.getText()));
		hiber.listUpdateAnswer(Integer.parseInt(textId.getText()), textRespuesta3.getText(), rdbtnVerdadera3.isSelected(), Integer.parseInt(textId.getText()));
		hiber.listUpdateAnswer(Integer.parseInt(textId.getText()), textRespuesta4.getText(), rdbtnVerdadera4.isSelected(), Integer.parseInt(textId.getText()));
	}
	public void Buscar(){
		// PRegunta
		hiber.listQuestion(Integer.parseInt(textId.getText()));
		textId.setText(String.valueOf(hiber.idPregunta));
		textPregunta.setText(hiber.pregunta);
		textCategoria.setText(hiber.categoria);
		
		//Respuesta
		hiber.listAnswer(Integer.parseInt(textId.getText()));
		textRespuesta1.setText(hiber.textoRespuesta1);
		textRespuesta2.setText(hiber.textoRespuesta2);
		textRespuesta3.setText(hiber.textoRespuesta3);
		textRespuesta4.setText(hiber.textoRespuesta4);
		///
		rdbtnVerdadera1.setSelected(hiber.iscorrect1);
		rdbtnVerdadera2.setSelected(hiber.iscorrect2);
		rdbtnVerdadera3.setSelected(hiber.iscorrect3);
		rdbtnVerdadera4.setSelected(hiber.iscorrect4);
	}
}
