-- ----------------------------
-- Records of patient_master
-- ----------------------------
INSERT INTO `patient_master` VALUES ('1', 'Mukesh', 'Soni', '28', '181', '2016-06-03 01:14:52', '2016-06-17 01:15:08');
INSERT INTO `patient_master` VALUES ('2', 'Niharika', 'Prasad', '32', '168', '2016-07-05 01:15:32', '2016-07-12 01:15:37');
INSERT INTO `patient_master` VALUES ('3', 'Pranab', 'Bhattacharya', '40', '172', '2016-05-05 01:22:42', '2016-05-19 01:22:50');

-- ----------------------------
-- Records of medicine_master
-- ----------------------------
INSERT INTO `medicine_master` VALUES ('1', 'Acetaminophen');
INSERT INTO `medicine_master` VALUES ('2', 'Temovate ');
INSERT INTO `medicine_master` VALUES ('3', 'Orajel');

-- ----------------------------
-- Records of prescription
-- ----------------------------
INSERT INTO `prescription` VALUES ('1', '1', '2016-05-03 01:14:52');
INSERT INTO `prescription` VALUES ('2', '1', '2016-06-03 01:14:52');
INSERT INTO `prescription` VALUES ('3', '2', '2016-07-05 01:15:32');

-- ----------------------------
-- Records of prescription_medicines_description
-- ----------------------------
INSERT INTO `prescription_medicines_description` VALUES ('1', '1', 'Twice a day after meals.');
INSERT INTO `prescription_medicines_description` VALUES ('1', '2', 'Gargles before sleeping.');
INSERT INTO `prescription_medicines_description` VALUES ('2', '2', 'Gargles before sleeping and after waking up.');
INSERT INTO `prescription_medicines_description` VALUES ('3', '3', 'Intake with hot water after dinner for 7 days.');
