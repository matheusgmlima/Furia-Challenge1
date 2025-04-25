# 🐅 Furia-Challenge1

Chatbot interativo no Telegram que traz informações atualizadas sobre o time **FURIA** no cenário de **CS2 (Counter-Strike 2)**.

---

## 💡 Ideia Inicial

Este bot foi criado com o objetivo de centralizar, em um único canal de comunicação, as informações mais relevantes sobre a equipe FURIA no CS2.

### Comandos disponíveis:
- `/start` – Inicia a interação e mostra as opções disponíveis.
- 🔫 **Últimos Jogos** – Exibe os últimos resultados da FURIA.
- 📅 **Próximos Jogos** – Lista partidas futuras da equipe.
- 👤 **Line Atual** – Mostra a lineup atual da FURIA.
- 🏆 **Melhores Campeonatos** - Mostra os campeonatos onde a FURIA melhor se qualificou.
- 📈 **Mais Jogos** – Expande a lista de partidas anteriores.
- 🔄 **Voltar ao menu** – Reinicia a navegação.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **MySQL**
- **Telegram Bot API (via TelegramBots Java SDK)**
- **Maven** para gerenciamento de dependências

---
## 🧪 Como Rodar o Projeto

### Pré-requisitos:

- Java 21+
- MySQL rodando localmente
- Maven
- Token de um bot do Telegram ([crie o seu aqui](https://t.me/BotFather))

### Setup do banco de dados

1. Crie o banco:

```sql
CREATE DATABASE furia_cs2;
```
2. Crie as tables:
```sql
CREATE TABLE campeonatos_furia (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
data_inicio DATE NOT NULL,
data_fim DATE NOT NULL,
local VARCHAR(100),
colocacao VARCHAR(10),
destaque TEXT
);

-- Tabela de jogos
CREATE TABLE jogos_furia (
id INT AUTO_INCREMENT PRIMARY KEY,
adversario VARCHAR(100) NOT NULL,
data_jogo DATE NOT NULL,
torneio VARCHAR(100) NOT NULL,
resultado VARCHAR(20)
);

-- Tabela de lineup
CREATE TABLE lineup_furia (
id INT AUTO_INCREMENT PRIMARY KEY,
nickname VARCHAR(50) NOT NULL,
nome_completo VARCHAR(100) NOT NULL,
funcao VARCHAR(50),
desde DATE
);
```
3. Insira as informações:
```sql
INSERT INTO jogos_furia (adversario, data_jogo, torneio, resultado) VALUES
('The MongolZ', '2025-04-09', 'PGL Bucharest 2025', '0-2'),
('Virtus.pro', '2025-04-08', 'PGL Bucharest 2025', '0-2'),
('Complexity', '2025-04-07', 'PGL Bucharest 2025', '1-2'),
('Apoegee', '2025-04-06', 'PGL Bucharest 2025', '2-0'),
('M80', '2025-03-22', 'BLAST Open Spring 2025', '2-0'),
('Natus Vincere', '2025-03-20', 'BLAST Open Spring 2025', '0-2'),
('Falcons', '2025-03-10', 'ESL Pro League Season 21', '1-1'),
('MIBR', '2025-03-05', 'ESL Pro League Season 21', '2-1'),
('Team Liquid', '2025-03-02', 'ESL Pro League Season 21', '0-2'),
('MOUZ', '2024-10-12', 'IEM Rio 2024', '0-2'),
('BIG', '2024-12-02', 'Perfect World Shanghai Major', '2-1'),
('Vitality', '2024-12-01', 'Perfect World Shanghai Major', '1-2'),
('SAW', '2024-03-19', 'PGL CS2 Major Copenhagen', '1-2'),
('M80', '2024-10-09', 'BLAST Fall Showdown 2024', '2-1'),
('NAVI', '2024-10-13', 'IEM Rio 2024', '0-2'),
('Heroic', '2024-09-20', 'ESL Pro League Season 20', '2-0'),
('G2 Esports', '2024-09-18', 'ESL Pro League Season 20', '1-2'),
('Astralis', '2024-09-17', 'ESL Pro League Season 20', '0-2'),
('ENCE', '2024-09-15', 'ESL Pro League Season 20', '2-0'),
('Fnatic', '2024-09-13', 'ESL Pro League Season 20', '2-1');

INSERT INTO lineup_furia (nickname, nome_completo, funcao, desde) VALUES
('KSCERATO', 'Kaike Cerato', 'Rifler', '2018-09-15'),
('yuurih', 'Yuri Boian', 'Rifler', '2018-09-15'),
('chelo', 'Marcelo Cespedes', 'Entry Fragger', '2023-01-01'),
('fallen', 'Gabriel Toledo', 'AWPer / IGL', '2023-07-03'),
('arT', 'Andrei Piovezan', 'Support / Entry', '2018-08-01'),
('Sidde', 'Sidnei Macedo', 'Coach', '2024-07-09');

INSERT INTO campeonatos_furia (nome, data_inicio, data_fim, local, colocacao, destaque) VALUES
('Elisa Masters Espoo 2023', '2023-11-29', '2023-12-03', 'Espoo, Finlândia', '1º', 'Vitória sobre Apeks por 3–1 na final; prêmio de US$ 100 mil.'),
('Brasil Game Show 2023', '2023-10-11', '2023-10-15', 'São Paulo, Brasil', '1º', 'Conquista do título no torneio nacional.'),
('Pinnacle Cup V', '2023-09-01', '2023-09-10', 'Online', '2º', 'Chegada à final, garantindo a segunda colocação.'),
('Roobet Cup 2023', '2023-10-25', '2023-11-02', 'Online', '3–4º', 'Vitória sobre Eternal Fire, Heroic e Apeks; eliminação na semifinal para Virtus.pro.'),
('PARI Please 2023', '2023-08-20', '2023-08-27', 'Online', '3–4º', 'Semifinal alcançada; derrota para 9 Pandas.'),
('IEM Rio 2024', '2024-10-07', '2024-10-13', 'Rio de Janeiro, Brasil', '5–6º', 'Eliminação nas semifinais para Mouz; destaque pela presença em casa.'),
('BetBoom Dacha 2023', '2023-12-05', '2023-12-10', 'Dubai, EAU', '5–6º', 'Participação encerrada na fase de grupos.');
