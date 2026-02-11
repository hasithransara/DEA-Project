-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2026 at 01:33 PM
-- Server version: 9.2.0
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `event_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `price_general` double DEFAULT NULL,
  `price_gold` double DEFAULT NULL,
  `price_vip` double DEFAULT NULL,
  `start_time` time(6) DEFAULT NULL,
  `id` bigint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `image_file_name` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `venue` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`price_general`, `price_gold`, `price_vip`, `start_time`, `id`, `description`, `category`, `image_file_name`, `title`, `venue`) VALUES
(1000, 3000, 5000, '19:00:00.000000', 1, 'Tropical beach party, neon nightlife, and summer vibes.t for project', 'Concerts', '1768322871342_WhatsApp Image 2026-01-13 at 8.25.24 PM.jpeg', 'PUB London', 'Matara , Feb 7 , 2026'),
(3500, 8000, 12000, '19:00:00.000000', 4, 'A night of unforgettable music and memories.  ', 'Concerts', '1768210369713_WhatsApp Image 2026-01-12 at 2.52.18 PM.jpeg', 'කතාවක්', 'Hangala, One gall Face January 30, 2026'),
(1000, 2000, 4000, '22:25:00.000000', 7, 'sample sports for project', 'Concerts', NULL, 'sample 3', 'port city ,20 Dec 2025 '),
(500, 2000, 5000, '19:30:00.000000', 9, 'Get ready for explosive T20 action! Watch the Asian heavyweights, Pakistan and Sri Lanka, go head-to-head in the 1st T20I. Expect thrilling boundaries, wicked spin, and a high-energy crowd as these two exciting teams fight for dominance. Book your tickets now to support your team live at the stadium.\"', 'Sports', '1768323468651_WhatsApp Image 2026-01-13 at 8.36.19 PM.jpeg', 'PAK VS SL', 'RPS, 18 may, 2026'),
(4000, 10000, 20000, '16:00:00.000000', 10, '  \"Experience the ultimate football rivalry as FC Barcelona takes on Real Madrid in the Supercopa de España Final. Witness world-class talent, intense passion, and the battle for silverware under the lights. Don\'t miss your chance to see these European giants collide in a match that promises history-making moments.\"', 'Sports', '1768323130270_WhatsApp Image 2026-01-13 at 8.35.08 PM.jpeg', 'Spanish Super Cup Final', 'Spain , march 5 , 2026'),
(2500, NULL, 5000, '10:00:00.000000', 11, '\"Be part of cricket\'s oldest and greatest rivalry. Catch the action live as Australia and England battle for the urn in the historic Ashes series. With two titans of the game, Pat Cummins and Ben Stokes, leading their sides, expect a test match filled with grit, determination, and unforgettable atmosphere. Secure your seats for this prestigious showdown.\"', 'Sports', '1768323271749_WhatsApp Image 2026-01-13 at 8.39.20 PM.jpeg', 'Ashes Series', 'England , march 5 , 2026'),
(1000, NULL, NULL, '09:30:00.000000', 12, '\"Join industry experts and academic pioneers at the International Conference on Financial Risk Management and Business Strategies. This event features keynote speeches and deep-dive sessions on navigating complex financial landscapes and mitigating global business risks.\"', 'Educational', '1768323742621_WhatsApp Image 2026-01-13 at 9.11.04 PM.jpeg', 'International Conference on Financial Risk Management and Business Strategies (ICFRMBS)', 'colombo , Feb 9 , 2026'),
(2000, NULL, NULL, '10:00:00.000000', 13, 'Experience a melting pot of culture and commerce at the International Conference on Global Trade, Business, and Entrepreneurship. This is your opportunity to network with international delegates, form cross-border partnerships, and explore the future of global markets.\"', 'Educational', '1768323899835_atsApp Image 2026-01-13 at 9.11.04 PM.jpeg', 'International Conference on Global Trade, Business, and Entrepreneurship(ICGTBE)', 'colombo , Feb 10, 2026'),
(1500, NULL, NULL, '10:00:00.000000', 14, '\"A collaborative workshop environment for educators and curriculum developers. The International Conference on Accounting Education focuses on modernizing teaching methods and building robust curriculums to prepare the next generation of accountants.\"', 'Educational', '1768324011330_WhatsApp Image 2026-01-13 at 9.11.08 PM.jpeg', 'International Conference on Taxation Systems and Policy Frameworks (ICTSPF)', 'colombo , march 5 , 2026');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `price_paid` double DEFAULT NULL,
  `quantity` int NOT NULL,
  `booking_date` datetime(6) DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `guest_email` varchar(255) DEFAULT NULL,
  `guest_name` varchar(255) DEFAULT NULL,
  `ticket_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`price_paid`, `quantity`, `booking_date`, `event_id`, `id`, `guest_email`, `guest_name`, `ticket_type`) VALUES
