package com.czg.string.com.czg.mapper;




public class Emp {
    private Integer Id;
    private String name;
    private Integer empId;
    private Integer empno;
    private Double sal;


    @Override
    public String toString() {
        return "Emp{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", empId=" + empId +
                ", empno=" + empno +
                ", sal=" + sal +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Emp(Integer id, String name, Integer empId, Integer empno, Double sal) {
        Id = id;
        this.name = name;
        this.empId = empId;
        this.empno = empno;
        this.sal = sal;
    }

    public Emp() {
    }
}
