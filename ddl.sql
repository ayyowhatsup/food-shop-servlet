CREATE TABLE NguoiDung(
maNguoiDung SERIAL PRIMARY KEY ,
tennguoidung VARCHAR(50),
sodienthoai VARCHAR(10),
matkhaumahoa VARCHAR(24),
laquantrivien int
);

CREATE TABLE TheLoai (
maTheLoai SERIAL PRIMARY KEY,
tenTheLoai VARCHAR(50)
);

CREATE TABLE SanPham (
maSanPham SERIAL PRIMARY KEY,
tenSanPham VARCHAR(100),
giaTien INT,
mieuTa TEXT,
hinhAnh VARCHAR(150),
DonViTinh VARCHAR(20),
TonKho INT,
maTheLoai INT,
FOREIGN KEY(maTheLoai) REFERENCES TheLoai(maTheLoai)
);

CREATE TABLE DonHang(
maDonHang SERIAL PRIMARY KEY,
manguoidung INT,
thoigiandathang TIMESTAMP,
thanhtien INT,
trangthai VARCHAR(50),
diachinhanhang VARCHAR(200),
FOREIGN KEY(manguoidung) REFERENCES NguoiDung(maNguoiDung)
);

CREATE TABLE DonHangChiTiet(
maDonHangChiTiet SERIAL PRIMARY KEY,
maDonHang INT,
maSanPham INT,
soLuong INT,
FOREIGN KEY(maDonHang) REFERENCES DonHang(maDonHang),
FOREIGN KEY(maSanPham) REFERENCES SanPham(maSanPham)
);