package br.unipe.mlpIII.cc.pertinencia;

import java.sql.*;

public class DataBase {
	private String host;
	private String dbname;
	private String login;
	private String senha;
	private String porta;
	private Connection con;
	private Statement st;
	private ResultSet rs;

	public DataBase(String host, String dbname, String login, String senha, String porta) {
		this.host = host;
		this.dbname = dbname;
		this.login = login;
		this.senha = senha;
		this.porta = porta;
	}
	
	public void setConnection(){
		try{
			Class.forName("org.postgresql.Driver");
			this.con = DriverManager.getConnection("jdbc:postgresql://"+this.host+":"+this.porta+"/"+this.dbname, this.login, this.senha);
			this.st = this.con.createStatement();
		}catch( ClassNotFoundException e){
			System.out.println(e.getMessage());
		}catch(SQLException e ){
			System.out.println(e.getMessage());
		}
	}
	
	public void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		this.st = null;
		this.rs = null;
		this.con = null;
	}
	
	public ResultSet query(String query){
		
		try {
			this.rs = st.executeQuery(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return this.rs;
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public ResultSet getResultSet() {
		return rs;
	}
	public void setResultSet(ResultSet rs) {
		this.rs = rs;
	}

	@Override
	public String toString() {
		return "DataBase";
	}
}
