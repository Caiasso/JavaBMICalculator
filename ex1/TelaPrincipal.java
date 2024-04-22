package ex1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField fieldPeso;
	private JTextField fieldAltura;
	private JLabel lblImc;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("Calculadora de IMC");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow]", "[][][20][][][20][][20][][]"));
		
		JLabel lblPeso = new JLabel("Seu peso em Kg");
		panel.add(lblPeso, "cell 0 0");
		
		fieldPeso = new JTextField();
		panel.add(fieldPeso, "cell 0 1,growx");
		fieldPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("Sua altura em metros");
		panel.add(lblAltura, "cell 0 3");
		
		fieldAltura = new JTextField();
		panel.add(fieldAltura, "cell 0 4,growx");
		fieldAltura.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this);
		panel.add(btnCalcular, "cell 0 6,growx");
		
		lblImc = new JLabel("");
		lblImc.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblImc.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblImc, "cell 0 8,alignx center");
		
		lblResult = new JLabel("");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(lblResult, "cell 0 9,alignx center");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Calcular"))
		{
			if(! fieldAltura.getText().isEmpty() && ! fieldPeso.getText().isEmpty())
			{
				float peso = Float.parseFloat(fieldPeso.getText());
				float altura = Float.parseFloat(fieldAltura.getText());
				
				IMC imc = new IMC(peso, altura);
				
				DecimalFormat df = new DecimalFormat("0.##");
				float resultado = imc.calculaImc(peso, altura);
				String resultadoForm = df.format(resultado);
				
				lblImc.setText(resultadoForm);
				lblResult.setText("Seu IMC");
				
				if(resultado < 25)
				{
					JOptionPane.showMessageDialog(contentPane, "Subpeso", "Seu Resultado", 1);
				}
				else if(resultado < 30)
				{
					JOptionPane.showMessageDialog(contentPane, "Peso Normal", "Seu Resultado", 1);
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Sobrepeso", "Seu Resultado", 1);
				}
			}
		}
		
	}
	
	

}
