
public class WiseSaying {
	
	int id;
	String regDate;
	String author;
	String content;
	
	WiseSaying(int id, String author, String content, String regDate){
		this.id =id;
		this.regDate =regDate;
		this.author =author;
		this.content =content;		
	}
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
