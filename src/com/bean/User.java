package com.bean;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
  
/** 
 * ”√ªß 
 * 
 */ 
@Entity(name="playerman")
public class User {  
     
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name = "id", unique = true,nullable=false) 
    private Integer  id;  
	@Column(name="name")  
    private String name;  
	@Column(name="password")  
    private String password;  
	@Column(name="createTime")    
    private Date createTime;  
	@Column(name="expireTime")  
    private Date expireTime;
	@Column(name="sex")
	private int sex;
	@Column(name="address",length=100)
	private String address;
  
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public Date getCreateTime() {  
        return createTime;  
    }  
  
    public void setCreateTime(Date createTime) {  
        this.createTime = createTime;  
    }  
  
    public Date getExpireTime() {  
        return expireTime;  
    }  
  
    public void setExpireTime(Date expireTime) {  
        this.expireTime = expireTime;  
    }

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", createTime=" + createTime
				+ ", expireTime=" + expireTime + ", sex=" + sex + ", address=" + address + "]";
	}
    
    
      
}  
