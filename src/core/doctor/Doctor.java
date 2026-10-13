/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.doctor;

import core.appoiment.Appoiment;
import core.patient.Patient;
import core.team.Team;
import java.util.ArrayList;

/**
 *
 * @author mapac
 */
public abstract class Doctor {
    protected int id;
    protected Team team;
    protected ArrayList<Appoiment> appoiments;
    protected ArrayList<Patient> patients;
   
    public Doctor(Team team, int id) {
    this.team = team;
    this.id = id;
    this.appoiments = new ArrayList<>();
    this.patients = new ArrayList<>();
   }

    public int getId() { return this.id; }
    public Team getTeam() { return this.team; }
    public ArrayList<Appoiment> getAppoiments() { return this.appoiments; }
    public ArrayList<Patient> getPatients() { return this.patients; }

    public void addPatient(Patient patient) {
        if (!this.patients.contains(patient)) {
            this.patients.add(patient);
        }
    }

    public void addAppoiment(Appoiment appoiment) {
        if (!this.appoiments.contains(appoiment)) {
            this.appoiments.add(appoiment);
        }
    }

}
