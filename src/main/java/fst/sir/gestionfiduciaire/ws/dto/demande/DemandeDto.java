package fst.sir.gestionfiduciaire.ws.dto.demande;

import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.commun.Societe;
import fst.sir.gestionfiduciaire.bean.demande.EtatDemande;
import fst.sir.gestionfiduciaire.bean.demande.TypeDemande;

import java.time.LocalDateTime;
public class DemandeDto{
private long id;
private String libelle;
private String code;
private LocalDateTime dateDemande;
private LocalDateTime dateExigibilite;
private Societe societe;
private TypeDemande typeDemande;
private EtatDemande etatDemande;
private Comptable comptableValidateur;
private Comptable comptableTraitant;

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getLibelle() {
    return libelle;
}

public void setLibelle(String libelle) {
    this.libelle = libelle;
}

public String getCode() {
    return code;
}

public void setCode(String code) {
    this.code = code;
}

public LocalDateTime getDateDemande() {
    return dateDemande;
}

public void setDateDemande(LocalDateTime dateDemande) {
    this.dateDemande = dateDemande;
}

public LocalDateTime getDateExigibilite() {
    return dateExigibilite;
}

public void setDateExigibilite(LocalDateTime dateExigibilite) {
    this.dateExigibilite = dateExigibilite;
}

public Societe getSociete() {
    return societe;
}

public void setSociete(Societe societe) {
    this.societe = societe;
}

public TypeDemande getTypeDemande() {
    return typeDemande;
}

public void setTypeDemande(TypeDemande typeDemande) {
    this.typeDemande = typeDemande;
}

public EtatDemande getEtatDemande() {
    return etatDemande;
}

public void setEtatDemande(EtatDemande etatDemande) {
    this.etatDemande = etatDemande;
}

public Comptable getComptableValidateur() {
    return comptableValidateur;
}

public void setComptableValidateur(Comptable comptableValidateur) {
    this.comptableValidateur = comptableValidateur;
}

public Comptable getComptableTraitant() {
    return comptableTraitant;
}

public void setComptableTraitant(Comptable comptableTraitant) {
    this.comptableTraitant = comptableTraitant;
}
}