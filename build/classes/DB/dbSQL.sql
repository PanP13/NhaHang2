use master;
drop database NhaHang1;

create database NhaHang1;
go
use NhaHang1;

create table KhachHang (
	MaKH char(5),
	HoTen nvarchar(50) NOT NULL,
	GioiTinh tinyint CHECK (GioiTinh<2) NOT NULL,
	Phone char(10) UNIQUE,
	Email varchar(50) UNIQUE,
	DiaChi nvarchar(100),
	CONSTRAINT PK_MaKH PRIMARY KEY (MaKH)
);

create table NhanVien (
	MaNV char(5),
	HoTen nvarchar(50) NOT NULL,
	GioiTinh tinyint CHECK (GioiTinh<2) NOT NULL,
	Phone char(10) UNIQUE,
	Email varchar(50) UNIQUE,
	DiaChi nvarchar(100),
	CONSTRAINT PK_MaNV PRIMARY KEY (MaNV)
);

create table LoaiTK(
	MaLTK tinyint CHECK(MaLTK<3) NOT NULL,
	TenLTK nvarchar(50) NOT NULL,
	CONSTRAINT PK_MaLTK PRIMARY KEY(MaLTK)
);

create table TaiKhoan(
	IDTK int IDENTITY(1,1) PRIMARY KEY,
	TenDN varchar(50) UNIQUE NOT NULL,
	MatKhau varchar(50) NOT NULL,
	MaLTK tinyint CHECK (MaLTK<3) NOT NULL,
	MaTK char(5) NOT NULL,
	CONSTRAINT FK_MaLTK_ACC FOREIGN KEY (MaLTK) REFERENCES LoaiTK(MaLTK)
);

create table LoaiBan(
	MaLB int,
	SoGhe int,
	CONSTRAINT PK_MaLB PRIMARY KEY(MaLB)
);

create table Ban (
	MaBan char(5),
	TenBan nvarchar(50) NOT NULL,
	MaLB int,
	TrangThai int default(0),
	CONSTRAINT PK_MaBan PRIMARY KEY (MaBan),
	CONSTRAINT FK_MaLB FOREIGN KEY (MaLB) REFERENCES LoaiBan(MaLB)
);

create table LoaiSP(
	MaLSP int,
	TenLSP nvarchar(50) NOT NULL,
	CONSTRAINT PK_MaLSP PRIMARY KEY (MaLSP)
);

create table SanPham (
	MaSP char(5),
	TenSP nvarchar(50) NOT NULL,
	DonGia int DEFAULT(0),
	MaLSP int,
	CONSTRAINT PK_MaSP PRIMARY KEY (MaSP),
	CONSTRAINT FK_MaLSP FOREIGN KEY (MaLSP) REFERENCES LoaiSP(MaLSP)
);

create table HoaDon (
	MaHD char(5),
	MaKH char(5),
	MaNV char(5),
	MaBan char(5),
	TrangThai int default (0),
	CONSTRAINT PK_MaHD PRIMARY KEY (MaHD),
	CONSTRAINT FK_MaKH_HD FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
	CONSTRAINT FK_MaNV_HD FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
	CONSTRAINT FK_MaBan_HD FOREIGN KEY (MaBan) REFERENCES Ban(MaBan)
);

create table CTHD (
	MaHD char(5),
	MaSP char(5),
	SoLuong int,
	CONSTRAINT PK_MaHD_MaSP_CTHD PRIMARY KEY (MaHD, MaSP),
	CONSTRAINT FK_MaHD_CTHD FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
	CONSTRAINT FK_MaSP_CTHD FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
);

/* Quy ước : 0 - Login, 1 - Logout, 2 - Add, 3 - Update, 4 - Delete*/

create table LichSu (
	ID int IDENTITY (1,1) PRIMARY KEY,
	TaiKhoan char(5) NOT NULL,
	HanhDong int NOT NULL, 
	ChiTiet nvarchar(300),
	ThoiGian datetime default(CURRENT_TIMESTAMP)
);

