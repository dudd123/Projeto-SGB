-- MySQL Script generated by MySQL Workbench
-- Fri Dec  1 11:09:40 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sgb_josevitor
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sgb_josevitor
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sgb_josevitor` DEFAULT CHARACTER SET utf8mb3 ;
USE `sgb_josevitor` ;

-- -----------------------------------------------------
-- Table `sgb_josevitor`.`tipo_obra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgb_josevitor`.`tipo_obra` (
  `cod_tipo_obra` INT NOT NULL,
  `descricao` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`cod_tipo_obra`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sgb_josevitor`.`obra_literaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgb_josevitor`.`obra_literaria` (
  `cod_obra_literaria` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `editora` VARCHAR(45) NOT NULL,
  `nro_edicao` VARCHAR(45) NULL DEFAULT NULL,
  `data_publicacao` DATE NULL DEFAULT NULL,
  `isbn` VARCHAR(45) NULL DEFAULT NULL,
  `qtd_pagina` VARCHAR(45) NULL DEFAULT NULL,
  `cod_tipo_obra` INT NOT NULL,
  PRIMARY KEY (`cod_obra_literaria`),
  INDEX `fk_obra_literaria_tipo_obra1_idx` (`cod_tipo_obra` ASC) VISIBLE,
  CONSTRAINT `fk_obra_literaria_tipo_obra1`
    FOREIGN KEY (`cod_tipo_obra`)
    REFERENCES `sgb_josevitor`.`tipo_obra` (`cod_tipo_obra`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sgb_josevitor`.`copia_obra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgb_josevitor`.`copia_obra` (
  `cod_copia_obra` INT NOT NULL,
  `situacao` VARCHAR(45) NOT NULL,
  `cod_obra_literaria` INT NOT NULL,
  PRIMARY KEY (`cod_copia_obra`),
  INDEX `fk_copia_obra_obra_literaria1_idx` (`cod_obra_literaria` ASC) VISIBLE,
  CONSTRAINT `fk_copia_obra_obra_literaria1`
    FOREIGN KEY (`cod_obra_literaria`)
    REFERENCES `sgb_josevitor`.`obra_literaria` (`cod_obra_literaria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sgb_josevitor`.`tipo_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgb_josevitor`.`tipo_usuario` (
  `cod_tipo_usuario` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `modulo_administrativo` VARCHAR(1) NOT NULL,
  `modulo_atendimento` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`cod_tipo_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sgb_josevitor`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgb_josevitor`.`usuario` (
  `cod_usuario` INT NOT NULL,
  `nome_completo` VARCHAR(60) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `rg` VARCHAR(15) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `senha_acesso` VARCHAR(64) NOT NULL,
  `telefone` VARCHAR(15) NULL DEFAULT NULL,
  `celular` VARCHAR(15) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `endereco` VARCHAR(80) NULL DEFAULT NULL,
  `nro` VARCHAR(6) NULL DEFAULT NULL,
  `compl` VARCHAR(80) NULL DEFAULT NULL,
  `bairro` VARCHAR(45) NULL DEFAULT NULL,
  `cidade` VARCHAR(30) NULL DEFAULT NULL,
  `estado` VARCHAR(30) NULL DEFAULT NULL,
  `cod_tipo_usuario` INT NOT NULL,
  PRIMARY KEY (`cod_usuario`),
  INDEX `fk_usuario_tipo_usuario_idx` (`cod_tipo_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_tipo_usuario`
    FOREIGN KEY (`cod_tipo_usuario`)
    REFERENCES `sgb_josevitor`.`tipo_usuario` (`cod_tipo_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `sgb_josevitor`.`emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgb_josevitor`.`emprestimo` (
  `cod_emprestimo` INT NOT NULL,
  `data_emprestimo` DATE NOT NULL,
  `data_devolucao` DATE NOT NULL,
  `valor_multa` FLOAT NULL DEFAULT NULL,
  `cod_usuario` INT NOT NULL,
  `cod_copia_obra` INT NOT NULL,
  PRIMARY KEY (`cod_emprestimo`),
  INDEX `fk_emprestimo_usuario1_idx` (`cod_usuario` ASC) VISIBLE,
  INDEX `fk_emprestimo_copia_obra1_idx` (`cod_copia_obra` ASC) VISIBLE,
  CONSTRAINT `fk_emprestimo_copia_obra1`
    FOREIGN KEY (`cod_copia_obra`)
    REFERENCES `sgb_josevitor`.`copia_obra` (`cod_copia_obra`),
  CONSTRAINT `fk_emprestimo_usuario1`
    FOREIGN KEY (`cod_usuario`)
    REFERENCES `sgb_josevitor`.`usuario` (`cod_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

