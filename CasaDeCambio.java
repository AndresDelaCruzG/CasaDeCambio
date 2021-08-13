package programa41;

import javax.swing.JOptionPane;
import programa43.ValidarCaptura;

public class CasaDeCambio {

	ValidarCaptura objCaptura = new ValidarCaptura();

	float Fondo, FondoIP, FondoID, FondoP, FondoD, TipoC, TipoV, AgregarP, AgregarD, RetirarP, RetirarD, VentaP, VentaD,
			PesosIn, DolaresIn, DolaresInF, PesosInF;

	int AcumTE, AcumFI;
	String texto = "";

	public void AbrirTurno() {

		JOptionPane.showMessageDialog(null, "Bienvenido a Home Exchange Systems");
		FondoIP = objCaptura.CapturaFloat("Ingrese el fondo Inicial de Pesos:");
		FondoID = objCaptura.CapturaFloat("Ingrese el fondo Inicial de Dolares:");

		FondoP = FondoIP;
		FondoD = FondoID;

		texto = texto + "\nSe abrio el turno inicial con: " + FondoP + " MXN y " + FondoD +" Dlls";

	} // Abrir Turno

	public void TC() {

		TipoC = objCaptura.CapturaFloat("Ingrese el tipo de compra actual:");

		if (TipoC > 26) {

			JOptionPane.showMessageDialog(null, "Tipo de compra exede valores permitidos, corrija los datos");

		} // if

		TipoV = objCaptura.CapturaFloat("Ingrese el tipo de venta actual:");

		if (TipoV > 26) {

			JOptionPane.showMessageDialog(null, "Tipo de venta exede valores permitidos, corrija los datos");

		} // if

		if (TipoC > TipoV) {

			JOptionPane.showMessageDialog(null, "Tipo de compra mayor a venta verifique los datos");

		} // if

		texto = texto + "\nSe ingreso \nTipo de Compra: " + TipoC + "\nTipo de Venta: " + TipoV;

	} // Tipo de cambio

	public void AgregarP() {

		AgregarP = objCaptura.CapturaFloat("Ingresa la cantidad de pesos a agregar:");

		FondoP += AgregarP;

		texto = texto + "\nSe agrego al fondo la cantidad de: " + AgregarP + " pesos";

	} // Agregar Pesos

	public void RetirarP() {

		RetirarP = objCaptura.CapturaFloat("Ingresa la cantidad a pesos retirar:");

		if (RetirarP < FondoP) {

			JOptionPane.showMessageDialog(null, "Se ha retirado la cantidad de: " + RetirarP + " MXN");

			FondoP -= RetirarP;

			texto = texto + "\nSe retiro del fondo la cantidad de: " + RetirarP + " pesos";

		} // if

		else {

			JOptionPane.showMessageDialog(null, "Fondo Insuficiente");

			AcumFI++;

			texto = texto + "\nTransaccion Incompleta";

		} // else

	} // Retirar Pesos

	public void AgregarD() {

		AgregarD = objCaptura.CapturaFloat("Ingresa la cantidad de dolares a agregar:");

		FondoD += AgregarD;

		texto = texto + "\nSe agrego al fonfo la cantidad de: " + AgregarD + " dolares";

	} // Agregar Dolares

	public void RetirarD() {

		RetirarD = objCaptura.CapturaFloat("Ingresa la cantidad de dolares a retirar:");

		if (RetirarD < FondoD) {

			JOptionPane.showMessageDialog(null, "Se ha retirado la cantidad de: " + RetirarD + " DLLS");

			FondoD -= RetirarD;

			texto = texto + "\nSe retiro del fondo la cantidad de: " + RetirarD + " dolares";

		} // if

		else {

			JOptionPane.showMessageDialog(null, "Fondo Insuficiente");

			AcumFI++;

			texto = texto + "\nTransaccion Incompleta";

		} // else

	} // Retirar Dolares

	public void FondoTC() {

		JOptionPane.showMessageDialog(null, "Fondo en pesos: " + FondoP + " pesos \nFondo en dolares: " + FondoD
				+ " dolares \nTipo de compra: " + TipoC + "\nTipo de Venta: " + TipoV);

		texto = texto + "\nSe consulto el Fondo y Tipos de Cambio";

	} // Fondo General

