package interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelOpciones extends JPanel implements ActionListener {

	public final static String INGRESAR_CLAVE = "INGRESAR_CLAVE";

	private JTextField txt_ingresar_semilla;
	private JLabel lab_semilla;
	private JButton but_semilla;

	public PanelOpciones() {
		setPreferredSize(new Dimension(200, 0));

		TitledBorder border = BorderFactory.createTitledBorder("Panel Opciones");
		setBorder(border);

		txt_ingresar_semilla = new JTextField(10);

		but_semilla = new JButton("Ingresar clave");
		but_semilla.setActionCommand(INGRESAR_CLAVE);
		but_semilla.addActionListener(this);

		lab_semilla = new JLabel("xxxxx");

		add(txt_ingresar_semilla);
		add(but_semilla);

		add(lab_semilla);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();

		switch (comando) {

		case INGRESAR_CLAVE:
			if (txt_ingresar_semilla.getText() != null && !txt_ingresar_semilla.getText().equals("")
					&& !txt_ingresar_semilla.getText().trim().equals("")) {
				but_semilla.setText(txt_ingresar_semilla.getText());
			} else {
				System.out.println("Debe ingresar una clave válida");
			}
			break;
		}

	}

}
