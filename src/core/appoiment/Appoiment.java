/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.appoiment;

import core.doctor.Doctor;
import core.patient.Patient;

/**
 *
 * @author mapac
 */
public class Appoiment {
    private Doctor doctor;
    private Patient patient;

    public Appoiment(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
        patient.addDoctor(doctor);
        patient.addAppoiment(this);
        doctor.addAppoiment(this);
    }

    public Doctor getDoctor() {
        return this.doctor; 
    }
    public Patient getPatient() { 
        return this.patient; 
    }

}
