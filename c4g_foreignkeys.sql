-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 29, 2017 at 03:15 PM
-- Server version: 5.5.57-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `c4g`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE IF NOT EXISTS `doctor` (
  `did` int(10) NOT NULL AUTO_INCREMENT,
  `dname` text NOT NULL,
  `dbirthdate` date NOT NULL,
  `degree` text NOT NULL,
  `hospital_name` text NOT NULL,
  `hospital _address` text NOT NULL,
  `dcontact` int(11) NOT NULL,
  `demail` text NOT NULL,
  `dpass` int(11) NOT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE IF NOT EXISTS `donor` (
  `doid` int(11) NOT NULL AUTO_INCREMENT,
  `dofname` text NOT NULL,
  `dolname` text NOT NULL,
  `doemail` text NOT NULL,
  `doamt` int(11) NOT NULL,
  `docontact` int(11) NOT NULL,
  PRIMARY KEY (`doid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE IF NOT EXISTS `hospital` (
  `h_id` int(11) NOT NULL AUTO_INCREMENT,
  `hospital_name` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`h_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `hospital_mapping`
--

CREATE TABLE IF NOT EXISTS `hospital_mapping` (
  `did` int(11) NOT NULL,
  `h_id` int(11) NOT NULL,
  KEY `did` (`did`),
  KEY `h_id` (`h_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE IF NOT EXISTS `patients` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` text NOT NULL,
  `inst.no.` text NOT NULL,
  `hosp_name` text NOT NULL,
  `pbdate` date NOT NULL,
  `p-age` int(11) NOT NULL,
  `Male` int(11) NOT NULL,
  `Female` int(11) NOT NULL,
  `Mtongue` text NOT NULL,
  `education` text NOT NULL,
  `father` text NOT NULL,
  `mother` text NOT NULL,
  `guardian` text NOT NULL,
  `pcontact` int(11) NOT NULL,
  `tempadd` text NOT NULL,
  `permadd` text NOT NULL,
  `illness` text NOT NULL,
  `Outstationed` text NOT NULL,
  `outstation_place` text NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `siblings`
--

CREATE TABLE IF NOT EXISTS `siblings` (
  `sib_id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `name` text NOT NULL,
  `gender` varchar(300) NOT NULL,
  PRIMARY KEY (`sib_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `siblings_mapping`
--

CREATE TABLE IF NOT EXISTS `siblings_mapping` (
  `pid` int(11) NOT NULL,
  `sib_id` int(11) NOT NULL,
  PRIMARY KEY (`pid`),
  KEY `sib_id` (`sib_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` text NOT NULL,
  `slocation` text NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `volunteer`
--

CREATE TABLE IF NOT EXISTS `volunteer` (
  `vid` int(10) NOT NULL AUTO_INCREMENT,
  `vname` text NOT NULL,
  `vcontact` int(11) NOT NULL,
  `vaddress` text NOT NULL,
  `vcategory` int(11) NOT NULL,
  `vemail` text NOT NULL,
  `reference` int(11) NOT NULL,
  `reason` text NOT NULL,
  `prefloc` int(11) DEFAULT NULL,
  `otherloc` text NOT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hospital_mapping`
--
ALTER TABLE `hospital_mapping`
  ADD CONSTRAINT `hospital_mapping_ibfk_2` FOREIGN KEY (`h_id`) REFERENCES `hospital` (`h_id`),
  ADD CONSTRAINT `hospital_mapping_ibfk_1` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`);

--
-- Constraints for table `siblings_mapping`
--
ALTER TABLE `siblings_mapping`
  ADD CONSTRAINT `siblings_mapping_ibfk_2` FOREIGN KEY (`sib_id`) REFERENCES `siblings` (`sib_id`),
  ADD CONSTRAINT `siblings_mapping_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `patients` (`pid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