Insert into KhachHang values 
('KH001', N'Ngô Phương Linh',  0, '0908615148', 'nplinh148@gmail.com', 'TPHCM'),
('KH002', N'Vũ Phong Đạt', 1, '0755239163', 'datvu163@gmail.com', 'TPHCM'),
('KH003', N'Trần Khánh Đang', 0, '0900349463', 'dangtk463@gmail.com', 'TPHCM'),
('KH004', N'Phạm Vương Vũ', 1, '0907566622', 'vuongvup622@gmail.com', 'TPHCM'),
('KH005', N'Nguyễn Dục Việt', 1, '0907748105', 'vietnguyen105@gmail.com', 'TPHCM'),
('KH006', N'Nguyễn Thành Đức', 1, '0756029760', 'thanhducng760@gmail.com', 'TPHCM'),
('KH007', N'Trịnh Như Ngọc', 0, '0754463494', 'trinhngoc494@gmail.com', 'TPHCM');

Insert into NhanVien values 
('NV001', N'Nguyễn Khánh Phương', 0, '0751604119', 'phuongng119@gmail.com', 'TPHCM'),
('NV002', N'Lý Thành Hưng', 1, '0752867999', 'lythanhhung999@gmail.com', 'TPHCM'),
('NV003', N'Trần Gia Hòa', 1, '0901501731', 'hoatran731@gmail.com', 'TPHCM'),
('NV004', N'Hồ Xuân Mai', 0, '0904957158', 'maiho158@gmail.com', 'TPHCM'),
('NV005', N'Mai Minh Huyền', 0, '0903908870', 'huyen870@gmail.com', 'TPHCM');

Insert into LoaiBan values
(0, 2),
(1, 4),
(2, 8),
(3, 16);

Insert into Ban(MaBan, TenBan, MaLB) values 
('BN001', 'Ban A1', 0),
('BN002', 'Ban A2', 0),
('BN003', 'Ban A3', 0),
('BN004', 'Ban B1', 1),
('BN005', 'Ban B2', 1),
('BN006', 'Ban C1', 2),
('BN007', 'Ban D1', 3);

Insert into LoaiSP values
(1, N'Khai vị'),
(2, N'Món chính'),
(3, N'Món phụ'),
(4, N'Đồ ngọt'),
(5, N'Nước giải khát'),
(6, N'Đồ uống có cồn');

Insert into SanPham values 
('SP001', N'Sủi cảo cá hồi', 50000, 1),
('SP002', N'Sủi cảo tôm', 30000, 1),
('SP003', N'Xà lách tôm hùm sốt tỏi', 50000, 1),
('SP004', N'Súp miso', 40000, 1),
('SP005', N'Súp hành tỏi', 30000, 1),
('SP006', N'Xà lách cá ngừ', 40000, 1),
('SP007', N'Xà lách dầu giấm', 35000, 1),
('SP008', N'Súp trứng', 40000, 1),
('SP009', N'Thăn bò sốt vang', 110000, 2),
('SP010', N'Pizza gà phủ phô mai', 80000, 2),
('SP011', N'Pizza hải sản', 90000, 2),
('SP012', N'Cá hồi phi lê', 100000, 2),
('SP013', N'Đùi gà sốt BBQ', 70000, 2),
('SP014', N'Bò và nấm', 90000, 2),
('SP015', N'Mỳ ý sốt bò bằm', 80000, 2),
('SP016', N'Mỳ ý sốt phô mai', 70000, 2),
('SP017', N'Mỳ ý hải sản', 90000, 2),
('SP018', N'Thịt cừu hầm rượu', 100000, 2),
('SP019', N'Sườn cừu nướng', 110000, 2),
('SP020', N'Bánh mỳ sốt bơ tỏi', 40000, 3),
('SP021', N'Bánh mỳ sốt nấm', 30000, 3),
('SP022', N'Khoai tây chiên', 40000, 3),
('SP023', N'Bắp cải xào', 30000, 3),
('SP024', N'Cháo gà', 40000, 3),
('SP025', N'Cơm trắng', 20000, 3),
('SP026', N'Cơm ngũ vị', 50000, 3),
('SP027', N'Thịt 7 loại', 60000, 3),
('SP028', N'Mouse chanh dây', 50000, 4),
('SP029', N'Tiramiru trà xanh', 50000, 4),
('SP030', N'Bánh quy chocolate', 40000, 4),
('SP031', N'Bánh quy vanilla', 40000, 4),
('SP032', N'Kem dâu tây', 50000, 4),
('SP033', N'Kem bạc hà', 50000, 4),
('SP034', N'Kem chocolate', 50000, 4),
('SP035', N'Cupcake đặc biệt', 70000, 4),
('SP036', N'Kem 3 vị', 70000, 4),
('SP037', N'Coca', 35000, 5),
('SP038', N'Pepsi', 35000, 5),
('SP039', N'7UP', 35000, 5),
('SP040', N'Trà chanh mật ong', 40000, 5),
('SP041', N'Trà đào', 50000, 5),
('SP042', N'Trà vải', 50000, 5),
('SP043', N'Nước suối', 25000, 5),
('SP044', N'Rượu vang đỏ', 70000, 6),
('SP045', N'Rượu vang trắng', 70000, 6),
('SP046', N'Rượu whiskey', 70000, 6),
('SP047', N'Rượu gin', 70000, 6),
('SP048', N'Rượu rum', 70000, 6),
('SP049', N'Tiger', 50000, 6),
('SP050', N'Strongbow', 50000, 6),
('SP051', N'Cá hồi đút lò', 110000, 2);

