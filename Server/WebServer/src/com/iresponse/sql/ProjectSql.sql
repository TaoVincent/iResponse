CREATE DATABASE IF NOT EXISTS `sfdb`; 
USE `sfdb`;

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` char(13) NOT NULL,
  `name` varchar(32) NOT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `project` VALUES ('100001', 'SpringFrame', '2017-06-19 18:59:15');
INSERT INTO `project` VALUES ('100002', 'Web', '2017-06-19 18:59:34');
