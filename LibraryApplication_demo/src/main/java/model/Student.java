package model;

public class Student {

    private Integer id;
    private String name;
    
    public Student() {}
    
    public Student(Integer id, String name) {
		// TODO Auto-generated constructor stub
    	this.id=id;
    	this.name=name;
    	
	}


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
}