/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.patient;

import core.appoiment.Appoiment;
import core.doctor.Doctor;
import core.team.Team;
import core.ward.Ward;
import java.util.ArrayList;

/**
 *
 * @author mapac
 */
public class Patient {
    private int id;
    private Team team;
    private Ward ward;
    private ArrayList<Appoiment> appoiments;
    private ArrayList<Doctor> doctors;
    

    public Patient(Ward ward, Team team, int id) {
        this.id = id;
        this.ward = ward;
        this.team = team;
        this.appoiments = new ArrayList<>();
        this.doctors = new ArrayList<>();
        ward.addPatient(this);
        team.addPatient(this);
    }

    public int getId() { 
        return this.id; 
    }
    public Team getTeam() { 
        return this.team; 
    }
    public Ward getWard() {
        return this.ward; 
    }
    public ArrayList<Doctor> getDoctors() { 
        return this.doctors; 
    }
    public ArrayList<Appoiment> getAppoiments() { 
        return this.appoiments; 
    }

    public void addDoctor(Doctor doctor) {
        if (!this.doctors.contains(doctor)) {
            this.doctors.add(doctor);
            doctor.addPatient(this);
        }
    }

    public void addAppoiment(Appoiment appoiment) {
        if (!this.appoiments.contains(appoiment)) {
            this.appoiments.add(appoiment);
        }
    }

    public void showAppoiments() {
        System.out.println("Patient " + this.id + " has " + this.appoiments.size() + " appoiments");
        for (Appoiment appoiment : this.appoiments) {
            System.out.println("Patient " + this.id
                    + " has an appoiment with the doctor " + appoiment.getDoctor().getId());
        }
    }

}
