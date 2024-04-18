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
import java.text.NumberFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import net.miginfocom.swing.MigLayout;

public class TelaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldPeso;
	private JTextField fieldAltura;
	private JLabel lblResult;
	private JLabel lblSeuImc;
	

	

	public JTextField getFieldPeso() {
		return fieldPeso;
	}

	public void setFieldPeso(JTextField fieldPeso) {
		this.fieldPeso = fieldPeso;
	}

	public JTextField getFieldAltura() {
		return fieldAltura;
	}

	public void setFieldAltura(JTextField fieldAltura) {
		this.fieldAltura = fieldAltura;
	}

	public JLabel getLblResult() {
		return lblResult;
	}

	public void setLblResult(JLabel lblResult) {
		this.lblResult = lblResult;
	}

	public JLabel getLblSeuImc() {
		return lblSeuImc;
	}

	public void setLblSeuImc(JLabel lblSeuImc) {
		this.lblSeuImc = lblSeuImc;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					frame.setResizable(false);
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
		setBounds(100, 100, 299, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Calculadora de IMC");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[253px]", "[14px][][30px][20][14px][30px][20][23px][20][30px][14px]"));
		
		JLabel lblPeso = new JLabel("Seu peso em Kg");
		panel.add(lblPeso, "cell 0 0,alignx left,aligny top");
		
		fieldPeso = new JTextField();
		panel.add(fieldPeso, "cell 0 2,grow");
		fieldPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("Sua altura em metros");
		panel.add(lblAltura, "cell 0 4,alignx left,aligny top");
		
		fieldAltura = new JTextField();
		fieldAltura.setColumns(10);
		panel.add(fieldAltura, "cell 0 5,grow");
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this);
		panel.add(btnCalcular, "cell 0 7,growx,aligny top");
		
		lblResult = new JLabel("");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblResult, "cell 0 9,grow");
		
		lblSeuImc = new JLabel("");
		lblSeuImc.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSeuImc, "cell 0 10,growx,aligny top");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Calcular"))
		{
			float peso = Float.parseFloat(fieldPeso.getText());
			float altura = Float.parseFloat(fieldAltura.getText());
			
			IMC imc = new IMC(peso, altura);
			
			float resultado = imc.calculaImc(peso, altura);
			
			DecimalFormat df = new DecimalFormat("0.##");
			String fim = df.format(resultado);
			
			
			lblResult.setText(fim);
			lblSeuImc.setText("Seu IMC");
			
			if(resultado < 25)
			{
				JOptionPane.showMessageDialog(contentPane, "Subpeso", "Resultado", 1);
			}
			else if(resultado < 30)
			{
				JOptionPane.showMessageDialog(contentPane, "Peso Normal", "Resultado", 1);
			}
			else
			{
				JOptionPane.showMessageDialog(contentPane, "Sobrepeso", "Resultado", 1);
			}
			
		}
		
	}
}
