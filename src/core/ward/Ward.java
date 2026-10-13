/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.ward;

import core.patient.Patient;
import java.util.ArrayList;

/**
 *
 * @author mapac
 */
public class Ward {
    private int id;
    private ArrayList<Patient> patients;

    public Ward(int id) {
        this.id = id;
        this.patients = new ArrayList<>();
    }

    public int getId() { 
        return this.id; }
    public ArrayList<Patient> getPatients() { 
        return this.patients; }

    public void numberDoctorsPatient() {
        for (Patient patient : this.patients) {
            System.out.println("Patient " + patient.getId() + " has "
                    + patient.getDoctors().size() + " doctors");
        }
    }

    public void relationAppoiments() {
        for (Patient patient : this.patients) {
            patient.showAppoiments();
        }
    }

    public void addPatient(Patient patient) {
        if (!this.patients.contains(patient)) {
            this.patients.add(patient);
        }
    }

    public Patient getPatient(int id) {
        for (Patient patient : this.patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

}
