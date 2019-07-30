package com.sahabul.dts2019ujian.model;

public class MenuMakanan {
    String kode, jenis, nama, penjelasan, harga;

    public MenuMakanan(String kode, String jenis, String nama, String penjelasan, String harga) {
        this.kode = kode;
        this.jenis = jenis;
        this.nama = nama;
        this.penjelasan = penjelasan;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
