package com.doc.assistant.test.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class DbUtilsDataExport {
	private String completeDataset = "initial_dataset.xml";
	
	public void exportData(){
		try {
			Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/doc_assistant_db", "root", "admin");
	        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
	        IDataSet fullDataSet = connection.createDataSet();
	        FlatXmlDataSet.write(fullDataSet, new FileOutputStream(completeDataset));
//	        FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream("test.dtd"));
		} catch (SQLException | DatabaseUnitException | IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args){
		DbUtilsDataExport export = new DbUtilsDataExport();
		export.exportData();
	}
}