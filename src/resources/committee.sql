-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 07, 2018 at 03:13 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `committee`
--

-- --------------------------------------------------------

--
-- Table structure for table `committee`
--

CREATE TABLE IF NOT EXISTS `committee` (
  `COMMITTEE_ID` int(10) NOT NULL,
  `NAME` tinytext NOT NULL,
  `START_DATE` date DEFAULT NULL,
  `TOTAL_VALUE` decimal(20,0) DEFAULT '0',
  `INTEREST` decimal(20,2) DEFAULT '0.00',
  `REMAINING` int(20) NOT NULL DEFAULT '20'
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `committee`
--

INSERT INTO `committee` (`COMMITTEE_ID`, `NAME`, `START_DATE`, `TOTAL_VALUE`, `INTEREST`, `REMAINING`) VALUES
(1, 'FEB_27', '2018-02-27', '50000', '1.50', 19),
(7, 'MARCH', '2018-02-27', '100000', '1.50', 19),
(8, 'OCT', '2018-02-27', '50000', '1.20', 17),
(9, 'MARCH_1', '2018-03-01', '50000', '1.20', 19);

-- --------------------------------------------------------

--
-- Table structure for table `mapping`
--

CREATE TABLE IF NOT EXISTS `mapping` (
  `COMMITTEE_ID` int(10) NOT NULL,
  `CUST_ID` int(10) NOT NULL,
  `REMAINING` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mapping`
--

INSERT INTO `mapping` (`COMMITTEE_ID`, `CUST_ID`, `REMAINING`) VALUES
(1, 1, 1),
(1, 2, 0),
(1, 3, 1),
(1, 4, 1),
(1, 5, 1),
(1, 6, 1),
(1, 7, 1),
(1, 8, 1),
(1, 9, 1),
(1, 10, 1),
(1, 11, 1),
(1, 12, 1),
(1, 13, 1),
(1, 14, 1),
(1, 15, 1),
(1, 16, 1),
(1, 17, 1),
(1, 18, 1),
(1, 19, 1),
(1, 20, 1),
(7, 2, 1),
(7, 3, 1),
(7, 4, 1),
(7, 5, 1),
(7, 6, 1),
(7, 7, 1),
(7, 8, 1),
(7, 9, 1),
(7, 10, 1),
(7, 11, 1),
(7, 12, 1),
(7, 13, 1),
(7, 14, 1),
(7, 15, 1),
(7, 16, 1),
(7, 17, 1),
(7, 18, 1),
(7, 19, 0),
(7, 20, 1),
(7, 21, 1),
(8, 1, 1),
(8, 2, 1),
(8, 3, 1),
(8, 4, 0),
(8, 5, 1),
(8, 6, 0),
(8, 7, 1),
(8, 8, 1),
(8, 9, 1),
(8, 10, 1),
(8, 11, 1),
(8, 12, 1),
(8, 13, 1),
(8, 14, 1),
(8, 15, 1),
(8, 16, 1),
(8, 17, 0),
(8, 18, 1),
(8, 19, 1),
(8, 20, 1),
(9, 1, 1),
(9, 2, 1),
(9, 3, 1),
(9, 4, 1),
(9, 5, 1),
(9, 6, 1),
(9, 7, 1),
(9, 8, 1),
(9, 9, 1),
(9, 10, 1),
(9, 11, 1),
(9, 12, 1),
(9, 13, 0),
(9, 14, 1),
(9, 15, 1),
(9, 16, 1),
(9, 17, 1),
(9, 18, 1),
(9, 19, 1),
(9, 20, 1);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `ACC_NO` int(10) NOT NULL,
  `NAME` tinytext NOT NULL,
  `JOIN_DATE` date DEFAULT NULL,
  `BALANCE` decimal(20,0) DEFAULT '0',
  `ADDRESS` tinytext,
  `CONTACT` bigint(12) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`ACC_NO`, `NAME`, `JOIN_DATE`, `BALANCE`, `ADDRESS`, `CONTACT`) VALUES
(1, 'Rajesh', '2018-02-26', '-2550', 'Barhiya', 0),
(2, 'Prince', '2018-02-26', '17850', 'Malpur', 0),
(3, 'Rakesh', '2018-02-26', '-150', 'Khutaha', 0),
(4, 'Rajni', '2018-02-26', '-150', 'Malpur', 0),
(5, 'Rahul', '2018-02-26', '-7150', 'Khhutaha', 0),
(6, 'Ravi', '2018-02-26', '22850', 'Malpur', 0),
(7, 'Rakesh', '2018-02-26', '-3150', 'Malpur', 0),
(8, 'wsdg', '2018-02-27', '-8150', 'Piparia', 0),
(9, 'Singh', '2018-02-27', '-3150', 'Piparia', 0),
(10, 'Kumar', '2018-02-27', '-7150', 'Khutaha', 0),
(11, 'sskd', '2018-02-27', '-3150', 'Malpur', 0),
(12, 'kdsks', '2018-02-27', '-9250', 'Karari Piparia', 0),
(13, 'shws', '2018-02-27', '18650', 'Basona', 0),
(14, 'Priyanjay Singh', '2018-02-27', '1850', 'Malpur', 0),
(15, 'Shimpi', '2018-02-27', '-4150', 'Malpur', 0),
(16, 'Siku Singh', '2018-02-27', '-9650', 'Terasi', 0),
(17, 'Lalan Singh', '2018-02-27', '25850', 'Malpur', 0),
(18, 'Sintu Singh', '2018-02-27', '-2150', 'Piparia', 0),
(19, 'Mritunjay Kumar Singh', '2018-02-27', '54850', 'Malpur', 0),
(20, 'Bipin Singh', '2018-02-27', '-4750', 'Malpur', 0),
(21, 'Siku Singh', '2018-02-27', '4000', 'Terasi', 0),
(22, 'Surendra Singh', '2018-03-01', '5000', 'Terasi Piparia', 0),
(23, 'Suresh', '2018-03-02', '2000', 'Basona', 9563488268),
(24, 'King', '2018-03-02', '2000', 'Malpur', 7254950405),
(25, 'Gautam', '2018-03-02', '3000', 'Malpur', 8405123445),
(26, 'Anshu', '2018-03-04', '13', 'Khutaha Dih', 862387218462);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE IF NOT EXISTS `transaction` (
  `ACC_NO` int(10) NOT NULL,
  `TRANSACTION_ID` int(10) NOT NULL,
  `TYPE` tinytext NOT NULL,
  `TRANSACTION_DATE` date DEFAULT NULL,
  `AMOUNT` decimal(20,0) DEFAULT '0',
  `BALANCE` decimal(20,0) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`ACC_NO`, `TRANSACTION_ID`, `TYPE`, `TRANSACTION_DATE`, `AMOUNT`, `BALANCE`) VALUES
(1, 1, 'Openning', '2018-02-26', '2000', '2000'),
(1, 2, 'Cash Deposit', '2018-02-26', '2000', '4000'),
(2, 3, 'Openning', '2018-02-26', '3000', '3000'),
(3, 4, 'Openning', '2018-02-26', '5000', '5000'),
(4, 5, 'Openning', '2018-02-26', '10000', '10000'),
(5, 6, 'Openning', '2018-02-26', '3000', '3000'),
(6, 7, 'Openning', '2018-02-26', '3000', '3000'),
(7, 8, 'Openning', '2018-02-26', '4000', '4000'),
(8, 9, 'Openning', '2018-02-27', '2000', '2000'),
(9, 10, 'Openning', '2018-02-27', '7000', '7000'),
(7, 11, 'Cash Deposit', '2018-02-27', '2000', '6000'),
(7, 12, 'Cash Deposit', '2018-02-27', '1000', '7000'),
(10, 13, 'Openning', '2018-02-27', '3000', '3000'),
(11, 14, 'Openning', '2018-02-27', '7000', '7000'),
(12, 15, 'Openning', '2018-02-27', '900', '900'),
(13, 16, 'Openning', '2018-02-27', '800', '800'),
(14, 17, 'Openning', '2018-02-27', '10000', '10000'),
(15, 18, 'Openning', '2018-02-27', '6000', '6000'),
(16, 19, 'Openning', '2018-02-27', '500', '500'),
(17, 20, 'Openning', '2018-02-27', '6000', '6000'),
(18, 21, 'Openning', '2018-02-27', '7929329', '7929329'),
(19, 22, 'Openning', '2018-02-27', '5000', '5000'),
(20, 23, 'Openning', '2018-02-27', '400', '400'),
(21, 24, 'Openning', '2018-02-27', '5000', '5000'),
(21, 25, 'Cash Deposit', '2018-02-27', '2000', '7000'),
(1, 26, 'FEB_27 Share', '2018-02-28', '-1250', '2750'),
(2, 27, 'FEB_27 Share', '2018-02-28', '-1250', '1750'),
(3, 28, 'FEB_27 Share', '2018-02-28', '-1250', '3750'),
(4, 29, 'FEB_27 Share', '2018-02-28', '-1250', '8750'),
(5, 30, 'FEB_27 Share', '2018-02-28', '-1250', '1750'),
(6, 31, 'FEB_27 Share', '2018-02-28', '-1250', '1750'),
(7, 32, 'FEB_27 Share', '2018-02-28', '-1250', '5750'),
(8, 33, 'FEB_27 Share', '2018-02-28', '-1250', '750'),
(9, 34, 'FEB_27 Share', '2018-02-28', '-1250', '5750'),
(10, 35, 'FEB_27 Share', '2018-02-28', '-1250', '1750'),
(11, 36, 'FEB_27 Share', '2018-02-28', '-1250', '5750'),
(12, 37, 'FEB_27 Share', '2018-02-28', '-1250', '-350'),
(13, 38, 'FEB_27 Share', '2018-02-28', '-1250', '-450'),
(14, 39, 'FEB_27 Share', '2018-02-28', '-1250', '8750'),
(15, 40, 'FEB_27 Share', '2018-02-28', '-1250', '4750'),
(16, 41, 'FEB_27 Share', '2018-02-28', '-1250', '-750'),
(17, 42, 'FEB_27 Share', '2018-02-28', '-1250', '4750'),
(18, 43, 'FEB_27 Share', '2018-02-28', '-1250', '6750'),
(19, 44, 'FEB_27 Share', '2018-02-28', '-1250', '3750'),
(20, 45, 'FEB_27 Share', '2018-02-28', '-1250', '-850'),
(2, 46, 'Top Bid Deposit', '2018-02-28', '25000', '26750'),
(1, 47, 'OCT Share', '2018-02-28', '-1500', '1250'),
(2, 48, 'OCT Share', '2018-02-28', '-1500', '25250'),
(3, 49, 'OCT Share', '2018-02-28', '-1500', '2250'),
(4, 50, 'OCT Share', '2018-02-28', '-1500', '7250'),
(5, 51, 'OCT Share', '2018-02-28', '-1500', '250'),
(6, 52, 'OCT Share', '2018-02-28', '-1500', '250'),
(7, 53, 'OCT Share', '2018-02-28', '-1500', '4250'),
(8, 54, 'OCT Share', '2018-02-28', '-1500', '-750'),
(9, 55, 'OCT Share', '2018-02-28', '-1500', '4250'),
(10, 56, 'OCT Share', '2018-02-28', '-1500', '250'),
(11, 57, 'OCT Share', '2018-02-28', '-1500', '4250'),
(12, 58, 'OCT Share', '2018-02-28', '-1500', '-1850'),
(13, 59, 'OCT Share', '2018-02-28', '-1500', '-1950'),
(14, 60, 'OCT Share', '2018-02-28', '-1500', '7250'),
(15, 61, 'OCT Share', '2018-02-28', '-1500', '3250'),
(16, 62, 'OCT Share', '2018-02-28', '-1500', '-2250'),
(17, 63, 'OCT Share', '2018-02-28', '-1500', '3250'),
(18, 64, 'OCT Share', '2018-02-28', '-1500', '5250'),
(19, 65, 'OCT Share', '2018-02-28', '-1500', '2250'),
(20, 66, 'OCT Share', '2018-02-28', '-1500', '-2350'),
(6, 67, 'Top Bid Deposit', '2018-02-28', '30000', '30250'),
(3, 68, 'Cash Deposit', '2018-03-01', '3000', '5250'),
(20, 69, 'Cash Deposit', '2018-03-01', '5000', '2650'),
(14, 70, 'Cash Deposit', '2018-03-01', '2000', '9250'),
(1, 71, 'MARCH_1 Share', '2018-03-01', '-1400', '-150'),
(2, 72, 'MARCH_1 Share', '2018-03-01', '-1400', '23850'),
(3, 73, 'MARCH_1 Share', '2018-03-01', '-1400', '3850'),
(4, 74, 'MARCH_1 Share', '2018-03-01', '-1400', '5850'),
(5, 75, 'MARCH_1 Share', '2018-03-01', '-1400', '-1150'),
(6, 76, 'MARCH_1 Share', '2018-03-01', '-1400', '28850'),
(7, 77, 'MARCH_1 Share', '2018-03-01', '-1400', '2850'),
(8, 78, 'MARCH_1 Share', '2018-03-01', '-1400', '-2150'),
(9, 79, 'MARCH_1 Share', '2018-03-01', '-1400', '2850'),
(10, 80, 'MARCH_1 Share', '2018-03-01', '-1400', '-1150'),
(11, 81, 'MARCH_1 Share', '2018-03-01', '-1400', '2850'),
(12, 82, 'MARCH_1 Share', '2018-03-01', '-1400', '-3250'),
(13, 83, 'MARCH_1 Share', '2018-03-01', '-1400', '-3350'),
(14, 84, 'MARCH_1 Share', '2018-03-01', '-1400', '7850'),
(15, 85, 'MARCH_1 Share', '2018-03-01', '-1400', '1850'),
(16, 86, 'MARCH_1 Share', '2018-03-01', '-1400', '-3650'),
(17, 87, 'MARCH_1 Share', '2018-03-01', '-1400', '1850'),
(18, 88, 'MARCH_1 Share', '2018-03-01', '-1400', '3850'),
(19, 89, 'MARCH_1 Share', '2018-03-01', '-1400', '850'),
(20, 90, 'MARCH_1 Share', '2018-03-01', '-1400', '1250'),
(13, 91, 'Top Bid Deposit', '2018-03-01', '28000', '24650'),
(22, 92, 'Openning', '2018-03-01', '5000', '5000'),
(3, 93, 'Cash Deposit', '2018-03-01', '2000', '5850'),
(1, 94, 'Cash Deposit', '2018-03-01', '400', '250'),
(1, 95, 'Cash Deposit', '2018-03-01', '200', '450'),
(23, 96, 'Openning', '2018-03-02', '2000', '2000'),
(24, 97, 'Openning', '2018-03-02', '2000', '2000'),
(25, 98, 'Openning', '2018-03-02', '3000', '3000'),
(2, 99, 'MARCH Share', '2018-03-04', '-3000', '20850'),
(3, 100, 'MARCH Share', '2018-03-04', '-3000', '2850'),
(4, 101, 'MARCH Share', '2018-03-04', '-3000', '2850'),
(5, 102, 'MARCH Share', '2018-03-04', '-3000', '-4150'),
(6, 103, 'MARCH Share', '2018-03-04', '-3000', '25850'),
(7, 104, 'MARCH Share', '2018-03-04', '-3000', '-150'),
(8, 105, 'MARCH Share', '2018-03-04', '-3000', '-5150'),
(9, 106, 'MARCH Share', '2018-03-04', '-3000', '-150'),
(10, 107, 'MARCH Share', '2018-03-04', '-3000', '-4150'),
(11, 108, 'MARCH Share', '2018-03-04', '-3000', '-150'),
(12, 109, 'MARCH Share', '2018-03-04', '-3000', '-6250'),
(13, 110, 'MARCH Share', '2018-03-04', '-3000', '21650'),
(14, 111, 'MARCH Share', '2018-03-04', '-3000', '4850'),
(15, 112, 'MARCH Share', '2018-03-04', '-3000', '-1150'),
(16, 113, 'MARCH Share', '2018-03-04', '-3000', '-6650'),
(17, 114, 'MARCH Share', '2018-03-04', '-3000', '-1150'),
(18, 115, 'MARCH Share', '2018-03-04', '-3000', '850'),
(19, 116, 'MARCH Share', '2018-03-04', '-3000', '-2150'),
(20, 117, 'MARCH Share', '2018-03-04', '-3000', '-1750'),
(21, 118, 'MARCH Share', '2018-03-04', '-3000', '4000'),
(19, 119, 'Top Bid Deposit', '2018-03-04', '60000', '57850'),
(26, 120, 'Openning', '2018-03-04', '223', '223'),
(26, 121, 'Cash Deposit', '2018-03-04', '90', '313'),
(26, 122, 'Cash Withdraw', '2018-03-04', '-300', '13'),
(1, 123, 'OCT Share', '2018-03-04', '-1500', '-1050'),
(2, 124, 'OCT Share', '2018-03-04', '-1500', '19350'),
(3, 125, 'OCT Share', '2018-03-04', '-1500', '1350'),
(4, 126, 'OCT Share', '2018-03-04', '-1500', '1350'),
(5, 127, 'OCT Share', '2018-03-04', '-1500', '-5650'),
(6, 128, 'OCT Share', '2018-03-04', '-1500', '24350'),
(7, 129, 'OCT Share', '2018-03-04', '-1500', '-1650'),
(8, 130, 'OCT Share', '2018-03-04', '-1500', '-6650'),
(9, 131, 'OCT Share', '2018-03-04', '-1500', '-1650'),
(10, 132, 'OCT Share', '2018-03-04', '-1500', '-5650'),
(11, 133, 'OCT Share', '2018-03-04', '-1500', '-1650'),
(12, 134, 'OCT Share', '2018-03-04', '-1500', '-7750'),
(13, 135, 'OCT Share', '2018-03-04', '-1500', '20150'),
(14, 136, 'OCT Share', '2018-03-04', '-1500', '3350'),
(15, 137, 'OCT Share', '2018-03-04', '-1500', '-2650'),
(16, 138, 'OCT Share', '2018-03-04', '-1500', '-8150'),
(17, 139, 'OCT Share', '2018-03-04', '-1500', '-2650'),
(18, 140, 'OCT Share', '2018-03-04', '-1500', '-650'),
(19, 141, 'OCT Share', '2018-03-04', '-1500', '56350'),
(20, 142, 'OCT Share', '2018-03-04', '-1500', '-3250'),
(4, 143, 'Top Bid Deposit', '2018-03-04', '30000', '31350'),
(4, 144, 'Cash Withdraw', '2018-03-04', '-30000', '1350'),
(1, 145, 'OCT Share', '2018-03-04', '-1500', '-2550'),
(2, 146, 'OCT Share', '2018-03-04', '-1500', '17850'),
(3, 147, 'OCT Share', '2018-03-04', '-1500', '-150'),
(4, 148, 'OCT Share', '2018-03-04', '-1500', '-150'),
(5, 149, 'OCT Share', '2018-03-04', '-1500', '-7150'),
(6, 150, 'OCT Share', '2018-03-04', '-1500', '22850'),
(7, 151, 'OCT Share', '2018-03-04', '-1500', '-3150'),
(8, 152, 'OCT Share', '2018-03-04', '-1500', '-8150'),
(9, 153, 'OCT Share', '2018-03-04', '-1500', '-3150'),
(10, 154, 'OCT Share', '2018-03-04', '-1500', '-7150'),
(11, 155, 'OCT Share', '2018-03-04', '-1500', '-3150'),
(12, 156, 'OCT Share', '2018-03-04', '-1500', '-9250'),
(13, 157, 'OCT Share', '2018-03-04', '-1500', '18650'),
(14, 158, 'OCT Share', '2018-03-04', '-1500', '1850'),
(15, 159, 'OCT Share', '2018-03-04', '-1500', '-4150'),
(16, 160, 'OCT Share', '2018-03-04', '-1500', '-9650'),
(17, 161, 'OCT Share', '2018-03-04', '-1500', '-4150'),
(18, 162, 'OCT Share', '2018-03-04', '-1500', '-2150'),
(19, 163, 'OCT Share', '2018-03-04', '-1500', '54850'),
(20, 164, 'OCT Share', '2018-03-04', '-1500', '-4750'),
(17, 165, 'Top Bid Deposit', '2018-03-04', '30000', '25850');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `committee`
--
ALTER TABLE `committee`
  ADD PRIMARY KEY (`COMMITTEE_ID`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`ACC_NO`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`TRANSACTION_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `committee`
--
ALTER TABLE `committee`
  MODIFY `COMMITTEE_ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `ACC_NO` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `TRANSACTION_ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=166;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
