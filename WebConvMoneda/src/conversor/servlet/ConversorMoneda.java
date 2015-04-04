package conversor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NET.webserviceX.www.CurrencyConvertorSoapProxy;
import NET.webserviceX.www.Currency;
import NET.webserviceX.www.CurrencyConvertorSoap;

import java.io.PrintWriter;
import java.rmi.RemoteException;

/**
 * Servlet implementation class ConversorMoneda
 */
public class ConversorMoneda extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConversorMoneda() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String monto = request.getParameter("monto");
		
		if(monto==""){//si el usuario no ingresa nada muestra un mensaje
			request.setAttribute("mensaje", "Debe ingresar un valor");
		} else {
			int valor = Integer.parseInt(monto);
			CurrencyConvertorSoapProxy conversor = new CurrencyConvertorSoapProxy();
			CurrencyConvertorSoap ccs = conversor.getCurrencyConvertorSoap();
		
			double conversionRate = ccs.conversionRate(Currency.CLP, Currency.USD);
			request.setAttribute("mensaje", "USD: "+ (valor*conversionRate));
		}
		request.getRequestDispatcher("/ConversorMon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
