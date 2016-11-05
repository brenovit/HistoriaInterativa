-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 05-Nov-2016 às 16:22
-- Versão do servidor: 5.7.16
-- PHP Version: 7.0.8-0ubuntu0.16.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `pi4sem`
--
CREATE DATABASE IF NOT EXISTS `pi4sem` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `pi4sem`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Autor`
--

CREATE TABLE `Autor` (
  `AUTO_ID` int(11) NOT NULL,
  `AUTO_NOME` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Comentario`
--

CREATE TABLE `Comentario` (
  `COME_ID` int(11) NOT NULL,
  `COME_Descricao` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `USUA_ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Livro`
--

CREATE TABLE `Livro` (
  `LIVR_ID` int(11) NOT NULL,
  `LIVR_SBN` int(11) NOT NULL,
  `LIVR_DataCadastro` date NOT NULL,
  `LIVR_Prefacio` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `LIVR_Titulo` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Pontuacao`
--

CREATE TABLE `Pontuacao` (
  `PONT_ID` int(11) NOT NULL,
  `PONT_Valor` int(11) DEFAULT NULL,
  `LIUS_ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `REL_Livro_Autor`
--

CREATE TABLE `REL_Livro_Autor` (
  `LIAU_ID` int(11) NOT NULL,
  `AUTO_ID` int(11) NOT NULL,
  `LIVR_ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `REL_Livro_Usuario`
--

CREATE TABLE `REL_Livro_Usuario` (
  `LIUS_ID` int(11) NOT NULL,
  `USUA_ID` int(11) NOT NULL,
  `LIVR_ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Telefone`
--

CREATE TABLE `Telefone` (
  `TELE_ID` int(11) NOT NULL,
  `TELE_Descricao` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `USUA_ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Tipo_Usuario`
--

CREATE TABLE `Tipo_Usuario` (
  `TPUS_ID` int(11) NOT NULL,
  `TPUS_Descricao` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `Tipo_Usuario`
--

INSERT INTO `Tipo_Usuario` (`TPUS_ID`, `TPUS_Descricao`) VALUES
(1, 'Master'),
(2, 'Leitor');

-- --------------------------------------------------------

--
-- Estrutura da tabela `Usuario`
--

CREATE TABLE `Usuario` (
  `USUA_ID` int(11) NOT NULL,
  `USUA_Nome` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `USUA_CPF` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `USUA_DataNasc` datetime DEFAULT NULL,
  `USUA_Email` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `USUA_Login` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `USUA_Senha` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `TPUS_ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `Usuario`
--

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Autor`
--
ALTER TABLE `Autor`
  ADD PRIMARY KEY (`AUTO_ID`);

--
-- Indexes for table `Comentario`
--
ALTER TABLE `Comentario`
  ADD PRIMARY KEY (`COME_ID`),
  ADD KEY `fk_Comentario_Usuario` (`USUA_ID`);

--
-- Indexes for table `Livro`
--
ALTER TABLE `Livro`
  ADD PRIMARY KEY (`LIVR_ID`);

--
-- Indexes for table `Pontuacao`
--
ALTER TABLE `Pontuacao`
  ADD PRIMARY KEY (`PONT_ID`),
  ADD KEY `fk_Pontuacao_REL_Livro_Usuario` (`LIUS_ID`);

--
-- Indexes for table `REL_Livro_Autor`
--
ALTER TABLE `REL_Livro_Autor`
  ADD PRIMARY KEY (`LIAU_ID`),
  ADD KEY `fk_REL_Livro_Autor_Autor` (`AUTO_ID`),
  ADD KEY `fk_REL_Livro_Autor_Livro` (`LIVR_ID`);

--
-- Indexes for table `REL_Livro_Usuario`
--
ALTER TABLE `REL_Livro_Usuario`
  ADD PRIMARY KEY (`LIUS_ID`),
  ADD KEY `fk_REL_Livro_Usuario_Livro` (`LIVR_ID`),
  ADD KEY `fk_REL_Livro_Usuario_Usuario` (`USUA_ID`);

--
-- Indexes for table `Telefone`
--
ALTER TABLE `Telefone`
  ADD PRIMARY KEY (`TELE_ID`),
  ADD KEY `fk_Telefone_Usuario` (`USUA_ID`);

--
-- Indexes for table `Tipo_Usuario`
--
ALTER TABLE `Tipo_Usuario`
  ADD PRIMARY KEY (`TPUS_ID`),
  ADD UNIQUE KEY `TPUS_ID` (`TPUS_ID`),
  ADD KEY `TPUS_ID_2` (`TPUS_ID`);

--
-- Indexes for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`USUA_ID`),
  ADD UNIQUE KEY `USUA_ID` (`USUA_ID`),
  ADD UNIQUE KEY `USUA_Login` (`USUA_Login`),
  ADD UNIQUE KEY `USUA_Email` (`USUA_Email`),
  ADD KEY `fk_Usuario_Tipo_Usuario` (`TPUS_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Autor`
--
ALTER TABLE `Autor`
  MODIFY `AUTO_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Comentario`
--
ALTER TABLE `Comentario`
  MODIFY `COME_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Livro`
--
ALTER TABLE `Livro`
  MODIFY `LIVR_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Pontuacao`
--
ALTER TABLE `Pontuacao`
  MODIFY `PONT_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `REL_Livro_Autor`
--
ALTER TABLE `REL_Livro_Autor`
  MODIFY `LIAU_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `REL_Livro_Usuario`
--
ALTER TABLE `REL_Livro_Usuario`
  MODIFY `LIUS_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Telefone`
--
ALTER TABLE `Telefone`
  MODIFY `TELE_ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Tipo_Usuario`
--
ALTER TABLE `Tipo_Usuario`
  MODIFY `TPUS_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `USUA_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;