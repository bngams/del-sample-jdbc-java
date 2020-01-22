CREATE TABLE `contacts` (
`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
`lastname` varchar(45) NOT NULL,
`firstname` varchar(45) NOT NULL,
`tel` varchar(16) NOT NULL,
`email` varchar(90) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