	public void PesosDolar() {

		float resto;

		PesosIn = objCaptura.CapturaFloat("Ingresa la cantidad de pesos recibidos:");

		int opcion = 0;

		while (opcion != 3) {

			opcion = objCaptura
					.CapturaInt("Venta de Pesos \n\n1) Conversion Fraccion \n2) Conversion Completa \n\n3) Regresar");

			switch (opcion) {

			case 1:

				PesosInF = objCaptura.CapturaFloat("Ingresa la cantidad de pesos a convertir:");

				resto = PesosIn - PesosInF;

				VentaD = PesosInF / TipoV; // Registro de la Venta de Dolares

				JOptionPane.showMessageDialog(null, "Se recibira la cantidad de " + PesosInF + " MXN a cambio de "
						+ VentaD + " USD \nTipo de cambio actual: " + TipoV + " MXN x Dolar");

				if (FondoD >= VentaD) {

					JOptionPane.showMessageDialog(null,
							"Transaccion realizada correctamente \nEntregar al cliente la cantidad de " + VentaD
									+ " DLLS y " + resto + " MXN");

					FondoD -= VentaD;
					FondoP += PesosInF;
					AcumTE++;

					texto = texto + "\nSe recibio la cantidad de: " + PesosInF + " MXN a cambio de: " + VentaD
							+ " Dlls";

				} // if

				else {

					JOptionPane.showMessageDialog(null, "Fondo Insuficiente");

					AcumFI++;

					texto = texto + "\nTransaccion Incompleta";

				} // else

				break;

			case 2:

				VentaD = PesosIn / TipoV; // Registro de la Venta de Dolares

				JOptionPane.showMessageDialog(null, "Se recibira la cantidad de " + PesosIn + " MXN a cambio de "
						+ VentaD + " USD \nTipo de cambio actual: " + TipoV + " MXN x Dolar");

				if (FondoD >= VentaD) {

					JOptionPane.showMessageDialog(null, "Transaccion realizada correctamente");

					FondoD -= VentaD;
					FondoP += PesosIn;
					AcumTE++;

					texto = texto + "\nSe recibio la cantidad de: " + PesosIn + " MXN a cambio de: " + VentaD + " Dlls";

				} // if

				else {

					JOptionPane.showMessageDialog(null, "Fondo Insuficiente");

					AcumFI++;

					texto = texto + "\nTransaccion Incompleta";

				} // else

				break;

			case 3:

				break;

			} // Switch
		} // While
	} // Compra

	public void DolarPesos() {

		float resto;

		DolaresIn = objCaptura.CapturaFloat("Ingresa la cantidad de dolares recibidos:");

		int opcion = 0;

		while (opcion != 3) {

			opcion = objCaptura.CapturaInt(
					"Compra de Dolares \n\n1) Conversion Fraccion \n2) Conversion Completa \n\n3) Regresar");

			switch (opcion) {

			case 1:

				DolaresInF = objCaptura.CapturaFloat("Ingresa la cantidad de dolares a convertir:");

				resto = DolaresIn - DolaresInF;

				VentaP = DolaresInF * TipoC; // Registro de la Venta de Pesos

				JOptionPane.showMessageDialog(null, "Se recibira la cantidad de " + DolaresInF + " USD a cambio de "
						+ VentaP + " MXN \nTipo de cambio actual: " + TipoC + " MXN x Dolar");

				if (FondoP >= VentaP) {

					JOptionPane.showMessageDialog(null,
							"Transaccion realizada correctamente \nEntregar al cliente la cantidad de " + VentaP
									+ " MXN y " + resto + " DLLS");

					FondoP -= VentaP;
					FondoD += DolaresInF;
					AcumTE++;

					texto = texto + "\nSe recibio la cantidad de: " + DolaresInF + " Dlls a cambio de: " + VentaP
							+ " pesos";

				} // if

				else {

					JOptionPane.showMessageDialog(null, "Fondo Insuficiente");

					AcumFI++;

					texto = texto + "\nTransaccion Incompleta";

				} // else

				break;

			case 2:

				VentaP = DolaresIn * TipoC; // Registro de la Venta de Pesos

				JOptionPane.showMessageDialog(null, "Se recibira la cantidad de " + DolaresIn + " USD a cambio de "
						+ VentaP + " MXN \nTipo de cambio actual: " + TipoC + " MXN x Dolar");

				if (FondoP >= VentaP) {

					JOptionPane.showMessageDialog(null, "Transaccion realizada correctamente");

					FondoP -= VentaP;
					FondoD += DolaresIn;
					AcumTE++;

					texto = texto + "\nSe recibio la cantidad de: " + DolaresIn + " Dlls a cambio de: " + VentaP
							+ " pesos";

				} // ifs

				else {

					JOptionPane.showMessageDialog(null, "Fondo Insuficiente");

					AcumFI++;

					texto = texto + "\nTransaccion Incompleta";

				} // else

				break;

			case 3:

				break;

			} // Switch
		} // While
	} // Venta

	public void Reportes() {

		JOptionPane.showMessageDialog(null,
				"Numero de transacciones exitosas: " + AcumTE + "\nNumero de transacciones denegadas: " + AcumFI);

	} // Reportes

	public void Bitacora() {

		JOptionPane.showMessageDialog(null, "Bitacora del dia" + texto);

	} // Bitacora

} // Casa De Cambio
