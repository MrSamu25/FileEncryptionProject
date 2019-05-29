package interfaz;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelArchivos extends JPanel {

	public PanelArchivos() {
		setPreferredSize(new Dimension(395, 0));
		
		TitledBorder border = BorderFactory.createTitledBorder("Panel Archivos");
		setBorder(border);
	}
}
