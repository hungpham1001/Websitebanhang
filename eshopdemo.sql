USE [master]
GO
/****** Object:  Database [learningHibernate]    Script Date: 11/12/2019 5:56:45 CH ******/
CREATE DATABASE [learningHibernate]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'learningHibernate', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\learningHibernate.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'learningHibernate_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\learningHibernate_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [learningHibernate] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [learningHibernate].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [learningHibernate] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [learningHibernate] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [learningHibernate] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [learningHibernate] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [learningHibernate] SET ARITHABORT OFF 
GO
ALTER DATABASE [learningHibernate] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [learningHibernate] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [learningHibernate] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [learningHibernate] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [learningHibernate] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [learningHibernate] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [learningHibernate] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [learningHibernate] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [learningHibernate] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [learningHibernate] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [learningHibernate] SET  DISABLE_BROKER 
GO
ALTER DATABASE [learningHibernate] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [learningHibernate] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [learningHibernate] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [learningHibernate] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [learningHibernate] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [learningHibernate] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [learningHibernate] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [learningHibernate] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [learningHibernate] SET  MULTI_USER 
GO
ALTER DATABASE [learningHibernate] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [learningHibernate] SET DB_CHAINING OFF 
GO
ALTER DATABASE [learningHibernate] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [learningHibernate] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [learningHibernate]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 11/12/2019 5:56:45 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[NameVN] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Categories] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Customers]    Script Date: 11/12/2019 5:56:45 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[Id] [nvarchar](20) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Fullname] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Photo] [nvarchar](50) NOT NULL,
	[Activated] [bit] NOT NULL,
	[Admin] [bit] NOT NULL,
 CONSTRAINT [PK_Customers] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 11/12/2019 5:56:45 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[OrderId] [int] NOT NULL,
	[ProductId] [int] NOT NULL,
	[UnitPrice] [float] NOT NULL,
	[Quantity] [int] NOT NULL,
	[Discount] [float] NOT NULL,
 CONSTRAINT [PK_OrderDetails] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Orders]    Script Date: 11/12/2019 5:56:45 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CustomerId] [nvarchar](20) NOT NULL,
	[OrderDate] [datetime] NOT NULL,
	[Address] [nvarchar](60) NOT NULL,
	[Amount] [float] NOT NULL,
	[Description] [nvarchar](1000) NULL,
 CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Products]    Script Date: 11/12/2019 5:56:45 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](60) NOT NULL,
	[UnitPrice] [float] NOT NULL,
	[Image] [nvarchar](50) NOT NULL,
	[ProductDate] [date] NOT NULL,
	[Available] [bit] NOT NULL,
	[CategoryId] [int] NOT NULL,
	[Quantity] [int] NOT NULL,
	[Description] [nvarchar](max) NULL,
	[Discount] [float] NOT NULL,
	[ViewCount] [int] NOT NULL,
	[Special] [bit] NOT NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetailsProduct] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetailsProduct]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_Orders] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([Id])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_Orders]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_OrdersCustomer] FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customers] ([Id])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_OrdersCustomer]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_CATEGORY] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Categories] ([Id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_CATEGORY]
GO
USE [master]
GO
ALTER DATABASE [learningHibernate] SET  READ_WRITE 
GO
