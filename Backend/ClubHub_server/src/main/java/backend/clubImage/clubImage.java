package backend.clubImage;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clubimage")

/**
 * 
 * @author Danny Yip, Cobi Mom
 *
 * A club image class
 */
public class clubImage {
	
	@Id
	/**
	 * students image number
	 */
	private String imageNumber;
	/**
	 * club unique id
	 */
	private String clubID;
	/**
	 * clubs image format
	 */
	private String imageFormat;
	/**
	 * clubs image url
	 */
	private String imageURL;


	/**
	 * empty club image constructor 
	 */
	public clubImage()
	{
		
	}
	
	/**
	 * Club image constructor with parameters
	 * 
	 * @param imagenumber
	 * students image number
	 * @param clubid
	 * club unique id
	 * @param imageformat
	 * clubs image format
	 * @param imageurl
	 * clubs image url
	 */
	public clubImage(String imagenumber,String clubid,String imageformat , String imageurl)
	{
		this.clubID = clubid;
		this.imageNumber = imagenumber;
		this.imageFormat = imageformat;
		this.imageURL = imageurl;


		
	}

	/**
	 * get club image number
	 * @return
	 * image number
	 */
	public String getImageNumber() {
		return imageNumber;
	}

	/**
	 * set image number
	 * @param imageNumber image number
	 */
	public void setImageNumber(String imageNumber) {
		this.imageNumber = imageNumber;
	}

	/**
	 * get club id
	 * @return
	 * club id
	 */
	public String getClubID() {
		return clubID;
	}

	/**
	 * set club id
	 * @param clubID club id
	 */
	public void setClubID(String clubID) {
		this.clubID = clubID;
	}

	/**
	 * get image format
	 * @return image format
	 */
	public String getImageFormat() {
		return imageFormat;
	}

	/**
	 * set image format 
	 * @param imageFormat image format
	 */
	public void setImageFormat(String imageFormat) {
		this.imageFormat = imageFormat;
	}

	/**
	 * get image url
	 * @return
	 * image url
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * set image url
	 * @param imageURL 
	 * image url
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}





	
	
	
	
	
}
