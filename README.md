# Sistem Database Mahasiswa

Aplikasi desktop berbasis Java untuk manajemen data mahasiswa dengan menggunakan arsitektur MVC-DAO (Model-View-Controller-Data Access Object) dan database MySQL.

## Deskripsi Aplikasi

Sistem Database Mahasiswa adalah aplikasi manajemen data mahasiswa yang memungkinkan pengguna untuk melakukan operasi CRUD (Create, Read, Update, Delete) pada data mahasiswa. Aplikasi ini menggunakan antarmuka grafis (GUI) yang dibangun dengan Swing di NetBeans IDE.

## Fitur

- Menambahkan data mahasiswa baru
- Menampilkan seluruh data mahasiswa dalam tabel
- Mengubah data mahasiswa yang sudah ada
- Menghapus data mahasiswa
- Pencarian data mahasiswa berdasarkan nama

## Arsitektur Aplikasi

Aplikasi ini dibangun dengan menggunakan pola desain MVC (Model-View-Controller) yang dikombinasikan dengan pola DAO (Data Access Object):

- **Model**: Representasi objek data mahasiswa
- **View**: Antarmuka pengguna grafis (GUI) untuk interaksi dengan pengguna
- **Controller**: Menghubungkan Model dan View, menangani logika bisnis
- **DAO**: Menangani operasi database, memisahkan logika akses data dari logika bisnis
- **DAOInterface**: Mendefinisikan kontrak untuk implementasi DAO

## Teknologi

- Java
- NetBeans IDE
- MySQL Database
- Java Swing untuk GUI
- JDBC untuk koneksi database

## Struktur Proyek

```
src/
├── crudmvcdao/         # Package utama aplikasi
├── Controller/         # Controller untuk menghubungkan Model dan View
├── DAO/                # Implementasi Data Access Object
├── DAOInterface/       # Interface untuk DAO
├── Helper/             # Utilitas seperti koneksi database
├── Model/              # Representasi objek data
└── View/               # Komponen GUI aplikasi
```

## Cara Penggunaan

1. Pastikan MySQL sudah terinstal dan berjalan di sistem Anda
2. Buat database dengan nama yang sesuai (defaultnya: `dbmahasiswa`)
3. Import skema database dari file SQL (jika disediakan)
4. Pastikan konfigurasi koneksi database sudah benar di file `KoneksiDB.java`
5. Build dan jalankan aplikasi melalui NetBeans IDE

## Persyaratan Sistem

- Java Development Kit (JDK) 8 atau yang lebih baru
- NetBeans IDE 8.2 atau yang lebih baru
- MySQL Server
- MySQL Connector/J (JDBC Driver untuk MySQL)

## Lisensi

[Disesuaikan dengan ketentuan lisensi]
