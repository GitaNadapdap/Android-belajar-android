package stud11417030.develops.uts2019;

public class book {
    public String judul;
    public String harga;
    public String description;

    public book(String judul, String harga, String description) {
        this.judul = judul;
        this.harga = harga;
        this.description = description;
    }

    public String getJudul() {
        return judul;
    }

    public String getHarga() {
        return harga;
    }

    public String getDescription(){
        return description;
    }
}
