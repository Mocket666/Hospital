package core.hospital;

import core.appoiment.Appoiment;
import core.doctor.Doctor;
import core.doctor.JuniorDoctor;
import core.patient.Patient;

import core.team.Team;
import core.ward.Ward;
import java.util.ArrayList;

public class Hospital {
    private ArrayList<Team> teams;
    private ArrayList<Ward> wards;

    public Hospital() {
        this.teams = new ArrayList<>();
        this.wards = new ArrayList<>();
    }

    public boolean addTeam(int id, int idConsultant) {
        if (getTeam(id) != null) {
            return false;
        }
        Team team = new Team(id, idConsultant);
        this.teams.add(team);
        return true;
    }

    public Team getTeam(int id) {
        for (Team team : this.teams) {
            if (team.getId() == id) {
                return team;
            }
        }
        return null;
    }

    public void addJuniorDoctor(Team team, int id) {
        if (team == null) {
            throw new IllegalArgumentException("El equipo no existe");
        }
        if (team.getDoctor(id) == null) {
            JuniorDoctor doctor = new JuniorDoctor(team, id);
            team.addDoctor(doctor);
        }
    }

    public boolean addWard(int id) {
        if (getWard(id) != null) {
            return false;
        }
        this.wards.add(new Ward(id));
        return true;
    }

    public Ward getWard(int id) {
        for (Ward ward : this.wards) {
            if (ward.getId() == id) {
                return ward;
            }
        }
        return null;
    }

    public boolean addPatient(Ward ward, Team team, int id) {
        if (ward == null || team == null) {
            throw new IllegalArgumentException("La sala y el equipo deben existir");
        }
        if (getPatient(id) != null) {
            return false;
        }
        // El constructor registra al paciente en su sala y en su equipo.
        new Patient(ward, team, id);
        return true;
    }

    public Patient getPatient(int id) {
        for (Ward ward : this.wards) {
            Patient patient = ward.getPatient(id);
            if (patient != null) {
                return patient;
            }
        }
        return null;
    }

    private Doctor getPatientDoctor(Patient patient, int number) {
        if (patient == null) {
            throw new IllegalArgumentException("El paciente no existe");
        }
        Team team = patient.getTeam();
        // El main entrega un numero relativo al ID del equipo.
        Doctor doctor = team.getDoctor(team.getId() + number);
        if (doctor == null) {
            throw new IllegalArgumentException("El doctor no existe en este equipo");
        }
        return doctor;
    }

    public void assignPatientDoctor(Patient patient, int number) {
        Doctor doctor = getPatientDoctor(patient, number);
        patient.addDoctor(doctor);
    }

    public void assignAppoiment(Patient patient, int number) {
        Doctor doctor = getPatientDoctor(patient, number);
        // Cada llamada crea una cita distinta, incluso con el mismo doctor.
        new Appoiment(doctor, patient);
    }

    public void numberDoctorsPatient() {
        for (Ward ward : this.wards) {
            ward.numberDoctorsPatient();
        }
    }

    public void numberPatientsTeam() {
        for (Team team : this.teams) {
            System.out.println("Team " + team.getId() + " has "
                    + team.getPatients().size() + " patients");
        }
    }

    public void relationAppoiments() {
        for (Ward ward : this.wards) {
            ward.relationAppoiments();
        }
    }
}
