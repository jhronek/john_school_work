-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 01, 2009 at 03:19 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9-2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pcparts`
--
CREATE DATABASE `pcparts` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pcparts`;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `custid` int(10) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `address` char(20) NOT NULL,
  `city` char(16) NOT NULL,
  `state` char(2) NOT NULL,
  `zip` char(5) NOT NULL,
  PRIMARY KEY (`custid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`custid`, `name`, `address`, `city`, `state`, `zip`) VALUES
(1, 'Smith, Tim', '12 Elm St', 'Tampa', 'FL', '34567'),
(2, 'Jones, Tom', '435 Oak Dr', 'Dunedin', 'FL', '33245'),
(3, 'Avery, Bill', '623 Ash Ave', 'Clearwater', 'FL', '33655'),
(4, 'Kerr, Debra', '1573 Yew Crt', 'Clearwater', 'FL', '33442');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `orderid` int(10) NOT NULL AUTO_INCREMENT,
  `custid` int(10) NOT NULL,
  `sku` char(5) NOT NULL,
  `quantity` int(10) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`orderid`, `custid`, `sku`, `quantity`, `date`) VALUES
(1, 2, 'C7615', 2, '2005-08-24'),
(2, 2, 'K9907', 1, '2005-08-24'),
(3, 3, 'C7615', 1, '2005-08-25'),
(4, 3, 'F0993', 1, '2005-08-25'),
(5, 1, 'B2245', 1, '2005-08-26');

-- --------------------------------------------------------

--
-- Table structure for table `parts`
--

CREATE TABLE IF NOT EXISTS `parts` (
  `sku` char(5) NOT NULL,
  `descrip` char(16) NOT NULL,
  `manuf` char(16) NOT NULL,
  `price` float(5,2) DEFAULT NULL,
  PRIMARY KEY (`sku`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parts`
--

INSERT INTO `parts` (`sku`, `descrip`, `manuf`, `price`) VALUES
('B2245', 'DVD Drive', 'Sony', 79.99),
('C7615', '1 GB Flash Dr', 'Sandisk', 49.95),
('F0993', 'Laptop Mouse', 'Logitech', 29.99),
('H2243', 'G router', 'Linksys', 59.99),
('U8872', 'G PC Card', 'Linksys', 54.95),
('K9907', '4 port USB Hub', 'Acer', 12.95);
