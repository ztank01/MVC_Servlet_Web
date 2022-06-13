USE [master]
GO
/****** Object:  Database [BanDoGiaDung]    Script Date: 16/12/2021 09:09:43 ******/
CREATE DATABASE [BanDoGiaDung]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BanDoGiaDung', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\BanDoGiaDung.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BanDoGiaDung_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\BanDoGiaDung_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [BanDoGiaDung] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BanDoGiaDung].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BanDoGiaDung] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET ARITHABORT OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BanDoGiaDung] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BanDoGiaDung] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BanDoGiaDung] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BanDoGiaDung] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET RECOVERY FULL 
GO
ALTER DATABASE [BanDoGiaDung] SET  MULTI_USER 
GO
ALTER DATABASE [BanDoGiaDung] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BanDoGiaDung] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BanDoGiaDung] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BanDoGiaDung] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BanDoGiaDung] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BanDoGiaDung] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'BanDoGiaDung', N'ON'
GO
ALTER DATABASE [BanDoGiaDung] SET QUERY_STORE = OFF
GO
USE [BanDoGiaDung]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 16/12/2021 09:09:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CategoryId] [int] NOT NULL,
	[CategoryName] [nvarchar](255) NOT NULL,
	[Icon] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderItem]    Script Date: 16/12/2021 09:09:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderItem](
	[ItemId] [int] NOT NULL,
	[Quantity] [int] NOT NULL,
	[UnitPrice] [int] NOT NULL,
	[ProductId] [int] NOT NULL,
	[OrderID] [int] NOT NULL,
	[Status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ItemId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 16/12/2021 09:09:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderId] [int] NOT NULL,
	[UserId] [int] NOT NULL,
	[OrderDate] [date] NOT NULL,
	[Status] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 16/12/2021 09:09:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductId] [int] NOT NULL,
	[ProductName] [nvarchar](255) NOT NULL,
	[Description] [ntext] NOT NULL,
	[Price] [int] NOT NULL,
	[ImageLink] [nvarchar](255) NULL,
	[CategoryId] [int] NOT NULL,
	[SellerID] [int] NOT NULL,
	[Amount] [int] NOT NULL,
	[InStock] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 16/12/2021 09:09:43 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserId] [int] NOT NULL,
	[UserName] [nvarchar](255) NOT NULL,
	[Password] [nvarchar](255) NOT NULL,
	[IsSeller] [int] NOT NULL,
	[IsAdmin] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Category] ([CategoryId], [CategoryName], [Icon]) VALUES (1, N'Đồ gia dụng nhà bếp', NULL)
