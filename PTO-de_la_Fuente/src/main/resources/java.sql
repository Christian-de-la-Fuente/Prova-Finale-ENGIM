-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Lug 22, 2024 alle 09:57
-- Versione del server: 10.4.21-MariaDB
-- Versione PHP: 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `articolo`
--

CREATE TABLE `articolo` (
  `id` int(11) NOT NULL,
  `codice` varchar(15) NOT NULL,
  `descrizione` varchar(150) NOT NULL,
  `peso` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `articolo`
--

INSERT INTO `articolo` (`id`, `codice`, `descrizione`, `peso`) VALUES
(1, 'PNDRV8', 'Pen drive USB 8G no brand', 0.15),
(2, 'DCP-J715E', 'Stampante Brother DCP J715 W', 5.30),
(3, 'LNVCX1', 'Notebook Lenovo Carbon X1', 1.90),
(4, 'ALCPPC3', 'Smartphone Alcatel POP C3', 0.53),
(5, 'BSHT1R', 'Ampli Combo valvolare BlackStar HT 1-R', 6.00);

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine`
--

CREATE TABLE `ordine` (
  `id` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ordine`
--

INSERT INTO `ordine` (`id`, `numero`, `data`) VALUES
(1, 95, '2023-05-29'),
(2, 114, '2023-06-01'),
(3, 256, '2023-06-07'),
(4, 395, '2023-07-24'),
(5, 423, '2023-08-03'),
(6, 564, '2024-02-23'),
(7, 695, '2024-05-28'),
(8, 723, '2024-07-16'),
(9, 832, '2024-07-24');

-- --------------------------------------------------------

--
-- Struttura della tabella `tariffa_corriere`
--

CREATE TABLE `tariffa_corriere` (
  `id` int(11) NOT NULL,
  `nome_corriere` varchar(3) NOT NULL,
  `nome_tariffa` varchar(20) NOT NULL,
  `peso_massimo` double(10,1) NOT NULL,
  `costo` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `tariffa_corriere`
--

INSERT INTO `tariffa_corriere` (`id`, `nome_corriere`, `nome_tariffa`, `peso_massimo`, `costo`) VALUES
(1, 'SDA', 'Economy', 1.0, 5.90),
(2, 'SDA', 'Economy', 5.0, 7.90),
(3, 'SDA', 'Bigbox', 30.0, 12.90),
(4, 'DHL', 'Veloce', 1.5, 6.50),
(5, 'DHL', 'Assicurata', 7.5, 9.90),
(6, 'DHL', 'XXL', 40.0, 13.90),
(7, 'UPS', 'Economy', 0.7, 5.20),
(8, 'UPS', 'Standard', 3.0, 6.90),
(9, 'UPS', 'Jumbo', 25.0, 11.50);

-- --------------------------------------------------------

--
-- Struttura della tabella `voce`
--

CREATE TABLE `voce` (
  `id` int(11) NOT NULL,
  `ordine_id` int(11) NOT NULL,
  `articolo_id` int(11) NOT NULL,
  `quantità` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `voce`
--

INSERT INTO `voce` (`id`, `ordine_id`, `articolo_id`, `quantità`) VALUES
(1, 1, 3, 2),
(2, 2, 2, 1),
(3, 2, 3, 1),
(4, 3, 3, 1),
(5, 3, 4, 1),
(6, 4, 1, 2),
(7, 4, 4, 1),
(8, 5, 4, 2),
(9, 5, 1, 1),
(10, 6, 1, 3),
(11, 7, 2, 7),
(12, 8, 5, 1),
(13, 8, 3, 1),
(14, 9, 5, 6);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `articolo`
--
ALTER TABLE `articolo`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `ordine`
--
ALTER TABLE `ordine`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `tariffa_corriere`
--
ALTER TABLE `tariffa_corriere`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `voce`
--
ALTER TABLE `voce`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_ordine` (`ordine_id`),
  ADD KEY `fk_articolo` (`articolo_id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `articolo`
--
ALTER TABLE `articolo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `ordine`
--
ALTER TABLE `ordine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT per la tabella `tariffa_corriere`
--
ALTER TABLE `tariffa_corriere`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT per la tabella `voce`
--
ALTER TABLE `voce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `voce`
--
ALTER TABLE `voce`
  ADD CONSTRAINT `fk_articolo` FOREIGN KEY (`articolo_id`) REFERENCES `articolo` (`id`),
  ADD CONSTRAINT `fk_ordine` FOREIGN KEY (`ordine_id`) REFERENCES `ordine` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
