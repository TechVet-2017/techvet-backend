package br.com.bovdog.bean;

/**
 * Class that implements the clinicalrecord and return a instance of clinical record.
 * @author João Paulo
 * @version 1.0
 */
public class VaccinationFactory implements ClinicalRecordFactory {

	/**
	*Return the instance
	*@return ClinicalRecordVaccination clinicalRecordVaccination
	*/
	@Override
	public ClinicalRecord createClinicalRecord() {
		ClinicalRecordVaccination clinicalRecordVaccination = new ClinicalRecordVaccination();
		return clinicalRecordVaccination;
	}

}
