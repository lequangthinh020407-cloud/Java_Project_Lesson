
import java.lang.reflect.Field;
import java.util.Random;

public class CongNhan {
    private String maCN=this.generateID();
    private String mHo="";
    private String mTen="";
    private int mSoSP=0;

    private String generateID() {
        Random rd = new Random();
        String res = "";

        for (int i=0; i<5; i++) res+=(char)(rd.nextInt(26)+'a');

        return res;
    }

    public CongNhan(String _mHo, String _mTen, int _mSoSP) {
        this.set_mHo(_mHo);
        this.set_mTen(_mTen);
        this.set_mSoSP(_mSoSP);
    };

    public CongNhan() {};

    public String getter(String attribute) {
        return this.getter(attribute, false);
    }

    public String getter(String attribute, boolean print) {
        try {
            Field field = this.getClass().getDeclaredField(attribute);
            field.setAccessible(true);
            String value = String.valueOf(field.get(this));
            if (print) System.out.println(value);
            return value;
        } catch (NoSuchFieldException e) {
            System.err.println("Attribute does not exist: " + attribute);
        } catch (IllegalAccessException e) {
            System.err.println("Unable to access attribute: " + attribute);
        }
        return null;
    }

    public void set_mHo(String _mHo) {
        if (_mHo.isEmpty()) _mHo="";
        this.mHo = _mHo;
    }

    public void set_mTen(String _mTen) {
        if (_mTen.isEmpty()) _mTen="";
        this.mTen = _mTen;
    }

    public void set_mSoSP(int _mSoSP) {
        if (_mSoSP < 0 || _mSoSP >= Integer.MAX_VALUE) _mSoSP = 0;
        this.mSoSP = _mSoSP;
    }

    public double tinhLuong() {
        double res=0;
        int luong = this.mSoSP;
        if (luong<=0) return 0;

        if (luong>=600)
            res=(luong-599)*.65+199*.6+199*.55+199*.5;
        else if (luong>=400)
            res=(luong-399)*.6+199*.55+199*.5;
        else if (luong>=200)
            res=(luong-199)*.55+199*.5;
        else if (luong>=1)
            res = luong*.5;

        return res;
    }

    @Override
    public String toString() {
        return "Ma so: "+this.maCN+"\nHo Ten: "+this.mHo+" "+this.mTen;
    }
}
