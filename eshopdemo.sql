USE [master]
GO

/****** Object:  Database [eShopDemo]    Script Date: 12/12/2019 12:07:46 AM ******/
CREATE DATABASE [eShopDemo]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'eShopDemo', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\eShopDemo.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'eShopDemo_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\eShopDemo_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

ALTER DATABASE [eShopDemo] SET COMPATIBILITY_LEVEL = 110
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [eShopDemo].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [eShopDemo] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [eShopDemo] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [eShopDemo] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [eShopDemo] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [eShopDemo] SET ARITHABORT OFF 
GO

ALTER DATABASE [eShopDemo] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [eShopDemo] SET AUTO_CREATE_STATISTICS ON 
GO

ALTER DATABASE [eShopDemo] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [eShopDemo] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [eShopDemo] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [eShopDemo] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [eShopDemo] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [eShopDemo] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [eShopDemo] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [eShopDemo] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [eShopDemo] SET  DISABLE_BROKER 
GO

ALTER DATABASE [eShopDemo] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [eShopDemo] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [eShopDemo] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [eShopDemo] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [eShopDemo] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [eShopDemo] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [eShopDemo] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [eShopDemo] SET RECOVERY SIMPLE 
GO

ALTER DATABASE [eShopDemo] SET  MULTI_USER 
GO

ALTER DATABASE [eShopDemo] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [eShopDemo] SET DB_CHAINING OFF 
GO

ALTER DATABASE [eShopDemo] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [eShopDemo] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO

ALTER DATABASE [eShopDemo] SET  READ_WRITE 
GO

