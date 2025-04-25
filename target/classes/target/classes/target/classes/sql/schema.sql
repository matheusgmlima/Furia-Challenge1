CREATE DATABASE furia_cs2;
USE furia_cs2;

CREATE TABLE campeonatos_furia (
                                   id INT AUTO_INCREMENT PRIMARY KEY,
                                   nome VARCHAR(100) NOT NULL,
                                   data_inicio DATE NOT NULL,
                                   data_fim DATE NOT NULL,
                                   local VARCHAR(100),
                                   colocacao VARCHAR(10),
                                   destaque TEXT
);

CREATE TABLE jogos_furia (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             adversario VARCHAR(100) NOT NULL,
                             data_jogo DATE NOT NULL,
                             torneio VARCHAR(100) NOT NULL,
                             resultado VARCHAR(20)
);

CREATE TABLE lineup_furia (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              nickname VARCHAR(50) NOT NULL,
                              nome_completo VARCHAR(100) NOT NULL,
                              funcao VARCHAR(50),
                              desde DATE
);
