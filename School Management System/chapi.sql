-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2019 at 12:37 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chapi`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `user_name` varchar(15) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`user_name`, `password`) VALUES
('', ''),
('101', '001'),
('abi', '003'),
('chapi', '001'),
('ela', '002');

-- --------------------------------------------------------

--
-- Table structure for table `chapi`
--

CREATE TABLE `chapi` (
  `name` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `birthDate` varchar(20) NOT NULL,
  `city` varchar(50) NOT NULL,
  `addrress` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nationality` varchar(40) NOT NULL,
  `relationalStatus` varchar(50) NOT NULL,
  `accademicStatus` varchar(30) NOT NULL,
  `salary` int(11) NOT NULL,
  `id` varchar(20) NOT NULL,
  `depName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `name` varchar(20) NOT NULL,
  `size` varchar(10) NOT NULL,
  `km` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`name`, `size`, `km`) VALUES
('AA', 'small', 500),
('adama', 'big', 100),
('Agaro', 'small', 125),
('Gambela', 'small', 150),
('Jima', 'small', 320),
('Meti', 'small', 700),
('mizan', 'small', 100),
('Tepi', 'small', 400);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `depName` varchar(50) NOT NULL,
  `building` varchar(10) NOT NULL,
  `budge` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`depName`, `building`, `budge`) VALUES
('Amharic', 'B520', 40000),
('Biology', 'B511', 21000),
('Business', 'B505', 40000),
('Chemistry', 'B513', 15000),
('Civics', 'B544', 40101),
('Economics', 'B504', 40000),
('Geography', 'b503', 40000),
('History', 'B502', 40000),
('IT', 'B501', 1000000),
('Mathimathics', 'B510', 50000),
('Physics', 'B514', 40000),
('Sport', 'B522', 10000),
('TD', 'B533', 40000);

-- --------------------------------------------------------

--
-- Table structure for table `idcount`
--

CREATE TABLE `idcount` (
  `idnum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `idcount`
--

INSERT INTO `idcount` (`idnum`) VALUES
(10000009);

-- --------------------------------------------------------

--
-- Table structure for table `stdemergency`
--

CREATE TABLE `stdemergency` (
  `id` varchar(10) NOT NULL,
  `emergName` varchar(50) NOT NULL,
  `emergPhone` varchar(50) DEFAULT NULL,
  `emergCity` varchar(50) DEFAULT NULL,
  `emergAddress` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stdemergency`
--

INSERT INTO `stdemergency` (`id`, `emergName`, `emergPhone`, `emergCity`, `emergAddress`) VALUES
('10000002', 'men', '178273', 'tep', 'ada'),
('10000003', 'men', '178273', 'tep', 'ada'),
('10000004', 'men', '178273', 'tep', 'ada'),
('10000005', 'men', '178273', 'tep', 'ada'),
('10000006', '', '', '', ''),
('10000007', 'ZRXHXF', 'ZRXTFH', 'XTYD', 'R6Y'),
('10000008', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` varchar(10) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `birthDate` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `grade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `firstName`, `lastName`, `birthDate`, `age`, `city`, `phone`, `email`, `gender`, `grade`) VALUES
('010', 'chapi', 'menge', '2000-02-16', 19, 'Adama', '0934257234', 'chapimenge3@gmail.com', 'M', 12),
('1000000', 'rrrre', 'tt', '55-Apr-1', 0, 'tt', 'tt', 'tttttt', 'Male', 12),
('10000001', '', '', '1-Jan-1', 0, '', '', '', 'Male', 9),
('10000002', 'cc', 'ccc', '2000-Mar-8', 0, 'ada', '342572', 'chhhh', 'Male', 11),
('10000003', 'cc', 'ccc', '2000-Mar-8', 0, 'ada', '342572', 'chhhh', 'Male', 11),
('10000004', 'cc', 'ccc', '2000-Mar-8', 0, 'ada', '342572', 'chhhh', 'Male', 11),
('10000005', 'cc', 'ccc', '2000-Mar-8', 0, 'ada', '342572', 'chhhh', 'Male', 11),
('10000006', 'aa', '', '1000-Jan-1', 0, '', '', '', 'Male', 9),
('10000007', 'RTYS', 'S5XY6RF', '2000-Jan-1', 0, 'ZFH', 'ZRTS', 'RSTX', 'Male', 9),
('10000008', 'tyhj', '', '55-Jan-1', 0, '', '', '', 'Male', 9),
('14611', 'chapi', 'menge', '2000-02-16', 19, 'Adama', '0934257234', 'chapimenge3@gmail.com', 'M', 12),
('156', 'ama', 'fantaw', '2000-02-16', 19, 'Adama', '0934257234', 'chapimenge3@gmail.com', 'M', 12);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `TId` varchar(50) NOT NULL,
  `Tname` varchar(50) NOT NULL,
  `Tgender` varchar(10) DEFAULT NULL,
  `Tphone` varchar(20) DEFAULT NULL,
  `TbirthDate` int(11) DEFAULT NULL,
  `Tcity` int(11) DEFAULT NULL,
  `Taddrress` int(11) DEFAULT NULL,
  `Temail` int(11) DEFAULT NULL,
  `Tnationality` int(11) DEFAULT NULL,
  `Tstatus` int(11) DEFAULT NULL,
  `TaccademicStatus` int(11) NOT NULL,
  `Tsalary` int(11) NOT NULL,
  `depName` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `teacherid`
--

CREATE TABLE `teacherid` (
  `idcount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacherid`
--

INSERT INTO `teacherid` (`idcount`) VALUES
(5000000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`user_name`);

--
-- Indexes for table `chapi`
--
ALTER TABLE `chapi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`depName`);

--
-- Indexes for table `stdemergency`
--
ALTER TABLE `stdemergency`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`TId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
