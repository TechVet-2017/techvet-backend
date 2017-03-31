package br.com.bovdog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.bovdog.bean.Patient;

public class PatientDAO {
	public List<Patient> getAllPatients() {
		List<Patient> patients= new ArrayList<Patient>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;

		return null;
	}
}
