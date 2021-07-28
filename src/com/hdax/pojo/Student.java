package com.hdax.pojo;

public class Student {

  private long id;
  private String userName;
  private String sex;
  private long sexBoolean;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public long getSexBoolean() {
    return sexBoolean;
  }

  public void setSexBoolean(long sexBoolean) {
    this.sexBoolean = sexBoolean;
  }

  @Override
  public String toString() {
    return "com.hdax.pojo.Student{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", sex='" + sex + '\'' +
            ", sexBoolean=" + sexBoolean +
            '}';
  }
}
