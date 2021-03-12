package model;

public class Show {
	int showId;
	String showName;
	String showImage;
	String showLocation;
	double entryPrice;
	String showDate;
	boolean upcoming;

	public Show(int showId, String showName, String showImage, String showLocation, double entryPrice, String showDate,
			boolean upcoming) {
		this.showId = showId;
		this.showName = showName;
		this.showImage = showImage;
		this.showLocation = showLocation;
		this.entryPrice = entryPrice;
		this.showDate = showDate;
		this.upcoming = upcoming;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getShowImage() {
		return showImage;
	}

	public void setShowImage(String showImage) {
		this.showImage = showImage;
	}

	public String getShowLocation() {
		return showLocation;
	}

	public void setShowLocation(String showLocation) {
		this.showLocation = showLocation;
	}

	public double getEntryPrice() {
		return entryPrice;
	}

	public void setEntryPrice(double entryPrice) {
		this.entryPrice = entryPrice;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public boolean isUpcoming() {
		return upcoming;
	}

	public void setUpcoming(boolean upcoming) {
		this.upcoming = upcoming;
	}

}