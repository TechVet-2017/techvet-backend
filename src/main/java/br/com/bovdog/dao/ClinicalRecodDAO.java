package br.com.bovdog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.bovdog.bean.ClinicalRecord;


public class ClinicalRecodDAO {
	
	private final String URL = "jdbc:mysql://localhost:3306/techvet?useSSL=false&serverTimezone=UTC";
	private final String USER = "root";
	private final String PASSWORD = "root";
	
	
	
	public List<ClinicalRecord> getAllClinicalRecords() {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<ClinicalRecord> records = new ArrayList<ClinicalRecord>();
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.prepareStatement("SELECT * FROM clinical_record");
			results = statement.executeQuery();
			
			while(results.next()) {
				
				ClinicalRecord record = new ClinicalRecord();
				
				record.setC_protocol(results.getInt("c_protocol"));
				record.setAnamnesis(results.getString("anamnesis"));
				record.setVeterinarian(results.getString("veterinarian"));
				record.setClinical_history(results.getString("clinical_history"));
				record.setDiagnosis(results.getString("diagnosis"));
				record.setPatientTemperature(results.getFloat("patientTemperature"));
				record.setCapillaryFill(results.getFloat("capillaryFill"));
				record.setPatientPulse(results.getString("patientPulse"));
				record.setMucosasApparent(results.getString("mucosasApparent"));
				record.setPatientRespiratoryRate(results.getFloat("patientRespiratoryRate"));
				record.setPatientHearRate(results.getFloat("patientHeartRate"));
				records.add(record);
				 
				
			}
			
		}
		
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
	
		catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		return records;
	}
	
	public ClinicalRecord getClinicalRecordById(){
		
		return null;
		
	}
	
	public void CreateClinicalRecord(ClinicalRecord clinicalRecord){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try{
			

			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "INSERT INTO clinicalRecord (anamnesis, veterinarian, clinical_history, diagnosis,"
					+"patientTemperature, capillaryFill, patientPulse, mucosasApparent, patientRespiratoryRate,"
					+"patientHeartRate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, clinicalRecord.getAnamnesis());
			preparedStatement.setString(2, clinicalRecord.getVeterinarian());
			preparedStatement.setString(3, clinicalRecord.getClinical_history());
			preparedStatement.setString(4, clinicalRecord.getDiagnosis());
			preparedStatement.setFloat(5, clinicalRecord.getPatientTemperature());
			preparedStatement.setFloat(6, clinicalRecord.getCapillaryFill());
			preparedStatement.setString(7, clinicalRecord.getPatientPulse());
			preparedStatement.setString(8, clinicalRecord.getMucosasApparent());
			preparedStatement.setFloat(9, clinicalRecord.getPatientRespiratoryRate());
			preparedStatement.setFloat(10, clinicalRecord.getPatientHeartRate());
			preparedStatement.executeUpdate();
			
		}
		
		catch(SQLException e) {
					
			e.printStackTrace();
					
		}
			
		catch(ClassNotFoundException e) {
					
			e.printStackTrace();
				
		}
	}
}
