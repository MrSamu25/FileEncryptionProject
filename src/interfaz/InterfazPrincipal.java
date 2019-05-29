package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class InterfazPrincipal extends JFrame {

	
	private PanelOpciones panelOpciones;
	private PanelArchivos panelArchivos;
	
	
	public static void main(String[] args) {
		InterfazPrincipal interfazPrincipal = new InterfazPrincipal();
		interfazPrincipal.setVisible(true);
	}

	
	public InterfazPrincipal() {
		
		setSize(new Dimension(600,400));
		setTitle("Proyecto final Ciberseguridad - Ana Arango, Steven Muriel, Jhoan Delgado");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout( new BorderLayout());
		
		panelArchivos =  new PanelArchivos();
		add(panelArchivos, BorderLayout.WEST);
		
		panelOpciones = new PanelOpciones();
		add(panelOpciones, BorderLayout.EAST);
		
	}
	
	
}