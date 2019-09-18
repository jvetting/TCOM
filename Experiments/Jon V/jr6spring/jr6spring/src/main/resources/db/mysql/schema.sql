CREATE TABLE IF NOT EXISTS tiles (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  character_name VARCHAR(30),
  red INT(4),
  blue INT(4),
  green INT(4),
  centerX INT(4),
  centerY (4),
  INDEX(character_name)
) engine=InnoDB;
