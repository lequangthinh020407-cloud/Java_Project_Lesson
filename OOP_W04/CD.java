package W3_Bai8;

public class CD {
	private String maCD;
	private String tuanCD;
	private String casy;
	private int sobaihat;
	private float gia;
	
	//Dong Goi 
	/**
	 * @return the maCD
	 */
	public String getMaCD() {
		return maCD;
	}
	/**
	 * @param maCD the maCD to set
	 */
	public void setMaCD(String maCD) {
		this.maCD = maCD;
	}
	/**
	 * @return the tuanCD
	 */
	public String getTuanCD() {
		return tuanCD;
	}
	/**
	 * @param tuanCD the tuanCD to set
	 */
	public void setTuanCD(String tuanCD) {
		this.tuanCD = tuanCD;
	}
	/**
	 * @return the casy
	 */
	public String getCasy() {
		return casy;
	}
	/**
	 * @param casy the casy to set
	 */
	public void setCasy(String casy) {
		this.casy = casy;
	}
	/**
	 * @return the sobaihat
	 */
	public int getSobaihat() {
		return sobaihat;
	}
	/**
	 * @param sobaihat the sobaihat to set
	 */
	public void setSobaihat(int sobaihat) throws Exception {
		if(sobaihat > 0)
			this.sobaihat = sobaihat;
		else
			throw new Exception("so bai hat phai lon hon 0");
	}


	public float getGia() { return gia; }
	public void  setGia(float gia) { this.gia = gia; }
	
	//constructor rong:  dung de tao nhung gia tri moi
	public CD() {}
	
	//constructor day du
	/**
	 * @param maCD
	 * @param tuanCD
	 * @param casy
	 * @param sobaihat
	 * @param gio
	 */
	 public CD(String tuanCD, String casy, int soBai,float gia, String maCD) throws Exception {
		 this.tuanCD = tuanCD;
		 this.casy  = casy;
		 this.setSobaihat(sobaihat);   // tái sử dụng ràng buộc
		 this.gia   = gia;
		 this.maCD  = maCD;
   }
	 
	// IN TIEU DE
	 
	 public static void Tieude()
	 {
	 System.out.println("In danh sach CD");
	 
	 //Ve dong gach ngang
	 for (int i=0;i<100;i++)
		 System.out.println("-");
	 System.out.println();
	 
	 // in tieu de theo tung cot
	 String s = String.format(
	            "|%10s|%10s|%10s|%10s|%10s|%10s|",
	            "Ma CD", "Tua CD", "Ca Sy",
	            "So Bai", "Don Gia", "Thanh Tien");
	        System.out.println(s);

	        // Vẽ dòng gạch ngang phía dưới
	        for (int i = 0; i < 100; i++) System.out.print("-");
	        System.out.println();
	 }

	 //Ghi DE ToString
	 public String toString() {
	        return String.format(
	            "|%10s|%10s|%10s|%10d|%10.2f|%10.2f|",
	            maCD, tuanCD, casy, sobaihat, gia, gia * sobaihat);
	    }
}
