/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.team;
import core.doctor.ConsultantDoctor;
import java.util.ArrayList;
import core.doctor.Doctor;
import core.patient.Patient;
/**
 *
 * @author mapac
 */
public class Team {
    private int id;
    private ConsultantDoctor teamLeader;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;
    
    public Team(int id, int idConsultant) {
    this.id = id;
    this.doctors = new ArrayList<>();
    this.patients = new ArrayList<>();

    this.teamLeader = new ConsultantDoctor(this, idConsultant);
    this.doctors.add(this.teamLeader);
   }

    public int getId() {
        return id;
    }
    
    public boolean addDoctor(Doctor doctor) {
    if (!this.doctors.contains(doctor)) {
        this.doctors.add(doctor);
        return true;
    }
    return false;
    
}
    

    public ConsultantDoctor getTeamLeader() { return this.teamLeader; }
    public ArrayList<Doctor> getDoctors() { return this.doctors; }
    public ArrayList<Patient> getPatients() { return this.patients; }

    public Doctor getDoctor(int id) {
        for (Doctor doctor : this.doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    public void addPatient(Patient patient) {
        if (!this.patients.contains(patient)) {
            this.patients.add(patient);
        }
    }

}
