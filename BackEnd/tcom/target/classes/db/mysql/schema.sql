CREATE TABLE IF NOT EXISTS tiles (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  centerX INT(4),
  centerY INT(4),
  hasPlayer boolean,
  INDEX(id)
) engine=InnoDB;