-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 29, 2017 at 07:03 PM
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
  `dcontact` bigint(20) NOT NULL,
  `demail` text NOT NULL,
  `dpass` text NOT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`did`, `dname`, `dbirthdate`, `degree`, `dcontact`, `demail`, `dpass`) VALUES
(1, 'rajesh', '1970-06-07', 'MBBS', 9773919892, 'ymmodi96@gmail.com', 'gd'),
(2, 'raghav', '1986-09-08', 'mbbs', 9821978904, 'yatrihsm@yahoo.co.in', 'ab');

-- --------------------------------------------------------

--
-- Table structure for table `doctor_patient_mapping`
--

CREATE TABLE IF NOT EXISTS `doctor_patient_mapping` (
  `did` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  KEY `did` (`did`),
  KEY `pid` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor_patient_mapping`
--

INSERT INTO `doctor_patient_mapping` (`did`, `pid`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE IF NOT EXISTS `donor` (
  `doid` int(11) NOT NULL AUTO_INCREMENT,
  `doemail` text NOT NULL,
  `doamt` int(11) NOT NULL,
  `docontact` int(11) NOT NULL,
  `doname` text NOT NULL,
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
  `haddress` text NOT NULL,
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
  `pcontact` bigint(20) NOT NULL,
  `tempadd` text NOT NULL,
  `permadd` text NOT NULL,
  `illness` text NOT NULL,
  `Outstationed` text NOT NULL,
  `outstation_place` text NOT NULL,
  `did` int(11) NOT NULL,
  `notes_doctor` text NOT NULL,
  PRIMARY KEY (`pid`),
  KEY `did` (`did`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`pid`, `pname`, `inst.no.`, `hosp_name`, `pbdate`, `p-age`, `Male`, `Female`, `Mtongue`, `education`, `father`, `mother`, `guardian`, `pcontact`, `tempadd`, `permadd`, `illness`, `Outstationed`, `outstation_place`, `did`, `notes_doctor`) VALUES
(1, 'Neha', 'CP898', 'Jaslok', '2001-06-15', 16, 0, 1, 'Gujarati', 'std 11', 'Raj', 'Kiara', '', 9819295737, 'gyujgdcfyud', 'hdwejg', 'jhdewhf', 'Yes', 'lonavala', 1, ''),
(2, 'karan', 'bg38723', 'KEM', '2004-09-10', 13, 1, 0, 'Malyali', 'std 8', 'manoj', 'leela', '', 9821978904, 'hdiuew', 'jwdwqjd', 'allergic to carrots', 'no', '', 2, 'allergic to carrots'),
(3, 'rashi', 'sh7779', 'Jaslok', '2010-12-04', 7, 0, 1, 'mkef', 'std 2', 'jkwjef', 'ewfw', '', 9833930290, 'udqei', 'ndkjqe2h', '', 'no', '', 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `patient_photo`
--

CREATE TABLE IF NOT EXISTS `patient_photo` (
  `im_id` int(11) NOT NULL AUTO_INCREMENT,
  `image` blob NOT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`im_id`)
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
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uemail` text NOT NULL,
  `pwd` text NOT NULL,
  `role` text NOT NULL,
  PRIMARY KEY (`uid`)
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
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `volunteer`
--

INSERT INTO `volunteer` (`vid`, `vname`, `vcontact`, `vaddress`, `vcategory`, `vemail`, `reference`, `reason`, `prefloc`, `otherloc`, `uid`) VALUES
(1, '', 2147483647, 'Mumbai,India', 1, 'shraddha.mak1911@gmail.com', 1, 'xyz', 1, '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `volunteer_patient`
--

CREATE TABLE IF NOT EXISTS `volunteer_patient` (
  `pid` int(11) NOT NULL,
  `vid` int(11) NOT NULL,
  KEY `pid` (`pid`),
  KEY `vid` (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `wish`
--

CREATE TABLE IF NOT EXISTS `wish` (
  `pid` int(11) NOT NULL,
  `vid` int(11) NOT NULL,
  `did` int(11) NOT NULL,
  `dtofadm` date NOT NULL,
  `dtidf` date NOT NULL,
  `granted` text NOT NULL,
  `wishiden` text NOT NULL,
  `dateoffulfill` date NOT NULL,
  `rushwish` text NOT NULL,
  `wish1_type` text NOT NULL,
  `w1desc` text NOT NULL,
  `w2` text NOT NULL,
  `w2desc` text NOT NULL,
  `w3` text NOT NULL,
  `w3desc` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `doctor_patient_mapping`
--
ALTER TABLE `doctor_patient_mapping`
  ADD CONSTRAINT `doctor_patient_mapping_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `patients` (`pid`),
  ADD CONSTRAINT `doctor_patient_mapping_ibfk_1` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`);

--
-- Constraints for table `hospital_mapping`
--
ALTER TABLE `hospital_mapping`
  ADD CONSTRAINT `hospital_mapping_ibfk_1` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`),
  ADD CONSTRAINT `hospital_mapping_ibfk_2` FOREIGN KEY (`h_id`) REFERENCES `hospital` (`h_id`);

--
-- Constraints for table `patients`
--
ALTER TABLE `patients`
  ADD CONSTRAINT `patients_ibfk_1` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`);

--
-- Constraints for table `siblings_mapping`
--
ALTER TABLE `siblings_mapping`
  ADD CONSTRAINT `siblings_mapping_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `patients` (`pid`),
  ADD CONSTRAINT `siblings_mapping_ibfk_2` FOREIGN KEY (`sib_id`) REFERENCES `siblings` (`sib_id`);

--
-- Constraints for table `volunteer_patient`
--
ALTER TABLE `volunteer_patient`
  ADD CONSTRAINT `volunteer_patient_ibfk_2` FOREIGN KEY (`vid`) REFERENCES `volunteer` (`vid`),
  ADD CONSTRAINT `volunteer_patient_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `patients` (`pid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
