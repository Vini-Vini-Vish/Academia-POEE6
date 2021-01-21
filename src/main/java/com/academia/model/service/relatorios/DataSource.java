package com.academia.model.service.relatorios;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.academia.model.service.ConexaoBancoService;

public class DataSource extends ConexaoBancoService {
	
	private Connection connection = null;
	
	public Connection getConnection() {
		
		Session session = getEntityManager().unwrap(Session.class);
	
		Conexao conexao = new Conexao();
		
		session.doWork(conexao);
		
		connection = conexao.getConnection();
		
		return connection;
	}
	
	 
	private static class Conexao implements Work  {
		
		private Connection connection;

		@Override
		public void execute(Connection connection) throws SQLException {
			this.connection = connection;
		}
		
	     
		public Connection getConnection() {
			return this.connection;
		}		
		
	}

}
