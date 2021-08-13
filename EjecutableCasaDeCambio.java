package programa41;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import programa43.ValidarCaptura;

public class EjecutableCasaDeCambio {

	static ImageIcon CasaCambio = new ImageIcon(
			"C://Users//52664//Documents//UABC//Programacion 3ro//Fotos Programas//CasaCambio.png");

	public static void main(String[] args) {

		CasaDeCambio obj = new CasaDeCambio();
		ValidarCaptura objCaptura = new ValidarCaptura();

		obj.AbrirTurno();
		obj.TC();

		int opcion = 0;

		while (opcion != 7) {

			opcion = objCaptura.CapturaInt("Tipo de Compra: " + obj.TipoC + "\nTipo de Venta: " + obj.TipoV
							+ "\n\n1) Cambiar T.C \n2) Agregar Dinero \n3) Retirar Dinero \n4) Consultar Fondo - Tipo de Cambio \n5) Comprar - Vender \n6) Bitacoras \n7) Salir");

			switch (opcion) {

			case 1:

				obj.TC();

				break;

			case 2:

				int opcion3 = 0;

				while (opcion3 != 3) {

					opcion3 = objCaptura
							.CapturaInt("* Agregar Fondos * \n\n1) Agregar Pesos \n2) Agregar Dolares \n\n3) Regresar");

					switch (opcion3) {

					case 1:

						obj.AgregarP();

						break;

					case 2:

						obj.AgregarD();

						break;

					case 3:

						break;

					default:

						JOptionPane.showMessageDialog(null, "Error");

					} // Switch

				} // While

				break;

			case 3:

				int opcion1 = 0;

				while (opcion1 != 3) {

					opcion1 = objCaptura
							.CapturaInt("* Retirar Fondo *\n\n1) Retirar Pesos \n2) Retirar Dolares \n\n3) Regresar");

					switch (opcion1) {

					case 1:

						obj.RetirarP();

						break;

					case 2:

						obj.RetirarD();

						break;

					case 3:

						break;

					default:

						JOptionPane.showMessageDialog(null, "Error");

					} // Switch

				} // While

				break;

			case 4:

				obj.FondoTC();

				break;

			case 5:

				while (opcion != 3) {

					opcion = objCaptura
							.CapturaInt("$ Compra - Venta $ \n\n1) Pesos a Dolar \n2) Dolar a Pesos \n\n3) Regresar");

					switch (opcion) {

					case 1:

						obj.PesosDolar();

						break;

					case 2:

						obj.DolarPesos();

					case 3:

						break;

					default:

						JOptionPane.showMessageDialog(null, "Error");

					} // Switch

				} // While

				break;

			case 6:

				obj.Bitacora();

				break;

			case 7:

				obj.Reportes();
				JOptionPane.showMessageDialog(null, "Sistema cerrado correctamente");

				break;

			default:

				JOptionPane.showMessageDialog(null, "Error");

			} // Switch

		} // While

	}

}
