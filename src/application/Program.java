package application;

import java.sql.Connection;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = DB.getConnection();
		System.out.println("DB conectado!!!!!");
		DB.closeConnection();  
		
		// não há necessidade fechamento ST e RT no qual foi implementado 2 métodos para fechamento
		// para não gerar várias exceçoes e é semente a classe public static void closeConnection()
	}
}