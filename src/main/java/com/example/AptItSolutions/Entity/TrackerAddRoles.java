package com.example.AptItSolutions.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tracker_add_roles")
public class TrackerAddRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;
    private Long roleId;
    private String existingRole;
    private String newRole;
    private String existingCreatedBy;
    private String newCreatedBy;
    private LocalDate existingCreationDate;
    private LocalDate newCreationDate;
	public Long getSno() {
		return sno;
	}
	public void setSno(Long sno) {
		this.sno = sno;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getExistingRole() {
		return existingRole;
	}
	public void setExistingRole(String existingRole) {
		this.existingRole = existingRole;
	}
	public String getNewRole() {
		return newRole;
	}
	public void setNewRole(String newRole) {
		this.newRole = newRole;
	}
	public String getExistingCreatedBy() {
		return existingCreatedBy;
	}
	public void setExistingCreatedBy(String existingCreatedBy) {
		this.existingCreatedBy = existingCreatedBy;
	}
	public String getNewCreatedBy() {
		return newCreatedBy;
	}
	public void setNewCreatedBy(String newCreatedBy) {
		this.newCreatedBy = newCreatedBy;
	}
	public LocalDate getExistingCreationDate() {
		return existingCreationDate;
	}
	public void setExistingCreationDate(LocalDate existingCreationDate) {
		this.existingCreationDate = existingCreationDate;
	}
	public LocalDate getNewCreationDate() {
		return newCreationDate;
	}
	public void setNewCreationDate(LocalDate newCreationDate) {
		this.newCreationDate = newCreationDate;
	}
	public TrackerAddRoles(Long sno, Long roleId, String existingRole, String newRole, String existingCreatedBy,
			String newCreatedBy, LocalDate existingCreationDate, LocalDate newCreationDate) {
		super();
		this.sno = sno;
		this.roleId = roleId;
		this.existingRole = existingRole;
		this.newRole = newRole;
		this.existingCreatedBy = existingCreatedBy;
		this.newCreatedBy = newCreatedBy;
		this.existingCreationDate = existingCreationDate;
		this.newCreationDate = newCreationDate;
	}
	@Override
	public String toString() {
		return "TrackerAddRoles [sno=" + sno + ", roleId=" + roleId + ", existingRole=" + existingRole + ", newRole="
				+ newRole + ", existingCreatedBy=" + existingCreatedBy + ", newCreatedBy=" + newCreatedBy
				+ ", existingCreationDate=" + existingCreationDate + ", newCreationDate=" + newCreationDate + "]";
	}
	public TrackerAddRoles() {
		super();
		// TODO Auto-generated constructor stub
	}


    
    
    
    
}