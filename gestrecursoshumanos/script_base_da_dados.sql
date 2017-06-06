-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.17-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema gestrecursoshumanos
--

CREATE DATABASE IF NOT EXISTS gestrecursoshumanos;
USE gestrecursoshumanos;

--
-- Definition of table `candidato`
--

DROP TABLE IF EXISTS `candidato`;
CREATE TABLE `candidato` (
  `id_candidato` int(11) NOT NULL AUTO_INCREMENT,
  `primeiro_nome_candidato` varchar(45) DEFAULT NULL,
  `segundo_nome_candidato` varchar(45) DEFAULT NULL,
  `ultimo_nome_funcionario` varchar(45) DEFAULT NULL,
  `alcunha_funcionario` varchar(45) DEFAULT NULL,
  `foto_candidato` varchar(45) DEFAULT NULL,
  `url_foto_candidato` varchar(45) DEFAULT NULL,
  `data_nascimento_candidato` date DEFAULT NULL,
  `telefone_fixo` varchar(45) DEFAULT NULL,
  `telemovel_principal` varchar(45) DEFAULT NULL,
  `telemovel_secundario` varchar(45) DEFAULT NULL,
  `email_principal` varchar(45) DEFAULT NULL,
  `email_secundario` varchar(45) DEFAULT NULL,
  `casa_candidato` varchar(45) DEFAULT NULL,
  `rua_funcionario` varchar(45) DEFAULT NULL,
  `bairro_candidato` varchar(45) DEFAULT NULL,
  `id_municipio` int(11) NOT NULL,
  PRIMARY KEY (`id_candidato`),
  KEY `fk_funcionario_municipio1_idx` (`id_municipio`),
  CONSTRAINT `fk_funcionario_municipio10` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `candidato`
--

/*!40000 ALTER TABLE `candidato` DISABLE KEYS */;
/*!40000 ALTER TABLE `candidato` ENABLE KEYS */;


--
-- Definition of table `contracto`
--

DROP TABLE IF EXISTS `contracto`;
CREATE TABLE `contracto` (
  `id_contracto` int(11) NOT NULL AUTO_INCREMENT,
  `data_admissao` date DEFAULT NULL,
  `data_inicio_contrato` date DEFAULT NULL,
  `data_fim_contrato` date DEFAULT NULL,
  `id_funcionario` int(11) NOT NULL,
  PRIMARY KEY (`id_contracto`),
  KEY `fk_contracto_funcionario1_idx` (`id_funcionario`),
  CONSTRAINT `fk_contracto_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contracto`
--

/*!40000 ALTER TABLE `contracto` DISABLE KEYS */;
/*!40000 ALTER TABLE `contracto` ENABLE KEYS */;


--
-- Definition of table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `nome_departamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `departamento`
--

/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;


--
-- Definition of table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `id_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `nome_empresa` varchar(45) DEFAULT NULL,
  `sigla_empresa` varchar(45) DEFAULT NULL,
  `logo_empresa` blob,
  `url_logo_empresa` varchar(45) DEFAULT NULL,
  `data_cricacao` date DEFAULT NULL,
  `casa_empresa` varchar(45) DEFAULT NULL,
  `rua_empresa` varchar(45) DEFAULT NULL,
  `bairro_empresa` varchar(45) DEFAULT NULL,
  `distrito_empresa` varchar(45) DEFAULT NULL,
  `home_page` varchar(45) DEFAULT NULL,
  `email_princiapal` varchar(45) DEFAULT NULL,
  `telefone_princiapl` varchar(45) DEFAULT NULL,
  `telefone_secundario` varchar(45) DEFAULT NULL,
  `telemovel_principal` varchar(45) DEFAULT NULL,
  `telemovel_secundario` varchar(45) DEFAULT NULL,
  `fax_principal` varchar(45) DEFAULT NULL,
  `fax_secundario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `empresa`
--

/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;


--
-- Definition of table `folha_pagamento`
--

DROP TABLE IF EXISTS `folha_pagamento`;
CREATE TABLE `folha_pagamento` (
  `id_folha_pagamento` int(11) NOT NULL AUTO_INCREMENT,
  `data_emissao` date DEFAULT NULL,
  `desconto_INSS` double DEFAULT NULL,
  `ferias` double DEFAULT NULL,
  `horas_extras` double DEFAULT NULL,
  `comissao` double DEFAULT NULL,
  `premios` double DEFAULT NULL,
  `id_funcionario` int(11) NOT NULL,
  PRIMARY KEY (`id_folha_pagamento`),
  KEY `fk_folha_pagamento_funcionario1_idx` (`id_funcionario`),
  CONSTRAINT `fk_folha_pagamento_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `folha_pagamento`
--

/*!40000 ALTER TABLE `folha_pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `folha_pagamento` ENABLE KEYS */;


--
-- Definition of table `funcao_funcionario`
--

DROP TABLE IF EXISTS `funcao_funcionario`;
CREATE TABLE `funcao_funcionario` (
  `id_funcao_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `funcao_funcionario` varchar(45) DEFAULT NULL,
  `salario_funcao` double DEFAULT NULL,
  PRIMARY KEY (`id_funcao_funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcao_funcionario`
--

/*!40000 ALTER TABLE `funcao_funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcao_funcionario` ENABLE KEYS */;


--
-- Definition of table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `primeiro_nome_funcionario` varchar(45) DEFAULT NULL,
  `segundo_nome_funcionario` varchar(45) DEFAULT NULL,
  `ultimo_nome_funcionario` varchar(45) DEFAULT NULL,
  `alcunha_funcionario` varchar(45) DEFAULT NULL,
  `data_nascimento_funcionario` date DEFAULT NULL,
  `foto_funcionario` blob,
  `url_foto_funcionario` varchar(45) DEFAULT NULL,
  `telefone_funcionario` varchar(45) DEFAULT NULL,
  `telemovel_princiapal` varchar(45) DEFAULT NULL,
  `telemovel_secundario` varchar(45) DEFAULT NULL,
  `email_principal` varchar(45) DEFAULT NULL,
  `email_secundario` varchar(45) DEFAULT NULL,
  `casa_funcionario` varchar(45) DEFAULT NULL,
  `rua_funcionario` varchar(45) DEFAULT NULL,
  `bairro_funcionario` varchar(45) DEFAULT NULL,
  `id_municipio` int(11) NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  KEY `fk_funcionario_municipio1_idx` (`id_municipio`),
  CONSTRAINT `fk_funcionario_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcionario`
--

/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;


--
-- Definition of table `funcionario_departamento`
--

DROP TABLE IF EXISTS `funcionario_departamento`;
CREATE TABLE `funcionario_departamento` (
  `id_funcionario_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `data_entrada` date DEFAULT NULL,
  `data_saida` date DEFAULT NULL,
  `id_funcionario` int(11) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  `id_funcao_funcionario` int(11) NOT NULL,
  PRIMARY KEY (`id_funcionario_departamento`),
  KEY `fk_funcionario_departamento_funcionario1_idx` (`id_funcionario`),
  KEY `fk_funcionario_departamento_departamento1_idx` (`id_departamento`),
  KEY `fk_funcionario_departamento_funcao_funcionario1_idx` (`id_funcao_funcionario`),
  CONSTRAINT `fk_funcionario_departamento_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_departamento_funcao_funcionario1` FOREIGN KEY (`id_funcao_funcionario`) REFERENCES `funcao_funcionario` (`id_funcao_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_departamento_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcionario_departamento`
--

/*!40000 ALTER TABLE `funcionario_departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario_departamento` ENABLE KEYS */;


--
-- Definition of table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
CREATE TABLE `municipio` (
  `id_municipio` int(11) NOT NULL AUTO_INCREMENT,
  `nome_municipio` varchar(45) DEFAULT NULL,
  `id_provincia` int(11) NOT NULL,
  PRIMARY KEY (`id_municipio`),
  KEY `fk_municipio_provincia_idx` (`id_provincia`),
  CONSTRAINT `fk_municipio_provincia` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `municipio`
--

/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;


--
-- Definition of table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
CREATE TABLE `provincia` (
  `id_provincia` int(11) NOT NULL AUTO_INCREMENT,
  `nome_provincia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_provincia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `provincia`
--

/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
