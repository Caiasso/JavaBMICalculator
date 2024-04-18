package ex1;

public class IMC {

	private float peso, altura;

	public IMC(float peso, float altura) {
		super();
		this.peso = peso;
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public float calculaImc(float peso, float altura) {
		
		float imc = this.peso/(altura*altura);		
	
		return imc;
	}
	
}
