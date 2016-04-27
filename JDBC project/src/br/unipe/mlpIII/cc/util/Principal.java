package br.unipe.mlpIII.cc.util;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import br.unipe.mlpIII.cc.pertinencia.*;
import br.unipe.mlpIII.cc.modelo.*;

public class Principal {
	public static void main(String[] args) {
		List<Conta> listaDeContas = new ArrayList<Conta>();
		DataBase db = new DataBase("localhost", "bancario", "postgres", "123456", "1521");
		
		db.setConnection();
		db.query("Select * from conta");
		
		try {
			while(db.getResultSet().next() ){
				listaDeContas.add(new Conta(db.getResultSet().getInt("id"), db.getResultSet().getString("numero"), db.getResultSet().getDouble("saldo"), db.getResultSet().getBoolean("status"), db.getResultSet().getString("titular")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		Collections.sort(listaDeContas);
		
		System.out.println(listaDeContas);
		
		db.closeConnection();
	}
}
