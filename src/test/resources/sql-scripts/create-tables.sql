CREATE DATABASE IF NOT EXISTS `doc_assistant_db`;

USE `doc_assistant_db`;

-- ----------------------------
-- Table structure for `patient_master`
-- ----------------------------
DROP TABLE IF EXISTS `patient_master`;

CREATE TABLE `patient_master` (
  `PATIENT_ID` int(6) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(20) NOT NULL,
  `LAST_NAME` varchar(20) NOT NULL,
  `AGE` int(3) NOT NULL,
  `HEIGHT` int(3) NOT NULL,
  `LAST_VISIT_DATE` datetime DEFAULT NULL,
  `NEXT_VISIT_DATE` datetime NOT NULL,
  PRIMARY KEY (`PATIENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for `medicine_master`
-- ----------------------------
DROP TABLE IF EXISTS `medicine_master`;

CREATE TABLE `medicine_master` (
  `MEDICINE_ID` int(6) NOT NULL AUTO_INCREMENT,
  `MEDICINE_NAME` varchar(60) NOT NULL,
  PRIMARY KEY (`MEDICINE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for `prescription`
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;

CREATE TABLE `prescription` (
  `PRESCRIPTION_ID` int(6) NOT NULL AUTO_INCREMENT,
  `PATIENT_ID` int(6) NOT NULL,
  `PRESCRIPTION_DATE` datetime NOT NULL,
  PRIMARY KEY (`PRESCRIPTION_ID`),
  KEY `FK_PATIENT_ID_FROM_PATIENT_MASTER` (`PATIENT_ID`),
  CONSTRAINT `FK_PATIENT_ID_FROM_PATIENT_MASTER` FOREIGN KEY (`PATIENT_ID`) REFERENCES `patient_master` (`PATIENT_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for `prescription_medicines_description`
-- ----------------------------
DROP TABLE IF EXISTS `prescription_medicines_description`;

CREATE TABLE `prescription_medicines_description` (
  `PRESCRIPTION_ID` int(6) NOT NULL DEFAULT '0',
  `MEDICINE_ID` int(6) NOT NULL DEFAULT '0',
  `DESCRIPTION` text,
  PRIMARY KEY (`PRESCRIPTION_ID`,`MEDICINE_ID`),
  KEY `FK_MEDICINE_ID_FROM_MEDICINE_MASTER` (`MEDICINE_ID`),
  CONSTRAINT `FK_MEDICINE_ID_FROM_MEDICINE_MASTER` FOREIGN KEY (`MEDICINE_ID`) REFERENCES `medicine_master` (`MEDICINE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PRESCRIPTION_ID_FROM_PRESCRIPTION` FOREIGN KEY (`PRESCRIPTION_ID`) REFERENCES `prescription` (`PRESCRIPTION_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
