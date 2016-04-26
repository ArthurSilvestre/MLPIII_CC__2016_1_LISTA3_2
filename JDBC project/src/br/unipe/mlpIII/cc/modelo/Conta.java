package br.unipe.mlpIII.cc.modelo;

public class Conta implements Comparable<Conta>{
	protected int id;
	protected String numero;
	protected double saldo;
	protected boolean status;
	protected String titular;
	
	public Conta(int id, String numero, double saldo, boolean status, String titular) {
		this.id = id;
		this.numero = numero;
		this.saldo = saldo;
		this.status = status;
		this.titular = titular;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	@Override
	public String toString() {
		return "Conta( id: " + id + ", numero: " + numero + ", saldo: R$" + saldo + ", status: " + status + ", titular: " + titular + ")\n";
	}

	@Override
	public int compareTo(Conta conta) {
		if (this.id < conta.id) return -1;
		if (this.id > conta.id) return  1;
		return 0;
	}

}
