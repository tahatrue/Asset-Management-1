package org.gradle;
public class User {
	   public int eid;
	   public String ename;
	   public String email;
	   public int age;
	   public String sex;
	   
	   public int geteId()
	   {
	       return eid;
	   }
	   public void seteId(int eid)
	   {
	       this.eid = eid;
	   }
	   public String geteName()
	   {
	       return ename;
	   }
	   public void seteName(String ename)
	   {
	       this.ename = ename;
	   }
	   public String getEmail()
	   {
	       return email;
	   }
	   public void setEmail(String email)
	   {
	       this.email = email;
	   }
	   public int getAge()
	   {
	    return age;
	   }
	   public void setAge(int age)
	   {
	    this.age= age;
	   }
	   public String getSex()
	   {
	    return sex;
	   }
	   public void setSex(String sex)
	   {
	    this.sex= sex;
	   }
}