INSERT [dbo].[Category] ([CategoryId], [CategoryName], [Icon]) VALUES (2, N'Đồ gia dụng lớn', NULL)
INSERT [dbo].[Category] ([CategoryId], [CategoryName], [Icon]) VALUES (3, N'Máy hút bụi & Thiết bị làm sạch', NULL)
INSERT [dbo].[Category] ([CategoryId], [CategoryName], [Icon]) VALUES (4, N'Quạt & Máy nóng lạnh', NULL)
INSERT [dbo].[Category] ([CategoryId], [CategoryName], [Icon]) VALUES (5, N'Thiết bị chăm sóc quần áo', NULL)
INSERT [dbo].[Category] ([CategoryId], [CategoryName], [Icon]) VALUES (6, N'Khác', NULL)
GO
INSERT [dbo].[OrderItem] ([ItemId], [Quantity], [UnitPrice], [ProductId], [OrderID], [Status]) VALUES (1, 2, 70, 11, 1, 0)
INSERT [dbo].[OrderItem] ([ItemId], [Quantity], [UnitPrice], [ProductId], [OrderID], [Status]) VALUES (2, 1, 2490, 1, 1, 1)
INSERT [dbo].[OrderItem] ([ItemId], [Quantity], [UnitPrice], [ProductId], [OrderID], [Status]) VALUES (3, 1, 1190, 12, 2, 1)
INSERT [dbo].[OrderItem] ([ItemId], [Quantity], [UnitPrice], [ProductId], [OrderID], [Status]) VALUES (4, 1, 12001, 5, 3, 2)
GO
INSERT [dbo].[Orders] ([OrderId], [UserId], [OrderDate], [Status]) VALUES (1, 3, CAST(N'2021-12-05' AS Date), 0)
INSERT [dbo].[Orders] ([OrderId], [UserId], [OrderDate], [Status]) VALUES (2, 3, CAST(N'2021-12-05' AS Date), 1)
INSERT [dbo].[Orders] ([OrderId], [UserId], [OrderDate], [Status]) VALUES (3, 3, CAST(N'2021-12-07' AS Date), 2)
GO
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (1, N'Lò vi sóng Sharp cơ R205VN 20 lít', N'Lò vi sóng Sharp - Sản phẩm tiện lợi cần thiết cho căn bếp của bạn!
Thiết kế đẹp mắt, tiết kiệm không gian, kiểu dáng lò nhỏ gọn rất thuận tiện cho việc lắp đặt và vệ sinh. Máu xám trung tính phù hợp nhiều không gian bếp.
Khoang lò có dung tích 20 lít cùng đĩa xoay thủy tinh có đèn chiếu sáng vô cùng hiện đại giúp thức ăn được chín đều và ngon hơn. 
Bạn có thể tùy chỉnh 1 trong 3 chức năng của lò là nấu, hâm nóng và rã đông với 5 mức công suất phù hợp, tối đa là 800 W giúp tiết kiệm nhiều thời gian nấu nướng.', 2490, N'sp1.jpg', 1, 2, 99, 100)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (2, N'Bếp từ AMOI cao cấp', N'Bếp từ đơn công suất 2600W
Mặt bếp bằng kính chịu nhiệt cho khả năng chịu được nhiệt độ cao.
Hiệu suất sử dụng năng lượng lên đến 95% tiết kiệm điện năng tiêu thụ.', 425, N'sp2.jpg', 1, 2, 100, 50)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (3, N'Nồi chiên không dầu dung tích 6 lít CAMEL', N'Nồi áp dụng công nghệ Rapid Air độc đáo cho phép bạn rán, nướng bánh, nướng và quay những món ăn nhanh ngon nhất và những bữa ăn có ít chất béo hơn bằng việc sử dụng ít dầu hoặc không có dầu! Nồi chiên không dầu CAMEL với công nghệ Rapid Air cũng tạo ra ít mùi hơn so với nồi chiên thông thường, nồi dễ vệ sinh, an toàn và tiết kiệm cho việc sử dụng hàng ngày.
 Chức năng hẹn giờ tích hợp cho phép bạn đặt sẵn thời gian nấu lên đến 30 phút. Chức năng tự động tắt có cả chỉ báo âm thanh "sẵn sàng". Điều khiển nhiệt độ hoàn toàn có thể điều chỉnh cho phép bạn đặt trước nhiệt độ nấu ăn tốt nhất cho thức ăn lên đến 200 độ. Thưởng thức những miếng rán giòn, vàng ươm, món ăn nhanh, gà, thịt và nhiều món khác - tất cả đều được chế biến với thời gian và nhiệt độ phù hợp để cho kết quả tốt nhất
 Không chỉ tuyệt vời khi rán, nồi chiên không dầu  CAMEL đổi mới với công nghệ Rapid Air còn cho phép bạn quay, nướng bánh và nướng những món ăn ưa thích.
 Thiết kế độc đáo của nồi chiên kết hợp luồng khí được làm nóng rất cao lưu thông nhanh, thiết kế hình sao và cấu hình làm nóng tối ưu cho phép bạn rán nhiều món ăn ngon miệng khác nhau theo cách nhanh chóng, dễ dàng và lành mạnh cho sức khỏe mà không cần thêm dầu
 Ngăn kéo ra phủ lớp chống dính có thể tháo rời và giỏ thức ăn có thể rửa được bằng máy rửa chén, giúp vệ sinh dễ dàng.', 1074, N'sp3.jpg', 1, 2, 50, 100)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (4, N'Máy cạo râu sk1588', N'ĐẶC ĐIỂM NỔI BẬT CỦA MÁY CẠO RÂU SHAVER SK1588
------------------------------
•  Chất liệu hợp kim + Nhựa bền ABS
•  Có thể sạc lại: pin sạc 4h dùng được 60 phút, tương đương với 30 lần cạo
nếu 2 ngày cạo 1 lần thì 2 tháng mới phải sạc 1 lần
•  Cấu trúc phân lớp, lưỡi kép 4D thông minh, giúp cạo nhanh sạch sẽ
•  3 lưỡi kép đồng bộ bằng hợp kim không gỉ
•  ĐẶC BIỆT: TỰ ĐỘNG MÀI LƯỠI CẠO: => không còn sự cùn, không cần thay lưỡi
•  Đầu cạo quay 360 độ, mọi hướng góc, giúp vệ sinh mọi vị trí trên mặt  (cực kỳ thuận tiện)
•  Chống nước tương đương cấp độ IPX7: dễ dang vệ sinh cọ rửa
•  Khóa an toàn
•  LED báo sạc
•  Được thiết kế hướng thế hệ mới
•  TẶNG KÈM: đầu tỉa lông mũi và tông đơ cắt tóc tiện dụng', 229, N'sp4.jpg', 3, 2, 150, 99)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (5, N'ECOVACS DEEBOT T8 AIVI PLUS Robot hút bụi lau nhà thông minh', N'Deebot T8 AIVI Plus là sự kết hợp giữa trí tuệ nhân tạo ”AIVI” và một cỗ máy làm sạch hoàn hảo:
✅ Công nghệ trí tuệ nhân tạo AIVI thế hệ mới, nhận dạng vật nhanh hơn 2 lần.
✅ Hệ thống điều hướng Laser DtoF định vị vật xa gấp 2 lần: Deebot Ozmo T8 AIVI Plus được trang bị hệ thống AIVI nâng cao giúp robot nhận dạng các đồ vật như : Giầy, dép, tất, dây điện các loại,..
✅ Hệ thống làm sach tự động  “Auto-Emtry” – Tự động đổ rác: Một trong điểm mới của Ecovacs Deebot T8 Aivi Plus là tự động đổ rác. Bạn không cần phải cực khổ đổ rác hàng ngày nữa. thay vào hãy làm việc này hàng tháng.
✅ Tường ảo thông minh. Multi-floor Map lưu 3 bản đồ. 
✅ TrueMapping™ giúp robot lập bản đồ trực quan chính xác gấp 4 lần.
✅ Lựa chọn khu vực làm sạch: Sau khi hoàn thiện bản đồ Deebot T8 và lúc này, hãy làm sạch căn hộ của bạn theo cách bạn muốn. 
✅ Cải tiến thiết kế, khả năng vận hành ưu việt: Deebot Ozmo T8 AIVI Plus là thế hệ robot được cải tiến thiết kế. Chỉ cao hơn 9cm, khả năng vượt vật cản 2cm, máng hút và chổi chính thế hệ mới, giúp T8 vận hành ưu việt hơn và đạt hiệu năng tối đa.
✅ Trình quản lý Video Mannager: Camera của hệ thống AIVI hỗ trợ quay video gửi trực tiếp về điện thoại của bạn qua trình quản lý "video Manager" trên App Ecovacs Home. ', 12001, N'sp5.jpg', 3, 2, 15, 50)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (6, N'Máy hút bụi cầm tay mini xe hơi PH16 Hoco', N'Các loại máy hút bụi thông thường không thể làm sạch các vị trí nhỏ trên xe ô tô bởi kích thước khá lớn. Tuy nhiên Máy hút bụi cầm tay xe hơi Hoco PH16 chính hãng với thiết kế nhỏ gọn. lực hút mạnh dễ dàng len lỏi vào nhiều ngóc ngách nhỏ và làm sạch triệt để, giúp việc vệ sinh ô tô của bạn trở nên dễ dàng hơn.', 539, N'sp6.jpg', 3, 2, 200, 15)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (7, N'Tủ Lạnh Mini Hyundai Chính Hãng', N'ĐẶC ĐIỂM SẢN PHẨM
- Sử dụng công nghệ độc quyền tiên tiến, không tạo ra khí có hại với môi trường và người sử dụng. 
- Hạn chế tối đa tiếng ồn khi hoạt động, tiếng ồn tối đa chỉ tương đương 50 db.
- Tính năng giữ nhiệt: ngoài việc làm lạnh thấp nhất là 5-10°C, tủ lạnh mini HYUNDAI còn có thêm tính năng giữ nhiệt. Tủ có thể giữ ấm được cafe, đồ uống, thức ăn... ở mức nhiệt độ cao nhất là 65°C.
- Nguồn điện: Tủ được trang bị 2 dây nguồn, 1 dây cắm trực tiếp vào dòng điện lưới gia đình 220v, 1 dây còn lại cắm vào tẩu sạc 12v trên ô tô  (Không dùng cho tẩu sạc 24v).
- Tủ có màn hình LED cảm ứng tại mặt trước, có điều chỉnh nhiệt độ bằng cảm ứng, hiển thị nhiệt độ đầy đủ (mẫu 20l).', 2850, N'sp7.jpg', 2, 2, 50, 200)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (8, N'Tủ sấy quần áo Sunhouse SHD2707', N'Tủ sấy quần áo Sunhouse SHD2707, Có điều khiển cỡ lớn mẫu mới nhất năm 2021, Công suất 1400W, Sấy tối đa 15 kg, Melima', 1599, N'sp8.jpg', 2, 2, 10, 100)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (9, N'Máy giặt mini bán tự động', N'Máy giặt mini bán tự động, Dung tích 7L giặt nhanh sạch không tốn điện nước. Gọn nhẹ để trong gia đình, phù hợp với gia đình có trẻ nhỏ 
Mô phỏng động tác giặt tay, nước xoáy đánh bật vết bẩn cứng đầu ', 1650, N'sp9.jpg', 2, 2, 50, 99)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (10, N'Remote điều khiển MR21GC', N'Thời gian giao hàng dự kiến cho sản phẩm này là từ 7-9 ngày

Xin chào! Hân hạnh được gặp bạn! Chào mừng đến với cửa hàng của chúng tôi!
Theo dõi cửa hàng của chúng tôi mỗi ngày để cập nhật các sản phẩm mới nhất.
Chúng tôi đảm bảo đạo đức kinh doanh, nơi giá cả luôn phải chăng và hợp lý.
Đừng lo lắng! Đảm bảo bạn sẽ hài lòng với chất lượng sản phẩm của chúng tôi.
Vui lòng liên hệ với chúng tôi nếu bạn có thắc mắc nhé.
Chúc một ngày tốt lành và đừng quên cho chúng tôi 5 sao nếu bạn thích sản phẩm của chúng tôi.
Cảm ơn bạn đã đến thăm cửa hàng! Hy vọng bạn có một trải nghiệm mua sắm xuất sắc!
 
 Hàng mới chính hãng.
 Chúng tôi đã kiểm tra chức năng sản phẩm rồi.
 Sản phẩm được đảm bảo.', 400, N'sp10.jpg', 6, 2, 10, 99)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (11, N'Đèn nháy trang trí giáng sinh, cây thông, phòng ngủ, decor ngoài trời cắm điện Pin bóng bi tròn hoặc đom đóm GD175 GD177', N'Đèn nháy trang trí giáng sinh, cây thông, phòng ngủ, ngoài trời cắm điện hoặc dùng Pin bóng bi tròn hoặc đom đóm
', 70, N'sp11.jpg', 6, 2, 147, 998)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (12, N'Máy rửa xe mini, máy rửa xe gia đình Panansonic 2500W', N'MÁY RỬA XE PANASONIC 2500W', 1190, N'sp12.jpg', 6, 2, 5, 50)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (13, N'Bàn là Sunhouse SHD1072', N'Bàn là có chế độ điều chỉnh nhiệt độ linh hoạt và tiện dụng
- Bề mặt bàn ủi chống dính, trượt êm trên mọi loại vải
- Thiết kế mũi nhọn và rãnh cúc áo, là phẳng mọi chi tiết nhỏ
- An toàn tuyệt đối khi sử dụng
- Bàn là khô SUNHOUSE SHD1072P là thiết bị gia dụng thiết yếu trong mỗi gia đình. Với công suất lớn dễ dàng điều chỉnh bằng núm xoay, mặt bàn là chống dính lướt êm trên mọi mặt vải, dây điện chắc chắn an toàn, sản phẩm có khả năng ủi là nhanh hơn hẳn so với bàn là thường, xóa nhanh các nếp nhăn quần áo mà không làm phai màu, giữ mùi thơm của quần áo lâu dài.
- Bề mặt bàn là được phủ lớp chống dính siêu bền, giúp bàn là trượt êm trên mọi chất liệu, tránh làm cháy xém quần áo, hạn chế bóng vải và dễ dàng vệ sinh khi cần thiết.
- Bàn là còn được trang bị thêm một đèn hiển thị báo nhiệt độ đã đủ nóng để tiến hành là ủi hay chưa. Tùy thuộc vào chế độ là mà bạn lựa chọn, sản phẩm sẽ mất 1 thời gian nhất định để làm nóng nhưng rất nhanh chóng, tiết kiệm thời gian và điện năng.
- Bàn ủi Sunhouse SHD1072 là sự lựa chọn đơn giản và hoàn hảo cho mỗi gia đình.', 145, N'sp13.jpg', 5, 2, 20, 78)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (14, N'Bàn là hơi nước Yangzi', N'Bàn là hơi nước Yangzi, công suất 1800W ủi các loại quần áo, bàn ủi hơi nước cây đứng tự ngắt khi quá tải nhiệt', 425, N'sp14.jpg', 5, 2, 45, 27)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (15, N'Bàn là hơi nước cầm tay', N'Bàn là hơi nước cầm tay hàng nhập khẩu chính hãng, nhỏ gọn khi mang đi du lịch thiết kế hiện đại hơi nước mạnh', 388, N'sp15.jpg', 5, 2, 99, 15)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (16, N'Quạt tản nhiệt gaming cho điện thoại DL01 DL TECH', N'Quạt tản nhiệt gaming cho điện thoại, tản nhiệt sò lạnh siêu mát DL01', 215, N'sp16.jpg', 4, 2, 107, 245)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (17, N'Máy lọc không khí AP T20 Homedics Mỹ', N'Máy lọc không khí HoMedics AP -T20 - Màu trắng - Nhập Khẩu Mỹ', 4750, N'sp17.jpg', 4, 2, 85, 277)
INSERT [dbo].[Product] ([ProductId], [ProductName], [Description], [Price], [ImageLink], [CategoryId], [SellerID], [Amount], [InStock]) VALUES (18, N'Đèn Sưởi 2 Bóng Kaimeidi Hàng Nội Địa- 800W', N'Đèn Sưởi 2 Bóng Kaimeidi Hàng Nội Địa Công Suất 800W  Quạt Sưởi Halogen Siêu Bền Tỏa Nhiệt Đều Tiết Kiệm Điện Gấp 2 Lần', 218, N'sp18.jpg', 4, 2, 378, 124)
GO
INSERT [dbo].[Users] ([UserId], [UserName], [Password], [IsSeller], [IsAdmin]) VALUES (1, N'admin', N'202cb962ac59075b964b07152d234b70', 0, 1)
INSERT [dbo].[Users] ([UserId], [UserName], [Password], [IsSeller], [IsAdmin]) VALUES (2, N'seller', N'202cb962ac59075b964b07152d234b70
', 1, 0)
INSERT [dbo].[Users] ([UserId], [UserName], [Password], [IsSeller], [IsAdmin]) VALUES (3, N'user', N'202cb962ac59075b964b07152d234b70', 0, 0)
GO
ALTER TABLE [dbo].[OrderItem]  WITH CHECK ADD  CONSTRAINT [don_hang] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderId])
GO
ALTER TABLE [dbo].[OrderItem] CHECK CONSTRAINT [don_hang]
GO
ALTER TABLE [dbo].[OrderItem]  WITH CHECK ADD  CONSTRAINT [san_Pham] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([ProductId])
GO
ALTER TABLE [dbo].[OrderItem] CHECK CONSTRAINT [san_Pham]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [Nguoi_mua] FOREIGN KEY([UserId])
REFERENCES [dbo].[Users] ([UserId])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [Nguoi_mua]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [Loai_sp] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Category] ([CategoryId])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [Loai_sp]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [Nguoi_ban] FOREIGN KEY([SellerID])
REFERENCES [dbo].[Users] ([UserId])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [Nguoi_ban]
GO
USE [master]
GO
ALTER DATABASE [BanDoGiaDung] SET  READ_WRITE 
GO
