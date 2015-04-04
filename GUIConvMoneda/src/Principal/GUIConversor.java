package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import NET.webserviceX.www.CurrencyConvertorSoapProxy;
import NET.webserviceX.www.Currency;
import NET.webserviceX.www.CurrencyConvertorSoap;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.awt.Font;

public class GUIConversor extends JFrame {

	private JPanel contentPane;
	private JTextField pesos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConversor frame = new GUIConversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIConversor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIngreseElMonto = new JLabel("Ingrese el monto (CLP)");
		lblIngreseElMonto.setFont(new Font("Consolas", Font.ITALIC, 13));
		lblIngreseElMonto.setBounds(149, 71, 160, 28);
		contentPane.add(lblIngreseElMonto);

		pesos = new JTextField();
		pesos.setBounds(171, 110, 102, 28);
		contentPane.add(pesos);
		pesos.setColumns(10);

		JLabel labelMonto = new JLabel("");
		labelMonto.setBounds(158, 183, 151, 23);
		contentPane.add(labelMonto);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				if(pesos.getText().trim().length() != 0){//validar que el campo de texto no esté vacío
					int monto = Integer.parseInt(pesos.getText());
					CurrencyConvertorSoapProxy conversor = new CurrencyConvertorSoapProxy();
					CurrencyConvertorSoap ccs = conversor.getCurrencyConvertorSoap();

					try {
						 double conversionRate = ccs.conversionRate(Currency.CLP, Currency.USD);
						labelMonto.setText("USD: " + (monto * conversionRate));
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					labelMonto.setText("Debe ingresar un monto!");
				}
				
			}
		});
		btnConvertir.setBounds(109, 149, 102, 23);
		contentPane.add(btnConvertir);
		
		JLabel lblConversorDeMonedas = new JLabel("Conversor de Monedas");
		lblConversorDeMonedas.setFont(new Font("Comic Sans MS", Font.ITALIC, 21));
		lblConversorDeMonedas.setBounds(109, 30, 270, 30);
		contentPane.add(lblConversorDeMonedas);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesos.setText("");
				labelMonto.setText("USD: ");
			}
		});
		btnLimpiar.setBounds(227, 149, 102, 23);
		contentPane.add(btnLimpiar);


	}
}
