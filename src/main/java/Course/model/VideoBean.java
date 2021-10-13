package Course.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VideoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer videoId;
	private String name;	//課程名
	private Clob videoInfo;	//課程資訊
	private String category; //課程類別
	private String partOfBody; //不確定會用數字還是字串來設定  //運動部位
	private Blob videoImage;	//影片圖片
	private String mimeType;   // /dmot/src/main/java/_03_listBooks/service/impl/BookServiceImpl.java
	private Date time;	//上傳時間
	private Integer price; //Integer or Double 	//課程價格
	private String coach; //放影片上傳者
	private String equipment; //器材
	private String level; //適合的層級
	private Boolean pass; //課程是否審核成功
	private	Boolean checked; //審核狀態（未審核/已審核）
	
	public VideoBean(Integer videoId) {
		this.videoId = videoId;
	}
	public VideoBean(Integer videoId, String name) {
		this.videoId = videoId;
		this.name = name;
	}
	
	public VideoBean() {
		super();
	}

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clob getVideoInfo() {
		return videoInfo;
	}

	public void setVideoInfo(Clob videoInfo) {
		this.videoInfo = videoInfo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPartOfBody() {
		return partOfBody;
	}

	public void setPartOfBody(String partOfBody) {
		this.partOfBody = partOfBody;
	}

	public Blob getVideoImage() {
		return videoImage;
	}

	public void setVideoImage(Blob videoImage) {
		this.videoImage = videoImage;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Boolean getPass() {
		return pass;
	}

	public void setPass(Boolean pass) {
		this.pass = pass;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}	
	
	

	
	

}
