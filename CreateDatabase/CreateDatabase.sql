USE BanDoGiaDung
GO
CREATE TABLE [dbo].[Users] (
  [UserId]	INT    NOT NULL,
  [UserName]	NVARCHAR (255) NOT NULL,
  [Password]	NVARCHAR (255) NOT NULL,
  [IsSeller]	INT NOT NULL,
  [IsAdmin]	INT NOT NULL,
  PRIMARY KEY CLUSTERED ([UserId] ASC)
);
GO
CREATE TABLE [dbo].[Category] (
  [CategoryId]  INT    NOT NULL,
	[CategoryName]	NVARCHAR (255) NOT NULL,
	[Icon]			NVARCHAR (255) NULL
  PRIMARY KEY CLUSTERED ([CategoryId] ASC)
);
GO
CREATE TABLE [dbo].[Orders] (
  [OrderId]	INT    NOT NULL,
  [UserId]	INT NOT NULL,
  [OrderDate]	DATE NOT NULL,
  [Status]	INT    NOT NULL,
  PRIMARY KEY CLUSTERED ([OrderId] ASC),
  CONSTRAINT [Nguoi_mua] FOREIGN KEY ([UserId]) REFERENCES [dbo].[Users] ([UserId])
);
GO
CREATE TABLE [dbo].[Product] (
  [ProductId]		INT NOT NULL,
  [ProductName]	NVARCHAR (255) NOT NULL, 
  [Description]	NTEXT NOT NULL,
  [Price]			INT NOT NULL,
  [ImageLink]		NVARCHAR (255) NULL,
  [CategoryId]  INT NOT NULL,
  [SellerID]  INT NOT NULL,
  [Amount]  INT NOT NULL,
	[InStock]  INT NOT NULL,
  PRIMARY KEY CLUSTERED ([ProductId] ASC),
	CONSTRAINT [Nguoi_ban] FOREIGN KEY ([SellerID]) REFERENCES [dbo].[Users] ([UserId]),
	CONSTRAINT [Loai_sp] FOREIGN KEY ([CategoryId]) REFERENCES [dbo].[Category] ([CategoryId])
);
GO
CREATE TABLE [dbo].[OrderItem] (
  [ItemId]	INT NOT NULL,
  [Quantity] INT NOT NULL,
  [UnitPrice] INT NOT NULL,
	[ProductId] INT NOT NULL,
	[OrderID]	INT NOT NULL,
	[Status]	INT    NOT NULL,
  PRIMARY KEY CLUSTERED ([ItemId] ASC),
	CONSTRAINT [san_Pham] FOREIGN KEY ([ProductId]) REFERENCES [dbo].[Product] ([ProductId]),
	CONSTRAINT [don_hang] FOREIGN KEY ([OrderID]) REFERENCES [dbo].[Orders] ([OrderId])
);
GO
