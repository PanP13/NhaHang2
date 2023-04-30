create database NhaHang1;
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
	MaLTK tinyint CHECK(MaLTK<2) NOT NULL,
	TenLTK nvarchar(50) NOT NULL,
	CONSTRAINT PK_MaLTK PRIMARY KEY(MaLTK)
);

create table TaiKhoan(
	IDTK int IDENTITY(1,1) PRIMARY KEY,
	TenDN varchar(50) UNIQUE NOT NULL,
	MatKhau varchar(50) NOT NULL,
	MaLTK tinyint CHECK (MaLTK<2) NOT NULL,
	MaTK char(5) NOT NULL,
	CONSTRAINT FK_MaTK_NV FOREIGN KEY (MaTK) REFERENCES NhanVien(MaNV),
	CONSTRAINT FK_MaLTK_ACC FOREIGN KEY (MaLTK) REFERENCES LoaiTK(MaLTK)
);

create table LoaiBan(
	MaLB char(3),
	SoGhe int,
	CONSTRAINT PK_MaLB PRIMARY KEY(MaLB)
);

create table Ban (
	MaBan char(5),
	TenBan nvarchar(50) NOT NULL,
	MaLB char(3),
	CONSTRAINT PK_MaBan PRIMARY KEY (MaBan),
	CONSTRAINT FK_MaLB FOREIGN KEY (MaLB) REFERENCES LoaiBan(MaLB)
);

create table LoaiSP(
	MaLSP char(3),
	TenLSP nvarchar(50) NOT NULL,
	CONSTRAINT PK_MaLSP PRIMARY KEY (MaLSP)
);

create table SanPham (
	MaSP char(5),
	TenSP nvarchar(50) NOT NULL,
	DonGia int DEFAULT(0),
	MaLSP char(3),
	CONSTRAINT PK_MaSP PRIMARY KEY (MaSP),
	CONSTRAINT FK_MaLSP FOREIGN KEY (MaLSP) REFERENCES LoaiSP(MaLSP)
);

create table HoaDon (
	MaHD char(5),
	MaKH char(5),
	MaNV char(5),
	MaBan char(5),
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

Insert into KhachHang values 
('KH001', 'Pan',  0, '1299680921', 'pan@gmail.com', 'TPHCM'),
('KH002', 'Rich', 1, '2557178005', 'rich@gmail.com', 'TPHCM'),
('KH003', 'Bell', 0, '8373309541', 'bell@gmail.com', 'TPHCM'),
('KH004', 'Luis', 1, '7574179115', 'luis@gmail.com', 'TPHCM'),
('KH005', 'John', 1, '3944577842', 'john@gmail.com', 'TPHCM');

Insert into NhanVien values 
('NV001', 'Nancy', 0, '9822035400', 'nancy@gmail.com', 'TPHCM'),
('NV002', 'Lucas', 1, '1414422682', 'lucas@gmail.com', 'TPHCM'),
('NV003', 'Olivia', 0, '1376948376', 'olivia@gmail.com', 'TPHCM'),
('NV004', 'Kyle', 1, '3950665453', 'kyle@gmail.com', 'TPHCM');

Insert into LoaiBan values
('LB1', 2),
('LB2', 4),
('LB3', 8),
('LB4', 16);

Insert into Ban values 
('BN001', 'Ban A1', 'LB1'),
('BN002', 'Ban A2', 'LB1'),
('BN003', 'Ban A3', 'LB1'),
('BN004', 'Ban B1', 'LB2'),
('BN005', 'Ban B2', 'LB2'),
('BN006', 'Ban C1', 'LB3'),
('BN007', 'Ban D1', 'LB4');

Insert into LoaiSP values
('LP1', 'Thức ăn'),
('LP2', 'Đồ ngọt'),
('LP3', 'Thức ăn vặt'),
('LP4', 'Nước uống');

Insert into SanPham values 
('SP001', 'Cơm chiên', 20000, 'LP1'),
('SP002', 'Cơm gà', 30000, 'LP1'),
('SP003', 'Coca', 10000, 'LP4'),
('SP004', 'Nước suối', 5000, 'LP4');

Insert into HoaDon values 
('HD001', 'KH001', 'NV001', 'BN001'),
('HD002', 'KH001', 'NV002', 'BN001'),
('HD003', 'KH002', 'NV002', 'BN001'),
('HD004', 'KH002', 'NV001', 'BN002');

Insert into CTHD values
('HD001', 'SP001', 2),
('HD001', 'SP003', 2),
('HD001', 'SP004', 1),
('HD002', 'SP001', 1),
('HD002', 'SP002', 3),
('HD002', 'SP003', 4),
('HD003', 'SP002', 4),
('HD003', 'SP003', 4),
('HD004', 'SP001', 1),
('HD004', 'SP004', 1);

Insert into LoaiTK values
(0,'Admin'),
(1,'Staff');

Insert into TaiKhoan (TenDN, MatKhau, MaLTK, MaTK) values
('admin', '123', 0, 'NV001'),
('staff001', '456', 1, 'NV002');