Insert into HoaDon values 
('HD001', 'KH001', 'NV001', 'BN004', 1),
('HD002', 'KH001', 'NV002', 'BN001', 1),
('HD003', 'KH002', 'NV002', 'BN001', 1),
('HD004', 'KH002', 'NV001', 'BN002', 0),
('HD005', 'KH001', 'NV001', 'BN001', 0),
('HD006', 'KH004', 'NV001', 'BN001', 0),
('HD007', 'KH003', 'NV004', 'BN005', 1);

Insert into CTHD values
('HD001', 'SP001', 1), ('HD001', 'SP003', 1), ('HD001', 'SP004', 1), ('HD001', 'SP012', 1), ('HD001', 'SP017', 1),
('HD001', 'SP022', 1), ('HD001', 'SP027', 1), ('HD001', 'SP030', 1), ('HD001', 'SP037', 1), ('HD001', 'SP042', 1),
('HD002', 'SP001', 1), ('HD002', 'SP002', 3), ('HD002', 'SP003', 4), ('HD003', 'SP002', 4), ('HD003', 'SP003', 1), 
('HD003', 'SP008', 1), ('HD003', 'SP017', 1), ('HD003', 'SP018', 1), ('HD003', 'SP021', 1), ('HD003', 'SP023', 1), 
('HD003', 'SP046', 2), ('HD004', 'SP001', 1), ('HD004', 'SP004', 1), ('HD004', 'SP009', 1), ('HD004', 'SP019', 1), 
('HD004', 'SP020', 1), ('HD004', 'SP022', 1), ('HD004', 'SP028', 1), ('HD004', 'SP040', 1), ('HD004', 'SP044', 1), 
('HD006', 'SP004', 1), ('HD006', 'SP011', 1), ('HD006', 'SP024', 1), ('HD006', 'SP035', 2), ('HD006', 'SP047', 2), 
('HD007', 'SP005', 1), ('HD007', 'SP006', 1), ('HD007', 'SP010', 1), ('HD007', 'SP013', 1), ('HD007', 'SP022', 3), 
('HD007', 'SP036', 1), ('HD007', 'SP037', 2), ('HD007', 'SP039', 1), ('HD007', 'SP051', 1);

Insert into LoaiTK values
(0,'Admin'),
(1,'Staff'),
(2,'Customer');

Insert into TaiKhoan (TenDN, MatKhau, MaLTK, MaTK) values
('admin', '123', 0, 'NV001'),
('staff01', '456', 1, 'NV002'),
('staff02', '456', 1, 'NV003'),
('staff03', '456', 1, 'NV004'),
('user01', '789', 2, 'KH001'),
('user02', '789', 2, 'KH002'),
('user03', '789', 2, 'KH003');

Insert into LichSu(TaiKhoan, HanhDong, ChiTiet) values
('NV001', 0, 'DangNhap'),
('NV001', 1, 'DangXuat');
GO
CREATE VIEW HDTong AS
SELECT HD.MaHD, HD.MaKH, HD.MaNV, HD.MaBan, HD.TrangThai, SUM(DonGia * SoLuong) AS TONGTIEN
FROM HoaDon as HD, CTHD, SanPham as SP
WHERE HD.MaHD = CTHD.MaHD AND CTHD.MaSP = SP.MaSP
GROUP BY HD.MaHD, HD.MaKH, HD.MaNV, HD.MaBan, HD.TrangThai

GO
CREATE VIEW CTHDTien AS
SELECT CT.MaHD, CT.MaSP, DonGia, SoLuong, SoLuong * DonGia AS THANHTIEN
FROM CTHD AS CT, SANPHAM AS SP
WHERE CT.MaSP = SP.MaSP