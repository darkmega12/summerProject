SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ecall
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ecall` DEFAULT CHARACTER SET latin1 ;
USE `ecall` ;

-- -----------------------------------------------------
-- Table `ecall`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecall`.`user` ;

CREATE TABLE IF NOT EXISTS `ecall`.`user` (
  `idUser` INT(11) NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NOT NULL,
  `userPassword` VARCHAR(45) NOT NULL,
  `userType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ecall`.`agent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecall`.`agent` ;

CREATE TABLE IF NOT EXISTS `ecall`.`agent` (
  `idAgent` INT(11) NOT NULL AUTO_INCREMENT,
  `lastName` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `middleName` VARCHAR(45) NOT NULL,
  `landline` VARCHAR(45) NOT NULL,
  `mobile` VARCHAR(45) NOT NULL,
  `birthDate` DATE NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `applicationDate` DATE NOT NULL,
  `agentStatus` VARCHAR(45) NOT NULL,
  `idUser` INT(11) NOT NULL,
  `zipCode` INT(4) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAgent`),
  INDEX `fk_Agent_User1` (`idUser` ASC),
  CONSTRAINT `fk_Agent_User1`
    FOREIGN KEY (`idUser`)
    REFERENCES `ecall`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ecall`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecall`.`course` ;

CREATE TABLE IF NOT EXISTS `ecall`.`course` (
  `idCourse` INT(11) NOT NULL AUTO_INCREMENT,
  `courseDescription` VARCHAR(45) NOT NULL,
  `courseCode` VARCHAR(45) NOT NULL,
  `courseName` VARCHAR(45) NOT NULL,
  `hourCount` INT(11) NOT NULL,
  PRIMARY KEY (`idCourse`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ecall`.`class`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecall`.`class` ;

CREATE TABLE IF NOT EXISTS `ecall`.`class` (
  `idClass` INT(11) NOT NULL AUTO_INCREMENT,
  `agentCount` INT(11) NOT NULL,
  `startingDate` DATE NOT NULL,
  `endingDate` DATE NOT NULL,
  `schedule` VARCHAR(45) NOT NULL,
  `venue` VARCHAR(45) NOT NULL,
  `classStatus` VARCHAR(45) NOT NULL,
  `idCourse` INT(11) NOT NULL,
  PRIMARY KEY (`idClass`),
  INDEX `fk_Class_Course1` (`idCourse` ASC),
  CONSTRAINT `fk_Class_Course1`
    FOREIGN KEY (`idCourse`)
    REFERENCES `ecall`.`course` (`idCourse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ecall`.`company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecall`.`company` ;

CREATE TABLE IF NOT EXISTS `ecall`.`company` (
  `idCompany` INT(11) NOT NULL AUTO_INCREMENT,
  `companyName` VARCHAR(45) NOT NULL,
  `zipCode` INT(4) NOT NULL,
  `contactNumber` VARCHAR(45) NOT NULL,
  `registrationDate` DATE NOT NULL,
  `companyStatus` VARCHAR(45) NOT NULL,
  `idUser` INT(11) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCompany`),
  INDEX `fk_Company_User1` (`idUser` ASC),
  CONSTRAINT `fk_Company_User1`
    FOREIGN KEY (`idUser`)
    REFERENCES `ecall`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ecall`.`educationbg`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecall`.`educationbg` ;

CREATE TABLE IF NOT EXISTS `ecall`.`educationbg` (
  `idEducationBG` INT(11) NOT NULL AUTO_INCREMENT,
  `degree` VARCHAR(45) NOT NULL,
  `yearCompletion` INT(11) NOT NULL,
  `university` VARCHAR(45) NOT NULL,
  `idAgent` INT(11) NOT NULL,
  PRIMARY KEY (`idEducationBG`),
  INDEX `fk_EducationBG_Agent1` (`idAgent` ASC),
  CONSTRAINT `fk_EducationBG_Agent1`
    FOREIGN KEY (`idAgent`)
    REFERENCES `ecall`.`agent` (`idAgent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ecall`.`grade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecall`.`grade` ;

CREATE TABLE IF NOT EXISTS `ecall`.`grade` (
  `idGrade` INT(11) NOT NULL AUTO_INCREMENT,
  `grade` FLOAT NOT NULL,
  `idClass` INT(11) NOT NULL,
  `idAgent` INT(11) NOT NULL,
  PRIMARY KEY (`idGrade`),
  INDEX `fk_grade_class1_idx` (`idClass` ASC),
  INDEX `fk_grade_agent1_idx` (`idAgent` ASC),
  CONSTRAINT `fk_grade_class1`
    FOREIGN KEY (`idClass`)
    REFERENCES `ecall`.`class` (`idClass`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grade_agent1`
    FOREIGN KEY (`idAgent`)
    REFERENCES `ecall`.`agent` (`idAgent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ecall`.`jobopening`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecall`.`jobopening` ;

CREATE TABLE IF NOT EXISTS `ecall`.`jobopening` (
  `idJobOpening` INT(11) NOT NULL AUTO_INCREMENT,
  `requestDate` DATE NOT NULL,
  `dueDate` DATE NOT NULL,
  `completeDate` DATE NOT NULL,
  `openingStatus` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `quantity` INT(11) NOT NULL,
  `idCompany` INT(11) NOT NULL,
  PRIMARY KEY (`idJobOpening`),
  INDEX `fk_JobOpening_Company1` (`idCompany` ASC),
  CONSTRAINT `fk_JobOpening_Company1`
    FOREIGN KEY (`idCompany`)
    REFERENCES `ecall`.`company` (`idCompany`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ecall`.`listcourses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecall`.`listcourses` ;

CREATE TABLE IF NOT EXISTS `ecall`.`listcourses` (
  `idListCourses` INT(11) NOT NULL AUTO_INCREMENT,
  `idCourse` INT(11) NOT NULL,
  `idAgent` INT(11) NOT NULL,
  PRIMARY KEY (`idListCourses`),
  INDEX `fk_ListCourses_Course1` (`idCourse` ASC),
  INDEX `fk_listcourses_agent1_idx` (`idAgent` ASC),
  CONSTRAINT `fk_ListCourses_Course1`
    FOREIGN KEY (`idCourse`)
    REFERENCES `ecall`.`course` (`idCourse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_listcourses_agent1`
    FOREIGN KEY (`idAgent`)
    REFERENCES `ecall`.`agent` (`idAgent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ecall`.`rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecall`.`rating` ;

CREATE TABLE IF NOT EXISTS `ecall`.`rating` (
  `idRating` INT(11) NOT NULL AUTO_INCREMENT,
  `rating` FLOAT NOT NULL,
  PRIMARY KEY (`idRating`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ecall`.`registrar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecall`.`registrar` ;

CREATE TABLE IF NOT EXISTS `ecall`.`registrar` (
  `idRegistrar` INT(11) NOT NULL AUTO_INCREMENT,
  `lastName` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `middleName` VARCHAR(45) NOT NULL,
  `idUser` INT(11) NOT NULL,
  PRIMARY KEY (`idRegistrar`),
  INDEX `fk_Registrar_User1` (`idUser` ASC),
  CONSTRAINT `fk_Registrar_User1`
    FOREIGN KEY (`idUser`)
    REFERENCES `ecall`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ecall`.`workexperience`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ecall`.`workexperience` ;

CREATE TABLE IF NOT EXISTS `ecall`.`workexperience` (
  `idWorkExperience` INT(11) NOT NULL AUTO_INCREMENT,
  `startingDate` DATE NOT NULL,
  `yearEffective` INT(11) NOT NULL,
  `agentSalary` FLOAT NOT NULL,
  `idAgent` INT(11) NOT NULL,
  `idJobOpening` INT(11) NOT NULL,
  `idRating` INT(11) NOT NULL,
  PRIMARY KEY (`idWorkExperience`),
  INDEX `fk_WorkExperience_Agent1` (`idAgent` ASC),
  INDEX `fk_WorkExperience_JobOpening1` (`idJobOpening` ASC),
  INDEX `fk_WorkExperience_Rating1` (`idRating` ASC),
  CONSTRAINT `fk_WorkExperience_Agent1`
    FOREIGN KEY (`idAgent`)
    REFERENCES `ecall`.`agent` (`idAgent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_WorkExperience_JobOpening1`
    FOREIGN KEY (`idJobOpening`)
    REFERENCES `ecall`.`jobopening` (`idJobOpening`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_WorkExperience_Rating1`
    FOREIGN KEY (`idRating`)
    REFERENCES `ecall`.`rating` (`idRating`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
