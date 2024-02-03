package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.enums.Shape;

public class Nodo {

	private Nodo pai;

	private Integer id;

	private String label;

	private Shape shape;

	private String style;

	private String color;

	private String fillcolor;

	private List<Nodo> filhos = new ArrayList<>();

	public Nodo(Integer id, String label) {
		
		this.id = id;
		this.label = label;
	
	}

	public Nodo(Nodo pai, Integer id, String label) {

		this.pai = pai;
		this.id = id;
		this.label = label;
	}

	public String arestasFilhos(int distancia) {

		StringBuilder strBuilder = new StringBuilder();

		strBuilder.append("");
		
		if (temFilhos()) {

			strBuilder.append(id + " -> {");

			for (int i = 0; i < filhos.size(); i++) {

				if (i < filhos.size() - 1) {

					strBuilder.append(filhos.get(i).getId() + ",");

				} else {

					strBuilder.append(filhos.get(i).getId() + "} [len=" + distancia + "]");

				}

			}
		}

		return strBuilder.toString();

	}

	@Override
	public String toString() {

		return id + " [ label=" + label + " shape=" + shape + " style=" + style + " fillcolor=" + fillcolor + " color="
				+ color + " ]";

	}

	public Boolean temFilhos() {

		return !filhos.isEmpty();

	}

	public Nodo getPai() {
		return pai;
	}

	public void setPai(Nodo pai) {
		this.pai = pai;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Nodo> getFilhos() {
		return filhos;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFillcolor() {
		return fillcolor;
	}

	public void setFillcolor(String fillcolor) {
		this.fillcolor = fillcolor;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