(333, 1, '2025-12-15 18:03:18.768548', 1, 1, 'hasithransara57@gmail.com', 'R A B Chathuranghi', 'General'),
(200, 1, '2025-12-24 15:29:46.171019', 4, 2, 'hasithransara57@gmail.com', 'R A B Chathuranghi', 'General'),
(5000, 2, '2025-12-26 14:42:52.110687', 1, 3, 'buddi@gmail.com', 'hasith', 'VIP'),
(2000, 1, '2025-12-28 16:54:37.097642', 7, 4, 'hasithransara57@gmail.com', 'R A A Premasiri', 'Gold'),
(2000, 1, '2026-01-12 13:19:56.248528', 9, 5, 'hasithransara57@gmail.com', 'R A B Chathuranghi', 'General'),
(2000, 1, '2026-01-12 13:19:58.826432', 9, 6, 'hasithransara57@gmail.com', 'R A B Chathuranghi', 'General'),
(2000, 1, '2026-01-12 13:20:24.098576', 9, 7, 'hasithransara57@gmail.com', 'R A B Chathuranghi', 'General'),
(2000, 1, '2026-01-12 13:21:52.379278', 9, 8, 'hasithransara57@gmail.com', 'R A A Premasiri', 'General'),
(1000, 1, '2026-01-12 13:23:16.288015', 1, 9, 'hasithransara57@gmail.com', 'R A B Chathuranghi', 'General'),
(2000, 1, '2026-01-12 13:29:31.896410', 10, 10, 'hasithransara57@gmail.com', 'R A A Premasiri', 'VIP'),
(1000, 1, '2026-01-12 14:01:04.439577', 1, 11, 'hasithransara57@gmail.com', 'R A B Chathuranghi', 'General'),
(3500, 10, '2026-01-12 15:07:00.500625', 4, 12, 'hasithransara57@gmail.com', 'R A B Chathuranghi', 'General'),
(2000, 1, '2026-01-13 22:42:32.721848', 13, 13, 'hasithransara57@gmail.com', 'R A A Premasiri', 'General'),
(3500, 1, '2026-01-14 11:22:38.828533', 4, 14, 'hasithransara57@gmail.com', 'isuru', 'General'),
(3500, 1, '2026-01-14 11:22:54.898985', 4, 15, 'hasithransara57@gmail.com', 'isuru', 'General'),
(3500, 1, '2026-01-14 11:23:35.537320', 4, 16, 'hasithransara57@gmail.com', 'isuru', 'General');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `role`) VALUES
(1, 'admin@test.com', '$2a$10$32tgg0shDuC0TlgVLdZrzOQtITlFYygmFJztK0a3JXhcbM2B.punW', 'ROLE_ADMIN'),
(2, 'oya123@gamil.com', '$2a$10$S5vJEulKqtbfr/rwBKF10O5riu3a6MASJfIQFSOX122gEjUYFnVt6', 'ROLE_ADMIN'),
(3, 'hasithransara57@gmail.com', '$2a$10$QFUEl/apqD6a89HWrvbwoeNb/YiEljBLDGVMoFvPMuvaPHGIq8pPm', 'ROLE_USER'),
(4, 'testuser@gmail.com', '$2a$10$SF8tPoTwgnte.OAVxTL6yO2p.toW.v6WxUQ5n54F35peR7X3w0XrC', 'ROLE_USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfytuhjopeamxbt1cpudy92x5n` (`event_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `FKfytuhjopeamxbt1cpudy92x5n` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
