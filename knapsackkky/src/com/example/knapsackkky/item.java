package com.example.knapsackkky;
public class item {
	private String name;
	private double value;
	private int weight;
	private int imageID;
	
	public String toString()
	{
		return "Name : "+name+" Value is : "+value+" weight: "+weight+"\n";
	}
	
	public item(String name,int weight,double value,int img)
	{
		this.name = name;
		this.weight = weight;
		this.value = value;
		imageID = img;
	}
	public String getName()
	{
		return name;
	}
	public double getValue()
	{
		return value;
	}
	public int getWeight()
	{
		return weight;
	}
	public int getIcon()
	{
		return imageID;
	}
	}
