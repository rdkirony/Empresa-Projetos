package project.restaurant.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;



public class RestaurantDto implements Serializable{

	private static final long serialVersionUID = 4600904826176900002L;
	
	private String id;
	private final String DI = "DI";
	private Date date;
	private String M;
	private UUID uuid;
	private ArrayList<String> respostas = new ArrayList<String>();

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getM() {
		return M;
	}
	public void setM(String m) {
		M = m;
	}
	public String getDI() {
		return DI;
	}
	public UUID getUuid() {
		uuid = UUID.randomUUID();
		return uuid;
	}
	public String formatDate() {
        LocalDate ldate = LocalDate.from(getDate().toInstant().atZone(ZoneOffset.UTC));
        String s = DateTimeFormatter.ISO_DATE.format(ldate);
		return s;
	}
	public String replace(String s) {
		String string = s.replace("-", "");
		return string;
	}
	public  ArrayList<String> getAll(){
		respostas.add(getId().toString());
		respostas.add(getDI().toString());
		respostas.add(replace(formatDate()));
		respostas.add(getM());
		respostas.add(replace(getUuid().toString()));
		return respostas;
	}

}
