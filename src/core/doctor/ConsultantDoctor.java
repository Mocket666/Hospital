/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.doctor;

import core.team.Team;

/**
 *
 * @author mapac
 */
public class ConsultantDoctor extends Doctor {
    private Team leaderOf;

    public ConsultantDoctor(Team team, int id) {
        super(team, id);
        this.leaderOf = team;
    }

    public Team getLeaderOf() { 
        return this.leaderOf; 
    }

}
