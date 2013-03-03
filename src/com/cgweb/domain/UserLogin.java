package com.cgweb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "User_Login")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserLogin implements Serializable {
	
	private static final long serialVersionUID = 1L;

		@Id()
		@Column(name = "USER_SEQ")
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_SEQ")
		@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ")
		private String id;

		@Column(name = "PASSWORD")
		private String password;

		@Column(name = "USER_NAME")
		private String userName;

		@Column(name = "ROLE")
		@Enumerated(EnumType.STRING)
		private Role role;

		@Column(name = "USER_ID")
		private String userId;

		public UserLogin(String userName, String password, Role role, String userId)
		{
			this();
			this.userName = userName;
			this.password = password;
			this.role = role;
			this.userId = userId;
		}

		public UserLogin(Role role)
		{
			this();
			this.role = role;
		}

		public UserLogin()
		{
			super();
		}

		public String getId()
		{
			return id;
		}

		public void setId(String id)
		{
			this.id = id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

}
