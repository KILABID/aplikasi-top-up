package com.latihanpbo.topupgenius;

public class produk {
    private String namaProduk;
    private String harga;

    public produk(String namaProduk, String harga) {
        this.namaProduk = namaProduk;
        this.harga = harga;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public String getHarga() {
        return harga;
    }
}