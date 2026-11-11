package W3_Bai8;

import java.util.Scanner;

public class List_CD {
	private CD[] cdr;
	private int count;
	 
	public List_CD(int n) {
	        this.cdr = new CD[n];   // BẮT BUỘC dùng this.cdr
	        this.count = 0;
	    }
	
	public int getCount()
	{
		return count;
	}
	
	//Mo rong mang
	public void TangKT()
	{
		if(cdr.length == count)
		{
			CD[] tam =new CD[cdr.length * 2];
			System.arraycopy(cdr, 0, tam, 0, count);
			cdr = tam;
		}
	}
	
	//Therm CD
	public boolean ThemCD (CD crom)
	{
		for (int i=0;i < count; i++)
			if (cdr[i].getMaCD().equalsIgnoreCase(crom.getMaCD()))
				return false;
		  TangKT();
	      cdr[count] = crom;
	      count++;
	      return true;
	}
	
	//Xoa CD
	 public boolean xoa(String maXoa) {
	        for (int i = 0; i < count; i++) {
	            if (cdr[i].getMaCD().equalsIgnoreCase(maXoa)) {
	                // Dồn các phần tử phía sau lên trước
	                for (int j = i; j < count - 1; j++) {
	                    cdr[j] = cdr[j + 1];
	                }
	                cdr[count - 1] = null;   // xóa tham chiếu ô cuối
	                count--;
	                return true;
	            }
	        }
	        return false;
	    }
	 public boolean CapNhat(String maCD, float gia)
	 {
		 for (int i=0; i < count; i++)
			 if(cdr[i].getMaCD().equalsIgnoreCase(maCD))
			 {
				 cdr[i].setGia(gia);
		 			return true;
	 		 }	
		 return false;
	 }
	 
	 public float TongTien()
	 {
		 float tong =0;
		 for (int i=0;i<count ;i++)
			 tong +=cdr[i].getGia() *cdr[i].getSobaihat();
		 return tong;
	 }
	 
	 public void InDS()
	 {
		 CD.Tieude(); 
		 for (int i = 0; i < count; i++) {
	            System.out.println(cdr[i]);        
	        }
	 }
	 
	 //NHAP CD TU BAN PHIM
	  public void nhapCD(Scanner sc) {
	        try {
	            System.out.print("Nhap ma CD: ");
	            String maCD = sc.nextLine();

	            System.out.print("Nhap tua CD: ");
	            String tuanCD = sc.nextLine();

	            System.out.print("Nhap ten ca sy: ");
	            String casy = sc.nextLine();

	            System.out.print("Nhap so bai hat: ");
	            int sobaihat = Integer.parseInt(sc.nextLine());

	            System.out.print("Nhap don gia: ");
	            float gia = Float.parseFloat(sc.nextLine());

	            CD cd = new CD(tuanCD, casy, sobaihat, gia, maCD);
	            if (ThemCD(cd)) {
	                System.out.println("=> Them CD thanh cong!");
	            } else {
	                System.out.println("=> Ma CD da ton tai, them that bai!");
	            }
	        } catch (Exception e) {
	            System.out.println("=> Loi nhap lieu: " + e.getMessage());
	        }
	    }
	  
	  //Xoa CD(Nhap tu ban phim)
	  public void xoaCD(Scanner sc) {
	        System.out.print("Nhap ma CD can xoa: ");
	        String maXoa = sc.nextLine();
	        if (xoa(maXoa)) {
	            System.out.println("=> Xoa thanh cong!");
	        } else {
	            System.out.println("=> Khong tim thay ma CD: " + maXoa);
	        }
	    }
	  
	  //Cap nhat gia CD (tu ban phim)
	  public void capNhatGiaCD(Scanner sc) {
	        System.out.print("Nhap ma CD can cap nhat: ");
	        String maCD = sc.nextLine();
	        try {
	            System.out.print("Nhap gia moi: ");
	            float gia = Float.parseFloat(sc.nextLine());
	            if (CapNhat(maCD, gia)) {
	                System.out.println("=> Cap nhat thanh cong!");
	            } else {
	                System.out.println("=> Khong tim thay ma CD: " + maCD);
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("=> Gia khong hop le!");
	        }
	    }
}
	 

