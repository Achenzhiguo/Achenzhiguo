package com.czg.string;


import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

public class Person {
    private Integer age;
    private String name;
    private Address address;
    private String sex;
    private Integer studyId;

    public Person() {
    }

    public Person(Integer age, String name, Address address, String sex, Integer studyId) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.studyId = studyId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getStudyId() {
        return studyId;
    }

    public void setStudyId(Integer studyId) {
        this.studyId = studyId;
    }

    @Override
    public String toString() {
        return "StringBufferDemo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", sex='" + sex + '\'' +
                ", studyId=" + studyId +
                '}';
    }

}
