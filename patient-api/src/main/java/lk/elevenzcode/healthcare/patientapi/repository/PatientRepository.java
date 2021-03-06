package lk.elevenzcode.healthcare.patientapi.repository;

import lk.elevenzcode.healthcare.commons.repository.GenericRepository;
import lk.elevenzcode.healthcare.patientapi.domain.Patient;

import java.util.List;


public interface PatientRepository extends GenericRepository<Patient> {
  List<Patient> findAllByStatusIdIsNot(int status);

  Patient findByIdAndStatusIdIsNot(Integer id, int status);
}
