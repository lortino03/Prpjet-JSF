package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")


public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	@Column(name="password")
	private String pwd;
	@Column(name="login")
	private String login;
	
				
				public int getId() {
					return id;
				}
				public void setId(int id) {
					this.id = id;
				}
				public String getPwd() {
					return pwd;
				}
				public void setPwd(String pwd) {
					this.pwd = pwd;
				}
				
				public String getLogin() {
					return login;
				}
				
				public void setLogin(String login) {
					this.login=login;
				}
				public User() {
					
				}
	
		public User(int id, String pwd,String login) {
			super();
			this.id = id;
			this.pwd = pwd;
			this.login=login;
		}

	
}
