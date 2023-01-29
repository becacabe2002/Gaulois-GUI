package models;

import org.json.simple.JSONObject;

public abstract class HistoricalItem {
	protected int id;
	private static int nbItem = 0;
	protected JSONObject jsonFormat;

	public JSONObject getJsonFormat() {
		return jsonFormat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getNbItem() {
		return nbItem;
	}

	public static void setNbItem(int nbItem) {
		HistoricalItem.nbItem = nbItem;
	}
	
	public HistoricalItem() {
		this.id = nbItem;
		this.incrementNbItem();
	}
	
	public void incrementNbItem() {
		nbItem++;
	}
	
	public abstract JSONObject createJSON();
	
}