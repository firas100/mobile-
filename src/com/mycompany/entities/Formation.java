/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import com.codename1.facebook.User;
import java.util.Collection;

/**
 *
 * @author FIRAS
 */
public class Formation {
      private int id;
    private String titre;
    private String description;
    private String type;
    private String pays;
    private String debut;
    private String fin;
    private Boolean confirmation;
    private User user;
    private Collection participations;

    public Formation() {
    }

    public Formation(int id, String titre, String description, String type, String pays, String debut, String fin, Boolean confirmation) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.type = type;
        this.pays = pays;
        this.debut = debut;
        this.fin = fin;
        this.confirmation = confirmation;
    }
    public Formation(String titre, String description, String type, String pays, String debut, String fin) {
    this.titre = titre;
    this.description = description;
    this.type = type;
    this.pays = pays;
    this.debut = debut;
    this.fin = fin;
}


//    public Formation(int id, String titre, String description, String type, String pays, String debut, String fin, Boolean confirmation, User user, Collection participations) {
//        this.id = id;
//        this.titre = titre;
//        this.description = description;
//        this.type = type;
//        this.pays = pays;
//        this.debut = debut;
//        this.fin = fin;
//        this.confirmation = confirmation;
//        this.user = user;
//        this.participations = participations;
//    }

   
    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", type=" + type + ", pays=" + pays + ", debut=" + debut + ", fin=" + fin + ", confirmation=" + confirmation + ", user=" + user + ", participations=" + participations + '}';
    }
    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection getParticipations() {
        return participations;
    }

    public void setParticipations(Collection participations) {
        this.participations = participations;
    }

    
    
    
    
}
