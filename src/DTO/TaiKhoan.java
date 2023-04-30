package DTO;
public class TaiKhoan {
    private int idTK;
    private String username;
    private String password;
    private int loaiTK;
    private String maTK;

    public int getIdTK() {
        return idTK;
    }

    public void setIdTK(int idTK) {
        this.idTK = idTK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoaiTK() {
        return loaiTK;
    }

    public void setLoaiTK(int loaiTK) {
        this.loaiTK = loaiTK;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }
    
}
