package com.doc.assistant.integration.dao;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDaoTest {

	@Autowired
	private DataSource dataSource;
	
	protected void setUp() throws Exception {
		IDatabaseConnection dbConn = new DatabaseDataSourceConnection(dataSource);
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(this.getClass().getClassLoader().getResourceAsStream("classpath:/db-state/initial_dataset.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(dbConn, dataSet);
	}
}